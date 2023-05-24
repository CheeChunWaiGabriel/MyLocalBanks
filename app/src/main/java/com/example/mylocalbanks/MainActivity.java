package com.example.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView Bank1;
    TextView Bank2;
    TextView Bank3;
    String bankClicked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bank1=findViewById(R.id.Bank1);
        Bank2=findViewById(R.id.Bank2);
        Bank3=findViewById(R.id.Bank3);
        registerForContextMenu(Bank1);
        registerForContextMenu(Bank2);
        registerForContextMenu(Bank3);
    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == Bank1) {
            bankClicked = "DBS";
        } else if (v == Bank2) {
            bankClicked = "OCBC";
        }
        else {
            bankClicked="UOB";}
        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
    }
    public boolean onContextItemSelected(MenuItem item) {
        if (bankClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent gotobank=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/index/default.page"));
                startActivity(gotobank);
                return true;
                //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                ;
                Intent intentCall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18001111111"));
                startActivity(intentCall);
                return true;
            }


        }
            else if (bankClicked.equalsIgnoreCase("OCBC")) {
                if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                    //code for action
                    Intent gotobank=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/group/gateway?"));
                    startActivity(gotobank);
                    //menu item successfully handled
                } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                    //code for action
                    ;
                    Intent intentCall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18003633333"));
                    startActivity(intentCall);
                }

        }
            if (bankClicked.equalsIgnoreCase("UOB")) {
                if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                    //code for action
                    Intent gotobank = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uobgroup.com/uobgroup/index.page"));
                    startActivity(gotobank);
                    //menu item successfully handled
                } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                    //code for action
                    ;
                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18002222121"));
                    startActivity(intentCall);
                }
            }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            Bank1.setText("DBS");
            Bank2.setText("OCBC");
            Bank3.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            Bank1.setText("星展银行");
            Bank2.setText("华侨银行");
            Bank2.setText("大华银行");
            return true;
        } else {
            Bank1.setText("Error translation");
            Bank2.setText("Error translation");
            Bank3.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }
}
