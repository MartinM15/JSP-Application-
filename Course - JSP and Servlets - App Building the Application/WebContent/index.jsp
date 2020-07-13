<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload Images</title>
</head>
<body>

<form action="ImageUpload?action=filesUpload" method="post" enctype="multipart/form-data">
Select Images : <input type="file" name="files" multiple />

<input type="submit" value="upload"/>
<a href="${pageContext.request.contextPath}/ImageUpload?action=listingImages">View Available Image</a>

</form>


</body>
</html>