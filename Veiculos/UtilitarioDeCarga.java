package veiculos;

public class UtilitarioDeCarga extends Veiculo{

    private double LitrosMax;
    private boolean Rampa;

    public UtilitarioDeCarga(String placa, String modelo, double capacidadeKg, double LitrosMax, boolean Rampa) {
        super(placa, modelo, capacidadeKg);
        this.LitrosMax = LitrosMax;
        this.Rampa = Rampa;

    }

    public double LitrosMax(){
        return LitrosMax;
    }
    public boolean Rampa(){
        return Rampa;
    }

    
}
