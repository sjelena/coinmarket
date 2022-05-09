package BEtask;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

public class Test1 {
    @Test
    public void test1() {
        given().header("X-CMC_PRO_API_KEY", "9f5f4cf2-a509-4f50-84f0-9fd91d0d6f66")
                .when().get("https://pro-api.coinmarketcap.com/v1/cryptocurrency/map").
        then().
                body("data.symbol", hasItems("BTC")).log().body().
                body("data.symbol", hasItems("USDT")).
                body("data.symbol", hasItems("ETH"));

    }

    private static RequestSpecification requestSpec;

    @BeforeClass
    public static void createRequestSpecification() {

        requestSpec = new RequestSpecBuilder().
                addHeader("X-CMC_PRO_API_KEY", "9f5f4cf2-a509-4f50-84f0-9fd91d0d6f66").
                build();
    }
    private static ResponseSpecification responseSpec;

    @BeforeClass
    public static void createResponseSpecification() {
        responseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                build();
    }

    String URL = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/map";

    @Test
    public void needIdOfCryptocurrency () {
        given(requestSpec).
                when().
//                queryParam("amount", 1).
//                queryParam("symbol", "BTC").
                get(URL).
                then().log().all();

    }

}
////package BEtask.impl;
////
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.specification.RequestSpecification;
//import lombok.Data;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static io.restassured.RestAssured.given;
//
//@Data
//public class BEtask1impl {
//    private static RequestSpecification requestSpec;
//    private String URL = "https://pro-api.coinmarketcap.com/v2/tools/price-conversion";
//
//    @BeforeClass
//    public static void createRequestSpecification() {
//        requestSpec = new RequestSpecBuilder().
//                addHeader("X-CMC_PRO_API_KEY", "9f5f4cf2-a509-4f50-84f0-9fd91d0d6f66").
////                setBaseUri("https://pro-api.coinmarketcap.com/v1/cryptocurrency/map").
//                build();
//    }
//
//    @Test
//    public void iNeedIdOf (String cryptocurrency) {
//        given(requestSpec).
//                when().
//                queryParam("amount", 1).
//                queryParam("symbol", cryptocurrency).
//                get(URL).
//                then().log().all();
//    }
//    @Test
//    public void iNeedIdOfa ( ) {
//
//        given(requestSpec).
//                when().get("https://pro-api.coinmarketcap.com/v1/cryptocurrency/map").then();
//
//
//    }
//}
//

