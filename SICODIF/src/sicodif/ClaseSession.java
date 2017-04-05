package sicodif;

public class ClaseSession
{
  //datos del tramite
  private String aduana = ""; 
  private String numero = ""; 
  private String gestion = ""; 
  private String estado = "";  
  private String accion="0";

  public ClaseSession () {}

  public String getAduana ()
  {
    return aduana;
  }

  public void setAduana (String newAduana)
  {
    aduana = newAduana;
  }
  
  public String getNumero ()
  {
    return numero;
  }

  public void setNumero (String newNumero)
  {
    numero = newNumero;
  }  

  public String getGestion ()
  {
    return gestion;
  }

  public void setGestion (String newGestion)
  {
    gestion = newGestion;
  }    

  public String getEstado ()
  {
    return estado;
  }

  public void setEstado (String newEstado)
  {
    estado = newEstado;
  }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
}
