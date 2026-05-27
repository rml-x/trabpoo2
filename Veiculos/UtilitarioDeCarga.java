package veiculos;

public class UtilitarioDeCarga extends Veiculo{

    private double litrosMax;
    private boolean rampa;

    public UtilitarioDeCarga(String placa, String modelo, double capacidadeKg, double litrosMax, boolean rampa) {
        super(placa, modelo, capacidadeKg);
        this.litrosMax = litrosMax;
        this.rampa = rampa;

    }

    public double getLitrosMax(){
        return litrosMax;
    }
    public boolean getRampa(){
        return rampa;
    }

    
}
