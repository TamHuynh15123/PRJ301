/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.QuestionsDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBUtils;

/**
 *
 * @author HP
 */
public class QuestionDAO {
    public boolean addQuestion(QuestionsDTO question) {
        String sql = "INSERT INTO tblQuestions (exam_id, question_text, option_a, option_b, option_c, option_d, correct_option) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setInt(1, question.getExamId());
            ps.setString(2, question.getQuestionText());
            ps.setString(3, question.getOptionA());
            ps.setString(4, question.getOptionB());
            ps.setString(5, question.getOptionC());
            ps.setString(6, question.getOptionD());
            ps.setObject(7, question.getCorrectOption(), java.sql.Types.CHAR);

            return ps.executeUpdate() > 0;
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public List<QuestionsDTO> getQuestionsByExam(int examId) {
        List<QuestionsDTO> questions = new ArrayList<>();
        String sql = "SELECT * FROM tblQuestions WHERE exam_id = ?";

        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, examId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    QuestionsDTO qs = new QuestionsDTO();
                    qs.setQuestionId(rs.getInt("question_id"));
                    qs.setExamId(rs.getInt("exam_id"));
                    qs.setQuestionText(rs.getString("question_text"));
                    qs.setOptionA(rs.getString("option_a"));
                    qs.setOptionB(rs.getString("option_b"));
                    qs.setOptionC(rs.getString("option_c"));
                    qs.setOptionD(rs.getString("option_d"));
                    qs.setCorrectOption(rs.getString("correct_option").charAt(0));

                    questions.add(qs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return questions;
    }
}
