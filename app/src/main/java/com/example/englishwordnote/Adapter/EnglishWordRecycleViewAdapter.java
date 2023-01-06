package com.example.englishwordnote.Adapter;

import static com.example.englishwordnote.MainActivity.db;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.englishwordnote.Activities.WordDetailActivity;
import com.example.englishwordnote.Models.EnglishWord;
import com.example.englishwordnote.R;
import com.example.englishwordnote.RecyclerViewInterface;
import com.google.gson.Gson;

import java.util.ArrayList;

public class EnglishWordRecycleViewAdapter
        extends RecyclerView.Adapter<EnglishWordRecycleViewAdapter.EnglishWordViewHolder>{

    private Context context;
    private ArrayList<EnglishWord> words;

    public EnglishWordRecycleViewAdapter(Context context, ArrayList<EnglishWord> words) {
        this.context = context;
        this.words = words;
    }

    @NonNull
    @Override
    public EnglishWordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.word_item, parent,false);
        EnglishWordViewHolder holder = new EnglishWordViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull EnglishWordViewHolder holder, int position) {

        holder.txtTitle.setText(words.get(holder.getAdapterPosition()).getWord().toString());
        holder.txtMeaning.setText(words.get(holder.getAdapterPosition()).getMeanings().toString());
        holder.btnViewWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gson gson = new Gson();
                String serializeWord = gson.toJson(words.get(holder.getAdapterPosition()));
//                Toast.makeText(context, serializeWord, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, WordDetailActivity.class);
                intent.putExtra("detail", serializeWord);
                context.startActivity(intent);
            }
        });
        holder.cardParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Are you sure you want to delete "+words.get(holder.getAdapterPosition()).getWord() + "?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try{
                            EnglishWord find_word = words.get(holder.getAdapterPosition());
                            if(find_word != null){
                                db.deleteItem(find_word);
                                notifyDataSetChanged();
                                Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();

                            }else{
                                Toast.makeText(context, "Unable to delete item", Toast.LENGTH_SHORT).show();
                            }
                        }catch(Exception ex){
                            Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    public class EnglishWordViewHolder extends RecyclerView.ViewHolder{
        private CardView cardParent;
        private TextView txtTitle, txtMeaning;
        private Button btnViewWord;
        public EnglishWordViewHolder(@NonNull View itemView) {
            super(itemView);
            cardParent = itemView.findViewById(R.id.cardParent);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtMeaning = itemView.findViewById(R.id.txtMeaning);
            btnViewWord = itemView.findViewById(R.id.btnViewWord);

        }
    }
}
