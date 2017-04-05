package sicodif;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class MenuForm extends ActionForm 
{
  private String opcion="0";
  
  public void reset(ActionMapping mapping, HttpServletRequest request)
  {
    super.reset(mapping, request);
  }

  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
  {
    return super.validate(mapping, request);
  }

  public String getOpcion ()
  {
    return opcion;
  }

  public void setOpcion (String newOpcion)
  {
    opcion = newOpcion;
  }
  
  
}