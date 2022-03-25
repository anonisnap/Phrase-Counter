package com.github.anonisnap.phrasecounter.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

	private final MutableLiveData<String> mText;

	public HomeViewModel() {
		mText = new MutableLiveData<>();
		mText.setValue("Welcome to the Teacher Counting App!\nThis Application is meant to help you keep track of how often your teachers may say specific phrases or words"); // Magic
	}

	public LiveData<String> getText() {
		return mText;
	}
}