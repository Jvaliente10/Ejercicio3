package joseAntonioValiente.ejercicio3fragments


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import joseAntonioValiente.ejercicio3fragments.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMainBinding.bind(view).apply {
            recycler.adapter = PersonAdapter(persons){ person ->
                navigateTo(person)
            }
        }
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)
    }
    private fun navigateTo(person:Person) {
        val fragment = DetailFragment()
        fragment.arguments = bundleOf(DetailFragment.EXTRA_PERSON to person)

        parentFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.slide_right_in,
                R.anim.slide_left_out,
                R.anim.slide_left_in,
                R.anim.slide_right_out
            )
            .replace(R.id.fragment_container_view, fragment)
            .setReorderingAllowed(true)
            .addToBackStack(null)
            .commit()
        }


    private val persons =
        listOf(
            Person("Jose","jose123@gmail.com","689741554", "https://loremflickr.com/320/240/young,boy"),
            Person("Juan","juan123@gmail.com","612356778", "https://loremflickr.com/320/240/father"),
            Person("Maria","maria123@gmail.com","691753654", "https://loremflickr.com/320/240/women,young"),
            Person("Alba","alba123@gmail.com","639714852", "https://loremflickr.com/320/240/girl,redhead")
        )
}
