package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {
    TextView buildFormulaTV;
    TextView resultsFormulaTV;
    boolean leftBracket = true;
    String Formula = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildFormulaTV = (TextView)findViewById(R.id.workingsTextView);
        resultsFormulaTV = (TextView)findViewById(R.id.resultTextView);
    }

    private void buildFormula(String givenValue){
        Formula = Formula + givenValue;
        buildFormulaTV.setText(Formula);
    }
    public void equals(View view) throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        double result = (double) engine.eval(Formula);
        resultsFormulaTV.setText(String.valueOf(result));
    }
    public void clear(View view) {
        buildFormulaTV.setText("");
        Formula = "";
        resultsFormulaTV.setText("0.0");
        leftBracket = true;
    }
    public void delete(View view){
        if (Formula.length() > 0) {
            Formula = Formula.substring(0, Formula.length() - 1);
            buildFormulaTV.setText(Formula);
        }
    }
    public void brackets(View view){
        if(leftBracket) {
            buildFormula("(");
            leftBracket = false;
        }else{
            buildFormula(")");
            leftBracket = true;
        }
    }
    public void multiply(View view){
        buildFormula("*");
    }
    public void minus(View view){
        buildFormula("-");
    }
    public void plus(View view){
        buildFormula("+");
    }
    public void power(View view){
        buildFormula("^");
    }
    public void division(View view){
        buildFormula("/");
    }
    public void plusminus(View view){
        buildFormula("-");
    }
    public void one(View view){
        buildFormula("1");
    }
    public void two(View view){
        buildFormula("2");
    }
    public void three(View view){
        buildFormula("3");
    }
    public void four(View view){
        buildFormula("4");
    }
    public void five(View view){
        buildFormula("5");
    }
    public void six(View view){
        buildFormula("6");
    }
    public void seven(View view){
        buildFormula("7");
    }
    public void eight(View view){
        buildFormula("8");
    }
    public void nine(View view){
        buildFormula("9");
    }
    public void zero(View view){
        buildFormula("0");
    }
    public void decimal(View view){
        buildFormula(".");
    }
}