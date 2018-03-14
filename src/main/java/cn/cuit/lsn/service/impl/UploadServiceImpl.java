package cn.cuit.lsn.service.impl;

import cn.cuit.lsn.service.UploadService;
import cn.cuit.lsn.util.UploadDataFileToServer;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service("uploadService")
public class UploadServiceImpl implements UploadService {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(UploadServiceImpl.class);

    @Override
    public String uploadDataFile(MultipartFile dataFile,String dstSever) {



        if (!dataFile.isEmpty()){
            //上传路径
//            String path = request.getSession().getServletContext().getRealPath("/static/fileUpload/");

            String fileName = dataFile.getOriginalFilename();

            if (UploadDataFileToServer.upload(dataFile, dstSever, fileName)){
                logger.info("--------------------------------文件保存为--------------------------------" + dstSever + fileName);
                return dstSever + fileName;
            }

        }

        return "";

    }


}
