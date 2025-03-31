package misPaquetes;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CorreoElectronico correo1 = new CorreoElectronico();
		correo1.enviarNotificacion();
		
		MensajeTexto mensaje1 = new MensajeTexto();
		mensaje1.enviarNotificacion();
	}

}
