package cn.cuit.lsn.service;

import cn.cuit.lsn.pojo.MovieInfo;
import cn.cuit.lsn.pojo.RecommenderArgs;

import java.util.List;

public interface RecommenderService {

    /**
     * 根据前端用户配置调用推荐算法
     *
     */
    void customRecommend(RecommenderArgs recommenderArgs);

    //默认推荐
    void defaultRecommend();

    List<?> showResult(Integer userId);

    void saveToMySQL(String fromDir,String toTable);
}
