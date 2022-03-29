package com.github.anonisnap.phrasecounter.ui.clickonteachers;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.github.anonisnap.phrasecounter.model.data.Phrase;
import com.github.anonisnap.phrasecounter.model.datapercistance.PhraseRepository;

public class ClickToCountViewModel extends AndroidViewModel {
	private final PhraseRepository repository;
	private Phrase phrase;
	private MutableLiveData<Integer> liveCount;

	public ClickToCountViewModel(Application app) {
		super(app);
		this.repository = PhraseRepository.getInstance(app);
		liveCount = new MutableLiveData<>();
	}

	public void setPhrase(Phrase phrase) {
		this.phrase = phrase;
		liveCount.setValue(phrase.getTimesSaid());
	}

	public Phrase getPhrase() {
		return phrase;
	}

	public void countUp() {
		liveCount.setValue(phrase.plusOne().getTimesSaid());
	}

	public void countDown() {
		liveCount.setValue(phrase.minusOne().getTimesSaid());
	}

	public void updateCount() {
		repository.updatePhrase(phrase);
	}

	public LiveData<Integer> getCount() {
		return liveCount;
	}
}