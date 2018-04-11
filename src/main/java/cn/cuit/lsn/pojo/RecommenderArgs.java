package cn.cuit.lsn.pojo;

import org.springframework.stereotype.Component;

@Component
public class RecommenderArgs {

    private String whichCF;
    private String similarityClassname;
    private int userId;
    private int nearestNeighbor;
    private int recommendNum;

    public String getWhichCF() {
        return whichCF;
    }

    public void setWhichCF(String whichCF) {
        this.whichCF = whichCF;
    }

    public String getSimilarityClassname() {
        return similarityClassname;
    }

    public void setSimilarityClassname(String similarityClassname) {
        this.similarityClassname = similarityClassname;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNearestNeighbor() {
        return nearestNeighbor;
    }

    public void setNearestNeighbor(int nearestNeighbor) {
        this.nearestNeighbor = nearestNeighbor;
    }

    public int getRecommendNum() {
        return recommendNum;
    }

    public void setRecommendNum(int recommendNum) {
        this.recommendNum = recommendNum;
    }
}
