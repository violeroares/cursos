package com.rockandcode.cursos.data.datasources.local

import com.rockandcode.cursos.data.models.CategoryDto
import com.rockandcode.cursos.data.models.CourseDocumentDto
import com.rockandcode.cursos.data.models.CourseDto
import com.rockandcode.cursos.data.models.CourseLevelDto
import com.rockandcode.cursos.data.models.DocumentTypeDto
import com.rockandcode.cursos.data.models.InstructorDto
import com.rockandcode.cursos.data.models.RangeMedalDto
import com.rockandcode.cursos.data.models.ScheduleDto
import com.rockandcode.cursos.data.models.UserCourseProgressDto
import com.rockandcode.cursos.data.models.UserDto
import com.rockandcode.cursos.data.models.UserProgressDto
import com.rockandcode.cursos.data.models.VideoItemDto

object MockDataSource {
    val instructorsDto =
        listOf(
            InstructorDto(
                id = 1,
                name = "Juan Perez",
                avatarUrl = "https://.../juan.png",
                bio = "",
                experience = "",
                specialization = "",
            ),
            InstructorDto(
                id = 2,
                name = "Maximiliano De Pietro",
                avatarUrl = "https://miel.unlam.edu.ar/data2/avatares/34870524.jpg?1586394949",
                bio = "",
                experience = "10 años en desarrollo móvil",
                specialization = "Android & Kotlin",
            ),
            InstructorDto(
                id = 3,
                name = "Heliana Vera",
                avatarUrl = "https://miel.unlam.edu.ar/data2/avatares/29698686.jpg?1592002555",
                bio = "",
                experience = "10 años en desarrollo móvil",
                specialization =
                    "Diseño de interfaces, Diseño gráfico, Community manager, " +
                        "Gestión en publicidad gráfica televisiva",
            ),
            InstructorDto(
                id = 3,
                name = "Christian Olivera",
                avatarUrl =
                    "https://scontent.feze9-1.fna.fbcdn.net/v/t1.6435-1" +
                        "/106390814_10221562122258462_2961036162880397966_n.jpg?" +
                        "stp=dst-jpg_s200x200_tt6&_nc_cat=105&ccb=1-7&_nc_sid=e99d92&_nc_ohc=" +
                        "1kHK53hT0E4Q7kNvwE0uu74&_nc_oc=AdkYZAi4BLNO7I7tyJePK6fN_0IRqa8IWvWnNpd1zx" +
                        "OwmGaQl_Nt8K6PN1bITIzMFIPUN_LmqU2-nkzTjb7NPpxw&_nc_zt=24&_nc_ht=scontent." +
                        "feze9-1.fna&_nc_gid=kQFpPqxKUxhoi93SwriHhA&oh=00_AfPrrq5odr6RG4hkSr1Z1PCX" +
                        "-nQFJ5O5HAlLHm_2IwAnVw&oe=68885ED2",
                bio = "",
                experience = "Guitarrista y compositor",
                specialization = "Guitarra, Lenguaje musical, Producción musical",
            ),
        )

    val categoriesDto =
        listOf(
            CategoryDto(
                id = 1,
                name = "Android",
                imageUrl =
                    "https://images.cults3d.com/veaKRfRlS0ejW7ZecLQIAX-712M=/516x516/" +
                        "filters:no_upscale():format(webp)/https://fbi.cults3d.com/uploaders" +
                        "/33634176/illustration-file/dfe3e06f-3b35-49c2-babe-e8705e9bdd52/ANDROID-LOGO-1.png",
            ),
            CategoryDto(
                id = 2,
                name = "C#",
                imageUrl =
                    "https://img.icons8.com/?size=100&id=Fycm8TUhWmFU&format=png&color=000000",
            ),
            CategoryDto(
                id = 3,
                name = "Matemática",
                imageUrl =
                    "https://aeac.science/wp-content/uploads/2020/06/matematicas.jpg",
            ),
            CategoryDto(
                id = 4,
                name = "Lengua",
                imageUrl =
                    "https://media.licdn.com/dms/image/v2/C5603AQHgiNd9G09-7A/profile-" +
                        "displayphoto-shrink_400_400/profile-displayphoto-shrink_400_400/0/" +
                        "1516975788273?e=1756339200&v=beta&t=dTJAHsnbk-fdLN3HAodYrenD14vPxwg2OYP0nlIyI3I",
            ),
            CategoryDto(
                id = 5,
                name = "Desarrollo",
                imageUrl = "https://.../dev.png",
            ),
            CategoryDto(
                id = 6,
                name = "Base de datos",
                imageUrl = "https://concepto.de/wp-content/uploads/2018/04/base-de-datos-min-e1523470739502.jpg",
            ),
            CategoryDto(
                id = 7,
                name = "Música",
                imageUrl = "https://cibccaracas.wordpress.com/wp-content/uploads/2016/05/musica_y_placer.jpg",
            ),
            CategoryDto(
                id = 8,
                name = "Diseño de interfaces",
                imageUrl = "https://.../dev.png",
            ),
            CategoryDto(
                id = 9,
                name = "Java",
                imageUrl = "https://.../dev.png",
            ),
        )

    val documentTypesDto =
        listOf(
            DocumentTypeDto(id = 11, name = "Clase", fileExtension = null),
            DocumentTypeDto(id = 12, name = "Ejercicio", fileExtension = null),
            DocumentTypeDto(id = 13, name = "PDF", fileExtension = "pdf"),
            DocumentTypeDto(id = 14, name = "Word", fileExtension = "docx"),
        )

    val documentsDto =
        listOf(
            CourseDocumentDto(
                id = 11,
                title = "Clase 1 - Introducción",
                description = "",
                url = "https://.../clase1.pdf",
                documentType = documentTypesDto[0],
            ),
            CourseDocumentDto(
                id = 12,
                title = "Ejercicio 1",
                description = "",
                url = "https://.../ejercicio1.docx",
                documentType = documentTypesDto[1],
            ),
            CourseDocumentDto(
                id = 13,
                title = "Manual PDF",
                description = "",
                url = "https://.../manual.pdf",
                documentType = documentTypesDto[2],
            ),
        )

    val levelsDto =
        listOf(
            CourseLevelDto(
                id = 11,
                name = "Principiante",
                description = "Curso para personas sin experiencia previa",
            ),
            CourseLevelDto(
                id = 12,
                name = "Intermedio",
                description = "Para quienes tienen conocimientos básicos",
            ),
            CourseLevelDto(
                id = 13,
                name = "Avanzado",
                description = "Curso para usuarios avanzados",
            ),
        )

    val coursesDto: List<CourseDto>
        get() =
            listOf(
                CourseDto(
                    id = 1,
                    title = "Android Jetpack Compose",
                    description =
                        "Jetpack Compose es el kit de herramientas moderno recomendado " +
                            "por Android para compilar IU nativa. Simplifica y acelera el desarrollo " +
                            "de la interfaz de usuario en Android. Dale vida rápidamente a tu app con " +
                            "menos código, herramientas poderosas y API de Kotlin intuitivas.",
                    thumbnailUrl =
                        "https://dropinblog.net/cdn-cgi/image/fit=scale-down,width=1400" +
                            "/34249715/files/kotlin-y-jetpack-compose.png",
                    rating = 3.5,
                    price = 250.0,
                    instructors = listOf(instructorsDto[1]),
                    categories = listOf(categoriesDto[0], categoriesDto[4]),
                    schedule =
                        listOf(
                            ScheduleDto("Lunes", "18:00", "20:00"),
                            ScheduleDto("Miércoles", "18:00", "20:00"),
                        ),
                    totalStudents = 1000,
                    items =
                        listOf(
                            VideoItemDto(
                                id = 1,
                                title = "Introducción a Jetpack Compose",
                                description = "Conceptos básicos...",
                                300,
                                videoUrl = "https://video1.mp4",
                                isPreview = true,
                                order = 0,
                            ),
                            VideoItemDto(
                                id = 2,
                                title = "Diseños y Columnas/Filas",
                                description = "Cómo crear diseños...",
                                1200,
                                videoUrl = "https://video2.mp4",
                                isPreview = false,
                                order = 1,
                            ),
                            VideoItemDto(
                                id = 3,
                                title = "Estado y Comportamiento",
                                description = "Manejo del estado...",
                                1500,
                                videoUrl = "https://video3.mp4",
                                isPreview = false,
                                order = 2,
                            ),
                            VideoItemDto(
                                id = 4,
                                title = "Temas y Animaciones",
                                description = "Personalización...",
                                1500,
                                videoUrl = "https://video4.mp4",
                                isPreview = false,
                                order = 3,
                            ),
                            VideoItemDto(
                                id = 5,
                                title = "Navegación",
                                description = "Implementación de la navegación...",
                                1500,
                                videoUrl = "https://video5.mp4",
                                isPreview = false,
                                order = 4,
                            ),
                            VideoItemDto(
                                id = 6,
                                title = "Arquitectura",
                                description = "Conceptos de arquitectura...",
                                1500,
                                videoUrl = "https://video6.mp4",
                                isPreview = false,
                                order = 5,
                            ),
                            VideoItemDto(
                                id = 7,
                                title = "Accesibilidad",
                                description = "Creación de interfaces accesibles...",
                                1500,
                                videoUrl = "https://video7.mp4",
                                isPreview = false,
                                order = 6,
                            ),
                            VideoItemDto(
                                id = 8,
                                title = "Pruebas",
                                description = "Pruebas automatizadas para Compose...",
                                1500,
                                videoUrl = "https://video8.mp4",
                                isPreview = false,
                                order = 7,
                            ),
                            VideoItemDto(
                                id = 9,
                                title = "Rendimiento",
                                description = "Optimización del rendimiento...",
                                1500,
                                videoUrl = "https://video9.mp4",
                                isPreview = false,
                                order = 8,
                            ),
                            VideoItemDto(
                                id = 10,
                                title = "Factores de Forma",
                                description = "Adaptación de la interfaz...",
                                1500,
                                videoUrl = "https://video10.mp4",
                                isPreview = false,
                                order = 9,
                            ),
                            VideoItemDto(
                                11,
                                title = "Integración con otros componentes",
                                description = "Uso de APIs de red...",
                                1500,
                                videoUrl = "https://video11.mp4",
                                isPreview = false,
                                order = 10,
                            ),
                            VideoItemDto(
                                12,
                                title = "Patrones de diseño",
                                description = "Introducción a patrones comunes...",
                                1500,
                                videoUrl = "https://video12.mp4",
                                isPreview = false,
                                order = 11,
                            ),
                        ),
                    documents = documentsDto,
                    level = levelsDto[0],
                ),
                CourseDto(
                    id = 2,
                    title = "SQL Avanzado",
                    description = "Aprende base de datos relacional...",
                    thumbnailUrl = "https://compraco.com.br/cdn/shop/articles/O-que-e-SQL-Server.jpg?v=1716456631",
                    rating = 3.7,
                    price = 250.0,
                    instructors = listOf(instructorsDto[1]),
                    categories = listOf(categoriesDto[5]),
                    schedule =
                        listOf(
                            ScheduleDto("Martes", "12:00", "16:00"),
                            ScheduleDto("Miércoles", "18:00", "20:00"),
                        ),
                    totalStudents = 500,
                    items =
                        listOf(
                            VideoItemDto(
                                id = 1,
                                title = "¿Qué es SQL y para qué sirve?",
                                description = "Se explica el concepto...",
                                300,
                                videoUrl = "https://video1.mp4",
                                isPreview = true,
                                order = 1,
                            ),
                            VideoItemDto(
                                id = 2,
                                title = "Instalación y configuración",
                                description = "Se guía sobre cómo instalar...",
                                1200,
                                videoUrl = "https://video2.mp4",
                                isPreview = false,
                                order = 2,
                            ),
                            VideoItemDto(
                                id = 3,
                                title = "Fundamentos de SQL",
                                description = "Se introducen los tipos de datos...",
                                1500,
                                videoUrl = "https://video3.mp4",
                                isPreview = false,
                                order = 3,
                            ),
                            VideoItemDto(
                                id = 4,
                                title = "Lenguaje de Definición de Datos (DDL)",
                                description = "Se aprenden comandos para crear...",
                                1500,
                                videoUrl = "https://video4.mp4",
                                isPreview = false,
                                order = 4,
                            ),
                            VideoItemDto(
                                id = 5,
                                title = "Lenguaje de Manipulación de Datos (DML)",
                                description = "Se aprenden comandos para insertar...",
                                1500,
                                videoUrl = "https://video5.mp4",
                                isPreview = false,
                                order = 5,
                            ),
                            VideoItemDto(
                                id = 6,
                                title = "Selección de datos",
                                description = "Se estudian las cláusulas SELECT...",
                                1500,
                                videoUrl = "https://video6.mp4",
                                isPreview = false,
                                order = 6,
                            ),
                            VideoItemDto(
                                id = 7,
                                title = "Uniones (JOIN)",
                                description = "Se aprenden diferentes tipos...",
                                1500,
                                videoUrl = "https://video7.mp4",
                                isPreview = false,
                                order = 7,
                            ),
                            VideoItemDto(
                                id = 8,
                                title = "Funciones de Agregación",
                                description = "Se estudian funciones como COUNT...",
                                1500,
                                videoUrl = "https://video8.mp4",
                                isPreview = false,
                                order = 8,
                            ),
                        ),
                    documents = emptyList(),
                    level = levelsDto[2],
                ),
                CourseDto(
                    id = 3,
                    title = "Desarrollo de interfaces",
                    description =
                        "Este curso de desarrollo de interfaces es una excelente opción " +
                            "para quienes desean aprender a crear interfaces digitales atractivas, " +
                            "funcionales y fáciles de usar, ya sea para aplicaciones web, móviles o de escritorio. ",
                    thumbnailUrl = "https://www.fasabri.com/wp-content/uploads/diseno-de-interfaz-de-usuario.jpg",
                    rating = 4.8,
                    price = 250.0,
                    instructors = listOf(instructorsDto[2]),
                    categories = listOf(categoriesDto[5]),
                    schedule =
                        listOf(
                            ScheduleDto("Miercoles", "19:00", "23:00"),
                        ),
                    totalStudents = 250,
                    items =
                        listOf(
                            VideoItemDto(
                                id = 1,
                                title = "Introducción a la Comunicación Visual",
                                description = "Elementos del Proceso comunicativo.",
                                durationSeconds = 300,
                                videoUrl = "https://video1.mp4",
                                isPreview = true,
                                order = 1,
                            ),
                            VideoItemDto(
                                id = 2,
                                title = "Sistemas de Diseño",
                                description = "",
                                durationSeconds = 1200,
                                videoUrl = "https://video1.mp4",
                                isPreview = false,
                                order = 2,
                            ),
                            VideoItemDto(
                                id = 3,
                                title = "Color",
                                description = "",
                                durationSeconds = 1500,
                                videoUrl = "https://video2.mp4",
                                isPreview = false,
                                order = 3,
                            ),
                            VideoItemDto(
                                id = 4,
                                title = "Introducción a las Interfaces",
                                description = "",
                                durationSeconds = 1500,
                                videoUrl = "https://video3.mp4",
                                isPreview = false,
                                order = 4,
                            ),
                            VideoItemDto(
                                id = 5,
                                title = "Interacción Humano Dispositivo",
                                description = "",
                                durationSeconds = 1500,
                                videoUrl = "https://video4.mp4",
                                isPreview = false,
                                order = 5,
                            ),
                            VideoItemDto(
                                id = 6,
                                title = "Usabilidad y Experiencia de Usuario",
                                description = "",
                                durationSeconds = 1500,
                                videoUrl = "https://video5.mp4",
                                isPreview = false,
                                order = 6,
                            ),
                            VideoItemDto(
                                id = 7,
                                title = "Evaluación Heurística",
                                description = "",
                                durationSeconds = 1500,
                                videoUrl = "https://video6.mp4",
                                isPreview = false,
                                order = 7,
                            ),
                            VideoItemDto(
                                id = 8,
                                title = "Prototipado",
                                description = "",
                                durationSeconds = 1500,
                                videoUrl = "https://video7.mp4",
                                isPreview = false,
                                order = 8,
                            ),
                        ),
                    documents = emptyList(),
                    level = levelsDto[0],
                ),
                CourseDto(
                    id = 4,
                    title = "Teoría musical",
                    description =
                        "Fundamentos de la música, teoría musical " +
                            "(notas, acordes, escalas, ritmo), historia de la música, " +
                            "entrenamiento vocal, producción musical, y/o aprendizaje de un instrumento",
                    thumbnailUrl =
                        "https://i0.wp.com/www.artsmusica.net/cursos/wp-content/uploads" +
                            "/2019/12/solfeo_teoria_musica_III-portada-1.jpg?w=750&ssl=1",
                    rating = 5.0,
                    price = 250.0,
                    instructors = listOf(instructorsDto[3]),
                    categories = listOf(categoriesDto[5]),
                    schedule =
                        listOf(
                            ScheduleDto("Miercoles", "19:00", "23:00"),
                        ),
                    totalStudents = 250,
                    items =
                        listOf(
                            VideoItemDto(
                                id = 1,
                                title = "Introducción",
                                description = "",
                                1200,
                                videoUrl = "https://video1.mp4",
                                isPreview = true,
                                order = 1,
                            ),
                            VideoItemDto(
                                id = 2,
                                title = "Teoria musical",
                                description = "",
                                1500,
                                videoUrl = "https://video2.mp4",
                                isPreview = false,
                                order = 2,
                            ),
                            VideoItemDto(
                                id = 3,
                                title = "Producción musical",
                                description = "",
                                1500,
                                videoUrl = "https://video3.mp4",
                                isPreview = false,
                                order = 3,
                            ),
                            VideoItemDto(
                                id = 4,
                                title = "Interpretación musical",
                                description = "",
                                1500,
                                videoUrl = "https://video4.mp4",
                                isPreview = false,
                                order = 4,
                            ),
                            VideoItemDto(
                                id = 5,
                                title = "Otros contenidos",
                                description = "",
                                1500,
                                videoUrl = "https://video5.mp4",
                                isPreview = false,
                                order = 5,
                            ),
                        ),
                    documents = emptyList(),
                    level = levelsDto[0],
                ),
            )

    val medalsDto =
        listOf(
            RangeMedalDto(
                id = 11,
                name = "Nivel 1",
                description = "Completaste hasta 100 puntos",
                icon = "🏆",
                threshold = 0,
            ),
            RangeMedalDto(
                id = 12,
                name = "Nivel 2",
                description = "Completaste más de 500 puntos",
                icon = "🏆",
                threshold = 500,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 3",
                description = "Completaste más de 1000 puntos",
                icon = "🏆",
                threshold = 1000,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 4",
                description = "Completaste más de 1500 puntos",
                icon = "🏆",
                threshold = 1500,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 5",
                description = "Completaste más de 2000 puntos",
                icon = "🏆",
                threshold = 2000,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 6",
                description = "Completaste más de 2500 puntos",
                icon = "🏆",
                threshold = 2500,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 7",
                description = "Completaste más de 3000 puntos",
                icon = "🏆",
                threshold = 3000,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 8",
                description = "Completaste más de 3500 puntos",
                icon = "🏆",
                threshold = 3500,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 9",
                description = "Completaste más de 4000 puntos",
                icon = "🏆",
                threshold = 4000,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 10",
                description = "Completaste más de 4500 puntos",
                icon = "🏆",
                threshold = 4500,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 11",
                description = "Completaste más de 5000 puntos",
                icon = "🏆",
                threshold = 5000,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 12",
                description = "Completaste más de 5500 puntos",
                icon = "🏆",
                threshold = 5500,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 13",
                description = "Completaste más de 6000 puntos",
                icon = "🏆",
                threshold = 6000,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 14",
                description = "Completaste más de 6500 puntos",
                icon = "🏆",
                threshold = 6500,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 15",
                description = "Completaste más de 7000 puntos",
                icon = "🏆",
                threshold = 7000,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 16",
                description = "Completaste más de 7500 puntos",
                icon = "🏆",
                threshold = 7500,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 17",
                description = "Completaste más de 8000 puntos",
                icon = "🏆",
                threshold = 8000,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 18",
                description = "Completaste más de 8500 puntos",
                icon = "🏆",
                threshold = 8500,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 19",
                description = "Completaste más de 9000 puntos",
                icon = "🏆",
                threshold = 9000,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 20",
                description = "Completaste más de 9500 puntos",
                icon = "🏆",
                threshold = 9500,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 21",
                description = "Completaste más de 10000 puntos",
                icon = "🏆",
                threshold = 10000,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 22",
                description = "Completaste más de 10500 puntos",
                icon = "🏆",
                threshold = 10500,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 23",
                description = "Completaste más de 11000 puntos",
                icon = "🏆",
                threshold = 11000,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 24",
                description = "Completaste más de 11500 puntos",
                icon = "🏆",
                threshold = 11500,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 25",
                description = "Completaste más de 12000 puntos",
                icon = "🏆",
                threshold = 12000,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 26",
                description = "Completaste más de 12500 puntos",
                icon = "🏆",
                threshold = 12500,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 27",
                description = "Completaste más de 13000 puntos",
                icon = "🏆",
                threshold = 13000,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 28",
                description = "Completaste más de 13500 puntos",
                icon = "🏆",
                threshold = 13500,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 29",
                description = "Completaste más de 14000 puntos",
                icon = "🏆",
                threshold = 14000,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 30",
                description = "Completaste más de 14500 puntos",
                icon = "🏆",
                threshold = 14500,
            ),
        )

    var userDto =
        UserDto(
            id = 1,
            name = "Natalia Mucci",
            email = "nataliaemucci@qmail.com",
            avatarUrl =
                "https://media.licdn.com/dms/image/v2/C5603AQHgiNd9G09-7A/profile-" +
                    "displayphoto-shrink_400_400/profile-displayphoto-shrink_400_400/0/" +
                    "1516975788273?e=1756339200&v=beta&t=dTJAHsnbk-fdLN3HAodYrenD14vPxwg2OYP0nlIyI3I",
            purchasedCourses = coursesDto.take(2),
            progressByCourse =
                listOf(
                    UserCourseProgressDto(
                        courseId = 1,
                        videoProgress =
                            listOf(
                                UserProgressDto(1, 300), // completo video 1
                                UserProgressDto(2, 600), // mitad video 2
                            ),
                    ),
                    UserCourseProgressDto(
                        courseId = 2,
                        videoProgress =
                            listOf(
                                UserProgressDto(1, 300),
                                UserProgressDto(2, 1200),
                                UserProgressDto(3, 1500),
                                UserProgressDto(4, 1500),
                            ),
                    ),
                ),
            score = 5400,
            preferredCategories = categoriesDto.take(2),
        )

    @Suppress("ktlint:standard:backing-property-naming")
    internal val pprogressByCourse =
        mutableMapOf<Int, MutableList<UserProgressDto>>().apply {
            userDto.progressByCourse.forEach { progress ->
                put(progress.courseId, progress.videoProgress.toMutableList())
            }
        }

    fun syncUserProgress() {
        userDto =
            userDto.copy(
                progressByCourse =
                    pprogressByCourse.map { (courseId, progressList) ->
                        UserCourseProgressDto(courseId, progressList.toList())
                    },
            )
    }

    fun toggleVideoWatched(
        courseId: Int,
        videoId: Int,
    ) {
        val videoList = coursesDto.find { it.id == courseId }?.items ?: return
        val videoDuration = videoList.find { it.id == videoId }?.durationSeconds ?: return

        val progressList = pprogressByCourse.getOrPut(courseId) { mutableListOf() }
        val existingIndex = progressList.indexOfFirst { it.videoId == videoId }

        if (existingIndex >= 0) {
            progressList.removeAt(existingIndex)
        } else {
            progressList.add(UserProgressDto(videoId, videoDuration))
        }
        syncUserProgress()
    }
}
