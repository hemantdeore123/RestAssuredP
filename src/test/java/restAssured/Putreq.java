package restAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Putreq extends Baseclass {
	private Response resp;
	@BeforeClass
	public void setUp() {
		Baseclass.initialization();
		 json.put("first_name","Swapnil" );
		 json.put("last_name", "kamble");
		 httpRequest.body(json.toString());
		 resp =httpRequest.put();
		}
	@Test(priority=1)
	public void validateStatusCodeput() {
	Assert.assertEquals(resp.getStatusCode(), 200);
	}
	@Test(priority=1)
	public void validateStatusLineput() {
	Assert.assertEquals(resp.getStatusLine(), "HTTP/1.1 200 OK");
	}
	@Test(priority=3)
	public void validateResponseBodyPut() {
	Assert.assertEquals(resp.getBody().asString().contains("Swapnil"), true);
	Assert.assertEquals(resp.getBody().asString().contains("kamble"), true);
	//Assert.assertEquals(resp.getBody().asString().contains("25"), true);
	
	}
}
