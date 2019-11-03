package config;


import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import static constants.Constants.RunVariables.path;
import static constants.Constants.RunVariables.server;

public class TestConfig {

	@BeforeClass
	public static void setUp() {
		RestAssured.baseURI = server;
		RestAssured.basePath = path;
	}
}
