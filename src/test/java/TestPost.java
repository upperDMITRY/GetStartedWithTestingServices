import entities.BaseClass;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;


public class TestPost extends BaseClass {
    protected String baseURL = "https://api.github.com/";
    private int actualStatus;

    @Test
    public void baseUrlPostRequest() throws IOException {
        HttpPost httpPost = new HttpPost(baseURL);

        CloseableHttpClient client = HttpClientBuilder.create().build();

        HttpResponse response = client.execute(httpPost);

        actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }
}
