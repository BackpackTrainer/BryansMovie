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
    <div id="success">Successfully added Movie with Title: ${addMovieTitle}</div>
</c:if>

<form:form action="/movie" method="post" modelAttribute="movie">
    <form:errors path="*"  cssClass="errorblock" element="div/"/>
    <form:label path="id">ID: ${movie.id}</form:label> <form:hidden path="id" />
    <form:label path="isbn" cssErrorClass="error">ISBN:  </form:label> <form:input path="isbn" type="text" cssErrorClass="error"/>
    <form:label path="title" cssErrorClass="error">TITLE:  </form:label> <form:input path="title" type="text"/>
    <form:select path="movieType">
        <form:options items="${movieTypeList}" itemLabel="type" itemValue="id" />
    </form:select>
    <input id="submit" type="submit" value="submit">
</form:form>
</body>
</html>
