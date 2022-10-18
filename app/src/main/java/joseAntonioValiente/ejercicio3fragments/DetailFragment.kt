package joseAntonioValiente.ejercicio3fragments


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import joseAntonioValiente.ejercicio3fragments.databinding.FragmentDetailBinding



class DetailFragment : Fragment(R.layout.fragment_detail) {
    companion object{
        const val EXTRA_PERSON = "person"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDetailBinding.bind(view)

        val person = arguments?.getParcelable<Person>(EXTRA_PERSON)

            if (person != null) {
                binding.personName.text = person.name
                Glide.with(binding.personImage)
                    .load(person.image).into(binding.personImage)

            }
        }
    }
