import greenfoot.*;

/**
 * Define el comportamiento base para todos los Pilotos de la Batalla Espacial
 */
public abstract class PilotoBase extends ActorBase {
    protected double ESCALA_X = 0.8;
    protected double ESCALA_Y = 0.8;

    /**
     * La nave que pilotará
     */
    protected NaveDeAtaque navePilotada;
    //Control de errores
    protected boolean flag;
    GreenfootImage imagenOriginal = new GreenfootImage(getImage());

    @Override
    protected void addedToWorld(World world) {
        imagenBase = getImage();
        actualizarImagen();
    }

    /**
     * Pre: La nave no puede tener un piloto anterior
     * post: El Piloto se sube a la Nave
     * 
     * @param nave es la Nave a la que se subirá el piloto
     */
    public void subirse(NaveDeAtaque nave) {
        if (!nave.tienePiloto){
            navePilotada = nave;
            nave.conducir(this.ColorNum);
            actualizarImagen();
        }
    }

    /**
     * Pre: Nave pilotada no puede ser null.
     * post: El Piloto deja la Nave.
     */
    public void bajarse() {
        if(this.navePilotada != null){
            this.navePilotada.notConducir();
            this.navePilotada = null;
            actualizarImagen();
        }
    }

    /**
     * Actualiza la imagen del Piloto, de acuerdo a su estado
     */
    @Override
    protected void actualizarImagen() {
        int tamCelda = getWorld().getCellSize();
        MyGreenfootImage nuevaImagen;

        if(ColorNum == 0){
            ColorNum = generarNumero(4,1);
        }

        if (this.navePilotada != null) {
            nuevaImagen = new MyGreenfootImage(getImage()) {
                public void configurar() {
                    setTransparency(150);
                }
            };
            nuevaImagen.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
            setImage(nuevaImagen);
        }else{
            nuevaImagen = new MyGreenfootImage(imagenOriginal){
                public void configurar() {
                    //Asigna un numero que usara para definir el color del sombreado   
                    highlightColor(ColorNum);
                }
            };
            nuevaImagen.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
            setImage(nuevaImagen);
        }
    }
}
