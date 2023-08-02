<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
    <title>Table Loader</title>
</head>
<body>
    <table border="1">
        <thead>
            <tr>
                <th>No</th>
                <th>Name</th>
                <th>Number</th>
                <th>User Id</th>
                <th>Total Deposit</th>
                <th>Current Score</th>
            </tr>
        </thead>
        <tbody>
        <%
            // 데이터베이스 연결 정보
            String url = "jdbc:mysql://localhost:3306/users?characterEncoding=UTF-8&serverTimezone=UTC";
            String username = "root";
            String password = "1q2w3e4r";

            // DB 연결, 쿼리 실행
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users_score");
            int rowCount = 0;

            // 결과를 테이블에 출력
            while (rs.next()) {
                rowCount++;
        %>
            <tr>
                <td><%= rs.getString("id") %></td>
                <td><%= rs.getString("no") %></td>
                <td><%= rs.getString("name") %></td>
                <td><%= rs.getString("number") %></td>
                <td><%= rs.getString("userId") %></td>
                <td><%= rs.getString("total_deposit") %></td>
                <td><%= rs.getString("current_score") %></td>
            </tr>
        <%
            }

            // 자원 정리
            rs.close();
            stmt.close();
            conn.close();
        %>
        <% for (int i = rowCount; i < 20; i++) { %>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        <% } %>
        </tbody>
    </table>
</body>
</html>
