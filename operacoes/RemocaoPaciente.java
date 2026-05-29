package operacoes;

import java.time.LocalDateTime;
import java.util.EnumMap;
import java.util.Map;

import enums.NivelClinico;
import enums.TipoProfissional;

public class RemocaoPaciente extends OperacaoClinica{

    private String nomePaciente;
    private int Idade;
    private NivelClinico nivel;
    private boolean precisaOxigenio;
    private boolean precisaUtiMovel;
    private boolean precisaMedicoAcompanhante;

    public RemocaoPaciente(int codigo, String origem, String destino, double distanciaKm, String solicitante,
    LocalDateTime dataHoraSolicitacao, String nomePaciente, int Idade, NivelClinico nivel, boolean precisaOxigenio, boolean precisaUtiMovel, boolean precisaMedicoAcompanhante) {
        
        super(codigo, origem, destino, distanciaKm, solicitante, dataHoraSolicitacao);
        this.nomePaciente = nomePaciente;
        this.Idade = Idade;
        this.nivel = nivel;
        this.precisaMedicoAcompanhante = precisaMedicoAcompanhante;
        this.precisaOxigenio = precisaOxigenio;
        this.precisaUtiMovel = precisaUtiMovel;
    }


    public String getnomePaciente(){
        return nomePaciente;
    }
    public int getIdade(){
        return Idade;
    }
    public NivelClinico getnivel(){
        return nivel;
    }
    public boolean isPrecisaOxigenio(){
        return precisaOxigenio;
    }
    public boolean isPrecisaUtiMovel(){
        return precisaUtiMovel;
    }
    public boolean isPrecisaMedicoAcompanhante(){
        return precisaMedicoAcompanhante;
    }

    @Override
    public String gerarLogAuditoria() {
        String titulo = String.format("Relatorio Remoção Paciente - Codigo: %s  - Status: %s \n", getCodigo(), getStatus());
        String informacaoPaciente = String.format("\t Paciente: %s , Idade: %d \n",getnomePaciente(), getIdade());
        String logOperacao = String.format("\t Solicitante: %s, Data_Hora_Solicitacao: %s \n", getSolicitante(), getDataHoraSolicitacao());
        String tecnicalidades = String.format("\t Nivel: %s, Oxigenio: %s \n UTI Movel: %s, Medico Acompanhante: %s, Custo: %s", getnivel(), isPrecisaOxigenio(), isPrecisaUtiMovel(),isPrecisaMedicoAcompanhante(), calcularCusto());
        String veiculo =String.format("\t Veiculo designado: %s ", getVeiculo() != null ? getVeiculo().getModelo() : "Não designado");
        return titulo + informacaoPaciente + logOperacao + obterDescricaoRastreamento() + veiculo + tecnicalidades;
    }

    @Override
    public double calcularCusto() {
        double custo = 100 + (getDistanciaKm() * 4);
        if (precisaOxigenio) {
            custo += 30;       
        }if (precisaUtiMovel){
            custo += 150;        
        }if (precisaMedicoAcompanhante){
            custo += 120;
        }
        return custo;
    }

    private static final Map<NivelClinico, Integer> prioridades = new EnumMap<>(NivelClinico.class);

    static {
        prioridades.put(NivelClinico.ESTAVEL, 1);
        prioridades.put(NivelClinico.OBSERVACAO, 2);
        prioridades.put(NivelClinico.GRAVE, 3);
        prioridades.put(NivelClinico.CRITICO, 4);
    }

    @Override
    public int calcularPrioridade() {
    
        return prioridades.getOrDefault(this.nivel, 1);
    
    }

    @Override
    public String obterDescricaoRastreamento() {
        return String.format("Remoção do paciente %s, partindo de %s para %s - Distancia: %s Km", getnomePaciente(), getOrigem(), getDestino(), getDistanciaKm()); 
    }

    @Override
    public boolean validar() {

        if (getVeiculo() == null) {
            return false;
        }
        if (precisaUtiMovel && !getVeiculo().isUTI()) {
            return false;
        }
        if(precisaOxigenio && !getVeiculo().temOxigenio()){
            return false;
        }
        if ((nivel == NivelClinico.CRITICO || nivel == NivelClinico.GRAVE) && !equipeContem(TipoProfissional.MEDICO)) {
            return false;
        }
        if (nivel == NivelClinico.CRITICO && !precisaUtiMovel && !precisaMedicoAcompanhante) return false;
    
        return true;
    }



}
