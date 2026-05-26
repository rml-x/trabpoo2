abstract class Veiculo {
   private String placa;
   private String modelo;
   private int capacidadeKg;
   boolean disponivel;

   public Veiculo(String placa, String modelo, int capacidadeKg){
        this.placa = placa;
        this.modelo = modelo;
        this.capacidadeKg = capacidadeKg;
        this.disponivel = true;
    }

   public void ocupar() {
    
   }


}