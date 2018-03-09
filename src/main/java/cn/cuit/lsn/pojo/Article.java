/**
 * 
 */
package cn.cuit.lsn.pojo;

import java.util.Date;

/**
 * @author 路双宁
 *
 */
public class Article {
	private Integer articleId;
	
	private String articleTitle;
	
	private String articleAuthor;
	
	private Date createTime;
	
	private String articleContent;
	
	private int articlePermission;
	
	private String articleType;
	
	private String articleBrief;

	public String getArticleBrief() {
		return articleBrief;
	}

	public void setArticleBrief(String articleBrief) {
		this.articleBrief = articleBrief;
	}

	public String getArticleType() {
		return articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	public int getArticlePermission() {
		return articlePermission;
	}

	public void setArticlePermission(int articlePermission) {
		this.articlePermission = articlePermission;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleAuthor() {
		return articleAuthor;
	}

	public void setArticleAuthor(String articleAuthor) {
		this.articleAuthor = articleAuthor;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

}
