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
            <th><fmt:message key="order.id"/></th>
            <th><fmt:message key="user.id"/></th>
            <th><fmt:message key="book.id"/></th>
            <th><fmt:message key="subscription.type"/></th>
            <th><fmt:message key="status"/></th>
            <th><fmt:message key="create.time"/></th>
            <th><fmt:message key="return.deadline"/></th>
        </tr>
        <c:forEach var="order" items="${requestScope.orders}">
            <tr>
                <td><c:out value="${order.orderId}"/></td>
                <td ><c:out value="${order.userId}"/></td>
                <td><c:out value="${order.bookId}"/></td>
                <td><c:out value="${order.subscriptionType}"/></td>
                <td><c:out value="${order.orderStatusId}"/></td>
                <td><c:out value="${order.orderCreateTime}"/></td>
                <td><c:out value="${order.returnDeadline}"/></td>
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
