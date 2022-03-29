package com.github.anonisnap.phrasecounter.ui.leaderboard;

import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.anonisnap.phrasecounter.R;
import com.github.anonisnap.phrasecounter.model.data.Phrase;

import java.util.ArrayList;
import java.util.List;

public class TeacherPhraseAdapter extends RecyclerView.Adapter<TeacherPhraseAdapter.ViewHolder> {
	private final List<Phrase> leaderboard;
	private OnClickListener listener;
	private final List<Integer> colours;

	public TeacherPhraseAdapter(List<Phrase> teacherPhrases) {
		leaderboard = teacherPhrases;
		colours = new ArrayList<>();
		colours.add(Color.rgb(212, 175, 55));
		colours.add(Color.rgb(192, 192, 192));
		colours.add(Color.rgb(205, 127, 50));
		colours.add(Color.argb(0, 0, 0, 0));
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		LayoutInflater inf = LayoutInflater.from(parent.getContext());
		View view = inf.inflate(R.layout.list_card_leaderboard, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		holder.courseView.setText(leaderboard.get(position).getCourse());
		holder.nameView.setText(leaderboard.get(position).getNameOfPerson());
		holder.phraseView.setText(leaderboard.get(position).getPhrase());
		holder.countView.setText(String.valueOf(leaderboard.get(position).getTimesSaid()));
		if (position < colours.size() - 1) {
			GradientDrawable gradient = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{colours.get(position), colours.get(colours.size() - 1)});
			gradient.setGradientType(GradientDrawable.LINEAR_GRADIENT);
			holder.rankGradient.setBackground(gradient);
			holder.rankGradient.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public int getItemCount() {
		return leaderboard.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {

		private final TextView courseView, nameView, phraseView, countView;
		private final View rankGradient;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);
			courseView = itemView.findViewById(R.id.leaderboard_course);
			nameView = itemView.findViewById(R.id.leaderboard_teacher_name);
			phraseView = itemView.findViewById(R.id.leaderboard_teacher_phrase);
			countView = itemView.findViewById(R.id.leaderboard_count);
			rankGradient = itemView.findViewById(R.id.rank_gradient);

			itemView.setOnClickListener(view -> listener.onClick(leaderboard.get(getBindingAdapterPosition())));
		}

	}

	public void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}

	public interface OnClickListener {
		void onClick(Phrase itemDisplay);
	}
}
