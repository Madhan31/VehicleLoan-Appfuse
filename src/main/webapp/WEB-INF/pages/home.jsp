<%@ include file="/common/taglibs.jsp"%>
<%@page import="com.i2i.vehicleloan.Constants" %>

	<% if (!(request.isUserInRole(Constants.ADMIN_ROLE))) {%>
		<c:redirect url="/userOperation"/>
	<%} %>
	
	<% if ((request.isUserInRole(Constants.ADMIN_ROLE))) {%>
		<c:redirect url="/adminOperation"/>
	<%} %>
