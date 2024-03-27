<%@page import="java.util.*" %>

<%!
  int zahl=-1;
  int max = 100;
  int eingabe;
  int durchgang=0;
%>

<html>
<body>
Finde die Zahl zwischen 0 und <%=max%>.

<form method="get" action="tipp.jsp">
  <p>
  <input type="text" name="tipp" size="20">
  <input type="submit" value="Tippen"></p>
</form>

<% 	if ( zahl < 0 )
	{
      zahl=(int)(Math.random()*max);
	}
	else
	{
	String s = request.getParameter("tipp");
	if ( s.length() != 0 )
	{
	    eingabe = Integer.parseInt(s);
		if ( zahl == eingabe)
		{
			%>
			<font color=red face="Arial">
			<h1>Treffer</h1><br>
			Sie brauchten: <%=durchgang%> Durchg&auml;nge
			</font>
			<%
			durchgang=0;
			zahl=(int)(Math.random()*max);
			}
			else
			{
				if (zahl<eingabe)
					{
					durchgang++;
					%>Meine Zahl ist kleiner<%
					}
				if (zahl>eingabe)
					{
					durchgang++;
					%>Meine ist gr�sser!<%
					}
			}
	}	
	}
%>

</body>

</html>