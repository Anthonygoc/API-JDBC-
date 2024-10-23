

package ifmt.cba.util;

import java.sql.Connection;

import javax.swing.JOptionPane;


public class FabricaTeste {

    public static void main(String args[]){
        
        Connection conexao;
        try{
            conexao = FabricaConexao.obterConexao();
            JOptionPane.showMessageDialog(null, "CONEXAO ESTABELECIDA ");
            conexao.close();
            JOptionPane.showMessageDialog(null, "Conexao encerrada");
        } catch (Exception sqle){
            JOptionPane.showMessageDialog(null, "conexao nao estabelecida -" +sqle);
        }
    }

}
