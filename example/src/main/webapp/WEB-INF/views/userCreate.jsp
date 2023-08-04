<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>정보 입력</title>
    <link rel="stylesheet" href="CSS/userCreate.css" />
  </head>
  <body>
    <!--? Info_Create Modal -->
    <div id="Create-modal-container" class="modal">
      <div class="modal-content flex-center">
        <form id="addInfoForm" method="POST" action="/userInfo">
          <table class="modal-table">
            <thead>
              <tr>
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
                <td><input type="text" name="data[<%=i %>][name]" /></td>
                <td><input type="text" name="data[<%=i %>][number]" /></td>
                <td><input type="text" name="data[<%=i %>][userId]" /></td>
                <td><input type="text" name="data[<%=i %>][deposit]" /></td>
                <td><input type="text" name="data[<%=i %>][score]" /></td>
              </tr>
              <% } %>
            </tbody>
          </table>
          <div id="button-container" class="buttonContainer">
            <button type="submit" id="addInfo">회원 정보에 추가하기</button>
            <button type="button" id="cancel">취소</button>
          </div>
        </form>
      </div>
    </div>
    <script>
      document.getElementById("cancel").addEventListener("click", function (e) {
        e.preventDefault();

        // 모든 입력 필드를 선택하고 값을 비웁니다.
        const inputs = document.querySelectorAll("#addInfoForm input[type='text']");
        inputs.forEach((input) => {
          input.value = "";
        });
      });
    </script>
  </body>
</html>
