package ifmt.cba.apps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


import ifmt.cba.util.FabricaConexao;

public class selecao3 {

    public static void main (String args []){

        Connection conexao = null;
        PreparedStatement comando = null;

        String nome = JOptionPane.showInputDialog("Forneca parte do nome a ser pesquisado");
        try{
            conexao = FabricaConexao.obterConexao();
            comando = conexao.prepareStatement("SELECT * FROM grupoproduto WHERE upper (nome) LIKE ?");
            comando.setString(1, "%" + nome.toUpperCase() + "%");
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()){
                do {
                    System.out.println("Codigo :" + resultado.getInt("Codigo"));
                    System.out.println("Nome :" + resultado.getString("nome"));
                    System.out.println("%Promocao :" + resultado.getFloat("margemlucro"));
                    System.out.println("------------------------------------------------");  
                } while (resultado.next()); {
                        
                }
            }else{
                System.out.println("Nao encontrado");
            }

                
            }catch (Exception ex){
                System.out.println("Erro ao recuperar um grupo" + ex.toString());
            }finally{
                try{
                    comando.close();
                    comando.close();
                }catch(SQLException ex ){
                    System.out.println("ERRO ao desconectar "+ ex.toString());
                }
            }
        }
    }
