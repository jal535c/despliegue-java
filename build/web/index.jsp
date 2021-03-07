<%-- 
    Document   : index
    Created on : 14-sep-2020, 10:27:03
    Author     : Juan Luis Almahano Leiva
--%>

<%@page import="paq.Juego"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  
  <body>
    <h3>BUSCA LA PAREJA (Autor: Juan Luis Almahano Leiva)</h3>
         
    <%          
      Juego juego = new Juego();
      int apareceBoton;
      
      if (session.getAttribute("juego") == null) {    //la primera vez
        session.setAttribute("juego", juego);
        apareceBoton=1;
      } else {
        juego=(Juego)session.getAttribute("juego");
        apareceBoton=juego.getBoton();
      }                  
    %>
        
    <form action="reset.jsp" method="post">
      <input type="submit" value="Empezar de nuevo">
    </form>
    
    <br>
    
    <% if (apareceBoton==1) { %>
    <form action="ocultar.jsp" method="post">
      <input type="submit" value="¿Tapamos?">    
    </form>
    <% } %>
        
    <br>
    
    <table border="1">
      <tr>
    
        <% 
          for (int i=0; i<16; i++) { 
            if (i%4==0) {
              out.println("</tr>");
              out.println("<tr>");
            }
            
        %>
    
        <td>
          <form action="foto.jsp" method="get">
            <input type="image" src="<%= juego.mostrar(i)%>" width="100" height="100">    <!-- es como un boton -->
            <input type="hidden" name="posicion" value="<%= i%>">
          </form>
        </td>
      
        <%        
          } 
        %>
      
      </tr>
    </table>
            
    <h5>Fallos: <%= juego.getFallos()%></h5>
  </body>
</html>
