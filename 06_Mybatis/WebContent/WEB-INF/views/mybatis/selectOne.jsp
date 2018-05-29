<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
<script src="${pageContext.request.contextPath }/js/jquery-3.3.1.js"></script>
<style>
body{text-align: center;}
div#student-container{text-align: center;}
table.tbl-student{margin: 0 auto; border: 1px solid; border-collapse: collapse;}
th,td{border: 1px solid; padding: 5px;}
th{text-align: right;}
td{text-align: left;}
td:last-of-type {text-align: center;}
</style>
</head>
<body>
	<div id="student-container">
		<h2>학생정보검색</h2>
		<p>총 학생 수 : ${count }</p>
	</div>
	<form action="${pageContext.request.contextPath }/student/selectOne.do">
		<table class="tbl-student">
			<tr>
				<th>학생번호</th>
				<td>
					<input type="number" name="no" value="${param.no }"/>
				</td>
			</tr>	
			<tr>
				<td colspan="2">
					<input type="submit" />
				</td>
			</tr>	
		</table>
	</form>
	<c:if test="${not empty studentName }">
	<p>학생이름은 ${studentName }입니다</p>
	</c:if>
	<c:if test="${not empty param.no && empty studentName }">
		해당 학생은 존재하지 않습니다.
	</c:if>
	
	<hr />
		<h2>@실습문제 : 특정학생 삭제하기</h2>
		<p>삭제처리후에는 사용자에게 피드백을 준 후(common/msg.jsp) 현제페이지로 리다이렉트시킬것</p>
		<form action="${pageContext.request.contextPath }/student/deleteStudent.do">
		<table class="tbl-student">
			<tr>
				<th>학생번호</th>
				<td>
					<input type="number" name="no" value="${param.no }"/>
				</td>
			</tr>	
			<tr>
				<td colspan="2">
					<input type="submit" />
				</td>
			</tr>	
		</table>
	</form>

	<hr />
	<h2>@실습문제 : ajax으로 학생한명 정보 가져오기</h2>
		<table class="tbl-student">
			<tr>
				<th>조회할 학생번호</th>
				<td>
					<input type="number" name="no" value="${param.no }" id="input"/>
				</td>
			</tr>	
			<tr>
				<td colspan="2">
					<input type="button" id="btn-ajax-search"  value="제출"/>
				</td>
			</tr>	
		</table>
		<div>
			<table id="tbl-ajax-student" class="tbl-student" >
			</table>
		</div>

<script>
$(function () {
	$("#btn-ajax-search").click(function () {
		var studentNo = $("#input").val()
		$.ajax({
			url:"${pageContext.request.contextPath }/student/searchStudent.do",
			data:{studentNo:studentNo},
			type:"post",
			dataType:"json",
			success:function(data){
				var html = "";
				html += "<tr>";
				html += "<td>번호</td>"
				html += "<td>"+data.studentNo;
				html += "</td></tr>";
				html += "<tr>";
				html += "<td>이름</td>"
				html += "<td>"+data.studentName;
				html += "</td></tr>";
				html += "<tr>";
				html += "<td>전화번호</td>"
				html += "<td>"+data.studentTel;
				html += "</td></tr>";
				html += "<tr>";
				html += "<td>주소</td>"
				html += "<td>"+data.studentAddr;
				html += "</td></tr>";
				html += "<tr>";
				html += "<td>입학일</td>"
				html += "<td>"+data.regDate;
				html += "</td></tr>";
				
				$("#tbl-ajax-student").html(html);
				
			},
			error:function(jqxhr,textStatus,errorThrown){
				console.log("ajax처리실패");
				console.log(jqxhr);
				console.log(textStatus);
				console.log(errorThrown);
			}
		});	
	});
});

if (document.all)

{

    document. Function("if (event.button==2) alert!(´Permission denied!´)")

}

</script>

</body>
</html>