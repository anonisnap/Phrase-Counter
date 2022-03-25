package com.github.anonisnap.phrasecounter.ui.addnewphrase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.anonisnap.phrasecounter.R;
import com.github.anonisnap.phrasecounter.databinding.FragmentAddNewPhraseBinding;
import com.github.anonisnap.phrasecounter.model.data.Phrase;

public class AddNewPhraseFragment extends Fragment {
	AddNewPhraseViewModel viewModel;
	private FragmentAddNewPhraseBinding binding;

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		viewModel = new ViewModelProvider(this).get(AddNewPhraseViewModel.class);
		binding = FragmentAddNewPhraseBinding.inflate(inflater, container, false);
		View root = binding.getRoot();

		binding.btnAddNewPhrase.setOnClickListener(this::addNewPhrase);

		return root;
	}

	private void addNewPhrase(View view) {
		EditText inputPhrase = binding.newPhrase, inputTeacher = binding.newTeacher, inputCourse = binding.newCourse;
		Phrase phrase = new Phrase(inputPhrase.getText().toString(), inputTeacher.getText().toString(), inputCourse.getText().toString(), 0);

		viewModel.addNewPhrase(phrase);

		inputPhrase.setText("");
		inputTeacher.setText("");
		inputCourse.setText("");

		Toast.makeText(getContext(), getContext().getString(R.string.phrase_add_confirm), Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}
}