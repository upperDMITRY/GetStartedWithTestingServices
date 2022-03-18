package lab;

import entities.BaseClass;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.*;

import java.io.IOException;

import static org.testng.Assert.assertEquals;


public class DataProviderTestUrls extends BaseClass {

    private int actualStatus;
    private CloseableHttpClient client;
    private CloseableHttpResponse response;

    @DataProvider
    public static Object[][] urls() {
        return new Object[][]{{"/emojis"}, {"/user/followers"}, {"/vasea"}};
    }

    @BeforeMethod
    public void setUp() {
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void tearDown() throws IOException {
        client.close();
        response.close();
    }

    @Test(dataProvider = "urls")
    public void EmojisURLReturns200(String endpoint) throws IOException {
        HttpGet httpGet = new HttpGet(baseURL + endpoint);

        response = client.execute(httpGet);

        actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }
}
