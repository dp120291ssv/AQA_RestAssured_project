package config;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import static constants.Constants.RunVariables.path;
import static constants.Constants.RunVariables.server;
import static constants.Constants.Server.REQUESTBIN_URL;

public class TestConfig {

	protected RequestSpecification requestSpecificationForUdemyCourse = new RequestSpecBuilder()
		.addHeader("Content-Type", "application/json")
		.addCookie("testCookie")
		.setBaseUri(REQUESTBIN_URL)
		.build();


	@BeforeClass
	public static void setUp() {
		RestAssured.baseURI = server;
		RestAssured.basePath = path;

//		RestAssured.requestSpecification = requestSpecificationForUdemyCourse;
	}
}
