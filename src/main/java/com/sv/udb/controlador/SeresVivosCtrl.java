package com.sv.udb.controlador;

import com.sv.udb.modelo.SeresVivos;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Jose Lira
 */
public class SeresVivosCtrl {
     //GUARDAR
    public boolean guar(SeresVivos obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("insert into seresvivos values(NULL,?,?,?)");
            cmd.setInt(1, obje.getCodiSere());            
            cmd.setString(2, obje.getNombSere());
            cmd.setString(3, obje.getDescSere());
            cmd.setInt(4, obje.getCodiRefeSere());
            cmd.executeUpdate();
            resp=true;
            
        } catch (Exception ex) {
            System.err.println("Error al guardadr Ser Vivo" + ex.getMessage());
        }
        finally
        {
            try {
                 if(cn != null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
        return resp;
    }
    
    
    //MOSTRAR
    public List<SeresVivos> constTodo()
    {
        List<SeresVivos> resp = new ArrayList();
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("select * from seresvivos");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new SeresVivos(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));               
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
        finally
        {
            try {
                if(cn != null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
        return resp;
    }
    
      //MODIFICAR
    public boolean modi(SeresVivos obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("update seresvivos set nomb_sere = '"+obje.getNombSere()+"' , desc_sere = '"+obje.getDescSere()+"' , codi_refe_sere = "+obje.getCodiRefeSere()+" where codi_sere = "+obje.getCodiSere()+"");
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al modificar: " + ex.getMessage());
        }
        finally
        {
            try {
                if(cn != null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } catch (SQLException err) {
                err.printStackTrace();
            }
        }
        return resp;
    }
    
    //ELIMINAR
    public boolean elim(SeresVivos obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("delete from seresvivos where codi_sere = "+obje.getCodiSere()+"");
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al Eliminar: " + ex.getMessage());
        }
        finally
        {
            try {
                if(cn != null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } catch (SQLException err) {
                err.printStackTrace();
            }
        }
        return resp;
    }


}
