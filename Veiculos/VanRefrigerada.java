package veiculos;

public class VanRefrigerada extends Veiculo{

    private double temperaturaAtual;
    private boolean controleTemperatura;
    
            
    public VanRefrigerada(String placa, String modelo, double capacidadeKg, double temperaturaAtual, boolean controleTemperatura) {
        super(placa, modelo, capacidadeKg);
        this.temperaturaAtual = temperaturaAtual;
        this.controleTemperatura = controleTemperatura;
       
        
    }

    public double getTemperaturaAtual(){
        return temperaturaAtual;
    }
    public boolean isControleTemperatura(){
        return controleTemperatura;
    }
    
    //TODO: add metodo de verificar temperatura
    
}
