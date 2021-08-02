<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>${title}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <link rel="stylesheet" href="styles/homepage.css">
</head>

<body>
<h1>${title}</h1>
<div>
    <form action="updated" id="edit" method="post">
        </p>
        <p>Updated Department: <label>
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
        <p>Updated First Name: <label>
            <input maxlength="30" name="firstName" required="required"
                   size="30"
                   type="text" value="${employee.firstName}"/>
        </label>
        </p>
        <p>Updated Last Name: <label>
            <input maxlength="30" name="lastName" required="required"
                   size="30" type="text" value="${employee.lastName}"/>
        </label>
        </p>
        <p>Updated Designation: <label>
            <input name="designation" required="required" size="15"
                   type="text" value="${employee.designation}"/>
        </label></p>
        <p>Updated Mobile Number: <label>
            <input maxlength="10" name="mobileNumber" required="required"
                   size="10"
                   type="tel" value="${employee.mobileNumber}"/>
        </label>
        </p>
        <input type="hidden" name=employeeId id="employeeId" value="${employee.employeeId}">
        <p><input type="submit" value="Update" class="center"/></p>
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