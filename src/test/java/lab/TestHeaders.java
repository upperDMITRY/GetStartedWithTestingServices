package lab;

import entities.BaseClass;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.*;

import java.io.IOException;

import static entities.ResponseUtils.getHeader;
import static entities.ResponseUtils.headerIsPresent;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestHeaders extends BaseClass {

    private CloseableHttpClient client;
    private CloseableHttpResponse response;

    @BeforeMethod
    public void setUp() {
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void tearDown() throws IOException {
        client.close();
        response.close();
    }

    @Test
    public void testContentTypeHeader() throws IOException {
        HttpGet httpGet = new HttpGet(BASEURL);

        response = client.execute(httpGet);

        Header contentType = response.getEntity().getContentType();


        assertEquals(contentType.getValue(), "application/json; charset=utf-8");

    }

    @Test
    public void testContentTypeHeaderMine() throws IOException {
        HttpGet httpGet = new HttpGet(BASEURL);

        response = client.execute(httpGet);

        ContentType ct = ContentType.getOrDefault(response.getEntity());

        assertEquals(ct.getMimeType(), "application/json");
    }

    @Test
    public void testAccessControlHeaderMine() throws IOException {
        HttpGet httpGet = new HttpGet(BASEURL);

        response = client.execute(httpGet);

        String header = getHeader(response, "access-control-allow-origin");

        assertEquals(header, "*");
    }

    @Test
    public void testHeaderIsPresent() throws IOException {
        HttpGet httpGet = new HttpGet(BASEURL);

        response = client.execute(httpGet);

        assertTrue(headerIsPresent(response, "access-control-allow-origin"));
    }

    //TODO Get header with stream
}
