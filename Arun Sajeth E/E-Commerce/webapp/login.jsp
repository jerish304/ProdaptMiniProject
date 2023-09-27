<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  
  <style>

form {

  width: 300px;

  margin: 0 auto;

  padding: 20px;

  background-color: #f7f7f7;

  border: 1px solid #ccc;

  border-radius: 5px;

}

 

label {

  display: block;

  margin-bottom: 5px;

  font-weight: bold;

}

 

input[type="email"],

input[type="password"] {

  width: 100%;

  padding: 10px;

  margin-bottom: 15px;

  border: 1px solid #ccc;

  border-radius: 3px;

}

 

input[type="submit"],

input[type="reset"] {

  display: inline-block;

  padding: 10px 20px;

  background-color: #007bff;

  color: #fff;

  border: none;

  border-radius: 3px;

  cursor: pointer;

}

 

input[type="submit"] {

  margin-right: 10px;

}


input[type="submit"]:hover,

input[type="reset"]:hover {

  background-color: #0056b3;

}
  
  </style>
  
  <style>
	body{
		background-color: lavender;
	}
</style>


  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

  <!-- font awesome style -->
  <link href="css/font-awesome.min.css" rel="stylesheet" />

  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />

</head>

<body class="sub_page">



  <div class="hero_area">
    <!-- header section strats -->
    <header class="header_section">
      <div class="container-fluid">
        <nav class="navbar navbar-expand-lg custom_nav-container ">
          <a class="navbar-brand" href="index.html">
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
              <li class="nav-item">
                <a class="nav-link" href="Register.jsp"> Register</a>
              </li>
              <li class="nav-item active">
                <a class="nav-link" href="login.jsp">Login</a>
              </li>
            </ul>
          </div>
        </nav>
      </div>
    </header>
    <!-- end header section -->
  </div>

  <!-- about section -->
  
  <br><br>
  
  <form action="Login_Controller">
  
  <table>
  <tr>
  <td><label>EMAIL-ID</label></td>
  <td><input type="email" id="email" name="email" value="" placeholder="Enter the Mail-ID"></td>
  <tr>
  <td><label>PASSWORD</label></td>
  <td><input type="password" name="password" value="" placeholder="Enter the Password"></td>
  </tr>
  </table>
  <br>
  <input type="submit" value="SUBMIT">
  <input type="reset" value="RESET">
  
  </form>
  
</body>

</html>