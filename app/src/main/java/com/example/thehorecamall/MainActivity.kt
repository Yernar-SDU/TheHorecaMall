package com.example.thehorecamall

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.view.WindowManager
import android.widget.ExpandableListView
import android.widget.ExpandableListView.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.example.thehorecamall.model.MenuItem
import com.example.thehorecamall.ui.address_choose.ChooseAddressActivity
import com.example.thehorecamall.ui.chat.ChatActivity
import com.example.thehorecamall.ui.detegrents.DetergentsActivity
import com.example.thehorecamall.ui.home.HomeFragment
import com.example.thehorecamall.ui.seller_log_in.SellerLoginActivity
import com.example.thehorecamall.ui.login.SendCodeActivity
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var listDataHeader : ArrayList<MenuItem>
    private lateinit var listDataChild : HashMap<MenuItem, List<MenuItem>>
    private lateinit var expListView : ExpandableListView
    private lateinit var listAdapter: ExpandListAdapter
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        //Make keyboard hidden onCreate
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)


        drawerLayout = findViewById(R.id.drawer_layout)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        //Make the background not shadowed
        drawerLayout.setScrimColor(resources.getColor(android.R.color.transparent));
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_gallery, R.id.nav_gallery, R.id.nav_gallery), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        enableExpandableList()

        setUpFragment(HomeFragment())
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)

        return true
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }



    private fun prepareListData(
            listDataHeader: MutableList<MenuItem>,
            listDataChild: MutableMap<MenuItem, List<MenuItem>>
    ) {

        val menuItem1 = MenuItem("LOG IN",false)
        val menuItem2 = MenuItem("SELLER LOG IN",false)
        val menuItem3 = MenuItem("CATEGORIES",false)
        val menuItem4 = MenuItem("DETERGENTS",true)
        val menuItem5 = MenuItem("COSMETICS",true)
        val menuItem6 = MenuItem("TEXTILES",true)
        val menuItem7 = MenuItem("EQUIPMENT",true)
        val menuItem8 = MenuItem("TABLEWARE",true)
        val menuItem9 = MenuItem("FURNITURE",true)
        val menuItem10 = MenuItem("INVENTORY",true)
        val menuItem11 = MenuItem("FOOD PRODUCTS",true)
        val menuItem12 = MenuItem("AROMATIZATION",true)
        val menuItem13 = MenuItem("DISINFECTION",true)
        val menuItem14 = MenuItem("CONSUMABLES",true)
        val menuItem15 = MenuItem("COMPARISIONS",true)
        val menuItem16 = MenuItem("FAVORITES",false)
        val menuItem17 = MenuItem("ORDERS",false)
        val menuItem18 = MenuItem("CHANGE LANGUAGE",false)
        val menuItem19 = MenuItem("KAZAKHSTAN",false)
        val menuItem20 = MenuItem("ALMATY",false)
        val menuItem21 = MenuItem("CHAT",false)
        val menuItem22 = MenuItem("CHOOSE PLACE",false)

        // Adding child data
        listDataHeader.add(menuItem1)
        listDataHeader.add(menuItem2)
        listDataHeader.add(menuItem3)
        listDataHeader.add(menuItem4)
        listDataHeader.add(menuItem5)
        listDataHeader.add(menuItem6)
        listDataHeader.add(menuItem7)
        listDataHeader.add(menuItem8)
        listDataHeader.add(menuItem9)
        listDataHeader.add(menuItem10)
        listDataHeader.add(menuItem11)
        listDataHeader.add(menuItem12)
        listDataHeader.add(menuItem13)
        listDataHeader.add(menuItem14)
        listDataHeader.add(menuItem15)
        listDataHeader.add(menuItem16)
        listDataHeader.add(menuItem17)
        listDataHeader.add(menuItem18)
        listDataHeader.add(menuItem19)
        listDataHeader.add(menuItem20)
        listDataHeader.add(menuItem21)
        listDataHeader.add(menuItem22)
        // Adding child data
        val detegrents: MutableList<MenuItem> = ArrayList()
        detegrents.add(MenuItem("consumables_child1",false))
        detegrents.add(MenuItem("consumables_child1",false))
        detegrents.add(MenuItem("consumables_child1",false))



        // Adding child data
        val cosmetics: MutableList<MenuItem> = ArrayList()
        cosmetics.add(MenuItem("consumables_child1",false))
        cosmetics.add(MenuItem("consumables_child1",false))
        cosmetics.add(MenuItem("consumables_child1",false))



        // Adding child data
        val textiles: MutableList<MenuItem> = ArrayList()
        textiles.add(MenuItem("consumables_child1",false))
        textiles.add(MenuItem("consumables_child1",false))
        textiles.add(MenuItem("consumables_child1",false))




        // Adding child data
        val eqipment: MutableList<MenuItem> = ArrayList()
        eqipment.add(MenuItem("consumables_child1",false))
        eqipment.add(MenuItem("consumables_child1",false))
        eqipment.add(MenuItem("consumables_child1",false))




        // Adding child data
        val tableware: MutableList<MenuItem> = ArrayList()
        tableware.add(MenuItem("consumables_child1",false))
        tableware.add(MenuItem("consumables_child1",false))
        tableware.add(MenuItem("consumables_child1",false))




        // Adding child data
        val furniture: MutableList<MenuItem> = ArrayList()
        furniture.add(MenuItem("consumables_child1",false))
        furniture.add(MenuItem("consumables_child1",false))
        furniture.add(MenuItem("consumables_child1",false))




        // Adding child data
        val inventory: MutableList<MenuItem> = ArrayList()
        inventory.add(MenuItem("consumables_child1",false))
        inventory.add(MenuItem("consumables_child1",false))
        inventory.add(MenuItem("consumables_child1",false))




        // Adding child data
        val food_products: MutableList<MenuItem> = ArrayList()
        food_products.add(MenuItem("consumables_child1",false))
        food_products.add(MenuItem("consumables_child1",false))
        food_products.add(MenuItem("consumables_child1",false))




        // Adding child data
        val aromatization: MutableList<MenuItem> = ArrayList()
        aromatization.add(MenuItem("consumables_child1",false))
        aromatization.add(MenuItem("consumables_child1",false))
        aromatization.add(MenuItem("consumables_child1",false))




        // Adding child data
        val disenfection: MutableList<MenuItem> = ArrayList()
        disenfection.add(MenuItem("disenfection_child1",false))
        disenfection.add(MenuItem("disenfection_child2",false))
        disenfection.add(MenuItem("disenfection_child3",false))


        // Adding child data
        val consumables: MutableList<MenuItem> = ArrayList()
        consumables.add(MenuItem("consumables_child1",false))
        consumables.add(MenuItem("consumables_child2",false))
        consumables.add(MenuItem("consumables_child3",false))


        listDataChild[listDataHeader[3]] = detegrents
        listDataChild[listDataHeader[4]] = cosmetics
        listDataChild[listDataHeader[5]] = textiles
        listDataChild[listDataHeader[6]] = eqipment
        listDataChild[listDataHeader[7]] = tableware
        listDataChild[listDataHeader[8]] = furniture
        listDataChild[listDataHeader[9]] = inventory
        listDataChild[listDataHeader[10]] = food_products
        listDataChild[listDataHeader[11]] = aromatization
        listDataChild[listDataHeader[12]] = disenfection
        listDataChild[listDataHeader[13]] = consumables
    }


    private fun enableExpandableList() {
        listDataHeader = ArrayList<MenuItem>()
        listDataChild = HashMap<MenuItem, List<MenuItem>>()
        expListView = findViewById<View>(R.id.left_drawer) as ExpandableListView
        prepareListData(listDataHeader, listDataChild)
        listAdapter = ExpandListAdapter(this, listDataHeader, listDataChild)
        // setting list adapter
        expListView.setAdapter(listAdapter)
        expListView.setOnGroupClickListener(OnGroupClickListener { parent, v, groupPosition, id ->
            if(listDataHeader.get(groupPosition).name.equals("SELLER LOG IN")){
                val intent = Intent(this@MainActivity, SellerLoginActivity::class.java).apply {  }
                Log.i("intent",intent.toString())
                startActivity(intent)
            }

            if(listDataHeader.get(groupPosition).name.equals("LOG IN")){
                val intent = Intent(this@MainActivity, SendCodeActivity::class.java).apply {  }
                Log.i("intent",intent.toString())
                startActivity(intent)
            }
            else if(listDataHeader.get(groupPosition).name.equals("DETERGENTS")){
                val intent = Intent(this@MainActivity, DetergentsActivity::class.java).apply {  }
                startActivity(intent)

            }
            else if(listDataHeader.get(groupPosition).name.equals("CATEGORIES")){
                setUpFragment(HomeFragment())
                drawerLayout.closeDrawers()
            }
            else if(listDataHeader.get(groupPosition).name.equals("CHAT")){
                val intent = Intent(this@MainActivity, ChatActivity::class.java).apply {  }
                startActivity(intent)
            }
            else if(listDataHeader.get(groupPosition).name.equals("CHOOSE PLACE")){
                val intent = Intent(this@MainActivity, ChooseAddressActivity::class.java).apply {  }
                startActivity(intent)
            }
            false
        })
        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(OnGroupExpandListener { groupPosition ->
            false


        })
        expListView.setOnGroupCollapseListener { groupPosutuin ->
            false
        }

        // Listview on child click listener
        expListView.setOnChildClickListener(OnChildClickListener { parent, v, groupPosition, childPosition, id -> // TODO Auto-generated method stub
            // Temporary code:

            // till here
            Toast.makeText(
                applicationContext,
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


    private fun setUpFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
    }
}