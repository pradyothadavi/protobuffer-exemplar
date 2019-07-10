package in.adavi.pradyot.sizecompare;

import in.adavi.pradyot.sizecompare.model.Name;
import in.adavi.pradyot.sizecompare.model.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author Pradyot H Adavi
 */
public class SizeCompare {
	
	public static void main( String[] args ){
		
		try {
			
			model.proto.Name name =
					model.proto.Name.newBuilder().setFirstName("FirstName").setMiddleName("MiddleName").setLastName("LastName").build();
			
			model.proto.Person person = model.proto.Person.newBuilder().setName(name).setAge(30).build();
			
			FileOutputStream fos = new FileOutputStream("protobuff");
			person.writeTo(fos);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			
			Name name = new Name();
			name.setFirstName("FirstName");
			name.setMiddleName("MiddleName");
			name.setLastName("LastName");
			
			Person person = new Person();
			person.setName(name);
			person.setAge(30);
			
			FileOutputStream fileOut = new FileOutputStream("objSer");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(person);
			objectOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File protobuff = new File("protobuff");
		System.out.println("Protobuff Size : "+protobuff.length());
		
		File objSer = new File("objSer");
		System.out.println("Java Default Size : "+objSer.length());
		
		System.out.println("Ratio : "+(objSer.length()/protobuff.length()));
	}
}
