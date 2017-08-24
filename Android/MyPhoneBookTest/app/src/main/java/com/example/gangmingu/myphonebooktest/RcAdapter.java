package com.example.gangmingu.myphonebooktest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by gangmingu on 2017. 4. 21..
 */

public class RcAdapter extends RecyclerView.Adapter<RcAdapter.VHolder> {

    private List<PhoneVO> phoneDTO;

    public RcAdapter (Context context, List<PhoneVO> phoneDTO){
        this.phoneDTO = phoneDTO;
    }

    @Override
    public VHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(VHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class VHolder extends RecyclerView.ViewHolder {
        TextView name, number;

        public VHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.view_list);
            number = (TextView) itemView.findViewById(R.id.view_list);
        }
    }
}
