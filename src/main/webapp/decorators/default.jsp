<!DOCTYPE html>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="org.springframework.security.authentication.AnonymousAuthenticationToken"%>
<%@page import="org.springframework.security.core.Authentication"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page import="com.i2i.vehicleloan.model.User" %>
<%@page import="com.i2i.vehicleloan.model.Role" %>
<html lang="en">
<head>
    <meta http-equiv="Cache-Control" content="no-store"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="<c:url value="/images/favicon.ico"/>"/>
    <title><decorator:title/> | <fmt:message key="webapp.name"/></title>
    <t:assets type="css"/>
    <decorator:head/>
</head>
<body onload = "populateStates('state','city');" style="padding-top:0px;">
<decorator:getProperty property="body.class" writeEntireProperty="true"/>
    <decorator:getProperty property="body.id" writeEntireProperty="true"/>
    <decorator:body/>  
    
<% 
   Authentication auth = SecurityContextHolder.getContext().getAuthentication();
   if(!(auth instanceof AnonymousAuthenticationToken)){
       User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
       session.setAttribute("currentUserFullName", user.getFullName());
       session.setAttribute("currentUserId", user.getId());
       session.setAttribute("currentUser", user);
       for(Role role : user.getRoles()){
    	  session.setAttribute("currentRole", role.getName());    	  
       }
   }
%>    

</body>
</html>
