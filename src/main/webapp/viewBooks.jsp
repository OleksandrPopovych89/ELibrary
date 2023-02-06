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
    <jsp:include page="fragments/menus/mainMenu.jsp"/>
</head>

<body>
<div class="col-lg-8 mx-auto p-4 py-md-5">
    <figure>
        <figcaption><fmt:message key="lsit.of.books"/></figcaption>
        <table class="table table-hover">
            <tbody class="text-center">
            <tr>
                <th><fmt:message key="book.id"/> <i class="bi bi-arrow-down-up"></i></th>
                <th><fmt:message key="title"/> <i class="bi bi-arrow-down-up"></i></th>
                <th><fmt:message key="author"/> <i class="bi bi-arrow-down-up"></i></th>
                <th><fmt:message key="publisher"/> <i class="bi bi-arrow-down-up"></i></th>
                <th><fmt:message key="isbn"/> <i class="bi bi-arrow-down-up"></i></th>
                <th><fmt:message key="date.of.publication"/> <i class="bi bi-arrow-down-up"></i></th>
                <th><fmt:message key="quantity"/> <i class="bi bi-arrow-down-up"></i></th>
            </tr>
            <c:forEach var="book" items="${requestScope.books}">
                <tr>
                    <td><c:out value="${book.bookID}"/></td>
                    <td class="text-start"><c:out value="${book.bookTitle}"/></td>
                    <td><c:out value="${book.authorName}"/></td>
                    <td><c:out value="${book.publisherName}"/></td>
                    <td><c:out value="${book.ISBN}"/></td>
                    <td><c:out value="${book.dateOfPublication}"/></td>
                    <td><c:out value="${book.quantity}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </figure>
</div>
</body>
</html>