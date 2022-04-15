package restAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeletReq extends Baseclass {
	Response resp;
	@ BeforeClass
	public void setUp() {
		Baseclass.initialization();
		httpRequest=RestAssured.given();
		 resp =httpRequest.delete();
		}
	@Test(priority=1)
	public void validateStatusCodeDelete() {
	Assert.assertEquals(resp.getStatusCode(), 204);
	}
	@Test(priority=2)
	public void validateStatusLineDelete() {
	Assert.assertEquals(resp.getStatusLine(), "HTTP/1.1 204 No Content");	
	}
}
