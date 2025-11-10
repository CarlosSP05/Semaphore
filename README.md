# Proyecto de Aparcamiento Concurrente

Este proyecto simula el acceso concurrente a un aparcamiento con un número limitado de plazas. Utiliza la clase `Semaphore` de Java para gestionar el acceso concurrente a los recursos (plazas del aparcamiento).

## Objetivos

- Comprender el uso de la clase `Semaphore` en la programación concurrente.
- Simular el acceso de múltiples coches a un aparcamiento con 3 plazas disponibles.
- Controlar el acceso para que nunca haya más de 3 coches aparcados simultáneamente.
- Los coches que no puedan aparcar deben esperar hasta que haya espacio disponible.
- Los mensajes en consola se mostrarán en el orden correcto gracias a la sincronización.

## Estructura del Proyecto

- **Aparcamiento.java**: Clase que gestiona el semáforo y el acceso a las plazas del aparcamiento.
- **Coche.java**: Representa a un coche que intenta aparcar en el aparcamiento.
- **PrincipalParking.java**: Clase principal que crea el aparcamiento, los coches y lanza los hilos.

## Cómo funciona

- Se crea un aparcamiento con 3 plazas utilizando un semáforo.
- Se lanzan 7 coches como hilos concurrentes. Cada coche intentará aparcar, permanecerá durante un tiempo aleatorio y luego saldrá, liberando la plaza.
- Los coches que no puedan entrar debido a la falta de plazas, esperarán hasta que una plaza se libere.

## ¿Por qué usar `Semaphore`?

He utilizado `Semaphore` para gestionar el acceso al aparcamiento porque es una herramienta eficiente para controlar el número de hilos que pueden acceder a un recurso limitado de manera concurrente. Comparado con otras alternativas como `synchronized`, `Semaphore` permite una mayor flexibilidad y control de los permisos, lo que lo hace ideal para esta situación donde el número de plazas es limitado.

## Ejecución

Para ejecutar el programa, compila y corre la clase `PrincipalParking.java`. Verás en la consola cómo los coches entran, esperan si no hay plazas disponibles y luego salen.
