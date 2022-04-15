package restAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class GetReq extends Baseclass{
	private Response resp;
	@BeforeClass
	public void setUp() {
	 Baseclass.initialization();
		resp =httpRequest.request(Method.GET);
		}
		@Test(priority=1)
		public void validateStatusCode() {
		int actualStatusCode=resp.getStatusCode();
		Assert.assertEquals(actualStatusCode, 200);
		}
		@Test(priority=2)
		public void validateStatusLine() {
		String actualStatusLine=resp.getStatusLine();
		Assert.assertEquals(actualStatusLine,"HTTP/1.1 200 OK");
		}
		@Test(priority=3)
		public void validateResponseBody() {
		String actulBody=resp.getBody().asString();
		System.out.println(actulBody);
		}
}
