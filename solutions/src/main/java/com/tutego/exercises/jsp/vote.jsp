<jsp:useBean id="vote" class="com.javatutor.Voting" scope="application">
</jsp:useBean>
<%
  vote.setVotes(1240,546,6574,123,23);
%>


Voting:<br>
1: <jsp:getProperty name="vote" property="votesFor1"/>
<jsp:getProperty name="vote" property="votesFor1Percentage"/>%
<br>
2: <jsp:getProperty name="vote" property="votesFor2"/>
<jsp:getProperty name="vote" property="votesFor2Percentage"/>%
<br>
3: <jsp:getProperty name="vote" property="votesFor3"/>
<jsp:getProperty name="vote" property="votesFor3Percentage"/>%
<br>
4: <jsp:getProperty name="vote" property="votesFor4"/>
<jsp:getProperty name="vote" property="votesFor4Percentage"/>%
<br>
5: <jsp:getProperty name="vote" property="votesFor5"/>
<jsp:getProperty name="vote" property="votesFor5Percentage"/>%
<br>

VoteCount: <jsp:getProperty name="vote" property="allVotes"/><br>
Average: <jsp:getProperty name="vote" property="average"/><br>
