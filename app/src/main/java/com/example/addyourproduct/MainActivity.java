package com.example.addyourproduct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button _btnInsert, _btnDelete, _btnUpdate;
    EditText _txtID, _txtName,_txtquantity, _txtPrice, _txtDiscription;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _btnInsert = (Button)findViewById(R.id. btnInsert);
        _btnDelete = (Button)findViewById(R .id. btnDelete);
        _btnUpdate = (Button)findViewById(R.id. btnUpdate);
        _txtID = (EditText)findViewById(R.id.txtID);
        _txtName = (EditText)findViewById(R.id.txtName);
        _txtquantity = (EditText)findViewById(R.id.txtquantity);
        _txtPrice = (EditText)findViewById(R.id.txtprice);
        _txtDiscription  = (EditText)findViewById(R.id.txtDiscription);
        openHelper=new DataBaseHelper(this);
        _btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = _txtName.getText().toString();
                String quantity = _txtquantity.getText().toString();
                String price = _txtPrice.getText().toString();
                String Discription = _txtDiscription.getText().toString();

                db=openHelper.getWritableDatabase();
                insertData(name,quantity,price,Discription);
                Toast.makeText(getApplicationContext(), "INSERTED SUCCESSESSFULLY", Toast.LENGTH_LONG).show();



            }
        });

        _btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db=openHelper.getWritableDatabase();
                String id = _txtID.getText() .toString();
                daleteData(id);
                Toast.makeText(getApplicationContext(),"Deleted successfully",Toast.LENGTH_LONG).show();
            }
        });

        _btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

    }
    public void insertData(String name, String quantity, String price, String Discription ) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.COLS_2, name);
        contentValues.put(DataBaseHelper.COLS_3, quantity);
        contentValues.put(DataBaseHelper.COLS_4, price);
        contentValues.put(DataBaseHelper.COLS_5, Discription);

        long id = db.insert(DataBaseHelper.TABLE_NAME, null, contentValues);

    }
    public boolean daleteData(String id){
        return db.delete(DataBaseHelper.TABLE_NAME, DataBaseHelper.COLS_1 + "=?", new String[]{id})>0;
    }
    }
