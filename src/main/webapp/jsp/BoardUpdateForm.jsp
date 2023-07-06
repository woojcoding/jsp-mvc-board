<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%><%--
  Created by IntelliJ IDEA.
  User: 82103
  Date: 2023-07-01
  Time: AM 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>게시판 수정</title>
</head>
<body>
  <script>
    function validateForm() {
      var writer = document.forms["myForm"]["writer"].value;

      var password = document.forms["myForm"]["password"].value;

      var title = document.forms["myForm"]["title"].value;

      var content = document.forms["myForm"]["content"].value;

      // 작성자 필수, 글자 수 검증
      if (writer.length < 3 || writer.length >= 5) {
        alert("작성자는 3글자 이상, 5글자 미만으로 입력해주세요.");
        return false;
      }
      
      // 제목 필수, 글자 수 검증
      if (title.length < 4 || title.length >= 100) {
        alert("제목은 4글자 이상, 100글자 미만으로 입력해주세요.");
        return false;
      }

      // 내용 필수, 글자 수 검증
      if (content.length < 4 || content.length >= 2000) {
        alert("내용은 4글자 이상, 2000글자 미만으로 입력해주세요.");
        return false;
      }
    }
  </script>
  <h2>게시판 - 수정</h2>
  기본정보
  <form name="myForm" action="board?cmd=update" method="post">
  <table>
    <tr>
      <th>카테고리</th>
      <td>${categoryName}</td>
    </tr>
    <tr>
      <th>등록 일시</th>
      <td>${boardBean.createdAt}</td>
    </tr>
    <tr>
      <th>수정 일시</th>
      <td>${boardBean.modifiedAt != null ? boardBean.modifiedAt : '-'}</td>
    </tr>
    <tr>
      <th>조회수</th>
      <td>${boardBean.views}</td>
    </tr>
    <tr>
      <th>작성자</th>
      <td><input type="text" name="writer" value="${boardBean.writer}"></td>
    </tr>
    <tr>
      <th>비밀번호</th>
      <td><input type="password" name="password" placeholder="비밀번호"></td>
    </tr>
    <tr>
      <th>제목</th>
      <td><textarea class="text" rows="1" cols="100" name="title">${boardBean.title}</textarea></td>
    </tr>
    <tr>
      <th>내용</th>
      <td><textarea class="text" rows="10" cols="60" name="content">${boardBean.content}</textarea></td>
    </tr>
    <tr>
      <th>파일 첨부</th>
      <td>
        첨부파일 다운로드 삭제
        <br>
        <input type="file">
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <div class="button-left">
          <a href="board?cmd=get&boardId=${boardBean.boardId}" class="button">취소</a>
        </div>
        <div class="button-right">
          <input type="hidden" name="boardId" value="${boardBean.boardId}">
          <button onclick="return validateForm();" class="button">저장</button>
        </div>
      </td>
    </tr>
  </table>
  </form>
</body>
</html>
