package cn.cuit.lsn.pojo;

import org.springframework.stereotype.Component;

@Component
public class RecommenderArgs {

    private String whichCF;
    private int numRecommendations;
    private String similarityClassname;
    private int maxPrefsPerUser;
    private int minPrefsPerUser;
    private int maxSimilaritiesPerItem;

    public String getWhichCF() {
        return whichCF;
    }

    public void setWhichCF(String whichCF) {
        this.whichCF = whichCF;
    }

    public int getNumRecommendations() {
        return numRecommendations;
    }

    public void setNumRecommendations(int numRecommendations) {
        this.numRecommendations = numRecommendations;
    }

    public String getSimilarityClassname() {
        return similarityClassname;
    }

    public void setSimilarityClassname(String similarityClassname) {
        this.similarityClassname = similarityClassname;
    }

    public int getMaxPrefsPerUser() {
        return maxPrefsPerUser;
    }

    public void setMaxPrefsPerUser(int maxPrefsPerUser) {
        this.maxPrefsPerUser = maxPrefsPerUser;
    }

    public int getMinPrefsPerUser() {
        return minPrefsPerUser;
    }

    public void setMinPrefsPerUser(int minPrefsPerUser) {
        this.minPrefsPerUser = minPrefsPerUser;
    }

    public int getMaxSimilaritiesPerItem() {
        return maxSimilaritiesPerItem;
    }

    public void setMaxSimilaritiesPerItem(int maxSimilaritiesPerItem) {
        this.maxSimilaritiesPerItem = maxSimilaritiesPerItem;
    }
}
