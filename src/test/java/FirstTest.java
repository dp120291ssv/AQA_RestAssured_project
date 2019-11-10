import config.TestConfig;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.Map;
import static constants.Constants.Actions.SWAPI_GET_PEOPLE;
import static constants.Constants.Path.SWAPI_PATH;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;

public class FirstTest extends TestConfig{
	@Test
	public void myFirstTest() {
		given().
			log().
			ifValidationFails().log().all().
		when().get(SWAPI_GET_PEOPLE + "1").
		then().
			log().body().
			statusCode(200);
	}

	@Test
	public void getSwapiAllResourcesAssertionExample(){
		given().spec(requestSpecificationSwapi).log().uri().
		when().get(SWAPI_PATH).
		then().body("people", equalTo("https://swapi.co/api/people/")).log().body();
	}

	@Test
	public void getSwapiPeopleResourcesAssertionExample(){
		given().spec(requestSpecificationSwapi).log().uri().
			when().get(SWAPI_PATH + SWAPI_GET_PEOPLE).
			then()
				.body("count", equalTo(87))
				.body("results.name[0]", equalTo("Luke Skywalker"))
				.log().body();
	}

	@Test
	public void getAllDataFromSwapi(){
		Response response =
			given().spec(requestSpecificationSwapi).log().uri().
				when().get(SWAPI_PATH).
				then().extract().response();
		String jsonResponseAsString = response.asString();
		System.out.println("jsonResponseAsString-->" + jsonResponseAsString);
	}

	@Test
	public void getCookieFromSwapi(){
		Response response =
			given().spec(requestSpecificationSwapi).log().uri().
				when().get(SWAPI_PATH).
				then().extract().response();

		Map<String, String> allCookie = response.getCookies();
		System.out.println("cookie--> " + allCookie);

		String someCookie = response.getCookie("__cfduid");
		System.out.println("Cookie __cfduid --> " + someCookie);
	}

	@Test
	public void getHeadersFromSwapi(){
		Response response =
			given().spec(requestSpecificationSwapi).log().uri().
			when().get(SWAPI_PATH).
			then().extract().response();

		Headers headers = response.getHeaders();
		System.out.println("headers--> " + headers);

		String contetnType = response.getHeader("Content-Type");
		System.out.println("Content-Type--> " + contetnType);
	}

	@Test
	public void validateXmlSchema(){
		given().log().uri()
		.when().get("https://maps.googleapis.com/maps/api/place/findplacefromtext/xml?key=apiKey&input=New York&inputtype=textquery&fields=formatted_address,geometry,icon,name,permanently_closed,photos,place_id,plus_code,types&language=ru")
		.then().body(matchesXsdInClasspath("googlePlacesXmlExample.xsd")).log().body();
	}

	@Test
	public void validateJsonSchema(){
		given().log().uri()
			.when().get("https://maps.googleapis.com/maps/api/place/findplacefromtext/json?key=apiKey&input=New York&inputtype=textquery&fields=formatted_address,geometry,icon,name,permanently_closed,photos,place_id,plus_code,types&language=ru")
			.then().body(matchesJsonSchemaInClasspath("googlePlacesJsonExample.json")).log().body();
	}
}
