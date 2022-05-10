package com.damir.stipancic.trivianavapplication

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.damir.stipancic.trivianavapplication.databinding.FragmentGameWonBinding

class GameWonFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameWonBinding>(
            inflater, R.layout.fragment_game_won, container, false)

        setHasOptionsMenu(true)

        binding.nextMatchButton.setOnClickListener{
            findNavController().navigate(GameWonFragmentDirections.actionGameWonFragmentToGameFragment())
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.winner_menu, menu)

        if(null == requireActivity().packageManager.resolveActivity(getShareIntent(), 0)){
            menu.findItem(R.id.share).isVisible = false
        }

    }

    // Creating our Share Intent
    private fun getShareIntent() : Intent {
        val args = GameWonFragmentArgs.fromBundle(requireArguments())
        return ShareCompat.IntentBuilder(requireContext())
            .setText(getString(R.string.share_success_text, args.numCorrect, args.numQuestions))
            .setType("text/plain")
            .intent
    }

    // Starting an Activity with our new Intent
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)

    }
}