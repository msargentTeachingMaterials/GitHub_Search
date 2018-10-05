package com.example.android.datafrominternet;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.datafrominternet.model.Repository;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoHolder>{
    Context mContext;
    ArrayList<Repository> mRepos;

    public RepoAdapter(Context context, ArrayList<Repository> repos){
        this.mContext = context;
        this.mRepos = repos;
    }

    @Override
    public RepoAdapter.RepoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(R.layout.item, parent, shouldAttachToParentImmediately);
        RepoHolder viewHolder = new RepoHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RepoAdapter.RepoHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mRepos.size();
    }

    public class RepoHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView url;

        public RepoHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            url = (TextView) itemView.findViewById(R.id.url);
        }

        void bind(int listIndex) {
            name.setText(mRepos.get(listIndex).getName());
            url.setText(mRepos.get(listIndex).getUrl());

        }
    }
}
