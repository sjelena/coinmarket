package BEtask.stepDefinitions;

import BEtask.models.ApiConnector;
import BEtask.models.Documentation;
import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static BEtask.util.Enum.TAG;

public class Btest3Step {
    ApiConnector apiConnector = new ApiConnector();
    Documentation documentation;
    Gson gson = new Gson();

    @Given("I send request for {int} currencies")
    public void iSendRequestForFirstCurrencies(int id) {
        List<Documentation> documentationList = new ArrayList<>();
        try {
            for (int i=1; i<=10; i++) {
                id = i;
                Response response = apiConnector.getDocumentation(id);
                JSONObject jsonObject = new JSONObject(response.asPrettyString());
                String tags = jsonObject.getJSONObject("data").getJSONObject(String.valueOf(i)).toString();
                documentation = gson.fromJson(tags, Documentation.class);

                documentationList.add(documentation);
            }
            Serenity.setSessionVariable(TAG).to(documentationList);
        }
        catch (Throwable e) {
            System.out.println("Exception:" + e);
        }
    }

    @When("I check witch currencies have the mineable tag associated with them")
    public void iCheckWitchCurrenciesHaveTheMineableTagAssociatedWithThem() {
        List<Documentation> documentationList = Serenity.sessionVariableCalled(TAG);
        for (Documentation documentation : documentationList){
            Assert.assertTrue(documentation.getTags().contains("mineable"));
        }
    }

    @Then("I verify that the correct cryptocurrencies have been printed out")
    public void iVerifyThatTheCorrectCryptocurrenciesHaveBeenPrintedOut() {
        List<Documentation> documentationList = Serenity.sessionVariableCalled(TAG);
        for (Documentation documentation1 : documentationList) {
            System.out.println("ID: " + documentation1.getId());
            System.out.println("Symbol: " + documentation1.getSymbol());
            System.out.println("Name: " + documentation1.getName());
        }
    }
}