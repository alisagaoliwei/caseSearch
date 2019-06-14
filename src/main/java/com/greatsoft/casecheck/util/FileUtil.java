package com.greatsoft.casecheck.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @Description: 文件上传工具类
 * @Author: yangzhanbiao
 * @CreateDate: 2019/5/7 12:48 PM
 */
public class FileUtil {

    /**
     * 将文件上传到服务器并返回url
     *
     * @param multipartFile
     * @param savePath
     * @return
     */
    public static String saveContentDescriptionFile(MultipartFile multipartFile, String savePath) {
        File file = new File(savePath);
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
        }
        String url = null;
        // 获得原始文件名
        String fileName = multipartFile.getOriginalFilename();
        if (fileName != null && !"".equals(fileName.trim())) {
            fileName = SerialNoUtil.getSerialNo() + fileName;
            url = savePath + File.separator + fileName;
            FileOutputStream out = null;
            InputStream in = null;
            try {
                in = multipartFile.getInputStream();
                out = new FileOutputStream(url);
                byte buffer[] = new byte[1024];
                int len = 0;
                while ((len = in.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                closeStream(in, out);
            }
        }
        return url;
    }

    /**
     * 关闭流
     *
     * @param in
     * @param out
     */
    public static void closeStream(InputStream in, OutputStream out) {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
