<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="resources"/>

<!DOCTYPE html>
<html lang="${sessionScope.locale}">

<head>
    <title><fmt:message key="app.title"/> <fmt:message key="sign.in"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="../fragments/formating/formating.jsp"/>
</head>

<body>

<jsp:include page="../fragments/menus/mainMenu.jsp"/>

<div class="col-lg-5 mx-auto p-4 py-md-5">

    <form method="POST" action="controller">
        <input type="hidden" name="action" value="sign-in">

        <div class="mb-1">
            <label class="form-label fs-5" for="email"><fmt:message key="email"/>: </label>
            <input class="form-control" type="email" name="email" id="email"
                   pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$" required value="${requestScope.email}">
        </div>

        <div class="mb-1">
            <label class="form-label  fs-5" for="password"><fmt:message key="password"/>: </label>
            <input class="form-control" type="password" name="password" id="password" required>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" onclick="showPass('password')" id="flexCheckDefault">
                <label class="form-check-label" for="flexCheckDefault"><fmt:message key="show.password"/></label>
            </div>
        </div>

        <button type="submit" class="btn btn-light mt-4 mb-4"><fmt:message key="sign.in"/></button>
    </form>

    <p class="fs-6 col-md-8">
        <fmt:message key="forgot.password"/>
        <a href="resetPassword.jsp" class="link-dark"><fmt:message key="reset.password"/></a>
    </p>

    <p class="fs-6 col-md-8">
        <fmt:message key="no.account"/>
        <a href="signUp.jsp" class="link-dark"><fmt:message key="sign.up"/></a>
    </p>
</div>

<jsp:include page="../fragments/formating/footer.jsp"/>

</body>
</html>