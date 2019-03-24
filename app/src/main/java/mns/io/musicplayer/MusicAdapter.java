package mns.io.musicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import mns.io.musicplayer.databinding.MusicViewBinding;
import mns.io.musicplayer.model.Music;
import mns.io.musicplayer.model.musicViewModel.MusicViewModel;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder> {

    private List<Music> data;
    private Context context;
    public class MusicViewHolder extends RecyclerView.ViewHolder{

        final MusicViewBinding binding;
        private Context context;

        public MusicViewHolder(MusicViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.context = context;
        }

        public void bind(Music music) {
            binding.setObj(new MusicViewModel(music));
        }
    }

    public MusicAdapter(List<Music> mData, Context context){
        this.data = mData;
        this.context = context;
    }


    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        MusicViewBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.music_view, parent, false);

        return new MusicViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {



        holder.bind(data.get(position));


    }


    @Override
    public int getItemCount() {
        return data.size();
    }



}
