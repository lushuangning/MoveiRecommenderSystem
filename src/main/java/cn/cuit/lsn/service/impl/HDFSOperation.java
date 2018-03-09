package cn.cuit.lsn.service.impl;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;


public class HDFSOperation {


    public static String mkdir(String dstHdfs){
        return null;
    }

    public static void delete(String destHdfs){

    }

    public static String getDirectoryFromHDFS(String destDire) {
        return null;
    }

    public static void copyFromLocal(String srcServer, String dstHdfs){
        Configuration conf = new Configuration();
        conf.addResource(new Path("/usr/local/hadoop-2.7.5/etc/hadoop/core-site.xml"));
        conf.addResource(new Path("/usr/local/hadoop-2.7.5/etc/hadoop/hdfs-site.xml"));
        try{
            FileSystem fs = FileSystem.get(conf);
            Path srcPath = new Path("/tmp/hello.txt");
            Path dstPath = new Path("input/test");
            //文件系统复制函数，false参数为删除源文件
            fs.copyFromLocalFile(false,srcPath,dstPath);
            fs.close();
            System.out.println("---------------------上传成功----------");
        }catch (IOException e){
            System.out.println("---------------------上传文件到HDFS时出现异常------------------------"
                    + e.getMessage());
        }


    }
}
