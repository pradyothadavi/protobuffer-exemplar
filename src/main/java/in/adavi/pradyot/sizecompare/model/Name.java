package in.adavi.pradyot.sizecompare.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Pradyot H Adavi
 */
@Data
public class Name implements Serializable {
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
}
