<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <title>Add Movie</title>

    <link rel="stylesheet" type="text/css" href="styles.css" />

</head>
<body>
<h1>We are on the Movies page!</h1>

<c:if test="${addMovieSuccess}">
    <div>Successfully added Movie with Title: ${addMovieTitle}</div>
</c:if>

<form:form action="/movie" method="post" modelAttribute="movie">
    <form:errors path="*"  cssClass="errorblock" element="div/"/>
    <form:label path="id">ID: </form:label> <form:input path="id" type="text" cssErrorClass="error"/>
    <form:label path="isbn" cssErrorClass="error">ISBN:  </form:label> <form:input path="isbn" type="text" cssErrorClass="error"/>
    <form:label path="title" cssErrorClass="error">TITLE:  </form:label> <form:input path="title" type="text"/>
    <input type="submit" value="submit">
</form:form>
</body>
</html>
