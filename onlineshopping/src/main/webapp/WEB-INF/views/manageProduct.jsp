<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="container">

	<div class="row">
	
	<c:if test="${not empty message}">
	  <div class="col-md-12">
	  
	    <div class="alert alert-success alert-dismissible">
	      <button type="button" class="close" data-dismiss="alert">&times;</button>
	      ${message}
	    </div>
	     
	  </div>
	</c:if>
		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>
				<!-- Panel Boby -->

				<div class="panel-body">
				
				  <sf:form class="form-horizontal" modelAttribute="product" action="${contextRoot}/manage/products" method="POST">
				     
				      <div class="form-group">
				       <label class="control-label col-md-4" for="name" > product Name: </label>
				        <div class="col-md-8">
				       <sf:input type="text" id="name" path="name" placeholder="Product Name" class="form-control"/>
				       <em class="help-block"> Please enter Product Name!</em>
				       </div>
				       </div>
				       
				       <div class="form-group">
				       <label class="control-label col-md-4" for="name" > Brand Name: </label>
				       <div class="col-md-8">
				       <sf:input type="text" id="brand" path="brand" placeholder="Brand Name" class="form-control"/>
				       <em class="help-block"> Please enter Brand Name!</em>
				       </div>
				       </div>
				       
				        <div class="form-group">
				       <label class="control-label col-md-4" for="name" > Product Description: </label>
				       <div class="col-md-8">
				       <sf:textarea rows="1" cols="1" path="description" placeholder="Enter Description" class="form-control"></sf:textarea>				     
				       </div>
				       </div>
				       
				       <div class="form-group">
				       <label class="control-label col-md-4" for="name" > Unit Price: </label>
				       <div class="col-md-8">
				       <sf:input type="text" id="price" path="unitprice" placeholder="Unit Price" class="form-control"/>
				       <em class="help-block"> Please enter Unit Price!</em>
				       </div>
				       </div>
				       
				        <div class="form-group">
				       <label class="control-label col-md-4" for="name" > Qty. Avilable: </label>
				       <div class="col-md-8">
				       <sf:input type="text" id="qty" path="quantity" placeholder="Enter the Quantity avilable" class="form-control"/>
				       <em class="help-block"> Please enter Quantity Avilable!</em>
				       </div>
				       </div>
				       
				       <div class="form-group">
				       <label class="control-label col-md-4" for="name" > Select Category: </label>
				       <div class="col-md-8">
				       <sf:select class="form-control" id="categoryId" path="categoryId" name="categoryId"
				        items="${categories}"
				        itemLabel="name"
				        itemValue="id"
				       />
				       </div>
				       </div>
				    
				       <div class="form-group">				        
				       <div class="col-md-offset-4 col-md-8">
				       <input type="submit" id="submit" name="submit" value="Submit" class="btn btn-primary"/>
				       
				       <sf:hidden path="id"/>
				       <sf:hidden path="code"/>
				       <sf:hidden path="supplierId"/>
				       <sf:hidden path="active"/>
				       <sf:hidden path="purchases"/>
				       <sf:hidden path="views"/>
				       
				       </div>
				       </div>
				        
				  </sf:form>
				
				</div>

			</div>


		</div>

	</div>
</div>