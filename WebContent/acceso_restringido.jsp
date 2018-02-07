<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="meta.jspf"%>

<title>S.Optica | Acceso Restringido</title>
</head>
<body>
<%@ include file="nav.jspf" %>

	<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Acceso Restringido</h1>
                </div><!-- /.col-lg-12 -->
        	</div><!-- /.row -->
        	<div class="panel-body">
        		<div class="alert alert-danger alert-dismissable">
                	<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                               <big><i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                               ATENCION: | </big> Usted no tiene permisos para ingresar a <%=request.getAttribute("infoText") %>
                </div>
                
			      	
		</div>
        	
	</div><!-- /page-wrapeper -->

<%@ include file="foot.jspf" %>
</body>
</html>