package constants;

import api.utils.Utils;

public class Constants {

	public static class Server {
		public static final String GOOGLE_PLACES_URL = "https://maps.googleapis.com/";
	}

	public static class Path {
		public static final String GOOGLE_PLACES_PATH = "maps/api/place/";
	}

	public static class Actions {
		//GOOGLE_PLACES
		public static final String GOOGLE_PLACES_SEARCH_ENDPOINT = "findplacefromtext/json";
	}

	public final static String API_TOKEN_FOR_GOOGLE = Utils.getValue("TOKEN");
}
