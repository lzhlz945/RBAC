<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul style="padding-left:0px;" class="list-group">
    <c:forEach items="${permissionRoot.children}" var="permission">
        <%--判断li标签中有没有ul标签--%>
        <c:if test="${empty permission}">
            <li class="list-group-item tree-closed" >
                <a href="${permission.url}"><i class="${permission.icon}"></i> ${permission.name}</a>
            </li>
        </c:if>
        <c:if test="${not empty permission}">
            <li class="list-group-item tree-closed">
                <span><i class="${permission.icon}"></i> ${permission.name} <span class="badge" style="float:right">${permission.children.size()}</span></span>
                <ul style="margin-top:10px;display:none;">
                    <c:forEach items="${permission.children}" var="children">
                        <li style="height:30px;">
                            <a href="${Path_APP}${children.url}"><i class="${children.icon}"></i> ${children.name}</a>
                        </li>
                    </c:forEach>
                </ul>
            </li>
        </c:if>
    </c:forEach>
</ul>
