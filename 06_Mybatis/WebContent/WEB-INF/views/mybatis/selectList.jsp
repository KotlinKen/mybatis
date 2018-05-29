<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>학생목록</title>
<style>
div.student-container{text-align:center;}
table.tbl-student{margin: 0 auto; border: 1px solid; border-collapse: collapse;}
th, td{border: 1px solid; padding: 5px;}
</style>
</head>
<body>
	<div class="student-container">
		<h2>selectList - VO</h2>
		<p>sqlSession.selectList 호출결과 List&lt;Student>를 리턴받음</p>
		<table class="tbl-student">
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>주소</th>
				<th>등록일</th>
			</tr>
			<c:forEach items="${list}" var="v" >
				<<<<<
				<tr>
					<td>${v.studentNo }</td>
				
					<td>${v.studentName }</td>
				
					<td>${v.studentTel }</td>
				
					<td>${v.studentEmail }</td>
				
					<td>${v.studentAddr }</td>
				
					<td>${v.regDate }</td>
				</tr>
			
			</c:forEach>
		</table>
	</div>
	<br />
	
	<hr />
		<div class="student-container">
		<h2>selectMapList - VO</h2>
		<p>sqlSession.selectList 호출결과 List&lt;Student>를 리턴받음</p>
		<table class="tbl-student">
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>주소</th>
				<th>등록일</th>
			</tr>
			<c:forEach items="${mapList}" var="v" >
				<<<<<
				<tr>
					<td>${v.get("STUDENT NO") }</td>
				
					<td>${v.get("STUDENT NAME") }</td>
				
					<td>${v.get("STUDENT TEL") }</td>
				
					<td>${v["STUDENT EMAIL"] }</td>
				
					<td>${v["STUDENT ADDR"] }</td>
				
					<td>${v["REG DATE"] }</td>
				</tr>
			
			</c:forEach>
		</table>
	</div>
	<br />
</body>
</html>