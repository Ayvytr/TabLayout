package com.ayvytr.app;

import android.os.Bundle;

import com.ayvytr.app.databinding.ActivityMainBinding;
import com.ayvytr.app.fragments.Fragment1;
import com.ayvytr.app.fragments.Fragment2;
import com.ayvytr.app.fragments.Fragment3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private Fragment[] fragments = {new Fragment1(), new Fragment2(), new Fragment3(),
//                                    new Fragment1(), new Fragment2(), new Fragment3()
    };
    private String[] titles = {
            "f1", "long fragment 2", "f 3",
            "fragment 1", "long long fragment 2", "fragment 3",
//            "f 4", "long long title of fragment 5", "fragment fff 6"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
//        binding.vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
//            @NonNull
//            @Override
//            public Fragment getItem(int position) {
//                return fragments[position];
//            }
//
//            @Override
//            public int getCount() {
//                return fragments.length;
//            }
//
//            @Nullable
//            @Override
//            public CharSequence getPageTitle(int position) {
//                return titles[position];
//            }
//        });
//        binding.tabLayout.setupWithViewPager(binding.vp);
        binding.vp2.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return fragments[position];
            }

            @Override
            public int getItemCount() {
                return fragments.length;
            }
        });
        binding.tabLayout.bindViewPager2(binding.vp2, titles);
    }
}
