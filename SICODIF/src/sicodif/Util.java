package sicodif;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import oracle.jdbc.OracleTypes;


public class Util {

    public Util() {

    }

    public static String DevuelveGerenciaCon(String gestion, String aduana, String numero) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        ResultSet rss = null;
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_enmienda.devuelve_gercon (?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, gestion);
            call.setString(3, aduana);
            call.setString(4, numero);
            call.execute();
            rs = (String)call.getObject(1);
        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
                if (rss != null)
                    rss.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

    public static String DevuelveFechaVenc(String gerencia, String dias) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        ResultSet rss = null;
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.restardiashabiles (?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, gerencia);
            call.setString(3, dias);
            call.execute();
            rs = (String)call.getObject(1);
        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
                if (rss != null)
                    rss.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

    public static String DevuelveAutCon(String gestion, String aduana, String numero) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        ResultSet rss = null;
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_enmienda.devuelve_autcon (?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, gestion);
            call.setString(3, aduana);
            call.setString(4, numero);
            call.execute();
            rs = (String)call.getObject(1);
        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
                if (rss != null)
                    rss.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

    public static String DevuelveJustAutCon(String gestion, String aduana, String numero) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        ResultSet rss = null;
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_enmienda.devuelve_justautcon (?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, gestion);
            call.setString(3, aduana);
            call.setString(4, numero);
            call.execute();
            rs = (String)call.getObject(1);
        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
                if (rss != null)
                    rss.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

    public static String creamensaje(String tipo, String Mensaje, String tiempo) {

        String res = "";
        if (tipo.equals("1")) {
            res =
"<div id='msgalert'>" + Mensaje + "</div><script type='text/javascript'>$(document).ready(function(){$('#msgalert').fadeIn(1000);setTimeout('hide()',450000);});function hide(){$('#msgalert').fadeOut(3000);}</script>";
        }
        if (tipo.equals("2")) {
            res =
"<div id='msgerror'>" + Mensaje + "</div><script type='text/javascript'>$(document).ready(function(){$('#msgerror').fadeIn(1000);setTimeout('hide()',450000);});function hide(){$('#msgerror').fadeOut(3000);}</script>";
        }
        if (tipo.equals("3")) {
            res =
"<div id='msginfo'>" + Mensaje + "</div><script type='text/javascript'>$(document).ready(function(){$('#msginfo').fadeIn(1000);setTimeout('hide()',450000);});function hide(){$('#msginfo').fadeOut(3000);}</script>";
        }
        return res;
    }

    public static String DevuelveEnmFis(FisFiscalizadorEnmForm bean) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        ResultSet rss = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.devuelve_control (?,?,?, ?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());
            call.registerOutParameter(5, -10);
            call.execute();
            rs = (String)call.getObject(1);

            if (rs.equals("CORRECTO")) {
                rss = (ResultSet)call.getObject(5);
                if (rss != null && rss.next()) {

                    bean.setEtapa(rss.getString(42));

                    bean.setFiscalizador(rss.getString(47));
                    bean.setCdgerencia(rss.getString(2));
                }
            } else {
                bean.setMensaje("ERROREL CONTROL DIFERIDO NO EXISTE");
            }
        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

    public static String DevuelveEnmNot(FisNotificaForm bean) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        ResultSet rss = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.devuelve_control (?,?,?, ?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());
            call.registerOutParameter(5, -10);
            call.execute();
            rs = (String)call.getObject(1);

            if (rs.equals("CORRECTO")) {
                rss = (ResultSet)call.getObject(5);
                if (rss != null && rss.next()) {

                    bean.setEtapa(rss.getString(42));

                    bean.setFecha_notificacion(rss.getString(16));
                    bean.setObservacion(rss.getString(17));
                    bean.setTipo(rss.getString(18));
                    bean.setCdgerencia(rss.getString(2));
                }
            } else {
                bean.setMensaje("ERROREL CONTROL DIFERIDO NO EXISTE");
            }
        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

    public static String DevuelveEnmRes(FisResultadosForm bean) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        ResultSet rss = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.devuelve_control (?,?,?, ?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());
            call.registerOutParameter(5, -10);
            call.execute();
            rs = (String)call.getObject(1);

            if (rs.equals("CORRECTO")) {
                rss = (ResultSet)call.getObject(5);
                if (rss != null && rss.next()) {

                    bean.setEtapa(rss.getString(42));

                    bean.setFec_liq(rss.getString(20));

                    bean.setTributo_ga(rss.getString(21));
                    bean.setTributo_iva(rss.getString(22));
                    bean.setTributo_ice(rss.getString(23));
                    bean.setTributo_iehd(rss.getString(24));
                    bean.setSancion(rss.getString(25));
                    bean.setMultaca(rss.getString(26));
                    bean.setMultacc(rss.getString(27));
                    bean.setMultacd(rss.getString(28));

                    bean.setTributo_ufv_ga(rss.getString(56));
                    bean.setTributo_ufv_iva(rss.getString(57));
                    bean.setTributo_ufv_ice(rss.getString(58));
                    bean.setTributo_ufv_iehd(rss.getString(59));
                    bean.setSancion_ufv(rss.getString(60));
                    bean.setMultaca_ufv(rss.getString(61));
                    bean.setMultacc_ufv(rss.getString(62));
                    bean.setMultacd_ufv(rss.getString(63));

                    bean.setValor_ufv(rss.getString(64));
                    bean.setCdgerencia(rss.getString(2));

                }
            } else {
                bean.setMensaje("ERROREL CONTROL DIFERIDO NO EXISTE");
            }
        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

    public static String DevuelveEnmFin(FisFinalizaForm bean) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        ResultSet rss = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.devuelve_control (?,?,?, ?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());
            call.registerOutParameter(5, -10);
            call.execute();
            rs = (String)call.getObject(1);

            if (rs.equals("CORRECTO")) {
                rss = (ResultSet)call.getObject(5);
                if (rss != null && rss.next()) {

                    bean.setEtapa(rss.getString(42));

                    bean.setTip_doc_con(rss.getString(31));
                    bean.setNro_inf(rss.getString(32));
                    bean.setFec_inf(rss.getString(33));
                    bean.setNro_doc_con(rss.getString(34));
                    bean.setFec_doc_con(rss.getString(35));
                    bean.setOvalor(rss.getString(48));
                    bean.setOpartida(rss.getString(49));
                    bean.setOorigen(rss.getString(50));
                    bean.setOsinobs(rss.getString(51));
                    bean.setComision(rss.getString(52));
                    bean.setCcondel(rss.getString(53));
                    bean.setCconcon(rss.getString(54));
                    bean.setCconadu(rss.getString(55));
                    bean.setCdgerencia(rss.getString(2));
                }
            } else {
                bean.setMensaje("ERROREL CONTROL DIFERIDO NO EXISTE");
            }
        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

    public static String DevuelveEnmRec(FisReciboForm bean) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        ResultSet rss = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.devuelve_control (?,?,?, ?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());
            call.registerOutParameter(5, -10);
            call.execute();
            rs = (String)call.getObject(1);

            if (rs.equals("CORRECTO")) {
                rss = (ResultSet)call.getObject(5);
                if (rss != null && rss.next()) {

                    bean.setEtapa(rss.getString(42));

                    bean.setFecha_aceptacion(rss.getString(30));

                    bean.setCdgerencia(rss.getString(2));
                }
            } else {
                bean.setMensaje("ERROREL CONTROL DIFERIDO NO EXISTE");
            }
        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }


    public static String DevuelveEnmDocCon(FisDocConclusionForm bean) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        ResultSet rss = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.devuelve_control (?,?,?, ?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());
            call.registerOutParameter(5, -10);
            call.execute();
            rs = (String)call.getObject(1);

            if (rs.equals("CORRECTO")) {
                rss = (ResultSet)call.getObject(5);
                if (rss != null && rss.next()) {

                    bean.setEtapa(rss.getString(42));

                    bean.setFec_not_doc(rss.getString(37));
                    bean.setTip_not_doc(rss.getString(38));

                    bean.setCdgerencia(rss.getString(2));


                }
            } else {
                bean.setMensaje("ERROREL CONTROL DIFERIDO NO EXISTE");
            }
        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

    public static String DevuelveEnmEnvLeg(FisEnvioLegalForm bean) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        ResultSet rss = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.devuelve_control (?,?,?, ?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());
            call.registerOutParameter(5, -10);
            call.execute();
            rs = (String)call.getObject(1);

            if (rs.equals("CORRECTO")) {
                rss = (ResultSet)call.getObject(5);
                if (rss != null && rss.next()) {

                    bean.setEtapa(rss.getString(42));

                    bean.setFec_env_legal(rss.getString(39));
                    bean.setNro_env_legal(rss.getString(40));
                    bean.setCdgerencia(rss.getString(2));
                }
            } else {
                bean.setMensaje("ERROREL CONTROL DIFERIDO NO EXISTE");
            }
        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }


    public static String GrabaControlDiferido(FisRegistroForm bean, String usuario) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        try {


            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.registra_control (?,?, ?,?, ?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());
            call.setString(5, usuario);
            call.setString(6, bean.getFiscalizador());
            call.setString(7, bean.getGerencia());
            call.registerOutParameter(8, OracleTypes.VARCHAR);

            call.execute();
            rs = (String)call.getObject(1);
            bean.setNrofis((String)call.getObject(8));

        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }


    public static String RechazaControlDiferido(FisDecAsigForm bean, String usuario) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.rechaza_control (?,?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());
            call.setString(5, usuario);

            call.execute();
            rs = (String)call.getObject(1);
            bean.setNrofis(bean.getKey_year() + "/" + bean.getKey_cuo() + "/C-" + bean.getReg_serial());

        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }


    public static String AsignaControlDiferido(FisDecAsigForm bean, String usuario) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.asigna_control (?,?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());
            call.setString(5, usuario);

            call.execute();
            rs = (String)call.getObject(1);
            bean.setNrofis(bean.getKey_year() + "/" + bean.getKey_cuo() + "/C-" + bean.getReg_serial());

        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }


    public static String NotificaControlDiferido(FisNotificaForm bean, String usuario) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.notifica_control (?,?,?,?,?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());
            call.setString(5, bean.getFecha_notificacion());
            call.setString(6, bean.getObservacion());
            call.setString(7, bean.getTipo());
            call.setString(8, usuario);

            call.execute();
            rs = (String)call.getObject(1);
            bean.setNrofis(bean.getKey_year() + "/" + bean.getKey_cuo() + "/C-" + bean.getReg_serial());

        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

    public static String FiscalizadorEnm(FisFiscalizadorEnmForm bean, String usuario) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.fiscalizador_enm (?,?,?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());
            call.setString(5, bean.getFiscalizador());
            call.setString(6, usuario);

            call.execute();
            rs = (String)call.getObject(1);
            bean.setNrofis(bean.getKey_year() + "/" + bean.getKey_cuo() + "/C-" + bean.getReg_serial());

        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }


    public static String NotificaControlDiferidoEnm(FisNotificaForm bean, String usuario) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.notifica_control_enm (?,?,?,?,?,?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());
            call.setString(5, bean.getFecha_notificacion());
            call.setString(6, bean.getObservacion());
            call.setString(7, bean.getTipo());
            call.setString(8, usuario);
            call.setString(9, bean.getObservacionenm());
            call.execute();
            rs = (String)call.getObject(1);
            bean.setNrofis(bean.getKey_year() + "/" + bean.getKey_cuo() + "/C-" + bean.getReg_serial());

        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }


    public static String ResultadosControlDiferido(FisResultadosForm bean, String usuario) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.resultados_control (?,?,?,?,?, ?,?,?,?,?, ?,? ,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());
            call.setString(5, bean.getFec_liq());
            call.setString(6, bean.getTributo_ga());
            call.setString(7, bean.getTributo_iva());
            call.setString(8, bean.getTributo_ice());
            call.setString(9, bean.getTributo_iehd());
            call.setString(10, bean.getMultaca_ufv());
            call.setString(11, bean.getMultacc());
            call.setString(12, bean.getMultacd());
            call.setString(13, usuario);
            //call.setString(14, bean.getFobfinal());
            call.setDouble(14, Double.parseDouble(bean.getFobfinal()));
            call.setString(15, bean.getSancion());
            call.execute();
            rs = (String)call.getObject(1);
            bean.setNrofis(bean.getKey_year() + "/" + bean.getKey_cuo() + "/C-" + bean.getReg_serial());

        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

    public static String ResultadosControlDiferidoEnm(FisResultadosForm bean, String usuario) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call =
con.prepareCall("{ ? = call pkg_sicodif.resultados_control_enm (?,?,?,?,?, ?,?,?,?,?, ?,? ,?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());
            call.setString(5, bean.getFec_liq());
            call.setString(6, bean.getTributo_ga());
            call.setString(7, bean.getTributo_iva());
            call.setString(8, bean.getTributo_ice());
            call.setString(9, bean.getTributo_iehd());
            call.setString(10, bean.getMultaca_ufv());
            call.setString(11, bean.getMultacc());
            call.setString(12, bean.getMultacd());
            call.setString(13, usuario);
            call.setDouble(14, Double.parseDouble(bean.getFobfinal()));
            call.setString(15, bean.getObservacionenm());
            call.setString(16, bean.getSancion());
            // call.setString(14, bean.getFobfinal());

            call.execute();
            rs = (String)call.getObject(1);
            bean.setNrofis(bean.getKey_year() + "/" + bean.getKey_cuo() + "/C-" + bean.getReg_serial());

        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

    public static String FinalizaControlDiferido(FisFinalizaForm bean, String usuario) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call =
con.prepareCall("{ ? = call pkg_sicodif.finaliza_control (?,?,?, ?,?,?,?,?, ?,?,?  ,?,?,?,?, ?,?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());

            call.setString(5, bean.getTip_doc_con());
            call.setString(6, bean.getNro_inf());
            call.setString(7, bean.getFec_inf());
            call.setString(8, bean.getNro_doc_con());
            call.setString(9, bean.getFec_doc_con());

            call.setString(10, bean.getObservacion());
            call.setString(11, bean.getContravencion());

            call.setString(12, usuario);
            call.setString(13, bean.getOvalor());
            call.setString(14, bean.getOpartida());
            call.setString(15, bean.getOorigen());
            call.setString(16, bean.getOsinobs());
            call.setString(17, bean.getComision());
            call.setString(18, bean.getCcondel());
            call.setString(19, bean.getCconcon());
            call.setString(20, bean.getCconadu());


            call.execute();
            rs = (String)call.getObject(1);
            bean.setNrofis(bean.getKey_year() + "/" + bean.getKey_cuo() + "/C-" + bean.getReg_serial());

        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }


    public static String FinalizaControlDiferidoEnm(FisFinalizaForm bean, String usuario) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call =
con.prepareCall("{ ? = call pkg_sicodif.finaliza_control_enm (?,?,?, ?,?,?,?,?, ?,?,?  ,?,?,?,?, ?,?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());

            call.setString(5, bean.getTip_doc_con());
            call.setString(6, bean.getNro_inf());
            call.setString(7, bean.getFec_inf());
            call.setString(8, bean.getNro_doc_con());
            call.setString(9, bean.getFec_doc_con());

            call.setString(10, bean.getObservacionenm());
            call.setString(11, bean.getContravencion());

            call.setString(12, usuario);
            call.setString(13, bean.getOvalor());
            call.setString(14, bean.getOpartida());
            call.setString(15, bean.getOorigen());
            call.setString(16, bean.getOsinobs());
            call.setString(17, bean.getComision());
            call.setString(18, bean.getCcondel());
            call.setString(19, bean.getCconcon());
            call.setString(20, bean.getCconadu());


            call.execute();
            rs = (String)call.getObject(1);
            bean.setNrofis(bean.getKey_year() + "/" + bean.getKey_cuo() + "/C-" + bean.getReg_serial());

        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

    public static String RegistraJustificativoAutCon(FisFinalizaForm bean, String usuario) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.registra_justificativoautcon (?,?,?, ?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());

            call.setString(5, bean.getJustificativo());
            call.setString(6, usuario);
            call.execute();
            rs = (String)call.getObject(1);
            bean.setNrofis(bean.getKey_year() + "/" + bean.getKey_cuo() + "/C-" + bean.getReg_serial());

        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }


    public static String RegistroRecibo(FisReciboForm bean, String usuario) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.registra_recibo (?,?,?, ?,?,?,? ,?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCd_gestion());
            call.setString(3, bean.getCd_gerencia());
            call.setString(4, bean.getCd_numero());

            call.setString(5, bean.getTipo_deuda());
            call.setString(6, bean.getMonto());
            call.setString(7, bean.getFecha_pago());
            call.setString(8, usuario);
            call.setString(9, bean.getRec_gestion());
            call.setString(10, bean.getRec_aduana());
            call.setString(11, bean.getRec_numero());


            call.execute();
            rs = (String)call.getObject(1);
            bean.setNrofis(bean.getKey_year() + "/" + bean.getKey_cuo() + "/C-" + bean.getReg_serial());

        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }


    public static String EliminaRecibo(FisReciboForm bean, String usuario) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.elimina_recibo (?,?,?, ?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCd_gestion());
            call.setString(3, bean.getCd_gerencia());
            call.setString(4, bean.getCd_numero());

            call.setString(5, bean.getId());
            call.setString(6, usuario);

            call.execute();
            rs = (String)call.getObject(1);
            bean.setNrofis(bean.getKey_year() + "/" + bean.getKey_cuo() + "/C-" + bean.getReg_serial());

        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }


    public static String EliminaFechaAceptacion(FisReciboForm bean, String usuario) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.elimina_aceptacion (?,?,?, ?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());
            call.setString(5, usuario);

            call.execute();
            rs = (String)call.getObject(1);
            bean.setNrofis(bean.getKey_year() + "/" + bean.getKey_cuo() + "/C-" + bean.getReg_serial());

        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }


    public static String RegistroAceptacion(FisReciboForm bean, String usuario) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.registra_aceptacion (?,?,?, ?,  ?,?,?, ?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());
            call.setString(5, bean.getFecha_aceptacion());

            call.setString(6, bean.getRec_gestion());
            call.setString(7, bean.getRec_aduana());
            call.setString(8, bean.getRec_numero());


            call.setString(9, usuario);

            call.execute();
            rs = (String)call.getObject(1);
            bean.setNrofis(bean.getKey_year() + "/" + bean.getKey_cuo() + "/C-" + bean.getReg_serial());

        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

    public static String RegistroNotificacionCon(FisDocConclusionForm bean, String usuario) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.registra_not_con (?,?,?, ?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());

            call.setString(5, bean.getFec_not_doc());
            call.setString(6, bean.getTip_not_doc());
            call.setString(7, usuario);

            call.execute();
            rs = (String)call.getObject(1);
            bean.setNrofis(bean.getKey_year() + "/" + bean.getKey_cuo() + "/C-" + bean.getReg_serial());

        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }


    public static String RegistroNotificacionConEnm(FisDocConclusionForm bean, String usuario) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.registra_not_con_enm (?,?,?, ?,?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());

            call.setString(5, bean.getFec_not_doc());
            call.setString(6, bean.getTip_not_doc());
            call.setString(7, usuario);
            call.setString(8, bean.getObservacionenm());
            call.execute();
            rs = (String)call.getObject(1);
            bean.setNrofis(bean.getKey_year() + "/" + bean.getKey_cuo() + "/C-" + bean.getReg_serial());

        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }


    public static String RegistroEnvioLegal(FisEnvioLegalForm bean, String usuario) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.registra_envio_legal (?,?,?, ?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());

            call.setString(5, bean.getFec_env_legal());
            call.setString(6, bean.getNro_env_legal());

            call.setString(7, usuario);

            call.execute();
            rs = (String)call.getObject(1);
            bean.setNrofis(bean.getKey_year() + "/" + bean.getKey_cuo() + "/C-" + bean.getReg_serial());

        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

    public static String RegistroEnvioLegalEnm(FisEnvioLegalForm bean, String usuario) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.registra_envio_legal_enm (?,?,?, ?,?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());

            call.setString(5, bean.getFec_env_legal());
            call.setString(6, bean.getNro_env_legal());

            call.setString(7, usuario);
            call.setString(8, bean.getObservacionenm());
            call.execute();
            rs = (String)call.getObject(1);
            bean.setNrofis(bean.getKey_year() + "/" + bean.getKey_cuo() + "/C-" + bean.getReg_serial());

        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

    public static String TablaReporte1(String gerencia, String fec_ini, String fec_fin) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        String tb = "";
        ResultSet rss = null;
        String vgerencia = "";

        try {

            if (gerencia.equals("%")) {
                vgerencia = "Todas las gerencias";
            } else if (gerencia.equals("GRLP")) {
                vgerencia = "GERENCIA REGIONAL LA PAZ";
            } else if (gerencia.equals("GRCB")) {
                vgerencia = "GERENCIA REGIONAL COCHABAMBA";
            } else if (gerencia.equals("GRSC")) {
                vgerencia = "GERENCIA REGIONAL SANTA CRUZ";
            } else if (gerencia.equals("GROR")) {
                vgerencia = "GERENCIA REGIONAL ORURO";
            } else if (gerencia.equals("GRTJ")) {
                vgerencia = "GERENCIA REGIONAL TARIJA";
            } else if (gerencia.equals("GRPT")) {
                vgerencia = "GERENCIA REGIONAL POTOSI";
            }

            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.reporte1 (?,?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, gerencia);
            call.setString(3, fec_ini);
            call.setString(4, fec_fin);
            call.registerOutParameter(5, -10);
            call.execute();
            rs = (String)call.getObject(1);
            tb = "";

            if (rs.equals("CORRECTO")) {


                rss = (ResultSet)call.getObject(5);

                tb = "<table>";
                tb = tb + "<table id='backgroun4'>";
                tb = tb + "<tr><th >REPORTE AVANCE CONTROL DIFERIDOS</th></tr>";
                tb =
 tb + " <tr><td ><div align='left'><table> <tr><td align='left'><strong>Gerencia:</strong> </td><td align='left'>" +
    vgerencia + "</td></tr><tr><td align='left'><strong>Fecha registro desde:</strong></td><td>" + fec_ini +
    "</td></tr><tr><td align='left'><strong>Fecha registro hasta:</strong></td><td>" + fec_fin +
    "</td></tr></table></div></td></tr>";
                tb = tb + "</table>";

                tb = tb + "<table id='backgroun3'>";
                //tb=tb+"<tr><th colspan='8'>REPORTE AVANCE CONTROL DIFERIDOS</th></tr>";
                tb =
 tb + "<tr><th>GERENCIA REGIONAL</th><th>CONTROLES DIFERIDOS INSTRUIDOS</th><th>CONTROLES DIFERIDOS NOTIFICADOS</th><th>CONTROLES DIFERIDOS NO NOTIFICADOS</th><th>CONTROLES DIFERIDOS CONCLUIDOS</th><th>CONTROLES DIFERIDOS CONCLUIDOS CON OBSERVACION</th><th>CONTROLES DIFERIDOS CONCLUIDOS CON MERCANCIA</th><th>CONTROLES DIFERIDOS CONCLUIDOS SIN MERCANCIA</th></tr>";
                while (rss != null && rss.next()) {
                    if (rss.getString(1).equals("TOTAL"))
                        tb =
 tb + "<tr><th>" + rss.getString(1) + "</th><th>" + rss.getString(2) + "</th><th>" + rss.getString(4) + "</th><th>" +
    rss.getString(3) + "</th><th>" + rss.getString(5) + "</th><th>" + rss.getString(8) + "</th><th>" +
    rss.getString(6) + "</th><th>" + rss.getString(7) + "</th></tr>";
                    else
                        tb =
 tb + "<tr><td>" + rss.getString(1) + "</td><td>" + rss.getString(2) + "</td><td>" + rss.getString(4) + "</td><td>" +
    rss.getString(3) + "</td><td>" + rss.getString(5) + "</td><td>" + rss.getString(8) + "</td><td>" +
    rss.getString(6) + "</td><td>" + rss.getString(7) + "</td></tr>";
                }


                tb = tb + "</table></table>";


            } else {
                tb = "NO EXISTE INFORMACION PARA EL REPORTE";

            }


        } catch (Exception er) {
            tb = "ERROR: " + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
                if (rss != null)
                    rss.close();
            } catch (SQLException er) {
                ;
            }
        }
        return tb;
    }


    public static String TablaReporte4(String gerencia, String fec_ini, String fec_fin) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        String tb = "";
        ResultSet rss = null;

        String vgerencia = "";

        try {
            if (gerencia.equals("%")) {
                vgerencia = "Todas las gerencias";
            } else if (gerencia.equals("GRLP")) {
                vgerencia = "GERENCIA REGIONAL LA PAZ";
            } else if (gerencia.equals("GRCB")) {
                vgerencia = "GERENCIA REGIONAL COCHABAMBA";
            } else if (gerencia.equals("GRSC")) {
                vgerencia = "GERENCIA REGIONAL SANTA CRUZ";
            } else if (gerencia.equals("GROR")) {
                vgerencia = "GERENCIA REGIONAL ORURO";
            } else if (gerencia.equals("GRTJ")) {
                vgerencia = "GERENCIA REGIONAL TARIJA";
            } else if (gerencia.equals("GRPT")) {
                vgerencia = "GERENCIA REGIONAL POTOSI";
            }

            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.reporte4 (?,?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, gerencia);
            call.setString(3, fec_ini);
            call.setString(4, fec_fin);
            call.registerOutParameter(5, -10);
            call.execute();
            rs = (String)call.getObject(1);
            tb = "";

            if (rs.equals("CORRECTO")) {


                rss = (ResultSet)call.getObject(5);

                tb = "<table>";
                tb = tb + "<table id='backgroun4'>";
                tb = tb + "<tr><th >REPORTE DE CONTROL DE FUNCIONARIOS NACIONAL</th></tr>";
                tb =
 tb + " <tr><td ><div align='left'><table> <tr><td align='left'><strong>Gerencia:</strong> </td><td align='left'>" +
    vgerencia + "</td></tr><tr><td align='left'><strong>Fecha registro desde:</strong></td><td>" + fec_ini +
    "</td></tr><tr><td align='left'><strong>Fecha registro hasta:</strong></td><td>" + fec_fin +
    "</td></tr></table></div></td></tr>";
                tb = tb + "</table>";


                tb = tb + "<table id='backgroun3'>";
                //tb=tb+"<tr><th colspan='10'>REPORTE DE CONTROL DE FUNCIONARIOS NACIONAL</th></tr>";
                tb =
 tb + "<tr><th>GERENCIA REGIONAL</th><th>FISCALIZADOR</th><th>CONTROLES DIFERIDOS INSTRUIDOS</th><th>CONTROLES DIFERIDOS NOTIFICADOS</th><th>CONTROLES DIFERIDOS NO NOTIFICADOS</th><th>CONTROLES DIFERIDOS CONCLUIDOS</th><th>CONTROLES DIFERIDOS CONCLUIDOS CON OBSERVACION</th><th>CONTROLES DIFERIDOS CONCLUIDOS CON MERCANCIA</th><th>CONTROLES DIFERIDOS CONCLUIDOS SIN MERCANCIA</th><th>CONTROLES DIFERIDOS FUERA DE PLAZO</th></tr>";
                while (rss != null && rss.next()) {
                    if (rss.getString(1).equals("TOTAL"))
                        tb =
 tb + "<tr><th>" + rss.getString(9) + "</th><th>" + rss.getString(1) + "</th><th>" + rss.getString(2) + "</th><th>" +
    rss.getString(4) + "</th><th>" + rss.getString(3) + "</th><th>" + rss.getString(5) + "</th><th>" +
    rss.getString(8) + "</th><th>" + rss.getString(6) + "</th><th>" + rss.getString(7) + "</th><th>" +
    rss.getString(10) + "</th></tr>";
                    else
                        tb =
 tb + "<tr><td>" + rss.getString(9) + "</td><td>" + rss.getString(1) + "</td><td>" + rss.getString(2) + "</td><td>" +
    rss.getString(4) + "</td><td>" + rss.getString(3) + "</td><td>" + rss.getString(5) + "</td><td>" +
    rss.getString(8) + "</td><td>" + rss.getString(6) + "</td><td>" + rss.getString(7) + "</td><td>" +
    rss.getString(10) + "</td></tr>";
                }

                tb = tb + "</table></table>";

            } else {
                tb = "NO EXISTE INFORMACION PARA EL REPORTE";

            }


        } catch (Exception er) {
            tb = "ERROR: " + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
                if (rss != null)
                    rss.close();
            } catch (SQLException er) {
                ;
            }
        }
        return tb;
    }


    public static String TablaReporte5(String gerencia, String fec_ini, String fec_fin) {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        simbolos.setGroupingSeparator(',');

        DecimalFormat d = new DecimalFormat("#,###,###.##", simbolos);
        d.setMaximumFractionDigits(2);
        d.setMinimumFractionDigits(2);


        DecimalFormat df = new DecimalFormat("#,###,###.##", simbolos);
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);

        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        String tb = "";
        double deuda = 0;
        double total = 0;

        int sumCdifconclui = 0;
        int sumCdifconclconObs = 0;
        String vgerencia = "";

        ResultSet rss = null;
        try {

            if (gerencia.equals("%")) {
                vgerencia = "Todas las gerencias";
            } else if (gerencia.equals("GRLP")) {
                vgerencia = "GERENCIA REGIONAL LA PAZ";
            } else if (gerencia.equals("GRCB")) {
                vgerencia = "GERENCIA REGIONAL COCHABAMBA";
            } else if (gerencia.equals("GRSC")) {
                vgerencia = "GERENCIA REGIONAL SANTA CRUZ";
            } else if (gerencia.equals("GROR")) {
                vgerencia = "GERENCIA REGIONAL ORURO";
            } else if (gerencia.equals("GRTJ")) {
                vgerencia = "GERENCIA REGIONAL TARIJA";
            } else if (gerencia.equals("GRPT")) {
                vgerencia = "GERENCIA REGIONAL POTOSI";
            }

            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.reporte5 (?,?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, gerencia);
            call.setString(3, fec_ini);
            call.setString(4, fec_fin);
            call.registerOutParameter(5, -10);
            call.execute();
            rs = (String)call.getObject(1);

            tb = "";

            if (rs.equals("CORRECTO")) {


                rss = (ResultSet)call.getObject(5);

                tb = "<table>";
                tb = tb + "<table id='backgroun4'>";
                tb = tb + "<tr><th >REPORTE RESULTADOS CONTROL DIFERIDOS</th></tr>";
                tb =
 tb + " <tr><td ><div align='left'><table> <tr><td align='left'><strong>Gerencia:</strong> </td><td align='left'>" +
    vgerencia + "</td></tr><tr><td align='left'><strong>Fecha conclusi&oacute;n desde:</strong></td><td>" + fec_ini +
    "</td></tr><tr><td align='left'><strong>Fecha conclusi&oacute;n hasta:</strong></td><td>" + fec_fin +
    "</td></tr></table></div></td></tr>";
                tb = tb + "</table>";

                tb = tb + "<table id='backgroun3'>";
                tb =
 tb + "<tr><th rowspan='2'>GERENCIA REGIONAL<br/>(A)</th><th rowspan='2'>CONTROLES DIFERIDOS CONCLUIDOS<br/>(B)</th><th rowspan='2'>CONTROLES DIFERIDOS CONCLUIDOS CON OBSERVACION<br/> (C)</th><th colspan='5'>DEUDA DETERMINADA POR FISCALIZACION Bs</th><th colspan='5'>TOTAL PAGADO Bs</th><th rowspan='2'>RENDIMIENTO MEDIO CONTROLES DIFERIDOS Bs<br/>((D+E+F+G)/C)</th></tr>";
                tb =
 tb + "<tr><th >TRIBUTO OMITIDO Bs<br/>(D)</th><th >SANCION POR OMISION DE PAGO (100%) Bs <br/>(E)</th><th >CONTRAV. ADUANERAS Bs<br/>(F)</th><th >CONTRABANDO CONTRAVENCIONAL Bs<br/>(G)</th><th >TOTAL DETERMINADO Bs<br/> (D+E+F+G)</th><th >TRIBUTO OMITIDO Bs<br/> (H)</th><th >SANCION POR OMISION DE PAGO Bs <br/>(I)</th><th >CONTRAV. ADUANERAS<br/> (J)</th><th >CONTRABANDO CONTRAVENCIONAL Bs<br/>(K)</th><th >TOTAL PAGADO Bs<br/> (H+I+J+K)</th></tr>";


                while (rss != null && rss.next()) {
                    if (rss.getString(1).equals("TOTAL")) {
                        tb =
 tb + "<tr><th>" + rss.getString(1) + "</th><th>" + sumCdifconclui + "</th><th>" + sumCdifconclconObs +
    "</th><th style='text-align:right'>" + df.format(Double.valueOf(rss.getString(4)).doubleValue()) +
    "</th><th style='text-align:right'>" + d.format(Double.valueOf(rss.getString(5)).doubleValue()) +
    "</th><th style='text-align:right'>" + d.format(Double.valueOf(rss.getString(6)).doubleValue()) +
    "</th><th style='text-align:right'>" + d.format(Double.valueOf(rss.getString(11)).doubleValue()) +
    "</th><th style='text-align:right'>" + d.format(Double.valueOf(rss.getString(13)).doubleValue()) +
    "</td><th style='text-align:right'>" + d.format(Double.valueOf(rss.getString(7)).doubleValue()) +
    "</th><th style='text-align:right'>" + d.format(Double.valueOf(rss.getString(8)).doubleValue()) +
    "</th><th  style='text-align:right'>" + d.format(Double.valueOf(rss.getString(9)).doubleValue()) +
    "</th><th style='text-align:right'>" + d.format(Double.valueOf(rss.getString(10)).doubleValue()) +
    "</th><th style='text-align:right'>" + d.format(Double.valueOf(rss.getString(14)).doubleValue()) +
    "</th><th style='text-align:right'>" + d.format(Double.valueOf(rss.getString(12)).doubleValue()) + "</th></tr>";
                    } else {
                        sumCdifconclui = sumCdifconclui + Integer.parseInt(rss.getString(2));
                        sumCdifconclconObs = sumCdifconclconObs + Integer.parseInt(rss.getString(3));
                        tb =
 tb + "<tr><td>" + rss.getString(1) + "</td><td>" + rss.getString(2) + "</td><td>" + rss.getString(3) +
    "</td><td style='text-align:right'>" + df.format(Double.valueOf(rss.getString(4)).doubleValue()) +
    "</td><td  style='text-align:right'>" + d.format(Double.valueOf(rss.getString(5)).doubleValue()) +
    "</td><td style='text-align:right'>" + d.format(Double.valueOf(rss.getString(6)).doubleValue()) +
    " </td><td style='text-align:right'>" + d.format(Double.valueOf(rss.getString(11)).doubleValue()) +
    " </td><td style='text-align:right'>" + d.format(Double.valueOf(rss.getString(13)).doubleValue()) +
    "</td><td style='text-align:right'>" + d.format(Double.valueOf(rss.getString(7)).doubleValue()) +
    "</td><td style='text-align:right'>" + d.format(Double.valueOf(rss.getString(8)).doubleValue()) +
    "</td><td style='text-align:right'>" + d.format(Double.valueOf(rss.getString(9)).doubleValue()) +
    "</td><td style='text-align:right'>" + d.format(Double.valueOf(rss.getString(10)).doubleValue()) +
    "</td><td style='text-align:right'>" + d.format(Double.valueOf(rss.getString(14)).doubleValue()) +
    "</td><td style='text-align:right'>" + d.format(Double.valueOf(rss.getString(12)).doubleValue()) + "</td></tr>";
                    }
                }


                tb = tb + "</table></table>";


            } else {
                tb = "NO EXISTE INFORMACION PARA EL REPORTE";

            }


        } catch (Exception er) {
            tb = "ERROR: " + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
                if (rss != null)
                    rss.close();
            } catch (SQLException er) {
                ;
            }
        }
        return tb;
    }


    public static String BandejaSupervisor(String gerencia, String estado) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        String tb = "";
        ResultSet rss = null;
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.bandeja_supervisor (?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, gerencia);
            call.setString(3, estado);
            call.registerOutParameter(4, -10);
            call.execute();
            rs = (String)call.getObject(1);
            tb = "";

            if (rs.equals("CORRECTO")) {


                rss = (ResultSet)call.getObject(4);


                tb = "<table id='backgroun3'>";
                tb = tb + "<caption>LISTADO DE DECLARACIONES OBSERVADAS CON FICHA INFORMATIVA</caption>";
                tb =
 tb + "<th>No.</th><th width='15%'>Declaraci&oacute;n</th><th>Patr&oacute;n</th><th>&Iacute;tems</th><th>Importador  </th><th>NIT Importador</th><th>Fecha Levante</th><th>Codigo CD</th><th>Fiscalizador</th><th>Fecha Registro</th><th>&nbsp;</th></tr>";
                String ia;
                int c = 1;

                while (rss != null && rss.next()) {
                    ia = "javascript:dui(" + rss.getString(1) + "," + rss.getString(2) + "," + rss.getString(3) + ");";
                    tb = tb + "<tr><td>" + c + "</td><td>";
                    tb =
 tb + "<a onclick=window.open('" + rss.getString(14) + "/repduiform.jsp?gestion=" + rss.getString(1) + "&aduana=" +
    rss.getString(2) + "&registro=" + rss.getString(3) +
    "&vdec=&vop=&vusu=&bandera=undefined','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0') href='javascript:void(0)' >";
                    tb = tb + rss.getString(1) + "/" + rss.getString(2) + "/C-" + rss.getString(3) + "</a></td>";
                    tb =
 tb + "<td>" + rss.getString(4) + "</td><td>" + rss.getString(5) + "</td><td>" + rss.getString(7) + "</td><td>" +
    rss.getString(6) + "</td><td>" + rss.getString(8) + "</td><td>" + rss.getString(9) + "</td><td>" +
    rss.getString(10) + "</td><td>" + rss.getString(11) + "</td><td><a href='" + ia +
    "' style='color:#0f69b4; font-weight:900;'>Procesar</a></td></tr>";
                    c = c + 1;
                }


                tb = tb + "</table>";


            } else {
                tb = "NO EXISTEN DECLARACIONES PARA ASIGNAR";

            }


        } catch (Exception er) {
            tb = "ERROR: " + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
                if (rss != null)
                    rss.close();
            } catch (SQLException er) {
                ;
            }
        }
        return tb;
    }

    public static String DevuelveConsulta(String reg_year, String key_cuo, String reg_nber, FisConsultaForm bean) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        ResultSet rss = null;
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.devuelve_consulta (?,?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, reg_year);
            call.setString(3, key_cuo);
            call.setString(4, reg_nber);
            call.registerOutParameter(5, -10);
            call.execute();
            rs = (String)call.getObject(1);


            if (rs.equals("CORRECTO")) {

                rss = (ResultSet)call.getObject(5);

                if (rss != null && rss.next()) {


                    bean.setCodfis(rss.getString(1));
                    bean.setFecval(rss.getString(2));
                    bean.setGerencia(rss.getString(3));

                    bean.setNit(rss.getString(4));
                    bean.setNombre(rss.getString(5));
                    bean.setDireccion(rss.getString(6));
                    bean.setActividad(rss.getString(7));

                    bean.setEsdui(rss.getString(8));
                    bean.setEsdue(rss.getString(9));
                    bean.setEsotro(rss.getString(10));

                    bean.setDeclaracion(rss.getString(11));
                    bean.setFecdeclaracion(rss.getString(12));

                    bean.setFres_nombre(rss.getString(13));
                    bean.setFfis_nombre(rss.getString(14));
                    bean.setFres_ci(rss.getString(15));
                    bean.setFfis_ci(rss.getString(16));


                }

            }


        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
                if (rss != null)
                    rss.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

    public static String BandejaFiscalizador(String fiscalizador, String estado) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        String tb = "";
        ResultSet rss = null;
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.bandeja_fiscalizador (?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, fiscalizador);
            call.setString(3, estado);
            call.registerOutParameter(4, -10);
            call.execute();
            rs = (String)call.getObject(1);
            tb = "";

            if (rs.equals("CORRECTO")) {


                rss = (ResultSet)call.getObject(4);


                tb = "<table id='backgroun3'>";
                tb = tb + "<caption>LISTADO DE DECLARACIONES OBSERVADAS CON FICHA INFORMATIVA</caption>";
                tb =
 tb + "<th>No.</th><th width='15%'>Declaraci&oacute;n</th><th>Patr&oacute;n</th><th>&Iacute;tems</th><th>Importador  </th><th>NIT Importador</th><th>Fecha Levante</th><th>Codigo CD</th><th>Estado</th><th>Fecha Asignaci&oacute;n</th><th>&nbsp;</th></tr>";
                String ia;
                int c = 1;
                while (rss != null && rss.next()) {
                    ia = "javascript:dui(" + rss.getString(1) + "," + rss.getString(2) + "," + rss.getString(3) + ");";

                    tb =
 tb + "<tr><td>1</td><td>" + rss.getString(1) + "/" + rss.getString(2) + "/C-" + rss.getString(3) + "</td><td>" +
    rss.getString(4) + "</td><td>" + rss.getString(5) + "</td><td>" + rss.getString(7) + "</td><td>" +
    rss.getString(6) + "</td><td>" + rss.getString(8) + "</td><td>" + rss.getString(9) + "</td><td>" +
    rss.getString(10) + "</td><td>" + rss.getString(11) + "</td><td><a href='" + ia +
    "' style='color:#0f69b4; font-weight:900;'>Orden de Fiscalizaci&oacute;n</a></td></tr>";
                    c = c + 1;

                }


                tb = tb + "</table>";


            } else {
                tb = "NO EXISTEN DECLARACIONES PARA ASIGNAR";

            }


        } catch (Exception er) {
            tb = "ERROR: " + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
                if (rss != null)
                    rss.close();
            } catch (SQLException er) {
                ;
            }
        }
        return tb;
    }

    public static String TablaReporte2(String gerencia, String fec_ini, String fec_fin) {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        simbolos.setGroupingSeparator(',');

        DecimalFormat d = new DecimalFormat("#,###,###.##", simbolos);
        d.setMaximumFractionDigits(2);
        d.setMinimumFractionDigits(2);


        DecimalFormat df = new DecimalFormat("#,###,###.##", simbolos);
        df.setMaximumFractionDigits(0);
        df.setMinimumFractionDigits(0);
        /*


                simbolos.setDecimalSeparator('.');
                simbolos.setGroupingSeparator(',');

                DecimalFormat d = new DecimalFormat("###.##", simbolos);
                d.setMaximumFractionDigits(2);
                d.setMinimumFractionDigits(2);
                DecimalFormat df = new DecimalFormat("#,###,###.##", simbolos);
                df.setMaximumFractionDigits(0);
                df.setMinimumFractionDigits(0);*/

        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        String tb = "";
        double deuda = 0;
        double total = 0;

        String vgerencia = "";

        ResultSet rss = null;

        try {

            if (gerencia.equals("%")) {
                vgerencia = "Todas las gerencias";
            } else if (gerencia.equals("GRLP")) {
                vgerencia = "GERENCIA REGIONAL LA PAZ";
            } else if (gerencia.equals("GRCB")) {
                vgerencia = "GERENCIA REGIONAL COCHABAMBA";
            } else if (gerencia.equals("GRSC")) {
                vgerencia = "GERENCIA REGIONAL SANTA CRUZ";
            } else if (gerencia.equals("GROR")) {
                vgerencia = "GERENCIA REGIONAL ORURO";
            } else if (gerencia.equals("GRTJ")) {
                vgerencia = "GERENCIA REGIONAL TARIJA";
            } else if (gerencia.equals("GRPT")) {
                vgerencia = "GERENCIA REGIONAL POTOSI";
            }
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.reporte2 (?,?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, gerencia);
            call.setString(3, fec_ini);
            call.setString(4, fec_fin);
            call.registerOutParameter(5, -10);
            call.execute();
            rs = (String)call.getObject(1);

            tb = "";

            if (rs.equals("CORRECTO")) {


                rss = (ResultSet)call.getObject(5);

                tb = "<table>";
                tb = tb + "<table id='backgroun4'>";
                tb = tb + "<tr><th >REPORTE DE RECUPERACION POR CONTROLES DIFERIDOS CONCLUIDOS - PAGADOS</th></tr>";
                tb =
 tb + " <tr><td ><div align='left'><table> <tr><td align='left'><strong>Gerencia:</strong> </td><td align='left'>" +
    vgerencia + "</td></tr><tr><td align='left'><strong>Fecha conclusi&oacute;n desde:</strong></td><td>" + fec_ini +
    "</td></tr><tr><td align='left'><strong>Fecha conclusi&oacute;n hasta:</strong></td><td>" + fec_fin +
    "</td></tr></table></div></td></tr>";
                tb = tb + "</table>";

                tb = tb + "<table id='backgroun3'>";
                //tb=tb+"<tr><th colspan='8'>REPORTE DE RECUPERACION POR CONTROLES DIFERIDOS CONCLUIDOS - PAGADOS</th></tr>";
                tb =
 tb + "<tr><th>&nbsp;</th><th>A</th><th>B</th><th>C</th><th>D=B+C</th><th>E</th><th>F</th><th>G=D+E+F</th></tr>";

                tb =
 tb + "<tr><th>GERENCIA REGIONAL</th><th>TOTAL CD CONCLUIDOS PAGADOS</th><th>TOTAL TRIBUTOS OMITIDO ACTUALIZADO - INTERES EN BS</th><th>TOTAL CONTRAVENCION ADUANERA EN BS</th><th>TOTAL DEUDA TRIBUTARIA</th><th>TOTAL SANCION POR OMISION DE PAGO EN BS</th><th>TOTAL CONTRABANDO EN BS</th><th>TOTAL RECUPERADO EN BS</th></tr>";
                while (rss != null && rss.next()) {
                    if (rss.getString(1).equals("TOTAL"))
                        tb =
 tb + "<tr><th>" + rss.getString(1) + "</th><th>" + df.format(Double.valueOf(rss.getString(2)).doubleValue()) +
    "</th><th style='text-align:right'>" + d.format(Double.valueOf(rss.getString(3)).doubleValue()) +
    "</th><th style='text-align:right'>" + d.format(Double.valueOf(rss.getString(4)).doubleValue()) +
    "</th><th style='text-align:right'>" + d.format(Double.valueOf(rss.getString(5)).doubleValue()) +
    "</th><th style='text-align:right'>" + d.format(Double.valueOf(rss.getString(6)).doubleValue()) +
    "</th><th style='text-align:right'>" + d.format(Double.valueOf(rss.getString(7)).doubleValue()) +
    "</th><th style='text-align:right'>" + d.format(Double.valueOf(rss.getString(8)).doubleValue()) + "</th></tr>";
                    else
                        tb =
 tb + "<tr><td>" + rss.getString(1) + "</td><td>" + df.format(Double.valueOf(rss.getString(2)).doubleValue()) +
    "</td><td style='text-align:right'>" + d.format(Double.valueOf(rss.getString(3)).doubleValue()) +
    "</td><td style='text-align:right'>" + d.format(Double.valueOf(rss.getString(4)).doubleValue()) +
    "</td><td style='text-align:right'>" + d.format(Double.valueOf(rss.getString(5)).doubleValue()) +
    "</td><td style='text-align:right'>" + d.format(Double.valueOf(rss.getString(6)).doubleValue()) +
    "</td><td style='text-align:right'>" + d.format(Double.valueOf(rss.getString(7)).doubleValue()) +
    "</td><td style='text-align:right'>" + d.format(Double.valueOf(rss.getString(8)).doubleValue()) + "</td></tr>";
                }


                tb = tb + "</table></table>";


            } else {
                tb = "NO EXISTE INFORMACION PARA EL REPORTE";

            }


        } catch (Exception er) {
            tb = "ERROR: " + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
                if (rss != null)
                    rss.close();
            } catch (SQLException er) {
                ;
            }
        }
        return tb;
    }

    public static String TablaReporte3(String gerencia, String fec_ini, String fec_fin) {

        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();

        simbolos.setDecimalSeparator(',');
        simbolos.setGroupingSeparator('.');

        DecimalFormat d = new DecimalFormat("#,###,###.##", simbolos);
        d.setMaximumFractionDigits(2);
        d.setMinimumFractionDigits(2);


        DecimalFormat df = new DecimalFormat("#,###,###.##", simbolos);
        df.setMaximumFractionDigits(0);
        df.setMinimumFractionDigits(0);

        String vgerencia = "";

        /*
                simbolos.setDecimalSeparator('.');
                simbolos.setGroupingSeparator(',');

                DecimalFormat d = new DecimalFormat("###.##", simbolos);
                d.setMaximumFractionDigits(2);
                d.setMinimumFractionDigits(2);
                DecimalFormat df = new DecimalFormat("#,###,###.##", simbolos);
                df.setMaximumFractionDigits(0);
                df.setMinimumFractionDigits(0);*/

        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        String tb = "";
        ResultSet rss = null;

        try {


            if (gerencia.equals("%")) {
                vgerencia = "Todas las gerencias";
            } else if (gerencia.equals("GRLP")) {
                vgerencia = "GERENCIA REGIONAL LA PAZ";
            } else if (gerencia.equals("GRCB")) {
                vgerencia = "GERENCIA REGIONAL COCHABAMBA";
            } else if (gerencia.equals("GRSC")) {
                vgerencia = "GERENCIA REGIONAL SANTA CRUZ";
            } else if (gerencia.equals("GROR")) {
                vgerencia = "GERENCIA REGIONAL ORURO";
            } else if (gerencia.equals("GRTJ")) {
                vgerencia = "GERENCIA REGIONAL TARIJA";
            } else if (gerencia.equals("GRPT")) {
                vgerencia = "GERENCIA REGIONAL POTOSI";
            }
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.reporte3 (?,?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, gerencia);
            call.setString(3, fec_ini);
            call.setString(4, fec_fin);
            call.registerOutParameter(5, -10);
            call.execute();
            rs = (String)call.getObject(1);
            tb = "";

            if (rs.equals("CORRECTO")) {


                rss = (ResultSet)call.getObject(5);

                tb = "<table>";
                tb = tb + "<table id='backgroun4'>";
                tb = tb + "<tr><th >REPORTE DE CONTROLES DIFERIDOS CONCLUIDOS - NO PAGADOS</th></tr>";
                tb =
 tb + " <tr><td ><div align='left'><table> <tr><td align='left'><strong>Gerencia:</strong> </td><td align='left'>" +
    vgerencia + "</td></tr><tr><td align='left'><strong>Fecha conclusi&oacute;n desde:</strong></td><td>" + fec_ini +
    "</td></tr><tr><td align='left'><strong>Fecha conclusi&oacute;n hasta:</strong></td><td>" + fec_fin +
    "</td></tr></table></div></td></tr>";
                tb = tb + "</table>";


                tb = tb + "<table id='backgroun3'>";
                //tb=tb+"<tr><th colspan='8'>REPORTE DE CONTROLES DIFERIDOS CONCLUIDOS - NO PAGADOS</th></tr>";
                tb =
 tb + "<tr><th>GERENCIA REGIONAL</th><th>TOTAL CD CONCLUIDOS NO PAGADOS</th><th>TOTAL TRIBUTOS OMITIDO</th><th>TOTAL CONTRAVENCION ADUANERA EN UFV's</th><th>TOTAL SANCION POR OMISION DE PAGO EN BS</th><th>TOTAL CONTRABANDO EN BS</th></tr>";
                while (rss != null && rss.next()) {
                    if (rss.getString(1).equals("TOTAL"))
                        tb =
 tb + "<tr><th>" + rss.getString(1) + "</th><th>" + df.format(Double.valueOf(rss.getString(2)).doubleValue()) +
    "</th><th style='text-align:right'>" + d.format(Double.valueOf(rss.getString(3)).doubleValue()) +
    "</th><th style='text-align:right'>" + d.format(Double.valueOf(rss.getString(4)).doubleValue()) +
    "</th><th style='text-align:right'>" + d.format(Double.valueOf(rss.getString(5)).doubleValue()) +
    "</th><th style='text-align:right'>" + d.format(Double.valueOf(rss.getString(6)).doubleValue()) + "</th></tr>";
                    else
                        tb =
 tb + "<tr><td>" + rss.getString(1) + "</td><td>" + df.format(Double.valueOf(rss.getString(2)).doubleValue()) +
    "</td><td style='text-align:right'>" + d.format(Double.valueOf(rss.getString(3)).doubleValue()) +
    "</td><td style='text-align:right'>" + d.format(Double.valueOf(rss.getString(4)).doubleValue()) +
    "</td><td style='text-align:right'>" + d.format(Double.valueOf(rss.getString(5)).doubleValue()) +
    "</td><td style='text-align:right'>" + d.format(Double.valueOf(rss.getString(6)).doubleValue()) + "</td></tr>";
                }


                tb = tb + "</table></table>";


            } else {
                tb = "NO EXISTE INFORMACION PARA EL REPORTE";

            }


        } catch (Exception er) {
            tb = "ERROR: " + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
                if (rss != null)
                    rss.close();
            } catch (SQLException er) {
                ;
            }
        }
        return tb;
    }


    public static FisDeclaracionForm DevuelveDUI(String key_year, String key_cuo, String reg_serial) {
        FisDeclaracionForm dui = new FisDeclaracionForm();
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        ResultSet rss = null;
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.devuelve_dui (?,?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, key_year);
            call.setString(3, key_cuo);
            call.setString(4, reg_serial);
            call.registerOutParameter(5, -10);
            call.execute();
            rs = (String)call.getObject(1);


            if (rs.equals("CORRECTO")) {


                rss = (ResultSet)call.getObject(5);
                if (rss != null && rss.next()) {
                    dui.setKey_year(rss.getString(1));
                    dui.setKey_cuo(rss.getString(2));
                    dui.setReg_serial(rss.getString(3));
                    dui.setAdministracion_aduana(rss.getString(4));
                    dui.setVista(rss.getString(5));
                    dui.setImportador(rss.getString(6));
                    dui.setDespachante(rss.getString(7));
                    dui.setFecha_registro(rss.getString(8));
                    dui.setCanal(rss.getString(9));
                    dui.setFecha_pasedesalida(rss.getString(10));
                    dui.setEstado(rss.getString(11));
                    dui.setMensaje(rss.getString(12));

                    dui.setFecha_registro_control(rss.getString(13));
                    dui.setUsuario_registro(rss.getString(14));
                    dui.setFecha_notificacion(rss.getString(15));
                    dui.setObs_notificacion(rss.getString(16));
                    dui.setUsuario_notificacion(rss.getString(17));
                    dui.setFecha_finalizacion(rss.getString(18));
                    dui.setObs_finalizacion(rss.getString(19));
                    dui.setUsuario_finalizacion(rss.getString(20));
                    dui.setFiscalizador(rss.getString(21));

                    dui.setFec_liquidacion(rss.getString(22));
                    dui.setMonto_total(rss.getString(23));
                    dui.setUsuario_resultados(rss.getString(24));

                    dui.setFec_not_doc(rss.getString(25));
                    dui.setTip_not_doc(rss.getString(26));

                    dui.setFec_env_legal(rss.getString(27));
                    dui.setNro_env_legal(rss.getString(28));

                    dui.setFecha_aceptacion(rss.getString(29));
                    dui.setFecha_doc_con(rss.getString(30));

                    dui.setFec_liq(rss.getString(31));
                    dui.setValor_ufv(rss.getString(32));
                    dui.setTributo_ga(rss.getString(33));
                    dui.setTributo_iva(rss.getString(34));
                    dui.setTributo_ice(rss.getString(35));
                    dui.setTributo_iehd(rss.getString(36));
                    dui.setSancion(rss.getString(37));
                    dui.setMultaca(rss.getString(38));
                    dui.setMultacc(rss.getString(39));
                    dui.setMultacd(rss.getString(40));
                    dui.setTributo_ufv_ga(rss.getString(41));
                    dui.setTributo_ufv_iva(rss.getString(42));
                    dui.setTributo_ufv_ice(rss.getString(43));
                    dui.setTributo_ufv_iehd(rss.getString(44));
                    dui.setSancion_ufv(rss.getString(45));
                    dui.setMultaca_ufv(rss.getString(46));
                    dui.setMultacc_ufv(rss.getString(47));
                    dui.setMultacd_ufv(rss.getString(48));

                    dui.setUsuario_aceptacion(rss.getString(49));
                    dui.setUsuario_not_doc_con(rss.getString(50));
                    dui.setUsuario_env_legal(rss.getString(51));

                    dui.setCd_gestion(rss.getString(52));
                    dui.setCd_gerencia(rss.getString(53));
                    dui.setCd_numero(rss.getString(54));

                    dui.setTip_doc_con(rss.getString(55));
                    dui.setNro_inf(rss.getString(56));
                    dui.setFec_inf(rss.getString(57));
                    dui.setNro_doc_con(rss.getString(58));
                    dui.setFec_doc_con(rss.getString(59));
                    dui.setOvalor(rss.getString(60));
                    dui.setOpartida(rss.getString(61));
                    dui.setOorigen(rss.getString(62));
                    dui.setOsinobs(rss.getString(63));
                    dui.setComision(rss.getString(64));
                    dui.setCcondel(rss.getString(65));
                    dui.setCconcon(rss.getString(66));
                    dui.setCconadu(rss.getString(67));
                    dui.setPagina(rss.getString(68));
                    dui.setOrigen(rss.getString(69));


                    dui.setUsuariolog(rss.getString(70));
                    dui.setFechalog(rss.getString(71));
                    dui.setFobinicial(rss.getString(72));
                    dui.setFobfinal(rss.getString(73));


                }

            } else {
                dui.setMensaje("ERRORLA DECLARACION NO EXISTE");

            }


        } catch (Exception er) {
            dui.setMensaje("ERROR" + er.toString());
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
                if (rss != null)
                    rss.close();
            } catch (SQLException er) {
                ;
            }
        }
        return dui;
    }


    public static String TablaDeclaracion(FisDeclaracionForm bean) {
        String rs = "OK";

        //rs = "<table class='tablasincss'><tr><th>Declaraci&oacute;n:</th><td><a href='javascript:reporte('2012','201','16881');'>" +bean.getKey_year()+"/"+bean.getKey_cuo()+"/C-"+bean.getReg_serial()+" </a></td></tr>";
        rs = "<table class='tablasincss'>";
        if (!(bean.getMensaje().equals("SIN CODIGO"))) {
            if (bean.getCd_numero().equals("0")) {
                rs = rs + "<tr><th>N&uacute;mero Control Diferido:</th><td><strong>PENDIENTE</strong></td></tr>";
            } else {
                rs =
 rs + "<tr><th>N&uacute;mero Control Diferido:</th><td><strong>" + bean.getMensaje() + "</strong></td></tr>";
            }
            rs = rs + "<tr><th>Fiscalizador:</th><td><strong>" + bean.getFiscalizador() + "</strong></td></tr>";

        }

        rs =
 rs + "<tr><th>Declaraci&oacute;n:</th><td><a onclick=window.open('" + bean.getPagina() + "/repduiform.jsp?gestion=" +
    bean.getKey_year() + "&aduana=" + bean.getKey_cuo() + "&registro=" + bean.getReg_serial() +
    "&vdec=&vop=&vusu=&bandera=undefined','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0') href='javascript:void(0)' >" +
    bean.getKey_year() + "/" + bean.getKey_cuo() + "/C-" + bean.getReg_serial() + " </a></td></tr>";

        rs = rs + "<tr><th>Documentos:</th><td><table><tr>";
        rs =
 rs + "<td><a onclick=window.open('" + bean.getPagina() + "/repduiform.jsp?gestion=" + bean.getKey_year() + "&aduana=" +
    bean.getKey_cuo() + "&registro=" + bean.getReg_serial() +
    "&vdec=&vop=&vusu=&bandera=undefined','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0') href='javascript:void(0)' >DUI</a></td>";
        rs =
 rs + "<td><a onclick=window.open('" + bean.getPagina() + "/DUI_docadi.jsp?gestion=" + bean.getKey_year() + "&aduana=" +
    bean.getKey_cuo() + "&registro=" + bean.getReg_serial() +
    "&vdec=&vop=&vusu=&bandera=undefined','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0') href='javascript:void(0)' >Doc. Adicionales</a></td>";
        rs =
 rs + "<td><a onclick=window.open('" + bean.getPagina() + "/DUI_notaval.jsp?gestion=" + bean.getKey_year() +
    "&aduana=" + bean.getKey_cuo() + "&registro=" + bean.getReg_serial() +
    "&vdec=&vop=&vusu=&bandera=undefined','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0') href='javascript:void(0)' >Nota de Valor</a></td>";
        rs =
 rs + "<td><a onclick=window.open('" + bean.getPagina() + "/DUI_infadi.jsp?gestion=" + bean.getKey_year() + "&aduana=" +
    bean.getKey_cuo() + "&registro=" + bean.getReg_serial() +
    "&vdec=&vop=&vusu=&bandera=undefined','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0') href='javascript:void(0)' >Inf. Adicional</a></td>";
        rs =
 rs + "<td><a onclick=window.open('" + bean.getPagina() + "/DUI_frv.jsp?gestion=" + bean.getKey_year() + "&aduana=" +
    bean.getKey_cuo() + "&registro=" + bean.getReg_serial() +
    "&vdec=&vop=&vusu=&bandera=undefined','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0') href='javascript:void(0)' >FRV</a></td>";

        /*
                rs =
 rs + "<tr><th>Declaraci&oacute;n:</th><td>" +
    bean.getKey_year() + "/" + bean.getKey_cuo() + "/C-" + bean.getReg_serial() + " </td></tr>";

        rs = rs + "<tr><th>Documentos:</th><td><table><tr>";
        rs =
 rs + "<td>DUI</td>";
     */

        rs = rs + "</tr></table></td></tr>";
        rs = rs + "<tr><th>Importador:</th><td>" + bean.getImportador() + "</td></tr>";
        rs = rs + "<tr><th>Despachante:</th><td>" + bean.getDespachante() + "</td></tr>";
        //rs = rs + "<tr><th>Vista:</th><td>"+bean.getVista()+"</td></tr>";
        rs = rs + "<tr><th>Fecha Registro:</th><td>" + bean.getFecha_registro() + "</td></tr>";
        rs = rs + "<tr><th>Canal:</th><td>" + bean.getCanal() + "</td></tr>";
        rs = rs + "<tr><th>Fecha Pase de Salida:</th><td>" + bean.getFecha_pasedesalida() + "</td></tr>";

        if (bean.getEstado() != null)
            rs = rs + "<tr><th>Estado:</th><td>" + bean.getEstado() + "</td></tr>";

        rs = rs + "<tr><td colspan='2'>";
        if (bean.getFecha_registro_control() != null) {
            rs =
 rs + "<table id='backgroun2'><tr><th>Operaci&oacute;n</th><th>Fecha</th><th>Descripci&oacute;n</th><th>Usuario</th></tr>";
            rs =
 rs + "<tr><td>Registro</td><td>" + bean.getFecha_registro_control() + "</td><td>REGISTRO DE CONTROL DIFERIDO</td><td>" +
    bean.getUsuario_registro() + "</td></tr>";

            if (bean.getEstado().equals("RECHAZADO")) {
                rs =
 rs + "<tr><td>Rechazado</td><td>" + bean.getFechalog() + "</td><td>RECHAZO DE CONTROL DIFERIDO</td><td>" +
    bean.getUsuariolog() + "</td></tr>";
            }

            if (bean.getFecha_notificacion() != null)
                rs =
 rs + "<tr><td>Notificaci&oacute;n</td><td>" + bean.getFecha_notificacion() + "</td><td>" + bean.getObs_notificacion() +
    "</td><td>" + bean.getUsuario_notificacion() + "</td></tr>";

            if (bean.getFec_liquidacion() != null)
                rs =
 rs + "<tr><td>Resultados</td><td>" + bean.getFec_liquidacion() + "</td><td>MONTO TOTAL (Bs): " + bean.getMonto_total() +
    "</td><td>" + bean.getUsuario_resultados() + "</td></tr>";

            if (bean.getFecha_aceptacion() != null)
                rs =
 rs + "<tr><td>Aceptaci&oacute;n Enmienda</td><td>" + bean.getFecha_aceptacion() + "</td><td>ACEPTACION DE ENMIENDA</td><td>" +
    bean.getUsuario_aceptacion() + "</td></tr>";

            if (bean.getFecha_finalizacion() != null)
                rs =
 rs + "<tr><td>Conclusi&oacute;n</td><td>" + bean.getFecha_finalizacion() + "</td><td>" + bean.getObs_finalizacion() +
    "</td><td>" + bean.getUsuario_finalizacion() + "</td></tr>";


            if (bean.getFec_not_doc() != null)
                rs =
 rs + "<tr><td>Notificaci&oacute;n Documento de Conclusi&oacute;n</td><td>" + bean.getFec_not_doc() +
    "</td><td>TIPO NOTIFICACION: " + bean.getTip_not_doc() + "</td><td>" + bean.getUsuario_not_doc_con() +
    "</td></tr>";


            if (bean.getFec_env_legal() != null)
                rs =
 rs + "<tr><td>Envio a Unidad Legal</td><td>" + bean.getFec_env_legal() + "</td><td>NRO. DE NOTA: " +
    bean.getNro_env_legal() + "</td><td>" + bean.getUsuario_env_legal() + "</td></tr>";
            rs = rs + "</table>";


        }

        rs = rs + "</td></tr></table>";

        return rs;
    }

    public static String DevuelveEstado(String key_year, String key_cuo, String reg_serial) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        ResultSet rss = null;
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.devuelve_estado (?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, key_year);
            call.setString(3, key_cuo);
            call.setString(4, reg_serial);
            call.execute();
            rs = (String)call.getObject(1);
        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
                if (rss != null)
                    rss.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

    public static String DevuelveUFV(String fecha) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        ResultSet rss = null;
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.devuelve_ufv (?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, fecha);
            call.execute();
            rs = (String)call.getObject(1);
        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
                if (rss != null)
                    rss.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }


    public static String DevuelveCodGerencia(String usuario) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        ResultSet rss = null;
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.devuelve_gerencia (?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, usuario);
            call.execute();
            rs = (String)call.getObject(1);
        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
                if (rss != null)
                    rss.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }
    /*
    public static String ConcluirFiscalizacion(FisAvanceForm bean) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        ResultSet rss = null;
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.concluir_fis_dui (?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getId());
            call.setString(3, bean.getNrofis());
            call.setString(4, bean.getUsuario());
            call.execute();
            rs = (String)call.getObject(1);

        } catch (Exception er) {
            rs = "ERROR"+er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
                if (rss != null)
                    rss.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }
*/

    public static String DevuelveAduanas(String aduana) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        ResultSet rss = null;
        String unidad = "";
        String param = "";
        try {
            if (aduana == null) {
                param = "-";
            } else {
                param = aduana;
            }
            con = dc.abrirConexion();
            call = con.prepareCall("{? = call pkg_sicodif.lista_aduana(?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.registerOutParameter(2, -10);
            call.execute();
            rs = (String)call.getObject(1);


            if (rs.equals("CORRECTO")) {
                rss = (ResultSet)call.getObject(2);
                rs = "<select name='key_cuo' id='key_cuo'>";
                String sw = "0";

                if (aduana == null || aduana.equals("")) {
                    rs = rs + "<option selected value=''>-- Seleccione una Aduana --</option>";
                }

                while (rss != null && rss.next()) {
                    if (param.equals(rss.getString(1))) {
                        rs =
 rs + "<option selected value='" + rss.getString(1) + "'>" + rss.getString(2) + "</option>";

                    } else {
                        rs = rs + "<option value='" + rss.getString(1) + "'>" + rss.getString(2) + "</option>";
                    }


                }


                rs = rs + "</select>";

            }


        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
                if (rss != null)
                    rss.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

    public static String DevuelveAduanas(String aduana, String gerencia) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        ResultSet rss = null;
        String unidad = "";
        String param = "";
        try {
            if (aduana == null) {
                param = "-";
            } else {
                param = aduana;
            }
            con = dc.abrirConexion();
            call = con.prepareCall("{? = call pkg_sicodif.lista_aduana_gerencia(?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.registerOutParameter(2, -10);
            call.setString(3, gerencia);
            call.execute();
            rs = (String)call.getObject(1);


            if (rs.equals("CORRECTO")) {
                rss = (ResultSet)call.getObject(2);
                rs = "<select name='key_cuo' id='key_cuo'>";
                String sw = "0";

                if (aduana == null || aduana.equals("") || aduana.equals("-")) {
                    rs = rs + "<option selected value=''>-- Seleccione una Aduana --</option>";
                }

                while (rss != null && rss.next()) {
                    if (param.equals(rss.getString(1))) {
                        rs =
 rs + "<option selected value='" + rss.getString(1) + "'>" + rss.getString(2) + "</option>";

                    } else {
                        rs = rs + "<option value='" + rss.getString(1) + "'>" + rss.getString(2) + "</option>";
                    }


                }


                rs = rs + "</select>";

            }


        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
                if (rss != null)
                    rss.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

    public static String DevuelveAduanasT(String aduana, String gerencia) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        ResultSet rss = null;
        String unidad = "";
        String param = "";
        try {
            if (aduana == null) {
                param = "-";
            } else {
                param = aduana;
            }
            con = dc.abrirConexion();
            call = con.prepareCall("{? = call pkg_sicodif.lista_aduana_gerencia(?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.registerOutParameter(2, -10);
            call.setString(3, gerencia);
            call.execute();
            rs = (String)call.getObject(1);

            if (rs.equals("CORRECTO")) {
                rss = (ResultSet)call.getObject(2);
                rs = "<select name='key_cuot' id='key_cuot'>";
                String sw = "0";

                //if (aduana == null || aduana.equals("")) {
                rs = rs + "<option selected value=''>-- Seleccione una Aduana --</option>";
                rs = rs + "<option value='%'>-- Todos --</option>";
                //}

                while (rss != null && rss.next()) {
                    if (param.equals(rss.getString(1))) {
                        rs =
 rs + "<option selected value='" + rss.getString(1) + "'>" + rss.getString(2) + "</option>";

                    } else {
                        rs = rs + "<option value='" + rss.getString(1) + "'>" + rss.getString(2) + "</option>";
                    }
                }
                rs = rs + "</select>";
            }
        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
                if (rss != null)
                    rss.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

    public static String DevuelveRecAduanas(String aduana) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        ResultSet rss = null;
        String unidad = "";
        String param = "";
        try {
            if (aduana == null) {
                param = "-";
            } else {
                param = aduana;
            }
            con = dc.abrirConexion();
            call = con.prepareCall("{? = call pkg_sicodif.lista_aduana(?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.registerOutParameter(2, -10);
            call.execute();
            rs = (String)call.getObject(1);


            if (rs.equals("CORRECTO")) {
                rss = (ResultSet)call.getObject(2);
                rs = "<select name='rec_aduana' id='rec_aduana'>";
                String sw = "0";

                if (aduana == null || aduana.equals("")) {
                    rs = rs + "<option selected value=''>-- Seleccione una Aduana --</option>";
                }

                while (rss != null && rss.next()) {
                    if (param.equals(rss.getString(1))) {
                        rs =
 rs + "<option selected value='" + rss.getString(1) + "'>" + rss.getString(2) + "</option>";

                    } else {
                        rs = rs + "<option value='" + rss.getString(1) + "'>" + rss.getString(2) + "</option>";
                    }


                }


                rs = rs + "</select>";

            }


        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
                if (rss != null)
                    rss.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

    public static String DevuelveRecAduanas(String aduana, String gerencia) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        ResultSet rss = null;
        String unidad = "";
        String param = "";
        try {
            if (aduana == null) {
                param = "-";
            } else {
                param = aduana;
            }
            con = dc.abrirConexion();
            call = con.prepareCall("{? = call pkg_sicodif.lista_aduana_gerencia(?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.registerOutParameter(2, -10);
            call.setString(3, gerencia);
            call.execute();
            rs = (String)call.getObject(1);


            if (rs.equals("CORRECTO")) {
                rss = (ResultSet)call.getObject(2);
                rs = "<select name='rec_aduana' id='rec_aduana'>";
                String sw = "0";

                if (aduana == null || aduana.equals("")) {
                    rs = rs + "<option selected value=''>-- Seleccione una Aduana --</option>";
                }

                while (rss != null && rss.next()) {
                    if (param.equals(rss.getString(1))) {
                        rs =
 rs + "<option selected value='" + rss.getString(1) + "'>" + rss.getString(2) + "</option>";

                    } else {
                        rs = rs + "<option value='" + rss.getString(1) + "'>" + rss.getString(2) + "</option>";
                    }


                }


                rs = rs + "</select>";

            }


        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
                if (rss != null)
                    rss.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }


    public static String DevuelveFiscalizadores(String gerencia) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        ResultSet rss = null;
        String unidad = "";
        String param = "";
        String sw2 = "0";
        try {
            if (gerencia == null) {
                param = "-";
            } else {
                param = gerencia;
            }
            con = dc.abrirConexion();
            call = con.prepareCall("{? = call pkg_sicodif.lista_fiscalizadores(?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.registerOutParameter(2, -10);
            call.setString(3, gerencia);
            call.execute();
            rs = (String)call.getObject(1);


            if (rs.equals("CORRECTO")) {
                rss = (ResultSet)call.getObject(2);
                rs = "<select name='fiscalizador' id='fiscalizador'>";
                String sw = "0";

                if (gerencia == null || gerencia.equals("")) {
                    rs = rs + "<option selected value=''>-- Seleccione un Fiscalizador --</option>";
                    sw2 = "1";
                }
                while (rss != null && rss.next()) {
                    rs = rs + "<option value='" + rss.getString(1) + "'>" + rss.getString(2) + "</option>";
                    sw2 = "1";
                }

                if (sw2.equals("0"))
                    rs =
 rs + " <option selected value=''>-- No se Registraron Fiscalizadores en esta Regional --</option>";

                rs = rs + "</select>";

            }


        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
                if (rss != null)
                    rss.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

    public static String DevuelveFiscalizadoresT(String gerencia) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        ResultSet rss = null;
        String unidad = "";
        String param = "";
        String sw2 = "0";
        try {
            if (gerencia == null) {
                param = "-";
            } else {
                param = gerencia;
            }
            con = dc.abrirConexion();
            call = con.prepareCall("{? = call pkg_sicodif.lista_fiscalizadores(?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.registerOutParameter(2, -10);
            call.setString(3, gerencia);
            call.execute();
            rs = (String)call.getObject(1);


            if (rs.equals("CORRECTO")) {
                rss = (ResultSet)call.getObject(2);
                rs = "<select name='fiscalizador' id='fiscalizador'>";
                String sw = "0";

                if (gerencia == null || gerencia.equals("")) {
                    rs = rs + "<option selected value=''>-- Seleccione un Fiscalizador --</option>";
                    rs = rs + "<option selected value='%'>-- Todos --</option>";
                    sw2 = "1";
                }
                while (rss != null && rss.next()) {
                    rs = rs + "<option value='" + rss.getString(1) + "'>" + rss.getString(2) + "</option>";
                    sw2 = "1";
                }

                if (sw2.equals("0"))
                    rs =
 rs + " <option selected value=''>-- No se Registraron Fiscalizadores en esta Regional --</option>";

                rs = rs + "</select>";

            }


        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
                if (rss != null)
                    rss.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

    public static String DevuelveFiscalizadoresEnm(String gerencia, String fiscalizador) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        ResultSet rss = null;
        String unidad = "";
        String param = "";
        String sw2 = "0";
        try {
            if (gerencia == null) {
                param = "-";
            } else {
                param = gerencia;
            }
            con = dc.abrirConexion();
            call = con.prepareCall("{? = call pkg_sicodif.lista_fiscalizadores(?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.registerOutParameter(2, -10);
            call.setString(3, gerencia);
            call.execute();
            rs = (String)call.getObject(1);


            if (rs.equals("CORRECTO")) {
                rss = (ResultSet)call.getObject(2);
                rs = "<select name='fiscalizador' id='fiscalizador'>";
                String sw = "0";

                if (gerencia == null || gerencia.equals("")) {
                    sw2 = "1";
                }
                while (rss != null && rss.next()) {
                    if (fiscalizador.equals(rss.getString(1))) {
                        rs =
 rs + "<option selected value='" + rss.getString(1) + "'>" + rss.getString(2) + "</option>";
                    } else {

                        rs = rs + "<option value='" + rss.getString(1) + "'>" + rss.getString(2) + "</option>";
                    }
                    sw2 = "1";
                }

                if (sw2.equals("0"))
                    rs =
 rs + " <option selected value=''>-- No se Registraron Fiscalizadores en esta Regional --</option>";

                rs = rs + "</select>";

            }


        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
                if (rss != null)
                    rss.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

    //reporte de Resultados de deudas -- dibuja la tabla del reporte del detalle de recaudaciones

    public static String TablaDetrecaudaciones(String gerencia, String fec_ini, String fec_fin) {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        simbolos.setGroupingSeparator(',');

        DecimalFormat d = new DecimalFormat("#,###,###.##", simbolos);
        d.setMaximumFractionDigits(2);
        d.setMinimumFractionDigits(2);


        DecimalFormat df = new DecimalFormat("#,###,###.##", simbolos);
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);

        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        String tb = "";
        double deuda = 0;
        double total = 0;
        String vgerencia = "";

        ResultSet rss = null;
        try {

            if (gerencia.equals("%")) {
                vgerencia = "Todas las gerencias";
            } else if (gerencia.equals("GRLP")) {
                vgerencia = "GERENCIA REGIONAL LA PAZ";
            } else if (gerencia.equals("GRCB")) {
                vgerencia = "GERENCIA REGIONAL COCHABAMBA";
            } else if (gerencia.equals("GRSC")) {
                vgerencia = "GERENCIA REGIONAL SANTA CRUZ";
            } else if (gerencia.equals("GROR")) {
                vgerencia = "GERENCIA REGIONAL ORURO";
            } else if (gerencia.equals("GRTJ")) {
                vgerencia = "GERENCIA REGIONAL TARIJA";
            } else if (gerencia.equals("GRPT")) {
                vgerencia = "GERENCIA REGIONAL POTOSI";
            }


            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_reporte.reporte_det_recauda (?,?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, gerencia);
            call.setString(3, fec_ini);
            call.setString(4, fec_fin);
            call.registerOutParameter(5, -10);
            call.execute();
            rs = (String)call.getObject(1);

            tb = "";

            if (rs.equals("CORRECTO")) {


                rss = (ResultSet)call.getObject(5);


                tb = "<table>";
                tb = tb + "<table id='backgroun4'>";
                tb = tb + "<tr><th >RESULTADOS DEUDA DETERMINADA</th></tr>";
                tb =
 tb + " <tr><td ><div align='left'><table> <tr><td align='left'><strong>Gerencia:</strong> </td><td align='left'>" +
    vgerencia + "</td></tr><tr><td align='left'><strong>Fecha conclusi&oacute;n desde:</strong></td><td>" + fec_ini +
    "</td></tr><tr><td align='left'><strong>Fecha conclusi&oacute;n hasta:</strong></td><td>" + fec_fin +
    "</td></tr></table></div></td></tr>";
                tb = tb + "</table>";
                tb = tb + "<table id='backgroun3'>";
                tb =
 tb + "<tr><th colspan='4'>DATOS DE LA DECLARACI&Oacute;N</th><th colspan='5'>MONTO DETERMINADO</th><th colspan='5'>MONTO COBRADO A LA FECHA</th></tr>";
                tb =
 tb + "<tr><th>GERENCIA</th><th>ADUANA</th><th>DESCRIPCI&Oacute;N ADUANA</th><th>N&Uacute;MERO DE DECLARACI&Oacute;N</th><th>TRIBUTO OMITIDO GA Bs</th><th>TRIBUTO OMITIDO IVA Bs</th><th>TRIBUTO OMITIDO ICE Bs</th><th>TRIBUTO OMITIDO IEHD Bs</th><th>TOTAL TRIBUTO OMITIDO Bs</th><th>TRIBUTO PAGADO GA Bs</th><th>TRIBUTO PAGADO IVA Bs</th><th>TRIBUTO PAGADO ICE Bs</th><th>TRIBUTO PAGADO IHD Bs</th><th>TOTAL TRIBUTO PAGADO</th></tr>";


                while (rss != null && rss.next()) {

                    tb =
 tb + "<tr><td>" + rss.getString(2) + "</td><td>" + rss.getString(5) + "</td><td>" + rss.getString(6) + "</td><td>" +
    rss.getString(7) + "</td><td style='text-align:right'>" +
    df.format(Double.valueOf(rss.getString(30)).doubleValue()) + "</td><td style='text-align:right'>" +
    df.format(Double.valueOf(rss.getString(31)).doubleValue()) + "</td><td style='text-align:right'>" +
    df.format(Double.valueOf(rss.getString(32)).doubleValue()) + "</td><td style='text-align:right'>" +
    df.format(Double.valueOf(rss.getString(33)).doubleValue()) + "</td><td style='text-align:right'>" +
    df.format(Double.valueOf(rss.getString(34)).doubleValue()) + "</td><td style='text-align:right'>" +
    df.format(Double.valueOf(rss.getString(64)).doubleValue()) + "</td><td style='text-align:right'>" +
    df.format(Double.valueOf(rss.getString(65)).doubleValue()) + "</td><td style='text-align:right'>" +
    df.format(Double.valueOf(rss.getString(66)).doubleValue()) + "</td><td style='text-align:right'>" +
    df.format(Double.valueOf(rss.getString(67)).doubleValue()) + "</td><td style='text-align:right'>" +
    df.format(Double.valueOf(rss.getString(68)).doubleValue()) + "</td></tr>";

                }


                tb = tb + "</table></table>";


            } else {
                tb = "NO EXISTE INFORMACION PARA EL REPORTE";

            }


        } catch (Exception er) {
            tb = "ERROR: " + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
                if (rss != null)
                    rss.close();
            } catch (SQLException er) {
                ;
            }
        }
        return tb;
    }

    public static String DevuelveAnulRes(FisAnulControldifForm bean) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        ResultSet rss = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.devuelve_control (?,?,?, ?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());
            call.registerOutParameter(5, -10);
            call.execute();
            rs = (String)call.getObject(1);

            if (rs.equals("CORRECTO")) {
                rss = (ResultSet)call.getObject(5);
                if (rss != null && rss.next()) {

                    bean.setEtapa(rss.getString(42));

                    bean.setFec_liq(rss.getString(20));

                    bean.setTributo_ga(rss.getString(21));
                    bean.setTributo_iva(rss.getString(22));
                    bean.setTributo_ice(rss.getString(23));
                    bean.setTributo_iehd(rss.getString(24));
                    bean.setSancion(rss.getString(25));
                    bean.setMultaca(rss.getString(26));
                    bean.setMultacc(rss.getString(27));
                    bean.setMultacd(rss.getString(28));

                    bean.setTributo_ufv_ga(rss.getString(56));
                    bean.setTributo_ufv_iva(rss.getString(57));
                    bean.setTributo_ufv_ice(rss.getString(58));
                    bean.setTributo_ufv_iehd(rss.getString(59));
                    bean.setSancion_ufv(rss.getString(60));
                    bean.setMultaca_ufv(rss.getString(61));
                    bean.setMultacc_ufv(rss.getString(62));
                    bean.setMultacd_ufv(rss.getString(63));

                    bean.setValor_ufv(rss.getString(64));
                    bean.setCdgerencia(rss.getString(2));

                }
            } else {
                bean.setMensaje("ERROREL CONTROL DIFERIDO NO EXISTE");
            }
        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }
    //guarda anulacion del control diferido

    public static String GuardaAnulacionControlDif(FisAnulControldifForm bean, String usuario) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.f_reg_anul_control_dif (?,?,?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());
            call.setString(5, bean.getObsanulacion());
            call.setString(6, usuario);
            call.execute();
            rs = (String)call.getObject(1);
            bean.setNrofis(bean.getKey_year() + "/" + bean.getKey_cuo() + "/C-" + bean.getReg_serial());

        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

    //guarda cierre del control diferido

    public static String GuardacierreControlDif(FisCierreContDifForm bean, String usuario) {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.f_reg_cierre_control_dif (?,?,?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getKey_year());
            call.setString(3, bean.getKey_cuo());
            call.setString(4, bean.getReg_serial());
            call.setString(5, bean.getCierreobservacion());
            call.setString(6, usuario);
            call.execute();
            rs = (String)call.getObject(1);
            bean.setNrofis(bean.getKey_year() + "/" + bean.getKey_cuo() + "/C-" + bean.getReg_serial());

        } catch (Exception er) {
            rs = "ERROR" + er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();
                call.close();
            } catch (SQLException er) {
                ;
            }
        }
        return rs;
    }

}


