package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ClientBanco {
    private Connection con;

    public ClientBanco() throws SQLException {
    	ConexaoBanco cb = new ConexaoBanco();
    	con = cb.obterConexao();
    }

	public void PostCandidato(Candidato can ){
        String sql = "INSERT INTO candidatos VALUES	(codigo, nome, sexo, data_nasc, cargo_pretendido, texto_curriculo) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, can.getCodigo());
            ps.setString(2, can.getNome());
            ps.setString(3, can.getSexo());
            ps.setDate(4, (Date) can.getData_nasc());
            ps.setString(5, can.getCargo_pretendido());
            ps.setString(6, can.getTexto_curriculo());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void DeleteCandidato(int id) throws ParseException{
        String sql = "DELETE FROM candidatos WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public ArrayList<Candidato> listarCandidatos(){
    	ArrayList<Candidato> candidatos = new ArrayList<>();
    	
        String sql = "SELECT * FROM candidatos";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	int id = rs.getInt(1);
            	String nome = rs.getString(2);
            	String sexo = rs.getString(3);
            	Date data_nasc = rs.getDate(4);
            	String cargo_pretendido = rs.getString(5);
            	String texto_curriculo = rs.getString(6);
            	
            	SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
            	
            	candidatos.add(new Candidato(id,nome,sexo,f.format(data_nasc), cargo_pretendido,texto_curriculo));
            }
            return candidatos;
            
        } catch (SQLException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
    
}

