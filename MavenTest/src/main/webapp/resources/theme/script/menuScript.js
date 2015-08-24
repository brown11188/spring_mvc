/**
 * 
 */
$(document).ready(function() {
	$('#menuList li').click(function(e) {
		$(this).addClass('active');
	});
});
//$(document).ready(function() {
//
//	$('#liList').click(viewdata);
//
//});
//
//function viewdata() {
//	$.ajax({
//		type : "GET",
//		url : "/MavenTest/listhibernate"
//	}).done(function(data) {
//		alert(data);
//		$('body').html(data);
//	});
//}
