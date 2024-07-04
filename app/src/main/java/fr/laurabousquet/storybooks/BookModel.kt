package fr.laurabousquet.storybooks

import org.w3c.dom.Text

class BookModel (
    val name: String = "Captive",
    val description: String ="Petite description",
    val imageUrl: String ="http://graven.yt/plantte.jpg",
    var liked: Boolean = false,
    val genra: String = "Romance",
    val score: String = "7/10"
)