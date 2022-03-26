import entities.BaseClass;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class TestPostAndDelete extends BaseClass {

    private CloseableHttpClient client;
    private CloseableHttpResponse response;
    private int actualStatus;

    @BeforeMethod
    public void setUp() {
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void tearDown() throws IOException {
        client.close();
        response.close();
    }

    @Test(priority = 10)
    public void DeleteMyRepository204() throws IOException {
        HttpDelete delete = new HttpDelete(BASEURL + "/repos/upperDMITRY/test");

        delete.setHeader(HttpHeaders.AUTHORIZATION, "token " + TOKEN);

        response = client.execute(delete);

        actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 204);
    }

    @Test(priority = 0)
    public void createNewRepository201() throws IOException {
        HttpPost post = new HttpPost(BASEURL + "/user/repos");

        post.setHeader(HttpHeaders.AUTHORIZATION, "token " + TOKEN);

        String json = "{\"name\":\"test\"}";

        post.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        response = client.execute(post);

        actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 201);
    }

}
