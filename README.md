---

# 📱 My City – Naryn Edition

Android-приложение, созданное по codelab **Create a My City App**.
Приложение демонстрирует лучшие места города **Нарын** и построено с использованием современного Android-стека.

---

## 🏔 О проекте

**My City – Naryn Edition** — это Android-приложение, которое:
- Отображает категории мест в городе Нарын
- Показывает список рекомендаций
- Отображает детальную информацию о выбранном месте
- Использует несколько экранов
- Реализовано по архитектуре MVVM
- Поддерживает адаптацию под разные размеры экранов

---

## 🛠 Используемые технологии
- Kotlin
- Jetpack Compose
- Navigation Compose
- ViewModel
- Material Design 3
- WindowSizeClass (адаптивный UI)
- Unidirectional Data Flow (UDF)

---

## 🧱 Архитектура

Проект построен по архитектуре **MVVM**.

```
UI (Composable функции)
        ↓
ViewModel (State management)
        ↓
Data Layer (LocalDataProvider)
```

Основные принципы:
- UI не хранит состояние
- ViewModel управляет состоянием
- Данные передаются через immutable state
- Навигация отделена от UI-логики

---

## 📂 Структура проекта

```
com.yntymak.narynapp
├── data/
│   ├── Category.kt
│   ├── Place.kt
│   └── LocalDataProvider.kt
│
├── ui/
│   ├── screens/
│   │   ├── CategoryScreen.kt
│   │   ├── RecommendationScreen.kt
│   │   └── DetailScreen.kt
│   │
│   ├── navigation/
│   │   └── MyCityNavGraph.kt
│   │
│   ├── theme/
│   │   ├── Color.kt
│   │   ├── Theme.kt
│   │   └── Type.kt
│   │
│   ├── MyCityViewModel.kt
│   └── MyCityUiState.kt
│
└── MainActivity.kt
```

---

## 📱 Экраны приложения

### 1️⃣ Category Screen

Отображает 4 категории:
- **Природа и парки** — горы, озёра и природные парки
- **Культура и музеи** — исторические и культурные достопримечательности
- **Кафе и еда** — лучшие места с местной кухней
- **Гостиницы и жильё** — отели, гестхаусы и юрточные лагеря

### 2️⃣ Recommendation Screen

Показывает список мест выбранной категории.

**Природа и парки (4 места):**
- Озеро Сон-Куль
- Перевал Молдо-Ашуу
- Салкын-Тор
- Кел-Суу

**Культура и музеи (4 места):**
- Исторический музей Нарына
- Центральная мечеть
- Центральная площадь
- Smart Park

**Кафе и еда (4 места):**
- Bamboo
- Чайхана Жибек-Жолу
- Этно-комплекс Ордо
- Gurman

**Гостиницы и жильё (3 места):**
- Отель «Хан-Тенгри»
- Kerben Hotel
- As a nomad ethno complex

### 3️⃣ Detail Screen

Содержит:
- Название места
- Описание
- Фото
- Кнопку «Назад»

---

## 🧠 ViewModel

Состояние UI:
```kotlin
data class MyCityUiState(
    val selectedCategory: Category? = null,
    val selectedPlace: Place? = null
)
```

Функции:
- `selectCategory()` — выбор категории
- `selectPlace()` — выбор места
- `navigateBack()` — навигация назад
- `getCategories()` — получить все категории
- `getPlacesForCategory(categoryId)` — получить места по категории
- `getPlaceById(placeId)` — получить место по ID

---

## 🔁 Навигация

Используется **Navigation Compose**.

Routes:
- `"category"` — экран категорий
- `"recommendations/{categoryId}"` — список мест категории
- `"details/{placeId}"` — детальный экран места

---

## 📐 Адаптивный дизайн

Приложение:
- Поддерживает телефоны (Compact)
- Поддерживает планшеты (Expanded)
- Использует `WindowSizeClass`
- Отображает два экрана рядом на больших устройствах (two-pane layout)

---

## 📊 Данные

Данные хранятся локально в `LocalDataProvider` (hardcoded).

Модели:
```kotlin
data class Place(
    val id: Int,
    val name: String,
    val description: String,
    @DrawableRes val imageRes: Int,
    val category: Category
)

data class Category(
    val id: Int,
    val name: String,
    val description: String,
    @DrawableRes val iconRes: Int
)
```

Всего: **4 категории**, **15 мест**.

---

## 🚀 Как запустить

1. Открыть проект в Android Studio
2. Sync Gradle
3. Запустить эмулятор или подключить устройство
4. Нажать **Run**

---

## ✅ Требования проекта

| Требование | Статус |
|---|---|
| Используется ViewModel | ✔ |
| Используется Navigation | ✔ |
| Минимум 3 экрана | ✔ (3 экрана) |
| Минимум 3 категории | ✔ (4 категории) |
| Минимум 3 места в каждой категории | ✔ (3–4 в каждой) |
| UI адаптивный | ✔ |
| Архитектура MVVM | ✔ |

---

## 🎯 Цель проекта

Практика:
- Архитектуры MVVM
- Navigation Compose
- Управления состоянием
- Создания многослойного Android-приложения
- Адаптивного UI с WindowSizeClass
