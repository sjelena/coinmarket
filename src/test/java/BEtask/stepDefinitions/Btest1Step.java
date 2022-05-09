package BEtask.stepDefinitions;

import BEtask.models.ApiConnector;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.Data;
import net.serenitybdd.core.Serenity;
import org.json.JSONException;
import org.json.JSONObject;

@Data
public class Btest1Step {
    ApiConnector apiConnector = new ApiConnector();
    @Given("I send request and I got JSON result")
    public void iNeedJSONResult() {
        apiConnector.requestSpecification();
    }

    @When("I need id of {string}")
    public void iNeedIdOf(String cryptocurrency) throws JSONException {
        try {
            Response response = apiConnector.getId(cryptocurrency);
            JSONObject object = new JSONObject(response.asPrettyString());
            int id = object.getJSONArray("data").getJSONObject(0).getInt("id");
            System.out.println(cryptocurrency + " ID " + " = " + id);
            Serenity.setSessionVariable(cryptocurrency).to(id);
        }
        catch (Throwable e) {
            System.out.println("Exception:" + e);
        }
    }

    @Then("I will convert {string} price to BOLI")
    public void iWillConvertThemToBOLI(String cryptocurrency) {
        try {
            int id = Serenity.sessionVariableCalled(cryptocurrency);
            Response response = apiConnector.priceConvert(String.valueOf(id));
            JSONObject object = new JSONObject(response.asPrettyString());
            double price = object.getJSONObject("data").getJSONObject("quote").getJSONObject("USD").getDouble("price");
            System.out.println(cryptocurrency + " price " + " = " + price);
        }
        catch (Throwable e) {
            System.out.println("Exception:" + e);
        }
    }
}