package BEtask.stepDefinitions;

import BEtask.models.ApiConnector;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

@Data
public class Btest2Step {
    ApiConnector apiConnector = new ApiConnector();
    Response responseDoc = apiConnector.getDocumentationForEtherium();
    JSONObject object = new JSONObject(responseDoc.asPrettyString());

    @When("Confirm that the following logo URL is present")
    public void confirmThatTheFollowingLogoURL() {
        try {
            String logo = object.getJSONObject("data").getJSONObject("1027").getString("logo");
            Assert.assertEquals(logo, "https://s2.coinmarketcap.com/static/img/coins/64x64/1027.png");
        }
        catch (Throwable e) {
            System.out.println("Exception:" + e);
        }
    }

    @And("Confirm that the technical_doc URI is present")
    public void confirmThatTheTechnical_docURIIsPresent() {
        try {
            JSONArray logo = object.getJSONObject("data").getJSONObject("1027").getJSONObject("urls").getJSONArray("technical_doc");
            Assert.assertEquals(logo.get(0), "https://github.com/ethereum/wiki/wiki/White-Paper");
        }
        catch (Throwable e) {
            System.out.println("Exception:" + e);
        }
    }

    @And("Confirm that the symbol of the currency is ETH")
    public void confirmThatTheSymbolOfTheCurrencyIsETH() {
        try {
            String symbol = object.getJSONObject("data").getJSONObject("1027").getString("symbol");
            Assert.assertEquals(symbol, "ETH");
        }
        catch (Throwable e) {
            System.out.println("Exception:" + e);
        }
    }

    @Then("Confirm that the date added is 2015-08-07T00:00:00.000Z")
    public void confirmThatTheDateAdded() {
        try {
            String date_added = object.getJSONObject("data").getJSONObject("1027").getString("date_added");
            Assert.assertEquals(date_added, "2015-08-07T00:00:00.000Z");
        }
        catch (Throwable e) {
            System.out.println("Exception:" + e);
        }
    }

    @And("Confirm that the platform is null")
    public void confirmThatThePlatformIsNull() {
        try {
            Assert.assertEquals(object.getJSONObject("data").getJSONObject("1027").get("platform"), null);
        }
        catch (Throwable e) {
            System.out.println("Exception:" + e);
        }
    }

    @And("Confirm that the currency has the mineable tag")
    public void confirmThatTheCurrencyHasTheMineableTagWithIt() {
        try {
            JSONArray tags = object.getJSONObject("data").getJSONObject("1027").getJSONArray("tags");
            Assert.assertEquals(tags.get(0), "mineable");
        }
        catch (NullPointerException e) {
            System.out.println("Exception:" + e);
        }
    }
}