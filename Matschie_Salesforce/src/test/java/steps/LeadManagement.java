package steps;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.Map;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;

public class LeadManagement extends baseAPI {

	@And("Lead details are added in body {string}")
	public void add_Lead_details(String str) {

		File file = new File(str);
		response = given().auth().oauth2(
				"00D5j000004mDIU!ARoAQL.kTMsTQ5aug7QwvVJP__hwWGHvqec8xRCnFEx116x78Ztc_XJ34pHAW0p1sSSDNkh1Ve_z8Gxwx9T_y_cGCsAgX6Wr")
				.contentType(ContentType.JSON).body(file).log().all().when().post("Lead");

	}

	@Given("get lead id to {string}")
	public void getId(String str) {
		System.out.println("\nLead ID "+str+": "+ id);
	}

	@When("Lead details are updated in body {string}")
	public void update_Lead_details(String str) {

		File file = new File(str);
		response = given().auth().oauth2(
				"00D5j000004mDIU!ARoAQL.kTMsTQ5aug7QwvVJP__hwWGHvqec8xRCnFEx116x78Ztc_XJ34pHAW0p1sSSDNkh1Ve_z8Gxwx9T_y_cGCsAgX6Wr")
				.contentType(ContentType.JSON).body(file).log().all().when().patch("Lead/" + id);

	}

	@When("Lead details are deleted")
	public void delete_Lead_details() {

		response = given().auth().oauth2(
				"00D5j000004mDIU!ARoAQL.kTMsTQ5aug7QwvVJP__hwWGHvqec8xRCnFEx116x78Ztc_XJ34pHAW0p1sSSDNkh1Ve_z8Gxwx9T_y_cGCsAgX6Wr")
				.contentType(ContentType.JSON).log().all().when().delete("Lead/" + id);
	}

	@When("Lead details are not loaded")
	public void deleted_Lead_details() {
		response = given().auth().oauth2(
				"00D5j000004mDIU!ARoAQL.kTMsTQ5aug7QwvVJP__hwWGHvqec8xRCnFEx116x78Ztc_XJ34pHAW0p1sSSDNkh1Ve_z8Gxwx9T_y_cGCsAgX6Wr")
				.contentType(ContentType.JSON).log().all().when().get("Lead/" + id);
		System.out.println(response.prettyPrint());
	}

}