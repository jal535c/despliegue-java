<%-- 
    Document   : foto
    Created on : 14-sep-2020, 9:51:27
    Author     : Juan Luis Almahano Leiva
--%>

<%@page import="paq.Juego"%>
<%  
  Juego j = (Juego)session.getAttribute("juego");     //recupero el objeto y la posicion   
  int id = Integer.parseInt(request.getParameter("posicion"));
 
  int anterior = j.getAnterior();
   
  if (anterior==-1 && j.estaOculta(id)) {    
    j.destaparUna(id);
    j.setAnterior(id);
    
  } else if (j.estaOculta(id)) {
    
    String s1 = j.getNombre(anterior);
    String s2 = j.getNombre(id);
    
    if (s1.equals(s2)) {      
      j.destaparUna(id);
      j.setAnterior(-1);
    } else {
      j.ocultarUna(anterior);
      j.destaparUna(id);
      j.setAnterior(id);
      j.incFallos();
    }
    
  }
    
  session.setAttribute("juego", j);   //no es necesario, los objetos funcionan por referencia
  response.sendRedirect("index.jsp");  
%>
