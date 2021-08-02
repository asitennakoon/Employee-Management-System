<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee Management System</title>
    <link rel="stylesheet" href="homepage.css">
</head>

<body>
<h1 style="text-align:center"><strong>Employee Management System</strong></h1>

<div id="container">
    <div>
        <h2><strong>Add a new employee</strong></h2>

        <form action="" id="add" method="post">
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
            <input type="hidden" name=department id="add_department" value="">
            <p><input type="submit" value="Add" class="center"/></p>
        </form>
    </div>

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
                <input name="department" required="required" size="15"
                       type="text"/>
            </label>
                &nbsp;<input type="submit" value="Search"/>
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

    <div>
        <h2><strong>Update employee details</strong></h2>

        <form action="edited" id="edit" method="post">
            <p>Employee ID: <label>
                <input maxlength="3" name="employeeId" required="required" size="3"
                       type="text"/>
            </label>
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
                       type="text"/>
            </label>
            </p>
            <p>Updated Last Name: <label>
                <input maxlength="30" name="lastName" required="required"
                       size="30" type="text"/>
            </label>
            </p>
            <p>Updated Designation: <label>
                <input name="designation" required="required" size="15"
                       type="text"/>
            </label></p>
            <p>Updated Mobile Number: <label>
                <input maxlength="10" name="mobileNumber" required="required"
                       size="10"
                       type="tel"/>
            </label>
            </p>
            <p><input type="submit" value="Update" class="center"/></p>
        </form>
    </div>

    <div>
        <h2><strong>Delete an employee</strong></h2>

        <form action="deleted" id="delete" method="post">
            Employee ID: <label>
            <input maxlength="3" name="employeeId" required="required" size="3"
                   type="text"/>
        </label>
            &nbsp;&nbsp;&nbsp;<input type="submit" value="Delete"/>
        </form>
    </div>
</div>

</body>

</html>