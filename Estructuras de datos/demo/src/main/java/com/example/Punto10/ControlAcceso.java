package com.example.Punto10;

import java.util.HashSet;

public class ControlAcceso {
    private HashSet<String> empleados;

    public ControlAcceso() {
        this.empleados = new HashSet<>();
    }

    // Agregar un nuevo empleado
    public void registrarEmpleado(String idEmpleado) {
        if (empleados.add(idEmpleado)) {
            System.out.println(" Empleado " + idEmpleado + " registrado correctamente.");
        } else {
            System.out.println(" El empleado " + idEmpleado + " ya está registrado.");
        }
    }

    // Verificar si un empleado tiene acceso
    public void verificarAcceso(String idEmpleado) {
        if (empleados.contains(idEmpleado)) {
            System.out.println(" Acceso permitido para el empleado " + idEmpleado);
        } else {
            System.out.println(" Acceso denegado. El empleado " + idEmpleado + " no está registrado.");
        }
    }

    // Eliminar un empleado (dar de baja)
    public void eliminarEmpleado(String idEmpleado) {
        if (empleados.remove(idEmpleado)) {
            System.out.println(" Empleado " + idEmpleado + " eliminado del sistema.");
        } else {
            System.out.println(" El empleado " + idEmpleado + " no está en el sistema.");
        }
    }

    // Mostrar lista de empleados registrados
    public void mostrarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println(" No hay empleados registrados.");
        } else {
            System.out.println(" Empleados con acceso permitido: " + empleados);
        }
    }
}
