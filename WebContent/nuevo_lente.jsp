<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="entity.Paciente"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../meta.jspf"%>
<title>S.Optica | Nuevo Lente Recetado</title>
</head>
<body>
<%@ include file="../nav.jspf" %>
<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Nuevo Lente Recetado</h1>
                </div><!-- /.col-lg-12 -->
        	</div><!-- /.row -->
        	
<div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Atenciones del paciente: </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">

            <form id ="formFicha" name="Ficha" action="" onsubmit="return validarFicha(this)" method="post"> 
            
            <div class="col-md-12">
            <div class="col-md-4">
               <div class="form-group input-group">
                    <span class="input-group-addon">Fecha Entrada*</span>
                    <input type="date" class="form-control" required="" name="fecha_entra" value="" placeholder="dd/mm/aaaa">
                </div> 
            </div>
            <div class="col-md-4">
               <div class="form-group input-group">
                    <span class="input-group-addon">F. Estima Salida*</span>
                    <input type="date" class="form-control" required="" name="fecha_estimada" value="" >
                </div> 
            </div>
            <div class="col-md-4">
               <div class="form-group input-group">
                    <span class="input-group-addon">Fecha Receta*</span>
                    <input type="date" class="form-control" required=""  name="fecha_receta" value="" >
                </div> 
            </div>
                <div>
                <hr></hr>
                </div>
            <div class="col-md-4">
                <div class="form-group input-group">
                    <span class="input-group-addon">Armazon</span>
                    <input type="text" class="form-control" maxlength="15" name="armazon" placeholder="">
                </div> 
                <div class="form-group input-group">
                    <span class="input-group-addon">Modelo</span>
                    <input type="text" class="form-control"  name="modelo" maxlength="15" placeholder="">
                </div>
                <div class="form-group input-group">
                   <span class="input-group-addon">Color</span>
                   <input type="text" class="form-control" name="color" maxlength="15" placeholder="">
                </div>
            </div>
            <div class="col-md-4">
               <label>Tipo:</label>                                    	
               <div class="radio">
                   <label>
                      <input type="radio" name="tipo" onclick="enable()" value="Multifocal" checked>
   			Multifocal
                   </label>
                   <br>
                   <label>
                        <input type="radio" onclick="enable()" name="tipo"  value="Bifocal" >
   			Bifocal
                   </label>
                  <br>
                   <label>
                       <input type="radio" onclick="disable_cerca()" name="tipo"  value="Lejos Monofocal" >
   			Lejos Monofocal
                        
                   </label>
                   <br>
                   <label>
                       <input type="radio" onclick="disable_lejos()" onchange="disable_lejos()" name="tipo" value="Cerca Monofocal" >
   			Cerca Monofocal
                   </label>
                   <br>
                   <label>
                        <input type="radio" onchange="disable_lejos()" name="tipo"  value="Cerca Ocupacional" >
   			Cerca Ocupacional
                   </label>
                   <br>
            </div>
          </div>
             <div class="col-md-4">
               <label>Lente:</label>                                    	
               
                <div class="radio">
                   <label>
                        <input type="radio" name="lente"  value="Mineral" checked>
   			Mineral
                   </label>
                    <br>
                   <label>
                        <input type="radio" name="lente"  value="Organico" >
   			Organico
                   </label>
                    <br>
                   <label>
                        <input type="radio" name="lente"  value="Policarbonato" >
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
                        
                      <input type="number" step="0.25" min="-20" max="20" maxlength="2" class="form-control" name="esf_od_c" id="esf_od_c" placeholder="">
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon">Cil. (O.D)</span>
                        <input type="number" step="0.25" min="-20" max="20" maxlength="2" class="form-control" id="cil_od_c" name="cil_od_c" placeholder="">
                    </div>  
                    <div class="form-group input-group">
                       <span class="input-group-addon">a</span>
                       <input type="number" min="-10" max="360" class="form-control" id="a_od_c" value="0" name="a_od_c" placeholder="" maxlength="3">
                       <div class="input-group-addon">Grados</div>
                    </div>
                </div>
                    <div class="col-md-3">
                        <h4>______</h4>
                        <label>Detalle O.I</label>	
                        <div class="form-group input-group">
                            <span class="input-group-addon">Esferico</span>
                            <input type="number" step="0.25" min="-20" max="20" maxlength="2" class="form-control" id="esf_oi_c" name="esf_oi_c" placeholder="">
                        </div>    
                        <div class="form-group input-group">
                            <span class="input-group-addon">Cilindrico</span>
                            <input type="number" step="0.25" min="-20" max="20" maxlength="2" class="form-control" id="cil_oi_c"   name="cil_oi_c" placeholder="">
                        </div> 
                        <div class="form-group input-group">
                           <span class="input-group-addon">a</span>
                           <input type="number"  min="0" max="360" class="form-control" value="0" id="a_oi_c" name="a_oi_c" placeholder="" maxlength="3" >
                           <div class="input-group-addon">Grados</div>
                        </div>   
                    </div>
                <div class="col-md-3">
                    <h4>Lejos</h4>
                   <label>Detalle O.D</label>	
                    <div class="form-group input-group">
                        <span class="input-group-addon">Esf. (O.D)</span>
                        <input type="number" step="0.25" min="-20" max="20" maxlength="2" class="form-control" id="esf_od_l" name="esf_od_l" placeholder="">
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon">Cil. (O.D)</span>
                        <input type="number" step="0.25" min="-20" max="20" maxlength="2" class="form-control" id="cil_od_l" name="cil_od_l" placeholder="">
                    </div>  
                    <div class="form-group input-group">
                       <span class="input-group-addon">a</span>
                       <input type="number" min="0" max="360" class="form-control" value="0" name="a_od_l" id="a_od_l" placeholder="" maxlength="3" size="3">
                       <div class="input-group-addon">Grados</div>
                    </div>
                </div>
                    <div class="col-md-3">
                        <h4>______</h4>
                        <label>Detalle O.I</label>	
                        <div class="form-group input-group">
                            <span class="input-group-addon">Esf. (O.I)</span>
                            <input type="number" step="0.25" min="-20" max="20" maxlength="2" class="form-control" name="esf_oi_l" id="esf_oi_l"  placeholder="">
                        </div>    
                        <div class="form-group input-group">
                            <span class="input-group-addon">Cil. (O.I)</span>
                            <input type="number" step="0.25" min="-20" max="20" maxlength="2" class="form-control" name="cil_oi_l" id="cil_oi_l" placeholder="">
                        </div> 
                        <div class="form-group input-group">
                           <span class="input-group-addon">a</span>
                           <input type="number" min="0" max="360" class="form-control" placeholder="" value="0" name="a_oi_l" id="a_oi_l"  maxlength="3" size="3">
                           <div class="input-group-addon">Grados</div>
                        </div>   
                    </div>
                <div class="col-md-12">
                <h4>Costos</h4>
                    <div class="col-md-3">
                        <div class="form-group input-group">
                            <span class="input-group-addon">Armazón			$</span>
                            <input type="number" min="0" step="0.10" maxlength="5" class="form-control" name="tot_arma" placeholder="">
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group input-group">
                            <span class="input-group-addon">Cristales		$</span>
                            <input type="number" min="0" step="0.10" maxlength="5" class="form-control" name="total_cris" placeholder="">
                        </div>  
                    </div>
                  <div class="col-md-3">
                       <div class="form-group input-group">
                           <span class="input-group-addon">Adicionales  $</span>
                           <input type="number" min="0" step="0.10" maxlength="5" class="form-control" name="adicionales" placeholder="">
                       </div>
                  </div> 
                   <div class="col-md-3">
                      <div class="form-group input-group">
                           <span class="input-group-addon">Seña		$</span>
                           <input type="number" min="0" step="0.10" maxlength="5" class="form-control" name="sena" placeholder="">
                        </div>
                    </div>  
               <div class="col-md-9">
                    <h4>Notas</h4>
                <textarea class="form-control" name="notas" rows="3" maxlength="150"></textarea>
               </div>    
               <div class="col-md-3">
                    <div align="right">
                        <br> 
                    <hr>
                    </div>  
                    <div align="right">
                    <button type="submit" class="btn btn-success">Aceptar</button>   
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
               </div>
          </div>
</div>

                    
<script src="config/js/ficha.js"></script>
</body>
</html>