package com.ifs21016.galeriputri.ui.listview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.ifs21016.galeriputri.R
import java.util.*

class ListviewFragment : Fragment() {

    private lateinit var myListView: ListView
    private lateinit var mySortButton: Button
    private var galaxies = arrayOf(
        "Ultah", "Gereja", "Pulang Gereja", "pak jO", "Saya",
        "Takjil", "Seblak", "Selfie", "List",
        "MBKM", "Perpustakaan", "Kaprodi", "Anime",
        "Samsung", "Smash", "spt", "Messier 87"
    )
    private var sortAscending = true
    private var galaxiesList = Arrays.asList(*galaxies)

    private fun sortData() {
        if (sortAscending) galaxiesList.sorted()
        else galaxiesList.sortedDescending()

        sortAscending = !sortAscending
        myListView.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, galaxiesList)
        myListView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, i, _ ->
                Toast.makeText(
                    requireContext(),
                    galaxiesList[i],
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    private fun initializeViews(view: View) {
        myListView = view.findViewById(R.id.myListView)
        myListView.adapter = object : ArrayAdapter<String>(requireContext(), R.layout.item_galery, R.id.galaxyName, galaxiesList) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                val galaxyImage = view.findViewById<ImageView>(R.id.galaxyImage)
                when (galaxiesList[position]) {
                    "Ultah" -> galaxyImage.setImageResource(R.drawable.ultah)
                    "Gereja" -> galaxyImage.setImageResource(R.drawable.gereja)
                    "Pulang Gereja" -> galaxyImage.setImageResource(R.drawable.pulanggereja)
                    "Pak Jo" -> galaxyImage.setImageResource(R.drawable.pakjo)
                    "Saya" -> galaxyImage.setImageResource(R.drawable.saye)
                    "Takjil" -> galaxyImage.setImageResource(R.drawable.takjil)
                    "Seblak" -> galaxyImage.setImageResource(R.drawable.seblak)
                    "Selfie" -> galaxyImage.setImageResource(R.drawable.sefie)
                    "List" -> galaxyImage.setImageResource(R.drawable.list)
                    "MBKM" -> galaxyImage.setImageResource(R.drawable.mbkm)
                    "Perpus" -> galaxyImage.setImageResource(R.drawable.perpus)
                    "kaprodi" -> galaxyImage.setImageResource(R.drawable.kaprodi)
                    "Anime" -> galaxyImage.setImageResource(R.drawable.anime)
                    "Samsung" -> galaxyImage.setImageResource(R.drawable.samsung)
                    "Smash" -> galaxyImage.setImageResource(R.drawable.smash)
                    "SPT" -> galaxyImage.setImageResource(R.drawable.spt)
                    "Messier 87" -> galaxyImage.setImageResource(R.drawable.messier_87)
                }
                return view
            }
        }


        mySortButton = view.findViewById(R.id.mySortBtn)
        mySortButton.setOnClickListener { sortData() }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_listview, container, false)
        initializeViews(view)
        return view
    }
}
