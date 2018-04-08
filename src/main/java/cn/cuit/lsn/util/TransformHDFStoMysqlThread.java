package cn.cuit.lsn.util;

import cn.cuit.lsn.util.hive.SqoopUtil;

import static cn.cuit.lsn.util.hive.SqoopUtil.createHdfsToMysqlJob;

@Deprecated
public class TransformHDFStoMysqlThread extends Thread {

    public String fromDir;
    public String toTable;

    public TransformHDFStoMysqlThread(String fromDir,String toTable){
        this.fromDir = fromDir;
        this.toTable = toTable;
    }

    @Override
    public void run() {
        SqoopUtil.startJob(createHdfsToMysqlJob(SqoopUtil.hdfsLink,SqoopUtil.mysqlLink,fromDir,toTable));
    }

}
