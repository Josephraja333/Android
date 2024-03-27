package com.example.dictionary.API

data class DictionaryData(
    val meanings: List<Meaning>,
    val phonetic: String?
)

data class Meaning (
    val partOfSpeech: String,
    val definitions: List<Definition>,
    val synonyms: List<String>,
    val antonyms: List<String>,
)

data class Definition(
    val definition: String
)