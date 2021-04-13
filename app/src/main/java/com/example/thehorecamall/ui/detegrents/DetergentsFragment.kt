package com.example.thehorecamall.ui.detegrents

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.thehorecamall.*
import com.example.thehorecamall.adapter.ExpandableListAdapterForDetergents
import com.example.thehorecamall.adapter.ViewPagerAdapter

class DetergentsFragment : Fragment() {
    private lateinit var listDataHeader : ArrayList<String>
    private lateinit var listDataChild : HashMap<String, List<String>>
    private lateinit var expListView : ExpandableListView
    private lateinit var listAdapter: ExpandableListAdapterForDetergents
    private var images = arrayListOf<Int>(R.drawable.firstmainimage, R.drawable.firstmainimage, R.drawable.firstmainimage)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root: View = inflater.inflate(R.layout.detegrents_fragment, container, false)
        val viewPagerAdapter: ViewPagerAdapter = ViewPagerAdapter(activity, images)
        val viewPager: ViewPager = root.findViewById(R.id.recycleViewForScrollingImages)
        expListView = root.findViewById<View>(R.id.menu_items) as ExpandableListView
        viewPager.adapter = viewPagerAdapter

        enableExpandableList()
        return root

    }

    private fun prepareListData(
            listDataHeader: MutableList<String>,
            listDataChild: MutableMap<String, List<String>>
    ) {


        // Adding child data
        listDataHeader.add("anythinginthisworld")
        listDataHeader.add("anythinginthisworld")
        listDataHeader.add("anythinginthisworld")
        listDataHeader.add("anythinginthisworld")
        listDataHeader.add("anythinginthisworld")

        val childs: MutableList<String> = ArrayList()
        childs.add("anythinginthisworlds_child1")
        childs.add("anythinginthisworlds_child2")
        childs.add("anythinginthisworlds_child3")


        listDataChild[listDataHeader[0]] = childs
        listDataChild[listDataHeader[1]] = childs
        listDataChild[listDataHeader[2]] = childs
        listDataChild[listDataHeader[3]] = childs
        listDataChild[listDataHeader[4]] = childs



    }


    private fun enableExpandableList() {
        listDataHeader = ArrayList<String>()
        listDataChild = HashMap<String, List<String>>()
        prepareListData(listDataHeader, listDataChild)
        listAdapter = ExpandableListAdapterForDetergents(activity as Context, listDataHeader, listDataChild)

        // setting list adapter
        expListView.setAdapter(listAdapter)
        expListView.setOnGroupClickListener(ExpandableListView.OnGroupClickListener { parent, v, groupPosition, id -> // Toast.makeText(getApplicationContext(),
            // "Group Clicked " + listDataHeader.get(groupPosition),
            // Toast.LENGTH_SHORT).show();
            false
        })
        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(ExpandableListView.OnGroupExpandListener { groupPosition ->

        })

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(ExpandableListView.OnGroupCollapseListener { groupPosition ->
            Toast.makeText(
                    context, listDataHeader.get(groupPosition).toString() + " Collapsed",
                    Toast.LENGTH_SHORT
            ).show()
        })

        // Listview on child click listener
        expListView.setOnChildClickListener(ExpandableListView.OnChildClickListener { parent, v, groupPosition, childPosition, id -> // TODO Auto-generated method stub
            // Temporary code:

            // till here
            Toast.makeText(
                    context,
                    listDataHeader.get(groupPosition)
                            .toString() + " : "
                            + listDataChild.get(
                            listDataHeader.get(groupPosition)
                    )!!.get(
                            childPosition
                    ), Toast.LENGTH_SHORT
            )
                    .show()
            false
        })
    }



}
