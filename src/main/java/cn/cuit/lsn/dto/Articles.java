package cn.cuit.lsn.dto;

import java.util.ArrayList;
import java.util.List;


public class Articles {
	private List<Content> articles = new ArrayList<>();

	public List<Content> getArticles() {
		return articles;
	}

	public void setArticles(List<Content> articles) {
		this.articles = articles;
	}
	
	
}
