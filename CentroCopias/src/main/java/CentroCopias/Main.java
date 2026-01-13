package CentroCopias;

public class Main {
    public static void main(String[] args) {
        //Creamos el centro de copias, en nuestro caso con dos máquinas
        CentroCopias centro = new CentroCopias(2);

        //Arrays para guardar estudiantes e hilos y controlarlo para finalizar el programa (5 según enunciado)

        Estudiante[] estudiantes = new Estudiante[5];
        Thread[] hilos = new Thread[5];

        //Creamos y arrancamos los estudiantes

        for (int i = 1; i <= 5; i++) {
            estudiantes[i - 1] = new Estudiante(centro, i);
            hilos[i - 1] = new Thread(estudiantes[i - 1]);
            hilos[i - 1].start();
        }

        //Ejecutamos el programa durante 20s (20000 ms)

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Indicamos que deben finalizar y se espera a que terminen la ejecución

        for (int i = 0; i < 5; i++) {
            estudiantes[i].detener();
        }

        for (int i = 0; i < 5; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Mostramos los resultados por pantalla

        System.out.println("\n===== RESUMEN DE LA JORNADA =====");
        for (int i = 0; i < 5; i++) {
            System.out.println(
                    "Estudiante " + estudiantes[i].getEstudiante() + " ha usado las fotocopiadoras " + estudiantes[i].getNumCopias() + " veces"
            );

        }
    }
}