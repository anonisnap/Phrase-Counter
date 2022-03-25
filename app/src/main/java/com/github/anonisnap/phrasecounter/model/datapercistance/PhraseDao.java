package com.github.anonisnap.phrasecounter.model.datapercistance;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.github.anonisnap.phrasecounter.model.data.Phrase;

import java.util.List;

@Dao
public interface PhraseDao {
	@Insert(onConflict = OnConflictStrategy.ABORT, entity = Phrase.class)
	void insert(Phrase phrase);

	@Update(onConflict = OnConflictStrategy.ABORT, entity = Phrase.class)
	void update(Phrase phrase);

	@Delete(entity = Phrase.class)
	void delete(Phrase phrase);

	@Query("DELETE FROM phrase_count_table")
	void deleteAllPhrases();

	@Query("SELECT * FROM phrase_count_table ORDER BY timesSaid DESC")
	LiveData<List<Phrase>> getAllPhrases();
}
