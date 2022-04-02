package service;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;


import java.io.IOException;

import static org.testng.Assert.assertEquals;


public class TestGet404 {

    private final String WRONGBASEENDPOINT = "https://api.github.com/wrongEndpoint";
    private int actualStatus;

    @Test
    public void baseUrlReturns404() throws IOException {
        HttpGet httpGet = new HttpGet(WRONGBASEENDPOINT);

        CloseableHttpClient client = HttpClientBuilder.create().build();

        HttpResponse response = client.execute(httpGet);

        actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 404);
    }
}
