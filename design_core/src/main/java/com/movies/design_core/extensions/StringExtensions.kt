package com.movies.design_core.extensions



fun String.capitalizeFirstLetterOfEachWord(): String {
    return this.split(" ").joinToString(" ") {
        it.replaceFirstChar { char -> char.uppercase() }
    }
}