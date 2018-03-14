package cn.cuit.lsn.controller;

import cn.cuit.lsn.dto.DataFileUploadStatus;
import cn.cuit.lsn.service.UploadService;
import cn.cuit.lsn.util.HDFSOperation;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/file")
public class UploadController {
    private static final String dstSever = "/tmp/";
    private static final String dstHdfs = "input/test/";


    private final UploadService uploadService;

    @Autowired
    public UploadController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @RequestMapping("/dataFile")
    @ResponseBody
    public String upload(MultipartFile dataFile){
        String srcServer = uploadService.uploadDataFile(dataFile,dstSever);
        String srcHdfs = HDFSOperation.copyFromLocal(srcServer,dstHdfs);
        DataFileUploadStatus dataFileUploadStatus = new DataFileUploadStatus();
        dataFileUploadStatus.setCreateTime(new Date());
        dataFileUploadStatus.setSrcHdfs(srcHdfs);
        dataFileUploadStatus.setSrcServer(srcServer);
        dataFileUploadStatus.setStatus(true);

        return JSON.toJSONString(dataFileUploadStatus);
    }
}
