package com.rockandcode.cursos.data.datasources.local

import com.rockandcode.cursos.data.models.BenefitDto
import com.rockandcode.cursos.data.models.CategoryDto
import com.rockandcode.cursos.data.models.CertificateDto
import com.rockandcode.cursos.data.models.CommentDto
import com.rockandcode.cursos.data.models.CourseDocumentDto
import com.rockandcode.cursos.data.models.CourseDto
import com.rockandcode.cursos.data.models.CourseFeatureItemDto
import com.rockandcode.cursos.data.models.CourseLevelDto
import com.rockandcode.cursos.data.models.CourseSectionDto
import com.rockandcode.cursos.data.models.DocumentTypeDto
import com.rockandcode.cursos.data.models.FeatureTypeDto
import com.rockandcode.cursos.data.models.InstructorDto
import com.rockandcode.cursos.data.models.RangeMedalDto
import com.rockandcode.cursos.data.models.ScheduleDto
import com.rockandcode.cursos.data.models.UserCourseProgressDto
import com.rockandcode.cursos.data.models.UserDto
import com.rockandcode.cursos.data.models.UserProgressDto
import com.rockandcode.cursos.data.models.VideoItemDto

object MockDataSource {
    private val instructorsDto =
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
                    "https://media.licdn.com/dms/image/v2/D4D03AQFlCSHGer5Mng/profile-displayphoto-" +
                        "shrink_200_200/profile-displayphoto-shrink_200_200/0/1694610604805?e=" +
                        "2147483647&v=beta&t=8Qv3Gizu2LXy5WFiTvpPIuijsusjo7jRGe-FF4U1xfY",
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
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751808922/" +
                        "android_pa1cck.png",
            ),
            CategoryDto(
                id = 2,
                name = "C#",
                imageUrl =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751808922/c_qcayux.png",
            ),
            CategoryDto(
                id = 3,
                name = "Matemática",
                imageUrl =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751808922/" +
                        "matematica_udwuvs.png",
            ),
            CategoryDto(
                id = 4,
                name = "Lengua",
                imageUrl =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751808922/" +
                        "lengua_kyqczi.png",
            ),
            CategoryDto(
                id = 5,
                name = "Desarrollo",
                imageUrl =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751808922/" +
                        "desarrollo_g0wpec.png",
            ),
            CategoryDto(
                id = 6,
                name = "Base de datos",
                imageUrl =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751808922/" +
                        "base_de_datos_fh2mgt.png",
            ),
            CategoryDto(
                id = 7,
                name = "Música",
                imageUrl =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751808922/" +
                        "musica_bmadxr.png",
            ),
            CategoryDto(
                id = 8,
                name = "Diseño",
                imageUrl =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751808922/" +
                        "diseno_awjmun.png",
            ),
            CategoryDto(
                id = 9,
                name = "Java",
                imageUrl =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751808922/" +
                        "java_kg9rcu.png",
            ),
        )

    private val documentTypesDto =
        listOf(
            DocumentTypeDto(id = 1, name = "Clase", fileExtension = null),
            DocumentTypeDto(id = 2, name = "Ejercicio", fileExtension = null),
            DocumentTypeDto(id = 3, name = "PDF", fileExtension = "pdf"),
            DocumentTypeDto(id = 4, name = "Word", fileExtension = "docx"),
        )

    private val documentsDto =
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
                title = "Clase 2 - Introducción\"",
                description = "",
                url = "https://.../ejercicio1.docx",
                documentType = documentTypesDto[0],
            ),
            CourseDocumentDto(
                id = 3,
                title = "Ejercicios",
                description = "",
                url = "https://.../manual.pdf",
                documentType = documentTypesDto[1],
            ),
        )

    private val levelsDto =
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
                    subTitle = "Simplifica y acelera el desarrollo de la interfaz de usuario en Android",
                    description =
                        "Jetpack Compose es el kit de herramientas moderno recomendado " +
                            "por Android para compilar IU nativa. Simplifica y acelera el desarrollo " +
                            "de la interfaz de usuario en Android. Dale vida rápidamente a tu app con " +
                            "menos código, herramientas poderosas y API de Kotlin intuitivas.",
                    thumbnailUrl =
                        "https://res.cloudinary.com/dznr3eupq/image/upload/v1751761012/jetpack_xvjj0w.jpg",
                    rating = 4.0,
                    ratingCount = 4,
                    price = 68750.00,
                    isFree = false,
                    instructors = listOf(instructorsDto[1]),
                    categories = listOf(categoriesDto[0], categoriesDto[4]),
                    schedule =
                        listOf(
                            ScheduleDto("Lunes", "18:00", "20:00"),
                            ScheduleDto("Miércoles", "18:00", "20:00"),
                        ),
                    totalStudents = 1000,
                    documents = documentsDto,
                    level = levelsDto[0],
                    features =
                        listOf(
                            CourseFeatureItemDto(
                                featureType =
                                    FeatureTypeDto(
                                        id = 1,
                                        name = "Certificado de finalización",
                                        iconKey = "certificate",
                                        showValue = false,
                                        unitLabel = null,
                                        displayOrder = 4,
                                    ),
                                value = null,
                            ),
                            CourseFeatureItemDto(
                                featureType =
                                    FeatureTypeDto(
                                        id = 2,
                                        name = "Acceso de por vida al contenido",
                                        iconKey = "access",
                                        showValue = false,
                                        unitLabel = null,
                                        displayOrder = 5,
                                    ),
                                value = null,
                            ),
                        ),
                    requirements = listOf("Conocimientos básicos de programación en Kotlin"),
                    author = instructorsDto[1],
                    createdAt = "30/06/2025",
                    updatedAt = "30/06/2025",
                    topics =
                        listOf(
                            "Fundamentos de Kotlin",
                            "Composables, Estados, Layouts, Componentes, Listas y Cuadrículas, Navegación",
                            "Arquitectura de Compose",
                            "Animaciones",
                            "Tematización (Theming)",
                            "Accesibilidad",
                            "Pruebas",
                            "Gráficos",
                        ),
                    tags = listOf("Android", "Kotlin"),
                    comments =
                        listOf(
                            CommentDto(
                                id = 1,
                                userName = "Andrea Lopez",
                                text = "Muy buen curso de Android. Quizas podrían agregar mas contenidos",
                                avatarUrl =
                                    "https://i.pinimg.com/736x/ca/ee/2a/caee2a0f06b406ebb920e4bf25965e18.jpg",
                                date = "05/07/2025",
                                rating = 3,
                            ),
                            CommentDto(
                                id = 2,
                                userName = "Mario Perez",
                                text = "Hice todos los ejercicios del curso y termine creando una App!. Lo recomiendo",
                                avatarUrl =
                                    "https://images.unsplash.com/photo-1633332755192-727a05c4013d?w=" +
                                        "800&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxz" +
                                        "ZWFyY2h8Mnx8YXZhdGFyJTIwZGUlMjBob21icmV8ZW58MHx8MHx8fDA%3D",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                            CommentDto(
                                id = 3,
                                userName = "Franco Lupo",
                                text = "Muy buen curso!. Recomendado a los amantes de Android",
                                avatarUrl =
                                    "https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?w=" +
                                        "800&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3" +
                                        "fDB8MHxzZWFyY2h8M3x8YXZhdGFyJTIwZGUlMjBob21icmV8ZW58MHx8MHx8fDA%3D",
                                date = "05/07/2025",
                                rating = 4,
                            ),
                        ),
                    sections =
                        listOf(
                            CourseSectionDto(
                                id = 1,
                                title = "Introducción",
                                description = "",
                                videos =
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
                                    ),
                            ),
                            CourseSectionDto(
                                id = 2,
                                title = "Parte 1",
                                description = "",
                                videos =
                                    listOf(
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
                                    ),
                            ),
                            CourseSectionDto(
                                id = 3,
                                title = "Parte 2",
                                description = "",
                                videos =
                                    listOf(
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
                                    ),
                            ),
                            CourseSectionDto(
                                id = 4,
                                title = "Parte 3",
                                description = "",
                                videos =
                                    listOf(
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
                            ),
                        ),
                    hasCertificate = true,
                    hasLifetimeAccess = true,
                ),
                CourseDto(
                    id = 2,
                    title = "SQL Avanzado",
                    subTitle = "Todo sobre la base de datos relacional SQL",
                    description = "Aprende base de datos relacional...",
                    thumbnailUrl =
                        "https://res.cloudinary.com/dznr3eupq/image/upload/v1751761010/sql_femqyo.jpg",
                    rating = 4.1,
                    ratingCount = 24,
                    price = 81250.00,
                    isFree = false,
                    instructors = listOf(instructorsDto[1]),
                    categories = listOf(categoriesDto[5]),
                    schedule =
                        listOf(
                            ScheduleDto("Martes", "12:00", "16:00"),
                            ScheduleDto("Miércoles", "18:00", "20:00"),
                        ),
                    totalStudents = 500,
                    sections =
                        listOf(
                            CourseSectionDto(
                                id = 5,
                                title = "Introducción",
                                description = "",
                                videos =
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
                                    ),
                            ),
                            CourseSectionDto(
                                id = 6,
                                title = "Instalación y configuración",
                                description = "",
                                videos =
                                    listOf(
                                        VideoItemDto(
                                            id = 14,
                                            title = "Instalación y configuración",
                                            description = "Se guía sobre cómo instalar...",
                                            durationSeconds = 1200,
                                            videoUrl = "https://video2.mp4",
                                            isPreview = false,
                                            order = 2,
                                        ),
                                    ),
                            ),
                            CourseSectionDto(
                                id = 7,
                                title = "Lenguaje SQL",
                                description = "",
                                videos =
                                    listOf(
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
                                    ),
                            ),
                            CourseSectionDto(
                                id = 8,
                                title = "Consultas",
                                description = "",
                                videos =
                                    listOf(
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
                            ),
                        ),
                    documents = emptyList(),
                    level = levelsDto[2],
                    features =
                        listOf(
                            CourseFeatureItemDto(
                                featureType =
                                    FeatureTypeDto(
                                        id = 1,
                                        name = "Certificado de finalización",
                                        iconKey = "certificate",
                                        showValue = false,
                                        unitLabel = null,
                                        displayOrder = 4,
                                    ),
                                value = null,
                            ),
                            CourseFeatureItemDto(
                                featureType =
                                    FeatureTypeDto(
                                        id = 2,
                                        name = "Acceso de por vida al contenido",
                                        iconKey = "access",
                                        showValue = false,
                                        unitLabel = null,
                                        displayOrder = 5,
                                    ),
                                value = null,
                            ),
                        ),
                    requirements = listOf("Conocimientos básicos de programación"),
                    createdAt = "30/06/2025",
                    updatedAt = "30/06/2025",
                    author = instructorsDto[1],
                    topics =
                        listOf(
                            "Pivoteo y Despivotado",
                            "Consultas Anidadas (Subqueries)",
                            "Consultas Recursivas",
                            "Autouniones",
                            "Procedimientos Almacenados: Creación y ejecución, Parámetros, Manejo de Errores",
                            "Triggers: Tipos. Creación y Activación",
                            "PARTITION BY, ORDER BY, FRAME",
                            "Extensiones de GROUP BY: ROLLUP, CUBE, GROUPING SETS",
                        ),
                    tags = listOf("SQL", "Bases de datos", "MySQL"),
                    comments =
                        listOf(
                            CommentDto(
                                id = 1,
                                userName = "Francisco Costa",
                                text = "El curso esta muy bien, lo recomiendo.",
                                avatarUrl =
                                    "https://images.unsplash.com/photo-1628157588553-5eeea00af15c?w=" +
                                        "800&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3" +
                                        "fDB8MHxzZWFyY2h8N3x8YXZhdGFyJTIwZGUlMjBob21icmV8ZW58MHx8MHx8fDA%3D",
                                date = "05/07/2025",
                                rating = 4,
                            ),
                            CommentDto(
                                id = 2,
                                userName = "Maria Lula",
                                text = "Me sirvio para enteder todo lo relacionado a consultas SQL.",
                                avatarUrl =
                                    "https://images.unsplash.com/photo-1688395195964-305f43f" +
                                        "9e0dc?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8M" +
                                        "HxwaG90by1yZWxhdGVkfDM1fHx8ZW58MHx8fHx8",
                                date = "05/07/2025",
                                rating = 3,
                            ),
                            CommentDto(
                                id = 3,
                                userName = "Amanda Sulky",
                                text = "Muy buen curso!.",
                                avatarUrl =
                                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQBeb5dnyo" +
                                        "git5AhfBZ85UUdTjDfvQCswMucQ&s",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                        ),
                    hasCertificate = true,
                    hasLifetimeAccess = true,
                ),
                CourseDto(
                    id = 3,
                    title = "Desarrollo de interfaces",
                    subTitle = "Aprender a crear interfaces digitales atractivas funcionales y fáciles de usar",
                    description =
                        "Este curso de desarrollo de interfaces es una excelente opción " +
                            "para quienes desean aprender a crear interfaces digitales atractivas, " +
                            "funcionales y fáciles de usar, ya sea para aplicaciones web, móviles o de escritorio. ",
                    thumbnailUrl =
                        "https://res.cloudinary.com/dznr3eupq/image/upload/v1751761011/disenio-interfaces_shtddk.jpg",
                    rating = 5.0,
                    ratingCount = 130,
                    price = 74999.00,
                    isFree = false,
                    instructors = listOf(instructorsDto[2]),
                    categories = listOf(categoriesDto[7]),
                    author = instructorsDto[2],
                    schedule =
                        listOf(
                            ScheduleDto("Miercoles", "19:00", "23:00"),
                        ),
                    totalStudents = 250,
                    comments =
                        listOf(
                            CommentDto(
                                id = 1,
                                userName = "Luis Enrique Montero",
                                text = "Muchas gracias!, estoy aprendiendo mucho. Un saludo enorme.",
                                avatarUrl =
                                    "https://media.licdn.com/dms/image/v2/D4D03AQFlCSHGer5Mng/profile-displayphoto-" +
                                        "shrink_200_200/profile-displayphoto-shrink_200_200/0/1694610604805?e=" +
                                        "2147483647&v=beta&t=8Qv3Gizu2LXy5WFiTvpPIuijsusjo7jRGe-FF4U1xfY",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                            CommentDto(
                                id = 2,
                                userName = "Santiago Sanchez",
                                text = "El mejor curso de desarrollo de interfaces!.",
                                avatarUrl = "https://miel.unlam.edu.ar/data2/avatares/34870524.jpg?1586394949",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                            CommentDto(
                                id = 3,
                                userName = "Carlos Gimemez",
                                text = "Muy buen curso!.",
                                avatarUrl = "https://media.gq.com.mx/photos/5c6c494700f5a75446d1db89/master/w_1600%2Cc_limit/corbata.jpg",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                        ),
                    sections =
                        listOf(
                            CourseSectionDto(
                                id = 9,
                                title = "Introducción",
                                description = "",
                                videos =
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
                                    ),
                            ),
                            CourseSectionDto(
                                id = 10,
                                title = "Parte 1",
                                description = "",
                                videos =
                                    listOf(
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
                                    ),
                            ),
                            CourseSectionDto(
                                id = 11,
                                title = "Parte 2",
                                description = "",
                                videos =
                                    listOf(
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
                                    ),
                            ),
                            CourseSectionDto(
                                id = 12,
                                title = "Parte 3",
                                description = "",
                                videos =
                                    listOf(
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
                            ),
                        ),
                    documents = emptyList(),
                    level = levelsDto[0],
                    features =
                        listOf(
                            CourseFeatureItemDto(
                                featureType =
                                    FeatureTypeDto(
                                        id = 1,
                                        name = "Certificado de finalización",
                                        iconKey = "certificate",
                                        showValue = false,
                                        unitLabel = null,
                                        displayOrder = 4,
                                    ),
                                value = null,
                            ),
                            CourseFeatureItemDto(
                                featureType =
                                    FeatureTypeDto(
                                        id = 2,
                                        name = "Acceso de por vida al contenido",
                                        iconKey = "access",
                                        showValue = false,
                                        unitLabel = null,
                                        displayOrder = 5,
                                    ),
                                value = null,
                            ),
                        ),
                    requirements = listOf("No requiere conocimientos previos"),
                    createdAt = "30/06/2025",
                    updatedAt = "30/06/2025",
                    topics =
                        listOf(
                            "Introducción a la Comunicación Visual",
                            "Sistemas de Diseño",
                            "Color",
                            "Introducción a las Interfaces",
                            "Interacción Humano Dispositivo",
                            "Usabilidad y Experiencia de Usuario",
                            "Evaluación Heurística",
                            "Prototipado",
                        ),
                    tags = listOf("UI", "UX", "Material Design"),
                    hasCertificate = true,
                    hasLifetimeAccess = true,
                ),
                CourseDto(
                    id = 4,
                    title = "Teoría musical",
                    subTitle = "Lenguaje musical y fundamentos de la música",
                    description =
                        "Fundamentos de la música, teoría musical " +
                            "(notas, acordes, escalas, ritmo), historia de la música, " +
                            "entrenamiento vocal, producción musical, y/o aprendizaje de un instrumento",
                    thumbnailUrl =
                        "https://res.cloudinary.com/dznr3eupq/image/upload/v1751753235/musica_olnk0y.jpg",
                    rating = 4.8,
                    ratingCount = 8,
                    price = 62499.00,
                    isFree = false,
                    instructors = listOf(instructorsDto[3]),
                    categories = listOf(categoriesDto[6]),
                    author = instructorsDto[3],
                    schedule =
                        listOf(
                            ScheduleDto("Miercoles", "19:00", "23:00"),
                        ),
                    totalStudents = 250,
                    sections =
                        listOf(
                            CourseSectionDto(
                                id = 13,
                                title = "Introducción",
                                description = "",
                                videos =
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
                                    ),
                            ),
                            CourseSectionDto(
                                id = 14,
                                title = "Parte 1",
                                description = "",
                                videos =
                                    listOf(
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
                            ),
                        ),
                    documents = emptyList(),
                    level = levelsDto[0],
                    features =
                        listOf(
                            CourseFeatureItemDto(
                                featureType =
                                    FeatureTypeDto(
                                        id = 1,
                                        name = "Certificado de finalización",
                                        iconKey = "certificate",
                                        showValue = false,
                                        unitLabel = null,
                                        displayOrder = 4,
                                    ),
                                value = null,
                            ),
                            CourseFeatureItemDto(
                                featureType =
                                    FeatureTypeDto(
                                        id = 2,
                                        name = "Acceso de por vida al contenido",
                                        iconKey = "access",
                                        showValue = false,
                                        unitLabel = null,
                                        displayOrder = 5,
                                    ),
                                value = null,
                            ),
                        ),
                    requirements = listOf("No requiere conocimientos previos"),
                    createdAt = "30/06/2025",
                    updatedAt = "30/06/2025",
                    topics =
                        listOf(
                            "Sonido y sus propiedades",
                            "Ritmo",
                            "Melodía",
                            "Armonía",
                            "Forma musical",
                            "Notación musical",
                            "Escalas y modos",
                            "Intervalos",
                            "Composición",
                            "Acústica musical",
                            "Función tonal",
                            "Tonalidad y atonalidad",
                        ),
                    tags = listOf("Música", "Armonía", "Escalas"),
                    comments =
                        listOf(
                            CommentDto(
                                id = 1,
                                userName = "Luis Enrique Montero",
                                text = "Muchas gracias!, estoy aprendiendo mucho. Un saludo enorme.",
                                avatarUrl =
                                    "https://media.licdn.com/dms/image/v2/D4D03AQFlCSHGer5Mng/profile-displayphoto-" +
                                        "shrink_200_200/profile-displayphoto-shrink_200_200/0/1694610604805?e=" +
                                        "2147483647&v=beta&t=8Qv3Gizu2LXy5WFiTvpPIuijsusjo7jRGe-FF4U1xfY",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                            CommentDto(
                                id = 2,
                                userName = "Santiago Sanchez",
                                text = "El mejor curso de desarrollo de interfaces!.",
                                avatarUrl = "https://miel.unlam.edu.ar/data2/avatares/34870524.jpg?1586394949",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                            CommentDto(
                                id = 3,
                                userName = "Carlos Gimemez",
                                text = "Muy buen curso!.",
                                avatarUrl = "https://media.gq.com.mx/photos/5c6c494700f5a75446d1db89/master/w_1600%2Cc_limit/corbata.jpg",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                        ),
                    hasCertificate = true,
                    hasLifetimeAccess = true,
                ),
                CourseDto(
                    id = 5,
                    title = "Numeración",
                    subTitle = "Sistema de numeración decimal - Valor posicional - Ubicación en la recta numérica",
                    description =
                        "Sistema de numeración decimal - Valor posicional - Ubicación en la recta numérica",
                    thumbnailUrl =
                        "https://firebasestorage.googleapis.com/v0/b/treiio-213b3.appspot.com" +
                            "/o/uploads%2Fmatematicas.jpg?alt=media&token=d18e6a41-262a-4501-924a-5a668be3f5fc",
                    rating = 4.7,
                    ratingCount = 5,
                    price = 49999.00,
                    isFree = false,
                    instructors = listOf(instructorsDto[4]),
                    categories = listOf(categoriesDto[2]),
                    author = instructorsDto[4],
                    schedule =
                        listOf(
                            ScheduleDto("Jueves", "17:00", "19:00"),
                        ),
                    totalStudents = 250,
                    level = levelsDto[1],
                    requirements = listOf("No requiere conocimientos previos"),
                    comments =
                        listOf(
                            CommentDto(
                                id = 1,
                                userName = "Luis Enrique Montero",
                                text = "Muchas gracias!, estoy aprendiendo mucho. Un saludo enorme.",
                                avatarUrl =
                                    "https://media.licdn.com/dms/image/v2/D4D03AQFlCSHGer5Mng/profile-displayphoto-" +
                                        "shrink_200_200/profile-displayphoto-shrink_200_200/0/1694610604805?e=" +
                                        "2147483647&v=beta&t=8Qv3Gizu2LXy5WFiTvpPIuijsusjo7jRGe-FF4U1xfY",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                            CommentDto(
                                id = 2,
                                userName = "Santiago Sanchez",
                                text = "El mejor curso de desarrollo de interfaces!.",
                                avatarUrl = "https://miel.unlam.edu.ar/data2/avatares/34870524.jpg?1586394949",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                            CommentDto(
                                id = 3,
                                userName = "Carlos Gimemez",
                                text = "Muy buen curso!.",
                                avatarUrl = "https://media.gq.com.mx/photos/5c6c494700f5a75446d1db89/master/w_1600%2Cc_limit/corbata.jpg",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                        ),
                    sections =
                        listOf(
                            CourseSectionDto(
                                id = 15,
                                title = "Introducción",
                                description = "",
                                videos =
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
                                    ),
                            ),
                            CourseSectionDto(
                                id = 16,
                                title = "Videos",
                                description = "",
                                videos =
                                    listOf(
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
                            ),
                        ),
                    features =
                        listOf(
                            CourseFeatureItemDto(
                                featureType =
                                    FeatureTypeDto(
                                        id = 1,
                                        name = "Certificado de finalización",
                                        iconKey = "certificate",
                                        showValue = false,
                                        unitLabel = null,
                                        displayOrder = 4,
                                    ),
                                value = null,
                            ),
                            CourseFeatureItemDto(
                                featureType =
                                    FeatureTypeDto(
                                        id = 2,
                                        name = "Acceso de por vida al contenido",
                                        iconKey = "access",
                                        showValue = false,
                                        unitLabel = null,
                                        displayOrder = 5,
                                    ),
                                value = null,
                            ),
                        ),
                    createdAt = "30/06/2025",
                    updatedAt = "30/06/2025",
                    topics =
                        listOf(
                            "Conceptos y propiedades básicas de los números reales",
                            "Los intervalos como conjuntos de números y segmentos de rectas",
                            "Valor absoluto y su interpretación geométrica",
                            "Nociones de funciones: Dominio, imagen",
                            "Funciones de números reales y sus gráficas",
                            "Álgebra de funciones de números reales",
                            "Nociones básicas de trigonometría",
                            "Propiedad trigonométrica y demostraciones",
                        ),
                    tags = listOf("Matemática", "Funciones", "Álgebra"),
                    hasCertificate = true,
                    hasLifetimeAccess = true,
                ),
                CourseDto(
                    id = 6,
                    title = "Base de Datos",
                    subTitle = "Curso inicial de bases de datos",
                    description =
                        "Curso donde aprenderás cómo armar tablas, insertar datos y hacer consultas",
                    thumbnailUrl =
                        "https://res.cloudinary.com/dznr3eupq/image/upload/v1751761013/" +
                            "base_de_datos_lg3vi0.jpg",
                    rating = 4.9,
                    ratingCount = 4,
                    price = 24999.00,
                    isFree = false,
                    instructors = listOf(instructorsDto[1]),
                    categories = listOf(categoriesDto[5]),
                    author = instructorsDto[1],
                    schedule =
                        listOf(
                            ScheduleDto("Lunes", "20:00", "22:00"),
                            ScheduleDto("Viernes", "20:00", "22:00"),
                        ),
                    totalStudents = 250,
                    level = levelsDto[0],
                    requirements = listOf("No requiere conocimientos previos"),
                    comments =
                        listOf(
                            CommentDto(
                                id = 1,
                                userName = "Luis Enrique Montero",
                                text = "Muchas gracias!, estoy aprendiendo mucho. Un saludo enorme.",
                                avatarUrl =
                                    "https://media.licdn.com/dms/image/v2/D4D03AQFlCSHGer5Mng/profile-displayphoto-" +
                                        "shrink_200_200/profile-displayphoto-shrink_200_200/0/1694610604805?e=" +
                                        "2147483647&v=beta&t=8Qv3Gizu2LXy5WFiTvpPIuijsusjo7jRGe-FF4U1xfY",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                            CommentDto(
                                id = 2,
                                userName = "Santiago Sanchez",
                                text = "El mejor curso de desarrollo de interfaces!.",
                                avatarUrl = "https://miel.unlam.edu.ar/data2/avatares/34870524.jpg?1586394949",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                            CommentDto(
                                id = 3,
                                userName = "Carlos Gimemez",
                                text = "Muy buen curso!.",
                                avatarUrl = "https://media.gq.com.mx/photos/5c6c494700f5a75446d1db89/master/w_1600%2Cc_limit/corbata.jpg",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                        ),
                    sections =
                        listOf(
                            CourseSectionDto(
                                id = 17,
                                title = "Introducción",
                                description = "",
                                videos =
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
                                    ),
                            ),
                            CourseSectionDto(
                                id = 18,
                                title = "Base de datos",
                                description = "",
                                videos =
                                    listOf(
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
                            ),
                        ),
                    features =
                        listOf(
                            CourseFeatureItemDto(
                                featureType =
                                    FeatureTypeDto(
                                        id = 1,
                                        name = "Certificado de finalización",
                                        iconKey = "certificate",
                                        showValue = false,
                                        unitLabel = null,
                                        displayOrder = 4,
                                    ),
                                value = null,
                            ),
                            CourseFeatureItemDto(
                                featureType =
                                    FeatureTypeDto(
                                        id = 2,
                                        name = "Acceso de por vida al contenido",
                                        iconKey = "access",
                                        showValue = false,
                                        unitLabel = null,
                                        displayOrder = 5,
                                    ),
                                value = null,
                            ),
                        ),
                    createdAt = "30/06/2025",
                    updatedAt = "30/06/2025",
                    topics =
                        listOf(
                            "Tipos de bases de datos",
                            "Ejemplos de bases de datos",
                            "Tablas",
                            "Registros",
                            "Campos",
                            "Claves primarias",
                            "Relaciones",
                        ),
                    tags = listOf("SQL", "Bases de datos", "MySQL"),
                    hasCertificate = true,
                    hasLifetimeAccess = true,
                ),
                CourseDto(
                    id = 7,
                    title = "Literatura clásica",
                    subTitle = "Una aventura por la historia de la literatura clásica y sus máximos exponentes",
                    description =
                        "Una aventura por la historia de la literatura clásica y sus máximos exponentes",
                    thumbnailUrl =
                        "https://res.cloudinary.com/dznr3eupq/image/upload/v1751753234/literatura_fzmgqi.jpg",
                    rating = 4.2,
                    ratingCount = 48,
                    price = 0.00,
                    isFree = true,
                    instructors = listOf(instructorsDto[2]),
                    categories = listOf(categoriesDto[3]),
                    author = instructorsDto[2],
                    schedule =
                        listOf(
                            ScheduleDto("Martes", "20:00", "22:00"),
                            ScheduleDto("Jueves", "20:00", "22:00"),
                        ),
                    totalStudents = 250,
                    level = levelsDto[1],
                    requirements = listOf("No requiere conocimientos previos"),
                    comments =
                        listOf(
                            CommentDto(
                                id = 1,
                                userName = "Luis Enrique Montero",
                                text = "Muchas gracias!, estoy aprendiendo mucho. Un saludo enorme.",
                                avatarUrl =
                                    "https://media.licdn.com/dms/image/v2/D4D03AQFlCSHGer5Mng/profile-displayphoto-" +
                                        "shrink_200_200/profile-displayphoto-shrink_200_200/0/1694610604805?e=" +
                                        "2147483647&v=beta&t=8Qv3Gizu2LXy5WFiTvpPIuijsusjo7jRGe-FF4U1xfY",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                            CommentDto(
                                id = 2,
                                userName = "Santiago Sanchez",
                                text = "El mejor curso de desarrollo de interfaces!.",
                                avatarUrl = "https://miel.unlam.edu.ar/data2/avatares/34870524.jpg?1586394949",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                            CommentDto(
                                id = 3,
                                userName = "Carlos Gimemez",
                                text = "Muy buen curso!.",
                                avatarUrl = "https://media.gq.com.mx/photos/5c6c494700f5a75446d1db89/master/w_1600%2Cc_limit/corbata.jpg",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                        ),
                    sections =
                        listOf(
                            CourseSectionDto(
                                id = 19,
                                title = "Introducción",
                                description = "",
                                videos =
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
                                    ),
                            ),
                            CourseSectionDto(
                                id = 20,
                                title = "Clase 1",
                                description = "",
                                videos =
                                    listOf(
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
                                    ),
                            ),
                            CourseSectionDto(
                                id = 21,
                                title = "Clase 2",
                                description = "",
                                videos =
                                    listOf(
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
                            ),
                        ),
                    features = emptyList(),
                    createdAt = "30/06/2025",
                    updatedAt = "30/06/2025",
                    topics =
                        listOf(
                            "El amor",
                            "La muerte",
                            "La moralidad y la ética",
                            "El destino y el libre albedrío",
                            "El heroísmo",
                            "La condición humana",
                            "La relación entre el individuo y la sociedad",
                            "La justicia y la injusticia",
                            "La búsqueda de la identidad",
                            "La guerra y sus consecuencias",
                        ),
                    tags = listOf("Lengua", "Literatura", "Arte"),
                    hasCertificate = true,
                    hasLifetimeAccess = true,
                ),
                CourseDto(
                    id = 8,
                    title = "Diseño de Juegos",
                    subTitle = "En este curso aprenderás a crear personajes, escenarios e historias para tus juegos",
                    description =
                        "En este curso aprenderás a crear personajes, escenarios e historias para tus juegos",
                    thumbnailUrl =
                        "https://res.cloudinary.com/dznr3eupq/image/upload/v1751761010/disenio-videojuegos_gjorio.jpg",
                    rating = 4.1,
                    ratingCount = 12,
                    price = 56250.00,
                    isFree = false,
                    instructors = listOf(instructorsDto[1]),
                    categories = listOf(categoriesDto[4]),
                    author = instructorsDto[1],
                    schedule =
                        listOf(
                            ScheduleDto("Lunes", "18:00", "22:00"),
                        ),
                    totalStudents = 250,
                    level = levelsDto[0],
                    requirements = listOf("No requiere conocimientos previos"),
                    comments =
                        listOf(
                            CommentDto(
                                id = 1,
                                userName = "Luis Enrique Montero",
                                text = "Muchas gracias!, estoy aprendiendo mucho. Un saludo enorme.",
                                avatarUrl =
                                    "https://media.licdn.com/dms/image/v2/D4D03AQFlCSHGer5Mng/profile-displayphoto-" +
                                        "shrink_200_200/profile-displayphoto-shrink_200_200/0/1694610604805?e=" +
                                        "2147483647&v=beta&t=8Qv3Gizu2LXy5WFiTvpPIuijsusjo7jRGe-FF4U1xfY",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                            CommentDto(
                                id = 2,
                                userName = "Santiago Sanchez",
                                text = "El mejor curso de desarrollo de interfaces!.",
                                avatarUrl = "https://miel.unlam.edu.ar/data2/avatares/34870524.jpg?1586394949",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                            CommentDto(
                                id = 3,
                                userName = "Carlos Gimemez",
                                text = "Muy buen curso!.",
                                avatarUrl = "https://media.gq.com.mx/photos/5c6c494700f5a75446d1db89/master/w_1600%2Cc_limit/corbata.jpg",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                        ),
                    sections =
                        listOf(
                            CourseSectionDto(
                                id = 22,
                                title = "Introducción",
                                description = "",
                                videos =
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
                                    ),
                            ),
                            CourseSectionDto(
                                id = 23,
                                title = "Parte 1",
                                description = "",
                                videos =
                                    listOf(
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
                                    ),
                            ),
                            CourseSectionDto(
                                id = 24,
                                title = "Parte 2",
                                description = "",
                                videos =
                                    listOf(
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
                            ),
                        ),
                    features =
                        listOf(
                            CourseFeatureItemDto(
                                featureType =
                                    FeatureTypeDto(
                                        id = 1,
                                        name = "Certificado de finalización",
                                        iconKey = "certificate",
                                        showValue = false,
                                        unitLabel = null,
                                        displayOrder = 4,
                                    ),
                                value = null,
                            ),
                            CourseFeatureItemDto(
                                featureType =
                                    FeatureTypeDto(
                                        id = 2,
                                        name = "Acceso de por vida al contenido",
                                        iconKey = "access",
                                        showValue = false,
                                        unitLabel = null,
                                        displayOrder = 5,
                                    ),
                                value = null,
                            ),
                        ),
                    createdAt = "30/06/2025",
                    updatedAt = "30/06/2025",
                    topics =
                        listOf(
                            "Géneros y Estilos",
                            "Temas y Ambientaciones",
                            "Mecánicas de Juego",
                            "Herramientas y Lenguajes",
                            "Diseño de Sonido. Diseño Gráfico. Narrativas",
                        ),
                    tags = listOf("Videojuegos", "Prototipado", "Desarrollo"),
                    hasCertificate = true,
                    hasLifetimeAccess = true,
                ),
                CourseDto(
                    id = 9,
                    title = "Cálculo Mental",
                    subTitle = "Podrás adquirir un repertorio de cálculos con estrategias para agilizar tu velocidad mental",
                    description =
                        "Podrás adquirir un repertorio de cálculos con estrategias para agilizar tu velocidad mental",
                    thumbnailUrl =
                        "https://res.cloudinary.com/dznr3eupq/image/upload/v1751761010/calculo-mental_jbdrkx.jpg",
                    rating = 4.3,
                    ratingCount = 18,
                    price = 62050.00,
                    isFree = false,
                    instructors = listOf(instructorsDto[4]),
                    categories = listOf(categoriesDto[2]),
                    author = instructorsDto[4],
                    schedule =
                        listOf(
                            ScheduleDto("Martes", "19:00", "21:30"),
                        ),
                    totalStudents = 250,
                    level = levelsDto[1],
                    requirements = listOf("Conocer las 4 operaciones básicas"),
                    comments =
                        listOf(
                            CommentDto(
                                id = 1,
                                userName = "Luis Enrique Montero",
                                text = "Muchas gracias!, estoy aprendiendo mucho. Un saludo enorme.",
                                avatarUrl =
                                    "https://media.licdn.com/dms/image/v2/D4D03AQFlCSHGer5Mng/profile-displayphoto-" +
                                        "shrink_200_200/profile-displayphoto-shrink_200_200/0/1694610604805?e=" +
                                        "2147483647&v=beta&t=8Qv3Gizu2LXy5WFiTvpPIuijsusjo7jRGe-FF4U1xfY",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                            CommentDto(
                                id = 2,
                                userName = "Santiago Sanchez",
                                text = "El mejor curso de desarrollo de interfaces!.",
                                avatarUrl = "https://miel.unlam.edu.ar/data2/avatares/34870524.jpg?1586394949",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                            CommentDto(
                                id = 3,
                                userName = "Carlos Gimemez",
                                text = "Muy buen curso!.",
                                avatarUrl = "https://media.gq.com.mx/photos/5c6c494700f5a75446d1db89/master/w_1600%2Cc_limit/corbata.jpg",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                        ),
                    sections =
                        listOf(
                            CourseSectionDto(
                                id = 25,
                                title = "Presentación",
                                description = "",
                                videos =
                                    listOf(
                                        VideoItemDto(
                                            id = 56,
                                            title = "Repertorios de cálculos",
                                            description = "Cuentas que ya conocemos.",
                                            durationSeconds = 500,
                                            videoUrl = "https://video1.mp4",
                                            isPreview = true,
                                            order = 0,
                                        ),
                                    ),
                            ),
                            CourseSectionDto(
                                id = 26,
                                title = "Sumas mentales",
                                description = "",
                                videos =
                                    listOf(
                                        VideoItemDto(
                                            id = 57,
                                            title = "Sumas que dan 10",
                                            description = "",
                                            durationSeconds = 300,
                                            videoUrl = "https://video1.mp4",
                                            isPreview = false,
                                            order = 1,
                                        ),
                                        VideoItemDto(
                                            id = 58,
                                            title = "Sumas de números redondos",
                                            description = "",
                                            durationSeconds = 800,
                                            videoUrl = "https://video2.mp4",
                                            isPreview = false,
                                            order = 2,
                                        ),
                                    ),
                            ),
                            CourseSectionDto(
                                id = 27,
                                title = "Multiplicaciones mentales",
                                description = "",
                                videos =
                                    listOf(
                                        VideoItemDto(
                                            id = 59,
                                            title = "Unidad seguida de ceros",
                                            description = "",
                                            durationSeconds = 900,
                                            videoUrl = "https://video3.mp4",
                                            isPreview = false,
                                            order = 3,
                                        ),
                                        VideoItemDto(
                                            id = 60,
                                            title = "Descomposición de tablas",
                                            description = "",
                                            durationSeconds = 450,
                                            videoUrl = "https://video4.mp4",
                                            isPreview = false,
                                            order = 4,
                                        ),
                                    ),
                            ),
                        ),
                    features =
                        listOf(
                            CourseFeatureItemDto(
                                featureType =
                                    FeatureTypeDto(
                                        id = 1,
                                        name = "Certificado de finalización",
                                        iconKey = "certificate",
                                        showValue = false,
                                        unitLabel = null,
                                        displayOrder = 4,
                                    ),
                                value = null,
                            ),
                            CourseFeatureItemDto(
                                featureType =
                                    FeatureTypeDto(
                                        id = 2,
                                        name = "Acceso de por vida al contenido",
                                        iconKey = "access",
                                        showValue = false,
                                        unitLabel = null,
                                        displayOrder = 5,
                                    ),
                                value = null,
                            ),
                        ),
                    createdAt = "30/06/2025",
                    updatedAt = "30/06/2025",
                    topics =
                        listOf(
                            "Cálculos",
                            "Velocidad mental",
                            "Sumas",
                            "Multiplicaciones",
                            "Extra: División método frances",
                        ),
                    tags = listOf("Cálculo", "Suma", "Multiplicación"),
                    hasCertificate = true,
                    hasLifetimeAccess = true,
                ),
                CourseDto(
                    id = 10,
                    title = "Historia del Rock Argentino",
                    subTitle = "Un recorrido por las bandas de rock Argentino que dieron origen a este movimiento popular",
                    description =
                        "Un recorrido por las bandas de rock Argentino que dieron origen a este movimiento popular",
                    thumbnailUrl =
                        "https://res.cloudinary.com/dznr3eupq/image/upload/v1751763766/charly_m0hdrj.jpg",
                    rating = 4.9,
                    ratingCount = 23,
                    price = 30500.00,
                    isFree = false,
                    instructors = listOf(instructorsDto[3]),
                    categories = listOf(categoriesDto[6]),
                    author = instructorsDto[3],
                    schedule =
                        listOf(
                            ScheduleDto("Lunes a Viernes", "16:00", "17:00"),
                        ),
                    totalStudents = 50,
                    level = levelsDto[0],
                    requirements = listOf("Que te guste la música"),
                    comments =
                        listOf(
                            CommentDto(
                                id = 1,
                                userName = "Luis Enrique Montero",
                                text = "Muchas gracias!, estoy aprendiendo mucho. Un saludo enorme.",
                                avatarUrl =
                                    "https://media.licdn.com/dms/image/v2/D4D03AQFlCSHGer5Mng/profile-displayphoto-" +
                                        "shrink_200_200/profile-displayphoto-shrink_200_200/0/1694610604805?e=" +
                                        "2147483647&v=beta&t=8Qv3Gizu2LXy5WFiTvpPIuijsusjo7jRGe-FF4U1xfY",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                            CommentDto(
                                id = 2,
                                userName = "Santiago Sanchez",
                                text = "El mejor curso de desarrollo de interfaces!.",
                                avatarUrl = "https://miel.unlam.edu.ar/data2/avatares/34870524.jpg?1586394949",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                            CommentDto(
                                id = 3,
                                userName = "Carlos Gimemez",
                                text = "Muy buen curso!.",
                                avatarUrl = "https://media.gq.com.mx/photos/5c6c494700f5a75446d1db89/master/w_1600%2Cc_limit/corbata.jpg",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                        ),
                    sections =
                        listOf(
                            CourseSectionDto(
                                id = 28,
                                title = "Inicios",
                                description = "",
                                videos =
                                    listOf(
                                        VideoItemDto(
                                            id = 61,
                                            title = "Bandas originarias",
                                            description = "Los pioneros de la música.",
                                            durationSeconds = 700,
                                            videoUrl = "https://video1.mp4",
                                            isPreview = true,
                                            order = 0,
                                        ),
                                    ),
                            ),
                            CourseSectionDto(
                                id = 29,
                                title = "Orígenes del sonido",
                                description = "",
                                videos =
                                    listOf(
                                        VideoItemDto(
                                            id = 62,
                                            title = "Los años '70",
                                            description = "",
                                            durationSeconds = 300,
                                            videoUrl = "https://video1.mp4",
                                            isPreview = false,
                                            order = 1,
                                        ),
                                        VideoItemDto(
                                            id = 63,
                                            title = "Censuras y prohibición",
                                            description = "",
                                            durationSeconds = 800,
                                            videoUrl = "https://video2.mp4",
                                            isPreview = false,
                                            order = 2,
                                        ),
                                        VideoItemDto(
                                            id = 64,
                                            title = "Tiempos modernos",
                                            description = "",
                                            durationSeconds = 800,
                                            videoUrl = "https://video2.mp4",
                                            isPreview = false,
                                            order = 3,
                                        ),
                                    ),
                            ),
                            CourseSectionDto(
                                id = 30,
                                title = "Artistas reconocidos",
                                description = "",
                                videos =
                                    listOf(
                                        VideoItemDto(
                                            id = 65,
                                            title = "Charly, Spinetta y Soda",
                                            description = "",
                                            durationSeconds = 900,
                                            videoUrl = "https://video3.mp4",
                                            isPreview = false,
                                            order = 4,
                                        ),
                                        VideoItemDto(
                                            id = 66,
                                            title = "Bandas actuales e influencias",
                                            description = "",
                                            durationSeconds = 450,
                                            videoUrl = "https://video4.mp4",
                                            isPreview = false,
                                            order = 5,
                                        ),
                                    ),
                            ),
                        ),
                    features =
                        listOf(
                            CourseFeatureItemDto(
                                featureType =
                                    FeatureTypeDto(
                                        id = 1,
                                        name = "Certificado de finalización",
                                        iconKey = "certificate",
                                        showValue = false,
                                        unitLabel = null,
                                        displayOrder = 4,
                                    ),
                                value = null,
                            ),
                            CourseFeatureItemDto(
                                featureType =
                                    FeatureTypeDto(
                                        id = 2,
                                        name = "Acceso de por vida al contenido",
                                        iconKey = "access",
                                        showValue = false,
                                        unitLabel = null,
                                        displayOrder = 5,
                                    ),
                                value = null,
                            ),
                        ),
                    createdAt = "30/06/2025",
                    updatedAt = "30/06/2025",
                    topics =
                        listOf(
                            "Rock",
                            "Música Argentina",
                            "Temas icónicos",
                        ),
                    tags = listOf("Rock", "Música"),
                    hasCertificate = true,
                    hasLifetimeAccess = true,
                ),
                CourseDto(
                    id = 11,
                    title = "Ortografía",
                    subTitle = "Conocé las reglas ortografía para lograr una mejor redacción",
                    description =
                        "Conocé las reglas ortografía para lograr una mejor redacción",
                    thumbnailUrl =
                        "https://res.cloudinary.com/dznr3eupq/image/upload/v1751762668/ortografia_dopwah.jpg",
                    rating = 3.9,
                    ratingCount = 52,
                    price = 0.00,
                    isFree = true,
                    instructors = listOf(instructorsDto[1]),
                    categories = listOf(categoriesDto[3]),
                    author = instructorsDto[1],
                    schedule =
                        listOf(
                            ScheduleDto("Viernes", "10:00", "12:00"),
                        ),
                    totalStudents = 50,
                    level = levelsDto[0],
                    requirements = listOf("No requiere conocimientos previos"),
                    comments =
                        listOf(
                            CommentDto(
                                id = 1,
                                userName = "Luis Enrique Montero",
                                text = "Muchas gracias!, estoy aprendiendo mucho. Un saludo enorme.",
                                avatarUrl =
                                    "https://media.licdn.com/dms/image/v2/D4D03AQFlCSHGer5Mng/profile-displayphoto-" +
                                        "shrink_200_200/profile-displayphoto-shrink_200_200/0/1694610604805?e=" +
                                        "2147483647&v=beta&t=8Qv3Gizu2LXy5WFiTvpPIuijsusjo7jRGe-FF4U1xfY",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                            CommentDto(
                                id = 2,
                                userName = "Santiago Sanchez",
                                text = "El mejor curso de desarrollo de interfaces!.",
                                avatarUrl = "https://miel.unlam.edu.ar/data2/avatares/34870524.jpg?1586394949",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                            CommentDto(
                                id = 3,
                                userName = "Carlos Gimemez",
                                text = "Muy buen curso!.",
                                avatarUrl = "https://media.gq.com.mx/photos/5c6c494700f5a75446d1db89/master/w_1600%2Cc_limit/corbata.jpg",
                                date = "05/07/2025",
                                rating = 5,
                            ),
                        ),
                    sections =
                        listOf(
                            CourseSectionDto(
                                id = 31,
                                title = "Primeros conceptos",
                                description = "",
                                videos =
                                    listOf(
                                        VideoItemDto(
                                            id = 67,
                                            title = "Reglas básicas",
                                            description = "Aprende a redactar.",
                                            durationSeconds = 800,
                                            videoUrl = "https://video1.mp4",
                                            isPreview = true,
                                            order = 0,
                                        ),
                                    ),
                            ),
                            CourseSectionDto(
                                id = 32,
                                title = "Reglas ortográficas",
                                description = "",
                                videos =
                                    listOf(
                                        VideoItemDto(
                                            id = 68,
                                            title = "MB-NV",
                                            description = "",
                                            durationSeconds = 1100,
                                            videoUrl = "https://video1.mp4",
                                            isPreview = false,
                                            order = 1,
                                        ),
                                        VideoItemDto(
                                            id = 69,
                                            title = "MP",
                                            description = "",
                                            durationSeconds = 1500,
                                            videoUrl = "https://video2.mp4",
                                            isPreview = false,
                                            order = 2,
                                        ),
                                    ),
                            ),
                            CourseSectionDto(
                                id = 33,
                                title = "Coherencia y cohesión",
                                description = "",
                                videos =
                                    listOf(
                                        VideoItemDto(
                                            id = 70,
                                            title = "Terminadas en Z y plurales",
                                            description = "",
                                            durationSeconds = 500,
                                            videoUrl = "https://video3.mp4",
                                            isPreview = false,
                                            order = 3,
                                        ),
                                        VideoItemDto(
                                            id = 71,
                                            title = "Uso de la diéresis",
                                            description = "",
                                            durationSeconds = 700,
                                            videoUrl = "https://video4.mp4",
                                            isPreview = false,
                                            order = 4,
                                        ),
                                    ),
                            ),
                        ),
                    features =
                        listOf(
                            CourseFeatureItemDto(
                                featureType =
                                    FeatureTypeDto(
                                        id = 1,
                                        name = "Certificado de finalización",
                                        iconKey = "certificate",
                                        showValue = false,
                                        unitLabel = null,
                                        displayOrder = 4,
                                    ),
                                value = null,
                            ),
                            CourseFeatureItemDto(
                                featureType =
                                    FeatureTypeDto(
                                        id = 2,
                                        name = "Acceso de por vida al contenido",
                                        iconKey = "access",
                                        showValue = false,
                                        unitLabel = null,
                                        displayOrder = 5,
                                    ),
                                value = null,
                            ),
                        ),
                    createdAt = "30/06/2025",
                    updatedAt = "30/06/2025",
                    topics =
                        listOf(
                            "Textos",
                            "Artículos y pronombres",
                            "Repetición y omisión de palabras",
                            "Cómo escribir correctamente",
                            "Reglas ortográficas",
                        ),
                    tags = listOf("Lengua", "Redacción", "Escritura"),
                    hasCertificate = true,
                    hasLifetimeAccess = true,
                ),
            )

    val benefitDto =
        listOf(
            BenefitDto(
                id = 1,
                description = "3 cuotas sin interés",
                discountPercent = 10.00,
            ),
            BenefitDto(
                id = 2,
                description = "10% de descuento en cursos",
                discountPercent = 10.00,
            ),
            BenefitDto(
                id = 3,
                description = "15% de descuento en cursos",
                discountPercent = 15.00,
            ),
            BenefitDto(
                id = 4,
                description = "20% de descuento en cursos",
                discountPercent = 20.00,
            ),
            BenefitDto(
                id = 5,
                description = "25% de descuento en cursos",
                discountPercent = 25.00,
            ),
        )

    val medalsDto =
        listOf(
            RangeMedalDto(
                id = 1,
                name = "Nivel 1",
                number = 1,
                description = "Completaste hasta 100 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 0,
            ),
            RangeMedalDto(
                id = 2,
                name = "Nivel 2",
                number = 2,
                description = "Completaste más de 500 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 500,
            ),
            RangeMedalDto(
                id = 3,
                name = "Nivel 3",
                number = 3,
                description = "Completaste más de 1000 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 1000,
            ),
            RangeMedalDto(
                id = 4,
                name = "Nivel 4",
                number = 4,
                description = "Completaste más de 1500 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 1500,
            ),
            RangeMedalDto(
                id = 5,
                name = "Nivel 5",
                number = 5,
                description = "Completaste más de 2000 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 2000,
            ),
            RangeMedalDto(
                id = 6,
                name = "Nivel 6",
                number = 6,
                description = "Completaste más de 2500 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 2500,
            ),
            RangeMedalDto(
                id = 7,
                name = "Nivel 7",
                number = 7,
                description = "Completaste más de 3000 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 3000,
            ),
            RangeMedalDto(
                id = 8,
                name = "Nivel 8",
                number = 8,
                description = "Completaste más de 3500 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 3500,
            ),
            RangeMedalDto(
                id = 9,
                name = "Nivel 9",
                number = 9,
                description = "Completaste más de 4000 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 4000,
            ),
            RangeMedalDto(
                id = 10,
                name = "Nivel 10",
                number = 10,
                description = "Completaste más de 4500 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 4500,
            ),
            RangeMedalDto(
                id = 11,
                name = "Nivel 11",
                number = 11,
                description = "Completaste más de 5000 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 5000,
            ),
            RangeMedalDto(
                id = 12,
                name = "Nivel 12",
                number = 12,
                description = "Completaste más de 5500 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 5500,
            ),
            RangeMedalDto(
                id = 13,
                name = "Nivel 13",
                number = 13,
                description = "Completaste más de 6000 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 6000,
            ),
            RangeMedalDto(
                id = 14,
                name = "Nivel 14",
                number = 14,
                description = "Completaste más de 6500 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 6500,
            ),
            RangeMedalDto(
                id = 15,
                name = "Nivel 15",
                number = 15,
                description = "Completaste más de 7000 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 7000,
            ),
            RangeMedalDto(
                id = 16,
                name = "Nivel 16",
                number = 16,
                description = "Completaste más de 7500 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 7500,
            ),
            RangeMedalDto(
                id = 17,
                name = "Nivel 17",
                number = 17,
                description = "Completaste más de 8000 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 8000,
            ),
            RangeMedalDto(
                id = 18,
                name = "Nivel 18",
                number = 18,
                description = "Completaste más de 8500 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 8500,
            ),
            RangeMedalDto(
                id = 19,
                name = "Nivel 19",
                number = 19,
                description = "Completaste más de 9000 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 9000,
            ),
            RangeMedalDto(
                id = 20,
                name = "Nivel 20",
                number = 20,
                description = "Completaste más de 9500 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 9500,
            ),
            RangeMedalDto(
                id = 21,
                name = "Nivel 21",
                number = 21,
                description = "Completaste más de 10000 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 10000,
            ),
            RangeMedalDto(
                id = 22,
                name = "Nivel 22",
                number = 22,
                description = "Completaste más de 10500 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 10500,
            ),
            RangeMedalDto(
                id = 23,
                name = "Nivel 23",
                number = 23,
                description = "Completaste más de 11000 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 11000,
            ),
            RangeMedalDto(
                id = 24,
                name = "Nivel 24",
                number = 24,
                description = "Completaste más de 11500 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 11500,
            ),
            RangeMedalDto(
                id = 25,
                name = "Nivel 25",
                number = 25,
                description = "Completaste más de 12000 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 12000,
            ),
            RangeMedalDto(
                id = 26,
                name = "Nivel 26",
                number = 26,
                description = "Completaste más de 12500 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 12500,
            ),
            RangeMedalDto(
                id = 27,
                name = "Nivel 27",
                number = 27,
                description = "Completaste más de 13000 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 13000,
            ),
            RangeMedalDto(
                id = 28,
                name = "Nivel 28",
                number = 28,
                description = "Completaste más de 13500 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 13500,
            ),
            RangeMedalDto(
                id = 29,
                name = "Nivel 29",
                number = 29,
                description = "Completaste más de 14000 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
                threshold = 14000,
            ),
            RangeMedalDto(
                id = 30,
                name = "Nivel 30",
                number = 30,
                description = "Completaste más de 14500 puntos",
                benefits =
                    listOf(benefitDto[0], benefitDto[1]),
                icon =
                    "https://res.cloudinary.com/dznr3eupq/image/upload/v1751813111/" +
                        "medalla_nlx0ny.png",
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
            purchasedCourses = coursesDto.take(4),
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
            score = 5400,
            progressByCourse = emptyList(),
//            score = 0,
            preferredCategories =
                listOf(
                    categoriesDto[0],
                    categoriesDto[8],
                    categoriesDto[3],
                    categoriesDto[7],
                ),
            birthDate = "03-04-1990",
            addressNumber = "999",
            addressStreet = "Arieta",
            gender = "F",
            phoneNumber = "11-3003-3003",
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
        // 🔍 Buscar el curso
        val sections = coursesDto.find { it.id == courseId }?.sections ?: return

        // 🔍 Buscar el video dentro de las secciones
        val video =
            sections
                .flatMap { it.videos }
                .firstOrNull { it.id == videoId } ?: return

        val videoDuration = video.durationSeconds

//        val videoList = coursesDto.find { it.id == courseId }?.items ?: return
//        val videoDuration = videoList.find { it.id == videoId }?.durationSeconds ?: return

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
