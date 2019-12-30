package tests.google_places_tests.positive;

import api.models.google_places.GooglePlacesModel;
import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.http.Method.GET;
import static io.restassured.http.Method.POST;

public class SearchTestPositive extends BaseTest {

	@Test(description = "поиск по тексту", dataProvider = "searchText")
	public void searhPlaceForText(String key, String input, String inputType){
		GooglePlacesModel.RequestModel model = GooglePlacesModel.RequestModel.builder()
			.key(key)
			.input(input)
			.inputtype(inputType)
			.build();
		apiManager.getGooglePlacesModel().search(model, GET,200);
	}

	@DataProvider
	public Object[] [] searchText(){
		return new Object[][]{
			{"AIzaSyAo69OiQnFMTJhEFXH7V7QdMJ3DGKXdVUI", "Мамой клянусь", "textquery"}
		};
	}
}
