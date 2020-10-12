package testscripts;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC004_DELETE {
@Test
public void test()
{
RestAssured.baseURI="https://reqres.in";
RequestSpecification req=RestAssured.given();
Response res=req.request(Method.DELETE,"/api/users/2");
System.out.println(res.asString());
Assert.assertEquals(res.getStatusCode(), 204);
}


}
