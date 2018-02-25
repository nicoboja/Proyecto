<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="entity.FichaLente"%>
    <%@page import="entity.Paciente"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../meta.jspf"%>
<title>S.Optica | Buscar Paciente</title>
</head>
<body>
<%@ include file="../nav.jspf" %>

	<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Registro de Atenciones</h1>
                </div><!-- /.col-lg-12 -->
        	</div><!-- /.row -->
        	
                    <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Atenciones del paciente: <b><%=((Paciente)request.getAttribute("pac")).getApellido()%> <%=((Paciente)request.getAttribute("pac")).getNombre() %></b>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        <div class="table-responsive">
						 <table id="example" cellspacing="0" class="table table-striped table-bordered table-hover" width="90%">
						 <!-- class="table table-striped table-bordered table-hover"    -->
                         <thead>
            					<tr>
            						<th>Ficha</th>
                					<th>Entrada</th>
                					<th>Estimado</th>
                					<th>Tipo</th>
                					<th>Lente</th>
                					<th>Estado</th>
                					<th>Fecha</th>
                					
                               </tr>
        					</thead>
       						<tfoot>
          					  <tr>
          					  		<th>Ficha</th>
                					<th>Entrada</th>
                					<th>Estimado</th>
                					<th>Tipo</th>
                					<th>Lente</th>
                					<th>Estado</th>
                					<th>Fecha</th>
                					
                                   	
                            </tr>
        					</tfoot>
       					 <tbody>
       					 <%if(request.getAttribute("listFicha") != null){
       						ArrayList<FichaLente> listPac = (ArrayList<FichaLente>)request.getAttribute("listFicha");
       	            		for(FichaLente f: listPac){
       	            			String tipo = "";
       	            			switch (f.getEstado()) {
       	            				case "Nuevo":
       	            					tipo = "success";
       	            				break;
       	            				case "Taller":
       	            					tipo = "warning";
       	            				 break;
       	            				case "Terminado":
       	            					tipo = "danger";
       	            				 break;
       	            				case "Comunicado":
       	            					tipo = "info";
       	            				 break;
       	            			}
       						 %>
           							
           							<tr class="<%=tipo%>">
           								<td><button type="button" onclick="document.location ='ModificarUsuario?id=<%=((Paciente)request.getAttribute("pac")).getApellido()%>'" class="btn btn-outline btn-warning text-right btn-block"><%=f.getIdFicha()%></button></td>
           								<td><%=f.getFecEntrada()%></td>
           								<td><%=f.getFecEstimadaS()%></td>
           								<td><%=f.getTipo().getDescripcion()%></td>
           								<td><%=f.getMaterial().getDescripcion()%></td>
           								<td><%=f.getEstado()%></td>
                                      	<td><%=f.getFecEstado()%></td>
                                      
                                	</tr>
                                	
                           <%} }%>        
 							  </tbody>
    					</table>
                            <!-- /.table-responsive -->
                          
                       
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
                <div class="col-lg-12">
                <br>
                                 <button type="button" onclick="document.location ='NuevoLente?hc=<%=((Paciente)request.getAttribute("pac")).getIdPac()%>'" class="btn btn-info btn-lg btn-block" >Nueva Atención</button>  	
                                 </div><!-- /row -->	
            </div>
            <!-- /.row -->
         
                </div><!-- /col12 -->
        </div>   <!-- /row -->
	</div><!-- /page-wrapeper -->

<%@ include file="../foot.jspf" %>
<script src="config/js/tablas.js"></script>
</body>
</html>