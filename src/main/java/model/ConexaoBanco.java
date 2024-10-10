package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBanco {
	private String driver   = "com.mysql.cj.jdbc.Driver";
    private String url      = "jdbc.mysql://127.0.0.1:3306/candidatos";
	private String user     = "root";
    private String password = "1234";
    //private String textoConexao;

    public Connection obterConexao(){
    	Connection con = null;
        try {
        	Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return con;
    }
}
