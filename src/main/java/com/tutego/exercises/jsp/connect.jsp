<html>
   <head>
      <title>Database Test JSP</title>
   </head>
   <body>
   <h1>Database Test JSP</h1>

<%@ page import="java.sql.*" %>

<%
 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 String url = "jdbc:odbc:Adress";
 Connection conn = java.sql.DriverManager.getConnection("jdbc:odbc:Adressen","","");
 Statement stat = conn.createStatement();
 ResultSet result = stat.executeQuery("SELECT * FROM Adressen");
 ResultSetMetaData rsmd = result.getMetaData();
 int count = rsmd.getColumnCount();
%>

<br><br>

<table border="2">
<%
 while ( result.next() )
 {
  out.println( "<tr>" );
  for(int i=1; i<=count;i++)
  {
    String s = result.getString( i );
    out.println( "<td>"+s+"</td>" );
  }
  out.println( "</tr>" );
 }

 result.close();
%>
</table>

<%
 conn.close();
%>
   </body>
</html>

