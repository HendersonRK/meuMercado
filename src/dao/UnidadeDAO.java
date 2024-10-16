package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Unidade;
import util.ConexaoBD;

public class UnidadeDAO
{
    public void insertUnidade ( Unidade u ) 
    {
        String sql = " insert into unidade_produto ( ds_unidade_produto ) values ( "+"'" + u.getUni() + "')";
        
        try
        {
            ConexaoBD.executeUpdate( sql );
        }
        catch ( SQLException ex )
        {
            ex.printStackTrace();
        }
    }
    
    public void updateUnidade ( Unidade u ) 
    {
        String sql = " update unidades set nome = '" + u.getUni() + "' where  codigo = " + u.getId();
                        
        try
        {
            ConexaoBD.executeUpdate( sql );
        }
        catch ( SQLException ex )
        {
            ex.printStackTrace();
        }
    }
    
    public void deleteUnidade ( Unidade u ) 
    {
        deleteUnidade ( u.getId() );
    }
    
    public void deleteUnidade ( int codigo ) 
    {
        String sql = " delete from unidades where codigo = " + codigo;
        
        try
        {
            ConexaoBD.executeUpdate( sql );
        }
        catch ( SQLException ex )
        {
            ex.printStackTrace();
        }
    }
    
    public Unidade consultarUnidadePorCodigo ( int codigo )
    {
        Unidade u = null;        
        
        String sql = "SELECT * FROM unidades WHERE id = " + codigo;
        
        try
        {
            ResultSet rs = ConexaoBD.executeQuery( sql );
            
            while ( rs.next() )
            {
                u = new Unidade();
                
                u.setId(rs.getInt( "nr_unidade_produto" ));
                u.setUni(rs.getString( "ds_unidade_produto" ));                
            }
        }
        
        catch ( SQLException ex )
        {
            ex.printStackTrace();
        }
        
        return u;
    }
    
    public Unidade consultarUnidadeExata ( String nome )
    {
        Unidade u = null;        
        
        String sql = "SELECT * FROM unidade_produto WHERE ds_unidade_produto = '" +nome+"'";
        
        try
        {
            ResultSet rs = ConexaoBD.executeQuery( sql );
            
            while ( rs.next() )
            {
                u = new Unidade();
                u.setId(rs.getInt( "nr_unidade_produto" ));
                u.setUni(rs.getString( "ds_unidade_produto" ));                
            }
        }
        
        catch ( SQLException ex )
        {
            ex.printStackTrace();
        }
        
        return u;
    }
    
    public ArrayList<Unidade> consultarUnidade ( String textoParaBuscar )
    {
        ArrayList<Unidade> unidades = new ArrayList();
        
        String sql = "select * from unidades " +
                     " where " +
                     " nome like  '%" + textoParaBuscar + "%'";
        
        try
        {
            ResultSet rs = ConexaoBD.executeQuery( sql );

            while ( rs.next() )
            {
                Unidade u = new Unidade();
                u.setId(rs.getInt("nr_unidade_produto"));
                u.setUni(rs.getString( "ds_unidade_produto" ));
                
                unidades.add( u );
            }
        }
        
        catch ( SQLException ex )
        {
            ex.printStackTrace();
        }
        
        return unidades;
    }
    
    public ArrayList<Unidade> getPalavras ( )
    {
        ArrayList<Unidade> unidades = new ArrayList();
        
        String sql = "select * from unidade order by nome";
        
        try
        {
            ResultSet rs = ConexaoBD.executeQuery( sql );

            while ( rs.next() )
            {
                Unidade u = new Unidade();
                u.setId(rs.getInt("id"));
                u.setUni(rs.getString( "uni" ));
                
                unidades.add( u );
            }
        }
        
        catch ( SQLException ex )
        {
            ex.printStackTrace();
        }
        
        return unidades;
    }
}
