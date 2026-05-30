package operacoes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import enums.Status;
import enums.TipoProfissional;
import interfaces.*;
import profissional.Profissional;
import veiculos.Veiculo;

public abstract class OperacaoClinica implements Validavel, Custeavel, Auditavel, Priorizavel, Rastreavel {
    private int codigo; // pq n usar UID?
    private String origem;
    private String destino;
    private double distanciaKm;
    private String solicitante;
    private LocalDateTime dataHoraSolicitacao;
    private Status status;
    private Veiculo veiculo;
    private List<Profissional> equipe;


    //construtor
    public OperacaoClinica(int codigo, String origem, String destino,
        double distanciaKm, String solicitante, LocalDateTime dataHoraSolicitacao){

        this.codigo = codigo;
        this.origem = origem;
        this.destino = destino;
        this.distanciaKm = distanciaKm;
        this.solicitante = solicitante;
        this.dataHoraSolicitacao = dataHoraSolicitacao;

        //especiais
        this.status = Status.SOLICITADA;
        this.veiculo = null;
        this.equipe = new ArrayList<>();
    }

    //getters
    public int getCodigo(){
        return codigo;
    }
    public String getOrigem(){
        return origem;
    }
    public String getDestino(){
        return destino;
    }
    public double getDistanciaKm(){
        return distanciaKm;
    }
    public String getSolicitante(){
        return solicitante;
    }
    public LocalDateTime getDataHoraSolicitacao(){
        return dataHoraSolicitacao;
    }
    public Status getStatus(){
        return status;
    }
    public Veiculo getVeiculo(){
        return veiculo;
    }
    public List<Profissional> getEquipe(){
        return Collections.unmodifiableList(equipe);
    }

    //setters
    public void designarVeiculo(Veiculo veiculo){
        if (veiculo.isDisponivel()) {
            veiculo.ocupar();
        } else {
            throw new RuntimeException("Não é possivel designar o veiculo pedido");
        }
    }
    
    public void adicionarProfissional(Profissional p) {
        equipe.add(p);
    }

    //metodos 
    public void aprovar(){
        if(status == Status.SOLICITADA){
            status = Status.APROVADA;
        }
        else {
            throw new RuntimeException("Operação não pode ser aprovada no estado atual");
        }
    }
    public void iniciar(){
        if (status == Status.APROVADA && validar()) {
            status = Status.EM_EXECUCAO;
        } else {
            throw new RuntimeException("Operação não pode ser iniciada no estado atual");

        }

    }

    public void concluir(){
        if (status == Status.EM_EXECUCAO) {
            status = Status.CONCLUIDA;
        } else {
            throw new RuntimeException("Operação não pode ser concluida no estado atual");
        }
    }
    public void cancelar(){
        if (status != Status.CONCLUIDA) {
            status = Status.CANCELADA;
        } else {
            throw new RuntimeException("Operação não pode ser cancelada no estado atual");
        }
    }

    //auxiliar validação
    protected boolean equipeContem(TipoProfissional tipo){
        
        for (Profissional p  : getEquipe()){

            if (p.getTipoProfissional() == tipo) {
                return true;
            }  
        }
        return false;
    }

    //heranças para subclasses 
    public abstract String gerarLogAuditoria();
    public abstract double calcularCusto();
    public abstract int calcularPrioridade();
    public abstract String obterDescricaoRastreamento();
    public abstract boolean validar();




}






