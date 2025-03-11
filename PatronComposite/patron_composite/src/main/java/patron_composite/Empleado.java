package patron_composite;

class Empleado implements Componente {
    private String nombre;
    private String cargo;

    public Empleado(String nombre, String cargo) {
        this.nombre = nombre;
        this.cargo = cargo;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Empleado: " + nombre + ", Cargo: " + cargo);
    }
}
