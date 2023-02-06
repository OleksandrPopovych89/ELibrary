<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="resources"/>

<!DOCTYPE html>
<html lang="${sessionScope.locale}">

<head>
    <title>
        <c:choose>
            <c:when test="${sessionScope.role eq 'ADMIN'}"><fmt:message key="create"/></c:when>
            <c:otherwise><fmt:message key="sign.up"/> </c:otherwise>
        </c:choose>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="fragments/formating/formating.jsp"/>
    <jsp:include page="fragments/menus/mainMenu.jsp"/>
</head>
<body>

<div class="col-lg-5 mx-auto p-4 py-md-5">
    <form method="POST" action="controller">
        <input type="hidden" name="action" value="create-user">

        <div>
            <label class="form-label fs-5" for="email"><fmt:message key="firstname"/>: </label>
            <input class="form-control" type="firstname" name="firstname" id="firstname"
                   pattern="^[ A-ZА-ЯЄІЇҐ][a-zа-яєіїґ]+([ -][A-ZА-ЯЄІЇҐ][a-zа-яєіїґ]+)?$" required
                   value="${requestScope.email}">
        </div>

        <div>
            <label class="form-label fs-5" for="lastname"><fmt:message key="lastname"/>: </label>
            <input class="form-control" type="lastname" name="lastname" id="lastname"
                   pattern="^[ A-ZА-ЯЄІЇҐ][a-zа-яєіїґ]+([ -][A-ZА-ЯЄІЇҐ][a-zа-яєіїґ]+)?$" required
                   value="${requestScope.email}">
        </div>
        <div>
            <label class="form-label fs-5" for="phone-number"><fmt:message key="phone.number"/>: </label>
            <input class="form-control" type="phone-number" name="phone-number" id="phone-number"
                   pattern="^\+380-\d{2}-\d{2}-\d{2}-\d{3}$" required value="${requestScope.email}">
        </div>

        <div>
            <label class="form-label fs-5" for="email"><fmt:message key="email"/>: </label>
            <input class="form-control" type="email" name="email" id="email"
                   pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$" required value="${requestScope.email}">
        </div>

        <div>
            <label class="form-label  fs-5" for="password"><fmt:message key="password"/>: </label>
            <input class="form-control" type="password" name="password" id="password"
                   pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,20}$" required>

            <div class="form-check">
                <input class="form-check-input" type="checkbox" onclick="showPass('password')" id="flexCheckDefault">
                <label class="form-check-label" for="flexCheckDefault"><fmt:message key="show.password"/></label>
            </div>
        </div>

        <button type="submit" class="btn btn-light mt-4 mb-4">
            <c:choose>
                <c:when test="${sessionScope.role eq 'ADMIN'}"><fmt:message key="create"/></c:when>
                <c:otherwise><fmt:message key="sign.up"/></c:otherwise>
            </c:choose>
        </button>
    </form>
</div>
</body>
</html>
