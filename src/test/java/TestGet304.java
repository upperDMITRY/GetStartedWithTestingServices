import entities.BaseClass;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.Optional;

import static org.testng.Assert.assertEquals;


public class TestGet304 extends BaseClass {

    private int actualStatus;

    @Test
    public void baseUrlReturns200() throws IOException {
        HttpGet httpGet = new HttpGet(baseURL);

        CloseableHttpClient client = HttpClientBuilder.create().build();

        HttpResponse response = client.execute(httpGet);

        actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }
}
