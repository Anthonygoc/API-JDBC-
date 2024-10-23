package ifmt.cba.apps;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import ifmt.cba.util.FabricaConexao;

public class Incluir1 {

    public static void main(String[] args) {
        Connection conexao = null;
        Statement comando = null;
        String nome = JOptionPane.showInputDialog("Forneca o nome do grupo do produto");
        float promocao =  Float.parseFloat( JOptionPane.showInputDialog("Forneca o percentual da promocao do grupo de produto"));  
        float margemlucro =  Float.parseFloat( JOptionPane.showInputDialog("Forneca o percentual da margem de lucro do grupo de produto"));  

        String sql = "INSERT INTO grupoproduto(nome, promocao, margemlucro) VALUES";
        sql +="('" + nome + "', " + promocao + ", " + margemlucro+ ")";
        try{
            conexao = FabricaConexao.obterConexao();
            comando = conexao.createStatement();
            comando.executeUpdate(sql);
            System.out.println("Inclulsao realizada com sucesso");
        }   catch(Exception ex){
            System.out.println("Erro ao incluir grupo de produto" + ex.toString());
        } finally{
            try{
                comando.close();
                conexao.close();
            } catch(SQLException ex){
                System.out.println("Erro ao desconectar" + ex.toString());
            }
}
}
}