package com.example;

public class excepciones {
    public class UsuarioNoEncontradoException extends Exception {
        public UsuarioNoEncontradoException(String mensaje) {
            super(mensaje);
        }
    }

    public class SaldoInsuficienteException extends Exception {
        public SaldoInsuficienteException(String mensaje) {
            super(mensaje);
        }
    }

    public class CuentaNoAsociadaException extends Exception {
        public CuentaNoAsociadaException(String mensaje) {
            super(mensaje);
        }
    }

    public class TransaccionInvalidaException extends Exception {
        public TransaccionInvalidaException(String mensaje) {
            super(mensaje);
        }
    }

    public class CategoriaDuplicadaException extends Exception {
        public CategoriaDuplicadaException(String mensaje) {
            super(mensaje);
        }
    }

    public class PresupuestoExcedidoException extends Exception {
        public PresupuestoExcedidoException(String mensaje) {
            super(mensaje);
        }
    }

    public class FormatoInvalidoException extends Exception {
        public FormatoInvalidoException(String mensaje) {
            super(mensaje);
        }
    }

    public class ConexionServidorException extends Exception {
        public ConexionServidorException(String mensaje) {
            super(mensaje);
        }
    }

    public class OperacionNoPermitidaException extends Exception {
        public OperacionNoPermitidaException(String mensaje) {
            super(mensaje);
        }
    }

    public class HistorialNoDisponibleException extends Exception {
        public HistorialNoDisponibleException(String mensaje) {
            super(mensaje);
        }
    }

}
