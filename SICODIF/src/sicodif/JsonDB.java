package sicodif;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;

import javax.sql.PooledConnection;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;


public class JsonDB
{

    public JsonDB()
        throws Exception
    {
    }

 public String getimportadores(String  val)
    {
 PooledConnection pc = null;
  Connection cn = null;
  Statement st = null;
  ResultSet rs = null;
StringBuffer json = new StringBuffer();
  //String xml = "<lista style='width:500px'>";

  try
  {
    InitialContext ic = new InitialContext();
    OracleConnectionPoolDataSource pd = (OracleConnectionPoolDataSource) ic.lookup("jdbc/sicodif");

    pc = pd.getPooledConnection();
    cn = pc.getConnection();
    st = cn.createStatement();

    CallableStatement call = null;
    call = cn.prepareCall( "{? = call PKG_SICODIF.c_cargaimp( ? ) }" );
    call.registerOutParameter( 1, OracleTypes.CURSOR );
    call.setString( 2, val );
    call.execute();

    rs = (ResultSet) call.getObject( 1 );

            if(rs.next())
            {
                json.append("[");
                String coma = "";
                do
                {
                    json.append(coma + "{  value: \"" + rs.getString(1) + "\" }");
                   
                    coma = ",";
                } while(rs.next());
                json.append("]");
            }


   
  }
catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(cn != null)
                    cn.close();
                if( pc != null )
                    pc.close(); 
            }
            catch(SQLException sqlexception) { }
        }

  
 
return json.toString();
    }




    public String getufv(String  fecha)
       {
    
    StringBuffer json = new StringBuffer();
           conexion dc = new conexion();
           Connection con = null;
           CallableStatement call = null;
           String rs = "OK";
          
           try {
               con = dc.abrirConexion();
         call = con.prepareCall("{ ? = call pkg_sicodif.devuelve_ufv (?) }");
           call.registerOutParameter(1, OracleTypes.VARCHAR);
         call.setString(2, fecha);
         call.execute();
         rs = (String)call.getObject(1);


              
                   json.append("[");
                   String coma = "";
                  
                       json.append(coma + "{  value: \"" + rs + "\" }");
                      
                       
                  
                   json.append("]");
               

      
         } catch (Exception er) {
             //rs = "ERROR"+er.toString();
         } finally {
             try {
                 if (con != null)
                     con.close();
                 call.close();
                
             } catch (SQLException er) {
                 ;
             }
         }
         
    
    return json.toString();
       }



}