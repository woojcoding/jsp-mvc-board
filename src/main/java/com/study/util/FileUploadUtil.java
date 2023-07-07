package com.study.util;

import com.study.model.FileBean;
import com.study.service.FileDao;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public class FileUploadUtil {
    public static void uploadFiles(Collection<Part> parts, long boardId) throws IOException {
        for (Part part : parts) {
            if (!part.getName().equals("file")) {
                continue;
            }

            if (part.getSize() == 0) {
                continue;
            }

            String fileOriginalName = part.getSubmittedFileName();

            String realPath = "C:\\Users\\82103\\Downloads\\jsp-board-mvc\\src\\main\\webapp\\WEB-INF\\uploads";

            File path = new File(realPath);

            if (!path.exists()) {
                path.mkdirs();
            }

            String filePath = realPath + File.separator + fileOriginalName;

            File file = new File(filePath);

            // 중복 파일명 처리
            int count = 1;

            String baseName = FilenameUtils.getBaseName(fileOriginalName);

            String extension = FilenameUtils.getExtension(fileOriginalName);

            String savedFileName = fileOriginalName;

            while (file.exists()) {
                savedFileName = baseName + "_" + count + "." + extension;

                filePath = realPath + File.separator + savedFileName;

                file = new File(filePath);

                count++;
            }

            try (InputStream filePartInputStream = part.getInputStream();
                 FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {

                byte[] buf = new byte[1024];

                int size;

                while ((size = filePartInputStream.read(buf)) != -1) {
                    fileOutputStream.write(buf, 0, size);
                }

                FileBean fileBean = new FileBean();

                fileBean.setBoardId(boardId);
                fileBean.setOriginalName(fileOriginalName);
                fileBean.setSavedName(savedFileName);

                FileDao fileDao = new FileDao();

                fileDao.saveFile(fileBean);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
