<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>요금 정산</title>
</head>
<body>
	<form>
    <input type="text" id="car_number" placeholder="차량 번호 입력">
    <button type="button" id="calculate">요금확인</button>
    <button type="button" id="checkOut">출차</button><br>
    <label id="calculate_result">요금 계산전 입니다</label>
    </form>
    <br>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script>

	$(document).ready(function(){
        $( "#calculate" ).click(function(e) {
            e.preventDefault();

            let data = { car_number: $('#car_number').val()};
            console.log(data);

            $.ajax({
                type: "POST",
                url: "/charge	",
                data: data,
               	contentType: 'application/x-www-form-urlencoded; charset=urc-kr',
                success: function(response) {
                    $('#calculate_result').text(response);
                },
                error: function(err) {
                    console.log("error!");
                }
            });
        });
	});
</script>
<script>

	$(document).ready(function(){
        $( "#checkOut" ).click(function(e) {
            e.preventDefault();

            let data = { car_number: $('#car_number').val()};
            console.log(data);

            $.ajax({
                type: "POST",
                url: "/parking_out",
                data: data,
                success: function(response) {
                    $('#calculate_result').text(response);
                },
                error: function(err) {
                    console.log("error!");
                }
            });
        });
	});
</script>
</body>
</html>