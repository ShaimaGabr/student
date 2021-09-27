import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.studentes.LocationViewModel
import com.example.studentes.R
import com.example.studentes.databinding.FragmentLocationBinding

class location : Fragment() {

lateinit var binding:FragmentLocationBinding
val viewmodedl:LocationViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentLocationBinding.inflate(inflater)
        binding.lifecycleOwner=this
        binding.viewModel=viewmodedl
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // viewmodedl.location(requireContext(),requireActivity())
    }


}