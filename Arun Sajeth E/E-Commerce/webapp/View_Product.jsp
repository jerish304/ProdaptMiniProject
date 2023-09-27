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
<title>Insert title here</title>
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

<h1 style="color:blue;"><center><b>WELCOME TO VIEW PAGE</b></center></h1>


<table style="width:100%">
<thead>
<tr>
<th colspan=1>ID</th>
<th colspan=1>NAME</th>
<th colspan=1>DESCRIPTION</th>
<th colspan=1>PRICE</th>
<th colspan=1>QUANTITY</th>
<th colspan=1>OPERATION</th>

</tr>
</thead>
<tbody>
	<%
	List<Product> data = (List<Product>)request.getAttribute("list");
	for(Product d : data)
	{
	%>
	<tr>
	<td><h4><%= d.getPid() %></h4>
	</td>
	<td><h4><%= d.getpName() %></h4></td>
	<td><h4><%= d.getpDesp() %></h4></td>
	<td><h4><%= d.getpPrice() %></h4></td>
	<td><h4><%= d.getpQty() %></h4></td>
	<td><form action="View_Edit_Delete_Controller">
	<input type="hidden" name=pid value="<%= d.getPid() %>">
	<input type="submit" name="viewchoice" value="EDIT">
	<input type="submit" name="viewchoice" value="DELETE"></form>
	</td>
	</tr>
	<% } %>	
</tbody>
</table>

	

</body>
</html>