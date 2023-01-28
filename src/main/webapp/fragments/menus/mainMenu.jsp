<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="resources"/>

<nav class="navbar navbar-expand-md navbar-dark bg-primary ">
    <div class="container-fluid">
        <a class="navbar-brand" href="../../index.jsp"><span class="mb-0 h5">LIBRARY</span></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarContent"
                aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <jsp:include page="menuChoice.jsp"/>
                <ul class="nav-item">
                    <a class="nav-link" href="../../about.jsp"><fmt:message key="about"/></a>
                </ul>
                <ul class="nav-item">
                    <a class="nav-link" href="../../contacts.jsp"><fmt:message key="contacts"/></a>
                </ul>


                <c:if test="${not empty sessionScope.loggedUser}">
                    <li class="nav-item">
                        <a class="nav-link" href="../../profile.jsp"><fmt:message key="profile"/></a>
                    </li>
                </c:if>
            </ul>
            <ul class="navbar-nav ms-auto mx-4 mb-4 mb-md-0">
                <c:choose>
                    <c:when test="${sessionScope.loggedUser eq null}">
                        <li class="nav-item">
                            <a class="nav-link" href="../../signIn.jsp"><fmt:message key="sign.in"/></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../../signUp.jsp"><fmt:message key="sign.up"/></a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="controller?action=sign-out"><fmt:message key="sign.out"/></a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
            <form method="POST" class="d-flex mt-2">
                <label>
                    <select name="locale" onchange='submit();'>
                        <option value="en" ${sessionScope.locale eq 'en' ? 'selected' : ''}>
                            <fmt:message key="en"/>
                        </option>
                        <option value="UK_UA" ${sessionScope.locale eq 'UA_UKR' ? 'selected' : ''}>
                            <fmt:message key="ua"/>
                        </option>
                    </select>
                </label>
            </form>
        </div>
    </div>
</nav>
