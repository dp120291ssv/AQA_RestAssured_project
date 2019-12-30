package api.utils;

import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {


	@Test
	public void readeFromProperty() {

		try (InputStream input = getClass().getClassLoader().getResourceAsStream("userData.properties")) {

			Properties prop = new Properties();

			if (input == null) {
				System.out.println("Sorry, unable to find config.properties");
				return;
			}

			//load a properties file from class path, inside static method
			prop.load(input);

			//get the property value and print it out
			System.out.println(prop.getProperty("SERGEI"));


		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
