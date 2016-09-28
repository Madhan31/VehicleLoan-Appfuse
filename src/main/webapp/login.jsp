<%@ include file="/common/taglibs.jsp" %>
<html lang="en">
<head>
    <title>I2I Vehicle Loan</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/bootstrap.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="padding-top:0px;">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="about">About</a></li>
        <li><a href="contact">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="signup"><span class="glyphicon glyphicon-log-in" style = "color:blue;"></span> New User</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container-fluid text-center">    
  <div class="row content">
<div class="col-md-8 text-left"> 
<div id="mycarousel" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner">
        <div class="item active">
        <img src="img/twowheeler.png" alt="" class="img-responsive">
           <div class="carousel-caption">
                                        
           </div>
        </div>
    </div>
</div>
<h1>Welcome</h1>
      <p>I2I Vehicle Loan pvt ltd is one of the superior, proactive loan service in the world. While providing cost effective, responsive service to others in our role as a development bank, and in doing so, meet the requirements of our stakeholders.
      	We, at I2I pvt ltd, are commited to become the bank of choice by providing SUPERIOR, PRO-ACTIVE, INNOVATIVE, STATE-OF-THE-ART banking services with an attitude of care and concern for the customers and patrons. </p>
      <hr>
    </div>
    <div class="row row-bottom-margin">
    <div class="col-sm-4 sidenav">
<div class = "panel panel-default col-sm-offset-0 col-sm-11 col">
   <div class = "panel-heading">
      <h2 class = "panel-title text-center title-style">
         Login
      </h2>
   </div>    
<form method="post" id="loginForm" action="<c:url value='/j_security_check'/>"
    onsubmit="saveUsername(this);return validateForm(this)" class="form-signin" autocomplete="off">
    <c:if test="${param.error != null}">
    <div class="alert alert-danger alert-dismissable">
        <fmt:message key="errors.password.mismatch"/>
    </div>
</c:if>
    <input type="text" name="j_username" id="j_username" class="form-control"
           placeholder="<fmt:message key="label.username"/>" required tabindex="1">
    <input type="password" class="form-control" name="j_password" id="j_password" tabindex="2"
           placeholder="<fmt:message key="label.password"/>" required>

<c:if test="${appConfig['rememberMeEnabled']}">
    <label for="rememberMe" class="checkbox">
        <input type="checkbox" name="_spring_security_remember_me" id="rememberMe" tabindex="3"/>
        <fmt:message key="login.rememberMe"/></label>
</c:if>

    <button type="submit" class="btn btn-lg btn-primary btn-block" name="login" tabindex="4">
        <fmt:message key='button.login'/>
    </button>
</form>
</div>
</div>
</div>
</div>
</div>
<c:if test="${null != message}" >
        <script language = "javaScript" type = "text/javascript">
            alert('<c:out value = "${message}" />');
            window.location.href="homePage";
        </script>
    </c:if>
</body>