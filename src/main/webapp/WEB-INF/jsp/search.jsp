<!DOCTYPE html>
<html lang="en">
<head>
    <title>Search Members</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <link rel="stylesheet" href="styles/homepage.css">
</head>

<body>

<div>
    <h2><strong>Search employees</strong></h2>

    <form action="employees" method="get">
        <p>Search by name: <label>
            <input name="name" required="required"
                   size="30"
                   type="text"/>
        </label>
            &nbsp;<input type="submit" value="Search"/>
        </p>
    </form>

    <form action="employees" method="get">
        <p>Search by department: <label>
            <select name="department" required="required" size="1">
                <option value="ENGINEERING">Engineering</option>
                <option value="IMPLEMENTATION">Implementation</option>
                <option value="SUPPORT">Support</option>
                <option value="BS">BS</option>
                <option value="MARKETING">Marketing</option>
                <option value="HR">HR</option>
            </select>
        </label>
            <input type="submit" value="Search"/>
        </p>
    </form>

    <form action="employees" method="get">
        <p>Search by condition: <label>
            <select name="condition" required="required" size="1">
                <option value="nicStartWith90">NIC start with 90</option>
                <option value="workingForFiveYears">Working for more than 5 years</option>
            </select>
        </label>
            &nbsp;<input type="submit" value="Search"/>
        </p>
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