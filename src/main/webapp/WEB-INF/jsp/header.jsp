<div class="header">
	<div class="left-header">
		<h1>CELLPHONE S</h1>
		<h2>${username == null? "Welcome to my Webside": username}</h2>
	</div>

</div>

<div class="topnav"
	style="background-color: #293847; color: black; height: 250px;">
	<a href="${pageContext.request.contextPath}/home.html">Home</a> <a
		href="#">Products</a> <a
		href="${pageContext.request.contextPath}/login.html"
		style="float: right;${username!=null?"display:none;":""}">Log in</a> <a
		href="${pageContext.request.contextPath}/home.html"
		style="float: right;${username==null?"display:none;":""}">Log out</a>
</div>
