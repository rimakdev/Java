package PatronMemento;

public class App {
    public static void main(String[] args) {
        String nombreJuego = "Mario Bros";
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();
        // Se ejecuta el juego por primera vez con un nivel 0.
        Juego juego = new Juego();
        juego.setNombre(nombreJuego);
        juego.setCheckpoint(0);
        originator.setEstado(juego);
        caretaker.addMemento(originator.guardar()); // Estado posición 0 en ArrayList de Mementos.
        /*
        Se setea nuevamente el juego ahora con un checkpoint conseguido en el nivel 1, y se guarda el estado actual del juego en el originador,
        más no se guarda el checkpoint en la lista de checkpoints, por lo que si el juego se reinicia, el jugador iniciará desde el nivel 0.
         */
        juego = new Juego();
        juego.setNombre(nombreJuego);
        juego.setCheckpoint(1);

        juego = new Juego();
        juego.setNombre(nombreJuego);
        juego.setCheckpoint(2);
        originator.setEstado(juego);
        caretaker.addMemento(originator.guardar()); // Estado posición 1 en ArrayList de Mementos.

        juego = new Juego();
        juego.setNombre(nombreJuego);
        juego.setCheckpoint(3);
        originator.setEstado(juego);
        caretaker.addMemento(originator.guardar()); // Estado posición 2 en ArrayList de Mementos.

        // Para mostrar los resultados:
        juego = originator.getEstado();
        System.out.println("Progreso actual:");
        System.out.println(juego);

        // Para restaurar a un checkpoint reciente:
        originator.restaurar(caretaker.getMemento(1));
        juego = originator.getEstado();
        System.out.println("\n\nEl juego ha sido restaurado:");
        System.out.println(juego);
    }
}
