package veiculos;

public class VanRefrigerada extends Veiculo{

    private double temperaturaAtual;
    private boolean controleTemperatura;
            
    public VanRefrigerada(String placa, String modelo, double capacidadeKg, double temperaturaAtual, boolean controleTemperatura) {
        super(placa, modelo, capacidadeKg);
        this.temperaturaAtual = temperaturaAtual;
        this.controleTemperatura = controleTemperatura;
        
    }

    public double temperaturaAtual(){
        return temperaturaAtual;
    }
    public boolean controleTemperatura(){
        return controleTemperatura;
    }
    
}
