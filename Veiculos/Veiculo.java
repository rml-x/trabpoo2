package veiculos;
public abstract class Veiculo {
   private String placa;
   private String modelo;
   private double capacidadeKg;
   private boolean disponivel;

   public Veiculo(String placa, String modelo, double capacidadeKg){
        this.placa = placa;
        this.modelo = modelo;
        this.capacidadeKg = capacidadeKg;
        this.disponivel = true;
    }

    //getters
    public String getModelo(){
        return modelo;
    }
    public String getPlaca(){
        return placa;
    }
    public double getCapacidadeKg(){
        return capacidadeKg;
    }
    public boolean isDisponivel(){
        return disponivel;
   }


    //metodos
   public void ocupar() {
        disponivel = false;
   }
   public void liberar(){
        disponivel =  true;
   }
   


}