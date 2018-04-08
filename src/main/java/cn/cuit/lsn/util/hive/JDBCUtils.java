package cn.cuit.lsn.util.hive;

import java.sql.*;

public class JDBCUtils {
    private static String driver = "org.apache.hive.jdbc.HiveDriver";
    private static String url = "jdbc:hive2://localhost:10000/default";

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection(){

        try {
            return DriverManager.getConnection(url,"lushuangning","");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void release(Connection conn, Statement st, ResultSet rs){

        if (st != null){
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                st = null;
            }
        }

        if (rs != null){
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                rs = null;
            }
        }

        if (conn != null){
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conn = null;
            }
        }

    }

}
