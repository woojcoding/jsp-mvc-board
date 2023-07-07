package com.study.service;

import com.study.model.FileBean;
import com.study.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FileDao {
    private Connection connection;

    private PreparedStatement pstmt;

    private ResultSet rs;

    public void saveFile(FileBean fileBean) throws Exception {
        connection = ConnectionUtil.getConnection();

        try {
            String query = "INSERT INTO file (boardId, originalName, savedName) VALUES (?, ?, ?)";

            pstmt = connection.prepareStatement(query);
            pstmt.setLong(1, fileBean.getBoardId());
            pstmt.setString(2, fileBean.getOriginalName());
            pstmt.setString(3, fileBean.getSavedName());
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<FileBean> getFiles(long boardId) throws Exception {
        List<FileBean> fileList = new ArrayList<>();

        connection = ConnectionUtil.getConnection();

        try {
            String query = "SELECT * FROM file WHERE boardId = ?";

            pstmt = connection.prepareStatement(query);
            pstmt.setLong(1, boardId);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                FileBean fileBean = new FileBean();

                fileBean.setOriginalName(rs.getString("originalName"));
                fileBean.setSavedName(rs.getString("savedName"));
                fileBean.setBoardId(rs.getLong("boardId"));

                fileList.add(fileBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return fileList;
    }
}
