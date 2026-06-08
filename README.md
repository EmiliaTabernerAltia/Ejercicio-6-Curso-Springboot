# 🚀 Ejercicio 6 - Curso Spring Boot

Proyecto de microservicios con Docker desarrollado como parte del curso de Spring Boot.

---

## Microservicios

| Servicio | Imagen | Host | Puerto Externo | Puerto Interno |
|---|---|---|---|---|
| `41_curso_docker` | `imagencurso` | localhost | `9000` | `8081` |
| `42_formacion_docker` | `imagenformacion` | localhost | `9001` | `8082` |

---

## Construcción de Imágenes Docker

```bash
# Imagen del microservicio Curso
docker build -t imagencurso ./imagen_curso

# Imagen del microservicio Formación
docker build -t imagenformacion ./imagen_formacion
```

---

## Ejecución de Contenedores

```bash
# Contenedor Cursos (accesible en http://localhost:9000)
docker run -p 9000:8081 imagencurso

# Contenedor Formación (accesible en http://localhost:9001)
docker run -p 9001:8082 imagenformacion
```

---

## Endpoints disponibles

| Microservicio | URL |
|---|---|
| Cursos | [http://localhost:9000](http://localhost:9000) |
| Formación | [http://localhost:9001](http://localhost:9001) |


