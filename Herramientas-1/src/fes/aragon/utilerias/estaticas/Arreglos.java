package fes.aragon.utilerias.estaticas;
import java.util.Random;

import fes.aragon.excep.IndiceFueraDeRango;

/**
 * Clase que tiene funciones para ocupar arreglos de tipo Integer
 * 
 * @author Jibda
 *
 */
public class Arreglos<E> { //<E> se convierte en el tipo que se asigne cuando se instancia el objeto
	private int indice=0;
	private int siguiente=-1;
	private final Object[] l; //final -> constante
	
	public Arreglos(int numeroElementos) {
		this.l = new Object[numeroElementos];
	}
	
	/**
	 * Método que inserta un valor de tipo Integer consecutivo
	 * 
	 * @param x es el parámetro que se recibe para agregar a la lista
	 * @throws IndiceFueraDeRango exepción que pasa cuando nos salimos fuera del
	 * 		índice
	 * 
	 */
	public void insertar(E x) throws IndiceFueraDeRango{
		if(indice < l.length) {
			l[indice] = x;
			indice++;
		}else {
			throw new IndiceFueraDeRango("Indice fuera de rango");
		}
	}

	/**
	 * Método que localiza un valor en la lista, retornan el índice
	 * 
	 * @param x valor Integer que se busca en la lista
	 * @return se retorna -l si no esta el valor en la lista, en caso contrario se
	 * 		retorna el índice
	 */
	public Integer localiza(E x) {
		for(int i=0; i<l.length; i++) {
			if(l[i].equals(x)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Método que recupera un elemento en el índice indicado
	 * 
	 * @param p entero que indica el índice del elemento a devolver
	 * @return E que se retorna, tomando la posición siguiente que se
	 * 		da como parámetro
	 * @throws IndiceFueraDeRango excepción que se arroja cuando el índice p está
	 * 		fuera de los rangos del arreglo
	 */
	public E recupera(int p)throws IndiceFueraDeRango{
		if(p >= l.length || p<0) {
			throw new IndiceFueraDeRango("Indice fuera de rango");
		} else {
			@SuppressWarnings("unchecked")
			final E e=(E)l[p]; //casheo
			return e;
		}
	}
	
	/**
	 * Método que elimina un elemento en el índice indicado
	 * 
	 * @param p entero que indica el indice del elemento a eliminar
	 * @throws IndiceFueraDeRango excepción que se arroja cuando el índice p esta
	 * 		fuera de los rangos del arreglo
	 */
	public void suprime(int p) throws IndiceFueraDeRango{
		if(p >= l.length || p<0) {
			throw new IndiceFueraDeRango("Indice fuera de rango");
		} else {
			l[p] = null;
		}
	}
	
	/**
	 * Método que da el elemento siguietne de la posición que nos indica
	 * 
	 * @param p entero que indica el indice del elemento a devolver
	 * @return E que se retorna, tomando la posición siguiente que se
	 * 		da como parametro
	 * @throws IndiceFueraDeRango excepción que se arroa cuando el indice p está
	 * 		fuera de los rangos del arreglo
	 */
	public E siguiente(int p) throws IndiceFueraDeRango{
		if(p==l.length||p<-1) {
			throw new IndiceFueraDeRango("Indice fuera de rango");
		}
		@SuppressWarnings("unchecked")
		final E e=(E)l[p+1];
		return e;
	}
	
	/**
	 * Método que da el elemento siguiente
	 * 
	 * @return E que se retorna, tomando la posición siguiente que se
	 * 		da en la variable de clase "siguiente".
	 */
	public E siguienteII(){
		@SuppressWarnings("unchecked")
		final E e=(E)l[siguiente+1];
		siguiente++;
		return e;
	}
	/**
	 * Método que da el elemento anterior de la posición que nos indica
	 * 
	 * @param p entero que indica el indice del elemento a devolver
	 * @return Integer que se retorna Integer tomando la posición anterior que se da
	 * 		como parámetro
	 * @throws IndiceFueraDeRango excepción que se arroja cuando el índice p está
	 * 		fuera de los rangos del arreglo
	 */
	public E anterior(int p) throws IndiceFueraDeRango{
		if(p >= l.length || p<=0) {
			//si arroja excepción ya no ejecuta demás código
			throw new IndiceFueraDeRango("Indice fuera de rango");
		}
		@SuppressWarnings("unchecked")
		final E e=(E)l[p-1];
		return e;
	}
	
	/**
	 * Método que limpia el arreglo de Enteros
	 * 
	 */
	public void limpiar() {
		for(int i=0;i<l.length; i++) {
			l[i]=null;
		}
	}
	
	/**
	 * Método que regresa el primer elemento del arreglo, si no existe regresa un
	 * null
	 * 
	 * @return retorna E o null del primer elemento del arreglo
	 */
	public E primero() {
		@SuppressWarnings("unchecked")
		final E e=(E)l[0];
		return e;
	}
	
	/**
	 * Método que devuelve la longitud del arreglo
	 * @return un entero que es la longitud del arreglo
	 */
	public Integer longitud() {
		return l.length;
	}
	
	/**
	 * Método que imprime todos los valores del arreglo
	 */
	public void imprime() {
		for(int i=0; i <l.length;i++) {
			System.out.print(l[i]+"\n");
		}
		System.out.println();
	}
	
	/**
	 * Método que asignara un valor en la posición indicada
	 * @param p entero que indica la posición donde se inserta el valor del arreglo
	 * @param x valor que se insertara en la posicion que se indica en p
	 * @throws IndiceFueraDeRango excepción que sucede cuando no estamos en el rango
	 */
	public void asignar(int p,E x) throws IndiceFueraDeRango{
		if(p>l.length||p<0) {
			throw new IndiceFueraDeRango("Indice fuera de rango");
		} else {
			l[p]=x;
		}
	}
	
	/**
	 * Método que devuelve el valor máximo en un arreglo de enteros
	 * @return Integer que se retorna, el valor máximo del arreglo
	 */
	public Integer maximo(){
		Integer auxMax = 0,tempMax;
		
		for (int i = 0; i < l.length; i++) {
			tempMax = (Integer)l[i];
			if (tempMax > auxMax) {
				auxMax = tempMax;
			}
		}
		
        return auxMax;
    }
	
	/**
	 * Método que devuelve el promedio de valores en un arreglo de enteros
	 * @return Integer que se retorna, el promedio de valores del arreglo
	 */
    public Integer promedio() {
        Integer sum = 0, aux, prom;
		
		for (int i = 0; i < l.length; i++) {
			aux = (Integer)l[i];
			sum = aux + sum;
		}
		
		prom = sum/l.length;
        
		return prom;
    }

	/**
	 * Método que devuelve el valor mínimo de un arreglo de enteros
	 * @return Integer que se retorna, el valor mínimo del arreglo
	 */
    public Integer minimo() {
    	Integer auxMin = 0,tempMin;
		
		for (int i = 0; i < l.length; i++) {
			tempMin = (Integer)l[i];
			if (tempMin < auxMin) {
				auxMin = tempMin;
			}
		}
		
        return auxMin;
    }
    
    /**
	 * Método que añade valores a un arreglo, dandole un intervalo de los mismos
     * @throws IndiceFueraDeRango 
	 */
    public void intervalo(int lI,int lS) throws IndiceFueraDeRango {
        // Li Ls for Li Ls for i<Li >Ls i++
    	Integer auxInt = 0;
    	Random rd = new Random();
    	
    	for (int i = 0; i < l.length ;i++) {
    		auxInt = rd.nextInt(lS - lI + 1) + lI;			
			if(indice < l.length) {
				l[indice] = auxInt;
				indice++;
			}else {
				throw new IndiceFueraDeRango("Indice fuera de rango");
			}
		}
    }

    /**
	 * Método que ordena un arreglo
	 */
    @SuppressWarnings("unchecked")
	public void ordenar(){
    	Integer i,j,temp;
    	
    	for(i=1;i<l.length;i++) {
    		for(j=0;j<i;j++) {
    			if((Integer)l[i] < (Integer)l[j]) {
    				temp = (Integer)l[j];
    				l[j] = (E)l[i];
    				l[i] = (E)temp;
    			}
    		}
    	}
    }
    
    /**
	 * Método que devuelve el valor central de un arreglo
	 * @return Integer con el valor medio del arreglo
	 */
    @SuppressWarnings("unchecked")
	public Integer mediana(){
    	Integer i,j,temp;
    	
    	for(i=1;i<l.length;i++) {
    		for(j=0;j<i;j++) {
    			if((Integer)l[i] < (Integer)l[j]) {
    				temp = (Integer)l[j];
    				l[j] = (E)l[i];
    				l[i] = (E)temp;
    			}
    		}
    	}
    	
    	return (Integer) l[(l.length)/2];
    }
}
