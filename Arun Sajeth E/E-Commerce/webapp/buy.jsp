<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
 <%@ page import="project.model.Product" %>
<!DOCTYPE html>
<html>
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
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        #container {
            width: 300px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

        label {
            display: block;
            margin-top: 10px;
        } 

        input[type="text"] {
            width: 100%;
            padding: 5px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 3px;
        } 

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007BFF;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
 
        input[type="submit"]:hover {
            background-color: #0056b3;
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
              <li class="nav-item active">
                <a class="nav-link" href="Home.jsp">Home <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item ">
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
<div id="container">
<% 
	Product p = (Product)request.getAttribute("prod");
%>
<% 
	int comm =0;
	if(request.getParameter("commodity")==null)
	{
		comm=1;
	}
	else
	{
		comm = Integer.parseInt(request.getParameter("commodity"));
	}
%>
<label>Product Name</label>
<%= p.getpName() %>
<br>
<label>Product Description</label>
<%= p.getpDesp() %>
<br>
<label>Product Price</label>
<%= comm*p.getpPrice() %>
<br>
<%
	int qty = p.getpQty();
	
	if(qty<comm)
	{
%>
<%
		out.println("QUANTITY OUT OF STOCK");
	}
	else
	{
%>
		<br>
		
		<form action="Quantity_Reducer">
		<label>CARD NUMBER</label>
		<input type="hidden" name="pid" value="<%= p.getPid() %>">
		<input type="hidden" name="comm" value="<%= comm %>">
		<input type="text" name="cardno" value="" placeholder="Enter the card number">
		<br>
		<label>MM</label>
		<input type="number" name="mm" value=""  min="1" max="12">
		<label>YYYY</label>
		<input type="number" name="yyyy" value=""  min="2020" max="2028">
		<br>
		<label>CCV</label>
		<input type="text" name="mm" value="" placeholder="Enter the cvv">
		<br>
		<input type="submit" value="PAY">
		
		</form>
<%
	}
%>
</div>

</body>
</html>