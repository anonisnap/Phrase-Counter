package com.github.anonisnap.phrasecounter.ui.leaderboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.github.anonisnap.phrasecounter.R;
import com.github.anonisnap.phrasecounter.databinding.FragmentLeaderboardListBinding;
import com.github.anonisnap.phrasecounter.model.data.Phrase;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class LeaderboardFragment extends Fragment {
	private FragmentLeaderboardListBinding binding;

	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		LeaderboardViewModel viewModel = new ViewModelProvider(this).get(LeaderboardViewModel.class);

		binding = FragmentLeaderboardListBinding.inflate(inflater, container, false);
		View root = binding.getRoot();

		binding.leaderboardView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
		viewModel.getAllPhrases().observe(getViewLifecycleOwner(), this::onChanged);

		return root;
	}

	private void onChanged(List<Phrase> phrases) {
		TeacherPhraseAdapter adapter = new TeacherPhraseAdapter(phrases);
		adapter.setOnClickListener(this::onPhraseClicked);
		binding.leaderboardView.setAdapter(adapter);
	}

	private void onPhraseClicked(Phrase phrase) {
		// Navigating to a different Fragment
		// Create a Bundle to send data
		Bundle bundle = new Bundle();
		// Fill bundle with Data
		bundle.putSerializable("phrase", phrase);
		System.out.println(bundle.getSerializable("phrase").toString());
		// Navigate with the bundle attached
		NavHostFragment.findNavController(this).navigate(R.id.action_nav_leaderboard_list_to_nav_click_to_count, bundle);
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}

}