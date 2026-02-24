package com.yntymak.narynapp.data

import com.yntymak.narynapp.R

object LocalDataProvider {

    val categories = listOf(
        Category(
            id = 1,
            name = "Природа и парки",
            description = "Горы, озёра и природные парки Нарынской области",
            iconRes = R.drawable.ic_nature
        ),
        Category(
            id = 2,
            name = "Культура и музеи",
            description = "Исторические и культурные достопримечательности",
            iconRes = R.drawable.ic_culture
        ),
        Category(
            id = 3,
            name = "Кафе и еда",
            description = "Лучшие места с местной кухней и рынки",
            iconRes = R.drawable.ic_cafe
        ),
        Category(
            id = 4,
            name = "Гостиницы и жильё",
            description = "Отели, гестхаусы и юрточные лагеря",
            iconRes = R.drawable.ic_hotel
        )
    )

    private val nature = categories[0]
    private val culture = categories[1]
    private val cafe = categories[2]
    private val hotel = categories[3]

    val places = listOf(
        // Природа и парки
        Place(
            id = 1,
            name = "Озеро Сон-Куль",
            description = "Высокогорное озеро на высоте 3016 метров — одно из крупнейших озёр Кыргызстана. Летом здесь можно увидеть юрточные лагеря кочевников, насладиться невероятными закатами и познакомиться с традиционным бытом кыргызов.",
            imageRes = R.drawable.son_kol,
            category = nature
        ),
        Place(
            id = 2,
            name = "Перевал Молдо-Ашуу",
            description = "Горный перевал на высоте 3346 метров, соединяющий Нарынскую область с Джалал-Абадской. Захватывающие виды на горные хребты и долины делают это место популярным среди путешественников.",
            imageRes = R.drawable.moldo_ashuu2,
            category = nature
        ),
        Place(
            id = 4,
            name = "Салкын-Тор",
            description = "Живописное ущелье недалеко от города Нарын. Популярное место для пикников и отдыха на природе с красивыми горными пейзажами и чистым горным воздухом.",
            imageRes = R.drawable.salkyn_tor,
            category = nature
        ),
        Place(
            id = 5,
            name = "Кел-Суу",
            description = "Великолепное озеро Кель-Суу было сформировано тысячи лет назад из-за разрушения горного массива. Оно расположено в долине Кок-Кия (3 520 м), Нарынской области, недалеко от границы с Китаем. По дороге к озеру открывается великолепный вид на: горы хребта Ат-баши, каньон Эки-Нарын (слияния двух рек Малый Нарын и Нарын), крепость Koshoi-Коргон VIII-х вв.",
            imageRes = R.drawable.kel_suu2,
            category = nature
        ),

        // Культура и музеи
        Place(
            id = 6,
            name = "Исторический музей Нарына",
            description = "Музей истории города Нарын, где представлены экспонаты о кочевой культуре, истории Великого Шёлкового пути и археологические находки региона.",
            imageRes = R.drawable.museum,
            category = culture
        ),
        Place(
            id = 7,
            name = "Центральная мечеть",
            description = "Главная мечеть города Нарын, являющаяся духовным центром мусульманской общины региона. Архитектурная достопримечательность с элементами традиционного кыргызского стиля.",
            imageRes = R.drawable.mosque,
            category = culture
        ),
        Place(
            id = 8,
            name = "Центральная площадь",
            description = "Главная площадь города Нарын — место проведения праздников, фестивалей и культурных мероприятий. Здесь расположены памятники и административные здания.",
            imageRes = R.drawable.center,
            category = culture
        ),
        Place(
            id = 15,
            name = "Smart Park",
            description = "Современный парк в городе Нарын — пространство для отдыха, образования и культурных мероприятий. Здесь расположены интерактивные зоны, детские площадки и места для проведения городских событий.",
            imageRes = R.drawable.smart_park,
            category = culture
        ),

        // Кафе и еда
        Place(
            id = 9,
            name = "Bamboo",
            description = "Уютное кафе в центре Нарына с разнообразным меню кыргызской и европейской кухни. Популярно среди местных жителей и туристов благодаря домашней атмосфере.",
            imageRes = R.drawable.bamboo,
            category = cafe
        ),
        Place(
            id = 10,
            name = "Чайхана Жибек-Жолу",
            description = "Традиционная чайхана в Нарыне, где можно попробовать настоящий кыргызский чай и блюда национальной кухни. Атмосфера пропитана восточным колоритом, а интерьер украшен национальными орнаментами.",
            imageRes = R.drawable.jibek_jolu,
            category = cafe
        ),
        Place(
            id = 11,
            name = "Этно-комплекс Ордо",
            description = "Ресторан национальной кыргызской кухни. Фирменное блюдо — беш-бармак, приготовленный по традиционному рецепту. Также подают лагман, манты и другие блюда.",
            imageRes = R.drawable.ordo,
            category = cafe
        ),
        Place(
            id = 16,
            name = "Gurman",
            description = "Кафе с разнообразным меню, включающим блюда кыргызской и европейской кухни. Популярное место для семейных обедов и ужинов, а также для проведения праздников и мероприятий.",
            imageRes = R.drawable.gurman,
            category = cafe
        ),

        // Гостиницы и жильё
        Place(
            id = 12,
            name = "Отель «Хан-Тенгри»",
            description = "Grand Khan Tengri Hotel 4* — комфортабельный отель в Нарыне с видом на горы, рестораном «Эпос» и современными конференц-залами. Отличный выбор для отдыха и деловых поездок.",
            imageRes = R.drawable.grand_hotel,
            category = hotel
        ),
        Place(
            id = 13,
            name = "Kerben Hotel",
            description = "Kerben Hotel — это отель, расположенный в городе Naryn. К услугам гостей сад, общий лаундж, ресторан и бар. В распоряжении гостей отеля с 3 звездами — бесплатный Wi-Fi, доставка еды и напитков и круглосуточная стойка регистрации. На территории имеется частная парковка.",
            imageRes = R.drawable.kerben_hotel,
            category = hotel
        ),
        Place(
            id = 14,
            name = "As a nomad etho complex",
            description = "As A Nomad Naryn Ethno Complex — это отель типа «постель и завтрак» в городе Naryn. Здесь есть общий лаундж и терраса, а также ресторан и бар. Из окон открывается вид на горы. Гостям предоставляется бесплатный Wi-Fi на всей территории. Также на территории имеется частная парковка.",
            imageRes = R.drawable.as_nomad,
            category = hotel
        )
    )

    fun getPlacesByCategory(categoryId: Int): List<Place> {
        return places.filter { it.category.id == categoryId }
    }

    fun getPlaceById(placeId: Int): Place? {
        return places.find { it.id == placeId }
    }

    fun getCategoryById(categoryId: Int): Category? {
        return categories.find { it.id == categoryId }
    }
}
