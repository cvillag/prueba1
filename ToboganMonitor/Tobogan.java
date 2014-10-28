package ToboganMonitor;

public class Tobogan{

	/**
	 * @param args
	 */
	public static final int NUM_NINIOS = 5;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TramoTobogan t1 = new TramoTobogan("Escalera", 2, 5);
		TramoTobogan t2 = new TramoTobogan("Preparando", 2, 3);
		TramoTobogan t3 = new TramoTobogan("Descender", 2, 2);
		TramoTobogan t4 = new TramoTobogan("Salir", 2, 2);
		
		for(int i = 0; i < NUM_NINIOS; i++){
			int edad = (int) (Math.random() * 8 + 2);
			Ninio n = new Ninio(edad, i);
			n.addTramo(t1);
			n.addTramo(t2);
			n.addTramo(t3);
			n.addTramo(t4);
			
			n.start();
		}
	}

}
