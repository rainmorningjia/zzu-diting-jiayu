package com.zzu.diting.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


/**
 * @author :wb-jcy525678
 * @description:
 * @date : 2019/4/4 14:29
 */
public class OSSClientUtil {
    // log日志
    private static Logger logger = Logger.getLogger(OSSClientUtil.class);
    private static String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
    private static String accessKeyId = "LTAIsFJTIRCdA8Ru";
    private static String accessKeySecret = "fFlfijBvG2SljGTPhA8LCBA5QvwSF5";
    private static String bucketName = "zzu-diting";
    private static String FOLDER = "user/";
    public static final String FORMAT = new SimpleDateFormat("yyyyMMdd").format(new Date());
    public static final String FORMATS = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

    public static OSSClient getOSSClient() {
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ossClient.createBucket(bucketName);
        return ossClient;
    }

    public static void stopOssClinet() {
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ossClient.shutdown();
    }

    public static String createBucketName(OSSClient ossClient, String bucketName) {
        // 存储空间
        final String bucketNames = bucketName;
        if (!ossClient.doesBucketExist(bucketName)) {
            // 创建存储空间
            Bucket bucket = ossClient.createBucket(bucketName);
            logger.info("创建存储空间成功");
            return bucket.getName();
        }
        return bucketNames;
    }

    public static String createFolder(OSSClient ossClient, String bucketName, String folder) {
        // 文件夹名
        final String keySuffixWithSlash = folder;
        // 判断文件夹是否存在，不存在则创建
        if (!ossClient.doesObjectExist(bucketName, keySuffixWithSlash)) {
            // 创建文件夹
            ossClient.putObject(bucketName, keySuffixWithSlash, new ByteArrayInputStream(new byte[0]));
            logger.info("创建文件夹成功");
            // 得到文件夹名
            OSSObject object = ossClient.getObject(bucketName, keySuffixWithSlash);
            String fileDir = object.getKey();
            return fileDir;
        }
        return keySuffixWithSlash;
    }
    /**
     * 上传图片至OSS 文件流
     *
     * @param ossClient
     *            oss连接
     * @param file
     *            上传文件（文件全路径如：D:\\image\\cake.jpg）
     * @param bucketName
     *            存储空间
     *            模拟文件夹名 如"qj_nanjing/"
     * @return String 返回的唯一MD5数字签名
     */
    public static String[] uploadObject2OSS(OSSClient ossClient, File file, String bucketName, String user_id) {
        String resultStr = null;
        String[] fo = new String[] { "", "" };
        try {
            // 以输入流的形式上传文件
            String folder = "";
            folder = FOLDER + user_id + "/" + FORMAT + "/";
            InputStream is = new FileInputStream(file);
            // 文件名
            String timefile = FORMATS;
            String fileName = file.getName();
            fileName = timefile + fileName.substring(fileName.lastIndexOf("."));
            logger.info("上传到路径" + folder + fileName);
            // 文件大小
            Long fileSize = file.length();
            // 创建上传Object的Metadata
            ObjectMetadata metadata = new ObjectMetadata();
            // 上传的文件的长度
            metadata.setContentLength(is.available());
            // 指定该Object被下载时的网页的缓存行为
            metadata.setCacheControl("no-cache");
            // 指定该Object下设置Header
            metadata.setHeader("Pragma", "no-cache");
            // 指定该Object被下载时的内容编码格式
            metadata.setContentEncoding("utf-8");
            // 文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
            // 如果没有扩展名则填默认值application/octet-stream
            metadata.setContentType(getContentType(fileName));
            // 指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
            metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");
            // 上传文件 (上传文件流的形式)
            PutObjectResult putResult = ossClient.putObject(bucketName, folder + fileName, is, metadata);
            // 解析结果
            resultStr = putResult.getETag();
            fo[1] = folder + fileName;
            fo[0] = resultStr;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("上传阿里云OSS服务器异常." + e.getMessage(), e);
        }
        return fo;
    }
    /**
     * 通过文件名判断并获取OSS服务文件上传时文件的contentType
     *
     * @param fileName
     *            文件名
     * @return 文件的contentType
     */
    public static String getContentType(String fileName) {
        // 文件的后缀名
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        if (".bmp".equalsIgnoreCase(fileExtension)) {
            return "image/bmp";
        }
        if (".gif".equalsIgnoreCase(fileExtension)) {
            return "image/gif";
        }
        if (".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension)
                || ".png".equalsIgnoreCase(fileExtension)) {
            return "image/jpeg";
        }
        if (".html".equalsIgnoreCase(fileExtension)) {
            return "text/html";
        }
        if (".txt".equalsIgnoreCase(fileExtension)) {
            return "text/plain";
        }
        if (".vsd".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.visio";
        }
        if (".ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if (".doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension)) {
            return "application/msword";
        }
        if (".xml".equalsIgnoreCase(fileExtension)) {
            return "text/xml";
        }
        if (".mp4".equalsIgnoreCase(fileExtension)) {
            return "video/mp4";
        }
        // 默认返回类型
        return "image/jpeg";
    }
    public static String getUrl(OSSClient ossClient, String bucketName, String fileName) {
        // 设置URL过期时间为10年 3600l* 1000*24*365*10
        Date expiration = new Date(System.currentTimeMillis()+ 3600L* 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, fileName, expiration);
        if (url != null) {
            return url.toString();
        }
        return "获网址路径出错";
    }
    public String urlpath(String user_id, String files) {
        OSSClient ossClient = OSSClientUtil.getOSSClient();
        String[] file = files.split(",");
        String url = "";
        for (String filename : file) {
            // System.out.println("filename:"+filename);
            File filess = new File(filename);
            String[] s = OSSClientUtil.uploadObject2OSS(ossClient, filess, bucketName, user_id);
            logger.info("上传后的文件MD5数字唯一签名:" + s[0]);
            logger.info("文件路径:" + s[1]);
            url = OSSClientUtil.getUrl(ossClient, bucketName, s[1]);
            logger.info("访问网址路径:" + url);
        }
        // 上传后的文件MD5数字唯一签名:40F4131427068E08451D37F02021473A
        return url;
    }
    // 测试
    public static void main(String[] args) throws Exception {
        OSSClientUtil t = new OSSClientUtil();
        OSSClient client=OSSClientUtil.getOSSClient();
        File file=new File("C:\\Users\\wb-jcy525678\\Desktop\\personal files\\设计图\\系统架构图02版 (1).png");
        String[] s=OSSClientUtil.uploadObject2OSS(client,file,bucketName,"2132");
        String url=OSSClientUtil.getUrl(client,bucketName,s[1]);
        System.out.println(url);
    }
        }
