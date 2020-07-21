package testscripts;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_RegisterUnsuccess {
	@SuppressWarnings("unchecked")
	@Test
	public void test()
	{
	RestAssured.baseURI="https://reqres.in";
	RequestSpecification req= RestAssured.given();
	JSONObject reqparam= new JSONObject();
reqparam.put("email","sydney@fife");
req.header("Content-Type","application/json");
req.body(reqparam.toJSONString());
Response res= req.request(Method.POST,"/api/register");
System.out.println(res.asString());
Assert.assertEquals(res.getStatusCode(),400);
System.out.println(res.getBody().jsonPath().get("error"));

	}

}
