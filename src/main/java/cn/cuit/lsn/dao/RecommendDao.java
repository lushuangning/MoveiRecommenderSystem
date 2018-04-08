package cn.cuit.lsn.dao;

import cn.cuit.lsn.pojo.MovieInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendDao {

    /**
     * 根据用户Id查询为该Id推荐的电影
     * @param userId 用户Id
     * @return List<MovieInfo>,推荐电影集合
     */
    List<MovieInfo> getRecommendMovie(@Param("userId") Integer userId);
}
