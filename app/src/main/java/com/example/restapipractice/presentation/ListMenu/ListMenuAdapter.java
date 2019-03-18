package com.example.restapipractice.presentation.ListMenu;

import android.support.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.restapipractice.R;
import com.example.restapipractice.data.model.Account;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ListMenuAdapter extends RecyclerView.Adapter<ListMenuAdapter.ListMenuHolder> {

    private OnItemClickListener mListener;
    private List<Account> mAccounts;
    //constructor
    public ListMenuAdapter(List<Account> accounts){mAccounts = accounts;}



    public interface OnItemClickListener {
        void onItemClick(Account account);
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
        Account currentAcc = mAccounts.get(position);
        holder.holderName.setText(currentAcc.getAccount_name());
        holder.holderBalance.setText(currentAcc.getAccount_balance()+"");
//        holder.mTvPriority.setText(String.valueOf(currentAcc.ge));
    }

    @Override
    public int getItemCount() {
        return mAccounts.size();
    }

    //pengganti constructor
    public void setMenuList(List<Account> accounts) {
        this.mAccounts = accounts;
        notifyDataSetChanged();
    }

    public Account getAccountAt(int position) {
        return mAccounts.get(position);
    }

    // inner class NoteHolder
    class ListMenuHolder extends RecyclerView.ViewHolder {

        private TextView holderName;

        private TextView holderBalance;
        private ImageButton holderDelete;

        public ListMenuHolder(View itemView) {
            super(itemView);

            holderName = itemView.findViewById(R.id.acc_name);
            holderBalance = itemView.findViewById(R.id.acc_balance);
            holderDelete = itemView.findViewById(R.id.btn_delete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (mListener != null && position != RecyclerView.NO_POSITION)
                        mListener.onItemClick(mAccounts.get(position));
                }
            });

        }

    }



}
