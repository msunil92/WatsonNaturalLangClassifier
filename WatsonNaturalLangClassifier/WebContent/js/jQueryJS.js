function DisplayWatsonChat() {
	$("#content").delay(100).fadeIn();
	//$("#content").css("display","inline");
	$("#overlay").css("opacity","0.4");
}

function Overlay() {
	$("#content").css("display","none");
	$("#overlay").css("opacity","1");
	//$("#container").html('');
	//$("#textbox").html('');
}

function sendMessage (message) {
	var pm = $("#container").html();
	if (pm.length > 3) {
		pm = pm +"</br>";
	}
	$("#container").html(pm+"<span class='thisClass'>"+"<span class='watson'>Watson: </span>"+message+"</span>");
	$(".thisClass").hide();
	$(".thisClass").delay(500).fadeIn();
	//$(".thisClass").css("font-weight","bold");
	$(".thisClass").removeClass("thisClass");
}

function ArtificialIntelligent(message) {
	if (message.length>0){
		sendMessage(message);
	}
}

function startTime() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById("header-image").innerHTML =
    h + ":" + m + ":" + s;
    var t = setTimeout(startTime,1000);
}

function checkTime(i) {
    if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
    return i;
}

$(function(){
	
	/*Will be loaded on start*/
	var links ="<br><h1><b><center>Reference Links</center></b></h1><br>";
	var link1 ="<h4><a href='http://www.google.com' target='none'>1. Google</a></h4><br>";
	var link2 ="<h4><a href='http://www.ibm.com/cloud-computing/bluemix/' target='none'>2. Build with infrastructure, platform, Watson, and software services on the Bluemix cloud platform</a></h4><br>";
	var link3 ="<h4><a href='https://www.ibmwatsonconversation.com/' target='none'>3. Watson conversation work page</a></h4>";
	//$("#container-left").html(links+link1+link2+link3);
	/*Will be loaded on start*/
	
	
	$("#textbox").keypress(function(event){
	    if (event.keyCode == 10 || event.keyCode == 13) {
	    	$("#send").click();
	    	event.preventDefault();
	    }
	  });
	
	$("#send").click(function(){
		var value = $("#usrName").val();
		if (value == "" || value == null)
			value = "Sunil";
		var UserName = "<span class='username'><b>"+value+": </b></span>"
		var newmessage = $("#textbox").val().trim();
		if (newmessage!="")
		{
			$("#textbox").val("");
			var pm = $("#container").html();
			console.log(pm);
			if (pm.length > 3) {
				pm = pm +"</br>";
			}
			var tempnewmessage = "<span class ='userMessage'>"+newmessage+"</span>";
			$("#container").html(pm+UserName+tempnewmessage);
		
			$("#container").scrollTop($("#container").prop("scrollHeight"));
			$.ajax({
				url : "WatsonNaturalLangClassifier",
				contentType: "html",
				type : "GET",
				data : {
					"inputQuestion" : newmessage,
				},
				success : function(responseText) {
					if (responseText != "" && responseText != null)
						ArtificialIntelligent(responseText+"</br>");
				}
			});
		}
	});
});
		