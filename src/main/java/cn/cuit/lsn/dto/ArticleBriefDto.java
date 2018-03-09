/**
 * 
 */
package cn.cuit.lsn.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @author newbie
 * DTO 用于表现层和业务层之间的数据传输，因其可以不暴露数据表的表结构。
 * 每个DTO要有一个默认的无参构造方法
 *
 */
public class ArticleBriefDto {
	private int articleId;
	
	private String articleTitle;
	
	private String articleAuthor;
	
	@JSONField(format = "yy-MM-dd")
    private Date createTime;
    
    private String articleBrief;

    public ArticleBriefDto(){}
    
	public int getArticleId() {
		return articleId;
	}


	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getArticleBrief() {
		return articleBrief;
	}

	public void setArticleBrief(String articleBrief) {
		this.articleBrief = articleBrief;
	}
    
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
}
