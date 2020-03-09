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
<script type="text/javascript"
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>CRUD demo - Spring Community</title>
</head>
<body>
		<div class="jumbotron text-center">
			<h2>Spring Community</h2>
			<p>CRUD application with JPA Data API in Spring</p>
	</div>

	<div class="container">
	      <div class="row">
	               <div id="oldBook" class="col-md-12">
	                 <form:form action="book" modelAttribute="book" class="form" method="Post">
	                        <div class="form-group col-md-8">
	                               <label>Id</label>
	                               <form:input type="text" path="id"  class="form-control"   placeholder="Enter Id"  />
	                        </div>
	                        <div class="form-group col-md-8">
	                               <label>ISBN</label>
	                               <form:input type="text" path="isbn"  class="form-control" placeholder="Enter ISBN" />
	                        </div>
	                        <div class="form-group col-md-8">
	                               <label>Name</label>
	                               <form:input type="text" path="name"  class="form-control" placeholder="Enter book's name"/>
	                        </div>
	                        <div class="form-group col-md-8">
	                               <label>Author</label>
	                               <form:input type="text" path="author"  class="form-control" placeholder="Enter author's name"/>
	                        </div>
	                        <div class="form-group col-md-8">
	                              <form:select path="category" class="form-control">
	                                      <c:forEach items="${ categories }" var="category">
	                                             <option value="${ category.id }" >${ category.name }</option>
	                                      </c:forEach>
	                               </form:select>	                        
	                        </div> 
	                        <div class="form-group col-md-8">
	                               <label>Published</label>
	                               <form:input type="text" path="publishedDate" id="date-picker"  class="form-control" placeholder="Enter published date"/>
	                        </div>
	                        <div class="form-group col-md-8 text-center">
	                               <input type="submit"  value="Update" class="btn btn-primary"/>
	                        </div>
	                 </form:form>
	            </div> 
	      </div>
	</div>
	
</body>
 <script>
  $( function() {
    $( "#date-picker" ).datepicker({
    	     "dateFormat": "yy-mm-dd"
    });
  });
  </script>
</html>