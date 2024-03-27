<table border = 0>

<tr>
	<td bgcolor ="grey">Zahl</td>
	<td bgcolor ="blue">Quadrat</td>
</tr>

<%
	for (int i = 1; i < 11; i++)
	{
%>
	<tr>
		<td bgcolor="red"> <%= i%> </td>
		<td bgcolor="wheat"> <%= i*i%> </td>
	</tr>

<%
	}
%>

</table>