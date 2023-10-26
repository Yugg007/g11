<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sell Cars</title>
</head>
<body>
    <h1>Sell a Car</h1>
    <form action="sellCar" method="post">
        <input type="submit" value="Sell Car">
    </form>

    <h2>Available Cars for Sale</h2>
    <table border="1">
        <tr>
            <th>Car ID</th>
            <th>Model</th>
            <th>Price</th>
        </tr>
        <c:forEach items="${cars}" var="car">
            <tr>
                <td>${car.id}</td>
                <td>${car.model}</td>
                <td>${car.price}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
