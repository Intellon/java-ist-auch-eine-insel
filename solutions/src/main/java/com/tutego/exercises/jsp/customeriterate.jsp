<%@ taglib prefix="c" uri="../WEB-INF/tld/c-rt.tld" %>

<jsp:useBean id="customerList" class="com.javatutor.Customers" />

<html>

<head>
</head>

<body>

<table border="2">
    <c:forEach var="iter" items="${customerList.customerList}" varStatus="status">
  
    <tr bgcolor="&lt;c:out value='${((status.count mod 2) == 0) ? " ffffaa"="" :="" "ffff77" }'"="">
		<td>
          <c:out value="${status.count}" />
        </td>
		<td>
          <c:out value="${iter.name}" />
        </td>
		<td>
          <c:out value="${iter.adress}" />
        </td>
	</tr>

    </c:forEach>
    </table>

</body>

</html>
