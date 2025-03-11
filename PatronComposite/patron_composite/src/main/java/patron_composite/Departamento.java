package patron_composite;

import java.util.ArrayList;
import java.util.List;

// empleados o sub-departamentos
class Departamento implements Componente {
    private String nombre;
    private List<Componente> empleados = new ArrayList<>();

    public Departamento(String nombre) {
        this.nombre = nombre;
    }

    public void agregarEmpleado(Componente empleado) {
        empleados.add(empleado);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Departamento: " + nombre);
        for (Componente empleado : empleados) {
            empleado.mostrarDetalles();
        }
    }
}