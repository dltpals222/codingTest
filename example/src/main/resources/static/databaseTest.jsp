<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>데이터베이스 연결 테스트</title>
    <meta charset="UTF-8">
</head>
<body>
    <h1>데이터베이스 연결 테스트</h1>
    <%
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스 연결
            String url = "jdbc:mysql://localhost:3306/users?characterEncoding=UTF-8&serverTimezone=UTC";
            String user = "root";
            String password = "1q2w3e4r";
            conn = DriverManager.getConnection(url, user, password);

            // 간단한 조회 쿼리 실행
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM users_score");

            // 결과 출력
            while (rs.next()) {
                out.println("id: " + rs.getString("id") + "<br>");
                out.println("name: " + rs.getString("name") + "<br>");
                out.println("number: " + rs.getString("number") + "<br>");
                out.println("deposit: " + rs.getString("deposit") + "<br>");
                out.println("score: " + rs.getString("score") + "<br>");
                out.println("userId: " + rs.getString("user_id") + "<br>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            out.println("데이터베이스 연결 실패: " + e.getMessage());
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
            if (stmt != null) try { stmt.close(); } catch (SQLException ignore) {}
            if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
        }
    %>
</body>
</html>
