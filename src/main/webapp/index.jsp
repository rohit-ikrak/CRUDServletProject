
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
<style>
	.container{
		justify-content: center;
		display: grid;
		align-items:center;		
	}
	input[type=button] {
  		background-color: #999;
  		border: ridge;
  		color: white;
  		padding: 12px 25px;
  		margin: 4px 2px;
  		
  	}
</style>
</head>
<body style="background-color:black; ">
	
	<div style="background-color:black; height:60px;">
		<h1 style="text-align:center; font-size:44px; color:white;">Simple CRUD Project</h1>		
	</div>
	
	
	<p style="text-align:center; font-size:20px; color:white;">This is a simple Servlet project that allow basic database operations (i.e. insert, update, delete, search, show).</p><br/><br/>
	<div class="container">
		<a href="insertdata.html"><input type="button" value="Insert Data" /></a><br/><br/>
		<a href="deletedata.html"><input type="button" value="Delete Data" /></a><br/><br/>
		<a href="updatedata.html"><input type="button" value="Update Data" /></a><br/><br/>
		<a href="searchdataajax.html"><input type="button" value="Search Data" /></a><br/><br/>
		<a href="showdata.html"><input type="button" value="Show All Data" /></a><br/><br/>
	</div>
	
	<div style="background-color:black; color:white;  position:fixed; left:0; bottom:0; width:100%;">
		<h6 style="text-align:center;">made by @rohitkarki</h6>
	</div>
	
</body>
</html>