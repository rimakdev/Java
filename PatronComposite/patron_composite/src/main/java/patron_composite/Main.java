package patron_composite;

/*
    Integrantes:
    -Juan Esteban Soto Pérez
    -Diane Ortega Soto
    -Natalia Tejada Cardona
*/

public class Main {
    public static void main(String[] args) {
        // Crear empleados
        Empleado emp1 = new Empleado("Juan", "Gerente");
        Empleado emp2 = new Empleado("María", "Desarrollador");
        Empleado emp3 = new Empleado("Pedro", "Desarrollador");

        // Crear departamentos
        Departamento departamentoTecnico = new Departamento("Departamento Técnico");
        Departamento departamentoRRHH = new Departamento("Departamento de Recursos Humanos");

        // Agregar empleados a los departamentos
        departamentoTecnico.agregarEmpleado(emp2);
        departamentoTecnico.agregarEmpleado(emp3);
        departamentoRRHH.agregarEmpleado(emp1);

        // Crear un departamento compuesto que contiene sub-departamentos
        Departamento empresa = new Departamento("Empresa");
        empresa.agregarEmpleado(departamentoTecnico);
        empresa.agregarEmpleado(departamentoRRHH);

        // Mostrar detalles de la empresa
        empresa.mostrarDetalles();
    }
}
