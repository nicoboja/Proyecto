<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="meta.jspf"%>

<title>S.Optica | Escritorio</title>
</head>
<body>
<%@ include file="nav.jspf" %>

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Escritorio</h1>
        </div><!-- /.col-lg-12 -->
    </div><!-- /.row -->
        	
    <div class="row">
        <div class="col-lg-3 col-md-6">
            <div class="panel panel-green">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="fa fa-tasks fa-5x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge"><%=request.getAttribute("nnuevos")%></div>
                            <div>Nuevas Entradas!</div>
                        </div>
                    </div><!--/row-->
                </div><!--/panel headings-->
                <%if((int)request.getAttribute("nnuevos")!=0){%>
                    <a href="../Proyecto/Pendientes?estado=Nuevo">
                    <div class="panel-footer">
                        <span class="pull-left">Ver detalle</span>
                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                        <div class="clearfix"></div>
                    </div>
                    </a>
                <% } %>
            </div>
        </div><!--/terminados-->
        
        <div class="col-lg-3 col-md-6">
            <div class="panel panel-yellow">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="fa fa-wrench fa-5x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge"><%=request.getAttribute("ntaller")%></div>
                            <div>En Taller!</div>
                        </div>
                    </div>
                </div>
                <%if((int)request.getAttribute("ntaller")!=0){%>
                <a href="../Proyecto/Pendientes?estado=Taller">
                <div class="panel-footer">                
                    <span class="pull-left">Ver Detalles</span>
                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                    <div class="clearfix"></div>                              
                </div>
                </a>
                <% } %>
            </div>
        </div>

        <div class="col-lg-3 col-md-6">
            <div class="panel panel-red">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                        <i class="fa fa-exclamation-circle fa-5x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge"><%=request.getAttribute("nterminados")%></div>
                            <div>Terminados!</div>
                        </div>
                    </div>
                </div>
                <%if((int)request.getAttribute("nterminados")!=0){%>
                <a href="../Proyecto/Pendientes?estado=Terminado">
                    <div class="panel-footer">
                        <span class="pull-left">Ver detalle</span>
                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                        <div class="clearfix"></div>
                    </div>
                </a>
                <% } %>
            </div>
        </div>
        
        <div class="col-lg-3 col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="fa fa-thumbs-o-up fa-5x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge"><%=request.getAttribute("ncomunicados")%></div>
                            <div>Comunicados!</div>
                        </div>
                    </div>
                </div>
                 <%if((int)request.getAttribute("ncomunicados")!=0){%>
                <a href="../Proyecto/Pendientes?estado=Comunicado">
                <div class="panel-footer">
                    <span class="pull-left">Ver Detalles</span>
                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                    <div class="clearfix"></div>
                </div>
                </a>
                <% } %>
            </div>
        </div>
    </div> <!-- ROW -->
   <!--  / ALERTAS -->   


        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <i class="fa fa-pencil-square-o fa-fw"></i> Notas Personales
               		</div>  <!-- /.panel-heading -->
                	<div class="panel-body">
                		<form action="Notas" id="notas" name="notas" method="post">
                    	<div class="form-group">
                        	<textarea class="form-control" rows="10" id="notaint" name="notaint"><%if(((Usuario)session.getAttribute("uss")).getNotasInt()!=null){%><%=((Usuario)session.getAttribute("uss")).getNotasInt()%><%} %></textarea>
                    	</div>
                    	<div>
                        	<button type="submit" class="btn btn-outline btn-primary btn-lg btn-block">Guardar</button>
                    	</div>
                    	</form>
                	</div>
            	</div>
        	</div>     
       </div><!-- /row -->
                    	
	</div><!-- /page-wrapeper -->

<%@ include file="foot.jspf" %>
</body>
</html>