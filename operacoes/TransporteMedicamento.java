package operacoes;

import java.time.LocalDateTime;

import enums.TipoProfissional;

public class TransporteMedicamento extends OperacaoClinica{
    private String nomeMedicamento;
    private boolean precisaRefrigerar;
    private Double temperaturaMin;
    private Double temperaturaMax;
    private boolean precisaAutorizacaoFarmaceutica;

    public TransporteMedicamento(int codigo, String origem, String destino, double distanciaKm, String solicitante,
    LocalDateTime dataHoraSolicitacao ,String nomeMedicamento, boolean precisaRefrigerar, Double temperaturaMin, Double temperaturaMax, boolean precisaAutorizacaoFarmaceutica){
       
        super(codigo, origem, destino, distanciaKm, solicitante, dataHoraSolicitacao);
        this.nomeMedicamento = nomeMedicamento;
        this.precisaRefrigerar = precisaRefrigerar;
        this.temperaturaMin = temperaturaMin;
        this.temperaturaMax = temperaturaMax;
        this.precisaAutorizacaoFarmaceutica = precisaAutorizacaoFarmaceutica;

    }

    //getters
    public String getNomeMedicamento(){ return nomeMedicamento; }
    public boolean isPrecisaRefrigerar(){ return precisaRefrigerar;}
    public Double getTemperaturaMin(){return temperaturaMin;}
    public Double getTemperaturaMax(){return temperaturaMax;}
    public boolean isPrecisaAutorizacaoFarmaceutica(){return precisaAutorizacaoFarmaceutica;}


    @Override
    public String gerarLogAuditoria() {
        String titulo = String.format(" Relatorio Transporte de Medicamento Controlado - Codigo: %s - Status: %s \n", getCodigo(), getStatus());
        String informacaoMedicamento = String.format("\t Nome medicamento: %s \n", getNomeMedicamento());
        String logOperacao = String.format("\t Solicitante: %s, Data_Hora_Solicitacao: %s , Nivel: %s \n", getSolicitante(), getDataHoraSolicitacao(),calcularPrioridade());
        String tecnicalidades = String.format("\t Temperatura Range: %s - %s , Van Refrigerada: %s, Farmaceutico: %s \n Custo: %s", getTemperaturaMin(), getTemperaturaMax(), isPrecisaRefrigerar(), isPrecisaAutorizacaoFarmaceutica(), calcularCusto());
        String veiculo =String.format("\t Veiculo designado: %s ", getVeiculo() != null ? getVeiculo().getModelo() : "Não designado");
        
        return titulo + informacaoMedicamento + logOperacao + tecnicalidades + obterDescricaoRastreamento() + veiculo;
    }

    @Override
    public double calcularCusto() {

        double custo = 40 + (getDistanciaKm() * 2.5);
        if (precisaRefrigerar) {
            custo += 35;       
        }if (precisaAutorizacaoFarmaceutica){
            custo += 20;        
        }
        return custo;
    }

    @Override
    public int calcularPrioridade() {
        int nivel = 1;
        if (precisaRefrigerar) nivel += 2;
        if (precisaAutorizacaoFarmaceutica) nivel += 1;
        return nivel;
    }

    @Override
    public String obterDescricaoRastreamento() {
        return String.format("Transporte do Medicamento Controlado: %s, partindo de %s para %s - Distancia: %s Km",getNomeMedicamento(), getOrigem(), getDestino(), getDistanciaKm()); 
    }

    @Override
    public boolean validar() {
        
        if (getVeiculo() == null) {
            return false;
        }
        if(precisaRefrigerar && (temperaturaMax == null || temperaturaMin == null)){
            return false;
        }
        if(precisaRefrigerar &&  (!getVeiculo().temRefrigeracao() || !getVeiculo().temperaturaAdequada(temperaturaMin, temperaturaMax))){
            return false;
        }
        if(precisaAutorizacaoFarmaceutica && !equipeContem(TipoProfissional.FARMACEUTICO)){
            return false;
        }
        
        
        return true;
    }


}
