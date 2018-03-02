<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="entity.Paciente"%>
    <%@page import="entity.FichaLente"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../meta.jspf"%>
<title>S.Optica | Lente Recetado</title>
</head>
<body>
<%@ include file="../nav.jspf" %>
<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Lente Recetado</h1>
                </div><!-- /.col-lg-12 -->
                
        	</div><!-- /.row -->
        	
        	<div class="row">
                <div class="col-lg-12">
                    <%
                    FichaLente f = new FichaLente();
                	f = (FichaLente)request.getAttribute("ficha");
                    String tipo = "";
           			switch (f.getEstado()) {
       				case "Nuevo":
       					%>
       					<div class="col-lg-8">
                    	<div>
                                    <p>
                                        <strong>NUEVO!</strong>
                                        <span class="pull-right text-muted">25% Realizado</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100" style="width: 25%">
                                            <span class="sr-only">25% Complete (success)</span>
                                        </div>
                                    </div>
                                </div>
                   		 </div>
                   		 <div class="col-lg-4">
                    	<p align="center"><small>CAMBIAR ESTADO</small></p>
                    	<button type="button" class="btn btn-outline btn-warning text-right btn-block btn-sm" onclick="document.location ='EstadoFicha?ff=<%=f.getIdFicha()%>&hc=<%=((Paciente)request.getAttribute("pac")).getIdPac()%>'" >En Taller</button>
                    	
                   		 </div>
       					<% 
       				break;
       				case "Taller":
       					%>
       					<div class="col-lg-8">
                    	<div>
                                    <p>
                                        <strong>EN TALLER</strong>
                                        <span class="pull-right text-muted">50% Realizado</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50%">
                                            <span class="sr-only">50% Realizado</span>
                                        </div>
                                    </div>
                                </div>
                   		 </div>
                   		 <div class="col-lg-4">
                    	<p align="center"><small>CAMBIAR ESTADO</small></p>
                    	<button type="button" class="btn btn-outline btn-danger text-right btn-block btn-sm" onclick="document.location ='EstadoFicha?ff=<%=f.getIdFicha()%>&hc=<%=((Paciente)request.getAttribute("pac")).getIdPac()%>'" >Terminado</button>
                    	
                   		 </div>
       					<%
       				 break;
       				case "Terminado":
       					%>
       					<div class="col-lg-8">
                    	<div>
                                    <p>
                                        <strong>TERMINADO</strong>
                                        <span class="pull-right text-muted">75% Realizado</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 75%">
                                            <span class="sr-only">75% Realizado</span>
                                        </div>
                                    </div>
                                </div>
                   		 </div>
                   		 <div class="col-lg-4">
                    	<p align="center"><small>CAMBIAR ESTADO</small></p>
                    	<button type="button" class="btn btn-outline btn-info text-right btn-block btn-sm" onclick="document.location ='EstadoFicha?ff=<%=f.getIdFicha()%>&hc=<%=((Paciente)request.getAttribute("pac")).getIdPac()%>'" >Comunicado</button>
                    	
                   		 </div>
       					<%
       				 break;
       				case "Comunicado":
       					%>
       					<div class="col-lg-8">
                    	<div>
                                    <p>
                                        <strong>COMUNICADO</strong>
                                        <span class="pull-right text-muted">90% Realizado</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100" style="width: 90%">
                                            <span class="sr-only">90% Realizado</span>
                                        </div>
                                    </div>
                                </div>
                   		 </div>
                   		 <div class="col-lg-4">
                    	<p align="center"><small>CAMBIAR ESTADO</small></p>
                    	<button type="button" class="btn btn-outline btn-primary text-right btn-block btn-sm" onclick="document.location ='EstadoFicha?ff=<%=f.getIdFicha()%>&hc=<%=((Paciente)request.getAttribute("pac")).getIdPac()%>'" >Entregado</button>
                    	
                   		 </div>
       					<%
       				 break;
       			} %>
                    	
                    
                </div>
           </div>
        	</BR>
			<div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Paciente: <b><%=((Paciente)request.getAttribute("pac")).getApellido()%> <%=((Paciente)request.getAttribute("pac")).getNombre()%></b></div>
                        <!-- /.panel-heading -->
                        
        
                        
                        <div class="panel-body">
                        

            <form id ="formFicha" name="formFicha" action="ModificarLente" method="post"> 
            <input type="hidden" value="<%=((Paciente)request.getAttribute("pac")).getIdPac()%>" name="hc" id="hc">
            <input type="hidden" value="<%=f.getIdFicha()%>" name="idf" id="idf">
            <div class="col-md-12">
       
            <div class="col-md-6">
               <div class="form-group input-group">
                    <span class="input-group-addon">F. Estima Salida*</span>
                    <input type="date" class="form-control" required="" name="fecha_estimada" value="<%=f.getFecEstimadaS()%>" >
                </div> 
            </div>
            <div class="col-md-6">
               <div class="form-group input-group">
                    <span class="input-group-addon">Fecha Receta*</span>
                    <input type="date" class="form-control" required=""  name="fecha_receta" value="<%=f.getFecReceta()%>" >
                </div> 
            </div>
                <div>
                <hr></hr>
                </div>
            <div class="col-md-4">
                <div class="form-group input-group">
                    <span class="input-group-addon">Armazon</span>
                    <input type="text" class="form-control" maxlength="15" name="armazon" placeholder="" value="<%=f.getArmazon()%>">
                </div> 
                <div class="form-group input-group">
                    <span class="input-group-addon">Modelo</span>
                    <input type="text" class="form-control"  name="modelo" maxlength="15" placeholder="" value="<%=f.getModelo()%>">
                </div>
                <div class="form-group input-group">
                   <span class="input-group-addon">Color</span>
                   <input type="text" class="form-control" name="color" maxlength="15" placeholder="" value="<%=f.getColor()%>">
                </div>
            </div>
            <div class="col-md-4">
               <label>Tipo:</label>                                    	
               <div class="radio">
                   <label>
                      <input type="radio" name="tipo" onclick="enable()" value="4" <% if(f.getTipo().getIdTipo()==4){%>checked  <% }%>>
   			Multifocal
                   </label>
                   <br>
                   <label>
                        <input type="radio" onclick="enable()" name="tipo"  value="5" <% if(f.getTipo().getIdTipo()==5){%>checked  <% }%>>
   			Bifocal
                   </label>
                  <br>
                   <label>
                       <input type="radio" onclick="disable_cerca()" name="tipo"  value="6" <% if(f.getTipo().getIdTipo()==6){%>checked  <% }%>>
   			Lejos Monofocal
                        
                   </label>
                   <br>
                   <label>
                       <input type="radio" onclick="disable_lejos()" onchange="disable_lejos()" name="tipo" value="7" <% if(f.getTipo().getIdTipo()==7){%>checked  <% }%>>
   			Cerca Monofocal
                   </label>
                   <br>
                   <label>
                        <input type="radio" onchange="disable_lejos()" name="tipo"  value="8" <% if(f.getTipo().getIdTipo()==8){%>checked  <% }%> >
   			Cerca Ocupacional
                   </label>
                   <br>
            </div>
          </div>
             <div class="col-md-4">
               <label>Lente:</label>                                    	
               
                <div class="radio">
                   <label>
                        <input type="radio" name="lente"  value="1" <% if(f.getMaterial().getIdMaterial()==1){%>checked  <% }%>>
   			Mineral
                   </label>
                    <br>
                   <label>
                        <input type="radio" name="lente"  value="2" <% if(f.getMaterial().getIdMaterial()==2){%>checked  <% }%>>
   			Organico
                   </label>
                    <br>
                   <label>
                        <input type="radio" name="lente"  value="3" <% if(f.getMaterial().getIdMaterial()==3){%>checked  <% }%>>
   			Policarbonato
                   </label>
                        <br>
                </div>
              </div>
                
            <div class="col-md-12">
                 
            </div>
                
                <div class="col-md-3">
                    <h4>Cerca</h4>
                   <label>Detalle O.D</label>	
                    <div class="form-group input-group">
                        <span class="input-group-addon">Esf. (O.D)</span>
                        
                      <input type="number" step="0.25" min="-20" max="20" maxlength="2" class="form-control" name="esf_od_c" id="esf_od_c" placeholder="" value="<%=f.getCodesf()%>">
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon">Cil. (O.D)</span>
                        <input type="number" step="0.25" min="-20" max="20" maxlength="2" class="form-control" id="cil_od_c" name="cil_od_c" placeholder="" value="<%=f.getCoicil()%>">
                    </div>  
                    <div class="form-group input-group">
                       <span class="input-group-addon">a</span>
                       <input type="number" min="-10" max="360" class="form-control" id="a_od_c" value="0" name="a_od_c" placeholder="" maxlength="3" value="<%=f.getCodgrados()%>">
                       <div class="input-group-addon">Grados</div>
                    </div>
                </div>
                    <div class="col-md-3">
                        <h4>______</h4>
                        <label>Detalle O.I</label>	
                        <div class="form-group input-group">
                            <span class="input-group-addon">Esferico</span>
                            <input type="number" step="0.25" min="-20" max="20" maxlength="2" class="form-control" id="esf_oi_c" name="esf_oi_c" placeholder="" value="<%=f.getCoiesf()%>">
                        </div>    
                        <div class="form-group input-group">
                            <span class="input-group-addon">Cilindrico</span>
                            <input type="number" step="0.25" min="-20" max="20" maxlength="2" class="form-control" id="cil_oi_c"   name="cil_oi_c" placeholder="" value="<%=f.getCoicil()%>">
                        </div> 
                        <div class="form-group input-group">
                           <span class="input-group-addon">a</span>
                           <input type="number"  min="0" max="360" class="form-control" value="0" id="a_oi_c" name="a_oi_c" placeholder="" maxlength="3" value="<%=f.getCoigrados()%>" >
                           <div class="input-group-addon">Grados</div>
                        </div>   
                    </div>
                <div class="col-md-3">
                    <h4>Lejos</h4>
                   <label>Detalle O.D</label>	
                    <div class="form-group input-group">
                        <span class="input-group-addon">Esf. (O.D)</span>
                        <input type="number" step="0.25" min="-20" max="20" maxlength="2" class="form-control" id="esf_od_l" name="esf_od_l" placeholder="" value="<%=f.getLodesf()%>">
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon">Cil. (O.D)</span>
                        <input type="number" step="0.25" min="-20" max="20" maxlength="2" class="form-control" id="cil_od_l" name="cil_od_l" placeholder="" value="<%=f.getLodcil()%>">
                    </div>  
                    <div class="form-group input-group">
                       <span class="input-group-addon">a</span>
                       <input type="number" min="0" max="360" class="form-control" value="0" name="a_od_l" id="a_od_l" placeholder="" maxlength="3" size="3" value="<%=f.getLodgrados()%>">
                       <div class="input-group-addon">Grados</div>
                    </div>
                </div>
                    <div class="col-md-3">
                        <h4>______</h4>
                        <label>Detalle O.I</label>	
                        <div class="form-group input-group">
                            <span class="input-group-addon">Esf. (O.I)</span>
                            <input type="number" step="0.25" min="-20" max="20" maxlength="2" class="form-control" name="esf_oi_l" id="esf_oi_l"  placeholder="" value="<%=f.getLoiesf()%>">
                        </div>    
                        <div class="form-group input-group">
                            <span class="input-group-addon">Cil. (O.I)</span>
                            <input type="number" step="0.25" min="-20" max="20" maxlength="2" class="form-control" name="cil_oi_l" id="cil_oi_l" placeholder="" value="<%=f.getLoicil()%>">
                        </div> 
                        <div class="form-group input-group">
                           <span class="input-group-addon">a</span>
                           <input type="number" min="0" max="360" class="form-control" placeholder="" value="0" name="a_oi_l" id="a_oi_l"  maxlength="3" size="3" value="<%=f.getLoigrados()%>">
                           <div class="input-group-addon">Grados</div>
                        </div>   
                    </div>
                <div class="col-md-12">
                <h4>Costos</h4>
                    <div class="col-md-4">
                        <div class="form-group input-group">
                            <span class="input-group-addon">Armazón			$</span>
                            <input type="number" min="0" step="0.10" maxlength="5" class="form-control" name="tot_arma" placeholder="" value="<%=f.getCostoArm()%>">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group input-group">
                            <span class="input-group-addon">Cristales		$</span>
                            <input type="number" min="0" step="0.10" maxlength="5" class="form-control" name="total_cris" placeholder="" value="<%=f.getCostoCrist()%>">
                        </div>  
                    </div>
                  
                   <div class="col-md-4">
                      <div class="form-group input-group">
                           <span class="input-group-addon">Seña		$</span>
                           <input type="number" min="0" step="0.10" maxlength="5" class="form-control" name="sena" placeholder="" value="<%=f.getSena()%>">
                        </div>
                    </div>  
               <div class="col-md-9">
                    <h4>Notas</h4>
                <textarea class="form-control" name="notas" rows="3" maxlength="300"><%=f.getNotas()%></textarea>
               </div>    
               <div class="col-md-3">
                    <div align="right">
                        <br> 
                    <hr>
                    </div>  
                    <div align="right">
                    <button type="submit" class="btn btn-outline btn-warning text-right btn-block">Modificar</button>   
                  </div> 
                   <hr>
               </div>    
            </div>
          </div>
         </form>    
        </div>
       
       </div>
     </div>
</div>
</div>
     
<script src="config/js/ficha.js"></script>
</body>
</html>