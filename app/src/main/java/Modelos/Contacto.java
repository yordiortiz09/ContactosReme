package Modelos;

public class Contacto {
    private String nombre;
    private String numero;
    private String url;

    public Contacto(String nombre, String numero, String url) {
        this.nombre = nombre;
        this.numero = numero;
        this.url = url;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }




}
