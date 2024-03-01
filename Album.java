import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String nombre;
    private String artista;
    private ArrayList<Cancion> canciones;

    public Album(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
        this.canciones = new ArrayList();


    }

    private Cancion findSong(String titulo) {
        for (Cancion cancion : canciones) {
            if (cancion.getTitulo().equalsIgnoreCase(titulo)) {
                return cancion;
            }
        }
        return null;
    }

    public boolean addsong(String titulo, double duracion) {

        if (findSong(titulo) == null) {
            Cancion nuevacancion = new Cancion(titulo, duracion);
            canciones.add(nuevacancion);
            return true;
        }

        return false;

    }

    public boolean addToPlayList(String titulo, LinkedList<Cancion> canciones) {
        Cancion cancion = findSong(titulo);
        if (cancion != null) {
            canciones.add(cancion);
            return true;

        } else {
            return false;
        }
    }

    public boolean addToPlayList(int numeropistas, LinkedList<Cancion> Playlist) {
        int index = numeropistas - 1;
        if (index >= 0 && index < canciones.size()) {
            Playlist.add(canciones.get(index));
            return true;

        } else {
            return false;
        }

    }
}
