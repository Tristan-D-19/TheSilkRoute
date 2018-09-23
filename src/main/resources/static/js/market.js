$(document).ready(function(){
	$('#addItem').click(function(e){
		e.preventDefaults();
		$("#cart-form").submit();
	});
	
});
