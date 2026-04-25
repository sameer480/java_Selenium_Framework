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

        // 🔹 Step 1: Create request body
        AuthRequest req = new AuthRequest();
        req.setName("admin");
        req.setGender("male");
        req.setId(10);
        req.setGender("male");
        req.setEmail("@gmail.com");
        req.setStatus("active");
        Response res = AuthService.generateToken(req);
        Assert.assertEquals(res.getStatusCode(), 200);
        Assert.assertNotNull(res.getBody());
    }
}