   function consultar(valor) {
      var Mensaje = "";
         
     if( ! fTrim( $('#key_year').val() ) ){
        Mensaje = Mensaje + "'Gesti\363n' es obligatorio\n";
      }
      else{
          if( ! foNumero( $('#key_year').val() ) ){
            Mensaje = Mensaje + "'Gesti\363n' debe ser un n\372mero\n";
          } 
      }
      if( ! fTrim( $('#key_cuo').val() ) ){
        Mensaje = Mensaje + "'Aduana' es obligatorio\n";
      }
      else{
          if( ! foNumero( $('#key_cuo').val() ) ){
            Mensaje = Mensaje + "'Aduana' debe ser un n\372mero\n";
          } 
      }
      if( ! fTrim( $('#reg_serial').val() ) ){
        Mensaje = Mensaje + "'N\372mero' es obligatorio\n";
      }
      else{
          if( ! foNumero( $('#reg_serial').val() ) ){
            Mensaje = Mensaje + "'N\372mero' debe ser un n\372mero\n";
          } 
      }
    
    
      if( Mensaje == "" )
      {
        $('#boton').val('consultar_anul');
        document.FisAnulControldifForm.submit();
      }
      else
      {
        alert( Mensaje );
        return false;
      }
  
        
  };
  
  function cancelar(valor) {
        $('#boton').val('cancelar_enm');
      document.FisAnulControldifForm.submit();
  };
  
  function guardaranul(valor) {
  
      var Mensaje = "";            
      var regex = /^\d+(?:\.\d{0,2})$/;  
      var o = /\b.+/.test($('#obsanulacion').val());
     
   if (!o) Mensaje = Mensaje +"Observaci\363n, es obligatorio.\n";
   
   if($('#obsanulacion').val().length>=600){
                Mensaje = Mensaje + "Observaci\363n, solo es permitido 600 caracteres.\n";                    
                } 
   
    
      if( Mensaje == "" )
      {
        $('#boton').val('guardar_anulacion');
        document.FisAnulControldifForm.submit();
      }
      else
      {
        alert( Mensaje );
        return false;
      }
  };


                
                
function ComparaFechas(fec0, fec1)
  {  
   var bRes = false;
   var sDia0 = fec0.substr(0, 2);
   var sMes0 = fec0.substr(3, 2);
   var sAno0 = fec0.substr(6, 4);
   var sDia1 = fec1.substr(0, 2);
   var sMes1 = fec1.substr(3, 2);
   var sAno1 = fec1.substr(6, 4);
    if (sAno1 > sAno0 ) bRes = true;
   else 
   {  if (sAno0 == sAno1)
      {  if (sMes1 > sMes0 ) bRes = true;
         else 
         {  if (sMes0 == sMes1)
               if (sDia1 >= sDia0 ) bRes = true;
         }
      }
      
   }
   return bRes;
  };  
  
  
  
function recupera_ufv() {

      var aux = Math.random();
      var fechaufv = $('#fec_liq').val();
      
      $.getJSON("json.do", 
      {
          parameter : 'devuelveUFV', fecha : fechaufv, vaux : aux
      },
      function (j) {
      if(j[0].value==0)
            {
             $('#valor_ufv').val('');
            }
            else
            {
            $('#valor_ufv').val(j[0].value);
            }
      
      });   
      
      /*
      $.get('JqueryServlet', { 
            fecha : fechaufv
      }, function(responseText) { 
            $('#valor_ufv').val(responseText);
      });
      */
     
      
  };
  function calcula_tributo() {
    var tributo_ga = new Number($('#tributo_ga').val());
    var tributo_iva = new Number($('#tributo_iva').val());
    var tributo_ice = new Number($('#tributo_ice').val());
    var tributo_iehd = new Number($('#tributo_iehd').val());
    var valor_ufv = new Number($('#valor_ufv').val().replace(',','.'));
    if(valor_ufv == "")
    {
        $('#tributo_ufv_ga').val("");
        $('#tributo_ufv_iva').val("");
        $('#tributo_ufv_ice').val("");
        $('#tributo_ufv_iehd').val("");
        $('#sancion').val("");
        $('#sancion_ufv').val("");
    }
    else
    {
        $('#tributo_ufv_ga').val(Math.round(tributo_ga/valor_ufv,0));
        $('#tributo_ufv_iva').val(Math.round(tributo_iva/valor_ufv,0));
        $('#tributo_ufv_ice').val(Math.round(tributo_ice/valor_ufv,0));
        $('#tributo_ufv_iehd').val(Math.round(tributo_iehd/valor_ufv,0));
        
        var tributo_ufv_ga = new Number($('#tributo_ufv_ga').val());
        var tributo_ufv_iva = new Number($('#tributo_ufv_iva').val());
        var tributo_ufv_ice = new Number($('#tributo_ufv_ice').val());
        var tributo_ufv_iehd = new Number($('#tributo_ufv_iehd').val());
        
        
        $('#sancion').val(tributo_ga+tributo_iva+tributo_ice+tributo_iehd);
        $('#sancion_ufv').val(Math.round((tributo_ga+tributo_iva+tributo_ice+tributo_iehd)/valor_ufv,0));
    }    
  };
  
  
  function calcula_multaca() {
    var tributo = new Number($('#multaca_ufv').val());
    var valor_ufv = new Number($('#valor_ufv').val().replace(',','.'));
    if(valor_ufv == "")
    {
        $('#multaca').val("");
    }
    else
    {
        $('#multaca').val(Math.round(tributo*valor_ufv,0));
    }    
  };
  
  
  function calcula_multacc() {
    var tributo = new Number($('#multacc').val());
    var valor_ufv = new Number($('#valor_ufv').val().replace(',','.'));
    if(valor_ufv == "")
    {
        $('#multacc_ufv').val("");
    }
    else
    {
        $('#multacc_ufv').val(Math.round(tributo/valor_ufv,0));
    }    
  };
  
  function calcula_multacd() {
    var tributo = new Number($('#multacd').val());
    var valor_ufv = new Number($('#valor_ufv').val().replace(',','.'));
    if(valor_ufv == "")
    {
        $('#multacd_ufv').val("");
    }
    else
    {
        $('#multacd_ufv').val(Math.round(tributo/valor_ufv,0));
    }    
  };
  