<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>정보 입력</title>
    <link rel="stylesheet" href="userCreate.css" />
  </head>
  <body>
    <!--? Info_Create Modal -->
    <div id="Create-modal-container" class="modal">
      <div class="modal-content">
        <form id="addInfoForm" method="POST" action="your_submit_url">
          <table class="width-height-inherit">
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
          <div id="button-container" class="buttonContainer">
            <button type="submit" id="addInfo">회원 정보에 추가하기</button>
            <button type="button" id="cancel">취소</button>
          </div>
        </form>
      </div>
    </div>
    <script>
      function saveInputFieldsData() {
        const table = document.querySelector("table");
        const rows = table.querySelectorAll("tbody tr");
        const form = document.getElementById("addInfoForm");

        rows.forEach(function (row, index) {
          const cells = row.querySelectorAll("td");

          cells.forEach(function (cell) {
            const input = document.createElement("input");
            input.type = "hidden";
            input.name = `data[${index}][${cell.getAttribute("name")}]`;
            input.value = cell.innerText;
            form.appendChild(input);
          });
        });
      }

      document.getElementById("addInfo").addEventListener("click", function (e) {
        e.preventDefault();
        saveInputFieldsData();
        document.getElementById("addInfoForm").submit();
      });
    </script>
  </body>
</html>
