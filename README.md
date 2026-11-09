# Práctica 2. Simulación de inversión bancaria
**Autor:** Noé Paredes Morales. 

**Asignatura:** Introducción a Ciencias de la Computación. 

<p align="justify">
Esta práctica desarrolló un simulador interactivo que calcula los días de duración de una inversión bancaria y el rendimiento generado
a una tasa anual del 12%. Incluye una implementación propia para el manejo y validación de fechas, en un paradigma de Programación Orientado a
Objetos. 
</p>

## Algoritmo desarrollado

<p align="justify">
El programa está organizado en dos clases principales. Cada una tiene una función diferente: una se encarga de trabajar con las fechas y la
otra de interactuar con el usuario y realizar los cálculos de inversión.
</p>

<div align="justify">
  
* **Clase** `Fecha` **:** permite trabajar con fechas y comprobar que sean válidas. Considera aspectos como los años bisiestos
  y el número de días de cada mes. También incluye un método para calcular cuántos días que hay entre dos fechas. Para ello, convierte cada fecha
  en un número que representa los días transcurridos desde el inicio del calendario, lo que facilita realizar operaciones y comparaciones entre
  fechas.

* **Clase** `TiempoDeInversion`**:** se encarga de solicitar al usuario los datos necesarios para calcular el rendimiento de una inversión, como
  el monto inicial y las fechas de inicio y de término. Utiliza la clase `Fecha` para obtener días transcurridos y realizar el cálculo
  correspondiente. También muestra los resultados con dos decimales y permite al usuario realizar otro cálculo o salir del programa.

</div>

## Instrucciones de compilación y ejecución

Para correr este programa desde la terminal, siga estos pasos:

1. Clone este repositorio en su máquina local usando `git clone` [https://github.com/noeparedes-morales/ICC-Practica02-NParedes/tree/main/NParedes/practica02/src/icc]. 
   Alternativamente, puede descargarlo como archivo ZIP desde GitHub y descomprimirlo.
2. Abra su aplicación de Terminal.
3. Navegue hasta el directorio donde guardó los archivos `.java`. Por ejemplo, para la carpeta NParedes en su Escritorio, use: `cd~/Desktop/NParedes`
4. Compile ambos archivos simultáneamente con el compilador de Java: `javac Fecha.java TiempoDeInversion.java`. Una vez compilados se generarán
   los archivos `.class` correspondientes a cada archivo.
5. Ejecute `java TiempoDeInversion`.
