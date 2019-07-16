package com.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;

public class FTPuitl {
    private String hostName="192.168.133.129";
    private int port=21;
    private String userName="ftpuser";
    private String password="running549166";
    private String path="home/ftpuser/image/";
    //获取链接
    public FTPClient getConnectionFTP() throws IOException {
        FTPClient ftpClient=new FTPClient();
        ftpClient.connect(hostName,port);
        //下面三行代码必须要，而且不能改变编码格式，否则不能正确下载中文文件
        ftpClient.setControlEncoding("GBK");
        FTPClientConfig conf=new FTPClientConfig(FTPClientConfig.SYST_NT);
        conf.setServerLanguageCode("zh");
        //登陆
        ftpClient.login(userName,password);
        if(!FTPReply.isPositiveCompletion(ftpClient.getReplyCode()));
        return ftpClient;

    }
    //关闭连接
    public boolean closeFTP(FTPClient ftpClient){
        if(ftpClient.isConnected()){
            try{
                ftpClient.disconnect();
                return true;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }
    //上传文件
    public void uploadFile(FTPClient ftpClient, InputStream inputStream){
        try{
            //让客户端告诉服务器开通一个端口用来数据传输
            ftpClient.enterLocalPassiveMode();
            //获取文件目录所有文件
            //指定上传目录
            ftpClient.changeWorkingDirectory("home/ftpuser/image/");
            //指定文件类型
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.storeFile("hello.jpg",inputStream);
            inputStream.close();
            ftpClient.logout();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
