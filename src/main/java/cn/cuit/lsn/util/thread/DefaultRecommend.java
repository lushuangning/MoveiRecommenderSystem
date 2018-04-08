package cn.cuit.lsn.util.thread;

import cn.cuit.lsn.util.hdfs.HDFSOperation;
import org.apache.hadoop.util.ToolRunner;
import org.apache.mahout.cf.taste.hadoop.item.RecommenderJob;

public class DefaultRecommend extends Thread {

    @Override
    public void run() {

        /**
         * --input(path): 存储用户偏好数据的目录，该目录下可以包含一个或多个存储用户偏好数据的文本文件；
         --output(path): 结算结果的输出目录
         --numRecommendations (integer): 为每个用户推荐的item数量，默认为10
         --usersFile (path): 指定一个包含了一个或多个存储userID的文件路径，仅为该路径下所有文件包含的userID做推荐计算 (该选项可选)
         --itemsFile (path): 指定一个包含了一个或多个存储itemID的文件路径，仅为该路径下所有文件包含的itemID做推荐计算 (该选项可选)
         --filterFile (path): 指定一个路径，该路径下的文件包含了[userID,itemID]值对，userID和itemID用逗号分隔。计算结果将不会为user推荐[userID,itemID]值对中包含的item (该选项可选)
         --booleanData (boolean): 如果输入数据不包含偏好数值，则将该参数设置为true，默认为false
         --maxPrefsPerUser (integer): 在最后计算推荐结果的阶段，针对每一个user使用的偏好数据的最大数量，默认为10
         --minPrefsPerUser (integer): 在相似度计算中，忽略所有偏好数据量少于该值的用户，默认为1
         --maxSimilaritiesPerItem (integer): 针对每个item的相似度最大值，默认为100
         --maxPrefsPerUserInItemSimilarity (integer): 在item相似度计算阶段，针对每个用户考虑的偏好数据最大数量，默认为1000
         --similarityClassname (classname): 向量相似度计算类
         --outputPathForSimilarityMatrix：SimilarityMatrix输出目录
         --randomSeed：随机种子 –sequencefileOutput：序列文件输出路径
         --tempDir (path): 存储临时文件的目录，默认为当前用户的home目录下的temp目录
         --startPhase
         --endPhase
         --threshold (double): 忽略相似度低于该阀值的item对
         */

        String [] args = {
                "--input","/user/hive/warehouse/ratings/ratings.csv",
                "--output","output/default_recommends",
                "--numRecommendations","10",
                "--maxSimilaritiesPerItem","100",
                "--minPrefsPerUser","1",
                "--similarityClassname", "SIMILARITY_PEARSON_CORRELATION",
                "--tempDir","temp"
        };

        try {
            ToolRunner.run(HDFSOperation.getConf(),new RecommenderJob(),args);
        }catch (Exception e){
            //TODO Auto-generated catch block
            //e.printStackTrace();
            HDFSOperation.cleanJob();
            System.out.println(e.getMessage());
        }
    }

}
