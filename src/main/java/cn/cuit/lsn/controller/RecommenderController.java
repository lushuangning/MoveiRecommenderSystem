package cn.cuit.lsn.controller;

import cn.cuit.lsn.pojo.RecommenderArgs;
import cn.cuit.lsn.service.RecommenderService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/recommend")
public class RecommenderController {

    private final RecommenderService recommenderService;

    @Autowired
    public RecommenderController(RecommenderService recommenderService){
        this.recommenderService = recommenderService;
    }

    @RequestMapping(value = "/setting",produces = "application/json; charset=utf-8")
    public void setting(@RequestBody RecommenderArgs recommenderArgs){

        System.out.println("-------------------------------------"
                + "\nuserId:" + recommenderArgs.getUserId()
                + "\nsimilarityClassname:" + recommenderArgs.getSimilarityClassname()
                + "\nnearestNeighbor:" + recommenderArgs.getNearestNeighbor()
                + "\nrecommendNum:" + recommenderArgs.getRecommendNum()
                + "\nwhichCF:" + recommenderArgs.getWhichCF()
        );

        recommenderService.customRecommend(recommenderArgs);
    }

    @RequestMapping(value = "/show")
    @ResponseBody
    public String show(){
//        String data = "{" + "\"total\":200," + "\"rows\":" + JSON.toJSONString(recommenderService.showResult(1)) + "}";
        String data = "{" + "\"data\":" + JSON.toJSONString(recommenderService.showResult(1)) + "}";
        System.out.println(data);
        return data;
    }
}
