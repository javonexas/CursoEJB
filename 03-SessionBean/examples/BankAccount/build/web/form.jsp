<%-- 
    Document   : form
    Created on : Aug 30, 2012, 1:13:18 PM
    Author     : anshenoy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="CalcServlet" method="POST">

<br> 
<tr><td><b>Select your choice:</b></tr></td>
<tr><td><input type="radio" name="group1" value ="dep">Deposit</tr></td>
<tr><td><input type="radio" name="group1" value ="with">Withdraw<br></tr></td>

<tr><td>
<input type="submit" value="Transmit">
<tr><td></tr></td>
    </body>
</html>
