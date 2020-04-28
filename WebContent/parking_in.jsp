<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>입차</title>
</head>
<body>
	<form>
    <input type="text" id="inNumber" placeholder="차량 번호 입력">
    <button type="button" id="checkIn">입차</button><br>
    <label id="in_result">입차대기</label>
    </form>
    <br>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script>

    $(document).ready(function(){
        $( "#checkIn" ).click(function(e) {
            e.preventDefault();

            let data = { car_number: $('#inNumber').val()};
            console.log(data);

            $.ajax({
                type: "POST",
                url: "/parking_in",
               	data: data,
                success: function(response) {
                    $('#in_result').text(response);
                },
                error: function(err) {
                    console.log("error!");
                }
            });
        });
    });
</script>
<script>

alert('no blank')
history.back()
</script>
</body>
</html>
