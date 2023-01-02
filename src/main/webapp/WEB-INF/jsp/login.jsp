<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="<c:url value="/resources/Css/login.css"/>">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
</head>
<body>
	<div class="container">
		<div class="left">
			<h1>Sign in</h1>
			<div style="${error==null ? "display:none;" : "color:red;text-align:center;"} ">${error}</div>
			<form name="login-form" action="login.html" method="post">

				<div>
					<input type="text" name="username" class="input-box"
						placeholder="Input your email">
				</div>
				<div>
					<input type="password" name="password" class="input-box"
						placeholder="Input your password">
				</div>
				<div>
					<span><a href="#" title="forgot" class="forgot">Forgot
							your password</a></span>
				</div>

				<div class="remember">
					<input type="checkbox" name="remember"> <label
						for="remember">Remember me</label>
				</div>
				<input class="submit-button" type="submit" value="LOGIN"> <input
					class="submit-button" type="reset" value="RESET">

			</form>
		</div>
		<div class="right">
			<div class="content">
				<h1>Welcome back!</h1>
				<p>
					To keep connected with us <br>please login with your personal
					info!<br>
				</p>
			</div>
		</div>
	</div>
	`
</body>

</html>