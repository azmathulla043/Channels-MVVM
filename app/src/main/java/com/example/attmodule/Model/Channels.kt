package com.example.attmodule.Model

data class Channels(
    val id:Int,
    val title :String,
    val startTime:LongIterator,
    val duration: Int,
    val image:String
)
