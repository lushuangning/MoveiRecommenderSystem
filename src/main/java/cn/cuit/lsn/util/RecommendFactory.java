package cn.cuit.lsn.util;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.*;
import org.apache.mahout.cf.taste.impl.common.FastByIDMap;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.GenericRecommenderIRStatsEvaluator;
import org.apache.mahout.cf.taste.impl.eval.RMSRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.GenericBooleanPrefDataModel;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericBooleanPrefItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericBooleanPrefUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.svd.Factorizer;
import org.apache.mahout.cf.taste.impl.recommender.svd.SVDRecommender;
import org.apache.mahout.cf.taste.impl.similarity.*;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.PreferenceArray;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 
 * @author bsspirit@gmail.com 
 * @link http://blog.fens.me/mahout-recommendation-api/
 */
public final class RecommendFactory {

    /**
     * build Data model from file
     * @param file 文件地址
     * @param delimiterRegex 数据分隔符
     */
    public static DataModel buildDataModel(String file,String delimiterRegex) throws TasteException, IOException {
        return new FileDataModel(new File(file),delimiterRegex);
    }

    /**
     * 有的时候，我们会忽略用户的喜好值，仅仅只关心用户和物品之间存不存在关联关系，这种关联关系在Mahout里面叫做“boolean preference”。
     * 之所以会有这类喜好，是因为用户和物品的关联要么存在，要么不存在，记住只是表示关联关系存不存在，不代表喜欢和不喜欢。
     * 实际上一条“boolean preference”可有三个状态：喜欢、不喜欢、没有任何关系。GenericBooleanPrefDataModel没存储喜好值，它默认用户对物品的喜好值都是1.0
     * @param file 文件地址
     * @return
     * @throws TasteException
     * @throws IOException
     */
    public static DataModel buildDataModelNoPref(String file) throws TasteException, IOException {
        return new GenericBooleanPrefDataModel(GenericBooleanPrefDataModel.toDataMap(new FileDataModel(new File(file))));
    }

    public static DataModelBuilder buildDataModelNoPrefBuilder() {
        return new DataModelBuilder() {
            @Override
            public DataModel buildDataModel(FastByIDMap<PreferenceArray> trainingData) {
                return new GenericBooleanPrefDataModel(GenericBooleanPrefDataModel.toDataMap(trainingData));
            }
        };
    }

    /**
     * similarity
     */
    public enum SIMILARITY {
        PEARSON, EUCLIDEAN, COSINE, TANIMOTO, LOGLIKELIHOOD, SPEARMAN, CITYBLOCK, FARTHEST_NEIGHBOR_CLUSTER, NEAREST_NEIGHBOR_CLUSTER
    }

    public static UserSimilarity userSimilarity(SIMILARITY type, DataModel m) throws TasteException {
        switch (type) {
        case PEARSON:
            return new PearsonCorrelationSimilarity(m);
        case COSINE:
            return new UncenteredCosineSimilarity(m);
        case TANIMOTO:
            return new TanimotoCoefficientSimilarity(m);
        case LOGLIKELIHOOD:
            return new LogLikelihoodSimilarity(m);
        case SPEARMAN:
            return new SpearmanCorrelationSimilarity(m);
        case CITYBLOCK:
            return new CityBlockSimilarity(m);
        case EUCLIDEAN:
        default:
            return new EuclideanDistanceSimilarity(m);
        }
    }

    public static ItemSimilarity itemSimilarity(SIMILARITY type, DataModel m) throws TasteException {
        switch (type) {
        case PEARSON:
            return new PearsonCorrelationSimilarity(m);
        case COSINE:
            return new UncenteredCosineSimilarity(m);
        case TANIMOTO:
            return new TanimotoCoefficientSimilarity(m);
        case LOGLIKELIHOOD:
            return new LogLikelihoodSimilarity(m);
        case CITYBLOCK:
            return new CityBlockSimilarity(m);
        case EUCLIDEAN:
        default:
            return new EuclideanDistanceSimilarity(m);
        }
    }


    /**
     * neighborhood
     */
    public enum NEIGHBORHOOD {
        NEAREST, THRESHOLD
    }

    public static UserNeighborhood userNeighborhood(NEIGHBORHOOD type, UserSimilarity s, DataModel m, double num) throws TasteException {
        switch (type) {
        case NEAREST:
            return new NearestNUserNeighborhood((int) num, s, m);
        case THRESHOLD:
        default:
            return new ThresholdUserNeighborhood(num, s, m);
        }
    }

    /**
     * recommendation
     */
    public enum RECOMMENDER {
        USER, ITEM
    }

    public static RecommenderBuilder userRecommender(final UserSimilarity us, final UserNeighborhood un, boolean pref) throws TasteException {
        return pref ? new RecommenderBuilder() {
            @Override
            public Recommender buildRecommender(DataModel model) throws TasteException {
                return new GenericUserBasedRecommender(model, un, us);
            }
        } : new RecommenderBuilder() {
            @Override
            public Recommender buildRecommender(DataModel model) throws TasteException {
                return new GenericBooleanPrefUserBasedRecommender(model, un, us);
            }
        };
    }

    public static RecommenderBuilder itemRecommender(final ItemSimilarity is, boolean pref) throws TasteException {
        return pref ? new RecommenderBuilder() {
            @Override
            public Recommender buildRecommender(DataModel model) throws TasteException {
                return new GenericItemBasedRecommender(model, is);
            }
        } : new RecommenderBuilder() {
            @Override
            public Recommender buildRecommender(DataModel model) throws TasteException {
                return new GenericBooleanPrefItemBasedRecommender(model, is);
            }
        };
    }



    public static RecommenderBuilder svdRecommender(final Factorizer factorizer) throws TasteException {
        return new RecommenderBuilder() {
            @Override
            public Recommender buildRecommender(DataModel dataModel) throws TasteException {
                return new SVDRecommender(dataModel, factorizer);
            }
        };
    }



    public static void showItems(long uid, List<RecommendedItem> recommendations, boolean skip) {
        if (!skip || recommendations.size() > 0) {
//            System.out.printf("%s,", uid);
            for (RecommendedItem recommendation : recommendations) {
                System.out.printf("%s,", uid);
                System.out.printf("%s,%f\n", recommendation.getItemID(), recommendation.getValue());
            }
        }
    }

    /**
     * evaluator
     */
    public enum EVALUATOR {
        AVERAGE_ABSOLUTE_DIFFERENCE, RMS
    }

    /**
     *
     * @param type 评估指标,AVERAGE_ABSOLUTE_DIFFERENCE为平方根误差,即MAE,RMS即均方根误差
     * @return
     */
    public static RecommenderEvaluator buildEvaluator(EVALUATOR type) {
        switch (type) {
        case RMS:
            return new RMSRecommenderEvaluator();
        case AVERAGE_ABSOLUTE_DIFFERENCE:
        default:
            return new AverageAbsoluteDifferenceRecommenderEvaluator();
        }
    }


    public static void evaluate(EVALUATOR type, RecommenderBuilder rb, DataModelBuilder mb, DataModel dm, double trainPt, double evaluationPt) throws TasteException {
        System.out.printf("%s Evaluater Score:%s\n", type.toString(), buildEvaluator(type).evaluate(rb, mb, dm, trainPt, evaluationPt));
    }


    public static void evaluate(RecommenderEvaluator re, RecommenderBuilder rb, DataModelBuilder mb, DataModel dm, double trainPt, double evaluationPt) throws TasteException {
        System.out.printf("Evaluater Score:%s\n", re.evaluate(rb, mb, dm, trainPt, evaluationPt));
    }



    /**
     * statsEvaluator
     */
    public static void statsEvaluator(RecommenderBuilder rb, DataModelBuilder mb, DataModel m, int topn) throws TasteException {
        RecommenderIRStatsEvaluator evaluator = new GenericRecommenderIRStatsEvaluator();
        //rb:推荐模型构造器
        //mb:数据模型构造器
        //m:数据集
        //at:TOP N
        //relevanceThreshold:相关临界值,分值达到多少认为用户感兴趣呢，就需要一个阈值，如果没有指定值，框架会为每个用户取一个阈值，它等于该用户的平均偏好值加上标准方差
        //evaluationPercentage:计算多少用户(0.1代表10%)
        IRStatistics stats = evaluator.evaluate(rb, mb, m, null, topn, GenericRecommenderIRStatsEvaluator.CHOOSE_THRESHOLD, 1.0);
        // System.out.printf("Recommender IR Evaluator: %s\n", stats);
        System.out.printf("Recommender IR Evaluator: [Precision:%s,Recall:%s]\n", stats.getPrecision(), stats.getRecall());
    }

}
