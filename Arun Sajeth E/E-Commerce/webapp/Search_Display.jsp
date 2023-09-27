<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
 <%@ page import="java.util.List" %>
 <%@ page import="project.model.Product" %>
<!DOCTYPE html>
<html lang="en">

<head>
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
              <li class="nav-item">
                <a class="nav-link" href="User_View_Product_Controller"> View Product</a>
              </li>
              <li class="nav-item active">
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
	<input type="search" name="search" value="" placeholder="Enter the product of search" style="width:90%; height:15%;">
	<input type="submit" value="SEARCH">
	
	

<br><br>

<table style="width:100%">
<thead>
<tr>
<th colspan=1>PRODUCT NAME</th>
<th colspan=1>PRODUCT PRICE</th>
<th colspan=1>ADD TO WISH LIST</th>
<th colspan=1>ADD TO CART</th>
<th colspan=1>BUY</th>

</tr>
</thead>
<tbody>
	<%
	List<Product> data = (List<Product>)request.getAttribute("list");
	for(Product d : data)
	{
	%>
	<tr>
	
	<td><h4><a href="Description_Controller?prodid=<%= d.getPid() %>">
	<%= d.getpName() %></a></h4></td>
	<td><h4><%= d.getpPrice() %></h4></td>
	<form action="User_View_Choice_Controller">
	<input type="hidden" name=pid value="<%= d.getPid() %>">
	<td><input type="submit" name="viewchoice" value="ADD TO WIST LIST"></td>
	<td><input type="submit" name="viewchoice" value="ADD TO CART"></td>
	<td><input type="submit" name="viewchoice" value="BUY"></td>
	
	</form>
	</tr>
	<% } %>	
</tbody>
</table>
	
	</form>
</body>

</html>