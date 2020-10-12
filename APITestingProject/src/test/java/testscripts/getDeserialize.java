package testscripts;

import io.restassured.RestAssured;

public class getDeserialize {
	public static void main(String args[])
	{
		NewPOJO pojo= RestAssured.get("https://reqres.in/api/users?page=2").as(NewPOJO.class);
		System.out.println(pojo);
	System.out.println(pojo.getPage());
	System.out.println(pojo.getData().get(1).getFirst_name());
	}
}
