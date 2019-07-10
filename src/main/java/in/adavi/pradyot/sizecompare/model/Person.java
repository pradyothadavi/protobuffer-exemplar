package in.adavi.pradyot.sizecompare.model;

import in.adavi.pradyot.sizecompare.model.Name;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Pradyot H Adavi
 */
@Data
public class Person implements Serializable {
	
	private Name name;
	
	private int age;
}
