package com.example.tugas1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextItem;
    private RadioGroup radioGroupMembership;
    private RadioButton radioButtonMember, radioButtonNonMember;
    private Button buttonProcess;
    private TextView textViewTotal;
    private ImageView imageView1, imageView2, imageView3;

    private int itemPrice = 0;
    private double discount = 0.1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextItem = findViewById(R.id.editTextItem);
        radioGroupMembership = findViewById(R.id.radioGroupMembership);
        radioButtonMember = findViewById(R.id.radioButtonMember);
        radioButtonNonMember = findViewById(R.id.radioButtonNonMember);
        buttonProcess = findViewById(R.id.buttonProcess);
        textViewTotal = findViewById(R.id.textViewTotal);
        imageView1 = findViewById(R.id.BolaBasket);
        imageView2 = findViewById(R.id.BolaVolley);
        imageView3 = findViewById(R.id.BolaFutsal);

        buttonProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTotal();
            }
        });
    }

    private void calculateTotal() {
        String selectedItem = editTextItem.getText().toString();

        if (selectedItem.isEmpty()) {
            Toast.makeText(this, "Please enter an item", Toast.LENGTH_SHORT).show();
            return;
        } else if (selectedItem.equalsIgnoreCase("Bola Basket")) {
            itemPrice = 50000;
            imageView1.setImageResource(R.drawable.bola_basket);
        } else if (selectedItem.equalsIgnoreCase("Bola Voli")){
            itemPrice = 75000;
            imageView2.setImageResource(R.drawable.bola_volley);
        } else if (selectedItem.equalsIgnoreCase("Bola Futsal")) {
            itemPrice = 100000;
            imageView3.setImageResource(R.drawable.bola_futsal);
        } else {
            Toast.makeText(this, "Invalid item", Toast.LENGTH_SHORT).show();
            return;
        }

        double totalPrice = itemPrice;
        if (radioButtonMember.isChecked()) {
            totalPrice = itemPrice - (itemPrice * discount);
        }

        textViewTotal.setText("Item: " + selectedItem + "\nPrice: " + itemPrice +
                "\nTotal Price: " + totalPrice);
    }
}