package com.git.model;

import java.util.Arrays;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SourceData {
	
	@Expose @SerializedName("tree")
	SourceType[] sourceType;

	public SourceData()
	{
		
	}
	public SourceType[] getSourceType() {
		return sourceType;
	}

	public void setSourceType(SourceType[] sourceType) {
		this.sourceType = sourceType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(sourceType);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SourceData other = (SourceData) obj;
		if (!Arrays.equals(sourceType, other.sourceType))
			return false;
		return true;
	}

	
	

}
