# Desafío: API de Libros de Stephen King 📚

Este proyecto es una aplicación de consola en Java, construida con **Spring Boot**, que interactúa con una API de libros de Stephen King. La aplicación permite a los usuarios buscar y analizar datos de los libros del famoso autor.

---

### Funcionalidades ✨

La aplicación ofrece las siguientes características principales:

* **Top 10 Libros con Más Páginas**: Muestra una lista de los diez libros con el mayor número de páginas de la colección.
* **Búsqueda por Título**: Permite al usuario buscar un libro específico por su título (o parte de él) y muestra sus detalles.
* **Búsqueda por Año**: Le pide al usuario ingresar un año de publicación y muestra una lista de todos los libros de Stephen King publicados en ese año.
* **Estadísticas de Páginas**: Calcula y muestra estadísticas resumidas (promedio, máximo, mínimo) del número de páginas de todos los libros.

---

### Tecnologías Utilizadas 🛠️

* **Java 24**: Lenguaje de programación.
* **Spring Boot**: Framework para el desarrollo de la aplicación.
* **Jackson**: Librería para la serialización y deserialización de JSON.
* **`ConsumoAPI` y `ConvierteDatos`**: Clases de servicio para manejar la comunicación con la API y el procesamiento de los datos JSON.
* **Streams y Collectors de Java**: Utilizados para procesar y agrupar los datos de manera eficiente.

---

### Cómo Usar la Aplicación 🚀

1.  **Clonar el repositorio**:
    `git clone https://github.com/cbastian1985/DesafioLibros.git`
2.  **Abrir en tu IDE**: Abre el proyecto en IntelliJ IDEA o cualquier otro IDE compatible con Spring Boot.
3.  **Ejecutar la clase principal**: Ejecuta la clase `DesafioApplication.java` para iniciar la aplicación.
4.  **Interactuar en la consola**: La aplicación te guiará a través de las diferentes opciones a través de mensajes en la consola.

---

### API Utilizada 🌐

Este proyecto consume la siguiente API pública:

`https://stephen-king-api.onrender.com/api/books`

---

### Contacto 🤝

Si tienes alguna pregunta o sugerencia, no dudes en contactarme en mi perfil de GitHub.
