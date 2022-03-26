import entities.BaseClass;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;


public class TestGet extends BaseClass {

    private int actualStatus;

    @Test
    public void baseUrlReturns200() throws IOException {
        HttpGet httpGet = new HttpGet(BASEURL);

        CloseableHttpClient client = HttpClientBuilder.create().build();

        HttpResponse response = client.execute(httpGet);

        actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }

    @Test
    public void baseUrlReturns401() throws IOException {
        HttpGet httpGet = new HttpGet(ENDPOINT);

        CloseableHttpClient client = HttpClientBuilder.create().build();

        HttpResponse response = client.execute(httpGet);

        actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 401);
    }

    @Test
    public void baseUrlReturns404() throws IOException {
        HttpGet httpGet = new HttpGet(WRONGBASEENDPOINT);

        CloseableHttpClient client = HttpClientBuilder.create().build();

        HttpResponse response = client.execute(httpGet);

        actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 404);
    }

    @Test
    public void baseUrlWithHeaders() throws IOException {
        HttpGet httpGet = new HttpGet(BASEURL);
        httpGet.setHeader("name", "privet");

        CloseableHttpClient client = HttpClientBuilder.create().build();

        HttpResponse response = client.execute(httpGet);

        actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }

}
