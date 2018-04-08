package cn.cuit.lsn.util.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

/**
 * 该类对HDFS进行一些基本操作,包括上传文件,删除文件或文件夹,新建文件夹,从HDFS取文件
 * @version 0.4.0
 * @author 路双宁
 */
public class HDFSOperation{

    //调用本地Hadoop设置
    private static Configuration conf = new Configuration();

    static {
        conf.addResource(new Path("/usr/local/hadoop-2.7.5/etc/hadoop/core-site.xml"));
        conf.addResource(new Path("/usr/local/hadoop-2.7.5/etc/hadoop/hdfs-site.xml"));
        conf.addResource(new Path("/usr/local/hadoop-2.7.5/etc/hadoop/mapred-site.xml"));
        conf.addResource(new Path("/usr/local/hadoop-2.7.5/etc/hadoop/yarn-site.xml"));
    }


    /**
     *在hdfs文件系统中创建文件夹
     * @param dstHdfs 创建地址
     * @return 创建后的文件夹地址
     * @throws IOException
     */
    //TODO 新建文件夹
    public static String mkdir(String dstHdfs){
        return null;
    }


    /**
     *删除hdfs文件系统中的指定文件或文件夹
     * @param destHdfs 待删除文件的地址
     * @throws IOException
     */
    //TODO 删除指定文件或文件夹
    public static void delete(String destHdfs){

    }


    /**
     * 遍历指定目录下的所有文件信息
     * @param destDire 文件夹目录
     * @return 文件夹下的文件信息，以json格式返回
     */
    //TODO 返回指定目录下的文件及文件夹
    public static String getDirectoryFromHDFS(String destDire) {
        return null;
    }


    /**
     *上传服务器中的文件到hdfs文件系统
     * @param srcServer 服务器中的文件地址
     * @param dstHdfs hdfs文件系统地址
     * @throws IOException
     */
    public static String copyFromLocal(String srcServer, String dstHdfs){

        try{
            FileSystem fs = FileSystem.get(conf);
            //文件系统复制函数，false参数为删除源文件
            fs.copyFromLocalFile(false,new Path(srcServer),new Path(dstHdfs));
            fs.close();
            System.out.println("---------------------上传成功----------");

            return dstHdfs;
        }catch (IOException e){
            System.out.println("---------------------上传文件到HDFS时出现异常------------------------"
                    + e.getMessage());
        }

        return null;
    }

    /**
     *从hdfs文件系统复制文件到服务器
     * @param destServer 服务器中的文件地址
     * @param srcHdfs hdfs文件地址
     * @throws IOException
     */
    public static String copyToLocal(String srcHdfs,String destServer){
        try {
            FileSystem fs = FileSystem.get(conf);
            fs.copyToLocalFile(new Path(srcHdfs),new Path(destServer));
            fs.close();
            System.out.println("---------------------成功从HDFS获取文件到服务器,存储路径:" + destServer);
        }catch (IOException e){
            System.out.println("---------------------从HDFS获取文件时出现异常------------------------"
                    + e.getMessage());
        }

        return null;
    }


    /**
     *获取Configuration对象
     *
     */
    public static Configuration getConf() {

        return conf;
    }

    //TODO 清除Job
    public static void cleanJob(){
        System.out.println("有异常抛出了");
    }
}
