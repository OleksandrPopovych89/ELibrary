<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%session.setAttribute("role", "LIBRARIAN");%>
<c:choose>
    <c:when test="${sessionScope.role eq 'ADMIN'}">
    <jsp:include page="adminMenu.jsp"/>
        </c:when>
        <c:when test="${sessionScope.role eq 'LIBRARIAN'}">
            <jsp:include page="librarianMenu.jsp"/>
        </c:when>
        <c:when test="${sessionScope.role eq 'READER'}">
            <jsp:include page="readerMenu.jsp"/>
        </c:when>
</c:choose>