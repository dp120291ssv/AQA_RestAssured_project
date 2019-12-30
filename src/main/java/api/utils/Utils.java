package api.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utils {


	public static String getValue(String value) {
		Properties props = new Properties();
		try {
			FileInputStream stream = new FileInputStream("src/test/resources/userData.properties");
			props.load(stream);
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Error!");
			e.printStackTrace();
		}

		String data = props.getProperty(value);
		try {
			data = new String(data.getBytes("ISO8859-1"), "UTF-8");
		} catch (Exception e) {
			System.out.println("NOT FOUND PROPERTY: "+value+" in file userData.properties");
			e.printStackTrace();
		}
		return data;
	}
}
