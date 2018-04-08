package cn.cuit.lsn.util.hive;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SaveToHive {

    public static void save(String file,String table){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "load data inpath " + "\"" + file + "\"" + " overwrite into table " + table;
        System.out.println(sql);

        try {
            //获取链接
            conn = JDBCUtils.getConnection();
            st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn,st,rs);
        }
    }

}
