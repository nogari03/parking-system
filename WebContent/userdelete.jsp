<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 삭제</title>
</head>
<body>
회원 삭제
<form>
    <input type="text" id="deleteUser" placeholder="이름 입력">
    <button type="button" id="userDelete">삭제</button><br>
    <label id="delete_result">결과 대기중</label>
    </form>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script>

    $(document).ready(function(){
        $( "#userDelete" ).click(function(e) {
            e.preventDefault();

            let data = { user_name: $('#deleteUser').val()};
            console.log(data);

            $.ajax({
                type: "POST",
                url: "/user_delete",
               	data: data,
                success: function(response) {
                    $('#delete_result').text(response);
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