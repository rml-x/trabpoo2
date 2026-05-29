package operacoes;

import java.time.LocalDateTime;

import enums.TipoProfissional;


public class TransporteEquipamentoMedico extends OperacaoClinica{
    private String nomeEquipamento;
    private double pesoEquipamentoKg;
    private double valorEstimado;
    private boolean exigeTecnico;
    private boolean exigeSeguro;

    public TransporteEquipamentoMedico(int codigo, String origem, String destino, double distanciaKm,
            String solicitante, LocalDateTime dataHoraSolicitacao, String nomeEquipamento, double pesoEquipamentoKg, double valorEstimado, boolean exigeTecnico, boolean exigeSeguro) {

        super(codigo, origem, destino, distanciaKm, solicitante, dataHoraSolicitacao);
        
        this.nomeEquipamento = nomeEquipamento;
        this.pesoEquipamentoKg = pesoEquipamentoKg;
        this.valorEstimado = valorEstimado;
        this.exigeTecnico = exigeTecnico;
        this.exigeSeguro = exigeSeguro;
    }

    public String getNomeEquipamento(){ return nomeEquipamento; }
    public double getPesoEquipamentoKg(){ return pesoEquipamentoKg; }
    public double getValorEstimado(){ return valorEstimado; }
    public boolean isExigeTecnico(){ return exigeTecnico; }
    public boolean isExigeSeguro(){ return exigeSeguro; }

    @Override
    public String gerarLogAuditoria() {
        String titulo = String.format(" Relatorio Transporte de Equipamento Médico - Codigo: %s - Status: %s \n", getCodigo(), getStatus());
        String inforcacaoEquipamento = String.format("\t Nome Equipamento: %s \n", getNomeEquipamento());
        String logOperacao = String.format("\t Solicitante: %s, Data_Hora_Solicitacao: %s , Nivel: %s \n", getSolicitante(), getDataHoraSolicitacao(),calcularPrioridade());
        String tecnicalidades = String.format("\t Tecnico: %s , Seguro: %s \n Custo: %s", isExigeTecnico(), isExigeSeguro(), calcularCusto());
        String veiculo =String.format("\t Veiculo designado: %s ", getVeiculo() != null ? getVeiculo().getModelo() : "Não designado");
        
        return titulo + inforcacaoEquipamento + logOperacao + tecnicalidades + obterDescricaoRastreamento() + veiculo;
    }

    @Override
    public double calcularCusto() {

        double custo = 50 + (getDistanciaKm() * 1.2);
        if (pesoEquipamentoKg > 100.00) {
            custo += 60;       
        }
        if (isExigeTecnico()) {
            custo += 70;        
        }
        if (isExigeSeguro()) {
            custo += 0.02 * valorEstimado;
           
        }
        return custo;
    }

    @Override
    public int calcularPrioridade() {
        int nivel = 1;
        if (isExigeSeguro()) nivel += 1;
        if (isExigeTecnico()) nivel += 2;
        return nivel;
    }

    @Override
    public String obterDescricaoRastreamento() {
        return String.format("Transporte da Equipamento Medico: %s, partindo de %s para %s - Distancia: %s Km",getNomeEquipamento(), getOrigem(), getDestino(), getDistanciaKm()); 

    }

    @Override
    public boolean validar() {

        if (getVeiculo() ==  null) {
            return false;
            
        }if (pesoEquipamentoKg > 100 && getVeiculo().getCapacidadeKg() < pesoEquipamentoKg ){
            return false;
        }if(exigeTecnico && !equipeContem(TipoProfissional.TECNICO_EQUIPAMENTO)){
            return false;
        }

        return true;

    }

}
