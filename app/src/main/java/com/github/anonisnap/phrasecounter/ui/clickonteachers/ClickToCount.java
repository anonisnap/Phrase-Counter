package com.github.anonisnap.phrasecounter.ui.clickonteachers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.anonisnap.phrasecounter.databinding.FragmentClickToCountBinding;
import com.github.anonisnap.phrasecounter.model.data.Phrase;

import java.util.Locale;

public class ClickToCount extends Fragment {
	// Android Views
	private Button countUpButton;
	private TextView phraseText, courseText, nameText, currentCountText;

	private ClickToCountViewModel viewModel;
	private FragmentClickToCountBinding binding;

	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		viewModel = new ViewModelProvider(this).get(ClickToCountViewModel.class);

		binding = FragmentClickToCountBinding.inflate(inflater, container, false);
		View root = binding.getRoot();

		bindViews();
		if (getArguments() != null) {
			System.out.println(getArguments().isEmpty());
		} else {
			System.out.println("Bundle was Null");
		}
		Phrase phrase = (Phrase) getArguments().getSerializable("phrase");
		viewModel.setPhrase(phrase);
		populateViews(phrase);

		return root;
	}

	private void bindViews() {
		countUpButton = binding.btnCountUp;
		phraseText = binding.txtPhrase;
		courseText = binding.txtCourse;
		nameText = binding.txtName;
		currentCountText = binding.txtCount;
	}

	private void populateViews(Phrase phrase) {
		phraseText.setText(phrase.getPhrase());
		nameText.setText(phrase.getNameOfPerson());
		courseText.setText(phrase.getCourse());
		viewModel.getCount().observe(getViewLifecycleOwner(), count -> currentCountText.setText(String.format(Locale.ENGLISH, "x%d", count)));
		countUpButton.setOnClickListener(view -> viewModel.addToCount());
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}

	@Override
	public void onDestroy() {
		viewModel.updateCount();
		super.onDestroy();
	}
}