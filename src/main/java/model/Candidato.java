package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Candidato {
	int codigo;
    String nome;
    char sexo;
    Date data_nasc;
    String cargo_pretendido;
    String texto_curriculo;

    public Candidato(int id, String nome, String sexo, String data_nasc, String cargo_pretendido, String texto_curriculo) throws ParseException {
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

        this.codigo = id;
        this.nome = nome;
        this.sexo = sexo.charAt(0);
        this.data_nasc = formatter.parse(data_nasc);
        this.cargo_pretendido = cargo_pretendido;
        this.texto_curriculo = texto_curriculo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return String.valueOf(sexo);
    }

    public Date getData_nasc() {
        return this.data_nasc;
    }

    public String getCargo_pretendido() {
        return cargo_pretendido;
    }

    public String getTexto_curriculo() {
        return texto_curriculo;
    }
}
