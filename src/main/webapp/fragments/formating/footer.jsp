<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="resources"/>

<div class="container">
    <footer class="py-md-5">
        <p class="text-center text-muted">2023 © <fmt:message key="app.title"/></p>
    </footer>
</div>