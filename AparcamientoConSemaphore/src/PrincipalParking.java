public class PrincipalParking {
    public static void main(String[] args) {
        // Crear un aparcamiento con 3 plazas
        Aparcamiento aparcamiento = new Aparcamiento(3);

        // Crear 7 coches
        for (int i = 1; i <= 7; i++) {
            String nombreCoche = "Coche-" + i;
            Coche coche = new Coche(nombreCoche, aparcamiento);
            Thread hilo = new Thread(coche);
            hilo.start();
        }
    }
}
