package restAssured;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.Method;
import io.restassured.response.Response;

public class Patchreq extends Baseclass {
	private Response resp;
	@BeforeClass
	public void setUp() {
		Baseclass.initialization();
		json.put("id", "27");
		 httpRequest.body(json.toString());
		 resp =httpRequest.patch();
		}
	
	
	@Test(priority=1)
	public void validateStatusCodePatch() {
	Assert.assertEquals(resp.getStatusCode(), 200);
	}
	@Test(priority=2)
	public void validateStatusLinePatch() {
	Assert.assertEquals(resp.getStatusLine(), "HTTP/1.1 200 OK");
	}
	@Test(priority=3)
	public void validateResponseBodyPatch() {
	Assert.assertEquals(resp.getBody().asString().contains("27"), true); 
	}
	@Test(priority=4)
	public void getReqeustForUpdateduser() {
	resp =httpRequest.request(Method.GET);
	}
	@Test(priority=5)
	public void validateResponseBodyUpdatedUser() {
	//Assert.assertEquals(resp.getBody().asString().contains("27"), true);
		System.out.println(resp.getBody().asString());
	}
}
