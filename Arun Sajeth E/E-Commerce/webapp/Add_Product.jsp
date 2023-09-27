<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />

  <title>Digian</title>
  


  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

  <!-- font awesome style -->
  <link href="css/font-awesome.min.css" rel="stylesheet" />

  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />
  
  <style>
	body{
		background-color: lavender;
	}
</style>
  
</head>
<body >

<div class="hero_area">
    <!-- header section strats -->
    <header class="header_section">
      <div class="container-fluid">
        <nav class="navbar navbar-expand-lg custom_nav-container ">
          <a class="navbar-brand" href="index.jsp">
            <span>
             E-COMMERCE
            </span>
          </a>

          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class=""> </span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav  ">
              <li class="nav-item active">
                <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="Register.jsp"> Register</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="login.jsp">Login</a>
              </li>
            </ul>
            
          </div>
        </nav>
      </div>
    </header>
    <!-- end header section -->
    </div>

<center>
<h1 style="color:brown;"><b>WELCOME TO ADD PRODUCT PAGE</b></h1>
<form action="./Add_Product_Controller">
<table>
<tr>
<td><label style="color:black;">PRODUCT ID</label></td>
<td><input type="text" name="pid" value="" placeholder="Enter the Product id"></td>
</tr>
<tr>
<td><label style="color:black;">PRODUCT NAME</label></td>
<td><input type="text" name="pName" value="" placeholder="Enter the Product name"></td>
</tr>
<tr>
<td><label style="color:black;">PRODUCT DESCRIPTION</label></td>
<td><input type="text" name="pDesp" value="" placeholder="Enter the Product description"></td>
</tr>
<tr>
<td><label style="color:black;">PRODUCT PRICE</label></td>
<td><input type="text" name="pPrice" value="" placeholder="Enter the Product price"></td>
</tr>
<tr>
<td><label style="color:black;">PRODUCT QUANTITY</label></td>
<td><input type="text" name="pQty" value="" placeholder="Enter the Product quantity"></td>
</tr>
</table>
<br>
<input type="submit" value="ADD">
<input type="reset" value="CLEAR">

</form>
</center>
</body>
</html>