/**
 * 
 */
package cn.cuit.lsn.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @author 路双宁
 * DTO 用于表现层和业务层之间的数据传输，因其可以不暴露数据表的表结构。
 * 每个DTO要有一个默认的无参构造方法
 *
 */
public class ArticleDto {
	private String articleId;
	
	private String articleTitle;
	
	private String articleAuthor;

    private String articleContent;
    
    private int articlePermission;
    
    @JSONField(format = "yyyy-MM-dd")
    private Date createTime;
    
    private String articleType;
    
    public ArticleDto(){}
	
	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getArticlePermission() {
		return articlePermission;
	}

	public void setArticlePermission(int articlePermission) {
		this.articlePermission = articlePermission;
	}

	public String getArticleType() {
		return articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
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

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
}
