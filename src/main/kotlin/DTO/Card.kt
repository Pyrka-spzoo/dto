package DTO

sealed class UnoCard(val name: String) {
    data class NumberCard(val color: Color, val number: Int) : UnoCard("NumberCard")
    data class SkipCard(val color: Color) : UnoCard("SkipCard")
    data class ReverseCard(val color: Color) : UnoCard("ReverseCard")
    data class DrawTwoCard(val color: Color) : UnoCard("DrawTwoCard")
    object WildCard : UnoCard("WildCard")
    object WildDrawFourCard : UnoCard("WildDrawFourCard")

    enum class Color {
        RED, YELLOW, GREEN, BLUE
    }
}

fun describeCard(card: UnoCard): String {
    return when (card) {
        is UnoCard.NumberCard -> "${card.name}: ${card.color} ${card.number}"
        is UnoCard.SkipCard -> "${card.name}: ${card.color}"
        is UnoCard.ReverseCard -> "${card.name}: ${card.color}"
        is UnoCard.DrawTwoCard -> "${card.name}: ${card.color}"
        UnoCard.WildCard -> UnoCard.WildCard.name
        UnoCard.WildDrawFourCard -> UnoCard.WildDrawFourCard.name
    }
}
