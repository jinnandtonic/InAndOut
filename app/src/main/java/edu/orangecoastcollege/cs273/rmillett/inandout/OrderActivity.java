package edu.orangecoastcollege.cs273.rmillett.inandout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Activity for user to input order information to be calculated and displayed in
 * <code>SummaryActivity</code>
 *
 * @author Ryan Millett
 * @version 1.0
 */
public class OrderActivity extends AppCompatActivity {

    //private static NumberFormat currency = NumberFormat.getCurrencyInstance();

    private EditText mDoubleDoubleEditText;
    private EditText mCheeseburgerEditText;
    private EditText mFrenchFriesEditText;
    private EditText mShakesEditText;
    private EditText mSmallDrinksEditText;
    private EditText mMediumDrinksEditText;
    private EditText mLargeDrinksEditText;

    private Order mOrder = new Order();

    private SharedPreferences mPrefs;

    private void initializeViews() {
        mDoubleDoubleEditText = (EditText) findViewById(R.id.doubleDoubleEditText);
        mCheeseburgerEditText = (EditText) findViewById(R.id.cheeseburgerEditText);
        mFrenchFriesEditText = (EditText) findViewById(R.id.friesEditText);
        mShakesEditText = (EditText) findViewById(R.id.shakesEditText);
        mSmallDrinksEditText = (EditText) findViewById(R.id.smallDrinksEditText);
        mMediumDrinksEditText = (EditText) findViewById(R.id.mediumDrinksEditText);
        mLargeDrinksEditText = (EditText) findViewById(R.id.largeDrinksEditText);
    }

    // UNUSED
    private void loadSharedPreferences() {
        mPrefs = getSharedPreferences("edu.orangecoastcollege.cs273.rmillett.InAndOut", MODE_PRIVATE);

        if(mPrefs != null) {
            mOrder.setDoubleDouble(mPrefs.getInt("doubleDouble", 0));
            mDoubleDoubleEditText.setText(String.valueOf(mOrder.getDoubleDouble()));
            mOrder.setCheeseburgers(mPrefs.getInt("cheeseburger", 0));
            mCheeseburgerEditText.setText(String.valueOf(mOrder.getCheeseburgers()));
            mOrder.setFrenchFries(mPrefs.getInt("fries", 0));
            mFrenchFriesEditText.setText(String.valueOf(mOrder.getFrenchFries()));
            mOrder.setShakes(mPrefs.getInt("shakes", 0));
            mShakesEditText.setText(String.valueOf(mOrder.getShakes()));
            mOrder.setSmallDrinks(mPrefs.getInt("smallDrinks", 0));
            mSmallDrinksEditText.setText(String.valueOf(mOrder.getSmallDrinks()));
            mOrder.setMediumDrinks(mPrefs.getInt("mediumDrinks", 0));
            mMediumDrinksEditText.setText(String.valueOf(mOrder.getMediumDrinks()));
            mOrder.setLargeDrinks(mPrefs.getInt("largeDrinks", 0));
            mLargeDrinksEditText.setText(String.valueOf(mOrder.getLargeDrinks()));
        }
    }

    // UNUSED
    private void savedSharedPreferences() {
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.clear();

        editor.putInt("doubleDouble", mOrder.getDoubleDouble());
        editor.putInt("cheeseburger", mOrder.getCheeseburgers());
        editor.putInt("fries", mOrder.getFrenchFries());
        editor.putInt("shakes", mOrder.getShakes());
        editor.putInt("smallDrinks", mOrder.getSmallDrinks());
        editor.putInt("mediumDrinks", mOrder.getMediumDrinks());
        editor.putInt("largeDrinks", mOrder.getLargeDrinks());

        editor.commit();
    }

    /**
     * Creates <code>OrderActivity</code>
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        initializeViews();
        //loadSharedPreferences();
    }

    /**
     * Takes user input and sends information to <code>SummaryActivity</code>
     *
     * @param v View
     */
    protected void placeOrder(View v) {
        // Update MODEL
        mOrder.setDoubleDouble(Integer.parseInt(mDoubleDoubleEditText.toString()));
        mOrder.setCheeseburgers(Integer.parseInt(mCheeseburgerEditText.toString()));
        mOrder.setFrenchFries((Integer.parseInt(mFrenchFriesEditText.toString())));
        mOrder.setShakes(Integer.parseInt(mShakesEditText.toString()));
        mOrder.setSmallDrinks(Integer.parseInt(mSmallDrinksEditText.toString()));
        mOrder.setMediumDrinks((Integer.parseInt(mMediumDrinksEditText.toString())));
        mOrder.setLargeDrinks(Integer.parseInt(mLargeDrinksEditText.toString()));

        //savedSharedPreferences();

        Intent summaryIntent = new Intent(this, SummaryActivity.class);
        summaryIntent.putExtra("subtotal", mOrder.calculateSubtotal());
        summaryIntent.putExtra("tax", mOrder.calculateTax());
        summaryIntent.putExtra("total", mOrder.calculateTotal());
        summaryIntent.putExtra("items ordered", mOrder.getNumberItemsOrdered());
        startActivity(summaryIntent);
    }
}
