package com.zzu.diting.util;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author :
 * @description:
 * @date : 2019/4/15 9:33
 */
public class FileUtil {
    public static File transerFile(MultipartFile file, HttpServletRequest request) throws IOException {
        File file1=null;
        if (file!=null) {
            if (!file.isEmpty()) {
                String filePath = request.getSession().getServletContext().getRealPath("/") + "upload\\";
                File dir = new File(filePath);
                if (!dir.exists()) {
                    dir.mkdir();
                }
                String path = filePath + file.getOriginalFilename();
                //save to the /upload path
                file1 = new File(path);
                FileUtils.copyInputStreamToFile(file.getInputStream(), file1);
            }
        }
        System.out.println(file1);
        return file1;
    }
}
