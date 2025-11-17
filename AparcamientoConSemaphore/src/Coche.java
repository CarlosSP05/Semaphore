import java.util.Random;

public class Coche implements Runnable {
    private String nombre;
    private Aparcamiento aparcamiento;

    public Coche(String nombre, Aparcamiento aparcamiento) {
        this.nombre = nombre;
        this.aparcamiento = aparcamiento;
    }

    @Override
    public void run() {
        // Intentar entrar al aparcamiento hasta que haya espacio
        while (!aparcar()) {
            // Si no hay espacio, esperar y volver a intentarlo
            try {
                Thread.sleep(1000);  // Esperar antes de intentar de nuevo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Dormir durante un tiempo aleatorio entre 1 y 4 segundos (simula el coche aparcado)
        try {
            Thread.sleep(1000 + new Random().nextInt(3000));  // 1 a 4 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Salir del aparcamiento
        aparcamiento.salir(nombre);
    }

    private boolean aparcar() {
        synchronized (aparcamiento) {
            // Si hay espacio en el aparcamiento, el coche entra
            if (aparcamiento.getPlazasOcupadas() < 3) {
                aparcamiento.entrar(nombre);  // El coche entra al aparcamiento
                return true;
            } else {
                // Si no hay espacio, muestra el mensaje de espera solo una vez
                if (!aparcamiento.isEsperando(nombre)) {
                    aparcamiento.mostrarEsperando(nombre);  // El coche está esperando
                    aparcamiento.setEsperando(nombre, true);  // Marca al coche como esperando
                }
                return false;  // Indica que el coche no pudo entrar
            }
        }
    }
}
