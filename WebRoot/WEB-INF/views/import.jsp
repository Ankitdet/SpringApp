<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
	String contextPath = request.getContextPath();
%>

<script type="text/javascript" src="<c:url value='<%=contextPath%>/js/jquery.js'/>"></script>
<script>
$(document).ready(function(){
});
</script>
<script type="text/javascript" src="<c:url value="<%=contextPath%>/bootstrap/js/bootstrap.js"/>"></script>
<link rel="stylesheet" href="<c:url value="<%=contextPath%>/bootstrap/css/bootstrap.min.css"/>">

<link rel="stylesheet" href="<c:url value="<%=contextPath%>/css/AdminLTE.min.css"/>">
