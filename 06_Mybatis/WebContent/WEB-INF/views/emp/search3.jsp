<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*"%>
    <%
    
    
    String[] job_codeArr = request.getParameterValues("job_code");
    List<String> jobList = null;
    if(job_codeArr != null) jobList = Arrays.asList(job_codeArr);
    
    String[] dept_codeArr = request.getParameterValues("dept_code");
    List<String> deptList = null;
    if(dept_codeArr != null) deptList = Arrays.asList(dept_codeArr);
    
    
    %>
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
<h2>사원</h2>
<div id="search-container">
	<form action="search3.kh">
	<table>
		<tr>
			<th>직급</th>
			<td>
				<input type="checkbox" name="job_code" id="J1" value="J1" <%= jobList != null && jobList.contains("J1") ? "checked" : "" %> />
				<label for="J1">대표</label>
				<input type="checkbox" name="job_code" id="J2" value="J2" <%= jobList != null && jobList.contains("J2") ? "checked" : "" %>/>
				<label for="J2">부사장</label>
				<input type="checkbox" name="job_code" id="J3" value="J3" <%= jobList != null && jobList.contains("J3") ? "checked" : "" %>/>
				<label for="J3">부장</label>
				<input type="checkbox" name="job_code" id="J4" value="J4" <%= jobList != null && jobList.contains("J4") ? "checked" : "" %>/>
				<label for="J4">차장</label>
				<input type="checkbox" name="job_code" id="J5" value="J5" <%= jobList != null && jobList.contains("J5") ? "checked" : "" %>/>
				<label for="J5">과장</label>
				<input type="checkbox" name="job_code" id="J6" value="J6" <%= jobList != null && jobList.contains("J6") ? "checked" : "" %>/>
				<label for="J6">대리</label>
				<input type="checkbox" name="job_code" id="J7" value="J7" <%= jobList != null && jobList.contains("J7") ? "checked" : "" %>/>
				<label for="J7">사원</label>
			</td>
		</tr>
		<!-- @실습문제 : 부서 -->
		
		<tr>
			<th>부서</th>
			<td>
				<input type="checkbox" name="dept_code" id="D1" value="D1" <%= deptList != null && deptList.contains("D1") ? "checked" : "" %> />
				<label for="D1">인사관리부</label>
				<input type="checkbox" name="dept_code" id="D2" value="D2" <%= deptList != null && deptList.contains("D2") ? "checked" : "" %>/>
				<label for="D2">회계관리부</label>
				<input type="checkbox" name="dept_code" id="D3" value="D3" <%= deptList != null && deptList.contains("D3") ? "checked" : "" %>/>
				<label for="D3">마케팅부</label>
				<input type="checkbox" name="dept_code" id="D4" value="D4" <%= deptList != null && deptList.contains("D4") ? "checked" : "" %>/>
				<label for="D4">국내영업부</label>
				<input type="checkbox" name="dept_code" id="D5" value="D5" <%= deptList != null && deptList.contains("D5") ? "checked" : "" %>/>
				<label for="D5">해외영업1부</label>
				<input type="checkbox" name="dept_code" id="D6" value="D6" <%= deptList != null && deptList.contains("D6") ? "checked" : "" %>/>
				<label for="D6">해외영업2부</label>
				<input type="checkbox" name="dept_code" id="D7" value="D7" <%= deptList != null && deptList.contains("D7") ? "checked" : "" %>/>
				<label for="D7">해외영업3부</label>
				<input type="checkbox" name="dept_code" id="D8" value="D8" <%= deptList != null && deptList.contains("D8") ? "checked" : "" %>/>
				<label for="D8">기술지원부</label>
				<input type="checkbox" name="dept_code" id="D9" value="D9" <%= deptList != null && deptList.contains("D9") ? "checked" : "" %>/>
				<label for="D9">총무부</label>
				<input type="checkbox" name="dept_code" id="dept_no" value="dept_none" <%= deptList != null && deptList.contains("dept_none") ? "checked" : "" %>/>
				<label for="dept_no">부서없음</label>
			</td>
		</tr>
		
		
		
		
		
		
		<tr>
			<th colsapn="2">
				<input type="submit" value="검색" />
			</th>
		</tr>
	</table>
	</form>
</div>
	<c:if test="${not empty param }">
 		<p>총 검색건수는 ${totalCount }건 입니다.</p> 
	</c:if>
<table class="tbl-emp">
	
	
	
	<tr>
		<th></th>
		<th>사번</th>
		<th>사원명</th>
		<th>주민번호</th>
		<th>이메일</th>
		<th>전화번호</th>
		<th>부서</th>
		<th>직급</th>
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
				<td>${emp["EMAIL"]}</td>
				<td>${emp["PHONE"]}</td>
				<td>${emp["DEPT_TITLE"]}</td>
				<td>${emp["JOB_NAME"]}</td>
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
<script>

$("#man").click(function(){
	console.log(this.checked);
	console.log(this);
	$(this).attr("checked", false);
	
})

</script>
</body>
</html>