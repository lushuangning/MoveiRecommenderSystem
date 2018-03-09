/**
 * 
 */
package cn.cuit.lsn.dao;

import cn.cuit.lsn.dto.ArticleBriefDto;
import cn.cuit.lsn.dto.ArticleDto;
import cn.cuit.lsn.pojo.Article;

import java.util.List;

/**
 * @author 路双宁
 *
 */
public interface ArticlesDao {

    /* 保存文章 */
    int save(Article article);

    /* 按标题查询一篇文章 */
    ArticleDto queryByTitle(String articleTitle);

    /* 按ID查询一篇文章 */
    ArticleDto queryByID(Integer articleId);

    /* 按权限查询所有文章简介 */
    List<ArticleBriefDto> queryAllArticles(String articleType);
}
