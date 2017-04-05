bCancel = false;

function fUpper( texto )
{
  return( texto.toUpperCase() );
}

function Trim ( texto )
{
  if (texto.length) 
  {
    while( '' + texto.charAt(0) == " " )
    {
      texto = texto.substring( 1, texto.length);
    }
  }
  return texto;
}

function fTrim( texto )
{
  aux = Trim( texto );
  if( aux == "" ) 
    return false;
  else
    return true;
}  

function fNumero( texto )
{
  var mascara = new RegExp("^[0-9]{0,150}$","g");
  return mascara.test( texto )
}

function fLetraNumero( texto )
{
  var mascara = new RegExp("^[a-zA-Z0-9-��]{0,150}$","g");
  return mascara.test( texto );
}

function fFecha( texto )
{
  var mascara = new RegExp("^[0-3]{1}[0-9]{1}/(01|02|03|04|05|06|07|08|09|10|11|12)/[1-2][0-9]{3}$","g");
  if (texto.length)
  {
    if( mascara.test(texto) )
    {
      var dd = texto.substring( 0,  2);
      var mm = texto.substring( 3,  5);
      var aa = texto.substring( 6, 10);
  
      if( aa<1960 || aa>2030 ) return false; //verficar con la fecha actual
      if( dd==0 ) return false;
      if( mm==4 || mm==6 || mm==9 || mm==11 )
      if( dd>30 ) return false;
      if( mm==2 )
      {
        var dias = aa%4 ? 28 : 29;
        if( dd>dias ) return false;
      }
      else
        if( dd>31) return false;
      return true;
    }
    else
      return false;
  }
  else
    return true;
}

function foNumero( texto )
{
  return ( fTrim(texto) && fNumero(texto) );
}

function foFecha( texto )
{
  return ( fTrim(texto) && fFecha(texto) );
}

function foLetraNumero( texto )
{
  return ( fTrim(texto) && fLetraNumero(texto) );
}

function foTramiteSivetur( texto )
{
	if( fTrim(texto) )
	{
	  var mascara = new RegExp("^[0-9]{4,7}[vV]{0,1}[0-9]{1,6}$","g");
	  return mascara.test( texto );
	}
	return false;
}

function fcFechas( fecini, fecfin )
{
  var fini = fecini.substring( 6, 10) + fecini.substring( 3, 5) + fecini.substring( 0, 2);
  var ffin = fecfin.substring( 6, 10) + fecfin.substring( 3, 5) + fecfin.substring( 0, 2);
  if( fini > ffin )
    return true;
  else
    return false;
}

function fcCierre( fecini, fecfin )
{
  var fini = fecini.substring( 6, 10) + fecini.substring( 3, 5) + fecini.substring( 0, 2);
  var ffin = fecfin.substring( 6, 10) + fecfin.substring( 3, 5) + fecfin.substring( 0, 2);
  if( fini >= ffin )
    return true;
  else
    return false;
}
  function NoAtras(){
    history.go(1)
  }