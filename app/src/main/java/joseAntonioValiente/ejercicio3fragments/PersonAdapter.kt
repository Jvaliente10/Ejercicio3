package joseAntonioValiente.ejercicio3fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import joseAntonioValiente.ejercicio3fragments.databinding.ViewPersonBinding


class PersonAdapter(val person: List<Person>, val listener: (Person) -> Unit) : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_person,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person =person[position]
        holder.bind(person)
        holder.itemView.setOnClickListener {
            listener(person)
        }
    }

    override fun getItemCount(): Int = person.size
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding=ViewPersonBinding.bind(view)
        fun bind(person: Person){
            binding.name.text = person.name
            binding.telfn.text = person.phone
            binding.mail.text = person.mail
            Glide.with(binding.root.context).load(person.image).into(binding.imagePerson)
        }
    }
}




