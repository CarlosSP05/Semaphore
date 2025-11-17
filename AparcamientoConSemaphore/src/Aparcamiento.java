import java.util.concurrent.Semaphore;
import java.util.HashSet;
import java.util.Set;

public class Aparcamiento {
    private Semaphore semaforo;  // Semáforo para controlar el número de coches en el aparcamiento
    private int plazasOcupadas;  // Contador de las plazas ocupadas
    private Set<String> esperando; // Set para gestionar coches que están esperando

    // Constructor que recibe la capacidad del aparcamiento
    public Aparcamiento(int capacidad) {
        semaforo = new Semaphore(capacidad); // Inicializa el semáforo con la capacidad del aparcamiento
        plazasOcupadas = 0; // Inicializa el contador de plazas ocupadas
        esperando = new HashSet<>();  // Inicializa el conjunto de coches esperando
    }

    // Método para que un coche intente entrar al aparcamiento
    public void entrar(String coche) {
        try {
            semaforo.acquire();  // Adquiere un permiso del semáforo (bloqueante si no hay espacio)
            synchronized (this) {
                plazasOcupadas++;  // Incrementa el contador de plazas ocupadas
                System.out.println(coche + " ha entrado. Plazas ocupadas: " + plazasOcupadas);
                esperando.remove(coche);  // El coche deja de estar esperando
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Método para que un coche salga del aparcamiento
    public void salir(String coche) {
        synchronized (this) {
            plazasOcupadas--;  // Decrementa el contador de plazas ocupadas
            System.out.println(coche + " ha salido. Plazas ocupadas: " + plazasOcupadas);
        }
        semaforo.release();  // Libera un permiso del semáforo, permitiendo que otro coche entre
    }

    // Método para mostrar que un coche está esperando para entrar
    public synchronized void mostrarEsperando(String coche) {
        System.out.println(coche + " está esperando...");
    }

    // Verifica si el coche ya está esperando
    public synchronized boolean isEsperando(String coche) {
        return esperando.contains(coche);
    }

    // Marca a un coche como esperando
    public synchronized void setEsperando(String coche, boolean esperando) {
        if (esperando) {
            this.esperando.add(coche);
        } else {
            this.esperando.remove(coche);
        }
    }

    // Método getter para obtener el número actual de plazas ocupadas
    public int getPlazasOcupadas() {
        return plazasOcupadas;
    }
}
