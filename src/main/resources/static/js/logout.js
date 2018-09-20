$(document).ready(function(){
	$('#logout').click(function(e){
		e.preventDefaults();
		$("#logout-form").submit();
	});
	
});
