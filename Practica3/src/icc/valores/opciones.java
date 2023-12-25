package icc.valores;

public enum opciones {
    PIEDRA, PAPEL, TIJERA;

     private opciones (String ops){
       this.ops=ops;
     }
     public String getops (){
  
       return ops;
     }
  
     private String ops;
  }
