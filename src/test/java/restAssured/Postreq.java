package restAssured;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class Postreq extends Baseclass{

	Response resp;
	 String actualId;
		@BeforeClass
		public void setUp() {
			Baseclass.initialization();
			 json.put("id", "25");
			 json.put("first_name","Hemant" );
			 json.put("last_name", "Deore");
			 httpRequest.body(json.toString());
			 resp =httpRequest.post();
			}
		@Test(priority=1)
		public void validateStatusCode() {
		int a =resp.getStatusCode();
		System.out.println(a);
		Assert.assertEquals(a, 201);
		
	}
		@Test(priority=2)
		public void validateStatusLine() {
		String b =resp.getStatusLine();
		Assert.assertEquals(b, "HTTP/1.1 201 Created");
		}
		@Test(priority=3)
		public void validateID() {
		String c =resp.getBody().asString();
		boolean d =c.contains("25");
		Assert.assertEquals(d, true);
		}
		@Test(priority=4)
		public void validateFirstName() {
		String c =resp.getBody().asString();
		boolean d =c.contains("Hemant");
		Assert.assertEquals(d, true);
		}
		@Test(priority=5)
		public void validateLast_Name() {
		String c =resp.getBody().asString();
		boolean d =c.contains("Deore");
		Assert.assertEquals(d, true);
		}
		@Test(priority=6)
		public void validateContentTypeHeader() {
		String head=resp.header("Content-Type");
		Assert.assertEquals(head, "application/json; charset=utf-8");
		}
		@Test(priority=7)
		public void validateAllHeaders()
		{
		Headers allheaders=resp.headers();
		for(Header abc:allheaders)
		{
		System.out.println(abc.getName()+ " "+abc.getValue());
		}
		}
		@Test(priority=8)
		public void validateBody(){
		String xyz = resp.getBody().asString();
		System.out.println(xyz);
		actualId=resp.jsonPath().getString("id");
		System.out.println("ID number is "+actualId);
		}
		@Test(priority=9)
		public void validategetRequest() {
		
		Response resp1 =httpRequest.request(Method.GET,actualId);
		System.out.println(resp1.getBody().asString());
		}
	
}
