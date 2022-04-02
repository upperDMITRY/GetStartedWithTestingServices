package service.lab;

import entities.BaseClass;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;


import java.io.IOException;

import static org.testng.Assert.assertEquals;


public class LabTestUrls extends BaseClass {

    private final String EMOJIURL ="https://api.github.com/emojis";
    private final String UERFOLLOWERSURL ="https://api.github.com/user/followers";
    private final String NONEXISTINGURL ="https://api.github.com/vasea";
    private int actualStatus;

    @Test
    public void EmojisURLReturns200() throws IOException {
        HttpGet httpGet = new HttpGet(EMOJIURL);

        CloseableHttpClient client = HttpClientBuilder.create().build();

        HttpResponse response = client.execute(httpGet);

        actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }

    @Test
    public void UserFollowersURLReturns401() throws IOException {
        HttpGet httpGet = new HttpGet(UERFOLLOWERSURL);

        CloseableHttpClient client = HttpClientBuilder.create().build();

        HttpResponse response = client.execute(httpGet);

        actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 401);
    }

    @Test
    public void UserFollowersURLReturns404() throws IOException {
        HttpGet httpGet = new HttpGet(NONEXISTINGURL);

        CloseableHttpClient client = HttpClientBuilder.create().build();

        HttpResponse response = client.execute(httpGet);

        actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 404);
    }
}
