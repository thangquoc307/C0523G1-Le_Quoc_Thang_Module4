<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chuyển đổi tiền tệ</title>
</head>
<body>
<form method="post">
    <select name="changeTo">
        <option value="1" ${change.equals("1") ? "selected" : ""}>VND to USD</option>
        <option value="2" ${change.equals("2") ? "selected" : ""}>USD to VND</option>
    </select>
    <input name="currency" type="number" value="${input}">
    <button type="submit">change</button>

    <h3>Kết quả : ${result}</h3>
</form>
</body>
</html>