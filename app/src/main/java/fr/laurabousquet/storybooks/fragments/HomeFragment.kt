package fr.laurabousquet.storybooks.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.laurabousquet.storybooks.BookModel
import fr.laurabousquet.storybooks.MainActivity
import fr.laurabousquet.storybooks.R
import fr.laurabousquet.storybooks.adapter.BookItemDecoration
import fr.laurabousquet.storybooks.adapter.bookAdapter

class HomeFragment(
    private val context: MainActivity
) : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // créer une liste qui va stocker les livres
        val bookList = arrayListOf<BookModel>()

        //1
        bookList.add(BookModel(
            name = "Captive - S.Rivens",
            description = "La dynastie des Scott.",
            imageUrl = "https://static.fnac-static.com/multimedia/PE/Images/FR/NR/04/73/00/16806660/1507-1/tsp20240605072046/Captive-tome-2-Edition-Collector.jpg",
            liked = true,
            genra = "Romance",
            score = "7/10"
        ))

        //2
        bookList.add(BookModel(
            name = "Albane - M.B.Dupuy",
            description = "Une femme durant la guerre.",
            imageUrl = "https://static.fnac-static.com/multimedia/PE/Images/FR/NR/b4/79/0d/17660340/1507-1/tsp20240614072948/Albane-T2-Au-nom-de-la-liberte.jpg",
            liked = false,
            genra = "Biographie",
            score = "6/10"
        ))

        //3
        bookList.add(BookModel(
            name = "Hades - S.St.Clair",
            description = "Romance Grecque",
            imageUrl = "https://static.fnac-static.com/multimedia/Images/FR/NR/69/b6/13/18069097/1507-1/tsp20240626080508/Hades-Persephone-Tome-1-Relie-jaspage.jpg",
            liked = true,
            genra = "Romance",
            score = "9/10"
        ))

        //4
        bookList.add(BookModel(
            name = "Jaanu - O.Ghanem",
            description = "Friends to Lovers.",
            imageUrl = "https://static.fnac-static.com/multimedia/PE/Images/FR/NR/cb/15/0b/17503691/1507-1.jpg",
            liked = false,
            genra = "Romance",
            score = "8/10"
        ))

        //5
        bookList.add(BookModel(
            name = "Katie - Mc.Dowell",
            description = "Endiablé !",
            imageUrl = "https://static.fnac-static.com/multimedia/PE/Images/FR/NR/b6/a0/fe/16687286/1507-1/tsp20240419115342/Katie.jpg",
            liked = false,
            genra = "Thriller",
            score = "5/10"
        ))

        //6
        bookList.add(BookModel(
            name = "Le Procès - F.Kafka",
            description = "Une justice invisible.",
            imageUrl = "https://static.fnac-static.com/multimedia/PE/Images/FR/NR/56/e0/02/188502/1507-1/tsp20240516083722/Le-Proces.jpg",
            liked = false,
            genra = "Thriller",
            score = "9/10"
        ))

        //7
        bookList.add(BookModel(
            name = "Mon Obscurité - V.Musso",
            description = "Trois femmes unies par un secret.",
            imageUrl = "https://static.fnac-static.com/multimedia/PE/Images/FR/NR/bd/00/08/17301693/1507-1/tsp20240621084129/Dans-mon-obscurite.jpg",
            liked = false,
            genra = "Thriller",
            score = "10/10"
        ))

        //8
        bookList.add(BookModel(
            name = "Le nageur - P.Assouline",
            description = "Un champion de l'eau.",
            imageUrl = "https://static.fnac-static.com/multimedia/PE/Images/FR/NR/31/80/06/17203249/1507-1/tsp20240606080400/Le-Nageur.jpg",
            liked = false,
            genra = "Biographie",
            score = "10/10"
        ))

        //9
        bookList.add(BookModel(
            name = "Le parfum - P.Süskind",
            description = "Histoire d'un nez.",
            imageUrl = "https://static.fnac-static.com/multimedia/Images/FR/NR/94/cd/03/249236/1507-1/tsp20230720114800/Le-Parfum.jpg",
            liked = true,
            genra = "Romance",
            score = "9/10"
        ))

        //10
        bookList.add(BookModel(
            name = "Virgin River - R.Carr",
            description = "La vie douce.",
            imageUrl = "https://static.fnac-static.com/multimedia/PE/Images/FR/NR/9a/0f/0a/17436570/1507-1/tsp20240620075119/Virgin-River-11-12.jpg",
            liked = false,
            genra = "Romance",
            score = "6/10"
        ))

        //11
        bookList.add(BookModel(
            name = "Une Vie - Maupassant",
            description = "La vie rurale.",
            imageUrl = "https://static.fnac-static.com/multimedia/Images/FR/NR/36/2e/03/208438/1507-1/tsp20230720134643/Une-vie.jpg",
            liked = true,
            genra = "Biographie",
            score = "10/10"
        ))


        //recup recycler view
        val horizontalRecyclerView = view?.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        if (horizontalRecyclerView != null)
            horizontalRecyclerView.adapter = bookAdapter (context, bookList.filter { !it.liked }, R.layout.item_horizontal_book)

            // recuperer le second recycler view
        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter=bookAdapter(context, bookList.filter { !it.liked }, R.layout.item_vertical_book)
        verticalRecyclerView.addItemDecoration(BookItemDecoration())
        return view
    }

    companion object {
        fun with(context: MainActivity) {

        }
    }
}