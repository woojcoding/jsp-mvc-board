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

/**
 * 파일 업로드 유틸리티 클래스입니다.
 */
public class FileUploadUtil {
    /**
     * 파일 업로드 메서드
     *
     * @param realPath 실제 경로
     * @param parts    Part 객체의 컬렉션으로 업로드할 파일
     * @param boardId  게시글 ID
     * @throws IOException 파일 업로드 중 예외가 발생할 경우
     */
    public static void uploadFiles(String realPath, Collection<Part> parts, long boardId) throws IOException {
        for (Part part : parts) {
            // 파일 파트가 아닌 경우 무시합니다.
            if (!part.getName().equals("file")) {
                continue;
            }
            // 파일 크기가 0인 경우 무시합니다.
            if (part.getSize() == 0) {
                continue;
            }

            String fileOriginalName = part.getSubmittedFileName();

            File path = new File(realPath);

            // 폴더가 없을 경우 생성합니다.
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

            // 파일을 업로드하고 DB에 정보를 저장합니다.
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
