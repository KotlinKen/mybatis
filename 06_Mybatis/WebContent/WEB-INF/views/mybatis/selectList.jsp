<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, com.kh.mybatis.model.vo.*"%>
    <%
    
    	/* List<Student> list = (List<Student>) request.getParameter("list"); */
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학생목록</title>

</head>

<body>
	<div id="student-container">
		<h2>selectList - VO </h2>
		<p>sqlSession.selectList 호출결과 List student를 리턴받음 </p>
		
		<table class="tbl-student">
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>주소</th>
				<th>등록일</th>
			</tr>
			
		
	<c:forEach var="v" items="${list}" varStatus="vs">
	<tr>
		<td>${v.studentNo}</td>
		<td>${v.studentName}</td>
		<td>${v.studentTel}</td>
		<td>${v.studentEmail}</td>
		<td>${v.studentAddr}</td>
		<td>${v.regDate}</td>
	</tr>
	</c:forEach>
		
		</table>
		
		
		
		
		
		<hr />
		<h2>selectList - MAP </h2>
		<p>sqlSession.selectMAP 호출결과 List String String 를 리턴받음 </p>
		
		<table class="tbl-student">
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>주소</th>
				<th>등록일</th>
			</tr>
			
		
	<c:forEach var="v" items="${mapList}" varStatus="vs">
	
	${v[1] }
	
	<tr>
		<td>${v.get("STUDENT NO")}</td>
		<td>${v.get("STUDENT NAME")}</td>
		<td>${v.get("STUDENT TEL")}</td>
		<td>${v.get("STUDENT EMAIL")}</td>
		<td>${v.get("STUDENT ADDR")}</td>
		<td>${v.get("REG DATE")}</td>
	</tr>
	</c:forEach>
		
		</table>
		
		
	</div>
</body>
</html>