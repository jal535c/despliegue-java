<%-- 
    Document   : reset2
    Created on : 28-may-2020, 9:09:31
    Author     : Juan Luis Almahano Leiva
--%>

<%
  session.invalidate();
  response.sendRedirect("index.jsp");
%>
