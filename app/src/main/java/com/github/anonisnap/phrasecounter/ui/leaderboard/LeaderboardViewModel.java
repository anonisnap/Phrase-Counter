package com.github.anonisnap.phrasecounter.ui.leaderboard;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.github.anonisnap.phrasecounter.model.data.Phrase;
import com.github.anonisnap.phrasecounter.model.datapercistance.PhraseRepository;

import java.util.List;

public class LeaderboardViewModel extends AndroidViewModel {
	private final PhraseRepository repo;

	public LeaderboardViewModel(Application app) {
		super(app);
		this.repo = PhraseRepository.getInstance(app);
	}

	public LiveData<List<Phrase>> getAllPhrases() {
		return repo.getAllPhrases();
	}

}