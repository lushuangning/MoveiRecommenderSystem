package cn.cuit.lsn.service.impl;

import cn.cuit.lsn.service.UploadService;
import cn.cuit.lsn.util.TransformHDFStoMysqlThread;
import cn.cuit.lsn.util.UploadDataFileToServer;
import cn.cuit.lsn.util.hdfs.HDFSOperation;
import cn.cuit.lsn.util.hive.SaveToHive;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service("uploadService")
public class UploadServiceImpl implements UploadService {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(UploadServiceImpl.class);

    @Override
    public String uploadToServer(MultipartFile dataFile,String dstSever) {

        if (!dataFile.isEmpty()){
            //上传路径
//            String path = request.getSession().getServletContext().getRealPath("/static/fileUpload/");

            String fileName = dataFile.getOriginalFilename();

            if (UploadDataFileToServer.upload(dataFile, dstSever, fileName)){
                System.out.println("--------------------------------文件保存为--------------------------------" + dstSever + fileName);
//                logger.info();
                return dstSever + fileName;
            }

        }

        return "";
    }

    @Override
    public String uploadToHDFS(String srcServer,String dstHdfs) {
       return HDFSOperation.copyFromLocal(srcServer,dstHdfs);
    }

    @Override
    public void transfromToMysql(String fromDir,String toTable) {
        TransformHDFStoMysqlThread thread = new TransformHDFStoMysqlThread(fromDir,toTable);
        thread.start();
    }

    @Override
    public void saveToHive(String file,String table) {
        if (file != null) {
            SaveToHive.save(file,table);
        }
    }
}
