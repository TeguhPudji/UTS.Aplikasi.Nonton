package com.example.aplikasinonton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.aplikasinonton.fragment.BaruFragment;
import com.example.aplikasinonton.fragment.PopulerFragment;

public class ViewAdapter extends FragmentStateAdapter {
    public ViewAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0 :
                return new BaruFragment();
            case 1 :
                return new PopulerFragment();
            default:
                return new BaruFragment();
        }
    }

    @Override
    public int getItemCount() {

        return 2;
    }
}
