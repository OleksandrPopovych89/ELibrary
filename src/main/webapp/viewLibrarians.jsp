<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="resources"/>

<!DOCTYPE html>
<html lang="${sessionScope.locale}">

<head>
    <title>Title</title>
    <jsp:include page="fragments/formating/formating.jsp"/>
</head>
<body>

<jsp:include page="fragments/menus/mainMenu.jsp"/>

<div class="col-lg-8 mx-auto p-4 py-md-5">
    <table class="table table-hover" >
        <tbody align="center">
        <tr>
            <th><fmt:message key="sequence.number"/></th>
            <th><fmt:message key="user.id"/></th>
            <th><fmt:message key="firstname"/></th>
            <th><fmt:message key="lastname"/></th>
            <th><fmt:message key="email"/></th>
            <th><fmt:message key="phone.number"/></th>
            <th><fmt:message key="delete"/></th>
        </tr>
        <c:forEach var="librarian" items="${requestScope.librarians}">
            <tr>
                <td><c:out value="${librarian.userId}"/></td>
                <td ><c:out value="${librarian.userId}"/></td>
                <td><c:out value="${librarian.userFirstname}"/></td>
                <td><c:out value="${librarian.userLastname}"/></td>
                <td><c:out value="${librarian.userEmail}"/></td>
                <td><c:out value="${librarian.userPhoneNumber}"/></td>
                <td></td>
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
