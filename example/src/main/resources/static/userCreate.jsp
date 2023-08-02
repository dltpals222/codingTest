<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>정보 입력</title>
  <link rel="stylesheet" href="userCreate.css">
</head>
<body>
        <!--? Info_Create Modal -->
        <div id="Info-Create-Container" class="modal" style=" z-index: 1; position: absolute;">
          <div class="modal-content">
            <form id="addInfoForm" method="POST" action="your_submit_url">
              <table>
                <thead>
                  <tr>
                    <th>NO</th>
                    <th>이름</th>
                    <th>번호</th>
                    <th>아이디</th>
                    <th>총 입금액</th>
                    <th>현스코어</th>
                  </tr>
                </thead>
                <tbody>
                  <% for (int i = 0; i < 10; i++) { %>
                    <tr>
                      <td contenteditable="true" name="NO"></td>
                      <td contenteditable="true" name="name"></td>
                      <td contenteditable="true" name="number"></td>
                      <td contenteditable="true" name="userId"></td>
                      <td contenteditable="true" name="deposit"></td>
                      <td contenteditable="true" name="score"></td>
                    </tr>
                  <% } %>
                </tbody>
              </table>
              <button type="submit" id="addInfo">회원 정보에 추가하기</button>
              <button type="button" id="cancel">취소하기</button>
            </form>
          </div>
        </div>
</body>
</html>