<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath }/js/jquery-3.3.1.js"></script>
<title> </title>
<style>
	body{text-align:center;}
	table.tbl-student{
		margin:0 auto;
		border:1px solid #333;
		border-collapse:collapse;
	
	}
	
	th, td{
		border:1px solid #333;
		padding:5px;
	}
	
	th{text-align:right;}
	td{text-align:left;}
	
	tr:last-of-type td{
	text-align:center;
	
}
	
	
	
</style>

</head>
<body>
	<div id="student-container">
		<h2>학생정보검색</h2>
		<p>총 학생수는 ${count }입니다.</p>
		
		
		<form action="${pageContext.request.contextPath }/student/selectOne.do">
			<table class="tbl-student">

				<tr>
					<th>학생번호</th>
					<td><input type="number" name="no" id=""  value="${param.no}"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="검색" />
					</td>
				
				</tr>
			</table>
		</form>
		<c:if test="${not empty studentName }" >
			<p>학생이름은 ${studentName } 입니다.</p>
		</c:if>
		
		<c:if test="${not empty param.no && empty studentName }" >
			해당 학생은 존재 하지 않습니다.
		</c:if>
	</div>
	
	<hr />
		<p>삭제처리후에는 사용자에게 피드백을 준후 ( common/msg.jsp ), 현재페이지로 리다이렉트 시킬것.</p>
		<form action="${pageContext.request.contextPath }/student/deleteStudent.do">
			<table class="tbl-student">

				<tr>
					<th>삭제할 학생번호</th>
					<td><input type="number" name="no" id="" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="삭제" />
					</td>
				
				</tr>
			</table>
		</form>
		
		<hr />
		<h2>@실습문제 : ajax로 학생한명 정보 가져오기 </h2>
			<table class="tbl-student">
				<tr>
					<th>알고싶은 학생</th>
					<td><input type="number" name="no" id="del_id" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" id="btn-ajax-search" value="검색" />
					</td>
				</tr>
			</table>
			<div>
				<table id="tbl-ajax-student" class="tbl-student">
					<!-- ajax 처리결과  -->
				</table>
			</div>
<script>


$("#btn-ajax-search").click(function(){

	
	var id = $("#del_id").val();
	var student = $("#tbl-ajax-student");

	
	$.ajax({
		url : "${pageContext.request.contextPath}/student/selectOne.do",
		data : {type : "ajaxSelectOne", no : id},
		type : "post",
		dataType : "json",
		success : function(data){

			
			
			if(data != null){
				var html = "<tr><td>번호</td><td>이름</td><td>전화</td><td>이메일</td><td>주소</td><td>등록일</td></tr><tr>";
				
				for(i in data){
					html += "<td>" + data[i]  +"</td>";
				}
					html += "</tr>";
					student.html(html);
			}else{
				var html = "값이 없습니다.";
				student.html(html);
			}			
			
			
		}
	});
});




</script>

</body>
</html>