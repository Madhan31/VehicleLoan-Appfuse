<%@ include file="/common/taglibs.jsp" %>  
<html>
    <title>Admin Operation</title>
        <link rel="stylesheet" href="css/style.css">
    <head>
        <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
   .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 80%;
      margin: auto;
  }
  </style>  
    </head>
    
    <body>
   <body data-spy="scroll" data-target=".navbar" data-offset="50">

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
        <li class = "active"><a href="">Home</a></li>
       
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
         <li><a href="loanDetail">Loan Payment</a></li>
        <li><a href="admin/users">Administrators</a></li>
        <li><a href="usersDetail">Users Detail</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="logout"><span class="glyphicon glyphicon-log-in" style="color:red"></span> Log out</a></li>
      </ul>
    </div>
  </div>
  </nav>
<div class="container-fluid text-center">   	 
<div class="row content">
<div class="col-md-8 text-left"> 
<div class="container" style = "border-left-style: solid; border-left-width: 0px; margin-left: 42px;">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="img/bikes10.png" alt="bike" width="460" height="345">
      </div>
    
      <div class="item">
        <img src="img/bikes7.png" alt="bike" width="460" height="345">
      </div>
    
      <div class="item">
        <img src="img/bikes8.png" alt="bike" width="460" height="345">
      </div>

      <div class="item">
        <img src="img/bikes9.png" alt="bike	" width="460" height="345">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
    </div>	
  </div>
</div>

</body>
</html>
