package restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PostAndGetTest {

    public Response createBooking(){

        //Create JSON Body
        JSONObject body = new JSONObject();
        body.put("firstname", "Sedat");
        body.put("lastname", "Yurt");
        body.put("totalprice", 155);
        body.put("depositpaid", false);

        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2022-01-01");
        bookingdates.put("checkout", "2022-04-01");
        body.put("bookingdates", bookingdates);
        body.put("additionalneeds", "Lunch");

        //Post Response
        Response response = RestAssured.given().contentType(ContentType.JSON).
                body(body.toString()).post("https://restful-booker.herokuapp.com/booking");
        response.print();
        return response;
    }

    @Test
    public void createBookingTests(){
        int bookingId = createBooking().jsonPath().getInt("bookingid");

        //Get Response
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking/" + bookingId);
        response.print();

        //Verifications
        SoftAssert softAssert = new SoftAssert();

        String actualFirstName = response.jsonPath().getString("firstname");
        softAssert.assertEquals(actualFirstName, "Sedat", "First name in response is not expected!");

        String actualLastName = response.jsonPath().getString("lastname");
        softAssert.assertEquals(actualLastName, "Yurt", "Last name in response is not expected!");

        int price = response.jsonPath().getInt("totalprice");
        softAssert.assertEquals(price, 155, "Total price in response is not expected!");

        boolean depositPaid = response.jsonPath().getBoolean("depositpaid");
        softAssert.assertFalse(depositPaid, "Deposit paid should be false, but it's not!");

        String actualCheckIn = response.jsonPath().getString("bookingdates.checkin");
        softAssert.assertEquals(actualCheckIn, "2022-01-01", "CheckIn in response is not expected!");

        String actualCheckOut = response.jsonPath().getString("bookingdates.checkout");
        softAssert.assertEquals(actualCheckOut, "2022-04-01", "CheckOut in response is not expected!");

        String actualAdditionalNeeds = response.jsonPath().getString("additionalneeds");
        softAssert.assertEquals(actualAdditionalNeeds, "Lunch", "additionalneeds is not expected!");

        softAssert.assertAll();
    }
}
