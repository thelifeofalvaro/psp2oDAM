package CentroCopias;

public class Estudiante implements Runnable {

    private CentroCopias centro;
    private int estudiante; //En nuestro caso serán 5
    private int numCopias; //Para contabilizar las veces que cada estudiante hace copias
    private boolean activo; //La usamos para finalizar los hilos al acabar el tiempo. Indica si el hilo sigue activo

    //Constructor para Estudiante

    public Estudiante(CentroCopias centro, int estudiante) {
        this.centro = centro;
        this.estudiante = estudiante;
        this.numCopias = 0; //Empiezan sin haber usado las fotocopiadoras
        this.activo = true;
    }

    //Metodo que simula que el estudiante está en la mesa de la biblioteca
    private void estudiando () {
        System.out.println("Estudiante " +estudiante+ " está estudiando.");
        try{
            Thread.sleep((int) (Math.random() * 3000));
        } catch (InterruptedException e){
            throw new RuntimeException(e);
            //El hilo finaliza
        }
    }

    //Metodo que simula que el estudiante está usando la fotocopiadora
    private void copiando() {
        System.out.println("Estudiante " + estudiante + " está fotocopiando.");
        try{
            Thread.sleep((int) (Math.random() * 3000));
        } catch (InterruptedException e){
            throw new RuntimeException(e);
            //El hilo finaliza
        }
    }

    //Metodo run. Ciclo principal de acciones de los estudiantes

    @Override
    public void run(){
        while (activo){
            //Empieza estudiando
            estudiando();
            //Solicita fotocopiadora
            int maquina = centro.solicitarMaquina(estudiante);
            //Usa la fotocopiadora
            copiando();
            numCopias++;
            //Libera la fotocopiadora
            centro.liberarMaquina(maquina,estudiante);
        }
    }

    //Detiene la ejecución cambiado el estado de activo a false

    public void detener(){
        activo = false;
    }

    // Getters para mostrar los resultados finales

    public int getNumCopias(){
        return numCopias;
    }

    public int getEstudiante(){
        return estudiante;
    }
}
