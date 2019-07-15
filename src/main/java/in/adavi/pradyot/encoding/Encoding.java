package in.adavi.pradyot.encoding;

import com.google.protobuf.TextFormat;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Pradyot H Adavi
 */
public class Encoding {
	
	public static void main(String args[]){
		
		/**
		 * 08 96 01 ( 0000 1000 1001 0110 0000 0001 )
		 *
		 * Step 1:
		 * 0 - Ignore MSB
		 * 000 1000
		 *
		 * Last 3 bits : 000 ---> Wire Type is 0
		 *  msb               lsb
		 *  0  0  0  1  0  0  0
		 *
		 *  0  0  0  0  1  0  0     0 (dropped bit)
		 *  0  0  0  0  0  1  0     0 (dropped bit)
		 *  0  0  0  0  0  0  1     0 (dropped bit)
		 *
		 *  Step 2:
		 *  1001 0110   msb is 1, then we have not yet reached the end of the message;
		 *  0000 0001   msb is 0, hence we have reached the end of the message.
		 *
		 *  0  0  1  0  1  1  0 -- 1st byte
		 *  0  0  0  0  0  0  1 -- 2nd byte
		 *
		 *  8192 4096 2048  1024  0512  0256  0128  0064  0032  0016  0008  0004  0002  0001
		 *    0    0    0     0     0     0     1     0     0     1     0     1     1     0
		 *
		 *  128 + 16 + 4 + 2 = 150
		 */
		model.proto.Test1 test1 = model.proto.Test1.newBuilder().setA(150).build();
		
		model.proto.Test2 test2 = model.proto.Test2.newBuilder().setB("testing").build();
		
		model.proto.Test3 test3 = model.proto.Test3.newBuilder().setC(test1).build();
		
		model.proto.Test4 test4 = model.proto.Test4.newBuilder().setD(-1).build();
		
		model.proto.Test5 test5 = model.proto.Test5.newBuilder().setE(-1).build();
		
		try {
			FileOutputStream fosTest1 = new FileOutputStream("test1");
			test1.writeTo(fosTest1);
			
			FileOutputStream fosTest2 = new FileOutputStream("test2");
			test2.writeTo(fosTest2);
			
			FileOutputStream fosTest3 = new FileOutputStream("test3");
			test3.writeTo(fosTest3);
			
			FileOutputStream fosTest4 = new FileOutputStream("test4");
			test4.writeTo(fosTest4);
			
			FileOutputStream fosTest5 = new FileOutputStream("test5");
			test5.writeTo(fosTest5);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(TextFormat.printToString(test1));
		System.out.println(TextFormat.printToString(test2));
		System.out.println(TextFormat.printToString(test3));
		System.out.println(TextFormat.printToString(test4));
		System.out.println(TextFormat.printToString(test5));
	}
}
