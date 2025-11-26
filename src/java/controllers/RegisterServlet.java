package controllers;

import dao.UsersDAO;
import models.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 1. QUAN TRỌNG: Dòng này quyết định đường dẫn là /register
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    // 2. Hàm doGet: Mở trang đăng ký
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/users/register.jsp").forward(request, response);
    }

    // 3. Hàm doPost: Xử lý khi bấm nút "Đăng Ký"
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Hỗ trợ tiếng Việt
        request.setCharacterEncoding("UTF-8");

        try {
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            String repass = request.getParameter("repass");
            String email = request.getParameter("email");

            // --- VALIDATION ---
            
            // 1. Check pass
            if (!pass.equals(repass)) {
                request.setAttribute("mess", "Mật khẩu nhập lại không khớp!");
                request.setAttribute("user", user);
                request.setAttribute("email", email);
                request.getRequestDispatcher("/WEB-INF/views/users/register.jsp").forward(request, response);
                return; 
            }

            // 2. Check user tồn tại
            UsersDAO dao = new UsersDAO();
            User a = dao.checkAccountExist(user);

            if (a != null) {
                request.setAttribute("mess", "Tên đăng nhập này đã có người dùng!");
                request.setAttribute("user", user);
                request.setAttribute("email", email);
                request.getRequestDispatcher("/WEB-INF/views/users/register.jsp").forward(request, response);
            } else {
                // --- THÀNH CÔNG ---
                dao.signup(user, pass, email);

                // 3. Chuyển hướng về trang Login
                // Dùng request.getContextPath() để đảm bảo đường dẫn luôn đúng là /SWP391/login
                response.sendRedirect(request.getContextPath() + "/login");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}