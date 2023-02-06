<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="resources"/>

<!DOCTYPE html>
<html lang="${sessionScope.locale}">

<head>
    <title><fmt:message key="librarians"/></title>
    <jsp:include page="fragments/formating/formating.jsp"/>
    <jsp:include page="fragments/menus/mainMenu.jsp"/>
</head>
<body>

<div class="col-lg-8 mx-auto p-4 py-md-5">
    <form method="post" action="controller">
        <input type="hidden" name="action" value="create-user-form">
        <button type="submit" class="btn btn-outline-primary float-left mt-1 mb-1">
            <h6>
                <i class="bi bi-person-add"></i>
                <fmt:message key="create.libtrarian"/>
            </h6>
        </button>
    </form>

    <div class="clearfix"></div>

    <figure>
        <figcaption><fmt:message key="list.of.librarians"/></figcaption>
        <table class="table table-hover mx-auto">
            <tbody class="text-center">
            <tr>
                <th><fmt:message key="user.id"/></th>
                <th><fmt:message key="firstname"/></th>
                <th><fmt:message key="lastname"/></th>
                <th><fmt:message key="email"/></th>
                <th><fmt:message key="phone.number"/></th>
                <th><fmt:message key="delete"/></th>
            </tr>
            <c:forEach var="librarian" items="${requestScope.librarians}">
                <tr>
                    <td><c:out value="${librarian.userId}"/></td>
                    <td><c:out value="${librarian.userFirstname}"/></td>
                    <td><c:out value="${librarian.userLastname}"/></td>
                    <td><c:out value="${librarian.userEmail}"/></td>
                    <td><c:out value="${librarian.userPhoneNumber}"/></td>
                    <td>
                        <form method="POST" action="controller">
                            <input type="hidden" name="action" value="delete-user">
                            <input type="hidden" name="user-id" value="${librarian.userId}">
                            <button type="button" class="btn btn-danger mt-6 mb-6" data-bs-toggle="modal"
                                    data-bs-target="#confirmDeleteModal">
                                <i class="bi bi-trash"></i>
                            </button>
                            <div class="modal fade" id="confirmDeleteModal" tabindex="-1"
                                 aria-labelledby="confirmDeleteModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header text-center">
                                            <h5 class="modal-title" id="confirmDeleteModalLabel"><fmt:message
                                                    key="confirm.delete"/></h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                    aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body text-center">
                                            <fmt:message key="are.you.shure"/>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                                <fmt:message key="cancel"/></button>
                                            <input type="hidden" name="action" value="delete-user">
                                            <input type="hidden" name="user-id" id="deleteUserId"
                                                   value="${librarian.userId}">
                                            <button type="submit" class="btn btn-danger"><fmt:message
                                                    key="delete"/></button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </figure>
</div>
</body>
</html>