package veiculos;

public class AmbulanciaUTI extends Veiculo{
    private boolean respirador;
    private boolean monitorCardiaco;
    private boolean equipeMediaFixa ;

    
    public AmbulanciaUTI(String placa, String modelo, double capacidadeKg, boolean respirador, boolean monitorCardiaco, boolean equipeMediaFixa ) {
        super(placa, modelo, capacidadeKg);
        this.respirador = respirador;
        this.monitorCardiaco = monitorCardiaco;
        this.equipeMediaFixa  = equipeMediaFixa ;
    }

    public boolean isRespirador(){
        return respirador;
    }
    public boolean isMonitorCardiaco(){
        return monitorCardiaco;
    }
    public boolean isEquipeMediaFixa (){
        return equipeMediaFixa ;
    }
    
    @Override
    public boolean isUTI() { 
        return true; 
    }


    
    
}
