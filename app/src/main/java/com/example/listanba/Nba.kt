package com.example.listanba

data class Nba(
    val id: Int,
    val name: String,
    val stadiumName: String,
    val titles: Int,
    val conferencia: Conferencias,
    val logo: String,
)

enum class Conferencias{
    ESTE,OESTE
}