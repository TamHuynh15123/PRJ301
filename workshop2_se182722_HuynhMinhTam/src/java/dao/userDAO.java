package dao;

import dto.userDTO;
import utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class userDAO implements IDAO<userDTO, String> {

    @Override
    public boolean create(userDTO entity) {
        return true;
    }

    @Override
    public List<userDTO> readAll() {
        return null;
    }

    @Override
    public userDTO readByID(String id) {
        return null;
    }

    @Override
    public boolean update(userDTO entity) {
        return true;
    }

    @Override
    public boolean delete(String id) {
        return true;
    }

    @Override
    public List<userDTO> search(String searchTerm) {
        return null;
    }

    public userDTO readByUsername(String strUsername) {
        String sql = "SELECT * FROM tblUsers WHERE Username=?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, strUsername);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                userDTO user = new userDTO(
                        rs.getString("Username"),
                        rs.getString("Name"),
                        rs.getString("Password"),
                        rs.getString("Role"));
                return user;
            }
        } catch (Exception e) {
            
        }
        return null;
    }
}
