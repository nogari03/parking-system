<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
	회원 정보 수정
	<form action="/userupdate" method="POST">
		<label for="car_number">차량 번호</label><input type="text" id="car_number" name="car_number" placeholder="차량 번호 입력"><br>
		<label for="name">이름</label> <input type="text" id="name" name="name" placeholder="변경할 이름"><br>
		<label for="phone">연락처</label> <input type="text" id="phone" name="phone"placeholder="변경할 전화번호"><br>
		
		<input type="submit" value="정보 수정" />
	</form>
</body>
</html>