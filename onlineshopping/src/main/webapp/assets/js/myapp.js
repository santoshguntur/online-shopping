$(function(){
	//solving active menu problem
	/*switch(menu){
	
	case 'About us':
		$('#about').addClass('active');
        break;
	case 'Contact us':
		$('#contact').addClass('active');
        break;
	default:
		$('#home').addClass('active');
        break;
	
	
	}*/
	
	//Code for Jquery datatable
		
	var $table=$('#productListTable');
	
	if($table.length ){
		console.log('Inside the table');
		var jsonUrl='';
		if (window.categoryId==''){
			jsonUrl=window.contextRoot+'/json/data/all/products';
		}else{
			jsonUrl=window.contextRoot+'/json/data/category/'+window.categoryId+'/products';
		}
		console.log('jsonUrl: '+jsonUrl);
		$table.DataTable({
			lengthMenu:[[3,5,-1],['3 Records','5 Records','ALL']],
			pageLength:3,	
			ajax:{
				url:jsonUrl,
				dataSrc:''
			},
			columns:[{
				data : 'code',
				bSortable : false,
				mRender : function(data, type, row) {

					return '<img src="' + window.contextRoot
							+ '/resources/images/' + data
							+ '.jpg" class="dataTableImg"/>';

				}
			},{data:'name'},{data:'brand'},{data:'unitprice'},
				{data:'unitprice',mRender:function(data,type,row){return '&#8377 '+data;}},
				{data:'quantity',mRender:function(data,type,row){
					
					if(data < 1) return '<span style="color:red">Out Of Stock';
					return data;
					}
				},
				{data:'id',data : 'id',	
					mRender : function(data, type, row) {

						var str = '';
						str += '<a href="'
								+ window.contextRoot
								+ '/show/'
								+ data
								+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
						
						       if(row.quantity <1 ){
						    	   
						    	   str += '<a href="'
										+ window.contextRoot
										+ '/cart/add/'
										+ data
										+ '/product" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
						       }else{
								str += '<a href="'
										+ window.contextRoot
										+ '/cart/add/'
										+ data
										+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
								
								}
						       return str;
							}
						
						}
				]
		});
	}
});