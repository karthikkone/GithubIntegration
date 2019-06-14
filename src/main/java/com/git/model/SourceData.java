package com.git.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SourceData {
	
	@Expose @SerializedName("tree")
	SourceType sourceType;

}
