package controllers;

import dao.UsersDAO;
import models.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    // 1. Mở form đăng nhập
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Đường dẫn này phải CHÍNH XÁC với nơi bạn để file login.jsp trong WEB-INF
        request.getRequestDispatcher("/WEB-INF/views/users/login.jsp").forward(request, response);
    }

    // 2. Xử lý đăng nhập khi bấm nút
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Lấy dữ liệu từ form (name="user" và name="pass")
            String u = request.getParameter("user");
            String p = request.getParameter("pass");

            // Gọi DAO kiểm tra trong Database
            UsersDAO dao = new UsersDAO();
            User account = dao.login(u, p);

            if (account == null) {
                // TRƯỜNG HỢP SAI:
                request.setAttribute("mess", "Tài khoản hoặc mật khẩu sai rồi!");
                // Quay lại đúng cái đường dẫn như hàm doGet để báo lỗi
                request.getRequestDispatcher("/WEB-INF/views/users/login.jsp").forward(request, response);
            } else {
                // TRƯỜNG HỢP ĐÚNG:
                HttpSession session = request.getSession();
                session.setAttribute("acc", account); // Lưu đối tượng 'account' vào session
                session.setMaxInactiveInterval(1800); // Session sống 30 phút

                // Check quyền admin
                if(account.getIsAdmin() == 1) {
                    // Nếu là Admin thì chuyển sang trang quản lý
                    response.sendRedirect("Admin.jsp"); 
                } else {
                    // Nếu là khách thì chuyển sang Servlet Home (đường dẫn /home)
                    response.sendRedirect("home"); 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}