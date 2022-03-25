package com.github.anonisnap.phrasecounter.ui.addnewphrase;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.github.anonisnap.phrasecounter.model.data.Phrase;
import com.github.anonisnap.phrasecounter.model.datapercistance.PhraseRepository;

public class AddNewPhraseViewModel extends AndroidViewModel {
	private final PhraseRepository repo;

	public AddNewPhraseViewModel(Application app) {
		super(app);
		repo = PhraseRepository.getInstance(app);
	}

	public void addNewPhrase(Phrase phrase) {
		repo.insert(phrase);
	}
}