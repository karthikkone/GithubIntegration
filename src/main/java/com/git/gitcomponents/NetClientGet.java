package com.git.gitcomponents;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import okhttp3.*;
@RestController
public class NetClientGet {

	// http://localhost:8080/RESTfulExample/json/product/get
@RequestMapping(value="/getComponents", method=RequestMethod.GET)
public void getComponents() {

  try {

	/*URL url = new URL("https://api.github.com/repos/karthikkone/DemoRepo/git/trees/686b02625baf89bd828480d0a3bcbb25fb2596d9");
	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	conn.setRequestMethod("GET");
	conn.setRequestProperty("Accept", "application/json");

	if (conn.getResponseCode() != 200) {
		throw new RuntimeException("Failed : HTTP error code : "
				+ conn.getResponseCode());
	}

BufferedReader br = new BufferedReader(new InputStreamReader(
	(conn.getInputStream())));

String output;
System.out.println("Output from Server .... \n");
while ((output = br.readLine()) != null) {
	System.out.println(output);
}	
		conn.disconnect();*/
	  
	  OkHttpClient httpClient = new OkHttpClient();
	  HttpUrl ghURL = HttpUrl.parse("https://api.github.com/repos/karthikkone/DemoRepo/git/trees/686b02625baf89bd828480d0a3bcbb25fb2596d9").newBuilder()
              .addPathSegment("")
              .build();

	  Request request = new Request.Builder()
      		.header("Accept", "application/json")
              .url(ghURL)
              .get()
              .build();
	  
	  Response response = httpClient.newCall(request).execute();
	  System.out.println("output :"+response.body());

	  } catch (Exception e) {

		e.printStackTrace();

	  }

	}

}