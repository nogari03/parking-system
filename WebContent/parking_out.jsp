<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>출차</title>
</head>
<body>
	<form>
    <input type="text" id="outNumber" placeholder="차량 번호 입력">
    <button type="button" id="checkOut">출차</button><br>
    <label id="out_result">출차대기</label>
    </form>
    <br>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script>

	$(document).ready(function(){
        $( "#checkOut" ).click(function(e) {
            e.preventDefault();

            let data = { car_number: $('#outNumber').val()};
            console.log(data);

            $.ajax({
                type: "POST",
                url: "/parking_out",
                data: data,
                success: function(response) {
                    $('#out_result').text(response);
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