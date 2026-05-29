package operacoes;

import java.time.Duration;
import java.time.LocalDateTime;

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

    public String geTipoAmostra(){ return tipoAmostra;}
    public Urgencia getNivelUrgencia(){return nivelUrgencia;}
    public boolean isRiscoBiologico(){return riscoBiologico;}
    public Duration getPrazoMinDuration(){return prazoMinDuration;}


    @Override
    public String gerarLogAuditoria() {

        String titulo = String.format(" Relatorio Transporte de Amostra Biologica - Codigo: %s - Status: %s \n", getCodigo(), getStatus());
        String informacaoMedicamento = String.format("\t Tipo da Amostra: %s \n", geTipoAmostra());
        String logOperacao = String.format("\t Solicitante: %s, Data_Hora_Solicitacao: %s , Nivel: %s \n", getSolicitante(), getDataHoraSolicitacao(),calcularPrioridade());
        String tecnicalidades = String.format("\t Enfermeiro: %s \n Custo: %s", calcularCusto());
        //TODO:por enfermeiro
        String veiculo =String.format("\t Veiculo designado: %s ", getVeiculo() != null ? getVeiculo().getModelo() : "Não designado");
        
        return titulo + informacaoMedicamento + logOperacao + tecnicalidades + obterDescricaoRastreamento() + veiculo;
    }

    @Override
    public double calcularCusto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularCusto'");
    }

    @Override
    public int calcularPrioridade() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularPrioridade'");
    }

    @Override
    public String obterDescricaoRastreamento() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obterDescricaoRastreamento'");
    }

    @Override
    public boolean validar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validar'");
    }
    
}
