<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="resources"/>

<li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
       aria-expanded="false">
        <fmt:message key="admin.menu"/>
    </a>
    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
        <li><a class="dropdown-item" href="controller?action=books-list"><fmt:message key="book.catalog"/></a></li>
        <li><a class="dropdown-item" href="controller?action=librarians-list"><fmt:message key="view.librarians"/></a></li>
        <li><a class="dropdown-item" href="controller?action=users-list"><fmt:message key="view.users"/></a></li>
        <%--        <li><hr class="dropdown-divider"></li>--%>
        <%--        <li><a class="dropdown-item" href="#">Something else here</a></li>--%>
    </ul>
</li>