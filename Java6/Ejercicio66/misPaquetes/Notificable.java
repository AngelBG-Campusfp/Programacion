package misPaquetes;

public interface Notificable {
	void enviarNotificacion();
}

class CorreoElectronico implements Notificable {
	public void enviarNotificacion() {
		System.out.println("El mensaje ha sido enviado por Correo");
	}
}

class MensajeTexto implements Notificable {
	public void enviarNotificacion() {
		System.out.println("El mensaje ha sido enviado por SMS");
	}
}
	
