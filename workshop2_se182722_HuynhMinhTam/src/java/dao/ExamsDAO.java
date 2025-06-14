/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ExamsDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author HP
 */
public class ExamsDAO {
    public List<ExamsDTO> searchExams(String searchTerm) {
        String sql = "SELECT e.exam_id, e.exam_title, e.subject, e.category_id, e.total_marks, e.duration, c.category_name "
                + "FROM tblExams e "
                + "JOIN tblExamCategories c ON e.category_id = c.category_id "
                + "WHERE c.category_name LIKE ? OR e.exam_title LIKE ? OR e.subject LIKE ?";
        List<ExamsDTO> list = new ArrayList<>();

        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            String param = "%" + searchTerm + "%";
            ps.setString(1, param);
            ps.setString(2, param);
            ps.setString(3, param);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ExamsDTO exam = new ExamsDTO(
                            rs.getInt("exam_id"),
                            rs.getString("exam_title"),
                            rs.getString("subject"),
                            rs.getInt("category_id"),
                            rs.getInt("total_marks"),
                            rs.getInt("duration"));
                    list.add(exam);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<ExamsDTO> getExamsByCategory(int categoryId) {
        List<ExamsDTO> exams = new ArrayList<>();
        String sql = "SELECT * FROM tblExams WHERE category_id = ?";
        
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, categoryId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int exam_id = rs.getInt("exam_id");
                    String exam_title = rs.getString("exam_title");
                    String subject = rs.getString("Subject");
                    
                    int total_marks = rs.getInt("total_marks");
                    int duration = rs.getInt("Duration");
                    
                    exams.add(new ExamsDTO(exam_id, exam_title, subject, categoryId, total_marks, duration));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return exams;
    }

   public boolean createExam(ExamsDTO exam) {
        
        String sql = "INSERT INTO tblExams (exam_title, Subject, category_id, total_marks, Duration) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, exam.getExamTitle());
            ps.setString(2, exam.getSubject());
            ps.setInt(3, exam.getCategoryId());
            ps.setInt(4, exam.getTotalMarks());
            ps.setInt(5, exam.getDuration());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
}
}
