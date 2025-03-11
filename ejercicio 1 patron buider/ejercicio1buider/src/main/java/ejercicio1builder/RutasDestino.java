package ejercicio1builder;

/*
 * Integrantes:
 * Juan Esteban Soto Pérez
 * Diane Ortega Soto
 * Oscar Leandro Agudelo Franco
 * 
 */
public class RutasDestino {

    public static void main(String[] args) {
        UsuarioBuilder builder = new UsuarioBuilder();

        Usuario usuario = builder
                .conPersonalizacion(true)
                .conFechaSalida("dd-mm-aaaa")
                .conIdentificacion("123456789")
                .conNombre("Juan Pérez")
                .conNumeroTelefono("3101234567")
                .conDestino("Playa Paraiso")
                .conAlojamiento("Hotel")
                .conTransporte("Autobús")
                .conActividades("Visitar monumentos")
                .build();

        System.out.println(usuario);
    }
}

class UsuarioBuilder {

    private boolean personalizar;
    private String fechaSalida;
    private String identificacion;
    private String nombre;
    private String numeroTelefono;
    private String destino;
    private String alojamiento;
    private String transporte;
    private String actividades;

    public UsuarioBuilder conPersonalizacion(boolean personalizar) {
        this.personalizar = personalizar;
        return this;
    }

    public UsuarioBuilder conFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
        return this;
    }

    public UsuarioBuilder conIdentificacion(String identificacion) {
        this.identificacion = identificacion;
        return this;
    }

    public UsuarioBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public UsuarioBuilder conNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
        return this;
    }

    public UsuarioBuilder conDestino(String destino) {
        this.destino = destino;
        return this;
    }

    public UsuarioBuilder conAlojamiento(String alojamiento) {
        this.alojamiento = alojamiento;
        return this;
    }

    public UsuarioBuilder conTransporte(String transporte) {
        this.transporte = transporte;
        return this;
    }

    public UsuarioBuilder conActividades(String actividades) {
        this.actividades = actividades;
        return this;
    }

    public Usuario build() {
        return new Usuario(personalizar, fechaSalida, identificacion, nombre, numeroTelefono, destino, alojamiento,
                transporte, actividades);
    }
}

class Usuario {

    private boolean personalizar;
    private String fechaSalida;
    private String identificacion;
    private String nombre;
    private String numeroTelefono;
    private String destino;
    private String alojamiento;
    private String transporte;
    private String actividades;

    public Usuario(boolean personalizar, String fechaSalida, String identificacion, String nombre,
            String numeroTelefono, String destino, String alojamiento, String transporte, String actividades) {
        this.personalizar = personalizar;
        this.fechaSalida = fechaSalida;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.numeroTelefono = numeroTelefono;
        this.destino = destino;
        this.alojamiento = alojamiento;
        this.transporte = transporte;
        this.actividades = actividades;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "personalizar=" + personalizar +
                ", fechaSalida='" + fechaSalida + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                ", destino='" + destino + '\'' +
                ", alojamiento='" + alojamiento + '\'' +
                ", transporte='" + transporte + '\'' +
                ", actividades='" + actividades + '\'' +
                '}';
    }
}
