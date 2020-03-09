<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Khai báo cho expression language -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Khai báo cho spring form -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/cerulean/bootstrap.min.css">
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
@import url(http://fonts.googleapis.com/css?family=Roboto);
     .form-horizontal {
           font-family: roboto;
           margin: 100px auto;
           max-width: 600px;
           max-height: 600px;
           background-color: #F7F7F7;
           padding: 50px;
     }
     .form-horizontal  legend {
          font-size: 1.8em;
     }
</style>
<title>Login</title>
</head>
<body>
<div class="container">
<form:form class="form-horizontal" modelAttribute="user">
  <fieldset>
    <table class="table">
          <thead>
               <tr>
                   <th>Username</th>
                   <th>Password</th>
                   <th>Role</th>
               </tr>
          </thead>
          <tbody>
                <c:forEach items="${ users }" var="user">
                        <tr> 
                             <td><c:out value="${ user.username }" /></td>
                             <td><c:out value="${ user.password }" /></td>
                             <td><c:out value="${ user.role.name }" /></td>
                        </tr>
                </c:forEach>
          </tbody>
    </table>
    <div class="form-group">
      <form:label for="inputEmail" path="username"  class="col-lg-2 control-label">Username</form:label>
      <div class="col-lg-10">
        <form:input type="text" path="username"  class="form-control" id="inputEmail" placeholder="Enter username" />
      </div>
    </div>
    <div class="form-group">
      <form:label for="inputPassword" path="password" class="col-lg-2 control-label">Password</form:label>
      <div class="col-lg-10">
        <form:input type="password"  path="password" class="form-control" id="inputPassword" placeholder="Enter password" />
        <div class="checkbox">
        <label>
            <input type="checkbox"> Remember me 
          <label>
        </div>
      </div>
    </div>
    <div class="form-group">
      <div class="col-lg-10 col-lg-offset-2">
        <form:button type="reset" class="btn btn-default">Cancel</form:button>
        <form:button type="submit" class="btn btn-primary">Submit</form:button>
      </div>
    </div>
  </fieldset>
</form:form>
</div>
</body>
</html>