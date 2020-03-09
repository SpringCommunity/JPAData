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
	<div class="container" style="margin-bottom: 30px">
	      <div class="row">
	             <div class="col-md-12">
	                  <form action="sort" method="post" class="form">
	                         <div class="form-inline">
	                               <label for="category">Sort by category</label>
	                               <select name="categoryId" class="form-control">
	                                             <option value="0">All</option>
	                                      <c:forEach items="${ categories }" var="cate">
	                                             <option value='<c:out value="${ cate.id }" />'><c:out value="${ cate.name }" /></option>
	                                      </c:forEach>
	                               </select>
	                               <input type="submit" value="Sort" class="btn btn-danger" />
	                         </div>
	                  </form>
	            </div>
	      </div>
	</div>
	<div class="container">
	      <div class="row">
	            <div class="col-md-12">
	             <form action="action" method="get">
	                  <table class="table table-bordered">
	                       <thead>
	                            <tr>
	                                 <th>Id</th>
	                                 <th>Isbn</th>
	                                 <th>Name</th>
	                                 <th>Author</th>
	                                 <th>Category</th>
	                                 <th>Published</th>
	                                 <th>Action</th>
	                            </tr>
	                       </thead>
	                       <tbody>
	                                  <c:forEach items="${ books }" var="book">
	                                  <tr>
	                                       <td><c:out value="${ book.id }" /></td>
	                                       <td><c:out value="${ book.isbn }" /></td>
	                                       <td><c:out value="${ book.name }" /></td>
	                                       <td><c:out value="${ book.author }" /></td>
	                                       <td><c:out value="${ book.category.name }" /></td>
	                                       <td><c:out value="${ book.publishedDate }" /></td>
	                                       <td class="text-center">
	                                             <input type="hidden"  name="bookId" value="${ book.id }"  />
	                                             <input type="submit"  name="action" class="btn btn-success" value="Edit" />&nbsp;<input type="submit" name="action" class="btn btn-warning" value="Delete" />&nbsp;<input type="button" name="action" class="btn btn-primary" value="Create" />
	                                       </td>
	                                  </tr>
	                                 </c:forEach>
	                                 	                       </tbody>
	                  </table>
	                  </form>
	            </div>
	            <div id="newBook" class="col-md-12" style="display: none">
	                 <form:form action="createbook" modelAttribute="book" class="form" method="Post">
	                        <div class="form-group col-md-2">
	                               <form:input type="text" path="isbn"  class="form-control" placeholder="Enter ISBN" />
	                        </div>
	                        <div class="form-group col-md-4">
	                               <form:input type="text" path="name"  class="form-control" placeholder="Enter book's name"/>
	                        </div>
	                        <div class="form-group col-md-2">
	                               <form:input type="text" path="author"  class="form-control" placeholder="Enter author's name"/>
	                        </div>
	                        <div class="form-group col-md-2">
	                               <form:select path="category" class="form-control">
	                                      <c:forEach items="${ categories }" var="category">
	                                             <form:option value="${ category }">${ category.name }</form:option>
	                                      </c:forEach>
	                               </form:select>
	                        </div>
	                        <div class="form-group col-md-2">
	                               <form:input type="text" path="publishedDate" id="date-picker" class="form-control" placeholder="Enter published date"/>
	                        </div>
	                        <div class="form-group col-md-12 text-center">
	                               <input type="submit"  name="action" value="Save" class="btn btn-primary"/>
	                        </div>
	                 </form:form>
	            </div>
	       </div>
	</div>
</body>
<script>
$( function(){
	 $( "input[value='Create']").click( function(e) {
			$( "#newBook" ).toggle();
	});
})
</script>
 <script>
  $( function() {
    $( "#date-picker" ).datepicker({
    	     "dateFormat": "yy-mm-dd"
    });
  });
  </script>
</html>