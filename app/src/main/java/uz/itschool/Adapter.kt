package uz.itschool

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import coil.load
import coil.transform.CircleCropTransformation
import uz.itschool.databinding.ItemUserBinding

class Adapter(context: Context, var users: MutableList<User>) :
    ArrayAdapter<User>(context, R.layout.item_user, users) {

    private var isFav = false
    override fun getCount(): Int {
        return users.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemUserBinding
        if (convertView == null) {
            binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        } else {
            binding = ItemUserBinding.bind(convertView)
        }
        val user = users[position]
        binding.img.load(user.img) {
            placeholder(R.drawable.ic_launcher_background)
            error(androidx.appcompat.R.drawable.abc_btn_radio_material_anim)
            transformations(CircleCropTransformation())
        }
        binding.delete.setOnClickListener {
            users.remove(user)
            notifyDataSetChanged()
        }
        binding.edit.setOnClickListener {
            val dialog = Dialog(context)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.custom_dialog)
            val name = dialog.findViewById<TextView>(R.id.name)
            name.text = user.name
            val population = dialog.findViewById<TextView>(R.id.population)
            population.text = user.population
            val change = dialog.findViewById(R.id.change) as Button
            change.setOnClickListener {
                user.name = name.text.toString()
                user.population = population.text.toString()
                notifyDataSetChanged()
                dialog.dismiss()
            }
            dialog.show()
        }

        binding.name.text = user.name
        binding.population.text = user.population
        binding.area.text = user.area

        return binding.root
    }
}