package com.git.model;

import javax.persistence.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class RepoData {
	@Expose @SerializedName("name")
	private String name;
	@Expose @SerializedName("path")
	private String path;
	@Expose @SerializedName("sha")
	private String sha;
	@Expose @SerializedName("url")
	private String url;
	@Expose @SerializedName("git_url")
	private String git_url;
	@Expose @SerializedName("download_url")
	private String downloadUrl;
	
	public RepoData()
	{
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getGit_url() {
		return git_url;
	}

	public void setGit_url(String git_url) {
		this.git_url = git_url;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((downloadUrl == null) ? 0 : downloadUrl.hashCode());
		result = prime * result + ((git_url == null) ? 0 : git_url.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		RepoData other = (RepoData) obj;
		if (downloadUrl == null) {
			if (other.downloadUrl != null)
				return false;
		} else if (!downloadUrl.equals(other.downloadUrl))
			return false;
		if (git_url == null) {
			if (other.git_url != null)
				return false;
		} else if (!git_url.equals(other.git_url))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
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
		return "RepoData [name=" + name + ", path=" + path + ", sha=" + sha + ", url=" + url + ", git_url=" + git_url
				+ ", downloadUrl=" + downloadUrl + "]";
	}
	
	
}
