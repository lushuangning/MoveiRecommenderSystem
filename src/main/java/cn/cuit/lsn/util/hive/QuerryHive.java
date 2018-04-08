package cn.cuit.lsn.util.hive;

import cn.cuit.lsn.pojo.MovieInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuerryHive {

    public static List<?> querry(String sql){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        System.out.println(sql);
        List<MovieInfo> movies = new ArrayList<>();
        MovieInfo movieInfo = null;
        try {
            //获取链接
            conn = JDBCUtils.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                movieInfo = new MovieInfo();
                movieInfo.setTitle(rs.getString(1));
                movieInfo.setGenres(rs.getString(2));
                movies.add(movieInfo);
                System.out.println("-------" + movieInfo.getTitle() + "\t\t" + movieInfo.getGenres());
            }

            return movies;
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn,st,rs);
        }

        return null;
    }
}
