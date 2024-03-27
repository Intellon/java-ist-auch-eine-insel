<%@page import = "java.util.*" %>

<%
  Date datum = new Date();
  int stunde = datum.getHours();
%>

<%= (stunde < 12)? stunde:(stunde - 12) %> <%= (stunde < 12)? "AM" : "PM" %>