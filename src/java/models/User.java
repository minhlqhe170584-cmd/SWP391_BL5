package models;

public class User {
    // 1. Khai báo thuộc tính (Phải Private để bảo mật)
    private int id;         // Map với cột uID
    private String user;    // Map với cột [user]
    private String pass;    // Map với cột pass
    private int isSell;     // Map với cột isSell (1: Bán, 0: Mua)
    private int isAdmin;    // Map với cột isAdmin (1: Admin, 0: User)
    private String email;   // Map với cột email

    // 2. Constructor không tham số (Bắt buộc phải có)
    public User() {
    }

    // 3. Constructor đầy đủ tham số (Dùng khi lấy dữ liệu từ DB lên)
    public User(int id, String user, String pass, int isSell, int isAdmin, String email) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.isSell = isSell;
        this.isAdmin = isAdmin;
        this.email = email;
    }

    // 4. Getter và Setter (Để các class khác lấy hoặc sửa dữ liệu)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }

    public String getPass() { return pass; }
    public void setPass(String pass) { this.pass = pass; }

    public int getIsSell() { return isSell; }
    public void setIsSell(int isSell) { this.isSell = isSell; }

    public int getIsAdmin() { return isAdmin; }
    public void setIsAdmin(int isAdmin) { this.isAdmin = isAdmin; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // 5. Hàm toString (Tùy chọn - Giúp in ra log để kiểm tra lỗi dễ hơn)
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", user=" + user + ", email=" + email + '}';
    }
}