<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="resources"/>


<ul class="nav-item"><a class="nav-link" href="controller?action=books-list"><fmt:message key="books"/></a></ul>
<ul class="nav-item"><a class="nav-link" href="controller?action=librarians-list"><fmt:message key="librarians"/></a>
</ul>
<ul class="nav-item"><a class="nav-link" href="controller?action=readers-list"><fmt:message key="readers"/></a></ul>
<ul class="nav-item"><a class="nav-link" href="controller?action=orders-list"><fmt:message key="orders"/></a></ul>

