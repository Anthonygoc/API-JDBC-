package ifmt.cba.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

    private static final String URL = "jdbc:postgresql://localhost:5432/produtos";
    private static final String DRIVE = "org.postgresql.Driver";
    private static final String USER = "postgres";
    private static final String PASS = "03022004";

public static Connection obterConexao() throws Exception{

    Connection conexao = null;
    
    try{

        Class.forName(DRIVE); 
        conexao = DriverManager.getConnection(URL, USER, PASS);
    }   catch (ClassNotFoundException cnf){
        throw new Exception("Driver Nao  encontrado " + cnf.getMessage());
    }catch(SQLException sqle){
        throw new Exception("Erro ao conectar no bando -" +sqle.getMessage());
    }
    return conexao;

}

}
