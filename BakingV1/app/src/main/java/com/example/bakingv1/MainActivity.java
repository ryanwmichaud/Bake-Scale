package com.example.bakingv1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    String inputUnit = "teaspoons";
    String outputUnit = "teaspoons";
    public void setInputUnit(String newUnit){
        this.inputUnit = newUnit;
    }
    public String getInputUnit() {
        return this.inputUnit;
    }
    public String getOutputUnit() {
        return this.outputUnit;
    }
    public void setOutputUnit(String newUnit){
        this.outputUnit = newUnit;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText editTextIn = (EditText) findViewById(R.id.edittext_inputAmount);
        TextView textViewOut = (TextView) findViewById(R.id.textView_newAmount);

        editTextIn.setText("0");
        textViewOut.setText("new amount: 0");

        Spinner spinner_input = (Spinner) findViewById(R.id.spinner_amount);
        //give it context, array, layout so it can turn the array into views
        ArrayAdapter<CharSequence> adapter_amount = ArrayAdapter.createFromResource(
                this,
                R.array.units_array,
                android.R.layout.simple_spinner_item
        );
        // layout for itemsand use it
        adapter_amount.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_input.setAdapter(adapter_amount);
        spinner_input.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int b =0;
                //changed the input unit
                double inputAmount =  Double.parseDouble(editTextIn.getText().toString());
                String newInputUnit = adapterView.getItemAtPosition(i).toString();
                String oldInputUnit = getInputUnit();
                convertInputUnits(oldInputUnit, newInputUnit, inputAmount, editTextIn);

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //nothing
            }
        });
        spinner_input.setSelection(0,true);

        //same for result dropdown
        Spinner spinner_output = (Spinner) findViewById(R.id.spinner_result);
        ArrayAdapter<CharSequence> adapter_result = ArrayAdapter.createFromResource(
                this,
                R.array.units_array,
                android.R.layout.simple_spinner_item
        );
        adapter_result.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_output.setAdapter(adapter_result);
        spinner_output.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //changed the input unit
                int a = 0;
                double outputAmount =  Double.parseDouble(textViewOut.getText().toString().substring(12));
                //String outputAmount = textViewOut.getText().toString();
                String newOutputUnit = adapterView.getItemAtPosition(i).toString();
                String oldOutputUnit = getOutputUnit();
                convertOutputUnits(oldOutputUnit, newOutputUnit, outputAmount, textViewOut);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //nothing
            }
        });
        spinner_output.setSelection(0,true);

    }

    public void convertInputUnits(String oldUnit, String newUnit, double oldNumber, EditText editTextIn){

        switch(inputUnit) {
            case "teaspoons":
                switch(newUnit) {
                    case "teaspoons":
                        break;
                    case "tablespoons":
                        editTextIn.setText(String.valueOf(oldNumber*0.33 ));
                        break;
                    case "cups":
                        editTextIn.setText(String.valueOf(oldNumber*0.021 ));
                        break;
                    case "liters":
                        editTextIn.setText(String.valueOf(oldNumber*0.005 ));
                        break;
                    default:
                        editTextIn.setText("error" );
                }
                break;
            case "tablespoons":
                switch(newUnit) {
                    case "teaspoons":
                        editTextIn.setText(String.valueOf(oldNumber*3 ));
                        break;
                    case "tablespoons":
                        break;
                    case "cups":
                        editTextIn.setText(String.valueOf(oldNumber*0.062 ));
                        break;
                    case "liters":
                        editTextIn.setText(String.valueOf(oldNumber*0.015 ));
                        break;
                    default:
                        editTextIn.setText("error" );
                }
                break;
            case "cups":
                switch(newUnit) {
                    case "teaspoons":
                        editTextIn.setText(String.valueOf(oldNumber*48.692 ));
                        break;
                    case "tablespoons":
                        editTextIn.setText(String.valueOf(oldNumber*16.231) );
                        break;
                    case "cups":
                        break;
                    case "liters":
                        editTextIn.setText(String.valueOf(oldNumber*0.24 ));
                        break;
                    default:
                        editTextIn.setText("error" );
                }
                break;
            case "liters":
                switch(newUnit) {
                    case "teaspoons":
                        editTextIn.setText(String.valueOf(oldNumber*202.884 ));
                        break;
                    case "tablespoons":
                        editTextIn.setText(String.valueOf(oldNumber*67.628 ));
                        break;
                    case "cups":
                        editTextIn.setText(String.valueOf(oldNumber*4.167 ));
                        break;
                    case "liters":
                        break;
                    default:
                        editTextIn.setText("error" );
                }
                break;
            default:
                editTextIn.setText("error" );

        }
        setInputUnit(newUnit);
    }
    public void convertOutputUnits(String oldUnit, String newUnit, double oldNumber, TextView textViewOut){
        switch(inputUnit) {
            case "teaspoons":
                switch(newUnit) {
                    case "teaspoons":
                        break;
                    case "tablespoons":
                        textViewOut.setText("New amount: " + oldNumber*0.333 );
                        break;
                    case "cups":
                        textViewOut.setText("New amount: " + oldNumber*0.021 );
                        break;
                    case "liters":
                        textViewOut.setText("New amount: " + oldNumber*0.005 );
                        break;
                    default:
                        textViewOut.setText("error" );
                }
                break;
            case "tablespoons":
                switch(newUnit) {
                    case "teaspoons":
                        textViewOut.setText("New amount: " + oldNumber*3 );
                        break;
                    case "tablespoons":
                        break;
                    case "cups":
                        textViewOut.setText("New amount: " + oldNumber*0.062 );
                        break;
                    case "liters":
                        textViewOut.setText("New amount: " + oldNumber*0.015 );
                        break;
                    default:
                        textViewOut.setText("error" );
                }
                break;
            case "cups":
                switch(newUnit) {
                    case "teaspoons":
                        textViewOut.setText("New amount: " + oldNumber*48.692 );
                        break;
                    case "tablespoons":
                        textViewOut.setText("New amount: " + oldNumber*16.231 );
                        break;
                    case "cups":
                        break;
                    case "liters":
                        textViewOut.setText("New amount: " + oldNumber*0.24 );
                        break;
                    default:
                        textViewOut.setText("error" );
                }
                break;
            case "liters":
                switch(newUnit) {
                    case "teaspoons":
                        textViewOut.setText("New amount: " + oldNumber*202.884 );
                        break;
                    case "tablespoons":
                        textViewOut.setText("New amount: " + oldNumber*67.628 );
                        break;
                    case "cups":
                        textViewOut.setText("New amount: " + oldNumber*4.167 );
                        break;
                    case "liters":
                        break;
                    default:
                        textViewOut.setText("error" );
                }
                break;
            default:
                textViewOut.setText("error" );

        }
        setOutputUnit(newUnit);
    }




}