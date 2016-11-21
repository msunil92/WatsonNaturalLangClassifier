<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Watson NLC</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="css/aurorastore.css">
<script	src="js/jQueryJS.js"></script>
</head>
<body>
	<div id ="overlay">
	<div id="groupBut">
		<button type="button" id="Apparel" class="btn btn-primary">Apparel</button>
		<button type="button" id="Electronics" class="btn btn-primary">Electronics</button>
		<button type="button" id="Grocery" class="btn btn-primary">Grocery</button>
		<button type="button" id="Health" class="btn btn-primary">Health</button>
		<button type="button" id="home" class="btn btn-primary">Home & Furnishing</button>
		<button type="button" id="Newsletters" class="btn btn-primary">Newsletters & Magazines</button>
		<button type="button" id="Departments" class="btn btn-primary">All Departments</button>
		<button type="button" id="helpButtton" class="btn btn-primary" onclick="DisplayWatsonChat()">Help</button>
	</div>
	
	<div id="image">
		<img alt="aurora_store.png" src="images/aurora_store.png" onclick="Overlay()"/>
	</div>
	</div>
	<div id="content">
		<div id="contentheader">Aurora Help Store</div>
		<div id="container"></div>
		<div id="ctrl">
			<textarea id="textbox" placeholder="Ask question to Watson..."></textarea>
			<button id="send">Send</button>
		</div>
	</div>
</body>

</html>