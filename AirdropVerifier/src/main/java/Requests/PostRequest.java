package Requests;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PostRequest {



    public String sendPost(String url) throws Exception {

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        try {
            HttpResponse response = client.execute(post);
            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    response.getEntity().getContent()));
            String line = "";
            String ret = "";
            while ((line = rd.readLine()) != null) {
                ret = ret+line+"\n";
            }
            return ret.trim();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
