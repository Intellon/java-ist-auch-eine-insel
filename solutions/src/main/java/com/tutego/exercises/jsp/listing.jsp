<%@page import = "java.util.*" %>
<%@page import = "java.io.*" %>

<html>
<head>
 <title>Directory Listing</title>
</head>
<body>
<%
	File datei = new File("c:\\kurse\\jakarta-tomcat-4.0.1\\webapps\\Root");
	File[] liste = datei.listFiles();
%>

<table cellpadding="3">

<%
  for (int i = 0; i < liste.length; i++)
  {
		File datei2 = liste[i];
		
		if (datei2.isDirectory())
		{
%>
		<tr><td><img src="open.gif" width="24" height="24"></td><td><font face="Verdana" size="-1"><a href="<%=liste[i]%>"><%=liste[i].getName()%></a></font></td><td></td></tr>
<%
        } else {
%>
		<tr><td><img src="new.gif" width="24" height="24"></td><td><font face="Verdana" size="-1"><a href="<%=liste[i]%>"><%=liste[i].getName()%></a></font></td><td>&nbsp;&nbsp;<font face="Verdana" size="-1"><%=liste[i].length()/1024%> kb</font></td></tr>
<%
        }
   }
%>

</table>
</body>
</html>