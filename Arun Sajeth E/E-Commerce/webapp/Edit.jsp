<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
 <%@ page import="java.util.List" %>
 <%@ page import="project.model.Product" %>
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
table, th, td {
  border: 3px solid black;
  color: black;
  border-collapse: collapse;
}
</style>
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

<h1 style="color:blue;"><center><b>WELCOME TO EDIT PAGE</b></center></h1>



	<%
	List<Product> data = (List<Product>)request.getAttribute("list");
	for(Product d : data)
	{
	%>
	<center>
	<form action="Edit_Controller">
	
	<table style="width:50%">
	<tr>
	<td><label>PRODUCT ID </label></td>
	<td><%= d.getPid()%></td>
	</tr>
	<tr>
	<td><label>PRODUCT NAME</label></td>
	<td><%= d.getpName() %></td>
	</tr>
	<tr>
	<td><label>PRODUCT DESCRIPTION</label></td>
	<td><%= d.getpDesp() %></td>
	</tr>
	
	<input type="hidden" name="ID" value="<%= d.getPid()%>">
	<tr>
	<td><label>PRODUCT PRICE </label></td>
	<td><input type="text" name="price" value="<%= d.getpPrice()%>"></td>
	</tr>
	<tr>
	<td><label>PRODUCT QUANTITY</label></td>
	<td><input type="text" name="quan" value="<%= d.getpQty()%>"></td>
	</tr>
	
	</table>
	<br>
	<input type="submit" value="SUBMIT">
	<input type="reset" value="RESET">
	</form>
	</center>
	
	
	
	<% } %>	
	

</body>
</html>