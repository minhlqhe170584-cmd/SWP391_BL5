<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập hệ thống</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    
    <style>
        body {
            /* Màu nền xanh dương thương hiệu */
            background-color: #729ce8;
            height: 100vh;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            font-family: Arial, sans-serif;
        }
        
        /* Logo chữ phía trên */
        .brand-logo {
            color: white;
            font-size: 45px;
            font-weight: bold;
            margin-bottom: 20px;
            font-style: italic;
            text-shadow: 2px 2px 5px rgba(0,0,0,0.3);
            letter-spacing: 1px;
        }

        /* Khung trắng (Card) */
        .login-card {
            background: white;
            padding: 40px;
            border-radius: 15px;
            width: 400px;
            box-shadow: 0 15px 35px rgba(0,0,0,0.2);
        }

        .login-title {
            text-align: center;
            font-weight: bold;
            color: #333;
            margin-bottom: 30px;
            font-size: 28px;
        }

        .form-control {
            height: 50px;
            border-radius: 8px;
            background-color: #f8f9fa;
            border: 1px solid #ddd;
            font-size: 16px;
        }
        .form-control:focus {
            box-shadow: none;
            border-color: #729ce8;
        }

        /* Nút Đăng nhập màu đỏ cam */
        .btn-login {
            background-color: #ff5b5b;
            color: white;
            height: 50px;
            border-radius: 8px;
            font-size: 18px;
            font-weight: bold;
            border: none;
            width: 100%;
            margin-top: 20px;
            transition: 0.3s;
        }
        .btn-login:hover {
            background-color: #e04a4a;
            color: white;
            cursor: pointer;
        }

        .register-link {
            text-align: center;
            margin-top: 25px;
            color: #666;
            font-size: 14px;
        }
        .register-link a {
            color: #4a90e2;
            text-decoration: none;
            font-weight: bold;
        }
        .register-link a:hover {
            text-decoration: underline;
        }

        /* Icon con mắt */
        .toggle-password {
            position: absolute;
            top: 50%;
            right: 15px;
            transform: translateY(-50%);
            cursor: pointer;
            color: #aaa;
        }
    </style>
</head>
<body>

    <div class="brand-logo">DeeStore</div>

    <div class="login-card">
        <h2 class="login-title">Đăng nhập</h2>

        <c:if test="${mess != null}">
            <div class="alert alert-danger text-center p-2 mb-3" role="alert">
                <i class="fa-solid fa-triangle-exclamation"></i> ${mess}
            </div>
        </c:if>

        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="form-group mb-3">
                <input type="text" name="user" class="form-control" placeholder="Tên đăng nhập / Email" required>
            </div>
            
            <div class="form-group mb-3 position-relative">
                <input type="password" name="pass" class="form-control" id="password-field" placeholder="Mật khẩu" required>
                <i class="fa-solid fa-eye-slash toggle-password" id="togglePassword"></i>
            </div>

            <button type="submit" class="btn btn-login">Đăng nhập</button>
        </form>

        <div class="register-link">
            Bạn chưa có tài khoản? 
            <a href="${pageContext.request.contextPath}/register">Đăng ký ngay</a>
        </div>
    </div>

    <script>
        const togglePassword = document.querySelector('#togglePassword');
        const password = document.querySelector('#password-field');

        togglePassword.addEventListener('click', function (e) {
            // 1. Chuyển đổi thuộc tính type giữa 'password' và 'text'
            const type = password.getAttribute('type') === 'password' ? 'text' : 'password';
            password.setAttribute('type', type);
            
            // 2. Đổi icon mắt mở/đóng
            this.classList.toggle('fa-eye');
            this.classList.toggle('fa-eye-slash');
        });
    </script>

</body>
</html>