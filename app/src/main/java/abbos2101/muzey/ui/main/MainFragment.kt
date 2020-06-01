package abbos2101.muzey.ui.main

import abbos2101.muzey.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(container?.context)
            .inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val bundle = Bundle()
//        bundle.putString("title", "Abbos")
//        findNavController().navigate(
//            R.id.action_mainFragment_to_contentFragment,
//            bundle
//        )
    }

    private fun loadTmpList(){

    }
}