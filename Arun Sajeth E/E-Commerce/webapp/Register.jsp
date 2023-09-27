<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
 <%@ page import="java.util.List" %>
 <%@ page import="java.util.ArrayList" %>
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

<body class="sub_page">

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
              <li class="nav-item ">
                <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item active">
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

  <!-- contact section -->



  <section class="contact_section layout_padding">
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-5 col-lg-4 offset-md-1">
          <div class="form_container">
            <div class="heading_container">
              <h3>
                Register Page
              </h3>
            </div>
            <form action="Registration_Controller">
              <div>
              	<label>Name</label>
                <input type="text" name="name" placeholder="Enter the Name " />
              </div>
              <div>
              	<label>DOB</label>
                <input type="date" name="dob" placeholder="Enter the YYYY-MM-DD"/>
                
              </div>
              <div>
              	<label>Email-ID</label>
                <input type="email" name="email" placeholder="Enter the Email" />
              </div>
              <div>
              	<label>Phone Number</label>
                <input type="tel" name="Phno" pattern="[789][0-9]{9}" placeholder="Enter thePhone number" />
              </div>
              <div>
              	<label>Password</label>
                <input type="password" name="pwd" placeholder="Enter the password " />
              </div>
              <div class="d-flex ">
                <button>
                  ADD
                </button>
              </div>
            </form>
          </div>
        </div>
          </div>
        </div>
  </section>

  <!-- end contact section -->

</body>

</html>