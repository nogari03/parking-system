<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
</head>
<body>
<form action="/customer" method="POST">
    <label for="name">이름</label>
    <input type="text" id="name" name="name"><br>
    <label for="phone">연락처</label>
    <input type="text" id="phone" name="phone"><br>
    <label for="car_number">차량 번호</label>
    <input type="text" id="car_number" name="car_number"><br>
    <label for="service_end">서비스 기간</label>
    <select id="service_end" name="service_end">
        <option value="1">1달</option>
        <option value="3">3달</option>
        <option value="6">6달</option>
    </select>
    <input type="submit" value="사용자 등록"/>
</form>
</body>
</html>