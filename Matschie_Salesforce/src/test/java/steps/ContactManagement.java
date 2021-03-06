package steps;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.Map;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;

public class ContactManagement extends baseAPI {

	@Given("enable logs")
	public void setUp() {
		request = given().log().all();
	}

	@And("contact details are added in body {string}")
	public void add_contact_details(String str) {

		File file = new File(str);
		response = given().auth().oauth2(
				"00D5j000004mDIU!ARoAQL.kTMsTQ5aug7QwvVJP__hwWGHvqec8xRCnFEx116x78Ztc_XJ34pHAW0p1sSSDNkh1Ve_z8Gxwx9T_y_cGCsAgX6Wr")
				.contentType(ContentType.JSON).body(file).log().all().when().post("Contact");

	}

	@Then("the status code is (\\d+)$") // ->only Digit
	public void verify_status_code(int statusCode) {
		json = response.then().statusCode(statusCode);
	}

	@And("response includes the id")
	public void response_equals() {
		id = json.extract().jsonPath().getString("id");
		System.out.println("\nCreated ID: " + id);
		System.out.println(json.extract().asString());

	}

	@Given("get contact id to {string}")
	public void getId(String str) {
		System.out.println("\nContact ID " + str + ": " + id);
	}

	@When("contact details are updated in body {string}")
	public void update_contact_details(String str) {

		File file = new File(str);
		response = given().auth().oauth2(
				"00D5j000004mDIU!ARoAQL.kTMsTQ5aug7QwvVJP__hwWGHvqec8xRCnFEx116x78Ztc_XJ34pHAW0p1sSSDNkh1Ve_z8Gxwx9T_y_cGCsAgX6Wr")
				.contentType(ContentType.JSON).body(file).log().all().when().patch("Contact/" + id);

	}

	@When("contact details are deleted")
	public void delete_contact_details() {

		response = given().auth().oauth2(
				"00D5j000004mDIU!ARoAQL.kTMsTQ5aug7QwvVJP__hwWGHvqec8xRCnFEx116x78Ztc_XJ34pHAW0p1sSSDNkh1Ve_z8Gxwx9T_y_cGCsAgX6Wr")
				.contentType(ContentType.JSON).log().all().when().delete("Contact/" + id);
	}

	@When("contact details are not loaded")
	public void deleted_contact_details() {
		response = given().auth().oauth2(
				"00D5j000004mDIU!ARoAQL.kTMsTQ5aug7QwvVJP__hwWGHvqec8xRCnFEx116x78Ztc_XJ34pHAW0p1sSSDNkh1Ve_z8Gxwx9T_y_cGCsAgX6Wr")
				.contentType(ContentType.JSON).log().all().when().get("Contact/" + id);
		System.out.println(response.prettyPrint());
	}

}