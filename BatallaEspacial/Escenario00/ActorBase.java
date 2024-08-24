import greenfoot.*;

/**
 * Clase base para estandarizar los comportamientos de los actores de la Batalla
 * Espacial.
 */
public abstract class ActorBase extends Actor {
    /**
     * Es la imagen con la que inicializa el Actor
     */
    protected GreenfootImage imagenBase;
    protected int ColorNum;
    /**
     * Punto de extensión para definir cómo debe actualizarse la imagen del Actor
     */
    protected abstract void actualizarImagen();

    /**
     * Captura las características del Actor al ser agregado al Mundo
     */
    @Override
    protected void addedToWorld(World world) {
        imagenBase = getImage();
        actualizarImagen();
    }
    
    protected int generarNumero(int max,int min){
        return (int) (Math.random() * (max-min+1)+min);
    }
}
