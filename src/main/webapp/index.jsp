<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="/WEB-INF/error.jsp" import="messagerie.*" %>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
		<font face="Arial">
			<p>
				<table border="1" cellpadding="3" cellspacing="2" width="20%" align="center">
					<tr bgcolor="#FF6600">
						<th>Subject</th>
						<th>Message</th>
					</tr>
					<%
						MessageList messageList = new MessageList(1);
						int line = 0;
						while (messageList.next()){
					%>
					<tr bgcolor="<%= line++ % 2 == 0 ? "#FFFF66" : "#FFCC00"%>">
						<td><b><%= messageList.subject() %></b></td>
						<td><%= messageList.text() %></td>
					</tr>
					<%
						}
						messageList.stop();
					%>
				</table>
			</p>
		</font>
<%@ include file="/WEB-INF/jspf/footer.jspf" %>