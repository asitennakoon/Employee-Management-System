<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee Management System</title>
    <style>
        div {
            border: 1px solid black;
            padding: 10px;
            margin: 2px;
        }

        #container {
            border: none;
            margin: auto;
            width: 50%;
            justify-content: center;
        }

        h2 {
            text-align: center;
        }

        .center {
            transform: translate(250px);
        }
    </style>
</head>

<body>
    <h1 style="text-align:center"><strong>Employee Management System</strong></h1>

    <div id="container">
        <div>
            <h2><strong>Add a new employee</strong></h2>

            <form action="" id="add" method="post" onsubmit="setForeignKey()">
                <p>Employee ID: <input maxlength="3" name="employeeId" required="required" size="3" type="text" />
                </p>
                <p>Department ID: <input maxlength="2" name="departmentId" id="add_departmentId" required="required"
                        size="2" type="text" />
                </p>
                <p>First Name: <input maxlength="30" name="firstName" required="required" size="30" type="text" />
                </p>
                <p>Last Name: <input maxlength="30" name="lastName" required="required" size="30" type="text" /></p>
                <p>NIC: <input name="nic" required="required" size="15" type="text" /></p>
                <p>Designation: <input name="designation" required="required" size="15" type="text" /></p>
                <p>Mobile Number: <input maxlength="10" name="mobileNumber" required="required" size="10" type="tel" />
                </p>
                <p>Start Date: <input name="startDate" required="required" size="12" type="date" /></p>
                <input type="hidden" name=department id="add_department" value="">
                <p><input type="submit" value="Add" class="center" /></p>
            </form>
        </div>

        <div>
            <h2><strong>Search employees</strong></h2>

            <form action="name" id="searchbyName" method="get">
                <p>Search by name: <input maxlength="30" name="employeeName" required="required" size="30"
                        type="text" />
                    &nbsp;<input type="submit" value="Search" />
                </p>
            </form>

            <form action="department" id="searchByDepartment" method="get">
                <p>Search by department: <input name="departmentName" required="required" size="15" type="text" />
                    &nbsp;<input type="submit" value="Search" />
                </p>
            </form>

            <form action="condition" id="searchByCondition" method="get">
                <p>Search by condition: <select name="condition" required="required" size="1">
                        <option value="nicStartWith90">NIC start with 90</option>
                        <option value="workingForFiveYears">Working for more than 5 years</option>
                    </select>
                    &nbsp;<input type="submit" value="Search" />
                </p>
            </form>
        </div>

        <div>
            <h2><strong>Update employee details</strong></h2>

            <form action="edited" id="edit" method="post" onsubmit="setForeignKey()">
                <p>Employee ID: <input maxlength="3" name="employeeId" required="required" size="3" type="text" />
                    &nbsp;Department ID: <input maxlength="2" name="departmentId" id="edit_departmentId"
                        required="required" size="2" type="text" />
                </p>
                <p>Updated First Name: <input maxlength="30" name="firstName" required="required" size="30"
                        type="text" />
                </p>
                <p>Updated Last Name: <input maxlength="30" name="lastName" required="required" size="30" type="text" />
                </p>
                <p>Updated NIC: <input name="nic" required="required" size="15" type="text" /></p>
                <p>Updated Designation: <input name="designation" required="required" size="15" type="text" /></p>
                <p>Updated Mobile Number: <input maxlength="10" name="mobileNumber" required="required" size="10"
                        type="tel" />
                </p>
                <p>Updated Start Date: <input name="startDate" required="required" size="12" type="date" />
                </p>
                <input type="hidden" name=department id="edit_department" value="">
                <p><input type="submit" value="Update" class="center" /></p>
            </form>
        </div>

        <div>
            <h2><strong>Delete an employee</strong></h2>

            <form action="deleted" id="delete" method="post">
                Employee ID: <input maxlength="3" name="employeeId" required="required" size="3" type="text" />
                &nbsp;Department ID: <input maxlength="2" name="departmentId" required="required" size="2"
                    type="text" />
                &nbsp;&nbsp;&nbsp;<input type="submit" value="Delete" />
            </form>
        </div>
    </div>

    <script>
        function setForeignKey() {
            document.getElementById("edit_department").value = document.getElementById("edit_departmentId").value;
            document.getElementById("add_department").value = document.getElementById("add_departmentId").value;
        }
    </script>

</body>

</html>