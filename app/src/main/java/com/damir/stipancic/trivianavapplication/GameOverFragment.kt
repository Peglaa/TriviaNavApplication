package com.damir.stipancic.trivianavapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.damir.stipancic.trivianavapplication.databinding.FragmentGameOverBinding

class GameOverFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameOverBinding>(
            inflater, R.layout.fragment_game_over, container, false
        )

        binding.tryAgainButton.setOnClickListener {
            findNavController().navigate(GameOverFragmentDirections.actionGameOverFragmentToGameFragment())
        }

        return binding.root
    }
}
