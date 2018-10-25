
public class ListaCircular {

    /**
     * Nodo que representa el inicio de la lista
     */
    private Nodo inicio;
    /**
     * Nodo que representa el fin de la lista
     */
    private Nodo fin;
    /**
     * Numero que representa el tamaño de la lista
     */
    private int nElementos;

    /**
     * Constructor que no recibe parametros.
     * Inicializa a inicio con null
     * Inicializa nElementos con cero
     */
    public ListaCircular() {
      inicio = null;
      nElementos=0;
    }

    /**
     * Metodo que determina si la lista esta o no vacia
     * @return boolean true si la lista esta vacia y false en otro caso
     */
    public boolean estaVacia() {
      return (inicio ==null);
    }

    /**
     * Inserta el primer elemento de la lista
     * @param obj - Elemento que sera insertado en la lista
     */
    public void insertar(Object obj) {
      if(obj!=null){
        if(inicio == null){
          inicio= new Nodo(obj);
          fin = inicio;
          inicio.sgte= inicio;
        }else{
          fin.sgte= new Nodo(obj);
          fin = fin.sgte;
          fin.sgte= inicio;
      }
        nElementos++;
      }
    }

    /**
     * Devuelve el tamaño de la lista
     * @return int - valor del tamaño de la lista
     */
    public int getSize() {
      return nElementos;
    }

    /**
     * Método que devuelve un Iterador con todos los elementos de la Lista.
     * @return Iterador con todos los elementos de la Lista.
     */
    public java.util.Iterator elementos(int inicio) {
        return new IteradorListaCircular(inicio);
    }


    private class IteradorListaCircular implements java.util.Iterator{

      private Nodo posicion;
      private Nodo posicionAnterior;

      public IteradorListaCircular(int ini){
        posicion = inicio;
        posicionAnterior= null;
        for(int i=0;(posicion!= null && i<ini);i++){
          posicion = posicion.sgte;
        }
      }
        /**
         * Metodo que determina si el Iterador tiene o no elementos que aun falten por iterar
         * @return true - Si todavia hay elementos por iterar, -faslse, en otro caso.
         */

        @Override
        public boolean hasNext() {
          return posicion != null;
        }

        /**
         * Metodo que obtiene el siguiente elemento en nuestro Iterador
         * @return Object - El siguiente elemento en el iterador
         */

        @Override
        public Object next() {
          if(hasNext()){
            posicionAnterior = posicion;
            posicion = posicion.sgte;
            return posicion.elemento;
          }
          throw new java.util.NoSuchElementException("Ya no  hay mas elementos que explorar");
        }

        /**
         * Metodo para eliminar un elemento de Iterador
         */

        @Override
        public void remove() {
          if(posicionAnterior == null)
            throw new IllegalStateException("No se puede eliminar sin antes buscarlo");
          if(posicion == null){
             throw new IllegalStateException("No hay mas elementos por eliminar");
          }else{
            if(posicion == posicionAnterior){
              posicion = null;
            }else{
              System.out.println(posicionAnterior.sgte.daElemento().toString());
              posicion= posicion.sgte;
              posicionAnterior.sgte = null;
              posicionAnterior.sgte = posicion;
            }
            nElementos--;
        }
        }
    }
}
