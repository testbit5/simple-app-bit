package com.example.restapipractice.presentation.ListMenu;

import android.support.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.restapipractice.R;
import com.example.restapipractice.data.model.Account;
import com.example.restapipractice.presentation.viewmodel.ListMenuVM;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ListMenuAdapter extends RecyclerView.Adapter<ListMenuAdapter.ListMenuHolder> {

    private OnItemClickListener mListener;
    private List<Account> mAccounts;
    private List<ListMenuVM> mListMenuVMList;

    //constructor
//    public ListMenuAdapter(List<Account> accounts){mAccounts = accounts;}

    public ListMenuAdapter(List<ListMenuVM> listMenu){mListMenuVMList = listMenu;}



    public interface OnItemClickListener {
        void onItemClick(ListMenuVM account);
    }



    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public ListMenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_note, parent, false);
        return new ListMenuHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ListMenuHolder holder, int position) {
        ListMenuVM currentAcc = mListMenuVMList.get(position);
        holder.holderName.setText(currentAcc.getAccName());
        holder.holderBalance.setText(currentAcc.getAccBalance());

        holder.holderDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("OnBindVIewHolder","Test");
                mListener.onItemClick(currentAcc);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mListMenuVMList.size();
    }

    //pengganti constructor
    public void setMenuList(List<ListMenuVM> listMenuVMList) {
        this.mListMenuVMList = listMenuVMList;
        notifyDataSetChanged();
    }

    public ListMenuVM getAccountAt(int position) {
        return mListMenuVMList.get(position);
    }

    // inner class NoteHolder
    class ListMenuHolder extends RecyclerView.ViewHolder {

        private TextView holderName;

        private TextView holderBalance;
        private ImageView holderDelete;


        public ListMenuHolder(View itemView) {
            super(itemView);

            holderName = itemView.findViewById(R.id.acc_name);
            holderBalance = itemView.findViewById(R.id.acc_balance);
            holderDelete = itemView.findViewById(R.id.btn_delete);


//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int position = getAdapterPosition();
//                    if (mListener != null && position != RecyclerView.NO_POSITION)
//                    {
//                        mListener.onItemClick(mListMenuVMList.get(position));
//
//                    }
//                }
//            });


        }

    }



}
