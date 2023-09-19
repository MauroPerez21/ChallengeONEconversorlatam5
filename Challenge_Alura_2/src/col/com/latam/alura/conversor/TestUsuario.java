package col.com.latam.alura.conversor;

public class TestUsuario {
	public static void main(String[] args) {
	
		mensajeInicio();
		abrirVentana();
		mensajeFin();
		
	}
	private static void mensajeInicio() {
		// TODO Auto-generated method stub
		System.out.println("inicio");
		//ArithmeticException ae = new ArithmeticException();
		
	
	}

	private static void abrirVentana() throws MiExcepcion{
		// TODO Auto-generated method stub
	//throw new MiExcepcion("mi excepcion fue lanzada");
		InterfazUsuario gui = new InterfazUsuario();
		try {
			gui.setVisible(true);  
		}catch(MiExcepcion me){
			me.printStackTrace();
		}
	}
	
	private static void mensajeFin() {
		// TODO Auto-generated method stub
		System.out.println("fin");
	}

	
}
