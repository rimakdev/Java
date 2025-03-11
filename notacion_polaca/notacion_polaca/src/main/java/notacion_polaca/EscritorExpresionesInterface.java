package notacion_polaca;

import java.util.ArrayList;

public interface EscritorExpresionesInterface {

    ArrayList<String> reescribirExpresion(ArrayList<String> expresionNormal);

    default Boolean esOperador(String elemento) {
        return "^/*-+".contains(elemento);
    }

    default Byte calcularPrioridad(String elemento) {

        if ("^".contains(elemento)) {
            return 3;
        } else if ("/*".contains(elemento)) {
            return 2;
        } else {
            return 1;
        }
    }
}
