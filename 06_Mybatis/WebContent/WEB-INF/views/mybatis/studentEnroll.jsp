<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학생등록 </title>
<style>
	div#enroll-container{text-align:center; width:500px; margin:0 auto;}
	#tbl-student{width:500px; border-collapse: collapse;}
	#tbl-student td, #tbl-student th{border:1px solid #ececec; padding:10px; }
	#tbl-student td input{padding:10px; }
	#tbl-student td .btn_student{padding:20px 30px;  background:#333; color:#fff; border:none;}
	
</style>
</head>

<body>
<div id="enroll-container">
	<h2>학생등록</h2>
	<form action="${pageContext.request.contextPath}/student/studentEnrollEnd.do">
		<table id="tbl-student">
			<tr>
				<th>학생이름</th>
				<td>
					<input type="text" name="studentName"/>
				
				</td>
			</tr>
			
			<tr>
				<th>전화번호</th>
				<td>
					<input type="tel" name="studentTel" maxlength=11 required/>
				
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<input type="email" name="studentEmail" required/>
				
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<input type="text" name="studentAddr"/>
				
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록" class="btn_student"/>
				</td>
			</tr>
		</table>
	</form>

</div>

</body>
</html>