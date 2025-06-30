package com.rockandcode.cursos.data.datasources.local

import com.rockandcode.cursos.data.models.CategoryDto
import com.rockandcode.cursos.data.models.CertificateDto
import com.rockandcode.cursos.data.models.CourseDocumentDto
import com.rockandcode.cursos.data.models.CourseDto
import com.rockandcode.cursos.data.models.CourseIncludeItemDto
import com.rockandcode.cursos.data.models.CourseLevelDto
import com.rockandcode.cursos.data.models.DocumentTypeDto
import com.rockandcode.cursos.data.models.IncludeTypeDto
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
                avatarUrl = "https://media.gq.com.mx/photos/5c6c494700f5a75446d1db89/master/w_1600%2Cc_limit/corbata.jpg",
                bio = "Licenciado en Maquinarias Electrónicas - Jefe Sector Seguridad en Security Company S.A. - Buenos Aires",
                experience = "Titular de Cátedra en la UBA. 20 años como jefe del sector de seguridad en una empresa multinacional",
                specialization = "Técnico en Electrónica",
            ),
            InstructorDto(
                id = 2,
                name = "Maximiliano De Pietro",
                avatarUrl = "https://miel.unlam.edu.ar/data2/avatares/34870524.jpg?1586394949",
                bio = "Desarrollador Senior - Escritor y divulgador de conocimientos informáticos.",
                experience = "10 años en desarrollo móvil",
                specialization = "Android & Kotlin",
            ),
            InstructorDto(
                id = 3,
                name = "Heliana Vera",
                avatarUrl = "https://miel.unlam.edu.ar/data2/avatares/29698686.jpg?1592002555",
                bio = "Licenciada en Bellas Artes - Docente en Universidad de Bellas Artes - Artista Gráfica",
                experience = "Coordinadora de grupos a cargo del desarrollo de interfaces",
                specialization =
                    "Diseño de interfaces, Diseño gráfico, Community manager, " +
                        "Gestión en publicidad gráfica televisiva",
            ),
            InstructorDto(
                id = 4,
                name = "Christian Olivera",
                avatarUrl =
                    "https://scontent.feze9-1.fna.fbcdn.net/v/t1.6435-1" +
                        "/106390814_10221562122258462_2961036162880397966_n.jpg?" +
                        "stp=dst-jpg_s200x200_tt6&_nc_cat=105&ccb=1-7&_nc_sid=e99d92&_nc_ohc=" +
                        "1kHK53hT0E4Q7kNvwE0uu74&_nc_oc=AdkYZAi4BLNO7I7tyJePK6fN_0IRqa8IWvWnNpd1zx" +
                        "OwmGaQl_Nt8K6PN1bITIzMFIPUN_LmqU2-nkzTjb7NPpxw&_nc_zt=24&_nc_ht=scontent." +
                        "feze9-1.fna&_nc_gid=kQFpPqxKUxhoi93SwriHhA&oh=00_AfPrrq5odr6RG4hkSr1Z1PCX" +
                        "-nQFJ5O5HAlLHm_2IwAnVw&oe=68885ED2",
                bio = "Escritor y compositor - Guitarrista y Manager de La Banda Del Fondo - Ganador de Carlos Gardel de Oro 2023",
                experience = "Guitarrista y compositor",
                specialization = "Guitarra, Lenguaje musical, Producción musical",
            ),
            InstructorDto(
                id = 5,
                name = "Federico Cipeli",
                avatarUrl =
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZCtiyXTcBj5PVCAy_KeRF26uuwbWpybr_Jw&s",
                bio = "Licenciado en Matemática - Desarrollador de Teoremas Físicos y Matemáticos",
                experience = "Gerente del Laboratorio Matemático de la UnLaM",
                specialization = "Teoría de Números y Álgebra",
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
            DocumentTypeDto(id = 1, name = "Clase", fileExtension = null),
            DocumentTypeDto(id = 2, name = "Ejercicio", fileExtension = null),
            DocumentTypeDto(id = 3, name = "PDF", fileExtension = "pdf"),
            DocumentTypeDto(id = 4, name = "Word", fileExtension = "docx"),
        )

    val documentsDto =
        listOf(
            CourseDocumentDto(
                id = 1,
                title = "Clase 1 - Introducción",
                description = "",
                url = "https://.../clase1.pdf",
                documentType = documentTypesDto[0],
            ),
            CourseDocumentDto(
                id = 2,
                title = "Ejercicio 1",
                description = "",
                url = "https://.../ejercicio1.docx",
                documentType = documentTypesDto[1],
            ),
            CourseDocumentDto(
                id = 3,
                title = "Manual PDF",
                description = "",
                url = "https://.../manual.pdf",
                documentType = documentTypesDto[2],
            ),
        )

    val levelsDto =
        listOf(
            CourseLevelDto(
                id = 1,
                name = "Principiante",
                description = "Curso para personas sin experiencia previa",
            ),
            CourseLevelDto(
                id = 2,
                name = "Intermedio",
                description = "Para quienes tienen conocimientos básicos",
            ),
            CourseLevelDto(
                id = 3,
                name = "Avanzado",
                description = "Curso para usuarios avanzados",
            ),
        )

    val certificates =
        listOf(
            CertificateDto(courseId = 1, userId = 1, "https://example.com/certs/user1_course1.pdf"),
            CertificateDto(courseId = 2, userId = 1, "https://example.com/certs/user1_course2.pdf"),
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
                                durationSeconds = 300,
                                videoUrl = "https://video1.mp4",
                                isPreview = true,
                                order = 0,
                            ),
                            VideoItemDto(
                                id = 2,
                                title = "Diseños y Columnas/Filas",
                                description = "Cómo crear diseños...",
                                durationSeconds = 1200,
                                videoUrl = "https://video2.mp4",
                                isPreview = false,
                                order = 1,
                            ),
                            VideoItemDto(
                                id = 3,
                                title = "Estado y Comportamiento",
                                description = "Manejo del estado...",
                                durationSeconds = 1500,
                                videoUrl = "https://video3.mp4",
                                isPreview = false,
                                order = 2,
                            ),
                            VideoItemDto(
                                id = 4,
                                title = "Temas y Animaciones",
                                description = "Personalización...",
                                durationSeconds = 1500,
                                videoUrl = "https://video4.mp4",
                                isPreview = false,
                                order = 3,
                            ),
                            VideoItemDto(
                                id = 5,
                                title = "Navegación",
                                description = "Implementación de la navegación...",
                                durationSeconds = 1500,
                                videoUrl = "https://video5.mp4",
                                isPreview = false,
                                order = 4,
                            ),
                            VideoItemDto(
                                id = 6,
                                title = "Arquitectura",
                                description = "Conceptos de arquitectura...",
                                durationSeconds = 1500,
                                videoUrl = "https://video6.mp4",
                                isPreview = false,
                                order = 5,
                            ),
                            VideoItemDto(
                                id = 7,
                                title = "Accesibilidad",
                                description = "Creación de interfaces accesibles...",
                                durationSeconds = 1500,
                                videoUrl = "https://video7.mp4",
                                isPreview = false,
                                order = 6,
                            ),
                            VideoItemDto(
                                id = 8,
                                title = "Pruebas",
                                description = "Pruebas automatizadas para Compose...",
                                durationSeconds = 1500,
                                videoUrl = "https://video8.mp4",
                                isPreview = false,
                                order = 7,
                            ),
                            VideoItemDto(
                                id = 9,
                                title = "Rendimiento",
                                description = "Optimización del rendimiento...",
                                durationSeconds = 1500,
                                videoUrl = "https://video9.mp4",
                                isPreview = false,
                                order = 8,
                            ),
                            VideoItemDto(
                                id = 10,
                                title = "Factores de Forma",
                                description = "Adaptación de la interfaz...",
                                durationSeconds = 1500,
                                videoUrl = "https://video10.mp4",
                                isPreview = false,
                                order = 9,
                            ),
                            VideoItemDto(
                                11,
                                title = "Integración con otros componentes",
                                description = "Uso de APIs de red...",
                                durationSeconds = 1500,
                                videoUrl = "https://video11.mp4",
                                isPreview = false,
                                order = 10,
                            ),
                            VideoItemDto(
                                12,
                                title = "Patrones de diseño",
                                description = "Introducción a patrones comunes...",
                                durationSeconds = 1500,
                                videoUrl = "https://video12.mp4",
                                isPreview = false,
                                order = 11,
                            ),
                        ),
                    documents = documentsDto,
                    level = levelsDto[0],
                    includes =
                        listOf(
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 1,
                                        name = "Video",
                                        iconUrl = "https://cdn.tuapp.com/icons/video.png",
                                    ),
                                description = "7 horas 52 de video bajo demanda",
                            ),
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 2,
                                        name = "Documento",
                                        iconUrl = "https://cdn.tuapp.com/icons/doc.png",
                                    ),
                                description = "Material descargable (PDFs, guías)",
                            ),
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 3,
                                        name = "Certificado",
                                        iconUrl = "https://cdn.tuapp.com/icons/certificate.png",
                                    ),
                                description = "Certificado de finalización",
                            ),
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 4,
                                        name = "Acceso de por vida",
                                        iconUrl = "https://cdn.tuapp.com/icons/infinity.png",
                                    ),
                                description = "Acceso de por vida al contenido",
                            ),
                        ),
                    requirements = "Conocimientos básicos de programación en Kotlin",
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
                                id = 13,
                                title = "¿Qué es SQL y para qué sirve?",
                                description = "Se explica el concepto...",
                                durationSeconds = 300,
                                videoUrl = "https://video1.mp4",
                                isPreview = true,
                                order = 1,
                            ),
                            VideoItemDto(
                                id = 14,
                                title = "Instalación y configuración",
                                description = "Se guía sobre cómo instalar...",
                                durationSeconds = 1200,
                                videoUrl = "https://video2.mp4",
                                isPreview = false,
                                order = 2,
                            ),
                            VideoItemDto(
                                id = 15,
                                title = "Fundamentos de SQL",
                                description = "Se introducen los tipos de datos...",
                                durationSeconds = 1500,
                                videoUrl = "https://video3.mp4",
                                isPreview = false,
                                order = 3,
                            ),
                            VideoItemDto(
                                id = 16,
                                title = "Lenguaje de Definición de Datos (DDL)",
                                description = "Se aprenden comandos para crear...",
                                durationSeconds = 1500,
                                videoUrl = "https://video4.mp4",
                                isPreview = false,
                                order = 4,
                            ),
                            VideoItemDto(
                                id = 17,
                                title = "Lenguaje de Manipulación de Datos (DML)",
                                description = "Se aprenden comandos para insertar...",
                                durationSeconds = 1500,
                                videoUrl = "https://video5.mp4",
                                isPreview = false,
                                order = 5,
                            ),
                            VideoItemDto(
                                id = 18,
                                title = "Selección de datos",
                                description = "Se estudian las cláusulas SELECT...",
                                durationSeconds = 1500,
                                videoUrl = "https://video6.mp4",
                                isPreview = false,
                                order = 6,
                            ),
                            VideoItemDto(
                                id = 19,
                                title = "Uniones (JOIN)",
                                description = "Se aprenden diferentes tipos...",
                                durationSeconds = 1500,
                                videoUrl = "https://video7.mp4",
                                isPreview = false,
                                order = 7,
                            ),
                            VideoItemDto(
                                id = 20,
                                title = "Funciones de Agregación",
                                description = "Se estudian funciones como COUNT...",
                                durationSeconds = 1500,
                                videoUrl = "https://video8.mp4",
                                isPreview = false,
                                order = 8,
                            ),
                        ),
                    documents = emptyList(),
                    level = levelsDto[2],
                    includes =
                        listOf(
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 1,
                                        name = "Video",
                                        iconUrl = "https://cdn.tuapp.com/icons/video.png",
                                    ),
                                description = "10 horas de video bajo demanda",
                            ),
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 2,
                                        name = "Documento",
                                        iconUrl = "https://cdn.tuapp.com/icons/doc.png",
                                    ),
                                description = "Material descargable (PDFs, guías)",
                            ),
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 3,
                                        name = "Certificado",
                                        iconUrl = "https://cdn.tuapp.com/icons/certificate.png",
                                    ),
                                description = "Certificado de finalización",
                            ),
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 4,
                                        name = "Acceso de por vida",
                                        iconUrl = "https://cdn.tuapp.com/icons/infinity.png",
                                    ),
                                description = "Acceso de por vida al contenido",
                            ),
                        ),
                    requirements = "Conocimientos básicos de programación",
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
                                id = 21,
                                title = "Introducción a la Comunicación Visual",
                                description = "Elementos del Proceso comunicativo.",
                                durationSeconds = 300,
                                videoUrl = "https://video1.mp4",
                                isPreview = true,
                                order = 1,
                            ),
                            VideoItemDto(
                                id = 22,
                                title = "Sistemas de Diseño",
                                description = "",
                                durationSeconds = 1200,
                                videoUrl = "https://video1.mp4",
                                isPreview = false,
                                order = 2,
                            ),
                            VideoItemDto(
                                id = 23,
                                title = "Color",
                                description = "",
                                durationSeconds = 1500,
                                videoUrl = "https://video2.mp4",
                                isPreview = false,
                                order = 3,
                            ),
                            VideoItemDto(
                                id = 24,
                                title = "Introducción a las Interfaces",
                                description = "",
                                durationSeconds = 1500,
                                videoUrl = "https://video3.mp4",
                                isPreview = false,
                                order = 4,
                            ),
                            VideoItemDto(
                                id = 25,
                                title = "Interacción Humano Dispositivo",
                                description = "",
                                durationSeconds = 1500,
                                videoUrl = "https://video4.mp4",
                                isPreview = false,
                                order = 5,
                            ),
                            VideoItemDto(
                                id = 26,
                                title = "Usabilidad y Experiencia de Usuario",
                                description = "",
                                durationSeconds = 1500,
                                videoUrl = "https://video5.mp4",
                                isPreview = false,
                                order = 6,
                            ),
                            VideoItemDto(
                                id = 27,
                                title = "Evaluación Heurística",
                                description = "",
                                durationSeconds = 1500,
                                videoUrl = "https://video6.mp4",
                                isPreview = false,
                                order = 7,
                            ),
                            VideoItemDto(
                                id = 28,
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
                    includes =
                        listOf(
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 1,
                                        name = "Video",
                                        iconUrl = "https://cdn.tuapp.com/icons/video.png",
                                    ),
                                description = "15 horas de video bajo demanda",
                            ),
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 2,
                                        name = "Documento",
                                        iconUrl = "https://cdn.tuapp.com/icons/doc.png",
                                    ),
                                description = "Material descargable (PDFs, guías)",
                            ),
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 3,
                                        name = "Certificado",
                                        iconUrl = "https://cdn.tuapp.com/icons/certificate.png",
                                    ),
                                description = "Certificado de finalización",
                            ),
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 4,
                                        name = "Acceso de por vida",
                                        iconUrl = "https://cdn.tuapp.com/icons/infinity.png",
                                    ),
                                description = "Acceso de por vida al contenido",
                            ),
                        ),
                    requirements = "No necesitas conocimientos previos",
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
                                id = 29,
                                title = "Introducción",
                                description = "",
                                durationSeconds = 1200,
                                videoUrl = "https://video1.mp4",
                                isPreview = true,
                                order = 1,
                            ),
                            VideoItemDto(
                                id = 30,
                                title = "Teoria musical",
                                description = "",
                                durationSeconds = 1500,
                                videoUrl = "https://video2.mp4",
                                isPreview = false,
                                order = 2,
                            ),
                            VideoItemDto(
                                id = 31,
                                title = "Producción musical",
                                description = "",
                                durationSeconds = 1500,
                                videoUrl = "https://video3.mp4",
                                isPreview = false,
                                order = 3,
                            ),
                            VideoItemDto(
                                id = 32,
                                title = "Interpretación musical",
                                description = "",
                                durationSeconds = 1500,
                                videoUrl = "https://video4.mp4",
                                isPreview = false,
                                order = 4,
                            ),
                            VideoItemDto(
                                id = 33,
                                title = "Otros contenidos",
                                description = "",
                                durationSeconds = 1500,
                                videoUrl = "https://video5.mp4",
                                isPreview = false,
                                order = 5,
                            ),
                        ),
                    documents = emptyList(),
                    level = levelsDto[0],
                    includes =
                        listOf(
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 1,
                                        name = "Video",
                                        iconUrl = "https://cdn.tuapp.com/icons/video.png",
                                    ),
                                description = "10 horas de video bajo demanda",
                            ),
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 2,
                                        name = "Documento",
                                        iconUrl = "https://cdn.tuapp.com/icons/doc.png",
                                    ),
                                description = "Material descargable (PDFs, guías)",
                            ),
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 3,
                                        name = "Certificado",
                                        iconUrl = "https://cdn.tuapp.com/icons/certificate.png",
                                    ),
                                description = "Certificado de finalización",
                            ),
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 4,
                                        name = "Acceso de por vida",
                                        iconUrl = "https://cdn.tuapp.com/icons/infinity.png",
                                    ),
                                description = "Acceso de por vida al contenido",
                            ),
                        ),
                    requirements = "No necesitas conocimientos previos",
                ),
                CourseDto(
                    id = 5,
                    title = "Numeración",
                    description =
                        "Sistema de numeración decimal - Valor posicional - Ubicación en la recta numérica",
                    thumbnailUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLiVyh8b7FBPv0486JEWFRHPuji-dRNpvBWw&s",
                    rating = 4.7,
                    price = 200.0,
                    instructors = listOf(instructorsDto[4]),
                    categories = listOf(categoriesDto[3]),
                    schedule =
                        listOf(
                            ScheduleDto("Jueves", "17:00", "19:00"),
                        ),
                    totalStudents = 250,
                    level = levelsDto[1],
                    requirements = "No necesitas conocimientos previos",
                    items =
                        listOf(
                            VideoItemDto(
                                id = 34,
                                title = "Introducción a la Numeración",
                                description = "Elementos numéricos.",
                                durationSeconds = 400,
                                videoUrl = "https://video1.mp4",
                                isPreview = true,
                                order = 0,
                            ),
                            VideoItemDto(
                                id = 35,
                                title = "Valor del número de acuerdo a la posición",
                                description = "",
                                durationSeconds = 1000,
                                videoUrl = "https://video1.mp4",
                                isPreview = false,
                                order = 1,
                            ),
                            VideoItemDto(
                                id = 36,
                                title = "Cómo ubicar un número en la recta",
                                description = "",
                                durationSeconds = 1200,
                                videoUrl = "https://video2.mp4",
                                isPreview = false,
                                order = 2,
                            ),
                            VideoItemDto(
                                id = 37,
                                title = "Densidad de la recta numérica",
                                description = "",
                                durationSeconds = 1300,
                                videoUrl = "https://video3.mp4",
                                isPreview = false,
                                order = 3,
                            ),
                            VideoItemDto(
                                id = 38,
                                title = "Operaciones",
                                description = "",
                                durationSeconds = 1200,
                                videoUrl = "https://video4.mp4",
                                isPreview = false,
                                order = 4,
                            ),
                        ),
                    includes =
                        listOf(
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 1,
                                        name = "Video",
                                        iconUrl = "https://cdn.tuapp.com/icons/video.png",
                                    ),
                                description = "10 horas de video bajo demanda",
                            ),
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 2,
                                        name = "Documento",
                                        iconUrl = "https://cdn.tuapp.com/icons/doc.png",
                                    ),
                                description = "Material descargable (PDFs, guías)",
                            ),
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 3,
                                        name = "Certificado",
                                        iconUrl = "https://cdn.tuapp.com/icons/certificate.png",
                                    ),
                                description = "Certificado de finalización",
                            ),
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 4,
                                        name = "Acceso de por vida",
                                        iconUrl = "https://cdn.tuapp.com/icons/infinity.png",
                                    ),
                                description = "Acceso de por vida al contenido",
                            ),
                        ),
                ),
                CourseDto(
                    id = 6,
                    title = "Base de Datos",
                    description =
                        "Curso donde aprenderás cómo armar tablas, insertar datos y hacer consultas",
                    thumbnailUrl = "https://i.sstatic.net/OAcqg.png",
                    rating = 3.2,
                    price = 300.0,
                    instructors = listOf(instructorsDto[1]),
                    categories = listOf(categoriesDto[5]),
                    schedule =
                        listOf(
                            ScheduleDto("Lunes", "20:00", "22:00"),
                            ScheduleDto("Viernes", "20:00", "22:00"),
                        ),
                    totalStudents = 250,
                    level = levelsDto[0],
                    requirements = "No necesitas conocimientos previos",
                    items =
                        listOf(
                            VideoItemDto(
                                id = 39,
                                title = "Introducción a Base de Datos",
                                description = "Componentes.",
                                durationSeconds = 700,
                                videoUrl = "https://video1.mp4",
                                isPreview = true,
                                order = 0,
                            ),
                            VideoItemDto(
                                id = 40,
                                title = "Qué es una base de datos",
                                description = "",
                                durationSeconds = 1100,
                                videoUrl = "https://video1.mp4",
                                isPreview = false,
                                order = 1,
                            ),
                            VideoItemDto(
                                id = 41,
                                title = "Cómo guardar datos",
                                description = "",
                                durationSeconds = 1200,
                                videoUrl = "https://video2.mp4",
                                isPreview = false,
                                order = 2,
                            ),
                            VideoItemDto(
                                id = 42,
                                title = "Cómo modificar datos",
                                description = "",
                                durationSeconds = 900,
                                videoUrl = "https://video3.mp4",
                                isPreview = false,
                                order = 3,
                            ),
                            VideoItemDto(
                                id = 43,
                                title = "Realizar consultas",
                                description = "",
                                durationSeconds = 800,
                                videoUrl = "https://video4.mp4",
                                isPreview = false,
                                order = 4,
                            ),
                            VideoItemDto(
                                id = 44,
                                title = "Creación de tablas",
                                description = "",
                                durationSeconds = 200,
                                videoUrl = "https://video5.mp4",
                                isPreview = false,
                                order = 5,
                            ),
                        ),
                    includes =
                        listOf(
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 1,
                                        name = "Video",
                                        iconUrl = "https://cdn.tuapp.com/icons/video.png",
                                    ),
                                description = "10 horas de video bajo demanda",
                            ),
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 2,
                                        name = "Documento",
                                        iconUrl = "https://cdn.tuapp.com/icons/doc.png",
                                    ),
                                description = "Material descargable (PDFs, guías)",
                            ),
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 3,
                                        name = "Certificado",
                                        iconUrl = "https://cdn.tuapp.com/icons/certificate.png",
                                    ),
                                description = "Certificado de finalización",
                            ),
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 4,
                                        name = "Acceso de por vida",
                                        iconUrl = "https://cdn.tuapp.com/icons/infinity.png",
                                    ),
                                description = "Acceso de por vida al contenido",
                            ),
                        ),
                ),
                CourseDto(
                    id = 7,
                    title = "Literatura clásica",
                    description =
                        "Una aventura por la historia de la literatura clásica y sus máximos exponentes",
                    thumbnailUrl = "https://img.freepik.com/vector-premium/libro-viejo-blanco_87946-1711.jpg?w=360",
                    rating = 4.2,
                    price = 500.0,
                    instructors = listOf(instructorsDto[2]),
                    categories = listOf(categoriesDto[4]),
                    schedule =
                        listOf(
                            ScheduleDto("Martes", "20:00", "22:00"),
                            ScheduleDto("Jueves", "20:00", "22:00"),
                        ),
                    totalStudents = 250,
                    level = levelsDto[1],
                    requirements = "No necesitas conocimientos previos",
                    items =
                        listOf(
                            VideoItemDto(
                                id = 45,
                                title = "Los comienzos de la escrituras",
                                description = "Primeros registros escritos.",
                                durationSeconds = 800,
                                videoUrl = "https://video1.mp4",
                                isPreview = true,
                                order = 0,
                            ),
                            VideoItemDto(
                                id = 46,
                                title = "Recorrido por grandes obras",
                                description = "",
                                durationSeconds = 1100,
                                videoUrl = "https://video1.mp4",
                                isPreview = false,
                                order = 1,
                            ),
                            VideoItemDto(
                                id = 47,
                                title = "Autores influyentes",
                                description = "",
                                durationSeconds = 1500,
                                videoUrl = "https://video2.mp4",
                                isPreview = false,
                                order = 2,
                            ),
                            VideoItemDto(
                                id = 48,
                                title = "Herramientas y tips para una buena redacción",
                                description = "",
                                durationSeconds = 500,
                                videoUrl = "https://video3.mp4",
                                isPreview = false,
                                order = 3,
                            ),
                            VideoItemDto(
                                id = 49,
                                title = "El Quijote",
                                description = "",
                                durationSeconds = 700,
                                videoUrl = "https://video4.mp4",
                                isPreview = false,
                                order = 4,
                            ),
                            VideoItemDto(
                                id = 50,
                                title = "Capítulos y prólogos.",
                                description = "",
                                durationSeconds = 500,
                                videoUrl = "https://video5.mp4",
                                isPreview = false,
                                order = 5,
                            ),
                        ),
                    includes =
                        listOf(
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 1,
                                        name = "Video",
                                        iconUrl = "https://cdn.tuapp.com/icons/video.png",
                                    ),
                                description = "10 horas de video bajo demanda",
                            ),
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 2,
                                        name = "Documento",
                                        iconUrl = "https://cdn.tuapp.com/icons/doc.png",
                                    ),
                                description = "Material descargable (PDFs, guías)",
                            ),
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 3,
                                        name = "Certificado",
                                        iconUrl = "https://cdn.tuapp.com/icons/certificate.png",
                                    ),
                                description = "Certificado de finalización",
                            ),
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 4,
                                        name = "Acceso de por vida",
                                        iconUrl = "https://cdn.tuapp.com/icons/infinity.png",
                                    ),
                                description = "Acceso de por vida al contenido",
                            ),
                        ),
                ),
                CourseDto(
                    id = 8,
                    title = "Diseño de Juegos",
                    description =
                        "En este curso aprenderás a crear personajes, escenarios e historias para tus juegos",
                    thumbnailUrl = "https://www.cokitos.com/wp-content/uploads/2022/12/pixel-art-pintar-ninos.jpg",
                    rating = 4.8,
                    price = 800.0,
                    instructors = listOf(instructorsDto[1]),
                    categories = listOf(categoriesDto[5]),
                    schedule =
                        listOf(
                            ScheduleDto("Lunes", "18:00", "22:00"),
                        ),
                    totalStudents = 250,
                    level = levelsDto[0],
                    requirements = "No necesitas conocimientos previos",
                    items =
                        listOf(
                            VideoItemDto(
                                id = 51,
                                title = "Juegos clásicos",
                                description = "Primeros registros escritos.",
                                durationSeconds = 700,
                                videoUrl = "https://video1.mp4",
                                isPreview = true,
                                order = 0,
                            ),
                            VideoItemDto(
                                id = 52,
                                title = "Cómo crear un personaje",
                                description = "",
                                durationSeconds = 500,
                                videoUrl = "https://video1.mp4",
                                isPreview = false,
                                order = 1,
                            ),
                            VideoItemDto(
                                id = 53,
                                title = "Pantallas y escenarios",
                                description = "",
                                durationSeconds = 1500,
                                videoUrl = "https://video2.mp4",
                                isPreview = false,
                                order = 2,
                            ),
                            VideoItemDto(
                                id = 54,
                                title = "Crea una historia con una trama",
                                description = "",
                                durationSeconds = 900,
                                videoUrl = "https://video3.mp4",
                                isPreview = false,
                                order = 3,
                            ),
                            VideoItemDto(
                                id = 55,
                                title = "Cómo subir tu juego",
                                description = "",
                                durationSeconds = 450,
                                videoUrl = "https://video4.mp4",
                                isPreview = false,
                                order = 4,
                            ),
                        ),
                    includes =
                        listOf(
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 1,
                                        name = "Video",
                                        iconUrl = "https://cdn.tuapp.com/icons/video.png",
                                    ),
                                description = "10 horas de video bajo demanda",
                            ),
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 2,
                                        name = "Documento",
                                        iconUrl = "https://cdn.tuapp.com/icons/doc.png",
                                    ),
                                description = "Material descargable (PDFs, guías)",
                            ),
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 3,
                                        name = "Certificado",
                                        iconUrl = "https://cdn.tuapp.com/icons/certificate.png",
                                    ),
                                description = "Certificado de finalización",
                            ),
                            CourseIncludeItemDto(
                                type =
                                    IncludeTypeDto(
                                        id = 4,
                                        name = "Acceso de por vida",
                                        iconUrl = "https://cdn.tuapp.com/icons/infinity.png",
                                    ),
                                description = "Acceso de por vida al contenido",
                            ),
                        ),
                ),
            )

    val medalsDto =
        listOf(
            RangeMedalDto(
                id = 1,
                name = "Nivel 1",
                description = "Completaste hasta 100 puntos",
                icon = "🏆",
                threshold = 0,
            ),
            RangeMedalDto(
                id = 2,
                name = "Nivel 2",
                description = "Completaste más de 500 puntos",
                icon = "🏆",
                threshold = 500,
            ),
            RangeMedalDto(
                id = 3,
                name = "Nivel 3",
                description = "Completaste más de 1000 puntos",
                icon = "🏆",
                threshold = 1000,
            ),
            RangeMedalDto(
                id = 4,
                name = "Nivel 4",
                description = "Completaste más de 1500 puntos",
                icon = "🏆",
                threshold = 1500,
            ),
            RangeMedalDto(
                id = 5,
                name = "Nivel 5",
                description = "Completaste más de 2000 puntos",
                icon = "🏆",
                threshold = 2000,
            ),
            RangeMedalDto(
                id = 6,
                name = "Nivel 6",
                description = "Completaste más de 2500 puntos",
                icon = "🏆",
                threshold = 2500,
            ),
            RangeMedalDto(
                id = 7,
                name = "Nivel 7",
                description = "Completaste más de 3000 puntos",
                icon = "🏆",
                threshold = 3000,
            ),
            RangeMedalDto(
                id = 8,
                name = "Nivel 8",
                description = "Completaste más de 3500 puntos",
                icon = "🏆",
                threshold = 3500,
            ),
            RangeMedalDto(
                id = 9,
                name = "Nivel 9",
                description = "Completaste más de 4000 puntos",
                icon = "🏆",
                threshold = 4000,
            ),
            RangeMedalDto(
                id = 10,
                name = "Nivel 10",
                description = "Completaste más de 4500 puntos",
                icon = "🏆",
                threshold = 4500,
            ),
            RangeMedalDto(
                id = 11,
                name = "Nivel 11",
                description = "Completaste más de 5000 puntos",
                icon = "🏆",
                threshold = 5000,
            ),
            RangeMedalDto(
                id = 121,
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
                id = 14,
                name = "Nivel 14",
                description = "Completaste más de 6500 puntos",
                icon = "🏆",
                threshold = 6500,
            ),
            RangeMedalDto(
                id = 15,
                name = "Nivel 15",
                description = "Completaste más de 7000 puntos",
                icon = "🏆",
                threshold = 7000,
            ),
            RangeMedalDto(
                id = 16,
                name = "Nivel 16",
                description = "Completaste más de 7500 puntos",
                icon = "🏆",
                threshold = 7500,
            ),
            RangeMedalDto(
                id = 17,
                name = "Nivel 17",
                description = "Completaste más de 8000 puntos",
                icon = "🏆",
                threshold = 8000,
            ),
            RangeMedalDto(
                id = 18,
                name = "Nivel 18",
                description = "Completaste más de 8500 puntos",
                icon = "🏆",
                threshold = 8500,
            ),
            RangeMedalDto(
                id = 19,
                name = "Nivel 19",
                description = "Completaste más de 9000 puntos",
                icon = "🏆",
                threshold = 9000,
            ),
            RangeMedalDto(
                id = 20,
                name = "Nivel 20",
                description = "Completaste más de 9500 puntos",
                icon = "🏆",
                threshold = 9500,
            ),
            RangeMedalDto(
                id = 21,
                name = "Nivel 21",
                description = "Completaste más de 10000 puntos",
                icon = "🏆",
                threshold = 10000,
            ),
            RangeMedalDto(
                id = 22,
                name = "Nivel 22",
                description = "Completaste más de 10500 puntos",
                icon = "🏆",
                threshold = 10500,
            ),
            RangeMedalDto(
                id = 23,
                name = "Nivel 23",
                description = "Completaste más de 11000 puntos",
                icon = "🏆",
                threshold = 11000,
            ),
            RangeMedalDto(
                id = 24,
                name = "Nivel 24",
                description = "Completaste más de 11500 puntos",
                icon = "🏆",
                threshold = 11500,
            ),
            RangeMedalDto(
                id = 25,
                name = "Nivel 25",
                description = "Completaste más de 12000 puntos",
                icon = "🏆",
                threshold = 12000,
            ),
            RangeMedalDto(
                id = 26,
                name = "Nivel 26",
                description = "Completaste más de 12500 puntos",
                icon = "🏆",
                threshold = 12500,
            ),
            RangeMedalDto(
                id = 27,
                name = "Nivel 27",
                description = "Completaste más de 13000 puntos",
                icon = "🏆",
                threshold = 13000,
            ),
            RangeMedalDto(
                id = 28,
                name = "Nivel 28",
                description = "Completaste más de 13500 puntos",
                icon = "🏆",
                threshold = 13500,
            ),
            RangeMedalDto(
                id = 29,
                name = "Nivel 29",
                description = "Completaste más de 14000 puntos",
                icon = "🏆",
                threshold = 14000,
            ),
            RangeMedalDto(
                id = 30,
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
//            progressByCourse =
//                listOf(
//                    UserCourseProgressDto(
//                        courseId = 1,
//                        videoProgress =
//                            listOf(
//                                UserProgressDto(1, 300), // completo video 1
//                                UserProgressDto(2, 600), // mitad video 2
//                            ),
//                    ),
//                    UserCourseProgressDto(
//                        courseId = 2,
//                        videoProgress =
//                            listOf(
//                                UserProgressDto(1, 300),
//                                UserProgressDto(2, 1200),
//                                UserProgressDto(3, 1500),
//                                UserProgressDto(4, 1500),
//                            ),
//                    ),
//                ),
//            score = 5400,
            progressByCourse = emptyList(),
            score = 0,
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

//    fun toggleVideoWatched(
//        courseId: Int,
//        videoId: Int,
//    ) {
//        val videoList = coursesDto.find { it.id == courseId }?.items ?: return
//        val videoDuration = videoList.find { it.id == videoId }?.durationSeconds ?: return
//
//        val progressList = pprogressByCourse.getOrPut(courseId) { mutableListOf() }
//        val existingIndex = progressList.indexOfFirst { it.videoId == videoId }
//
//        if (existingIndex >= 0) {
//            progressList.removeAt(existingIndex)
//        } else {
//            progressList.add(UserProgressDto(videoId, videoDuration))
//        }
//        syncUserProgress()
//    }

    fun toggleVideoWatched(
        courseId: Int,
        videoId: Int,
    ) {
        val videoList = coursesDto.find { it.id == courseId }?.items ?: return
        val videoDuration = videoList.find { it.id == videoId }?.durationSeconds ?: return

        val progressList = pprogressByCourse.getOrPut(courseId) { mutableListOf() }
        val existingIndex = progressList.indexOfFirst { it.videoId == videoId }
        val puntosPorSegundo = 1 // ejemplo: 1 punto por segundo

        if (existingIndex >= 0) {
            // Si el video ya estaba marcado como visto, se desmarca
            progressList.removeAt(existingIndex)
            // Opcional: restar puntos al desmarcar el video
            val puntosRestados = videoDuration * puntosPorSegundo
            userDto = userDto.copy(score = maxOf(0, userDto.score - puntosRestados))
        } else {
            // Marcar el video como visto
            progressList.add(UserProgressDto(videoId, videoDuration))

            // Sumar puntos
            val puntosGanados = videoDuration * puntosPorSegundo

            // Actualizar score del usuario
            userDto = userDto.copy(score = userDto.score + puntosGanados)
        }

        syncUserProgress()
    }
}
