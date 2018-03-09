package cn.cuit.lsn.controller;

import cn.cuit.lsn.service.UploadService;
import cn.cuit.lsn.service.impl.HDFSOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class UploadController {
    private static final String dstSever = "/tmp/";
    private static final String dstHdfs = "input/test";

    @Autowired
    private UploadService uploadService;
//    private HDFSOperation hdfsOperate;


    private static final Logger logger = Logger.getLogger(UploadController.class);

    @RequestMapping("/dataFile")
    public String upload(MultipartFile dataFile){
        String srcServer = uploadService.uploadDataFile(dataFile,dstSever);
        HDFSOperation.copyFromLocal(srcServer,dstHdfs);


        return "index";
    }
}
