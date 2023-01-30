<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="resources"/>

<!DOCTYPE html>
<html lang="${sessionScope.locale}">

<head>
    <title>Books</title>
    <jsp:include page="fragments/formating/formating.jsp"/>
</head>

<body>

<jsp:include page="fragments/menus/mainMenu.jsp"/>

<div class="col-lg-8 mx-auto p-4 py-md-5">
    <table class="table table-hover" >
        <tbody align="center">
        <tr>
            <th><fmt:message key="book.id"/></th>
            <th><fmt:message key="title"/></th>
            <th><fmt:message key="author"/></th>
            <th><fmt:message key="publisher"/></th>
            <th><fmt:message key="isbn"/></th>
            <th><fmt:message key="date.of.publication"/></th>
            <th><fmt:message key="quantity"/></th>
        </tr>
        <c:forEach var="book" items="${requestScope.books}">
            <tr>
                <td><c:out value="${book.bookID}"/></td>
                <td align="left"><c:out value="${book.bookTitle}"/></td>
                <td><c:out value="${book.authorName}"/></td>
                <td><c:out value="${book.publisherName}"/></td>
                <td><c:out value="${book.ISBN}"/></td>
                <td><c:out value="${book.dateOfPublication}"/></td>
                <td><c:out value="${book.quantity}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<footer>
    <jsp:include page="fragments/formating/footer.jsp"/>
</footer>
</body>
</html>