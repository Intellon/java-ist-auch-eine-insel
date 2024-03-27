<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>

<body>

<form method="GET" action="rechner.jsp">

<%! int wert2; int wert; %>
<%
	try
	{
	wert = Integer.parseInt(request.getParameter("zahl"));
	wert2 = wert*wert;
	}
	catch(Exception e)
	{
	wert=0;
	}
%>
  <table border="1" width="55%">
    <tr>
      <td width="100%" align="center">Das Quadrat von <%= wert %> ist <%= wert2 %>! Bitte gib mir eine neue Zahl:</td>
    </tr>
    <tr>
      <td width="100%" align="center"><input type="text" name="zahl" size="20"></td>
    </tr>
    <tr>
      <td width="100%" align="center"><input type="submit" value="ausführen!" name="B1"></td>
    </tr>
  </table>
</form>
</body>
</html>
