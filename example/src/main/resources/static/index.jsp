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
    <div id="root" style="display: flex">
      <div class="side-bg-black"></div>
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
      <div id="user-info-container" style="background-color: rgb(217, 252, 252)">
        <div id="header-user-info" class="header-user-info-style">
          <div id="user-info" class="user-info-style">회원정보</div>
          <div id="info-container" class="info-container-style">
            <div id="info-add" class="div-info">추가 +</div>
            <div id="info-update" class="div-info">선택수정</div>
            <div id="info-delete" class="div-info">선택삭제</div>
            <select name="search" id="user-search">
              <option value="name">이름으로 검색</option>
              <option value="number">번호로 검색</option>
              <option value="userId">아이디로 검색</option>
            </select>
            <div>
              <input type="text" />
            </div>
          </div>
        </div>
        <div id="main-user-info">
          <div id="info-table"></div>
          <div id="total"></div>
        </div>
      </div>
      <div class="side-bg-black"></div>
    </div>
  </body>
</html>
