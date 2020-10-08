<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Home Ethan Foster</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <br>
        <h2>Hello ${username}</h2>
        <form action="logout" method="get">
            <a href="login?logout" name="logout">Logout</a>
        </form>
        
    </body>
</html>
