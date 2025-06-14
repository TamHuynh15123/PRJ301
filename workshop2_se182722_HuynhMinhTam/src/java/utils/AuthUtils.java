/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dao.userDAO;
import dto.userDTO;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP
 */
public class AuthUtils {

    public static final String ADMIN_ROLE = "Instructor";
    public static final String USER_TOLE = "Student";

    public static userDTO getUser(String strUserID) {
        userDAO udao = new userDAO();
        userDTO user = udao.readByUsername(strUserID);
        return user;
    }

    public static boolean isValidLogin(String strUserID, String strPassword) {
        userDTO user = getUser(strUserID);
        System.out.println(user);
//        System.out.println(user.getPassword());
        System.out.println(strPassword);
        return user != null && user.getPassword().equals(strPassword);
    }

    public static userDTO getUser(HttpSession session) {
//        if (session.getAttribute("user") != null) {
//            return (UserDTO) session.getAttribute("user");
//        } else {
//            return null;
//        }
           Object obj = session.getAttribute("user");
           return (obj!=null)?(userDTO)obj:null;
    }

    public static boolean isLoggedIn(HttpSession session) {
        return session.getAttribute("user") != null;
    }

    public static boolean isAdmin(HttpSession session) {
        if (!isLoggedIn(session)) {
            return false;
        }
        userDTO user = (userDTO) session.getAttribute("user");
        return user.getRole().equals(ADMIN_ROLE);
    }
}