package cn.cuit.lsn.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class UploadDataFileToServer {


    public static boolean upload(MultipartFile file, String path, String fileName){
        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
            System.out.println("--------------------------------文件上传成功--------------------------------");
            return true;
        } catch (IllegalStateException | IOException e) {
            System.out.println("--------------------------------文件上传异常--------------------------------"
                    + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

}
