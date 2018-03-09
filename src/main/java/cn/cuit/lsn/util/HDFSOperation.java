package cn.cuit.lsn.util;


import cn.cuit.lsn.service.HDFSOperationService;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.stereotype.Service;

import java.io.IOException;


public class HDFSOperation {

    //Hadoop设置
    private static Configuration conf = new Configuration();
    static {
        conf.addResource(new Path("/usr/local/hadoop-2.7.5/etc/hadoop/core-site.xml"));
        conf.addResource(new Path("/usr/local/hadoop-2.7.5/etc/hadoop/hdfs-site.xml"));
    }


    public String mkdir(String dstHdfs){
        return null;
    }

    public void delete(String destHdfs){

    }

    public String getDirectoryFromHDFS(String destDire) {
        return null;
    }

    public static String copyFromLocal(String srcServer, String dstHdfs){

        try{
            FileSystem fs = FileSystem.get(conf);
            Path srcPath = new Path("/tmp/hello.txt");
            Path dstPath = new Path("input/test/");
            //文件系统复制函数，false参数为删除源文件
            fs.copyFromLocalFile(false,srcPath,dstPath);
            fs.close();
            System.out.println("---------------------上传成功----------");

            return dstPath.toString();
        }catch (IOException e){
            System.out.println("---------------------上传文件到HDFS时出现异常------------------------"
                    + e.getMessage());
        }

            return null;
    }
}
