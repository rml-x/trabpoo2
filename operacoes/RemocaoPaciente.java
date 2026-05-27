package operacoes;

import java.time.LocalDateTime;

import enums.NivelClinico;

public class RemocaoPaciente extends OperacaoClinica{

    private String NomePaciente;
    private int idade;
    private NivelClinico Nivel;
    private boolean PrecisaOxigenio;
    private boolean PrecisaUtiMovel;
    private boolean PrecisaMedicoAcompanhante;

    public RemocaoPaciente(int codigo, String origem, String destino, double distanciaKm, String solicitante,
    LocalDateTime dataHoraSolicitacao) {
        
        super(codigo, origem, destino, distanciaKm, solicitante, dataHoraSolicitacao);
    }

    @Override
    public String gerarLogAuditoria() {

    }

    @Override
    public double calcularCusto() {

    }

    @Override
    public int calcularPrioridade() {

    }

    @Override
    public String obterDescricaoRastreamento() {

    }

    @Override
    public boolean validar() {
        
    }



}
