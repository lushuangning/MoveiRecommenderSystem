package cn.cuit.lsn.util.hive;

import org.apache.sqoop.client.SqoopClient;
import org.apache.sqoop.model.*;
import org.apache.sqoop.submission.counter.Counter;
import org.apache.sqoop.submission.counter.CounterGroup;
import org.apache.sqoop.submission.counter.Counters;
import org.apache.sqoop.validation.Status;

import java.util.UUID;

public class SqoopUtil {
    public static SqoopClient client;
    public static MLink hdfsLink;
    public static MLink mysqlLink;

    static{
        //对应于终端中的set server --host localhost --port 12000 --weapp sqoop
        client = new SqoopClient("http://localhost:12000/sqoop/");
        hdfsLink = createHdfsLink();
        mysqlLink = createMysqlLink();
    }


    //建立mysql链接
    public static MLink createMysqlLink(){
        MLink link = client.createLink("generic-hive-connector");

        link.setName("hive-link" + UUID.randomUUID().toString().substring(0,10));
        link.setCreationUser("lushuangning");
        MLinkConfig linkConfig = link.getConnectorLinkConfig();
        linkConfig.getStringInput("linkConfig.connectionString").setValue("hive:mysql://115.159.40.239:3306/movie_recommender");
        linkConfig.getStringInput("linkConfig.jdbcDriver").setValue("com.mysql.hive.Driver");
        linkConfig.getStringInput("linkConfig.username").setValue("root");
        linkConfig.getStringInput("linkConfig.password").setValue("135569");
        linkConfig.getStringInput("dialect.identifierEnclose").setValue(" ");
        Status status = client.saveLink(link);

        return linkStatus(link,status);
    }

    //建立HDFS链接
    public static MLink createHdfsLink(){
        MLink link = client.createLink("hdfs-connector");
        link.setName("hdfs-link" + UUID.randomUUID().toString().substring(0, 10));
        link.setCreationUser("xigua");
        MLinkConfig linkConfig = link.getConnectorLinkConfig();
        //hdfs目录
        linkConfig.getStringInput("linkConfig.uri").setValue("hdfs://localhost");
        //hadoop的配置文件目录
        linkConfig.getStringInput("linkConfig.confDir").setValue("/usr/local/hadoop-2.7.5/etc/hadoop");
        Status status = client.saveLink(link);

        return linkStatus(link,status);
    }


    //建立传输的job
    public static String createHdfsToMysqlJob(MLink fromLink,MLink toLink,String fromDir,String toTable){
        MJob job = client.createJob(fromLink.getName(),toLink.getName());
        job.setName("HdfsToMysql-job" + UUID.randomUUID());
        job.setCreationUser("lushuangning");
        MFromConfig fromConfig = job.getFromJobConfig();
        //hdfs文件目录
        fromConfig.getStringInput("fromJobConfig.inputDirectory")
                .setValue(fromDir);
        MToConfig toJobConfig = job.getToJobConfig();
        //数据库
        toJobConfig.getStringInput("toJobConfig.schemaName")
                .setValue("movie_recommender");
        //数据库表
        toJobConfig.getStringInput("toJobConfig.tableName")
                .setValue(toTable);

//        toJobConfig.getListInput("toJobConfig.columnList").setValue(Arrays.asList("id", "name", "alerts", "cron"));
        MDriverConfig driverConfig = job.getDriverConfig();
        driverConfig.getIntegerInput("throttlingConfig.numExtractors").setValue(1);
        Status status = client.saveJob(job);

        return jobStatus(job,status);

    }


    private static MLink linkStatus(MLink link,Status status){
        if (status.canProceed()) {
            System.out.println("Created Link with Link Name : " + link.getName());
            return link;
        } else {
            System.out.println("Something went wrong creating the link");
            return null;
        }
    }

    private static String jobStatus(MJob job,Status status){
        if (status.canProceed()) {
            System.out.println("Created Job with Job Name: " + job.getName());
            return job.getName();
        } else {
            System.out.println("Something went wrong creating the job");
            return null;
        }
    }

    public static void startJob(String jobName){
        MSubmission submission = client.startJob(jobName);
        System.out.println("Job Submission Status : " + submission.getStatus());
        if (submission.getStatus().isRunning() && submission.getProgress() != -1) {
            System.out.println("Progress : " + String.format("%.2f %%", submission.getProgress() * 100));
        }

        System.out.println("Hadoop job id :" + submission.getExternalJobId());
        System.out.println("Job link : " + submission.getExternalLink());

        Counters counters = submission.getCounters();
        if (counters != null) {
            System.out.println("Counters:");
            for (CounterGroup group : counters) {
                System.out.print("\t");
                System.out.println(group.getName());
                for (Counter counter : group) {
                    System.out.print("\t\t");
                    System.out.print(counter.getName());
                    System.out.print(": ");
                    System.out.println(counter.getValue());
                }
            }
        }

    }
}
