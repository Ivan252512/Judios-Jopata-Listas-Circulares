import java.util.Scanner;

public class Tarea2{
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        while (true){
            System.out.println("¿Qué quieres hacer?, escoge un número: " );
            System.out.println("1) Ejercicio 1." );
            System.out.println("2) Ejercicio 2." );
            System.out.println("3) Punto extra." );
            int ejercicio=4;
            try{
                while (true){
                    ejercicio = entrada.nextInt();
                    if (ejercicio>0 && ejercicio<4)
                        break;
                    else
                        System.out.println("El número debe estar entre 1 y 3");
                }
            }catch (NumberFormatException e) {
                System.out.println("No es un número");
            }
            while (true){
                try {
                    if (ejercicio<3){
                        System.out.println("Introduce el número de personas:" );
                        int personas = entrada.nextInt();
                        //Ejercicio 1
                        if (ejercicio==1){
                            CirculoJudios circ1 = new CirculoJudios(personas);
                            circ1.mata(2);
                            break;
                        }
                        //Ejercicio 2
                        else if (ejercicio==2){
                            CirculoJudios circ2 = new CirculoJudios(personas);
                            circ2.mata();
                            break;
                        }
                    }
                    //Punto extra.
                    /* Nombres. */
                    String[] nombres = {
                        "Aaron", "Benito", "Carlos", "Daniel", "Ernesto",
                        "Fernando", "Gerardo", "Hernán", "Inmaculada", "Juan"
                    };
                    CirculoJudios CircNombres = new CirculoJudios(nombres);
                    CircNombres.mata(2);
                    break;
                }catch (NumberFormatException e) {
                    System.out.println("No es un número");
                }
            }
            System.out.println("¿Desea salir? 1 para sí, cualquier número para"
                               + " no." );
            try{
                if (entrada.nextInt()==1)
                    break;
            }catch (NumberFormatException e) {
                System.out.println("No es un número");
            }
        }
    }
}
