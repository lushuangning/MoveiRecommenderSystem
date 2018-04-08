package cn.cuit.lsn.controller;

import cn.cuit.lsn.pojo.FileConfirm;
import cn.cuit.lsn.service.RecommenderService;
import cn.cuit.lsn.service.UploadService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/file")
public class UploadController {
    //上传到服务器的目录
    private static final String dstSever = "/home/lushuangning/DataFile/";
    //上传到HDFS的目录
    private static final String ratingsDstHdfs = "input/ratings/";
    private static final String moviesDstHdfs = "input/movies/";


    private final UploadService uploadService;
    private final RecommenderService recommenderService;


    @Autowired
    public UploadController(UploadService uploadService,RecommenderService recommenderService) {
        this.uploadService = uploadService;
        this.recommenderService = recommenderService;
    }

    @RequestMapping("/dataFile")
    @ResponseBody
    public String upload(MultipartFile[] dataFile){
        List<String> fileName = new ArrayList<>();

        for (int i = 0;i < dataFile.length; i++){
            fileName.add(uploadService.uploadToServer(dataFile[i],dstSever));
        }

        for(String name:fileName){
            System.out.println("----------------" + name);
        }

        return JSON.toJSONString("OK");
    }

    @RequestMapping("/confirm")
    @ResponseBody
    public String confirm(@RequestBody FileConfirm fileConfirm){
        System.out.println("评分文件为" + fileConfirm.getRatings());
        System.out.println("详情文件为" + fileConfirm.getMovies());
        System.out.println("链接文件为" + fileConfirm.getLinks());

        String ratingsDir = uploadService.uploadToHDFS(dstSever + fileConfirm.getRatings(),ratingsDstHdfs + fileConfirm.getRatings());
        String moviesDir = uploadService.uploadToHDFS(dstSever + fileConfirm.getMovies(),moviesDstHdfs + fileConfirm.getMovies());
        System.out.println("ratings在HDFS上的目录为:" + ratingsDir);
        System.out.println("movies在HDFS上的目录为:" + moviesDir);

//        uploadService.transfromToMysql(ratingsDstHdfs,"ratings");
//        uploadService.transfromToMysql(moviesDstHdfs,"movies");

        uploadService.saveToHive(ratingsDir,"ratings");
        uploadService.saveToHive(moviesDir,"movies");

        //开启默认推荐
        recommenderService.defaultRecommend();

        return "OK";
    }

}
