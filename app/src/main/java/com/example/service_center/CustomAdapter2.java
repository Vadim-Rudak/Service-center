package com.example.service_center;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter2 extends RecyclerView.Adapter<CustomAdapter2.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList Order_id, Order_name,  Day_number, Warranty, Payment, Performance, Other;

    CustomAdapter2(Activity activity, Context context, ArrayList Order_id, ArrayList Order_name,
                   ArrayList Day_number, ArrayList Warranty, ArrayList Payment, ArrayList Performance, ArrayList Other){
        this.activity = activity;
        this.context = context;
        this.Order_id = Order_id;
        this.Order_name = Order_name;
        this.Day_number = Day_number;
        this.Warranty = Warranty;
        this.Payment = Payment;
        this.Performance = Performance;
        this.Other = Other;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row2, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.Order_id_txt2.setText(String.valueOf(Order_id.get(position)));
        holder.Order_name_txt2.setText(String.valueOf(Order_name.get(position)));
        holder.Day_number_txt2.setText(String.valueOf(Day_number.get(position)));
        holder.Warranty_txt2.setText(String.valueOf(Warranty.get(position)));
        holder.Payment_txt2.setText(String.valueOf(Payment.get(position)));
        holder.Performance_txt2.setText(String.valueOf(Performance.get(position)));
        holder.Other_txt2.setText(String.valueOf(Other.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Up_act2.class);
                intent.putExtra("id", String.valueOf(Order_id.get(position)));
                intent.putExtra("Order_name", String.valueOf(Order_name.get(position)));
                intent.putExtra("Day_number", String.valueOf(Day_number.get(position)));
                intent.putExtra("Warranty", String.valueOf(Warranty.get(position)));
                intent.putExtra("Payment", String.valueOf(Payment.get(position)));
                intent.putExtra("Performance", String.valueOf(Performance.get(position)));
                intent.putExtra("Other", String.valueOf(Other.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });

        holder.mainLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(context, Info_user2.class);
                intent.putExtra("id", String.valueOf(Order_id.get(position)));
                intent.putExtra("Order_name", String.valueOf(Order_name.get(position)));
                intent.putExtra("Other", String.valueOf(Other.get(position)));
                activity.startActivityForResult(intent, 1);
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return Order_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView Order_id_txt2, Order_name_txt2, Day_number_txt2, Warranty_txt2, Payment_txt2, Performance_txt2, Other_txt2;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Order_id_txt2 = itemView.findViewById(R.id.Order_id_txt2);
            Order_name_txt2 = itemView.findViewById(R.id.Order_name_txt2);
            Day_number_txt2 = itemView.findViewById(R.id.Day_number_txt2);
            Warranty_txt2 = itemView.findViewById(R.id.Warranty_txt2);
            Payment_txt2 = itemView.findViewById(R.id.Payment_txt2);
            Performance_txt2 = itemView.findViewById(R.id.Performance_txt2);
            Other_txt2 = itemView.findViewById(R.id.Other_txt2);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}
