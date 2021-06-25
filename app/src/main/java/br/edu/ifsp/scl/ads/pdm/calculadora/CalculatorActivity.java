package br.edu.ifsp.scl.ads.pdm.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

import br.edu.ifsp.scl.ads.pdm.calculadora.databinding.ActivityCalculatorBinding;

public class CalculatorActivity extends AppCompatActivity {

    private ActivityCalculatorBinding activityCalculatorBinding;
    Operations operation = new Operations();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCalculatorBinding = ActivityCalculatorBinding.inflate(getLayoutInflater());
        setContentView(activityCalculatorBinding.getRoot());

        setTitle(R.string.basic_calculator);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zeroBt:
                displayText("0");
                break;
            case R.id.oneBt:
                displayText("1");
                break;
            case R.id.twoBt:
                displayText("2");
                break;
            case R.id.threeBt:
                displayText("3");
                break;
            case R.id.fourBt:
                displayText("4");
                break;
            case R.id.fiveBt:
                displayText("5");
                break;
            case R.id.sixBt:
                displayText("6");
                break;
            case R.id.sevenBt:
                displayText("7");
                break;
            case R.id.eightBt:
                displayText("8");
                break;
            case R.id.nineBt:
                displayText("9");
                break;
            case R.id.clearBt:
                activityCalculatorBinding.displayTv.setText("0");
                break;
            case R.id.plusBt:
                displayText("+");
                break;
            case R.id.minusBt:
                displayText("-");
                break;
            case R.id.timesBt:
                displayText("*");
                break;
            case R.id.dividedBt:
                displayText("/");
                break;
            case R.id.equalsBt:
                calculateResult();
                break;
            case R.id.dotBt:
                displayText(".");
                break;
            default:
                break;
        }
    }

    private void displayText(String display) {
        String actualDisplayText = activityCalculatorBinding.displayTv.getText().toString();
        if (actualDisplayText.length() == 1 && actualDisplayText.contains("0")) {
            activityCalculatorBinding.displayTv.setText("");
            actualDisplayText = "";
        }
        if (    activityCalculatorBinding.displayTv.getText().toString().contains("+") ||
                activityCalculatorBinding.displayTv.getText().toString().contains("-") ||
                activityCalculatorBinding.displayTv.getText().toString().contains("*") ||
                activityCalculatorBinding.displayTv.getText().toString().contains("/")) {
            calculateResult();
        }
        actualDisplayText = activityCalculatorBinding.displayTv.getText().toString();
        activityCalculatorBinding.displayTv.setText(actualDisplayText.concat(display));
    }

    private void calculateResult() {
        String actualDisplayText = activityCalculatorBinding.displayTv.getText().toString();
        String[] operand = actualDisplayText.split("[\\s^*/+-]");

        if(operand.length > 1) {
            String firstOperand = operand[0];
            String secondOperand = operand[1];

            if (actualDisplayText.contains("+")) {
                activityCalculatorBinding.displayTv.setText(operation.addition(firstOperand, secondOperand));
            } else if (actualDisplayText.contains("-")) {
                activityCalculatorBinding.displayTv.setText(operation.subtraction(firstOperand, secondOperand));
            } else if (actualDisplayText.contains("*")) {
                activityCalculatorBinding.displayTv.setText(operation.multiplication(firstOperand, secondOperand));
            } else if (actualDisplayText.contains("/")) {
                activityCalculatorBinding.displayTv.setText(operation.division(firstOperand, secondOperand));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.basicCalculatorMi:
                Toast.makeText(this, "Already in the basic calculator!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.advancedCalculatorMi:
                Intent advancedCalculatorIntent = new Intent(this, AdvancedCalculatorActivity.class);
                startActivity(advancedCalculatorIntent);
                return true;
            default:
                return false;
        }
    }
}