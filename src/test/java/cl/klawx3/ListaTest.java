package cl.klawx3;

import org.junit.Test;

import cl.klawx3.datastructure.listo_r.Nodo;

public class ListaTest {



    @Test
    public void pruebaLista(){
        Nodo nodoFinal = new Nodo();
        nodoFinal.valor = 999;

        Nodo otroNodo = new Nodo();
        otroNodo.valor = 100;
        otroNodo.siguiente = nodoFinal;

        Nodo base = new Nodo();
        base.valor = 0;
        base.siguiente = otroNodo;

        Nodo aux = base;
        while(aux != null){
            System.out.println(aux.valor);
            aux = aux.siguiente;
        }
    
    }
    
}
