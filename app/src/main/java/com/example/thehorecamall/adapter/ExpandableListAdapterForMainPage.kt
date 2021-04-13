package com.example.thehorecamall

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.example.thehorecamall.model.MenuItem


class ExpandListAdapter(
        context: Context, listDataHeader: List<MenuItem>,
        listChildData: HashMap<MenuItem, List<MenuItem>>
) : BaseExpandableListAdapter() {

    private val images = arrayListOf<Int>(R.drawable.login,R.drawable.sellerlogin,R.drawable.categories,R.drawable.detegrents,R.drawable.cosmetics,
                                            R.drawable.textiles,R.drawable.equipment,R.drawable.tableware,R.drawable.furniture,R.drawable.inventory,
                                            R.drawable.foodproducts,R.drawable.aromatization,R.drawable.disinfection,
                                            R.drawable.consumables,R.drawable.comparisons,R.drawable.favorites,R.drawable.orders,R.drawable.changelanguage,
                                            R.drawable.kazakhstan,R.drawable.almaty,0,0,0,0)
    private val _context: Context
    private val _listDataHeader // header titles
            : List<MenuItem>

    // child data in format of header title, child title
    private val _listDataChild: HashMap<MenuItem, List<MenuItem>>
    override fun getChild(groupPosition: Int, childPosititon: Int): Any {
        return _listDataChild[_listDataHeader[groupPosition]]
                ?.get(childPosititon)!!
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getChildView(
        groupPosition: Int, childPosition: Int,
        isLastChild: Boolean, convertView: View?, parent: ViewGroup?
    ): View? {
        var convertView: View? = convertView
        val childText = getChild(groupPosition, childPosition) as MenuItem
        if (convertView == null) {
            val infalInflater = _context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = infalInflater.inflate(R.layout.list_item, null)
        }
        val txtListChild = convertView
            ?.findViewById(R.id.lblListItem) as TextView
        txtListChild.text = childText.name
        return convertView
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        if(_listDataChild[_listDataHeader[groupPosition]] == null){
            return 0
        }
        return _listDataChild[_listDataHeader[groupPosition]]
            ?.size!!
    }

    override fun getGroup(groupPosition: Int): Any {
        return _listDataHeader[groupPosition]
    }

    override fun getGroupCount(): Int {
        return _listDataHeader.size

    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getGroupView(
        groupPosition: Int, isExpanded: Boolean,
        convertView: View?, parent: ViewGroup?
    ): View? {
        var convertView: View? = convertView
        val headerTitle = getGroup(groupPosition) as MenuItem
        var groupPosition2 = groupPosition + getChildrenCount(groupPosition)
        if (convertView == null) {
            val infalInflater = _context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = infalInflater.inflate(R.layout.list_group, null)
        }

        if(getChildrenCount(groupPosition) != 0){

            val list_group_image = convertView?.findViewById(R.id.list_group_image) as ImageView
            list_group_image.setImageResource(R.drawable.circleplus)
        }
        val left_group_image = convertView
                ?.findViewById(R.id.left_group_image) as ImageView
        left_group_image.setImageResource(images[groupPosition])

        val lblListHeader = convertView
            ?.findViewById(R.id.lblListHeader) as TextView
        lblListHeader.text = headerTitle.name

        return convertView
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    init {
        _context = context
        _listDataHeader = listDataHeader
        _listDataChild = listChildData
    }



}