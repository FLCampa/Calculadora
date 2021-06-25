package br.edu.ifsp.scl.ads.pdm.calculadora;

import java.text.DecimalFormat;

public class Operations {

    DecimalFormat formatResult = new DecimalFormat("#.#########");

    public String addition(String firstOperand, String secondOperand) {
        double operation = Double.parseDouble(firstOperand) + Double.parseDouble(secondOperand);
        return Double.toString(operation);
    }

    public String subtraction(String firstOperand, String secondOperand) {
        double operation = Double.parseDouble(firstOperand) - Double.parseDouble(secondOperand);
        return Double.toString(operation);
    }

    public String multiplication(String firstOperand, String secondOperand) {
        double operation = Double.parseDouble(firstOperand) * Double.parseDouble(secondOperand);
        return Double.toString(operation);
    }

    public String division(String firstOperand, String secondOperand) {
        double operation = Double.parseDouble(firstOperand) / Double.parseDouble(secondOperand);
        if (secondOperand.equals("0")) {
            return "Error";
        }
        else {
            return Double.toString(operation);
        }
    }

    public String powerOf(String base, String exponent) {
        double operation = Math.pow(Double.parseDouble(base), Double.parseDouble(exponent));
        if (exponent.equals("0")) {
            return "1";
        }
        else {
            return Double.toString(operation);
        }
    }

    public String percent(String operand) {
        double percentResult =  Double.parseDouble(operand) / 100;
        return Double.toString(percentResult);
    }

    public String squareRoot(Double operand) {
        double squareRootResult = Math.sqrt(operand);
        String formatedSquareRootResult = formatResult.format(squareRootResult);
        if (squareRootResult < 0) {
            return "Error";
        }
        else {
            return formatedSquareRootResult;
        }
    }

}
