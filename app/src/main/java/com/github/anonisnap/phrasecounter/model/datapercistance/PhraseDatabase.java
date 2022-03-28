package com.github.anonisnap.phrasecounter.model.datapercistance;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.github.anonisnap.phrasecounter.model.data.Phrase;

@Database(entities = {Phrase.class}, version = 2)
public abstract class PhraseDatabase extends RoomDatabase {
	private static PhraseDatabase instance;

	public abstract PhraseDao teacherPhraseDao();

	public static synchronized PhraseDatabase getInstance(Context context) {
		if (instance == null) {
			instance = Room.databaseBuilder(context.getApplicationContext(), PhraseDatabase.class, "phrase_count_database").fallbackToDestructiveMigration().build();
		}
		return instance;
	}
}
