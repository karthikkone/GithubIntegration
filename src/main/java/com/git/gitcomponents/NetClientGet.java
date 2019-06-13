package com.git.gitcomponents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;
@RestController
public class NetClientGet {

	// http://localhost:8080/RESTfulExample/json/product/get
	@RequestMapping(value="/getComponents", method=RequestMethod.GET)
	public JSONObject getComponents() {

	  try {

		URL url = new URL("https://api.github.com/repos/karthikkone/DemoRepo/git/trees/686b02625baf89bd828480d0a3bcbb25fb2596d9");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		JSONObject json = new JSONObject();
		json.put("output",conn.getInputStream());

		conn.disconnect();
		return json;

	  } catch (MalformedURLException e) {

		e.printStackTrace();
		return null;

	  } catch (IOException e) {

		e.printStackTrace();
		return null;

	  }

	}

}