<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="resources"/>

<!DOCTYPE html>
<html lang="${sessionScope.locale}">

<head>
    <title><fmt:message key="readers"/></title>
    <jsp:include page="fragments/formating/formating.jsp"/>
    <jsp:include page="fragments/menus/mainMenu.jsp"/>
</head>
<body>
<div class="col-lg-8 mx-auto p-4 py-md-5">
    <figure>
        <figcaption><fmt:message key="list.of.readers"/></figcaption>
        <table class="table table-hover">
            <tbody class="text-center">
            <tr>
                <th><fmt:message key="user.id"/></th>
                <th><fmt:message key="firstname"/></th>
                <th><fmt:message key="lastname"/></th>
                <th><fmt:message key="email"/></th>
                <th><fmt:message key="phone.number"/></th>
                <th><fmt:message key="blocking.unblocking"/></th>
            </tr>
            <c:forEach var="user" items="${requestScope.readers}">
                <tr>
                    <td><c:out value="${user.userId}"/></td>
                    <td><c:out value="${user.userFirstname}"/></td>
                    <td><c:out value="${user.userLastname}"/></td>
                    <td><c:out value="${user.userEmail}"/></td>
                    <td><c:out value="${user.userPhoneNumber}"/></td>
                    <td></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </figure>
</div>
</body>
</html>
