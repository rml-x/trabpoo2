package veiculos;

public class AmbulanciaSimples extends Veiculo{

    private boolean maca;
    private boolean oxigenio;

    public AmbulanciaSimples(String placa, String modelo, double capacidadeKg, boolean maca, boolean oxigenio) {
        super(placa, modelo, capacidadeKg);
        this.maca = maca;
        this.oxigenio = oxigenio;
        
    }

    //getters
    public boolean isMaca(){
        return maca;
    }
    public boolean isOxigenio(){
        return oxigenio;
    }

    @Override
    public boolean temOxigenio() { 
        return true; 
    } 
    
    
}
