package com.git.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SourceType {
	@Expose @SerializedName("path")
	private String path;
	@Expose @SerializedName("sha")
	private String sha;
	@Expose @SerializedName("url")
	private String url;
	
	public SourceType() {
		
	}
	
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getSha() {
		return sha;
	}
	public void setSha(String sha) {
		this.sha = sha;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((sha == null) ? 0 : sha.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		SourceType other = (SourceType) obj;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (sha == null) {
			if (other.sha != null)
				return false;
		} else if (!sha.equals(other.sha))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "SourceType [path=" + path + ", sha=" + sha + ", url=" + url + "]";
	}

	
}
