package CentroCopias;

public class CentroCopias {

    private boolean[] maquinas; // true = libre, false = ocupado

    public CentroCopias(int numMaquinas) {
        this.maquinas = new boolean[numMaquinas]; //Empiezan libres
    }

    //ZONA CRITICA. Acción 1. Solicitar fotocopiadora mediante synchronized
    public synchronized int solicitarMaquina(int estudiante) {

        // Si todas las fotocopiadoras están ocupadas, el estudiante debe esperar
        while (maquinasOcupadas()) {
            try {
                System.out.println("Estudiante " + estudiante + " tiene que esperar, no hay fotocopiadoras libres");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Se busca la primera fotocopiadora libre
        for (int i = 0; i < maquinas.length; i++) {
            if (!maquinas[i]) {
                maquinas[i] = true;
                System.out.println("Estudiante " + estudiante + " usa la fotocopiadora " + (i + 1));
                return i;
            }
        }

        return -1; // No debería llegar, pero Java me da error si no cierro esta estructura
    }

    //ZONA CRITICA. Acción 2. Liberar fotocopiadora mediante synchronized

    public synchronized void liberarMaquina(int numMaquina, int estudiante) {
        maquinas[numMaquina] = false;
        System.out.println("Estudiante " + estudiante + " libera la fotocopiadora " + (numMaquina + 1));
        notifyAll(); // Se avisa a los estudiantes de que hay una fotocopiadora libre
    }

    //Comprobamos si todas las fotocopiadoras están ocupadas
    private boolean maquinasOcupadas() {
        for (boolean maquina : maquinas) {
            if (!maquina) {
                return false;
            }
        }
        return true;
    }

}