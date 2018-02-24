<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="entity.FichaLente"%>
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
                            Atenciones del paciente: 
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        <div class="table-responsive">
						 <table id="example" cellspacing="0" class="table table-striped table-bordered table-hover" width="90%">
						 <!-- class="table table-striped table-bordered table-hover"    -->
                         <thead>
            					<tr>
                					<th>HC</th>
                					<th>Doc.</th>
                					
                               </tr>
        					</thead>
       						<tfoot>
          					  <tr>
                					<th>HC</th>
                					<th>Doc.</th>
                					
                                   	
                            </tr>
        					</tfoot>
       					 <tbody>
       					 <%if(request.getAttribute("listAte") != null){
       						ArrayList<FichaLente> listPac = (ArrayList<FichaLente>)request.getAttribute("listAte");
       	            		for(FichaLente f: listPac){
       						 %>
           							<tr>
                                       	<td>asd</td>
                                        <td>hola</td>
                                       
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
                                 <button type="submit" class="btn btn-info btn-lg btn-block" >Nueva Atención</button>  	
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