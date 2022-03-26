import entities.BaseClass;
import entities.User;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static entities.ResponseUtils.unmarshall;
import static org.testng.Assert.*;


public class TestGetBody extends BaseClass {

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
    public void returnsCorrectId() throws IOException {
        HttpGet get = new HttpGet(BASEURL + "/users/upperDMITRY");

        response = client.execute(get);

        String jsonBody= EntityUtils.toString(response.getEntity());

        JSONObject jsonObject = new JSONObject(jsonBody);

        Integer idValue = (Integer) jsonObject.get("id");

        assertEquals(idValue, Integer.valueOf(70110861));
    }

    @Test
    public void returnsCorrectId_unmarshall() throws IOException {
        HttpGet get = new HttpGet(BASEURL + "/users/upperDMITRY");

        response = client.execute(get);

        User user = unmarshall(response, User.class);

        assertEquals(user.getId(), 70110861);
    }

    @Test
    public void returnsCorrectLogin() throws IOException {
        HttpGet get = new HttpGet(BASEURL + "/users/upperDMITRY");

        response = client.execute(get);

        String jsonBody= EntityUtils.toString(response.getEntity());

        JSONObject jsonObject = new JSONObject(jsonBody);

        String login = (String) jsonObject.get("login");

        assertEquals(login, "upperDMITRY");
    }

    @Test
    public void returnsCorrectLogin_unmarshall() throws IOException {
        HttpGet get = new HttpGet(BASEURL + "/users/upperDMITRY");

        response = client.execute(get);

        User user = unmarshall(response, User.class);

        assertEquals(user.getLogin(), "upperDMITRY");
    }

    @Test
    public void returnsCorrectName() throws IOException {
        HttpGet get = new HttpGet(BASEURL + "/users/upperDMITRY");

        response = client.execute(get);

        String jsonBody= EntityUtils.toString(response.getEntity());

        JSONObject jsonObject = new JSONObject(jsonBody);

        String name = (String) jsonObject.get("name");

        assertEquals(name, "Dmitry");
    }

    @Test
    public void returnsCorrectName_unmarshall() throws IOException {
        HttpGet get = new HttpGet(BASEURL + "/users/upperDMITRY");

        response = client.execute(get);

        User user = unmarshall(response, User.class);

        assertEquals(user.getName(), "Dmitry");
    }

    @Test
    public void returnsThatFollowersExists() throws IOException {
        HttpGet get = new HttpGet(BASEURL + "/users/upperDMITRY");

        response = client.execute(get);

        String jsonBody= EntityUtils.toString(response.getEntity());

        JSONObject jsonObject = new JSONObject(jsonBody);

        Integer count = (Integer) jsonObject.get("followers");

        assertFalse(count != 0);
    }

    @Test
    public void returnsThatFollowersExists_unmarshall() throws IOException {
        HttpGet get = new HttpGet(BASEURL + "/users/upperDMITRY");

        response = client.execute(get);

        User user = unmarshall(response, User.class);

        assertFalse(user.getFollowers() != 0);
    }

}
