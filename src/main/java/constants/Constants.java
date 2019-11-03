package constants;

import static constants.Constants.Path.SWAPI_PATH;
import static constants.Constants.Server.JSON_PLACEHOLDER_URL;
import static constants.Constants.Server.REQUESTBIN_URL;
import static constants.Constants.Server.SWAPI_URL;

public class Constants {

	public static class RunVariables {
		public static String server = JSON_PLACEHOLDER_URL;
		public static String path = "";

	}

	public static class Server {
		public static final String SWAPI_URL = "https://swapi.co/";
		public static final String GOOGLE_PLACES_URL = "https://maps.googleapis.com/";
		public static final String JSON_PLACEHOLDER_URL = "https://jsonplaceholder.typicode.com/";
		public static String REQUESTBIN_URL = "https://ene53trtecoc.x.pipedream.net";

	}

	public static class Path {
		public static final String SWAPI_PATH = "api/";
		public static final String GOOGLE_PLACES_PATH = "maps/api/place/";
	}

	public static class Actions {
		//swapi
		public static final String SWAPI_GET_PEOPLE = "people/";

		//jsonplaceholder
		public static final String JSON_PLACEHOLDER_GET = "comments/";
		public static final String JSON_PLACEHOLDER_POST = "posts/";
		public static final String JSON_PLACEHOLDER_PUT = "posts/1";
		public static final String JSON_PLACEHOLDER_DELETE = "posts/1";
		public static String JSONPLACEHOLDER_POST = "posts/";
	}
}
