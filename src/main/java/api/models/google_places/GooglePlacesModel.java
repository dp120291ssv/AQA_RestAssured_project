package api.models.google_places;

import api.utils.NetworkCore;
import io.restassured.http.Method;
import lombok.Builder;
import lombok.Getter;
import java.util.HashMap;
import static constants.Constants.Actions.GOOGLE_PLACES_SEARCH_ENDPOINT;
import static constants.Constants.Path.GOOGLE_PLACES_PATH;
import static constants.Constants.Server.GOOGLE_PLACES_URL;

public class GooglePlacesModel extends NetworkCore {

	@Builder
	@Getter
	public static class RequestModel{
		String key;
		String input;
		String inputtype;
	}

	public GooglePlacesModel search(RequestModel model, Method method, int statusCode){
		HashMap requestBody = new HashMap();
		requestBody.put("key", model.getKey());
		requestBody.put("input", model.getInput());
		requestBody.put("inputtype", model.getInputtype());
		requestSpecBuilder.setBaseUri(GOOGLE_PLACES_URL + GOOGLE_PLACES_PATH + GOOGLE_PLACES_SEARCH_ENDPOINT)
						  .addQueryParams(requestBody);
		sendRequestAndGetResponse(method, statusCode);
		return this;
	}
}
