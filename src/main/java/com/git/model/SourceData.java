package com.git.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SourceData {
	
	@Expose @SerializedName("tree")
	SourceType sourceType;

	public SourceType getSourceType() {
		return sourceType;
	}

	public void setSourceType(SourceType sourceType) {
		this.sourceType = sourceType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sourceType == null) ? 0 : sourceType.hashCode());
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
		if (sourceType == null) {
			if (other.sourceType != null)
				return false;
		} else if (!sourceType.equals(other.sourceType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SourceData [sourceType=" + sourceType + "]";
	}
	
	

}
