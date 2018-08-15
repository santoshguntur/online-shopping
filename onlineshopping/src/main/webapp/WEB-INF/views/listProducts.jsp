<div class="container">
	<div class="row">
		<!-- Would be display sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>

		<!-- Would be display sidebar -->
		<div class="col-md-9">

			<!-- Added for breadcrumb component -->
			<div class="row">
				<div class="col-md-12">

					<c:if test="${userClickAllProducts == true}">
					<script>
						window.categoryId='';
						</script>
						<ol class="breadcrumb">						
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All products</a>
							</li>
						</ol>
					</c:if>
					
					<c:if test="${userClickCategoryProducts == true}">
					<script>
						window.categoryId='${category.id}';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>
					</c:if>
				</div>

			</div>
	
	        <div class="row">
	        
	           <div class="col-xs-12">
	           
	               <table id="productListTable" class="table table-striped table-boarded">
	               
	                 <thead>
	                 <th>Image</th>
	                  <th>Name</th>
	                  <th>Brand</th>
	                  <th>Price</th>
	                  <th>Qty. Avalable</th>
	                  <th></th>
	                 </thead>
	               
	               
	                <tfoot>
	                <th>Image</th>
	                  <th>Name</th>
	                  <th>Brand</th>
	                  <th>Price</th>
	                  <th>Qty. Avalable</th>
	                  <th></th>
	                 </tfoot>
	               </table>
	           
	           </div>
	        </div>
		</div>
	</div>

</div>