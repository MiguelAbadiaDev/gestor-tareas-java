# 📝 Gestor de Tareas - Java

Sistema de gestión de tareas por consola desarrollado en Java.

## 📋 Descripción

Aplicación que permite crear, listar, completar y eliminar tareas desde la línea de comandos. Cada tarea tiene:
- ID único autogenerado
- Título y descripción
- Estado (completada/pendiente)
- Fecha de creación

## 🚀 Funcionalidades

- ✅ Crear nuevas tareas
- 📄 Listar todas las tareas
- 🔍 Filtrar por estado (pendientes/completadas)
- 🔎 Buscar por ID
- ✔️ Marcar como completada/pendiente
- 🗑️ Eliminar tareas

## 🛠️ Tecnologías

- Java 17
- ArrayList para gestión de datos
- Excepciones personalizadas
- LocalDate para fechas

## 📦 Estructura del proyecto
```
src/
├── Main.java                      # Clase principal con menú
├── Tarea.java                     # Modelo de datos
└── TareaInvalidaException.java    # Excepción personalizada
```

## ▶️ Cómo ejecutar

1. Clona el repositorio:
```bash
git clone https://github.com/MiguelAbadiaDev/gestor-tareas-java.git
```

2. Navega a la carpeta src:
```bash
cd src
```

3. Compila:
```bash
javac *.java
```

4. Ejecuta:
```bash
java Main
```

5. Para volver a la raíz:
```bash
cd ..
```

## 📸 Ejemplo de uso
```
***MENÚ DE OPCIONES***
1. Crear Tarea
2. Listar todas las tareas
3. Listar tareas pendientes
...
```

## 🎯 Aprendizajes

Este proyecto me permitió practicar:
- Programación orientada a objetos
- Manejo de excepciones
- Colecciones (ArrayList)
- Validación de datos
- Documentación con Javadoc

## 👤 Autor

**Miguel Abadía Peñalver**
- GitHub: [@MiguelAbadiaDev](https://github.com/MiguelAbadiaDev)

## 📧 Contacto

¿Tienes preguntas o sugerencias? Abre un [issue](https://github.com/MiguelAbadiaDev/gestor-tareas-java/issues) o contáctame en GitHub.

## 📄 Licencia

Este proyecto es de código abierto para fines educativos.
