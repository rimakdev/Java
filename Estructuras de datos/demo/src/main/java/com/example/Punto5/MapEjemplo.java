package com.example.Punto5;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapEjemplo {
    public static void main(String[] args) {
        // HashMap: No garantiza orden
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(3, "Laptop");
        hashMap.put(1, "Teléfono");
        hashMap.put(2, "Tablet");

        // LinkedHashMap: Mantiene el orden de inserción
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(3, "Laptop");
        linkedHashMap.put(1, "Teléfono");
        linkedHashMap.put(2, "Tablet");

        // TreeMap: Ordena por clave (ascendente por defecto)
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "Laptop");
        treeMap.put(1, "Teléfono");
        treeMap.put(2, "Tablet");

        // Mostrar los mapas
        System.out.println("HashMap (Sin orden garantizado): " + hashMap);
        System.out.println("LinkedHashMap (Orden de inserción): " + linkedHashMap);
        System.out.println("TreeMap (Ordenado por clave): " + treeMap);
    }
}
