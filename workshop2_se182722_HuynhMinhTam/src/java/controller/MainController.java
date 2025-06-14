/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ExamCategoriesDAO;
import dao.ExamsDAO;
import dao.QuestionDAO;
import dao.userDAO;
import dto.ExamCategoriesDTO;
import dto.ExamsDTO;
import dto.QuestionsDTO;
import dto.userDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.AuthUtils;

/**
 *
 * @author HP
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private userDAO usersDAO = new userDAO();
    private ExamsDAO examsDAO = new ExamsDAO();
    private ExamCategoriesDAO ecDAO = new ExamCategoriesDAO();
    
    private static final String LOGIN_PAGE = "login.jsp";

    private String processLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = LOGIN_PAGE;
        String strUsername = request.getParameter("txtUserID");
        String strPassword = request.getParameter("txtPassword");
        if (AuthUtils.isValidLogin(strUsername, strPassword)) {
            userDAO udao = new userDAO();
            userDTO user = udao.readByUsername(strUsername);
            request.getSession().setAttribute("user", user);
            url = processViewExamCategories(request, response);
        } else {
            request.setAttribute("message", "Incorrect Username or Password");
        }
        return url;
    }

    private String processLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = LOGIN_PAGE;
        //
        HttpSession session = request.getSession();
        if (AuthUtils.isAdmin(session)) {
            session.invalidate();
        }
        return url;
    }

    public String processViewExamCategories(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<ExamCategoriesDTO> list = ecDAO.getAllCategories();
        request.setAttribute("list", list);
        request.setAttribute("test", "categories");
        return "exams.jsp";
    }

    public String processViewExamsByCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String categoryIdStr = request.getParameter("categoryId");

        if (categoryIdStr != null && !categoryIdStr.isEmpty()) {
            try {
                int categoryId = Integer.parseInt(categoryIdStr);
                ExamsDAO examDAO = new ExamsDAO();
                List<ExamsDTO> exams = examDAO.getExamsByCategory(categoryId);
                request.setAttribute("exams", exams);
                request.setAttribute("test", "exams");
            } catch (NumberFormatException e) {
                request.setAttribute("message", "Invalid category ID.");
            }
        } else {
            request.setAttribute("message", "Category ID is required.");
        }

        return "exams.jsp";
    }

    public String processCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<ExamCategoriesDTO> categories = ecDAO.getAllCategories();
        request.setAttribute("categories", categories);
        String url = "create.jsp";
        String examTitle = request.getParameter("examTitle");
        String subject = request.getParameter("subject");
        String StrcategoryId = request.getParameter("categoryId");
        String StrtotalMarks = request.getParameter("totalMarks");
        String Strduration = request.getParameter("duration");

        String examTitleError = null;
        String subjectError = null;
        String categoryError = null;
        String totalMarksError = null;
        String durationError = null;

        if (examTitle.trim().isEmpty()) {
            examTitleError = "Exam Title can't be empty.";
        }
        if (subject == null || subject.trim().isEmpty()) {
            subjectError = "Subject can't be empty.";
        }
        if (StrcategoryId == null || StrcategoryId.trim().isEmpty()) {
            categoryError = "Category must be selected.";
        }
        if (StrtotalMarks == null || StrtotalMarks.trim().isEmpty()) {
            totalMarksError = "Total Marks is required.";
        }
        if (Strduration == null || Strduration.trim().isEmpty()) {
            durationError = "Duration is required.";
        }

        // Chuyển đổi số
        int categoryId = 0, totalMarks = 0, duration = 0;

        if (categoryError == null) {
            try {
                categoryId = Integer.parseInt(StrcategoryId);
            } catch (NumberFormatException e) {
                categoryError = "Invalid category format.";
            }
        }

        if (totalMarksError == null) {
            try {
                totalMarks = Integer.parseInt(StrtotalMarks);
                if (totalMarks <= 0 || totalMarks > 10) {
                    totalMarksError = "Total Marks must be between 1 and 10.";
                }
            } catch (NumberFormatException e) {
                totalMarksError = "Invalid total marks format.";
            }
        }

        if (durationError == null) {
            try {
                duration = Integer.parseInt(Strduration);
                if (duration <= 15 || duration > 90) {
                    durationError = "Duration must be between 15 minutes and 90 minutes.";
                }
            } catch (NumberFormatException e) {
                durationError = "Invalid duration format.";
            }
        }

        // Nếu có lỗi, giữ lại dữ liệu nhập
        if (examTitleError != null || subjectError != null || categoryError != null
                || totalMarksError != null || durationError != null) {
            request.setAttribute("examTitleError", examTitleError);
            request.setAttribute("subjectError", subjectError);
            request.setAttribute("categoryError", categoryError);
            request.setAttribute("totalMarksError", totalMarksError);
            request.setAttribute("durationError", durationError);

            request.setAttribute("examTitle", examTitle);
            request.setAttribute("subject", subject);
            request.setAttribute("categoryId", StrcategoryId);
            request.setAttribute("totalMarks", StrtotalMarks);
            request.setAttribute("duration", Strduration);

            return url;
        }

        // Nếu không có lỗi, tạo đối tượng ExamDTO
        ExamsDTO exam = new ExamsDTO(0, examTitle, subject, categoryId, totalMarks, duration);
        ExamsDAO examDAO = new ExamsDAO();
        boolean created = examDAO.createExam(exam);
        if (created) {
            request.setAttribute("message", "Exam created successfully!");
            url = "MainController?action=viewExamCategories";
        } else {
            request.setAttribute("message", "Exam creation failed.");
            request.setAttribute("examTitle", examTitle);
            request.setAttribute("subject", subject);
            request.setAttribute("categoryId", StrcategoryId);
            request.setAttribute("totalMarks", StrtotalMarks);
            request.setAttribute("duration", Strduration);
        }

        return url;
    }

    public String processAddQuestion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "question.jsp";
        String examIdStr = request.getParameter("exam_id");
        String questionText = request.getParameter("question_text");
        String optionA = request.getParameter("option_a");
        String optionB = request.getParameter("option_b");
        String optionC = request.getParameter("option_c");
        String optionD = request.getParameter("option_d");
        String correctOptionStr = request.getParameter("correct_option");

        // Khai báo biến lỗi
        String examIdError = null;
        String questionTextError = null;
        String optionAError = null;
        String optionBError = null;
        String optionCError = null;
        String optionDError = null;
        String correctOptionError = null;

        int examId = 0;
        char correctOption = ' ';

        // Kiểm tra exam_id
        if (examIdStr == null || examIdStr.trim().isEmpty()) {
            examIdError = "Exam ID is required.";
        } else {
            try {
                examId = Integer.parseInt(examIdStr);
            } catch (NumberFormatException e) {
                examIdError = "Invalid Exam ID format.";
            }
        }

        // Kiểm tra nội dung câu hỏi
        if (questionText == null || questionText.trim().isEmpty()) {
            questionTextError = "Question text is required.";
        }

        // Kiểm tra đáp án A
        if (optionA == null || optionA.trim().isEmpty()) {
            optionAError = "Option A is required.";
        }

        // Kiểm tra đáp án B
        if (optionB == null || optionB.trim().isEmpty()) {
            optionBError = "Option B is required.";
        }

        // Kiểm tra đáp án C
        if (optionC == null || optionC.trim().isEmpty()) {
            optionCError = "Option C is required.";
        }

        // Kiểm tra đáp án D
        if (optionD == null || optionD.trim().isEmpty()) {
            optionDError = "Option D is required.";
        }

        // Kiểm tra correct_option
        if (correctOptionStr == null || correctOptionStr.trim().isEmpty()) {
            correctOptionError = "Correct Option is required.";
        } else if (correctOptionStr.length() != 1 || !"ABCD".contains(correctOptionStr.toUpperCase())) {
            correctOptionError = "Correct Option must be A, B, C, or D.";
        } else {
            correctOption = correctOptionStr.toUpperCase().charAt(0);
        }

        // Nếu có lỗi, trả lại trang add_question.jsp kèm theo thông báo lỗi
        if (examIdError != null || questionTextError != null || optionAError != null
                || optionBError != null || optionCError != null || optionDError != null || correctOptionError != null) {
            request.setAttribute("examIdError", examIdError);
            request.setAttribute("questionTextError", questionTextError);
            request.setAttribute("optionAError", optionAError);
            request.setAttribute("optionBError", optionBError);
            request.setAttribute("optionCError", optionCError);
            request.setAttribute("optionDError", optionDError);
            request.setAttribute("correctOptionError", correctOptionError);

            request.setAttribute("exam_id", examIdStr);
            request.setAttribute("question_text", questionText);
            request.setAttribute("option_a", optionA);
            request.setAttribute("option_b", optionB);
            request.setAttribute("option_c", optionC);
            request.setAttribute("option_d", optionD);
            request.setAttribute("correct_option", correctOptionStr);

            return url;
        }
        QuestionsDTO question = new QuestionsDTO(0, examId, questionText, optionA, optionB, optionC, optionD, correctOption);
        QuestionDAO dao = new QuestionDAO();
        boolean success = dao.addQuestion(question);

        if (success) {
            request.setAttribute("message", "Question added successfully!");
        } else {
            request.setAttribute("message", "Failed to add question.");
        }

        return url;

    }

    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN_PAGE;

        try {
            String action = request.getParameter("action");
            System.out.println("action: " + action);

            if (action != null) {
                switch (action) {
                    case "login":
                        url = processLogin(request, response);
                        break;
                    case "logout":
                        url = processLogout(request, response);
                        request.getSession().invalidate();
                        url = LOGIN_PAGE;
                        break;
                    
                    case "viewExamCategories":
                        url = processViewExamCategories(request, response);
                        break;
                    case "viewExamsByCategory":
                        url = processViewExamsByCategory(request, response);
                        break;
                    case "createExam":
                        url = processCreate(request, response);
                        break;
                    case "addQuestion":
                        url = processAddQuestion(request, response);
                        break;

                }
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
