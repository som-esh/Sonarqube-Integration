<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Minor Assignment 1</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<div>
				<h1>Calculator</h1>
				<h2>This is Production Environment</h2>
			</div>

			<div>
				<label>Result</label> <input type="text" class="form-control"
					value="<%=request.getAttribute("result")%>">
			</div>

			<div>
				<input onclick="history.back()" type="submit" value="Go Back"
					class="btn btn-outline-primary px-2 py-6 my-4">
			</div>
		</div>
	</div>
</body>

</html>


