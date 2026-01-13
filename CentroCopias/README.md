📚 Centro de Copias de la Biblioteca (Java)

  Simulación en Java del funcionamiento de un centro de copias de una biblioteca utilizando programación concurrente.
  Proyecto desarrollado como práctica evaluable de la asignatura Programación de Servicios y Procesos (PSP) del ciclo 
  Desarrollo de Aplicaciones Multiplataforma (DAM).

🧩 Resumen del problema

  - 5 estudiantes quieren hacer copias de sus apuntes.
  - El centro dispone de 2 máquinas de copiado.
  - Cada máquina solo puede ser utilizada por un estudiante a la vez.
  - Si no hay máquinas libres, los estudiantes deben esperar.
  - El objetivo es coordinar el acceso concurrente a las máquinas evitando conflictos.

⚙️ Tecnologías y conceptos usados
  - Java
  - Hilos (Thread / Runnable)
  - Exclusión mutua (synchronized)
  - Comunicación entre hilos (wait() / notifyAll())
  - Gestión de recursos compartidos
  - Control de ejecución temporal (20 segundos)

🧠 Enfoque de la solución:

  - Cada estudiante está representado por un hilo.
  - Las máquinas de copiado son un recurso compartido gestionado por la clase central CentroCopias.
  - Cuando todas las máquinas están ocupadas, los hilos entran en espera usando wait().
  - Al liberar una máquina, se notifica a los hilos en espera con notifyAll().

El programa se ejecuta durante 20 segundos, tras los cuales los hilos finalizan correctamente y se muestra un resumen.
La lógica está inspirada en el clásico problema de la cena de los filósofos, adaptado a un único recurso por hilo.

▶️ Ejecución

Ejecutar la clase Main.
La consola mostrará en tiempo real cuándo los estudiantes estudian, cuándo solicitan una máquina, cuándo la usan y la liberan
Al finalizar, se muestra un resumen con el número de copias realizadas por cada estudiante.


📌 Proyecto realizado con fines educativos
