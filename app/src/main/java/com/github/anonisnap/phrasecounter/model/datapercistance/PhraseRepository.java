package com.github.anonisnap.phrasecounter.model.datapercistance;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.github.anonisnap.phrasecounter.model.data.Phrase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PhraseRepository {
	// Singleton
	private static PhraseRepository instance;
	// Database Access
	private final PhraseDao phraseDao;
	// LiveData used to automatically update the Viewport layers
	private final LiveData<List<Phrase>> allPhrases;
	// Used for Async
	private final ExecutorService executorService;

	// Private Constructor, part of Singleton
	private PhraseRepository(Application application) {
		PhraseDatabase database = PhraseDatabase.getInstance(application);
		phraseDao = database.teacherPhraseDao();
		allPhrases = phraseDao.getAllPhrases();
		executorService = Executors.newFixedThreadPool(2);
	}

	/**
	 * Access to Singleton Class, PhraseRepository.
	 *
	 * @param application Base Application of the process
	 * @return Instance of Singleton class, PhraseRepository
	 */
	public static synchronized PhraseRepository getInstance(Application application) {
		if (instance == null) {
			instance = new PhraseRepository(application);
		}

		return instance;
	}

	public LiveData<List<Phrase>> getAllPhrases() {
		return allPhrases;
	}

	/**
	 * Inserts a new Phrase into local Storage
	 *
	 * @param phrase Phrase to be added
	 */
	public void insert(Phrase phrase) {
		executorService.execute(() -> phraseDao.insert(phrase));
	}

	/**
	 * Removes all Phrases in the local Storage
	 */
	public void deleteAllPhrases() {
		executorService.execute(phraseDao::deleteAllPhrases);
	}

	/**
	 * Update existing Phrase by parsing a new Phrase with matching ID
	 *
	 * @param updatedPhrase Updated Phrase. Phrase with Matching ID will be updated
	 */
	public void updatePhrase(Phrase updatedPhrase) {
		executorService.execute(() -> phraseDao.update(updatedPhrase));
	}
}
