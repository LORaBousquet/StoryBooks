package fr.laurabousquet.storybooks

import android.app.Dialog
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import fr.laurabousquet.storybooks.adapter.bookAdapter
import fr.laurabousquet.storybooks.fragments.HomeFragment

class BookPopup(
    private val adapter: bookAdapter,
    private val currentBook: BookModel
): Dialog(adapter.context){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.popup_books_details)
        setupComponents()
        setupCloseButton()
        setupReadButton()

    }

    private fun setupReadButton() {
        // recuper
        val readButton = findViewById<ImageView>(R.id.round_button)

        if(currentBook.liked){
            readButton.setImageResource(R.drawable.ic_read)
        }
        else{
            readButton.setImageResource(R.drawable.ic_unread)
        }

    }


    private fun setupCloseButton() {
        findViewById<ImageView>(R.id.close_button).setOnClickListener{
            // fermer la fenêtre popup
            dismiss()
        }
    }

    private fun setupComponents() {
        //actualiser l'image du livre
        val bookImage = findViewById<ImageView>(R.id.image_item)
        Glide.with(adapter.context).load(Uri.parse(currentBook.imageUrl)).into(bookImage)

        //actualiser le nom du livre
        findViewById<TextView>(R.id.popup_book_name).text = currentBook.name

        //actualiser la description du livre
        findViewById<TextView>(R.id.popup_book_description_subtitle).text = currentBook.description

        //actualiser le genre du roman
        findViewById<TextView>(R.id.popup_book_genra_subtitle).text= currentBook.genra

        //actualiser la note du roman
        findViewById<TextView>(R.id.popup_book_score_subtitle).text= currentBook.score

    }

}