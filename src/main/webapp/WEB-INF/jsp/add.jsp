<!DOCTYPE html>
<html lang="en">
<head>
    <title>Add Members</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <link rel="stylesheet" href="styles/homepage.css">
</head>

<body>
<div>
    <h2><strong>Add a new employee</strong></h2>

    <form action="added" id="add" method="post">
        <p>Department: <label>
            <select name="departmentId" required="required" size="1">
                <option value=1>Engineering</option>
                <option value=2>Implementation</option>
                <option value=3>Support</option>
                <option value=4>BS</option>
                <option value=5>Marketing</option>
                <option value=6>HR</option>
            </select>
        </label>
        </p>
        <p>First Name: <label>
            <input maxlength="30" name="firstName" required="required" size="30"
                   type="text"/>
        </label>
        </p>
        <p>Last Name: <label>
            <input maxlength="30" name="lastName" required="required" size="30"
                   type="text"/>
        </label></p>
        <p>NIC: <label>
            <input name="nic" required="required" size="15" type="text"/>
        </label></p>
        <p>Designation: <label>
            <input name="designation" required="required" size="15" type="text"/>
        </label>
        </p>
        <p>Mobile Number: <label>
            <input maxlength="10" name="mobileNumber" required="required"
                   size="10" type="tel"/>
        </label>
        </p>
        <p>Start Date: <label>
            <input name="startDate" required="required" size="12" type="date"/>
        </label></p>
        <p><input type="submit" value="Add" class="center"/></p>
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