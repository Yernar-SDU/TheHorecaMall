package com.example.thehorecamall.ui.address_choose

import DeleteAddressDialog
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.thehorecamall.R

class NewAddressAddingFragment : Fragment() {
    lateinit var final_street: String
    lateinit var position: String
    lateinit var nameOfTheAddressEditText: EditText
    lateinit var deleteAddress: TextView
    lateinit var newAddressTextView: TextView
    lateinit var podezdEditText: EditText
    lateinit var saveButton: Button
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root : View = inflater.inflate(R.layout.new_address_add_layoutt,container,false)
        nameOfTheAddressEditText = root.findViewById(R.id.name_of_the_address_editText)
        podezdEditText = root.findViewById(R.id.podezd_editText)
        newAddressTextView = root.findViewById(R.id.new_address_textView)
        saveButton = root.findViewById(R.id.save_button)
        deleteAddress = root.findViewById(R.id.delete_address_button)
        hideKeyboard()
        return root
    }


    override fun onStart() {
        super.onStart()
        val args = arguments
        if (args != null) {
            final_street = args.getString("final_street").toString()
            position = args.getString("position").toString()
        }
        newAddressTextView.setText(final_street)

        Log.i("tag",final_street)

        saveButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(activity, ChooseAddressActivity::class.java).apply {
                    putExtra("nameOfTheAddress",nameOfTheAddressEditText.text.toString())
                    putExtra("finalStreet",final_street)
                    putExtra("podezdEditText",podezdEditText.text.toString())
                    putExtra("position",position)
                    putExtra("justDelete",false)

                }
                startActivity(intent)
            }

        })


        deleteAddress.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val args = Bundle()
                val dialogFragment : DialogFragment = DeleteAddressDialog()
                args.putString("position",position)
                args.putBoolean("justDelete",true)
                dialogFragment.arguments = args
                dialogFragment.show(childFragmentManager,"sad")

            }
        })


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

    fun delete(view : View){

    }
}