<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Список маршрутных точек</title>
</head>
<body>
<table>
    <tr>
        <th>Груз</th>
        <th>Город</th>
        <th>Тип</th>
        <th>Обновить</th>
        <th>Удалить</th>
    </tr>
    <C:forEach var="waypoint" items="${waypoints}">

        <c:url var="updateButton" value="/admin/updateWaypoint">
            <c:param name="waypointId" value="${waypoint.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/admin/deleteWaypoint">
            <c:param name="waypointId" value="${waypoint.id}"/>
        </c:url>

        <tr>
            <td>${waypoint.cargo}</td>
            <td>${waypoint.city.name}</td>
            <td><c:if test="${waypoint.loading == false}">Выгрузка</c:if>
                <c:if test="${waypoint.loading == true}">Загрузка</c:if></td>
            <td><input type="button" value="Обновить" onclick="window.location.href='${updateButton}'"/></td>
            <td><input type="button" value="Удалить" onclick="window.location.href='${deleteButton}'"/></td>
        </tr>
    </C:forEach>
</table>
<input type="button" value="Добавить точку" onclick="window.location.href='addWaypoint'">
</body>
</html>