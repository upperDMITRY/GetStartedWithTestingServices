package service;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;


import java.io.IOException;

import static org.testng.Assert.assertEquals;


public class TestHeader {

    private final String ENDPOINT = "https://api.github.com/";
    private int actualStatus;

    @Test
    public void baseUrlReturns401() throws IOException {
        HttpGet httpGet = new HttpGet(ENDPOINT);
        httpGet.setHeader("name", "privet");

        CloseableHttpClient client = HttpClientBuilder.create().build();

        HttpResponse response = client.execute(httpGet);

        actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }
}
