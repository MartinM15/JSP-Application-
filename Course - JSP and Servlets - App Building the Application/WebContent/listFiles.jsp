<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="org.fullstack.hibernate.entity.Files" %>
     <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listing Images</title>
</head>
<body>
<h1>Listing Images</h1> 

<table border=1>
<tr>
<th>Preview</th>
<th>Available Information</th>
<th>Update information</th>
<th>Action</th>
<%
	String path = (String)request.getAttribute("path");
	List<Files> files = (List<Files>) request.getAttribute("files");
for(Files file:files){
	out.print("<tr><td><img src="+ path + file.getFileName()+" height='200' ></tr></td>");
}
%>

</table>
</body>
</html>