package services;

import static org.hamcrest.Matchers.containsString;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ContactTests extends BaseRequest{
	
	
	@Test
	public void creatContact(){
		
		File file = new File("./data/Contact.json");
		request
		.auth().oauth2("00D5j000004mDIU!ARoAQL.kTMsTQ5aug7QwvVJP__hwWGHvqec8xRCnFEx116x78Ztc_XJ34pHAW0p1sSSDNkh1Ve_z8Gxwx9T_y_cGCsAgX6Wr")
			.contentType(ContentType.JSON)
			.body(file)
			.post("Contact")
			.then()
			.log().all()
			.assertThat()
			.statusCode(201)
			.body(containsString("id"),containsString("success"));		
	}
}