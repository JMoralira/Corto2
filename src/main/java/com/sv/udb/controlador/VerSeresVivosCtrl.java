/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;
import com.sv.udb.modelo.VerSeresVivos;
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
public class VerSeresVivosCtrl {
    
    
    
    //GUARDAR REINO
    
     public boolean guardar(VerSeresVivos obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("insert into seresvivos values(NULL,?,?,NULL)");
            cmd.setString(1, obje.getNombSer());
            cmd.setString(2, obje.getDescSer());
            cmd.executeUpdate();
            resp=true;
            
        } catch (Exception ex) {
            System.err.println("Error al guardar Ser Vivo" + ex.getMessage());
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
    
    
      //GUARDAR 
    public boolean guar(VerSeresVivos obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("insert into seresvivos values(NULL,?,?,?)");
            cmd.setString(1, obje.getNombSer());
            cmd.setString(2, obje.getDescSer());
            cmd.setInt(3, obje.getPerteSer());
            cmd.executeUpdate();
            resp=true;
            
        } catch (Exception ex) {
            System.err.println("Error al guardar Ser Vivo" + ex.getMessage());
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
    public List<VerSeresVivos> constTodo()
    {
        List<VerSeresVivos> resp = new ArrayList();
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("SELECT s2.codi_sere, s2.codi_refe_sere, s1.nomb_sere 'PERTENECE A', s2.nomb_sere, s2.desc_sere \n" +
                                                        "FROM seresvivos s1 RIGHT JOIN seresvivos s2 on s1.codi_sere = s2.codi_refe_sere\n" +
                                                        "ORDER BY s1.codi_sere");
            ResultSet rs = cmd.executeQuery();
            resp.add(new VerSeresVivos(0,0,null,null,null));
            while(rs.next())
            {
                resp.add(new VerSeresVivos(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));               
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
    
    //MODIFICAR REINO
      //MODIFICAR
    public boolean modificar(VerSeresVivos obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
          PreparedStatement cmd = cn.prepareStatement("update seresvivos set nomb_sere = '"+obje.getNombSer()+"' , desc_sere = '"+obje.getDescSer()+"' , codi_refe_sere = NULL where codi_sere = "+obje.getCodiSer()+"");
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
    
    //MODIFICAR    
    public boolean modi(VerSeresVivos obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
          PreparedStatement cmd = cn.prepareStatement("update seresvivos set nomb_sere = '"+obje.getNombSer()+"' , desc_sere = '"+obje.getDescSer()+"' , codi_refe_sere = "+obje.getPerteSer()+" where codi_sere = "+obje.getCodiSer()+"");
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
    public boolean elim(VerSeresVivos obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
          PreparedStatement cmd = cn.prepareStatement("delete from seresvivos where codi_sere = "+obje.getCodiSer()+"");
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
