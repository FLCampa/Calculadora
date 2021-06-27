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

import br.edu.ifsp.scl.ads.pdm.calculadora.databinding.ActivityAdvancedCalculatorBinding;

public class AdvancedCalculatorActivity extends AppCompatActivity {

    private ActivityAdvancedCalculatorBinding activityAdvancedCalculatorBinding;
    Operations operation = new Operations();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAdvancedCalculatorBinding = ActivityAdvancedCalculatorBinding.inflate(getLayoutInflater());
        setContentView(activityAdvancedCalculatorBinding.getRoot());

        setTitle(R.string.advanced_calculator);
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
                activityAdvancedCalculatorBinding.displayTv.setText("0");
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
            case R.id.powerOfBt:
                displayText("^");
                break;
            case R.id.percentBt:
                String percentOperand = activityAdvancedCalculatorBinding.displayTv.getText().toString();
                activityAdvancedCalculatorBinding.displayTv.setText(operation.percent(percentOperand));
                break;
            case R.id.squareRootBt:
                Double squareRootOperand = Double.parseDouble(activityAdvancedCalculatorBinding.displayTv.getText().toString());
                activityAdvancedCalculatorBinding.displayTv.setText(operation.squareRoot(squareRootOperand));
                break;
            default:
                break;
        }
    }

    private void displayText(String display) {
        String actualDisplayText = activityAdvancedCalculatorBinding.displayTv.getText().toString();
        if (actualDisplayText.length() == 1 && actualDisplayText.contains("0")) {
            activityAdvancedCalculatorBinding.displayTv.setText("");
        }
        if (    !activityAdvancedCalculatorBinding.displayTv.getText().toString().contains(".") &&
                activityAdvancedCalculatorBinding.displayTv.getText().toString().contains("+") ||
                activityAdvancedCalculatorBinding.displayTv.getText().toString().contains("-") ||
                activityAdvancedCalculatorBinding.displayTv.getText().toString().contains("*") ||
                activityAdvancedCalculatorBinding.displayTv.getText().toString().contains("/") ) {
            calculateResult();
        }
        actualDisplayText = activityAdvancedCalculatorBinding.displayTv.getText().toString();
        activityAdvancedCalculatorBinding.displayTv.setText(actualDisplayText.concat(display));
    }

    private void calculateResult() {
        String actualDisplayText = activityAdvancedCalculatorBinding.displayTv.getText().toString();
        String[] operand = actualDisplayText.split("[\\s^*/+-]");

        if(operand.length > 1) {
            String firstOperand = operand[0];
            String secondOperand = operand[1];

            if (actualDisplayText.contains("+")) {
                activityAdvancedCalculatorBinding.displayTv.setText(operation.addition(firstOperand, secondOperand));
            } else if (actualDisplayText.contains("-")) {
                activityAdvancedCalculatorBinding.displayTv.setText(operation.subtraction(firstOperand, secondOperand));
            } else if (actualDisplayText.contains("*")) {
                activityAdvancedCalculatorBinding.displayTv.setText(operation.multiplication(firstOperand, secondOperand));
            } else if (actualDisplayText.contains("/")) {
                activityAdvancedCalculatorBinding.displayTv.setText(operation.division(firstOperand, secondOperand));
            } else if (actualDisplayText.contains("^")) {
                activityAdvancedCalculatorBinding.displayTv.setText(operation.powerOf(firstOperand, secondOperand));
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
                Intent basicCalculatorIntent = new Intent(this, CalculatorActivity.class);
                startActivity(basicCalculatorIntent);
                return true;
            case R.id.advancedCalculatorMi:
                Toast.makeText(this, "Already in the advanced calculator!", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }
}