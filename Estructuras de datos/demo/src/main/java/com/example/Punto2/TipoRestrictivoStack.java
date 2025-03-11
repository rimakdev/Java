package com.example.Punto2;

import java.util.Stack;

public class TipoRestrictivoStack {
    private Stack<Object> pila;

    public TipoRestrictivoStack() {
        this.pila = new Stack<>();
    }

    public void push(Object elemento) {
        if (pila.isEmpty() || pila.peek().getClass().equals(elemento.getClass())) {
            pila.push(elemento);
            System.out.println("Elemento agregado: " + elemento);
        } else {
            System.out.println("Error: Tipo incompatible. Se esperaba " + pila.peek().getClass().getSimpleName());
        }
    }

    public Object pop() {
        if (!pila.isEmpty()) {
            return pila.pop();
        }
        System.out.println("Error: La pila está vacía.");
        return null;
    }

    public Object peek() {
        if (!pila.isEmpty()) {
            return pila.peek();
        }
        System.out.println("Error: La pila está vacía.");
        return null;
    }

    public boolean isEmpty() {
        return pila.isEmpty();
    }

    public void mostrarPila() {
        System.out.println("Contenido de la pila: " + pila);
    }
}
