package com.example.Punto2;

public class Main {
    public static void main(String[] args) {
        TipoRestrictivoStack pila = new TipoRestrictivoStack();

        pila.push(10); // Se agrega correctamente
        pila.push(20); // Se agrega correctamente
        pila.push("Hola"); // Error: Tipo incompatible

        pila.pop(); // Elimina 20

        pila.push(15); // Se agrega correctamente
        pila.push(3.14); // Error: Tipo incompatible

        pila.mostrarPila(); // Muestra el contenido de la pila
    }
}
