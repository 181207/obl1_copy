<%--
  Created by IntelliJ IDEA.
  User: vegardguttormsen
  Date: 2017/09/18
  Time: 9:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<head>
    <title>Login</title>
</head>
<body>
<p>
<c:out value="${requestScope.invalidPasswordRedirect eq true ? 'Passordet du gav inn var feil. Prøv igjen:' : 'Gi inn passord:' }" />
</p>

<form action="login" method="post">
      <fieldset>
            <legend>Velkommen til EDB-shoppen!</legend>
            <p><input type="password" name="pwd" /></p>

            <p><input type="submit" value="Logg inn" /></p>
          </fieldset>
    </form>
</body>
