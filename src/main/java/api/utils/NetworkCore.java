package api.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import static io.restassured.RestAssured.given;

public class NetworkCore {

	protected Response response;
	protected RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
	protected JSONObject responseBody;

	protected void sendRequestAndGetResponse (Method method, int statusCode) {
		response = given()
			.spec(requestSpecBuilder.build()).log().uri().log().parameters()
			.when().request(method);
		response.then().log().body()
			.assertThat().statusCode(statusCode);
		try {
			responseBody = new JSONObject(response.getBody().asString());
		} catch (Exception e){
			Assert.fail("Can't get response body");
		}
	}
}
