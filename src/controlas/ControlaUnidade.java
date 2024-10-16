package controlas;

import dao.UnidadeDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Unidade;


public class ControlaUnidade
{
    private UnidadeDAO dao = new UnidadeDAO();
    
    public String addUnidade ( Unidade novaUnidade )
    {
        try
        {
            if ( novaUnidade.getUni().isEmpty() )
            {
                return "Preencha todos os campos";
            }
            if ( consultarUnidadeExata( novaUnidade.getUni()) == null )
            {
                dao.insertUnidade(novaUnidade);
                return null;
            }
            else
            {
                return "Unidade " +novaUnidade.getUni()+ " já existe!";
            }
        }
        catch ( Exception ex )
        {
            Logger.getLogger( ControlaUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "Tive problemas ao cadastrar nova unidade de produto";
                
    }
    
    public Unidade consultarUnidadeExata ( String unidadeParaBuscar )
    {
        return dao.consultarUnidadeExata(unidadeParaBuscar);
    }
    
}
