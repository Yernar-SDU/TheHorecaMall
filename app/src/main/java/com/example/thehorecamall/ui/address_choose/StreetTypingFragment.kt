package com.example.thehorecamall.ui.address_choose

import CityModel
import android.R.attr.data
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.thehorecamall.Network.GeoCodeApi
import com.example.thehorecamall.Network.GeoCodeInterface
import com.example.thehorecamall.R
import com.example.thehorecamall.adapter.AutoCompleteAddressAdapter
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import retrofit2.Call


class StreetTypingFragment : Fragment() , TextWatcher{
    val url : String = "https://autocomplete.geocoder.ls.hereapi.com/6.2/suggest.json?apiKey=0kVVNurfkAzNulnxLtZ30twz5z6ULGt2bLxirrqL1wE&query="
    lateinit var address_EditText : EditText
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: AutoCompleteAddressAdapter
    lateinit var final_street: String
    val cityModels : MutableList<CityModel> = arrayListOf()

    lateinit var autocompleteFragment : AutocompleteSupportFragment
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root : View = inflater.inflate(
                R.layout.adding_addresses_appearing_layout,
                container,
                false
        )
        adapter  = AutoCompleteAddressAdapter(cityModels)
        recyclerView = root.findViewById(R.id.addresses_recycleView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        address_EditText = root.findViewById(R.id.address_edit_text)
        address_EditText.addTextChangedListener(this)
        val args = arguments
        var position : String = "0"
        if (args != null) {
            position = args.getString("position").toString()
        }

        address_EditText.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent): Boolean {
                return if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    val fragmentB = NewAddressAddingFragment()
                    val args = Bundle()
                    args.putString("final_street",final_street)
                    args.putString("position",position)
                    fragmentB.arguments = args
                    hideKeyboard()
                    activity?.supportFragmentManager
                            ?.beginTransaction()
                            ?.replace(R.id.fragmentForNewAddress, fragmentB)
                            ?.commit()
                    fragmentB.setArguments(args)
                    activity?.supportFragmentManager
                            ?.beginTransaction()
                            ?.remove(activity?.supportFragmentManager!!.findFragmentById(R.id.fragmentForAddingAddresses)!!)
                            ?.commit()
                    true
                } else false
            }
        })
        return root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onStart() {
        super.onStart()

    }
    fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }

    fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }


    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        val gson = Gson()
        val api_interface : GeoCodeInterface = GeoCodeApi().getClient().create(GeoCodeInterface::class.java)
        val call : Call<List<CityModel>> = api_interface.getGeocode()

        if (s != null && s.length > 0 && !s.equals("")) {
            val stringRequest = StringRequest(Request.Method.GET,
                    url + s,
                    { response ->
                        val mainObject = JSONObject(response)
                        val month = mainObject.getJSONArray("suggestions")
                        for (i in 0 until month.length()) {
                            val addressObject = month.getJSONObject(i).getJSONObject("address")
                            val collectionType = object : TypeToken<List<CityModel?>?>() {}.type
                            lateinit var cityModel: CityModel
                            if (addressObject.has("street") && addressObject.has("city") && addressObject.has("country")) {
                                cityModel = CityModel(addressObject.getString("street"), addressObject.getString("city"), addressObject.getString("country"))
                            } else if (addressObject.has("city") && addressObject.has("country")) {
                                cityModel = CityModel(month.getJSONObject(i).getString("label"), addressObject.getString("city"), addressObject.getString("country"))
                            } else if (addressObject.has("country")) {
                                cityModel = CityModel(month.getJSONObject(i).getString("label"), "Вне города", addressObject.getString("country"))
                            } else {
                                cityModel = CityModel(month.getJSONObject(i).getString("label"), "Вне города", "Вне страны")
                            }
                            cityModels.add(cityModel)
                            Log.i("tsg", "city: " + cityModels.get(i).city + " country: " + cityModels.get(i).country + " street: " + cityModels.get(i).street)

                        }
                    },
                    { })
            val requestQueue : RequestQueue = Volley.newRequestQueue(context)
            requestQueue.add(stringRequest)
        }
        adapter.notifyDataSetChanged()
        cityModels.clear()
    }

    override fun afterTextChanged(s: Editable?) {
        final_street = s.toString()
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
        recyclerView.isNestedScrollingEnabled = false
        recyclerView.layoutManager = layoutManager
        adapter  = AutoCompleteAddressAdapter(cityModels)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }


}

