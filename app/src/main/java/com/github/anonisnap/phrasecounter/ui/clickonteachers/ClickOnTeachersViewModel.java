package com.github.anonisnap.phrasecounter.ui.clickonteachers;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ClickOnTeachersViewModel extends ViewModel {

	private final MutableLiveData<String> mText;

	public ClickOnTeachersViewModel() {
		mText = new MutableLiveData<>();
		mText.setValue("This is gallery fragment");
	}

	public LiveData<String> getText() {
		return mText;
	}
}