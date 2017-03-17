/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.hp0331.objview.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hp0331.objview.R;

public class StickyFragment extends Fragment implements ObservableScrollView.Callbacks {
    private TextView mStickyView;
    private View mPlaceholderView;
    private ObservableScrollView mObservableScrollView;
    private ListView listview;
    private List<String> list=new ArrayList<String>();

    public StickyFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.fragment_content, container, false);
        for (int i = 0; i < 100; i++) {
			list.add("这是我们出售的商品从不打折贵的要死"+i);
		}
        listview=(ListView)rootView.findViewById(R.id.listview);

        listview.setAdapter(new MyAdapter(getActivity(), list));
        setListViewHeightBasedOnChildren(listview);
        mObservableScrollView = (ObservableScrollView) rootView.findViewById(R.id.scroll_view);
        mObservableScrollView.setCallbacks(this);

        mStickyView = (TextView) rootView.findViewById(R.id.sticky);
        mStickyView.setText(R.string.sticky_item);
        mPlaceholderView = rootView.findViewById(R.id.placeholder);

        mObservableScrollView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        onScrollChanged(mObservableScrollView.getScrollY());
                    }
                });

        return rootView;
    }
    public static void setListViewHeightBasedOnChildren(ListView listView) { 
        if(listView == null) return;
        MyAdapter listAdapter = (MyAdapter) listView.getAdapter(); 
        if (listAdapter == null) { 
            // pre-condition 
            return; 
        } 
        int totalHeight = 0; 
        for (int i = 0; i < listAdapter.getCount(); i++) { 
            View listItem = listAdapter.getView(i, null, listView); 
            listItem.measure(0, 0); 
            totalHeight += listItem.getMeasuredHeight(); 
        } 
        ViewGroup.LayoutParams params = listView.getLayoutParams(); 
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params); 
    }
    @Override
    public void onScrollChanged(int scrollY) {
        mStickyView.setTranslationY(Math.max(mPlaceholderView.getTop(), scrollY));
    }

    @Override
    public void onDownMotionEvent() {
    }

    @Override
    public void onUpOrCancelMotionEvent() {
    }
}
