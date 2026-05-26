abstract class Veiculo {
   private String placa;
   private String modelo;
   private int capacidadeKg;
   private boolean disponivel;

   public Veiculo(String placa, String modelo, int capacidadeKg){
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
    public int getCapacidadeKg(){
        return capacidadeKg;
    }


    //metodos
   public void ocupar() {
        disponivel = false;
   }
   public void liberar(){
        disponivel =  true;
   }
   public boolean isDisponivel(){
        return disponivel;
   }


}