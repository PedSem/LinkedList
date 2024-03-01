import java.util.*;

public class MainCancion {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Album album = new Album("Skillet", "Rise");
        album.addsong("Hero", 3.15);
        album.addsong("Monster", 3.15);
        album.addsong("Salvation", 3.15);
        ArrayList<Album> albumes = new ArrayList<Album>();
        albumes.add(album);
        LinkedList<Cancion> playlist = new LinkedList<Cancion>();

        album.addToPlayList("Hero", playlist);
        album.addToPlayList("Monster", playlist);
        album.addToPlayList(3, playlist);
        play(playlist);

    }


    public static void printcancion(LinkedList<Cancion> playlist) {
        Iterator<Cancion> it = playlist.iterator();
        while (it.hasNext()) {
            System.out.println("Cancion:" + it.next());
        }
        System.out.println("-----");
    }


    public static void play(LinkedList<Cancion> playlist) {
        boolean continuar = true;
        ListIterator<Cancion> it = playlist.listIterator();

        boolean siguientecancion = true;
        imprimirmenu();
        while (continuar) {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 0:
                    System.out.println("No hay canciones disponibles");
                    continuar = false;
                    break;
                case 1:
                    if (!siguientecancion) {
                        if (it.hasNext())
                            it.next();
                        siguientecancion = true;
                    }

                    if (it.hasNext()) {
                        System.out.println("La cancion es:" + it.next());
                    } else {
                        System.out.println("Ya no hay mas canciones");
                        siguientecancion = false;
                    }
                    break;
                case 2:
                    if (siguientecancion) {
                        if (it.hasPrevious())
                            it.previous();
                        siguientecancion = false;
                    }
                    if (it.hasPrevious()) {
                        System.out.println("La cancion anterior es:" + it.previous());

                    } else {
                        System.out.println("Primera cancion");
                        siguientecancion = true;
                    }
                    break;
                case 3:
                    if(siguientecancion){
                        if(it.hasPrevious()) {
                            System.out.println(it.previous());
                        }else {
                            System.out.println(it.next());
                        }


                    }else if(it.hasNext()){
                        System.out.println(it.next());
                    }else{
                        System.out.println(it.previous());
                    }
                    break;

                case 4:
                    printcancion(playlist);
                    break;
                case 5:
                    imprimirmenu();
                    break;

                case 6:
                    if(playlist.isEmpty()){
                        System.out.println("No hay canciones");
                    }else{
                        System.out.println("La cancion eliminada es:");
                        if(siguientecancion){
                            if(it.hasPrevious()) {
                                System.out.println(it.previous());
                            }else {
                                System.out.println(it.next());
                            }


                        }else if(it.hasNext()){
                            System.out.println(it.next());
                        }else{
                            System.out.println(it.previous());
                        }
                    }
                    it.remove();
                    break;





            }
        }

    }

    public static void imprimirmenu() {
        System.out.println("0-Salir de la lista de reproduccion");
        System.out.println("1-Reproducir la siguiente cancion en la lista");
        System.out.println("2-Reproducir la cancion previa de la lista");
        System.out.println("3-Repetir la cancion actual");
        System.out.println("4-Imprimir la lista de canciones de la playlist");
        System.out.println("5-Volver a imprimir el menu");
        System.out.println("6-Eliminar cancion actual");

    }
}
