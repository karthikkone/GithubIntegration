package com.git.model;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class RepoData {
	
	private String name;
	private String path;
	private String sha;
	private String size;
	private String url;
	private String html_url;
	private String git_url;
	private String downloadUrl;
	private String type;
	private class links
	{
		private String self;
		private String git;
		private String html;
		public String getSelf() {
			return self;
		}
		public void setSelf(String self) {
			this.self = self;
		}
		public String getGit() {
			return git;
		}
		public void setGit(String git) {
			this.git = git;
		}
		public String getHtml() {
			return html;
		}
		public void setHtml(String html) {
			this.html = html;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((git == null) ? 0 : git.hashCode());
			result = prime * result + ((html == null) ? 0 : html.hashCode());
			result = prime * result + ((self == null) ? 0 : self.hashCode());
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
			links other = (links) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (git == null) {
				if (other.git != null)
					return false;
			} else if (!git.equals(other.git))
				return false;
			if (html == null) {
				if (other.html != null)
					return false;
			} else if (!html.equals(other.html))
				return false;
			if (self == null) {
				if (other.self != null)
					return false;
			} else if (!self.equals(other.self))
				return false;
			return true;
		}
		private RepoData getOuterType() {
			return RepoData.this;
		}
		@Override
		public String toString() {
			return "links [self=" + self + ", git=" + git + ", html=" + html + "]";
		}
		
		
	};
	public RepoData()
	{
		
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getHtml_url() {
		return html_url;
	}

	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
