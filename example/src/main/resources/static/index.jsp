<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="index.css" />
  </head>
  <body>
    <div id="root" style="display: flex" class="width-height-100">
      
      <div class="side-bg-black"></div>


      <!--? side nav -->
      <div id="user-managers" class="user-managers-display">
        <div id="um-1" class="um-style">
          <div class="user-manager">회원관리</div>
          <ul class="ul-list-style-type">
            <li class="li-style">정보</li>
            <li class="li-style">로그인정보</li>
            <li class="li-style">추천인정보</li>
            <li class="li-style">SNS보내기</li>
          </ul>
        </div>
        <div id="um-2" class="um-style">
          <div class="user-manager">회원관리</div>
          <ul class="ul-list-style-type">
            <li class="li-style">정보</li>
            <li class="li-style">로그인정보</li>
            <li class="li-style">추천인정보</li>
            <li class="li-style">SNS보내기</li>
          </ul>
        </div>
        <div id="um-3" class="um-style">
          <div class="user-manager">회원관리</div>
          <ul class="ul-list-style-type">
            <li class="li-style">정보</li>
            <li class="li-style">로그인정보</li>
            <li class="li-style">추천인정보</li>
            <li class="li-style">SNS보내기</li>
          </ul>
        </div>
      </div>


      <!--? Main -->
      <div id="user-info-container" class="user-info-container-style">

        <!--? Main nav -->
        <div id="header-user-info" class="header-user-info-style">
          <div id="user-info-font" class="user-info-font-style flex-center">회원정보</div>
          <div id="info-container" class="info-container-style">
            <button id="info-add" class="div-info div-info-add-style flex-center">추가 +</button>
            <button id="info-update" class="div-info flex-center">선택수정</button>
            <button id="info-delete" class="div-info flex-center">선택삭제</button>
            <select
              name="search"
              id="user-search"
              class="div-info flex-center search-style-hight-43"
            >
              <option value="name">이름으로 검색</option>
              <option value="number">번호로 검색</option>
              <option value="userId">아이디로 검색</option>
            </select>
            <div>
              <input type="text" class="div-info flex-center search-style-hight-43" />
            </div>
          </div>
        </div>

        <!--? Main Table -->
        <div id="main-user-info">
          <table>
            <thead>
              <tr>
                <th></th>
                <th>NO</th>
                <th>이름</th>
                <th>번호</th>
                <th>아이디</th>
                <th>총 입금액</th>
                <th>현스코어</th>
              </tr>
            </thead>
            <tbody>
            </tbody>
          </table>
        </div>

      </div>

      <div class="side-bg-black"></div>
      

      <!--? Info_Create Modal -->
      <div id="Info-Create-Container" class="modal" style="display: none; z-index: 1; position: absolute;">
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
      


    </div>

    <script>
      var modal = document.getElementById("Info-Create-Container");
      var cancelBtn = document.getElementById("cancel");

      // '모든 정보 전달' 버튼 이벤트 처리기
      document.getElementById("info-add").addEventListener("click", function () {
        // 이제 모달 창을 엽니다.
        modal.style.display = "block";
      });
    
      document.getElementById("addInfo").addEventListener("click", function () {
        // 정보를 모두 수집하고 폼에 추가합니다.
        var hiddenFields = collectAllData();
        var form = document.getElementById("addInfoForm");
        form.innerHTML += hiddenFields;

      });
    
      document.getElementById("cancel").addEventListener("click", function () {
        modal.style.display = "none";
      });
    
    </script>
    
  </body>
</html>
