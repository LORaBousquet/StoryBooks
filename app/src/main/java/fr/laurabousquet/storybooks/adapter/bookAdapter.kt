package fr.laurabousquet.storybooks.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.laurabousquet.storybooks.BookModel
import fr.laurabousquet.storybooks.BookPopup
import fr.laurabousquet.storybooks.MainActivity
import fr.laurabousquet.storybooks.R

class bookAdapter (
    val context: MainActivity,
    private val bookList: List<BookModel>,
    private val layoutId: Int
) : RecyclerView.Adapter<bookAdapter.ViewHolder>(){

    // composant à controler
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val bookImage = view.findViewById<ImageView>(R.id.image_item)
        val bookName:TextView? =view.findViewById(R.id.name_item)
        val bookDescription:TextView? =view.findViewById(R.id.description_item)
        val unreadIcon = view.findViewById<ImageView>(R.id.unread_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(layoutId, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //recuperer les infos du livre
        val currentBook = bookList[position]

        // utiliser glide pour recup l'image depuis son lien
        Glide.with(context).load(Uri.parse(currentBook.imageUrl)).into(holder.bookImage)

        //maj le nom du livre
        holder.bookName?.text = currentBook.name

        //maj la description
        holder.bookDescription?.text = currentBook.description

        //verifier si le livre a été lu ou on
        if(currentBook.liked) {
            holder.unreadIcon.setImageResource(R.drawable.ic_read)
        }
        else {
            holder.unreadIcon.setImageResource(R.drawable.ic_unread)
        }

        // intercation lors du clic sur un livre
        holder.itemView.setOnClickListener{
            //afficher la popup
            BookPopup(this, currentBook).show()
        }

    }

    override fun getItemCount(): Int = bookList.size
}