package cn.cuit.lsn.service;

import org.apache.hadoop.conf.Configuration;
import org.springframework.stereotype.Repository;

import java.io.IOException;

/**
 * @version 0.3.0
 * @author 路双宁
 * 已废弃
 */

@Deprecated
public interface HDFSOperationService {
    /**
     *上传服务器中的文件到hdfs文件系统
     * @param srcServer 服务器中的文件地址
     * @param dstHdfs hdfs文件系统地址
     * @throws IOException
     */
    String copyFromLocal(String srcServer, String dstHdfs);

    /**
     *在hdfs文件系统中创建文件夹
     * @param dstHdfs 创建地址
     * @return 创建后的文件夹地址
     * @throws IOException
     */
    String mkdir(String dstHdfs);

    /**
     *删除hdfs文件系统中的指定文件或文件夹
     * @param destHdfs 待删除文件的地址
     * @throws IOException
     */
    void delete(String destHdfs);

    /**
     * 遍历指定目录下的所有文件信息
     * @param destDire 文件夹目录
     * @return 文件夹下的文件信息，以json格式返回
     */
    String getDirectoryFromHDFS(String destDire);

    Configuration getConf();
}
