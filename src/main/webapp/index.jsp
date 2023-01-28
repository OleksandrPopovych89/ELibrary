<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="resources"/>

<!DOCTYPE html>
<html lang="${sessionScope.locale}">

<head>
    <title><fmt:message key="app.title"/></title>
    <jsp:include page="fragments/formating/formating.jsp"/>
</head>

<body>

<jsp:include page="fragments/menus/mainMenu.jsp"/>

<footer>
    <jsp:include page="fragments/formating/footer.jsp"/>
</footer>
</body>
</html>