<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 5/31/2023
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>QLSV</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="khung">
    <h1>Create Student</h1>
    <c:choose>
        <c:when test="${empty student.id}">

            <form action="students?action=create" method="POST">
                <table style="width: 350px">
                    <tr>
                        <td class="cot1"><label for="name">Name:</label></td>
                        <td class="cot1"><input type="text" id="name" name="name"></td>
                    </tr>
                    <tr>
                        <td class="cot1"><label for="score">Score:</label></td>
                        <td class="cot1"><input type="text" id="score" name="score"></td>
                    </tr>
                    <tr>
                        <td class="cot1"><label for="grade">Grade:</label></td>
                        <td class="cot1"><input type="text" id="grade" name="grade" value="${student.grade}"></td>
                    </tr>
                    <tr>
                        <td class="cot1"><input type="submit" class="btn" value="Create"></td>
                        <td class="cot1"><a href="students" class="cancel">Cancel</a></td>
                    </tr>
                </table>

            </form>
        </c:when>

        <c:otherwise>
            <form action="students?action=update" method="POST">
                <input type="hidden" name="id" value="${student.id}">

                <table style="width: 350px">
                    <tr>
                        <td class="cot1"><label for="name2">Name:</label></td>
                        <td class="cot1"><input type="text" id="name2" name="name" value="${student.name}"></td>
                    </tr>
                    <tr>
                        <td class="cot1"><label for="score2">Score:</label></td>
                        <td class="cot1"><input type="text" id="score2" name="score" value="${student.score}"></td>
                    </tr>
                    <tr>
                        <td class="cot1"><label for="grade2">Grade:</label></td>
                        <td class="cot1"><input type="text" id="grade2" name="grade" value="${student.grade}"></td>
                    </tr>
                    <tr>
                        <td class="cot1"><input type="submit" class="btn" value="Update"></td>
                        <td class="cot1"><a href="students" class="cancel">Cancel</a></td>
                    </tr>
                </table>



            </form>

        </c:otherwise>
    </c:choose>

</div>

</body>
</html>
