package operacoes;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.EnumMap;
import java.util.Map;

import enums.TipoProfissional;
import enums.Urgencia;

public class TransporteAmostraBiologica extends OperacaoClinica{

    private String tipoAmostra;
    private Urgencia nivelUrgencia;
    private boolean riscoBiologico;
    private Duration prazoMinDuration;
    
    public TransporteAmostraBiologica(int codigo, String origem, String destino, double distanciaKm, String solicitante,
            LocalDateTime dataHoraSolicitacao, String tipoAmostra, Urgencia nivelUrgencia, boolean riscoBiologico,
            Duration prazoMinDuration) {

        super(codigo, origem, destino, distanciaKm, solicitante, dataHoraSolicitacao);
        
        this.tipoAmostra = tipoAmostra;
        this.nivelUrgencia = nivelUrgencia;
        this.riscoBiologico = riscoBiologico;
        this.prazoMinDuration = prazoMinDuration;
    }

    public String getTipoAmostra(){ return tipoAmostra;}
    public Urgencia getNivelUrgencia(){return nivelUrgencia;}
    public boolean isRiscoBiologico(){return riscoBiologico;}
    public Duration getPrazoMinDuration(){return prazoMinDuration;}


    @Override
    public String gerarLogAuditoria() {

        String titulo = String.format(" Relatorio Transporte de Amostra Biologica - Codigo: %s - Status: %s \n", getCodigo(), getStatus());
        String informacaoMedicamento = String.format("\t Tipo da Amostra: %s \n", getTipoAmostra());
        String logOperacao = String.format("\t Solicitante: %s, Data_Hora_Solicitacao: %s , Nivel: %s \n", getSolicitante(), getDataHoraSolicitacao(),calcularPrioridade());
        String tecnicalidades = String.format("\t Enfermeiro: %s \n Custo: %s", isRiscoBiologico(), calcularCusto());
        String veiculo =String.format("\t Veiculo designado: %s ", getVeiculo() != null ? getVeiculo().getModelo() : "Não designado");
        
        return titulo + informacaoMedicamento + logOperacao + tecnicalidades + obterDescricaoRastreamento() + veiculo;
    }

    @Override
    public double calcularCusto() {

        double custo = 30 + (getDistanciaKm() * 2);
        if (nivelUrgencia == Urgencia.ALTA) {
            custo += 40;       
        }
        if (nivelUrgencia == Urgencia.CRITICA) {
            custo += 80;        
        }
        if (riscoBiologico) {
            custo += 50;
        }
        if (prazoMinDuration != null && prazoMinDuration.compareTo(Duration.ofMinutes(60)) < 0) {
            custo += 25;
        }
        return custo;
    }


    private static final Map<Urgencia, Integer> prioridades = new EnumMap<>(Urgencia.class);

    static {
        prioridades.put(Urgencia.BAIXA, 1);
        prioridades.put(Urgencia.MEDIA, 2);
        prioridades.put(Urgencia.ALTA, 3);
        prioridades.put(Urgencia.CRITICA, 4);
    }

    @Override
    public int calcularPrioridade() {
        return prioridades.getOrDefault(this.nivelUrgencia, 1);
    }

    @Override
    public String obterDescricaoRastreamento() {
        return String.format("Transporte da Amostra Biologica: %s, partindo de %s para %s - Distancia: %s Km",getTipoAmostra(), getOrigem(), getDestino(), getDistanciaKm()); 
    }

    @Override
    public boolean validar() {
        
        if (getVeiculo() == null) {
            return false;
        }if (riscoBiologico && !equipeContem(TipoProfissional.ENFERMEIRO)) {
            return false;
        }
        if (nivelUrgencia == Urgencia.CRITICA && !equipeContem(TipoProfissional.MOTORISTA)) {
            return false;
        }
    
        return true;
    }
    
}
