<%@ include file="/common/taglibs.jsp" %>     
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <link rel="stylesheet" href="css/style.css">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <title>Loan Detail</title>
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
        <li><a href="home">Home</a></li>
       
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Vehicle Operation<span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="insertVehicle">Add Vehicle</a></li>
              <li><a href="deleteVehicle">Delete Vehicle</a></li>
              <li><a href="retrieveAllVehicle">Display All Vehicle</a></li> 
            </ul>
          </li>
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Vehicle Model Operation<span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="insertVehicleModel">Add Vehicle Model</a></li>
              <li><a href="deleteVehicleModel">Delete Vehicle Model</a></li>
              <li><a href="retrieveAllVehicleModel">Display All Vehicle Model</a></li> 
            </ul>
          </li>
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Company Operation<span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="insertCompany">Add Company</a></li>
              <li><a href="deleteCompany">Delete Company</a></li>
              <li><a href="retrieveAllCompany">Display All Company</a></li> 
            </ul>
          </li>
         <li class = "active"><a href="#">Loan Payment</a></li>
        <li><a href="admin/users">Administrators</a></li>
        <li><a href="usersDetail">Users Detail</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="logout"><span class="glyphicon glyphicon-log-in" style="color:red"></span> Log out</a></li>
      </ul>
    </div>
  </div>
  </nav>
  <div class="jumbotron text-center" style="padding-top: 2px; padding-bottom: 13px;">
            <h1><small>All User Detail</small></h1>
            </div> 
            <div class = "container">
        <c:if test = "${users != null}">
            <table class="table">
                <thead>
                <tr class = "success">
                    <th>User ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="users">
                    <tr class = "info">
                        <td><c:out value="${users.id}" /></td>
                        <td><c:out value="${users.firstName}" /></td>
                        <td><c:out value="${users.lastName}" /></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>   
        </div>
  <div class="jumbotron text-center" style="padding-top: 2px; padding-bottom: 13px;">
            <h1><small>Enter User Id To Make Payment</small></h1>
  </div> 
  <div class = "panel panel-default col-sm-offset-4 col-sm-4 col">
   <div class = "panel-heading">
      <h2 class = "panel-title text-center title-style">
         Loan Payment
      </h2>
   </div>   
      <div class = "panel-body"><br>
        <form action = "payment" class= "login-form">
        <div class="form-group">
            <table id = "table td th">
                <tr>
                <td>User Id</td>
                <td><input type = "text" name = "userId" required = "required" /></td>                
                </tr>
                </table>
                <div class = "panel-footer footer-align"><input type = "submit" name = "button" value = "Search" class="btn btn-info btn-lg pull-right col-sm-4 border input-align"/></div>
        </div>
        </form>
        </div>
        </div>
    </body>
     <c:if test="${message != null}" >
        <script language = "javaScript" type = "text/javascript">
            alert('<c:out value = "${message}" />');
        </script>
    </c:if>
</html>
