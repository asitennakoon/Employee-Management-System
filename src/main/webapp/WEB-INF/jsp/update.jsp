<!DOCTYPE html>
<html lang="en">
<head>
    <title>Update Members</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <link rel="stylesheet" href="styles/homepage.css">
</head>

<body>

<div>
    <h2><strong>Update employee details</strong></h2>

    <form action="edit" id="edit" method="get">
        <p>Employee ID: <label>
            <input maxlength="3" name="employeeId" required="required" size="3"
                   type="text"/>
        </label>
        <input type="submit" value="Edit"/>
    </form>
</div>

<a href="${pageContext.request.contextPath}/">
    <p>Go Back...
    <p>
</a>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

</body>

</html>