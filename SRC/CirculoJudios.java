public class CirculoJudios{
    /**
     * Lista circular para los judios.
     */
    private ListaCircular judios;

    /**
     * Variable para saber si la lista tiene nombres.
     */
    private boolean conNombres = false;

    /**
     * Constructor que recibe el número de judios.
     * @param numJudios la cantidad de judios.
     */
    public CirculoJudios(int numJudios){
        judios = new ListaCircular();
        int cont = 0;
        while (cont<numJudios){
            judios.insertar(cont++);
        }
    }

    /**
     * Constructor que recibe los nombres de los judios.
     * @param nombres un arreglo con los nombres.
     */
    public CirculoJudios(String[] nombres){
        judios = new ListaCircular();
        int cont = 0;
        while (cont<nombres.length){
            judios.insertar(nombres[cont++]);
        }
        conNombres = true;
    }

    /**
     *Método para resolver el ejercicio1.
     *@param salto el número de lugares que se saltan para ejecutar a un judio.
     */
    public void mata(int salto){
        java.util.Iterator j = judios.elementos(-1);
        int cont = 0;
        int ejecucion = 1;
        int tamanioOriginal = judios.getSize();
        while(j.hasNext()){
            j.next();
            cont++;
            if (cont==salto){
                if (ejecucion<tamanioOriginal){
                    if (conNombres)
                        System.out.print("En la ejecución " + ejecucion +
                                         " murió ");
                    else
                        System.out.print("En la ejecución " + ejecucion +
                                         " murió la persona en la posición " );
                }else
                    if (conNombres)
                        System.out.println("Sobrevivió " + j.next());
                    else
                        System.out.println("Sobrevivió la persona en el lugar "
                                           + j.next());
                j.remove();
                cont=1;
                ejecucion++;
            }
        }
    }

    /**
     *Método para resolver el ejercicio2.
     */
    public void mata(){
        java.util.Iterator j = judios.elementos(-1);
        int cont = 0;
        int ejecucion = 1;
        int tamanioOriginal = judios.getSize();
        while(j.hasNext()){
            j.next();
            cont++;
            if (cont >= (int) (Math.random() * judios.getSize())){
                if (ejecucion<tamanioOriginal){
                    if (conNombres)
                        System.out.print("En la ejecución " + ejecucion +
                                         " murió ");
                    else
                        System.out.print("En la ejecución " + ejecucion +
                                         " murió la persona en la posición " );
                }else
                    if (conNombres)
                        System.out.println("Sobrevivió " + j.next());
                    else
                        System.out.println("Sobrevivió la persona en el lugar "
                                           + j.next());
                j.remove();
                cont=1;
                ejecucion++;
            }
        }
    }

}
