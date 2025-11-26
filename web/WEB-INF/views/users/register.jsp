<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng ký tài khoản</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    
    <style>
        /* CSS giữ nguyên như cũ */
        body { background-color: #729ce8; height: 100vh; display: flex; flex-direction: column; align-items: center; justify-content: center; font-family: Arial, sans-serif; }
        .brand-logo { color: white; font-size: 40px; font-weight: bold; margin-bottom: 20px; font-style: italic; text-shadow: 2px 2px 4px rgba(0,0,0,0.2); }
        .login-card { background: white; padding: 40px; border-radius: 15px; width: 400px; box-shadow: 0 10px 25px rgba(0,0,0,0.2); }
        .form-control { height: 50px; border-radius: 8px; background-color: #f8f9fa; border: 1px solid #ddd; }
        .btn-register { background-color: #4a90e2; color: white; height: 50px; border-radius: 8px; font-size: 18px; font-weight: bold; border: none; width: 100%; margin-top: 10px; }
        .btn-register:hover { background-color: #357abd; color: white; }
        a { text-decoration: none; }
    </style>
</head>
<body>

    <div class="brand-logo">DeeStore</div>

    <div class="login-card">
        <h3 class="text-center font-weight-bold mb-4" style="color: #333;">Đăng Ký</h3>

        <c:if test="${mess != null}">
            <div class="alert alert-danger text-center">${mess}</div>
        </c:if>

        <form action="${pageContext.request.contextPath}/register" method="post">
            <div class="form-group">
                <input type="text" name="user" class="form-control" placeholder="Tên đăng nhập" value="${user}" required>
            </div>
            <div class="form-group">
                <input type="email" name="email" class="form-control" placeholder="Email" value="${email}" required>
            </div>
            <div class="form-group">
                <input type="password" name="pass" class="form-control" placeholder="Mật khẩu" required>
            </div>
            <div class="form-group">
                <input type="password" name="repass" class="form-control" placeholder="Nhập lại mật khẩu" required>
            </div>

            <button type="submit" class="btn btn-register">Tạo Tài Khoản</button>
        </form>

        <div class="text-center mt-3">
            Đã có tài khoản? 
            <a href="${pageContext.request.contextPath}/login" style="color: #ff5b5b; font-weight: bold;">Đăng nhập ngay</a>
        </div>
    </div>

</body>
</html>