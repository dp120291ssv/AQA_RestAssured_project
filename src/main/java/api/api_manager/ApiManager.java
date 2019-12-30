package api.api_manager;

import api.models.google_places.GooglePlacesModel;
import api.utils.NetworkCore;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class ApiManager {

	@Getter
	@Setter
	private GooglePlacesModel googlePlacesModel = new GooglePlacesModel();
}
