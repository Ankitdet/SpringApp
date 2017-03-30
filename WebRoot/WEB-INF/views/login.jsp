<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
<script>
$(document).ready(function(){
	
});
</script>
<script type="text/javascript" src="<c:url value="/resources/bootstrap/js/bootstrap.js"/>"></script>
<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>


      <form:form class="form-signin" name="loginform" method="post" action="login.do" commandName="users">
        <h2 class="form-signin-heading">Login</h2>
        <form:input path="username" class="form-control"/>
        <form:password path="password" class="form-control"/>
        <label class="checkbox" style="margin-left:20px">
          <input type="checkbox" value="remember-me">Remember me
        </label>
        
        <button name="Submit" id="submit" class="btn btn-primary" type="submit">Sign in</button>
		<button name="reset" class="btn btn-primary">Reset</button>
        <div id="message"></div>
      </form:form>

    </div> <!-- /container -->

