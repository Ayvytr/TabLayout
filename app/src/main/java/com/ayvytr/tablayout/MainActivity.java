package com.ayvytr.tablayout;

import android.os.Bundle;

import com.ayvytr.tablayout.databinding.ActivityMainBinding;
import com.ayvytr.tablayout.fragments.Fragment1;
import com.ayvytr.tablayout.fragments.Fragment2;
import com.ayvytr.tablayout.fragments.Fragment3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Fragment[] fragments = {new Fragment1(), new Fragment2(), new Fragment3(),
                                    new Fragment1(), new Fragment2(), new Fragment3()};
    private String[] titles = {
        "fragment 1", "long long long fragment 2", "fragment 3",
        "f 4", "long long title of fragment 5", "fragment fff 6"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments[position];
            }

            @Override
            public int getCount() {
                return fragments.length;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });
        binding.tabLayout.setupWithViewPager(binding.vp);
    }
}
