package edu.orangecoastcollege.cs273.rmillett.inandout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * Displays cost information based on user's input from <code>OrderActivity</code>
 *
 * @author Ryan Millett
 * @version 1.0
 */
public class SummaryActivity extends AppCompatActivity {

    private static NumberFormat currency = NumberFormat.getCurrencyInstance();

    private TextView mTotalTextView;
    private TextView mItemsTextView;
    private TextView mSubtotalTextView;
    private TextView mTaxTextView;

    /**
     * Creates <code>SummaryActivity</code>
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent intent = getIntent();
        String subtotal = currency.format(intent.getDoubleExtra("subtotal", 0.0));
        String tax = currency.format(intent.getDoubleExtra("tax", 0.0));
        String total = currency.format(intent.getDoubleExtra("total", 0.0));
        String itemsOrdered = currency.format(intent.getIntExtra("items ordered", 0));

        mTotalTextView = (TextView) findViewById(R.id.orderTotalTextView);
        mTotalTextView.setText("Order Total: " + total);
        mItemsTextView = (TextView) findViewById(R.id.itemsOrderedTextView);
        mItemsTextView.setText("Number of items ordered: " + itemsOrdered);
        mSubtotalTextView = (TextView) findViewById(R.id.subtotalTextView);
        mSubtotalTextView.setText("Subtotal: " + subtotal);
        mTaxTextView = (TextView) findViewById(R.id.taxTextView);
        mTaxTextView.setText("Tax :" + tax);
    }

    /**
     * Completes <code>SummaryActivity</code> and returns to <code>OrderActivity</code>
     *
     * @param v View
     */
    protected void startNewOrder(View v) {
        finish();
    }
}
