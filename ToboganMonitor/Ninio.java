package ToboganMonitor;

import java.util.ArrayList;
import java.util.Iterator;

public class Ninio extends Thread{
	
	private int edad;
	private int nombre;
	private ArrayList<TramoTobogan> tobogan;
	
	public void run(){
		int i = 0;
		TramoTobogan tActual = tobogan.get(0);
		TramoTobogan tSiguiente = tobogan.get(1);
		try {
			tActual.pidoTurno(this);
			while (i < tobogan.size()) {
				tActual.estar(this);
				if(i < tobogan.size()-1){
					tSiguiente.pidoTurno(this);
				}
				tActual.salir(this);
				i++;
				if(i < tobogan.size()){
					tActual = tobogan.get(i);
				}
				if(i < tobogan.size()-1){
					tSiguiente = tobogan.get(i+1);
				}
			}
		} catch (Exception e) {System.out.println("Error");}
		System.out.println("---El niño " + this.nombre + " ha terminado!");
	}
	
	//No es la mejor forma de implementarlo, seguro.
	public void addTramo(TramoTobogan t){
		tobogan.add(t);
	}
	
	public Ninio(int e, int n){
		setEdad(e);
		setNombre(n);
		this.tobogan = new ArrayList<TramoTobogan>();
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

}
