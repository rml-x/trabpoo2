package operacoes;

import java.time.LocalDateTime;

public class TransporteMedicamento extends OperacaoClinica{
    private String nomeMedicamento;
    private boolean precisaRefrigerar;
    private double temperaturaMin;
    private double temperaturaMax;
    private boolean precisaAutorizacaoFarmaceutica;

    public TransporteMedicamento(int codigo, String origem, String destino, double distanciaKm, String solicitante,
    LocalDateTime dataHoraSolicitacao ,String nomeMedicamento, boolean precisaRefrigerar, double temperaturaMin, double temperaturaMax, boolean precisaAutorizacaoFarmaceutica){
       
        super(codigo, origem, destino, distanciaKm, solicitante, dataHoraSolicitacao);
        this.nomeMedicamento = nomeMedicamento;
        this.precisaRefrigerar = precisaRefrigerar;
        this.temperaturaMin = temperaturaMin;
        this.temperaturaMax = temperaturaMax;
        this.precisaAutorizacaoFarmaceutica = precisaAutorizacaoFarmaceutica;

    }

    @Override
    public String gerarLogAuditoria() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gerarLogAuditoria'");
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
