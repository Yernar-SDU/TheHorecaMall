import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thehorecamall.ui.address_choose.ChooseAddressActivity

class DeleteAddressDialog : androidx.fragment.app.DialogFragment() {
    lateinit var position : String
    var justDelete : Boolean = false
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage("Вы действительно хотите удалить адрес?")
            .setPositiveButton("Да") { dialog, which ->
                val intent = Intent(activity, ChooseAddressActivity::class.java).apply {
                    putExtra("position",position)
                    putExtra("justDelete",true)
                }
                startActivity(intent)

            }
            .setNegativeButton("Нет") { _, _ -> }
            .create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments
        justDelete = args!!.getBoolean("justDelete")
        position = args!!.getString("position").toString()
    }


    companion object {
        const val TAG = "PurchaseConfirmationDialog"
    }
}