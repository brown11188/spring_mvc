/**
 * 
 */
$(document).ready(function() {
	$graph = $('p:eq(3)');
	$graph.hide();
	$('a.more').click(function() {
		$graph.slideToggle('slow');
		if ($(this).text() == 'Read more') {
			$(this).text('Read less');
		} else {
			$(this).text('Read more');
		}
		return false;
	});
});
$(document).ready(function() {

	$('#langEN').click(function() {
		var path = window.location.href;
		if (path.indexOf("?language=en") >= 0||path.indexOf("&language=en") >= 0) {

		} else if (path.indexOf("?language=vi") >= 0) {
			path = path.replace("?language=vi", "?language=en");
			window.location.href = path + "";
		}else if (path.indexOf("&language=vi") >= 0){
			path = path.replace("&language=vi", "&language=en");
			window.location.href = path + "";
		}  else if (path.indexOf("?") >= 0) {
			path += "&language=en";
			window.location.href = path + "";
		}
		else if (path.indexOf("?") < 0) {
			path += "?language=en";
			window.location.href = path + "";
		}
	});
});
$(document).ready(function(){
	$('#langVN').click(function() {
		var path = window.location.href;
		if (path.indexOf("?language=vi") >= 0||path.indexOf("&language=vi") >= 0) {

		} else if (path.indexOf("?language=en") >= 0) {
			path = path.replace("?language=en", "?language=vi");
			window.location.href = path + "";
		}  else if (path.indexOf("&language=en") >= 0){
			path = path.replace("&language=en", "&language=vi");
			window.location.href = path + "";
		} else if (path.indexOf("?") >= 0) {
			path += "&language=vi";
			window.location.href = path + "";
		}
		else if (path.indexOf("?") < 0) {
			path += "?language=vi";
			window.location.href = path + "";
		}
	});
});



