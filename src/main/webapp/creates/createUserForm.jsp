<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="resources"/>

<!DOCTYPE html>
<html lang="${sessionScope.locale}">

<head>
    <title><fmt:message key="librarian.menu"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="../fragments/formating/formating.jsp"/>
</head>
<body>

<jsp:include page="../fragments/menus/mainMenu.jsp"/>

<div class="col-lg-5 mx-auto p-4 py-md-5">
    <form method="POST" action="controller">
        <input type="hidden" name="action" value="create-user">

        <div class="mb-1">
            <label class="form-label fs-5" for="email"><fmt:message key="email"/>: </label>
            <input class="form-control" type="email" name="email" id="email"
                   pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$" required value="${requestScope.email}">
        </div>

        <button type="submit" class="btn btn-light mt-4 mb-4"><fmt:message key="blocked.status"/></button>
    </form>
</div>
<jsp:include page="../fragments/formating/footer.jsp"/>
</body>
</html>
