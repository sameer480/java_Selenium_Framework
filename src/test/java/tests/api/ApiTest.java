package tests.api;
import api.models.request.AuthRequest;
import api.services.AuthService;
import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(utils.TestListener.class)
public class ApiTest {

    @Test(retryAnalyzer = utils.RetryAnalyzer.class)
    public void generateTokenTest() {

    }
}