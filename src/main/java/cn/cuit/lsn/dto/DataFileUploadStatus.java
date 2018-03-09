package cn.cuit.lsn.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class DataFileUploadStatus {

    public DataFileUploadStatus(){}

    private boolean status;

    private String srcServer;

    private String srcHdfs;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public String getSrcServer() {
        return srcServer;
    }

    public void setSrcServer(String srcServer) {
        this.srcServer = srcServer;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getSrcHdfs() {
        return srcHdfs;

    }

    public void setSrcHdfs(String srcHdfs) {
        this.srcHdfs = srcHdfs;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
