package com.git.gitcomponents;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
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
public JSONObject getComponents(String accountname,String reponame) {

  try {	
	  
	  OkHttpClient httpClient = new OkHttpClient();
	  JSONObject json = new JSONObject();
	  List<String> components = new ArrayList<>();
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
      for(int i=0; i< repoData.length ;i++)
      {
      System.out.println("gson repoData :"+repoData[i].getPath());
      if(repoData[i].getPath().contains("src"))
      {
    	  System.out.println("repoData[i].getPath() :"+repoData[i].getPath() );
    	  System.out.println("repoData[i].getSha() :"+repoData[i].getSha() );
    	  //call another method sendinf src sha ..
    	  //json.put("components", getMetadataType(accountname,reponame,repoData[i].getSha()));
    	  json = getMetadataType(accountname,reponame,repoData[i].getSha());
      }
      }
      
	  }
	  return json;
	  } catch (Exception e) {

		e.printStackTrace();

	  }
  	return null;
  		
	}
	public JSONObject getMetadataType(String accountname,String reponame,String sha)
	{
		try {	
			List<String> components = new ArrayList<>();
			JSONObject json = new JSONObject();
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
		      
		      SourceData sourceData = gson.fromJson(resp, SourceData.class);
		      System.out.println("gson sourceData :"+sourceData.getSourceType());
		      SourceType[] sourcetype = sourceData.getSourceType();
		      System.out.println("sourcetype [1]:"+sourcetype[1].getPath()+" "+sourcetype[1].getUrl()+" "+sourcetype[1].getSha());
		      
		      //getComponents(accountname,reponame,sourcetype[0].getSha());
		      for(int i=0; i< sourcetype.length ;i++)
		      {	      
		    	  components = getComponents(accountname,reponame,sourcetype[i].getSha());
		    	  json.put(sourcetype[i].getPath(), components);
		      }
		      
		      
			  }
			  else if(response.code() == 422)
			  {
				  System.out.println("Invalid Metadata Type");
				  
			  }
			  return json;
			  } catch (Exception e) {

				e.printStackTrace();

			  }
		return null;
	}
	public List<String> getComponents(String accountname,String reponame,String sha)
	{
		try {	
			  List<String> components = new ArrayList<String>();
			  System.out.println(accountname+" "+reponame+" "+sha);
			  OkHttpClient httpClient = new OkHttpClient();
			  String url = "https://api.github.com/repos/"+accountname+"/"+reponame+"/git/trees/"+sha;
			  Request request = new Request.Builder()
		      		.header("Accept", "application/json")
		              .url(url)
		              .get()
		              .build();
			  
			  Response response = httpClient.newCall(request).execute();
			  String resp =null;
			  if(response.code() == 200)
			  {
			  resp = response.body().string();
			  System.out.println("output :"+resp);
			  
			  Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		      
		      SourceData sourceData = gson.fromJson(resp, SourceData.class);
		      System.out.println("gson sourceData :"+sourceData.getSourceType());
		      SourceType[] sourcetype = sourceData.getSourceType();
		      System.out.println("sourcetype [1]:"+sourcetype[1].getPath()+" "+sourcetype[1].getUrl()+" "+sourcetype[1].getSha());
		      
		      for(int i=0; i< sourcetype.length ;i++)
		      {	      
		    	  System.out.println("components :"+sourcetype[i].getPath());
		    	  String ext = FilenameUtils.getExtension(sourcetype[i].getPath());
		    	  if(ext.contains("xml") != true)
		    	  {
		    	  components.add(sourcetype[i].getPath());
		    	  }
		      }
			  }
			  else if(response.code() == 422)
			  {
				  System.out.println("Invalid Metadata Type");
			  }
			  return components;
			  } catch (Exception e) {

				e.printStackTrace();

			  }
			return null;
	}
}