package mypackage.jackson.json;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main1_Driver {

	public static void main(String[] args) {
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);
			System.out.println(student);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
