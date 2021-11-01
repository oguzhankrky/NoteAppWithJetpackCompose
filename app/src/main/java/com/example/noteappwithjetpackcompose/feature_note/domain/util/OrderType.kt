package com.example.noteappwithjetpackcompose.feature_note.domain.util

sealed class OrderType
{
    object Ascending:OrderType()
    object Descending:OrderType()

}
