package ru.mail.park.lecture9;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.mail.park.lecture9.injection.StringUtils;

public class ListFragment extends Fragment {

    @BindView(R.id.list)
    RecyclerView list;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        list.setLayoutManager(new LinearLayoutManager(getContext()));
        list.setAdapter(new Adapter());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.right)
        TextView right;

        @BindView(R.id.left)
        TextView left;

        @Inject
        StringUtils stringUtils;

        ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            App.getComponent().inject(this);
        }

        @SuppressLint("DefaultLocale")
        void bind(final int position) {
            right.setText(String.format("%d^2 = %d", position, position * position));
            left.setText(stringUtils.getAppName());
        }
    }

    private static class Adapter extends RecyclerView.Adapter<ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
            final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            return new ViewHolder(inflater.inflate(R.layout.list_item, parent, false));
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.bind(position);
        }

        @Override
        public int getItemCount() {
            return 100;
        }
    }
}
