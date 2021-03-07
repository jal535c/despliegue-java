<%-- 
    Document   : ocultar
    Created on : 28-may-2020, 9:36:24
    Author     : Juan Luis Almahano Leiva
--%>

<%@page import="paq.Juego"%>
<%  
  Juego j=(Juego)session.getAttribute("juego");
  
  j.taparTodos();
  j.setBoton(0);
  j.setAnterior(-1);
  j.resetFallos();
  
  session.setAttribute("juego", j);  //los objetos funcionan por referencia
  response.sendRedirect("index.jsp");
%>