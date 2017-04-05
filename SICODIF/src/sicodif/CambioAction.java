package sicodif;


import cliente.ClaseEnvio;
import cliente.ServiciosUsuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;


public class CambioAction extends Action
{
	public ActionForward execute( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response )
		throws IOException, ServletException
	{
		CambioForm bCambio = ( CambioForm ) form;

		ActionMessages msg = new ActionMessages();
                ServiciosUsuario serviciosUsuario=new ServiciosUsuario();
                ClaseEnvio claseEnvio=serviciosUsuario.getServiciosUsuario();                            		
		try
		{
			if( bCambio.getOpcion() == 1 )
			{
                            Integer Clave=claseEnvio.cambiaClave(bCambio.getUsuario(), bCambio.getClave(), bCambio.getNuevo());                                                        
                            int i = (int) Clave.longValue();
				    if(i == 0)
				     {
				      //  errors.add("error", new ActionMessage("error", "No se pudo cambiar la Contrase\361a, por favor, vuelva a intentar"));
				          bCambio.setMsg("<span style='color:#900; font-size:12px ; font-family:Arial, Helvetica, sans-serif'>No se pudo cambiar la Contrase\361a, por favor, vuelva a intentar</span>");
				     }
				    else
				     {    //errors.add("bien", new ActionMessage("bien", "Se cambio correctamente la Contrase\361a"));
				          bCambio.setMsg("<span style='color:#069; font-size:12px ; font-family:Arial, Helvetica, sans-serif'>Se cambio correctamente la Contrase\361a</span>");
				     }
			}
			return mapping.findForward( "usuario" );
		}
		catch( Exception e )
		{			
		    bCambio.setMsg("<span style='color:#900; font-size:12px ; font-family:Arial, Helvetica, sans-serif'>Existe un problema con Web-Usuario <br> "+e.getMessage()+"</span>");
		    request.setAttribute("CambioForm",bCambio );
			return mapping.findForward( "cambio" );
		}
		finally
		{
			if( !msg.isEmpty() )
				this.saveErrors( request, msg );
		}
	}
}