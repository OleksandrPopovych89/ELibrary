<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="resources"/>

<!DOCTYPE html>
<html lang="${sessionScope.locale}">

<head>
    <title><fmt:message key="hello.page"/></title>
    <jsp:include page="fragments/formating/formating.jsp"/>
    <jsp:include page="fragments/menus/mainMenu.jsp"/>
</head>
<body>


<div class="container">
    <div class="header text-center my-5">
        <h1><fmt:message key="welcome"/></h1>
        <img src="<c:url value="img/lib.jpg"/>"
             alt="no image "
             class="img-fluid">
    </div>

</div>
</body>
</html>