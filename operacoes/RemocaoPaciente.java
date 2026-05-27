package operacoes;

import java.time.LocalDateTime;

import enums.NivelClinico;

public class RemocaoPaciente extends OperacaoClinica{

    private String NomePaciente;
    private int Idade;
    private NivelClinico Nivel;
    private boolean PrecisaOxigenio;
    private boolean PrecisaUtiMovel;
    private boolean PrecisaMedicoAcompanhante;

    public RemocaoPaciente(int codigo, String origem, String destino, double distanciaKm, String solicitante,
    LocalDateTime dataHoraSolicitacao) {
        
        super(codigo, origem, destino, distanciaKm, solicitante, dataHoraSolicitacao);
    }


    public String getNomePaciente(){
        return NomePaciente;
    }
    public int getIdade(){
        return Idade;
    }
    public NivelClinico getNivel(){
        return Nivel;
    }
    public boolean isPrecisaOxigenio(){
        return PrecisaOxigenio;
    }
    public boolean isPrecisaUtiMovel(){
        return PrecisaUtiMovel;
    }
    public boolean isPrecisaMedicoAcompanhante(){
        return PrecisaMedicoAcompanhante;
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
