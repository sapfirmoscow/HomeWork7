package ru.sberbank.homework7.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.sberbank.homework7.MyColorLoader;
import ru.sberbank.homework7.R;

public class FirstFragment extends Fragment implements LoaderManager.LoaderCallbacks<Integer> {


    private static final int LOADER_ID = 1;
    private View mView;
    private Loader<Integer> mLoader;

    public static FirstFragment newInstance() {

        Bundle args = new Bundle();

        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mView = view.findViewById(R.id.first_fragment);
        mLoader = getActivity().getSupportLoaderManager().initLoader(LOADER_ID, null, this);//deprecated ??
        mLoader.forceLoad();

    }

    @NonNull
    @Override
    public Loader<Integer> onCreateLoader(int i, @Nullable Bundle bundle) {
        switch (i) {
            case LOADER_ID:
                return new MyColorLoader(getContext());
            default:
                return new Loader<>(getContext());
        }
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Integer> loader, Integer integer) {
        mView.setBackgroundColor(integer);
        mLoader.forceLoad();
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Integer> loader) {

    }
}
