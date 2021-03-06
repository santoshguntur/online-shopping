<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>


<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online Shopping - ${title}</title>
    
    <script>
  
   window.menu = '${title}';
   window.contextRoot = '${contextRoot}';
  </script>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    
      <!-- Bootstrap Datatable -->
    <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css}/myapp.css" rel="stylesheet">
    
   

  </head>

  
  <body>

    <!-- Navigation -->
    <%@include file="./shared/navbar.jsp" %>

    <!-- Page Content -->
    <c:if test="${userClickHome==true}">
       <%@include file="./home.jsp" %>
   </c:if>
    <!-- /.container -->

   <!-- When user clicks on about  -->
   <c:if test="${userClickAbout==true}">
       <%@include file="./about.jsp" %>
   </c:if>
   
   <!--  When user clicks on Contact   -->
   <c:if test="${userClickContact==true}">
       <%@include file="./contact.jsp" %>
   </c:if>
   
   <!--  When user clicks on listProducts   -->
   <c:if test="${userClickCategoryProducts == true or userClickAllProducts == true}">
       <%@include file="listProducts.jsp" %>
   </c:if>
   
    <!--  When user clicks on singleproduct   -->
   <c:if test="${userClickShowProduct == true}">
       <%@include file="singleProduct.jsp" %>
   </c:if>
   
			<!-- Load only when user clicks manage product -->
			<c:if test="${UserClickManageProducts == true}">
				<%@include file="manageProduct.jsp"%>
			</c:if>	
   
   
    <!-- Footer -->
    <%@include file="./shared/footer.jsp" %>
   

    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/bootstrap.bundle.min.js"></script>
     <!-- Adding datatable plugin -->
    <script src="${js}/jquery.dataTables.js"></script>
     <script src="${js}/dataTables.bootstrap.js"></script>
    <!-- Adding my js file -->
    <script src="${js}/myapp.js"></script>
    
  </body>

</html>
