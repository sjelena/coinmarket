package BEtask.models;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

public class ApiConnector {
    public static String BASE_URL = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/map";
    public static String CONVERSION_URL = "https://pro-api.coinmarketcap.com/v2/tools/price-conversion";
    public static String DOCUMENTATION_URL = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/info";

    public RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .addHeader("X-CMC_PRO_API_KEY", "9f5f4cf2-a509-4f50-84f0-9fd91d0d6f66")
                .build();
    }

    public Response getId(String cryptocurrency) {
        return SerenityRest
                .given().spec(requestSpecification())
                .when()
                .get(BASE_URL + "?symbol=" + cryptocurrency)
                .thenReturn();
    }

    public Response priceConvert(String cryptocurrency) {
        return SerenityRest
                .given().spec(requestSpecification())
                .when()
                .get(CONVERSION_URL + "?amount=1&id=" + cryptocurrency)
                .thenReturn();
    }
    public Response getDocumentationForEtherium() {
        return SerenityRest
                .given().spec(requestSpecification()).queryParam("id", "1027")
                .when()
                .get(DOCUMENTATION_URL)
                .thenReturn();
    }
    public Response getDocumentation(int id) {
        return SerenityRest
                .given().spec(requestSpecification())
                .when()
                .get(DOCUMENTATION_URL + "?id=" +id)
                .thenReturn();
    }
}