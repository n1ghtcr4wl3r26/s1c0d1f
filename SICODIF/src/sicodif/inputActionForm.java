package sicodif;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/*import org.apache.struts.action.ActionError;*/

public class inputActionForm extends ActionForm 
{
  private String usuario;
  private String clave;
  private String fmensaje;
  private ArrayList opciones=new ArrayList();
  private String dgerencia;

  /**
   * Reset all properties to their default values.
   * @param mapping The ActionMapping used to select this instance.
   * @param request The HTTP Request we are processing.
   */
  public void reset(ActionMapping mapping, HttpServletRequest request)
  {
    super.reset(mapping, request);
  }

  /**
   * Validate all properties to their default values.
   * @param mapping The ActionMapping used to select this instance.
   * @param request The HTTP Request we are processing.
   * @return ActionErrors A list of all errors found.
   */
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
  {
    return super.validate(mapping, request);
  }

  public String getUsuario()
  {
    return usuario;
  }

  public void setUsuario(String newUsuario)
  {
    usuario = newUsuario;
  }

  public String getClave()
  {
    return clave;
  }

  public void setClave(String newClave)
  {
    clave = newClave;
  }

    public ArrayList getOpciones() {
        return opciones;
    }

    public void setOpciones(ArrayList opciones) {
        this.opciones = opciones;
    }
    
    public String getFmensaje()
    {
      return fmensaje;
    }

    public void setFmensaje(String newFmensaje)
    {
      fmensaje = newFmensaje;
    }


    public void setDgerencia(String dgerencia) {
        this.dgerencia = dgerencia;
    }

    public String getDgerencia() {
        return dgerencia;
    }
}
