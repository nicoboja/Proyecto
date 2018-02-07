<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="config/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<!-- Custom Fonts -->
<link href="config/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<script type="text/javascript" >
function carga() {
	document.getElementById("alias").focus();
	
}
</script>


<title>Soptica | Iniciar Sesion</title>
</head>
<body onload="carga();">

<div class="container">

    <div class="row" id="center">
   	 	<div class="col-md-4 col-md-offset-4">
    		<h1 align="center">S<i class="fa fa-eye" aria-hidden="true"></i><small>PTICA</small></h1>
    		<p align="center" >OPTICA CENTRO</p>
    		
    	</div>
		<div class="col-md-4 col-md-offset-4">
		<br>
    		<div class="panel panel-default">
    		
			  	<div class="panel-heading">
			  	<h3 class="panel-title">Iniciar Sesión</h3>
			 	</div>
			 	
			  	<div class="panel-body">
			  	
			 <div class="alert alert-<%=request.getAttribute("infoTipo")%>">
                	<button type="button" class="close" data-dismiss="alert" aria-hidden="true"></button>
                              <big><i class="fa fa-exclamation-circle" aria-hidden="true"></i></big>
                               <%=request.getAttribute("infoText")%>
             </div> 
                
            
                
			  <form class="form-signin" name="signin" action="/Proyecto/inicio" method="post">
                    <fieldset>
			    	  	<div class="form-group">
			    	  		<input class="form-control" placeholder="Usuario" name="user" id="user" type="text" required maxlength="15" minlength="4">
			    		</div>
			    		<div class="form-group">
			    			<input class="form-control" placeholder="Contraseña" name="pass" type="pass" value="" required maxlength="15" minlength="3">
			    		</div>
			    		
			    		<input class="btn btn-lg btn-success btn-block" type="submit" value="Iniciar">
			    		<br>
			    		<p align="right" ><em><a href="#">Recuperar Contraseña</a></em></p>
			    	</fieldset>
			   </form>  
			      	
			    </div>
			 
			</div>
	
		</div>
	</div>
</div>

</body>
</html>