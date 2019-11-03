package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import static constants.Constants.RunVariables.path;
import static constants.Constants.RunVariables.server;
import static constants.Constants.Server.REQUSTBIN_URL;

public class TestConfig {

	protected RequestSpecification requestSpecificationXml = new RequestSpecBuilder()
		.addHeader("Content-Type", "application/xml")
		.addCookie("testCookieXML")
		.setBaseUri(REQUSTBIN_URL)
		.build();

	@BeforeClass
	public static void setUp() {
		RestAssured.baseURI = server;
		RestAssured.basePath = path;
		RequestSpecification requestSpecificationJson = new RequestSpecBuilder()
			.addHeader("Content-Type", "application/json")
			.addCookie("testCookieJSON")
			.build();
		RestAssured.requestSpecification = requestSpecificationJson;	}
}
