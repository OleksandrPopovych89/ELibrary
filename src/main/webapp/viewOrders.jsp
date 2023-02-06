<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="resources"/>

<!DOCTYPE html>
<html lang="${sessionScope.locale}">

<head>
    <title><fmt:message key="orders"/></title>
    <jsp:include page="fragments/formating/formating.jsp"/>
    <jsp:include page="fragments/menus/mainMenu.jsp"/>
</head>
<body>
<div class="col-lg-8 mx-auto p-4 py-md-5">
    <figure>
        <figcaption><fmt:message key="list.of.orders"/></figcaption>
        <table class="table table-hover">
            <tbody class="text-center">
            <tr>
                <th><fmt:message key="order.id"/></th>
                <th><fmt:message key="firstname"/></th>
                <th><fmt:message key="lastname"/></th>
                <th><fmt:message key="title"/></th>
                <th><fmt:message key="subscription.type"/></th>
                <th><fmt:message key="status"/></th>
                <th><fmt:message key="create.time"/></th>
                <th><fmt:message key="return.deadline"/></th>
            </tr>
            <c:forEach var="order" items="${requestScope.orders}">
                <tr>
                    <td><c:out value="${order.orderId}"/></td>
                    <td><c:out value="${order.user.userFirstname}"/></td>
                    <td><c:out value="${order.user.userLastname}"/></td>
                    <td><c:out value="${order.book.bookTitle}"/></td>
                    <td><c:out value="${order.subscriptionType}"/></td>
                    <td><c:out value="${order.orderStatusId}"/></td>
                    <td><c:out value="${order.orderCreateTime}"/></td>
                    <td><c:out value="${order.returnDeadline}"/></td>
                    <td></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </figure>
</div>
</body>
</html>
