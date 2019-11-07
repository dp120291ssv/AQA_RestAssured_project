import config.TestConfig;
import org.testng.annotations.Test;
import static constants.Constants.Actions.SWAPI_GET_PEOPLE;
import static constants.Constants.Path.SWAPI_PATH;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class FirstTest extends TestConfig{

	@Test
	public void myFirstTest() {
		given().
			log().uri().
//			ifValidationFails().
		when().get(SWAPI_GET_PEOPLE + "1").
		then().
			log().body().
			statusCode(200);
	}

	/**
	 *
	 * Hamcrest помогает писать тесты.
	 * Не надо путать его с полнофункциональными фреймворками для тестирования, такими как JUnit.
	 * Hamcrest – это всего лишь библиотека matcher-ов, которая используется в паре с JUnit или другим
	 * аналогичным фреймворком для тестирования.

	 Название Hamcrest является анаграммой «matcher». Matcher – это такое выражение,
	 тестирующее на совпадение с определенным условием.
	 * */

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
}
