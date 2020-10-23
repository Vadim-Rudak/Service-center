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

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList Order_id, Order_name, Customer, Month_number, Day_number, Warranty, Payment, Performance;

    CustomAdapter(Activity activity, Context context, ArrayList Order_id, ArrayList Order_name, ArrayList Customer,
                  ArrayList Month_number, ArrayList Day_number, ArrayList Warranty, ArrayList Payment, ArrayList Performance){
        this.activity = activity;
        this.context = context;
        this.Order_id = Order_id;
        this.Order_name = Order_name;
        this.Customer = Customer;
        this.Month_number = Month_number;
        this.Day_number = Day_number;
        this.Warranty = Warranty;
        this.Payment = Payment;
        this.Performance = Performance;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.Order_id_txt.setText(String.valueOf(Order_id.get(position)));
        holder.Order_name_txt.setText(String.valueOf(Order_name.get(position)));
        holder.Customer_txt.setText(String.valueOf(Customer.get(position)));
        holder.Month_number_txt.setText(String.valueOf(Month_number.get(position)));
        holder.Day_number_txt.setText(String.valueOf(Day_number.get(position)));
        holder.Warranty_txt.setText(String.valueOf(Warranty.get(position)));
        holder.Payment_txt.setText(String.valueOf(Payment.get(position)));
        holder.Performance_txt.setText(String.valueOf(Performance.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(Order_id.get(position)));
                intent.putExtra("Order_name", String.valueOf(Order_name.get(position)));
                intent.putExtra("Customer", String.valueOf(Customer.get(position)));
                intent.putExtra("Month_number", String.valueOf(Month_number.get(position)));
                intent.putExtra("Day_number", String.valueOf(Day_number.get(position)));
                intent.putExtra("Warranty", String.valueOf(Warranty.get(position)));
                intent.putExtra("Payment", String.valueOf(Payment.get(position)));
                intent.putExtra("Performance", String.valueOf(Performance.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return Order_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView Order_id_txt, Order_name_txt, Customer_txt, Month_number_txt, Day_number_txt, Warranty_txt, Payment_txt, Performance_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Order_id_txt = itemView.findViewById(R.id.Order_id_txt);
            Order_name_txt = itemView.findViewById(R.id.Order_name_txt);
            Customer_txt = itemView.findViewById(R.id.Customer_txt);
            Month_number_txt = itemView.findViewById(R.id.Month_number_txt);
            Day_number_txt = itemView.findViewById(R.id.Day_number_txt);
            Warranty_txt = itemView.findViewById(R.id.Warranty_txt);
            Payment_txt = itemView.findViewById(R.id.Payment_txt);
            Performance_txt = itemView.findViewById(R.id.Performance_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}
