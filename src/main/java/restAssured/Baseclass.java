package restAssured;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Baseclass {
	public static JSONObject json;
	public static RequestSpecification httpRequest;
		public static void initialization()
		{
				RestAssured.baseURI="https://reqres.in/api/users/2";
				httpRequest=RestAssured.given();
				httpRequest.header("Content-Type","application/json");
				json = new JSONObject();	
		}	
	
	
	
}
