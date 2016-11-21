/*$(document).ready(function() {
	$('#butt').click(function(event) {
		var name = $('#Question').val();
		$.get('GetUserServlet', {
			inputQuestion : name
		}, function(responseText) {

			var uid = uniqueId("loaded_data_");
			$("#ajaxGetUserServletResponse").append("<div id='" + uid + "'/>");
			$("#" + uid).text(responseText);

		});
	});
});
*/
var idCounter = 0;
uniqueId = function(prefix) {
	var id = idCounter++;
	return prefix ? prefix + id : id;
};

$(document).ready(function() {
	$('#butt').click(function(event) {
		var name = $('#Question').val();
		document.getElementById("Question").value = "";
		$.ajax({
			url : "watsonControlerServlet",
			 contentType: "htm	l",
			type : "GET",
			data : {
				"inputQuestion" : name,
			},
			success : function(responseText) {
				var uid = uniqueId("loaded_data_");
				var aID = uid+"a";
				var qID = uid+"q";
				$("#ajaxResponse").append("<div id='" + aID + "'/>");
				$("#" + aID).html("<font color=\"red\">"+name+"</font><p>&nbsp;&nbsp;"+responseText+"</p>");
				//$("#ajaxResponse1").append("<div id='" + qID + "'/>");
				//$("#" + qID).html(responseText).html(responseText);
		}
		});
		
	});
	
});
