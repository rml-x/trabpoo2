package veiculos;

public class AmbulanciaUTI extends Veiculo{
    private boolean respirador;
    private boolean monitorCardiaco;
    private boolean mediaFixa;

    
    public AmbulanciaUTI(String placa, String modelo, double capacidadeKg, boolean respirador, boolean monitorCardiaco, boolean mediaFixa) {
        super(placa, modelo, capacidadeKg);
        this.respirador = respirador;
        this.monitorCardiaco = monitorCardiaco;
        this.mediaFixa = mediaFixa;
    }

    public boolean isRespirador(){
        return respirador;
    }
    public boolean isMonitorCardiaco(){
        return monitorCardiaco;
    }
    public boolean isMediaFixa(){
        return mediaFixa;
    }


    
    
}
