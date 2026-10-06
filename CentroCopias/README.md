# 📚 Centro de Copias de la Biblioteca

Simulación en Java del funcionamiento de un centro de copias de una biblioteca utilizando programación concurrente.

Proyecto desarrollado como práctica evaluable de la asignatura **Programación de Servicios y Procesos (PSP)** del ciclo **Desarrollo de Aplicaciones Multiplataforma (DAM)**.

## 🎯 Objetivo

El proyecto simula un escenario en el que varios estudiantes necesitan utilizar un número limitado de máquinas de copiado.

El sistema debe coordinar el acceso concurrente a estas máquinas, evitando que dos estudiantes utilicen la misma máquina simultáneamente y gestionando la espera cuando todos los recursos están ocupados.

## 🧩 Problema planteado

El escenario está compuesto por:

- 5 estudiantes que realizan copias de sus apuntes.
- 2 máquinas de copiado disponibles.
- Cada máquina puede ser utilizada por un único estudiante a la vez.
- Los estudiantes deben esperar cuando no existe ninguna máquina disponible.
- La ejecución se mantiene durante 20 segundos.

El objetivo es gestionar correctamente el acceso concurrente a las máquinas como recurso compartido.

## ⚙️ Funcionamiento

Cada estudiante se representa mediante un hilo independiente.

Las máquinas de copiado son gestionadas como un recurso compartido por la clase central `CentroCopias`.

Cuando una máquina está disponible, un estudiante puede utilizarla. Si todas están ocupadas, el hilo correspondiente queda esperando hasta que se libere una máquina.

El programa utiliza:

- `Thread` / `Runnable` para representar la ejecución concurrente.
- `synchronized` para controlar el acceso al recurso compartido.
- `wait()` para poner en espera a los hilos cuando no hay máquinas disponibles.
- `notifyAll()` para notificar a los hilos en espera cuando se libera una máquina.

## 🧠 Enfoque de la solución

El funcionamiento puede resumirse de la siguiente forma:

    Estudiante → solicita máquina
          ↓
    ¿Hay máquina disponible?
       ↙           ↘
     Sí             No
      ↓              ↓
    Utiliza        wait()
    máquina          ↓
      ↓         Se libera una máquina
    Libera           ↓
    máquina       notifyAll()
      ↓
    Continúa

La ejecución finaliza después de 20 segundos y se muestra un resumen con el número de copias realizadas por cada estudiante.

## ▶️ Ejecución

Ejecutar la clase `Main`.

Durante la ejecución, la consola muestra información sobre las diferentes acciones realizadas por los estudiantes:

- Estudio.
- Solicitud de una máquina.
- Uso de la máquina.
- Liberación de la máquina.

Al finalizar el periodo de ejecución se muestra un resumen con el número de copias realizadas por cada estudiante.

## 🛠️ Tecnologías y conceptos

- Java
- Programación concurrente
- `Thread`
- `Runnable`
- `synchronized`
- `wait()`
- `notifyAll()`
- Recursos compartidos
- Sincronización entre hilos

## 🎓 Contexto académico

Práctica desarrollada durante la asignatura **Programación de Servicios y Procesos (PSP)** de 2º DAM.

## 📚 Enunciado

[Enunciado completo](https://github.com/user-attachments/files/24588764/Practica.1de2.PSP.2.pdf)

## 👤 Autor

**Álvaro Medina**