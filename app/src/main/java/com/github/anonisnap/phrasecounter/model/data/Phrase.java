package com.github.anonisnap.phrasecounter.model.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Locale;

@Entity(tableName = "phrase_count_table")
public class Phrase implements Serializable {
	@PrimaryKey(autoGenerate = true)
	private int id;

	// Phrase Details
	@NotNull
	private final String phrase;
	@NotNull
	private final String course;
	@NotNull
	private final String nameOfPerson;
	private int timesSaid;

	public Phrase(@NonNull String phrase, @NonNull String nameOfPerson, @NonNull String course, int timesSaid) {
		this.phrase = phrase;
		this.nameOfPerson = nameOfPerson;
		this.course = course;
		this.timesSaid = timesSaid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@NonNull
	public String getPhrase() {
		return phrase;
	}

	@NonNull
	public String getCourse() {
		return course;
	}

	@NonNull
	public String getNameOfPerson() {
		return nameOfPerson;
	}

	public int getTimesSaid() {
		return timesSaid;
	}

	@NotNull
	@Override
	public String toString() {
		return String.format(Locale.ENGLISH, "%s ~%s [%s] | x%d", phrase, nameOfPerson, course, timesSaid);
	}

	public Phrase plusOne() {
		timesSaid++;
		return this;
	}

	public Phrase minusOne() {
		timesSaid--;
		return this;
	}
}
