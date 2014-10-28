package ToboganMonitor;


public class TramoTobogan {
	
	private Ninio ninio;
	private String nombreTramo;
	private int tiempoMinimo;
	private int tiempoMaximo;
	
	public TramoTobogan(String nombre, int tmin, int tmax){
		this.nombreTramo = nombre;
		this.tiempoMinimo = tmin;
		this.tiempoMaximo = tmax;
	}
	
	public Ninio getNinio(){
		return this.ninio;
	}
	
	public void setNinio(Ninio n) throws Exception{
		if(this.ninio == null){
			this.ninio = n;
		}
	}
	
	public 	boolean estaLibre(){
		return this.ninio == null;
	}
	
	public synchronized void pidoTurno(Ninio n) throws Exception{
		while(!this.estaLibre()){
			wait();
		}
		this.setNinio(n);
	}
	
	public void estar(Ninio n) throws Exception{
		System.out.println("El niño " + this.ninio.getNombre() + 
				" con " + this.ninio.getEdad() + 
				" está en " + this.nombreTramo + ".");
		
		Thread.sleep((long) (Math.random() * 1000 * (this.tiempoMaximo - this.tiempoMinimo) + this.tiempoMinimo)); 
	}
	public synchronized void salir(Ninio n) throws Exception{
		//System.out.println("El niño " + this.ninio.getNombre() +
		//		" sale del " + this.nombreTramo);
		notify();
		this.ninio = null;
		int a = 0;
	}
}
