<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload imagen</title>
</head>
<body>

<form action="ImageUpload?action=filesUpload" method="post" enctype="multipart/form-data">
Select Imagen: <input type="file" name="files" multiple />

<input type="submit" value="upload"/>


</form>


</body>
</html>