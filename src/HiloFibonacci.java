class HiloFib extends Thread{
	
	private float numero;//numero que le da el usuario
	public float nfib;//numero donde se guarda el resultado
	
	//constructor
	public HiloFib(float numeroPos){
		this.numero=numeroPos;
	}
	@Override
	public void run(){
		
			nfib=fibonacci(numero);
	}
	
	public float fibonacci(float f){
		
		float f1=0;
		float f2=1;
		
		if (numero<=0) {
			nfib=0;
		}
		if(numero <=2){
			nfib=1;
		}
		else{

			for (float i = 2; i <= f; i++) {
				f2= f1 + f2;
				f1 = f2 - f1;
			}
		}
		
		return f2;
	}
}


public class HiloFibonacci {
	
	public static void main(String[] args) {
		float numero=100;
		//monohilo
		try {
			
			HiloFib hiloUnico= new HiloFib(numero);
			hiloUnico.start();
			hiloUnico.join();
			System.out.println(String.valueOf("El monohilo: "+hiloUnico.nfib));

		
		
		//multihilo
			
			//creacion de los 2 hilos para las 2 partes del numero de fibonacci
			HiloFib hilo1 = new HiloFib((numero-2));
			HiloFib hilo2 =new HiloFib((numero-1));
			
			//arrancar los hilos
			hilo1.start();
			hilo2.start();
			
			//esperar hasta que acaben los hilos
			hilo1.join();
			hilo2.join();
			System.out.println("El multihilo: "+String.valueOf((hilo1.nfib+hilo2.nfib)));	
		} catch (InterruptedException e) {}
	}
}
