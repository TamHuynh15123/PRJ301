/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ExamCategoriesDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author HP
 */
public class ExamCategoriesDAO implements IDAO<ExamCategoriesDTO, Integer> {

    @Override
    public boolean create(ExamCategoriesDTO entity) {
        String sql = "INSERT INTO tblExamCategories (category_name, description) VALUES (?, ?)";
        try (Connection con = DBUtils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, entity.getCategoryName());
            ps.setString(2, entity.getDescription());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ExamCategoriesDTO readByID(Integer id) {
        String sql = "SELECT * FROM tblExamCategories WHERE category_id = ?";
        try (Connection con = DBUtils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new ExamCategoriesDTO(
                        rs.getInt("category_id"),
                        rs.getString("category_name"),
                        rs.getString("description"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ExamCategoriesDTO> readAll() {
        String sql = "SELECT * FROM tblExamCategories";
        List<ExamCategoriesDTO> list = new ArrayList<>();
        try (Connection con = DBUtils.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new ExamCategoriesDTO(
                        rs.getInt("category_id"),
                        rs.getString("category_name"),
                        rs.getString("description")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean update(ExamCategoriesDTO entity) {
        String sql = "UPDATE tblExamCategories SET category_name = ?, description = ? WHERE category_id = ?";
        try (Connection con = DBUtils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, entity.getCategoryName());
            ps.setString(2, entity.getDescription());
            ps.setInt(3, entity.getCategoryId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "DELETE FROM tblExamCategories WHERE category_id = ?";
        try (Connection con = DBUtils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<ExamCategoriesDTO> getAllCategories() {
    List<ExamCategoriesDTO> categories = new ArrayList<>();
    String sql = "SELECT category_id, category_name, description FROM tblExamCategories";
    
    try (Connection conn = DBUtils.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        
        while (rs.next()) {
            int id = rs.getInt("category_id");
            String name = rs.getString("category_name");
            String description = rs.getString("description");
            categories.add(new ExamCategoriesDTO(id, name, description));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    
    return categories;
}



    @Override
    public List<ExamCategoriesDTO> search(String searchTerm) {
        String sql = "SELECT * FROM tblExamCategories WHERE category_name LIKE ?";
        List<ExamCategoriesDTO> list = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            String param = "%" + searchTerm + "%";
            ps.setString(1, param);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ExamCategoriesDTO c = new ExamCategoriesDTO(
                        rs.getInt("category_id"),
                        rs.getString("category_name"),
                        rs.getString("description"));
                list.add(c);               
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public static List<ExamCategoriesDTO> getCategoriesByFilter(String categoryId) throws SQLException, ClassNotFoundException {
        List<ExamCategoriesDTO> categoriesList = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();
            String sql = "SELECT * FROM exam_categories";

            if (categoryId != null && !categoryId.isEmpty()) {
                sql += " WHERE id = ?";
            }

            ps = con.prepareStatement(sql);

            if (categoryId != null && !categoryId.isEmpty()) {
                ps.setInt(1, Integer.parseInt(categoryId));
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                ExamCategoriesDTO category = new ExamCategoriesDTO(
                        rs.getInt("category_id"),
                        rs.getString("category_name"),
                        rs.getString("description")
                );
                categoriesList.add(category);
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        }

        return categoriesList;
    }

}

