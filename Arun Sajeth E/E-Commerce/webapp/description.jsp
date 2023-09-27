<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
 <%@ page import="java.util.List" %>
 <%@ page import="project.model.Product" %>
<!DOCTYPE html>
<html>
<head>

<style>
table, th, td {
  border: 3px hidden black;
  color: black;
  
}
</style>
<style>
	body{
		background-color: lavender;
	}
</style>

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

</head>


<body>

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
              <li class="nav-item">
                <a class="nav-link" href="Home.jsp">Home <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item active">
                <a class="nav-link" href="User_View_Product_Controller"> View Product</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="Search_Product.jsp"> Search Product</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="DisplayWishLIst_Controlller"> MyList</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="DisplayAddCart_Controller"> MyCart</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="Logout"> Logout</a>
              </li>
            </ul>
            
          </div>
        </nav>
      </div>
    </header>
    <!-- end header section -->
    </div>

<br><br>
   
<center>
<table style="width:50%">

<% Product prod = (Product) request.getAttribute("product"); %>
<tr>
<td><label>PRODUCT NAME</label></td>
<td><label><%= prod.getpName() %></label> </td>
</tr>
<tr>
<td><label>PRODUCT NAME</label></td>
<td><label><%= prod.getpDesp() %></label></td>
</tr>
<tr>
<td><label>PRODUCT NAME</label></td>
<td><label><%= prod.getpPrice() %></label></td>
</tr>
</table>

<form action="User_View_Choice_Controller">
	<input type="hidden" name=pid value="<%= prod.getPid() %>">
	<input type="submit" name="viewchoice" value="ADD TO WIST LIST">
	<input type="submit" name="viewchoice" value="ADD TO CART">
	<input type="submit" name="viewchoice" value="BUY">
</form>
</center>
</body>
</html>