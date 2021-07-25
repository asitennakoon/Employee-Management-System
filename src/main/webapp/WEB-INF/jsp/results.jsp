<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <title>${title}</title>
</head>

<body>
    <h1>${title}</h1>
    <table>
        <thead>
            <tr>
                <th>Employee ID</th>
                <th>Department ID</th>
                <th>Full Name</th>
                <th>NIC</th>
                <th>Designation</th>
                <th>Mobile Number</th>
                <th>Start Date</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${employees}" var="employee">
                <tr>
                    <td>${employee.employeeId}</td>
                    <td>${employee.departmentId}</td>
                    <td>${employee.firstName} ${employee.lastName}</td>
                    <td>${employee.nic}</td>
                    <td>${employee.designation}</td>
                    <td>${employee.mobileNumber}</td>
                    <td>${employee.startDate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/">
        <p>Go Back...<p>
    </a>
</body>

</html>