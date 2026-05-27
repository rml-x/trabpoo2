package profissional;
import enums.TipoProfissional;

public class Profissional {
    private String nome;
    private int registro;
    private TipoProfissional tipo;

    public Profissional(String nome, int registro, TipoProfissional tipo){
        this.nome = nome;
        this.registro = registro;
        this.tipo = tipo;
    }

    public String getNome(){
        return nome;
    }
    public int getRegistro(){
        return registro;
    }
    public TipoProfissional getTipoProfissional() {
        return tipo;
    }
}
