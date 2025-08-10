package com.aluracursos.desafio.principal;

import com.aluracursos.desafio.model.Datos;
import com.aluracursos.desafio.model.DatosLibros;
import com.aluracursos.desafio.service.ConsumoAPI;
import com.aluracursos.desafio.service.ConvierteDatos;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private static final String URL_BASE = "https://stephen-king-api.onrender.com/api/books";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);

    public void muestraElMenu() {
        var json = consumoAPI.obtenerDatos(URL_BASE);
        var datos = conversor.obtenerDatos(json, Datos.class);

        if (datos == null || datos.data() == null) {
            System.out.println("No se pudieron obtener los datos de la API.");
            return;
        }


        // 1. Top 10 Libros con más páginas
        System.out.println("--- Top 10 Libros con más páginas ---");
        datos.data().stream()
                .sorted(Comparator.comparing(DatosLibros::paginas).reversed())
                .limit(10)
                .forEach(l -> {
                    String paginasStr = "";
                    if (l.paginas() != null) {
                        if (l.paginas() == l.paginas().intValue()) {
                            paginasStr = String.valueOf(l.paginas().intValue());
                        } else {
                            paginasStr = String.valueOf(l.paginas());
                        }
                    } else {
                        paginasStr = "N/A";
                    }
                    System.out.printf("Título: %s, Páginas: %s%n", l.titulo(), paginasStr);
                });

        // 2. Búsqueda de libro por nombre
        System.out.println("\n--- Búsqueda de libro por título ---");
        System.out.println("Ingrese el título del libro que desea buscar:");
        var tituloLibro = teclado.nextLine();

        Optional<DatosLibros> libroBuscado = datos.data().stream()
                .filter(l -> l.titulo().toLowerCase().contains(tituloLibro.toLowerCase()))
                .findFirst();

        if (libroBuscado.isPresent()) {
            System.out.println("\nLibro encontrado:");
            System.out.println("Título: " + libroBuscado.get().titulo());
            System.out.println("Autor: " + libroBuscado.get().getAutor());
            System.out.println("Páginas: " + libroBuscado.get().paginas());
            System.out.println("Año: " + libroBuscado.get().anio());
        } else {
            System.out.println("\nLibro '" + tituloLibro + "' no encontrado.");
        }

        // 3. Búsqueda por año de publicación
        System.out.println("\n--- Búsqueda de libros por año ---");
        System.out.println("Ingrese el año de publicación que desea buscar:");

        try {
            var anioBuscado = teclado.nextInt();
            teclado.nextLine();
            Map<Integer, List<DatosLibros>> librosPorAnio = datos.data().stream()
                    .collect(Collectors.groupingBy(d -> d.anio().intValue()));

            List<DatosLibros> librosDelAnio = librosPorAnio.get(anioBuscado);

            if (librosDelAnio != null && !librosDelAnio.isEmpty()) {
                System.out.println("\nLibros publicados en el año " + anioBuscado + ":");
                librosDelAnio.forEach(libro -> System.out.println("  - " + libro.titulo()));
            } else {
                System.out.println("\nNo se encontraron libros publicados en el año " + anioBuscado + ".");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
            teclado.nextLine();
        }
    }
}