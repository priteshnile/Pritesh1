$(document).ready(function(){
	//var q=$(this).closest('tr').find('.q').val
	/*function myFunction(x) {
		var i=x.rowIndex+1;
		    alert("Row index is: " + i);
		}*/
	var r = $('#ordertable tr').length-1;
	//alert(r);
	


	$("tr.row").each(function() {
	  $this = $(this)
	  //var value = $this.find("span.value").html();
	  var q = $this.find("input.q").val();
	  //alert(q);
	  var p=$this.find("input.p").val()*q;
	  alert(p);
	 
	});


	
	/* for(var i = 0; i < r; i++)
		 {
		 $this = $(this)
	var q=$this.find("input.q").val();
	alert(q);
		 }*/
	
	
	
	update_total();
	
	$(".quantity").change(function() {
		var quantity=$(this).closest('tr').find('.quantity').val();
		  var itemid =$(this).closest('tr').find('.itemid').val(); 
		//alert("calculate total");
		 $.ajax({
				url: "http://localhost:8088/SpringMVCHibernate/updateKart",
				type:"GET",
			 data: { 'itemid' : itemid,'quantity' : quantity},
				 success: function(s){  
					 
					 //alert(s);
					 //window.location.href="kart";
						
		    		    },  
		    		    error: function(e){  
		    		    	//alert(JSON.stringify(r));
		      		      //alert("In error");  
		      		      
		      		    }  
			});
		update_total();

	});
	function update_total()
	{

		var grandtotal=0;
	    $('#myTable > tbody  > tr').each(function() {
  // alert("Inside");
	    	
	        var qty = $(this).find('option:selected').val();
	       // alert(qty);
	        var price = $(this).find('.price').val();
	       // alert(price);
	        var total = (qty*price)
	       
	        $(this).find('.total').val(total);
	        grandtotal=grandtotal+total;
	        //alert(grandtotal);
	    });
	    $("#grandtotal").val(grandtotal);
	  
	}
	
	$(".removefromkart").click(function(){
		// $(this).closest('tr').remove();
		 // update_total(); 
		//alert("Removing from kart");
		//$('#myTable > tbody  > tr').each(function() {
		//var quantity=$(this).val();
	    var itemid =$(this).closest('tr').find('.itemid').val();    
	    //alert(itemid);
	    $.ajax({
			url: "http://localhost:8088/SpringMVCHibernate/removeFromKart",
			type:"GET",
		 data: { 'itemid' : itemid/*,'quantity' : quantity*/},
			 success: function(s){  
				 
				 //alert(s);
				 window.location.href="kart";
					
	    		    },  
	    		    error: function(e){  
	    		    	//alert(JSON.stringify(r));
	      		      //alert("In error");  
	      		      
	      		    }  
		});
			        
				   // });
	});
});