<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isErrorPage="true" %>

<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="resources"/>

<!DOCTYPE html>
<head>
    <title><fmt:message key="oops"/></title>
    <jsp:include page="fragments/formating/formating.jsp"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
<div class="col-lg-5 mx-auto p-4 py-md-5">
    <p class="fs-4 col-md-8 text-error"><fmt:message key="global.error"/></p><br><br><br>

    <p class="fs-6 col-md-8"><a href="index.jsp" class="link-dark"><fmt:message key="to.main"/></a></p>
</div>

<jsp:include page="fragments/formating/footer.jsp"/>

</body>
</html>