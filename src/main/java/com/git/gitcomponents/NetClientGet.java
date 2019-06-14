package com.git.gitcomponents;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.git.model.RepoData;
import com.git.model.SourceData;
import com.git.model.SourceType;
import com.git.db.DataRepository;
import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.sf.json.JSONObject;
import okhttp3.*;
@RestController
public class NetClientGet {
	private DataRepository dataRepository;
	
@RequestMapping(value="/getComponents", params={"accountname","reponame"},method=RequestMethod.GET)
public void getComponents(String accountname,String reponame) {

  try {	
	  
	  OkHttpClient httpClient = new OkHttpClient();
	  String url = "https://api.github.com/repos/"+accountname+"/"+reponame+"/"+"contents";
	  Request request = new Request.Builder()
      		.header("Accept", "application/json")
              .url(url)
              .get()
              .build();
	  
	  Response response = httpClient.newCall(request).execute();
	  if(response.code() == 200)
	  {
	  String resp = response.body().string();
	  //System.out.println("output :"+resp);
	  Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
      
      RepoData[] repoData = gson.fromJson(resp, RepoData[].class);
      //JSONObject json = new JSONObject();
      for(int i=0; i< repoData.length ;i++)
      {
      System.out.println("gson repoData :"+repoData[i].getPath());
      if(repoData[i].getPath().contains("src"))
      {
    	  System.out.println("repoData[i].getPath() :"+repoData[i].getPath() );
    	  System.out.println("repoData[i].getSha() :"+repoData[i].getSha() );
    	  //call another method sendinf src sha ..
    	  getMetadataType(accountname,reponame,repoData[i].getSha());
      }
      }
	  }

	  } catch (Exception e) {

		e.printStackTrace();

	  }

	}
	public void getMetadataType(String accountname,String reponame,String sha)
	{
		try {	
			  System.out.println(accountname+" "+reponame+" "+sha);
			  OkHttpClient httpClient = new OkHttpClient();
			  String url = "https://api.github.com/repos/"+accountname+"/"+reponame+"/git/trees/"+sha;
			  Request request = new Request.Builder()
		      		.header("Accept", "application/json")
		              .url(url)
		              .get()
		              .build();
			  
			  Response response = httpClient.newCall(request).execute();
			  if(response.code() == 200)
			  {
			  String resp = response.body().string();
			  System.out.println("output :"+resp);
			  Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		      
		      SourceType[] sourceData = gson.fromJson(resp, SourceType[].class);
		      //JSONObject json = new JSONObject();
		      for(int i=0; i< sourceData.length ;i++)
		      {
		      System.out.println("gson repoData :"+sourceData[i]);
		      /*if(sourceData[i].getPath() == "src")
		      {
		    	  //call another method sendinf src sha ..
		      }*/
		      }
			  }

			  } catch (Exception e) {

				e.printStackTrace();

			  }
	}
}