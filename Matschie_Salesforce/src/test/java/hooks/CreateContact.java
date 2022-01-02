package hooks;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateContact{

	@Test
	public void createContact() {
		RestAssured.baseURI = "https://sample-9d-dev-ed.my.salesforce.com";

		File data = new File("./data/Contact.json");

		Response res = RestAssured.given().auth().oauth2(
				"00D5j000004mDIU!ARoAQL.kTMsTQ5aug7QwvVJP__hwWGHvqec8xRCnFEx116x78Ztc_XJ34pHAW0p1sSSDNkh1Ve_z8Gxwx9T_y_cGCsAgX6Wr")
				.contentType(ContentType.JSON).log().all().body(data).post("services/data/v20.0/sobjects/Contact");

		System.out.println(res.prettyPrint());

	}

}