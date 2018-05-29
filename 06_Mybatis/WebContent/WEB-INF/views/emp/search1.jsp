<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> </title>
<style>
.searchType{font-size:50px;  vertical-align: middle; padding:10px; margin-bottom:30px; }
body{font-size:30px;}
table{border-collapse: collapse;}
table th{background:#333; color:#fff; font-weight:normal;}
table td, table th{border:1px solid #333; padding:10px; font-size:24px; }
</style>
</head>
<body>
<div id="emp-container">
<h2>사원정보 복수검색</h2>
<div id="search-container">
	<form action="search2.kh">
		<select name="searchType" class="searchType">
			<option value="" disabled selected>검색</option>
			<option value="emp_id" ${'emp_id' eq param.searchType ? "selected" : "" }>사번</option>
			<option value="emp_name" ${'emp_name' eq param.searchType ? "selected" : "" }>사원명</option>
			<option value="email" ${'email' eq param.searchType ? "selected" : "" }>이메일</option>
			<option value="phone" ${'phone' eq param.searchType ? "selected" : "" }>전화번호</option>
		</select>
		<input type="search" name="searchKeyword"class="searchType" />
		<!-- 성별 라디오 추가	 -->		
		<input type="radio" name="gender" id="man" value="남" />
		<label for="man">남성</label>
		
		<input type="radio" name="gender" id="woman" value="여" />
		<label for="woman">여성</label>
		&nbsp;
		
		<input type="submit" value="검색" class="searchType"/>
	</form>
</div>
<table class="tbl-emp">

	<tr>
		<th></th>
		<th>사번</th>
		<th>사원명</th>
		<th>주민번호</th>
		<th>성별</th>
		<th>이메일</th>
		<th>전화번호</th>
		<th>부서코드</th>
		<th>직급코드</th>
		<th>급레벨</th>
		<th>급여</th>
		<th>보너스율</th>
		<th>매니져사번</th>
		<th>입사일</th>
	</tr>

	<c:if test="${not empty list}">
		<c:forEach var="emp" items="${list}" varStatus="vs">
			<tr>
				<td>${vs.count}</td>
				<td>${emp["EMP_ID"]}</td>
				<td>${emp["EMP_NAME"]}</td>
				<td>${fn:substring(emp["EMP_NO"], 0, 8).concat("******")}</td>
				<td>${emp["GENDER"]}</td>
				<td>${emp["EMAIL"]}</td>
				<td>${emp["PHONE"]}</td>
				<td>${emp["DEPT_CODE"]}</td>
				<td>${emp["JOB_CODE"]}</td>
				<td>${emp["SAL_LEVEL"]}</td>
				<fmt:setLocale value="ko" />
				<td><fmt:formatNumber value="${emp.SALARY}" pattern="\#,###.##"/></td>
				<td><fmt:formatNumber value="${emp['BONUS'] }" type="percent"/></td>
				<td>${emp["MANAGER_ID"]}</td>
				<td><fmt:formatDate value="${emp.HIRE_DATE}" type="both" pattern="yyyy-MM-dd(E)"/></td>
			
			
			</tr>
		</c:forEach>
	</c:if>
	
	<c:if test="${empty list}">
	<tr>
		<td colspan="13" align="center">
			검색결과가 없습니다.
		</td>
	</tr>
	
	</c:if>
	
	
</table>

</div>

</body>
</html>