#!/usr/bin/env bash
protoc -I=proto --java_out=. proto/name.proto
protoc -I=proto --java_out=. proto/person.proto
