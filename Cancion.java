public class Cancion {
    private String titulo;
    private double duracion;
    public Cancion(String titulo,double duracion){
        this.titulo=titulo;
        this.duracion=duracion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cancion cancion = (Cancion) o;

        if (Double.compare(cancion.duracion, duracion) != 0) return false;
        return titulo.equals(cancion.titulo);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = titulo.hashCode();
        temp = Double.doubleToLongBits(duracion);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "titulo='" + titulo + '\'' +
                ", duracion=" + duracion +
                '}';
    }
}
