<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 82103
  Date: 2023-07-01
  Time: PM 2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>비밀번호 확인</title>
</head>
<body>
<table>
  <form action="board?cmd=delete&boardId=${boardId}" method="post">
  <tr class="password">
    <th>비밀번호</th>
    <td><input type="password" id="password" name="password" placeholder="비밀번호를 입력해 주세요."></td>
  </tr>
  <tr>
    <td class="buttons" colspan="2">
      <a href="board?cmd=get&boardId=${boardId}" class="button">취소</a>
      <button type="submit">확인</button>
    </td>
  </form>
  </tr>
</table>
</body>
</html>
