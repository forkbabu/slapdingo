package com.zhihu.matisse.internal.ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zhihu.matisse.R;
import com.zhihu.matisse.internal.entity.Album;
import com.zhihu.matisse.internal.entity.Item;
import com.zhihu.matisse.internal.entity.SelectionSpec;
import com.zhihu.matisse.internal.model.AlbumMediaCollection;
import com.zhihu.matisse.internal.model.SelectedItemCollection;
import com.zhihu.matisse.internal.ui.adapter.AlbumMediaAdapter;
import com.zhihu.matisse.internal.ui.widget.MediaGridInset;
import com.zhihu.matisse.internal.utils.UIUtils;

public class MediaSelectionFragment extends Fragment implements AlbumMediaCollection.AlbumMediaCallbacks, AlbumMediaAdapter.CheckStateListener, AlbumMediaAdapter.OnMediaClickListener {
    public static final String EXTRA_ALBUM = "extra_album";
    private AlbumMediaAdapter mAdapter;
    private final AlbumMediaCollection mAlbumMediaCollection = new AlbumMediaCollection();
    private AlbumMediaAdapter.CheckStateListener mCheckStateListener;
    private AlbumMediaAdapter.OnMediaClickListener mOnMediaClickListener;
    private RecyclerView mRecyclerView;
    private SelectionProvider mSelectionProvider;

    public interface SelectionProvider {
        SelectedItemCollection provideSelectedItemCollection();
    }

    public static MediaSelectionFragment newInstance(Album album) {
        MediaSelectionFragment mediaSelectionFragment = new MediaSelectionFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_album", album);
        mediaSelectionFragment.setArguments(bundle);
        return mediaSelectionFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SelectionProvider) {
            this.mSelectionProvider = (SelectionProvider) context;
            if (context instanceof AlbumMediaAdapter.CheckStateListener) {
                this.mCheckStateListener = (AlbumMediaAdapter.CheckStateListener) context;
            }
            if (context instanceof AlbumMediaAdapter.OnMediaClickListener) {
                this.mOnMediaClickListener = (AlbumMediaAdapter.OnMediaClickListener) context;
                return;
            }
            return;
        }
        throw new IllegalStateException("Context must implement SelectionProvider.");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_media_selection, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        int i;
        super.onActivityCreated(bundle);
        Album album = (Album) getArguments().getParcelable("extra_album");
        AlbumMediaAdapter albumMediaAdapter = new AlbumMediaAdapter(getContext(), this.mSelectionProvider.provideSelectedItemCollection(), this.mRecyclerView);
        this.mAdapter = albumMediaAdapter;
        albumMediaAdapter.registerCheckStateListener(this);
        this.mAdapter.registerOnMediaClickListener(this);
        this.mRecyclerView.setHasFixedSize(true);
        SelectionSpec instance = SelectionSpec.getInstance();
        if (instance.gridExpectedSize > 0) {
            i = UIUtils.spanCount(getContext(), instance.gridExpectedSize);
        } else {
            i = instance.spanCount;
        }
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), i));
        this.mRecyclerView.addItemDecoration(new MediaGridInset(i, getResources().getDimensionPixelSize(R.dimen.media_grid_spacing), false));
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mAlbumMediaCollection.onCreate(getActivity(), this);
        this.mAlbumMediaCollection.load(album, instance.capture);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mAlbumMediaCollection.onDestroy();
    }

    public void refreshMediaGrid() {
        this.mAdapter.notifyDataSetChanged();
    }

    public void refreshSelection() {
        this.mAdapter.refreshSelection();
    }

    @Override // com.zhihu.matisse.internal.model.AlbumMediaCollection.AlbumMediaCallbacks
    public void onAlbumMediaLoad(Cursor cursor) {
        this.mAdapter.swapCursor(cursor);
    }

    @Override // com.zhihu.matisse.internal.model.AlbumMediaCollection.AlbumMediaCallbacks
    public void onAlbumMediaReset() {
        this.mAdapter.swapCursor(null);
    }

    @Override // com.zhihu.matisse.internal.ui.adapter.AlbumMediaAdapter.CheckStateListener
    public void onUpdate() {
        AlbumMediaAdapter.CheckStateListener checkStateListener = this.mCheckStateListener;
        if (checkStateListener != null) {
            checkStateListener.onUpdate();
        }
    }

    @Override // com.zhihu.matisse.internal.ui.adapter.AlbumMediaAdapter.OnMediaClickListener
    public void onMediaClick(Album album, Item item, int i) {
        AlbumMediaAdapter.OnMediaClickListener onMediaClickListener = this.mOnMediaClickListener;
        if (onMediaClickListener != null) {
            onMediaClickListener.onMediaClick((Album) getArguments().getParcelable("extra_album"), item, i);
        }
    }
}
