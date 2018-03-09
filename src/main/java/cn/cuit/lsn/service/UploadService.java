package cn.cuit.lsn.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 上传文件到服务器
 * @version 0.1.0
 * @author 路双宁
 */

public interface UploadService {

    /**
     * 上传文件
     * @param dataFile 数据文件
     * @param dstSever 目标路径
     * @return 文件路径+文件名
     */
    String uploadDataFile(MultipartFile dataFile, String dstSever);
}
