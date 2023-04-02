<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/user/taglib.jsp"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

	<div class=" content-container p-3" style="height: auto; ">
		<div class="col-12 col-lg-8 table-responsive">
			<table class="table table-dark table-hover caption-top" >
				<caption class="table-caption p-2">Members of the team</caption>
				<thead>
					<tr>
						<th>Mail</th>
						<th>Name</th>
						<th>Address</th>
						<th>Phone</th>
						<th>Function</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listAccount}" var="o">
						<c:if test="${o.role==2}">
							<tr>
								<th scope="row">${o.usr}</th>
								<td>${o.name}</td>
								<td>${o.address}</td>
								<td>${o.phone}</td>
								<td>
									<span style="${username == null ? "display:none;" : ""}">
									<a href="EditAccount?usermail=${o.usr}"
											>Update </a> </span>
									<span style="${username == null ? "display:none;" : ""}">
									<a href="DeleteAccount?usermail=${o.usr}"
										onclick="javascript:return confirm('Are you sure?')">
											Delete</a></span></td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
			<p>
				<a href="admin/createAccount.jsp" style="${usernameAdmin == null ? "display:none;" : ""}">Create new member</a>
			</p>
			<table class="table table-dark table-hover caption-top" >
				<caption class="table-caption p-2">Members User</caption>
				<thead>
					<tr>
						<th>Mail</th>
						<th>Name</th>
						<th>Address</th>
						<th>Phone</th>
						<th>Function</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listAccount}" var="o">
						<c:if test="${o.role==1}">
							<tr>
								<th scope="row">${o.usr}</th>
								<td>${o.name}</td>
								<td>${o.address}</td>
								<td>${o.phone}</td>
								<td>
									<span style="${username == null ? "display:none;" : ""}"><a
										href="EditAccount?usermail=${o.usr}">Update </a></span>
									<span style="${username == null ? "display:none;" : ""}"><a
										href="DeleteAccount?usermail=${o.usr}"
										onclick="javascript:return confirm('Are you sure?')">
											Delete</a></span></td>
							</tr>
						</c:if>
					</c:forEach>

				</tbody>
			</table>
		</div>

	</div>
	</div>

