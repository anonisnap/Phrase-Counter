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

import com.github.anonisnap.phrasecounter.databinding.FragmentClickOnTeachersBinding;

public class ClickOnTeachersFragment extends Fragment {
	// Android Views
	private Button countUpButton;
	private TextView phraseText, courseText, nameText, currentCountText;

	private ClickOnTeachersViewModel viewModel;
	private FragmentClickOnTeachersBinding binding;

	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		viewModel = new ViewModelProvider(this).get(ClickOnTeachersViewModel.class);

		binding = FragmentClickOnTeachersBinding.inflate(inflater, container, false);
		View root = binding.getRoot();

		countUpButton = binding.btnCountUp;
		phraseText = binding.txtPhrase;
		courseText = binding.txtCourse;
		nameText = binding.txtName;
		currentCountText = binding.txtCount;

		return root;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}

	@Override
	public void onDestroy() {
//		viewModel.updateCount();
		super.onDestroy();
	}
}