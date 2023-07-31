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
    <div id="root" class="flex-center">
      <div class="side-bg-black"></div>
      <div id="user-manager">
        <div id="um-1">
          <div class="user-managers">회원관리</div>
          <ul class="ul-style">
            <li>정보</li>
            <li>로그인정보</li>
            <li>추천인정보</li>
            <li>SNS보내기</li>
          </ul>
        </div>
        <div id="um-2">
          <div class="user-managers">회원관리</div>
          <ul class="ul-style">
            <li>정보</li>
            <li>로그인정보</li>
            <li>추천인정보</li>
            <li>SNS보내기</li>
          </ul>
        </div>
        <div id="um-3">
          <div class="user-managers">회원관리</div>
          <ul class="ul-style">
            <li>정보</li>
            <li>로그인정보</li>
            <li>추천인정보</li>
            <li>SNS보내기</li>
          </ul>
        </div>
      </div>
      <div id="user-info-container">
        <div>
          <div id="user-info">회원정보</div>
          <div>
            <div id="info-add">추가 +</div>
            <div id="info-update">선택수정</div>
            <div id="info-delete">선택삭제</div>
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
        <div id="user-table-container">
          <div id="info-table"></div>
          <div id="total"></div>
        </div>
      </div>
      <div class="side-bg-black"></div>
    </div>
  </body>
</html>
