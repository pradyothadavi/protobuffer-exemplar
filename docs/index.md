## Introduction

Protocol buffers – a language-neutral, platform-neutral, extensible
way of serializing structured data for use in communications protocols,
data storage, and more.

Advantages
- are simpler
- are 3 to 10 times smaller
- are 20 to 100 times faster
- are less ambiguous
- generate data access classes that are easier to use programmatically

## Language Guide ( Proto3 )

### Defining A Message Type 
The first line of the file specifies that you're using proto3 syntax: if
you don't do this the protocol buffer compiler will assume you are using
proto2. This must be the first non-empty, non-comment line of the file.

```
syntax = “proto3”

message <name> {

}
```

### Assigning Field Numbers

1 - 15 : Occupy 1 byte. ( This should be reserved for frequently occurring element. )

16 - 2047 : 2 bytes 

19000 - 19999 : Reserved

229-1 ( 536,870,911 )  is the largest number

### Specifying Field Rules 
singular repeated

Multiple message types can be defined in a single .proto file. This is useful if you are defining multiple related messages.

To add comments to your .proto files, use C/C++-style // and /* ... */ syntax.

### Reserved Fields 
If you update a message type by entirely removing a
field, or commenting it out, future users can reuse the field number
when making their own updates to the type. This can cause severe issues
if they later load old versions of the same .proto, including data
corruption, privacy bugs, and so on. One way to make sure this doesn't
happen is to specify that the field numbers (and/or names, which can
also cause issues for JSON serialization) of your deleted fields are
reserved. The protocol buffer compiler will complain if any future users
try to use these field identifiers.

```
 enum Foo { 
    reserved 2, 15, 9 to 11, 40 to max; 
    reserved "FOO","BAR"; 
 }
```

### Default Values 

When a message is parsed, if the encoded message does
not contain a particular singular element, the corresponding field in
the parsed object is set to the default value for that field. These
defaults are type-specific:

- For strings, the default value is the empty string.
- For bytes, the default value is empty bytes.
- For bools, the default value is false.
- For numeric types, the default value is zero.
- For enums, the default value is the first defined enum value, which must be 0.
- For message fields, the field is not set. Its exact value is
  language-dependent. See the generated code guide for details. T- he
  default value for repeated fields is empty (generally an empty list in
  the appropriate language).

Note that for scalar message fields, once a message is parsed there's no
way of telling whether a field was explicitly set to the default value
(for example whether a boolean was set to false) or just not set at all:
you should bear this in mind when defining your message types. For
example, don't have a boolean that switches on some behaviour when set
to false if you don't want that behaviour to also happen by default.
Also note that if a scalar message field is set to its default, the
value will not be serialized on the wire.

### Enumerations 
Every enum definition must contain a constant that maps
to zero as its first element. This is because:

There must be a zero value, so that we can use 0 as a numeric default value.
The zero value needs to be the first element, for compatibility with the proto2 semantics where the first enum value is always the default.

option allow_alias = true;

Enumerator constants must be in the range of a 32-bit integer. Since enum values use varint encoding on the wire, negative values are inefficient and thus not recommended.

You can also use an enum type declared in one message as the type of a field in a different message, using the syntax MessageType.EnumType.

During deserialization, unrecognized enum values will be preserved in the message, though how this is represented when the message is deserialized is language-dependent. In languages that support open enum types with values outside the range of specified symbols, such as C++ and Go, the unknown enum value is simply stored as its underlying integer representation. In languages with closed enum types such as Java, a case in the enum is used to represent an unrecognized value, and the underlying integer can be accessed with special accessors. In either case, if the message is serialized the unrecognized value will still be serialized with the message.

### Importing Definitions
 
new.proto
// new.proto
// All definitions are moved here

old.proto
// old.proto
// This is the proto that all clients are importing.
import public "new.proto";
import "other.proto";

client.proto
// client.proto
import "old.proto";
// You use definitions from old.proto and new.proto, but not other.proto

The protocol compiler searches for imported files in a set of directories specified on the protocol compiler command line using the -I/--proto_path flag. If no flag was given, it looks in the directory in which the compiler was invoked. In general you should set the --proto_path flag to the root of your project and use fully qualified names for all imports.

### Nested Types

If you want to reuse this message type outside its parent message type, you refer to it as Parent.Type

### Updating A Message Type

Don't change the field numbers for any existing fields.
Fields can be removed, as long as the field number is not used again in your updated message type. You may want to rename the field instead, perhaps adding the prefix "OBSOLETE_", or make the field number reserved, so that future users of your .proto can't accidentally reuse the number.
Compatible Data Type
int32, uint32, int64, uint64, and bool
sint32 and sint64
string and bytes are compatible as long as the bytes are valid UTF-8.
fixed32 and sfixed32
fixed64 and sfixed64

### Unknown Fields 

Unknown fields are well-formed protocol buffer
serialized data representing fields that the parser does not recognize.
For example, when an old binary parses data sent by a new binary with
new fields, those new fields become unknown fields in the old binary.

### Any

The Any message type lets you use messages as embedded types without having their .proto definition. An Any contains an arbitrary serialized message as bytes, along with a URL that acts as a globally unique identifier for and resolves to that message's type. To use the Any type, you need to import google/protobuf/any.proto

The default type URL for a given message type is type.googleapis.com/packagename.messagename

### Oneof

If you have a message with many fields and where at most one field will be set at the same time, you can enforce this behavior and save memory by using the oneof feature.

You can check which value in a oneof is set (if any) using a special case() or WhichOneof() method.

To define a oneof in your .proto you use the oneof keyword followed by your oneof name. You then add your oneof fields to the oneof definition. 

Eg:
message SampleMessage {
  oneof test_oneof {
    string name = 4;
    SubMessage sub_message = 9;
  }
}

Setting a oneof field will automatically clear all other members of the oneof. So if you set several oneof fields, only the last field you set will still have a value.
If the parser encounters multiple members of the same oneof on the wire, only the last member seen is used in the parsed message.
A oneof cannot be repeated
Be careful when adding or removing oneof fields. If checking the value of a oneof returns None/NOT_SET, it could mean that the oneof has not been set or it has been set to a field in a different version of the oneof. There is no way to tell the difference, since there's no way to know if an unknown field on the wire is a member of the oneof.

### Maps

If you want to create an associative map as part of your data definition, protocol buffers provides a handy shortcut syntax:

map<key_type, value_type> map_field = N;

where the key_type can be any integral or string type (so, any scalar type except for floating point types and bytes). Note that enum is not a valid key_type. The value_type can be any type except another map.

Map fields cannot be repeated
Wire format ordering and map iteration ordering of map values is undefined
When parsing from the wire or when merging, if there are duplicate map keys the last key seen is used.
If you provide a key but no value for a map field, the behavior when the field is serialized is language-dependent

### Packages

You can add an optional package specifier to a .proto file to prevent name clashes between protocol message types.

Type name resolution in the protocol buffer language works like C++: first the innermost scope is searched, then the next-innermost, and so on, with each package considered to be "inner" to its parent package. A leading '.' (for example, .foo.bar.Baz) means to start from the outermost scope instead.

### Options

https://github.com/protocolbuffers/protobuf/blob/master/src/google/protobuf/descriptor.proto

option java_package = "com.example.foo";
option java_multiple_files = true;
option java_outer_classname = "Ponycopter";
optimize_for (file option): Can be set to SPEED, CODE_SIZE, or LITE_RUNTIME.
option optimize_for = CODE_SIZE;

