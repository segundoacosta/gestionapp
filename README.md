# GestionApp

## Descripción

GestionApp ha sido diseñada para proporcionar una solución completa y eficiente al reto de optimización de gestión de aplicaciones. Esta aplicación permite a los usuarios:

- Gestionar la información de las aplicaciones
- Visualizar datos relevantes para la toma de decisiones
- Recibir recomendaciones de optimización

La arquitectura y tecnologías elegidas aseguran que la aplicación sea robusta, mantenible y escalable, cumpliendo así con los requisitos técnicos y funcionales del desafío.

## Estructura del Proyecto

```
com.acosta.segundo.gestion.app/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/acosta/segundo/gestion/app/
│   │   │   │   ├── data/
│   │   │   │   │   ├── local/
│   │   │   │   │   │   ├── AppDatabase.kt
│   │   │   │   │   │   └── AppDao.kt
│   │   │   │   │   ├── remote/
│   │   │   │   │   │   └── FirebaseService.kt
│   │   │   │   │   ├── repository/
│   │   │   │   │   │   └── AppRepositoryImpl.kt
│   │   │   │   │   └── model/
│   │   │   │   │       └── AppEntity.kt
│   │   │   │   ├── domain/
│   │   │   │   │   ├── model/
│   │   │   │   │   │   └── App.kt
│   │   │   │   │   ├── repository/
│   │   │   │   │   │   └── AppRepository.kt
│   │   │   │   │   └── usecase/
│   │   │   │   │       ├── AddAppUseCase.kt
│   │   │   │   │       ├── GetAppsUseCase.kt
│   │   │   │   │       └── OptimizeAppsUseCase.kt
│   │   │   │   ├── presentation/
│   │   │   │   │   ├── ui/
│   │   │   │   │   │   ├── theme/
│   │   │   │   │   │   │   └── Theme.kt
│   │   │   │   │   │   ├── components/
│   │   │   │   │   │   │   ├── AppItem.kt
│   │   │   │   │   │   │   └── AppForm.kt
│   │   │   │   │   │   ├── screens/
│   │   │   │   │   │   │   ├── AppListScreen.kt
│   │   │   │   │   │   │   ├── AppDetailScreen.kt
│   │   │   │   │   │   │   └── OptimizationScreen.kt
│   │   │   │   │   ├── viewmodel/
│   │   │   │   │   │   ├── AppListViewModel.kt
│   │   │   │   │   │   └── OptimizationViewModel.kt
│   │   │   │   │   └── navigation/
│   │   │   │   │       └── Navigation.kt
│   │   │   │   └── di/
│   │   │   │       └── AppModule.kt
│   │   │   └── res/
│   │   └── androidTest/
│   └── build.gradle.kts
├── build.gradle.kts
└── settings.gradle.kts
```

## Características Principales

- Gestión de aplicaciones
- Visualización de datos de uso y recursos
- Recomendaciones de optimización
- Interfaz de usuario intuitiva con Jetpack Compose
- Arquitectura limpia y MVVM para una mejor separación de responsabilidades
- Persistencia de datos local con Room
- Inyección de dependencias con Hilt

## Tecnologías Utilizadas

- Kotlin
- Jetpack Compose
- Clean Architecture
- MVVM
- Room Database
- Hilt
- Coroutines y Flow

## Instalación

[Instrucciones de instalación aquí]

## Uso

[Instrucciones de uso aquí]

## Contribución

[Instrucciones para contribuir al proyecto aquí]

## Licencia

[Información de licencia aquí]
