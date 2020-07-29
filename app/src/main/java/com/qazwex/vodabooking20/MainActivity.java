package com.qazwex.vodabooking20;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DateFormat;
import java.util.Objects;
import android.view.MenuItem;
import android.widget.PopupMenu;

import com.android.volley.RequestQueue;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    final private DatabaseReference mRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://vodabooking20.firebaseio.com/");//global to handel it  in function and put
    private RequestQueue mQueue;Button btndays_popup,btnRooms_popup; TextView txtviewID,txtDAY,txtuser;
    int[] intArray_meas1 = new int[6];//6 number of fields in things speak
    int[] intArray_meas2 = new int[6];//6 number of fields
    int[] intArray_meas3 = new int[6];//6 number of fields
    int[] intArray_meas4 = new int[6];//6 number of fields
    int[] intArray_meas5 = new int[6];//6 number of fields

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btndays_popup = (Button)findViewById(R.id.idDays);
        txtDAY= (TextView) findViewById(R.id.txid_daymob);
        btnRooms_popup = (Button)findViewById(R.id.idRooms);//for meeting room button
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());//instead of FULL date i put DAY field
        txtDAY.setText(currentDate);
        mQueue = Volley.newRequestQueue(this);

      //  mRef.child("BookedTime 9-10").child("Slot A1").child("Car Number").setValue(123);
       // mRef.child("BookedTime 9-10").child("Slot A1").child("Booked").setValue(true);
        jsonParse();

        btndays_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenuDays = new PopupMenu(MainActivity.this ,btndays_popup);
                popupMenuDays.getMenuInflater().inflate(R.menu.days_menu,popupMenuDays.getMenu());
                //popupMenuDays.getMenu().removeItem(R.id.idSat);
                popupMenuDays.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.idsat9_10:
                            {

                                oActivitySat9_10();
                                return true;
                            }
                            case R.id.idsat10_11:
                            {
                                oActivitySat10_11();return true;
                            }
                            case R.id.idsat11_12:
                            {
                                oActivitySat11_12(); return true;
                            }
                            //sun
                            case R.id.idsun9_10:
                            {
                                oActivitySun9_10();return true;
                            }

                            case R.id.idsun10_11:
                            {
                                oActivitySun10_11();return true;
                            }
                            case R.id.idsun11_12:
                            {
                                oActivitySun11_12(); return true;
                            }
                            //mon
                            case R.id.idmon9_10:
                            {
                                oActivityMon9_10();return true;
                            }

                            case R.id.idmon10_11:
                            {
                                oActivityMon10_11();return true;
                            }
                            case R.id.idmon11_12:
                            {
                                oActivityMon11_12(); return true;
                            }
                            //tue
                            case R.id.idtues9_10:
                            {
                                oActivityTue9_10();return true;
                            }

                            case R.id.idtues10_11:
                            {
                                oActivityTue10_11();return true;
                            }
                            case R.id.idtues11_12:
                            {
                                oActivityTue11_12(); return true;
                            }
                            //wed
                            case R.id.idwed9_10:
                            {
                                oActivityWed9_10();return true;
                            }

                            case R.id.idwed10_11:
                            {
                                oActivityWed10_11();return true;
                            }
                            case R.id.idwed11_12:
                            {
                                oActivityWed11_12(); return true;
                            }

                            //thursday
                            case R.id.idthurs9_10:
                            {
                                oActivityThu9_10();return true;
                            }

                            case R.id.idthurs10_11:
                            {
                                oActivityThu10_11();return true;
                            }
                            case R.id.idthurs11_12:
                            {
                                oActivityThu11_12(); return true;
                            }
                            case R.id.idsat9_10room:
                            {
                                oRoomSat9_10();
                                return true;
                            }


                            default:{
                                return false;}

                        }
                    }
                });
                popupMenuDays.show();
            }
        });

        btnRooms_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenuRooms = new PopupMenu(MainActivity.this ,btnRooms_popup);
                popupMenuRooms.getMenuInflater().inflate(R.menu.rooms_menu,popupMenuRooms.getMenu());
                popupMenuRooms.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.idsat9_10room:
                            {
                                oRoomSat9_10();
                                return true;
                            }
                            default:{
                                return false;}
                        }
                    }
                });
                popupMenuRooms.show();
            }
        });





    }
    public void oActivitySat9_10() {
        Intent intent = new Intent(this, oActivitySat9_10.class);
        Toast.makeText(MainActivity.this,"sss",Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }//sat9-10  intent

    public void oActivitySat10_11() {
        Intent intent = new Intent(this, oActivitySat10_11.class);
        startActivity(intent);
    }


    public void oActivitySat11_12() {
        Intent intent = new Intent(this, oActivitySat11_12.class);
        startActivity(intent);
    }
    //sun
    public void oActivitySun9_10() {
        Intent intent = new Intent(this, oActivitySun9_10.class);
        startActivity(intent);
    }

    public void oActivitySun10_11() {
        Intent intent = new Intent(this, oActivitySun10_11.class);
        startActivity(intent);
    }


    public void oActivitySun11_12() {
        Intent intent = new Intent(this, oActivitySun11_12.class);
        startActivity(intent);
    }

    //mon
    public void oActivityMon9_10() {
        Intent intent = new Intent(this, oActivityMon9_10.class);
        startActivity(intent);
    }

    public void oActivityMon10_11() {
        Intent intent = new Intent(this, oActivityMon10_11.class);
        startActivity(intent);
    }


    public void oActivityMon11_12() {
        Intent intent = new Intent(this, oActivityMon11_12.class);
        startActivity(intent);
    }

    //tue
    public void oActivityTue9_10() {
        Intent intent = new Intent(this, oActivityTue9_10.class);
        startActivity(intent);
    }

    public void oActivityTue10_11() {
        Intent intent = new Intent(this, oActivityTue10_11.class);
        startActivity(intent);
    }


    public void oActivityTue11_12() {
        Intent intent = new Intent(this, oActivityTue11_12.class);
        startActivity(intent);
    }
    //wed
    public void oActivityWed9_10() {
        Intent intent = new Intent(this, oActivityWed9_10.class);
        startActivity(intent);
    }

    public void oActivityWed10_11() {
        Intent intent = new Intent(this, oActivityWed10_11.class);
        startActivity(intent);
    }


    public void oActivityWed11_12() {
        Intent intent = new Intent(this, oActivityWed11_12.class);
        startActivity(intent);
    }
    ///thur
    public void oActivityThu9_10() {
        Intent intent = new Intent(this, oActivityThu9_10.class);
        startActivity(intent);
    }

    public void oActivityThu10_11() {
        Intent intent = new Intent(this, oActivityThu10_11.class);
        startActivity(intent);
    }


    public void oActivityThu11_12() {
        Intent intent = new Intent(this, oActivityThu11_12.class);
        startActivity(intent);
    }
    public void oRoomSat9_10() {
        Intent intent = new Intent(this, oRoomSat9_10.class);
        startActivity(intent);
        Toast.makeText(MainActivity.this,"room",Toast.LENGTH_SHORT).show();
    }


    /*private void sensordataWithDAy(String day_today,String slotA1field1,String slotA2field2,String slotB1field3,String slotB2field4,String slotC1field5,String slotC2field6)
    {
        if (slotA1field1.equals("1")){//means there is  a car so we will GRAY the button the the Whole day in the slot A1
            mRef.child(day_today).child("BookedTime 9-10").child("Slot A1").child("Booked").setValue(true);
            mRef.child(day_today).child("BookedTime 10-11").child("Slot A1").child("Booked").setValue(true);
            mRef.child(day_today).child("BookedTime 11-12").child("Slot A1").child("Booked").setValue(true);
            //Toast.makeText(MainActivity.this,"sss",Toast.LENGTH_SHORT).show();
        }
        if (slotA2field2.equals("1")){//means there is  a car so we will GRAY the button the the Whole day in the slot A1
            mRef.child(day_today).child("BookedTime 9-10").child("Slot A2").child("Booked").setValue(true);
            mRef.child(day_today).child("BookedTime 10-11").child("Slot A2").child("Booked").setValue(true);
            mRef.child(day_today).child("BookedTime 11-12").child("Slot A2").child("Booked").setValue(true);
            // Toast.makeText(MainActivity.this,"sss",Toast.LENGTH_SHORT).show();
        }
        if (slotB1field3.equals("1")){//means there is  a car so we will GRAY the button the the Whole day in the slot A1
            mRef.child(day_today).child("BookedTime 9-10").child("Slot B1").child("Booked").setValue(true);
            mRef.child(day_today).child("BookedTime 10-11").child("Slot B1").child("Booked").setValue(true);
            mRef.child(day_today).child("BookedTime 11-12").child("Slot B1").child("Booked").setValue(true);
            // Toast.makeText(MainActivity.this,"sss",Toast.LENGTH_SHORT).show();
        }
        if (slotB2field4.equals("1")){//means there is  a car so we will GRAY the button the the Whole day in the slot A1
            mRef.child(day_today).child("BookedTime 9-10").child("Slot B2").child("Booked").setValue(true);
            mRef.child(day_today).child("BookedTime 10-11").child("Slot B2").child("Booked").setValue(true);
            mRef.child(day_today).child("BookedTime 11-12").child("Slot B2").child("Booked").setValue(true);
        }
        if (slotC1field5.equals("1")){//means there is  a car so we will GRAY the button the the Whole day in the slot A1
            mRef.child(day_today).child("BookedTime 9-10").child("Slot C1").child("Booked").setValue(true);
            mRef.child(day_today).child("BookedTime 10-11").child("Slot C1").child("Booked").setValue(true);
            mRef.child(day_today).child("BookedTime 11-12").child("Slot C1").child("Booked").setValue(true);

        }
        if (slotC2field6.equals("1")){//means there is  a car so we will GRAY the button the the Whole day in the slot A1
            mRef.child(day_today).child("BookedTime 9-10").child("Slot C2").child("Booked").setValue(true);
            mRef.child(day_today).child("BookedTime 10-11").child("Slot C2").child("Booked").setValue(true);
            mRef.child(day_today).child("BookedTime 11-12").child("Slot C2").child("Booked").setValue(true);
        }


    }*/


       private void jsonParse(){
        String url="https://api.thingspeak.com/channels/1013793/feeds.json?results=5";
        JsonObjectRequest request= new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Toast.makeText(MainActivity.this, "response yayayay", Toast.LENGTH_SHORT).show();
                            JSONArray jsonArray = response.getJSONArray("feeds");

                            String fieldsinMeas1[] = {jsonArray.getJSONObject(0).getString("field1"), jsonArray.getJSONObject(0).getString("field2"),jsonArray.getJSONObject(0).getString("field3"),jsonArray.getJSONObject(0).getString("field4"),jsonArray.getJSONObject(0).getString("field5"),jsonArray.getJSONObject(0).getString("field6")};
                            String fieldsinMeas2[] = {jsonArray.getJSONObject(1).getString("field1"), jsonArray.getJSONObject(1).getString("field2"),jsonArray.getJSONObject(1).getString("field3"),jsonArray.getJSONObject(1).getString("field4"),jsonArray.getJSONObject(1).getString("field5"),jsonArray.getJSONObject(1).getString("field6")};
                            String fieldsinMeas3[] = {jsonArray.getJSONObject(2).getString("field1"), jsonArray.getJSONObject(2).getString("field2"),jsonArray.getJSONObject(2).getString("field3"),jsonArray.getJSONObject(2).getString("field4"),jsonArray.getJSONObject(2).getString("field5"),jsonArray.getJSONObject(2).getString("field6")};
                            String fieldsinMeas4[] = {jsonArray.getJSONObject(3).getString("field1"), jsonArray.getJSONObject(3).getString("field2"),jsonArray.getJSONObject(3).getString("field3"),jsonArray.getJSONObject(3).getString("field4"),jsonArray.getJSONObject(3).getString("field5"),jsonArray.getJSONObject(3).getString("field6")};
                            String fieldsinMeas5[] = {jsonArray.getJSONObject(4).getString("field1"), jsonArray.getJSONObject(4).getString("field2"),jsonArray.getJSONObject(4).getString("field3"),jsonArray.getJSONObject(4).getString("field4"),jsonArray.getJSONObject(4).getString("field5"),jsonArray.getJSONObject(4).getString("field6")};
                            Toast.makeText(MainActivity.this, "fieldsinMeas5 field 2 = " +fieldsinMeas5[1], Toast.LENGTH_SHORT).show();


                            Calendar calendar = Calendar.getInstance();
                            int day = calendar.get(Calendar.DAY_OF_WEEK);
                            switch (day) {
                                case Calendar.SATURDAY:{
                                    // Current day is Sunday
                                    //we take data from sensor today which is saturday
                                    //we close the whole day until the sensor gets zero

                                    mRef.child("Saturday").child("BookedTime 9-10").child("Slot A1").child("SensorValue").setValue(fieldsinMeas5[0]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Saturday").child("BookedTime 10-11").child("Slot A1").child("SensorValue").setValue(fieldsinMeas5[0]);
                                    mRef.child("Saturday").child("BookedTime 11-12").child("Slot A1").child("SensorValue").setValue(fieldsinMeas5[0]);
                                    // slot a2
                                    mRef.child("Saturday").child("BookedTime 9-10").child("Slot A2").child("SensorValue").setValue(fieldsinMeas5[1]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Saturday").child("BookedTime 10-11").child("Slot A2").child("SensorValue").setValue(fieldsinMeas5[1]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Saturday").child("BookedTime 11-12").child("Slot A2").child("SensorValue").setValue(fieldsinMeas5[1]);//fieldinmeas5[0]= firld 1 in jason data

                                    //slot b1
                                    mRef.child("Saturday").child("BookedTime 9-10").child("Slot B1").child("SensorValue").setValue(fieldsinMeas5[2]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Saturday").child("BookedTime 10-11").child("Slot B1").child("SensorValue").setValue(fieldsinMeas5[2]);
                                    mRef.child("Saturday").child("BookedTime 11-12").child("Slot B1").child("SensorValue").setValue(fieldsinMeas5[2]);
                                    // slot b2
                                    mRef.child("Saturday").child("BookedTime 9-10").child("Slot B2").child("SensorValue").setValue(fieldsinMeas5[3]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Saturday").child("BookedTime 10-11").child("Slot B2").child("SensorValue").setValue(fieldsinMeas5[3]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Saturday").child("BookedTime 11-12").child("Slot B2").child("SensorValue").setValue(fieldsinMeas5[3]);//fieldinmeas5[0]= firld 1 in jason data
                                    //slot c1
                                    mRef.child("Saturday").child("BookedTime 9-10").child("Slot C1").child("SensorValue").setValue(fieldsinMeas5[4]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Saturday").child("BookedTime 10-11").child("Slot C1").child("SensorValue").setValue(fieldsinMeas5[4]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Saturday").child("BookedTime 11-12").child("Slot C1").child("SensorValue").setValue(fieldsinMeas5[4]);//fieldinmeas5[0]= firld 1 in jason data

                                    //slot c2
                                    mRef.child("Saturday").child("BookedTime 9-10").child("Slot C2").child("SensorValue").setValue(fieldsinMeas5[5]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Saturday").child("BookedTime 10-11").child("Slot C2").child("SensorValue").setValue(fieldsinMeas5[5]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Saturday").child("BookedTime 11-12").child("Slot C2").child("SensorValue").setValue(fieldsinMeas5[5]);//fieldinmeas5[0]= firld 1 in jason data




                                    // mRef.child("Saturday").child("BookedTime 10-11").child("Slot A2").setValue(true);

                                    break;}
                                case Calendar.SUNDAY:{
                                    // Current day is Monday
                                    mRef.child("Sunday").child("BookedTime 9-10").child("Slot A1").child("SensorValue").setValue(fieldsinMeas5[0]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Sunday").child("BookedTime 10-11").child("Slot A1").child("SensorValue").setValue(fieldsinMeas5[0]);
                                    mRef.child("Sunday").child("BookedTime 11-12").child("Slot A1").child("SensorValue").setValue(fieldsinMeas5[0]);
                                    // slot a2
                                    mRef.child("Sunday").child("BookedTime 9-10").child("Slot A2").child("SensorValue").setValue(fieldsinMeas5[1]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Sunday").child("BookedTime 10-11").child("Slot A2").child("SensorValue").setValue(fieldsinMeas5[1]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Sunday").child("BookedTime 11-12").child("Slot A2").child("SensorValue").setValue(fieldsinMeas5[1]);//fieldinmeas5[0]= firld 1 in jason data

                                    //slot b1
                                    mRef.child("Sunday").child("BookedTime 9-10").child("Slot B1").child("SensorValue").setValue(fieldsinMeas5[2]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Sunday").child("BookedTime 10-11").child("Slot B1").child("SensorValue").setValue(fieldsinMeas5[2]);
                                    mRef.child("Sunday").child("BookedTime 11-12").child("Slot B1").child("SensorValue").setValue(fieldsinMeas5[2]);
                                    // slot b2
                                    mRef.child("Sunday").child("BookedTime 9-10").child("Slot B2").child("SensorValue").setValue(fieldsinMeas5[3]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Sunday").child("BookedTime 10-11").child("Slot B2").child("SensorValue").setValue(fieldsinMeas5[3]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Sunday").child("BookedTime 11-12").child("Slot B2").child("SensorValue").setValue(fieldsinMeas5[3]);//fieldinmeas5[0]= firld 1 in jason data
                                    //slot c1
                                    mRef.child("Sunday").child("BookedTime 9-10").child("Slot C1").child("SensorValue").setValue(fieldsinMeas5[4]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Sunday").child("BookedTime 10-11").child("Slot C1").child("SensorValue").setValue(fieldsinMeas5[4]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Sunday").child("BookedTime 11-12").child("Slot C1").child("SensorValue").setValue(fieldsinMeas5[4]);//fieldinmeas5[0]= firld 1 in jason data
                                    //slot c2
                                    mRef.child("Sunday").child("BookedTime 9-10").child("Slot C2").child("SensorValue").setValue(fieldsinMeas5[5]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Sunday").child("BookedTime 10-11").child("Slot C2").child("SensorValue").setValue(fieldsinMeas5[5]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Sunday").child("BookedTime 11-12").child("Slot C2").child("SensorValue").setValue(fieldsinMeas5[5]);//fieldinmeas5[0]= firld 1 in jason data

                                    break;}
                                case Calendar.MONDAY:{
                                    mRef.child("Monday").child("BookedTime 9-10").child("Slot A1").child("SensorValue").setValue(fieldsinMeas5[0]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Monday").child("BookedTime 10-11").child("Slot A1").child("SensorValue").setValue(fieldsinMeas5[0]);
                                    mRef.child("Monday").child("BookedTime 11-12").child("Slot A1").child("SensorValue").setValue(fieldsinMeas5[0]);
                                    // slot a2
                                    mRef.child("Monday").child("BookedTime 9-10").child("Slot A2").child("SensorValue").setValue(fieldsinMeas5[1]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Monday").child("BookedTime 10-11").child("Slot A2").child("SensorValue").setValue(fieldsinMeas5[1]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Monday").child("BookedTime 11-12").child("Slot A2").child("SensorValue").setValue(fieldsinMeas5[1]);//fieldinmeas5[0]= firld 1 in jason data

                                    //slot b1
                                    mRef.child("Monday").child("BookedTime 9-10").child("Slot B1").child("SensorValue").setValue(fieldsinMeas5[2]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Monday").child("BookedTime 10-11").child("Slot B1").child("SensorValue").setValue(fieldsinMeas5[2]);
                                    mRef.child("Monday").child("BookedTime 11-12").child("Slot B1").child("SensorValue").setValue(fieldsinMeas5[2]);
                                    // slot b2
                                    mRef.child("Monday").child("BookedTime 9-10").child("Slot B2").child("SensorValue").setValue(fieldsinMeas5[3]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Monday").child("BookedTime 10-11").child("Slot B2").child("SensorValue").setValue(fieldsinMeas5[3]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Monday").child("BookedTime 11-12").child("Slot B2").child("SensorValue").setValue(fieldsinMeas5[3]);//fieldinmeas5[0]= firld 1 in jason data
                                    //slot c1
                                    mRef.child("Monday").child("BookedTime 9-10").child("Slot C1").child("SensorValue").setValue(fieldsinMeas5[4]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Monday").child("BookedTime 10-11").child("Slot C1").child("SensorValue").setValue(fieldsinMeas5[4]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Monday").child("BookedTime 11-12").child("Slot C1").child("SensorValue").setValue(fieldsinMeas5[4]);//fieldinmeas5[0]= firld 1 in jason data
                                    //slot c2
                                    mRef.child("Monday").child("BookedTime 9-10").child("Slot C2").child("SensorValue").setValue(fieldsinMeas5[5]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Monday").child("BookedTime 10-11").child("Slot C2").child("SensorValue").setValue(fieldsinMeas5[5]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Monday").child("BookedTime 11-12").child("Slot C2").child("SensorValue").setValue(fieldsinMeas5[5]);//fieldinmeas5[0]= firld 1 in jason data

                                    break;}
                                case Calendar.TUESDAY:{
                                    mRef.child("Tuesday").child("BookedTime 9-10").child("Slot A1").child("SensorValue").setValue(fieldsinMeas5[0]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Tuesday").child("BookedTime 10-11").child("Slot A1").child("SensorValue").setValue(fieldsinMeas5[0]);
                                    mRef.child("Tuesday").child("BookedTime 11-12").child("Slot A1").child("SensorValue").setValue(fieldsinMeas5[0]);
                                    // slot a2
                                    mRef.child("Tuesday").child("BookedTime 9-10").child("Slot A2").child("SensorValue").setValue(fieldsinMeas5[1]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Tuesday").child("BookedTime 10-11").child("Slot A2").child("SensorValue").setValue(fieldsinMeas5[1]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Tuesday").child("BookedTime 11-12").child("Slot A2").child("SensorValue").setValue(fieldsinMeas5[1]);//fieldinmeas5[0]= firld 1 in jason data

                                    //slot b1
                                    mRef.child("Tuesday").child("BookedTime 9-10").child("Slot B1").child("SensorValue").setValue(fieldsinMeas5[2]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Tuesday").child("BookedTime 10-11").child("Slot B1").child("SensorValue").setValue(fieldsinMeas5[2]);
                                    mRef.child("Tuesday").child("BookedTime 11-12").child("Slot B1").child("SensorValue").setValue(fieldsinMeas5[2]);
                                    // slot b2
                                    mRef.child("Tuesday").child("BookedTime 9-10").child("Slot B2").child("SensorValue").setValue(fieldsinMeas5[3]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Tuesday").child("BookedTime 10-11").child("Slot B2").child("SensorValue").setValue(fieldsinMeas5[3]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Tuesday").child("BookedTime 11-12").child("Slot B2").child("SensorValue").setValue(fieldsinMeas5[3]);//fieldinmeas5[0]= firld 1 in jason data
                                    //slot c1
                                    mRef.child("Tuesday").child("BookedTime 9-10").child("Slot C1").child("SensorValue").setValue(fieldsinMeas5[4]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Tuesday").child("BookedTime 10-11").child("Slot C1").child("SensorValue").setValue(fieldsinMeas5[4]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Tuesday").child("BookedTime 11-12").child("Slot C1").child("SensorValue").setValue(fieldsinMeas5[4]);//fieldinmeas5[0]= firld 1 in jason data
                                    //slot c2
                                    mRef.child("Tuesday").child("BookedTime 9-10").child("Slot C2").child("SensorValue").setValue(fieldsinMeas5[5]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Tuesday").child("BookedTime 10-11").child("Slot C2").child("SensorValue").setValue(fieldsinMeas5[5]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Tuesday").child("BookedTime 11-12").child("Slot C2").child("SensorValue").setValue(fieldsinMeas5[5]);//fieldinmeas5[0]= firld 1 in jason data

                                    break;}
                                case Calendar.WEDNESDAY:{
                                    mRef.child("Wednesday").child("BookedTime 9-10").child("Slot A1").child("SensorValue").setValue(fieldsinMeas5[0]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Wednesday").child("BookedTime 10-11").child("Slot A1").child("SensorValue").setValue(fieldsinMeas5[0]);
                                    mRef.child("Wednesday").child("BookedTime 11-12").child("Slot A1").child("SensorValue").setValue(fieldsinMeas5[0]);
                                    // slot a2
                                    mRef.child("Wednesday").child("BookedTime 9-10").child("Slot A2").child("SensorValue").setValue(fieldsinMeas5[1]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Wednesday").child("BookedTime 10-11").child("Slot A2").child("SensorValue").setValue(fieldsinMeas5[1]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Wednesday").child("BookedTime 11-12").child("Slot A2").child("SensorValue").setValue(fieldsinMeas5[1]);//fieldinmeas5[0]= firld 1 in jason data

                                    //slot b1
                                    mRef.child("Wednesday").child("BookedTime 9-10").child("Slot B1").child("SensorValue").setValue(fieldsinMeas5[2]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Wednesday").child("BookedTime 10-11").child("Slot B1").child("SensorValue").setValue(fieldsinMeas5[2]);
                                    mRef.child("Wednesday").child("BookedTime 11-12").child("Slot B1").child("SensorValue").setValue(fieldsinMeas5[2]);
                                    // slot b2
                                    mRef.child("Wednesday").child("BookedTime 9-10").child("Slot B2").child("SensorValue").setValue(fieldsinMeas5[3]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Wednesday").child("BookedTime 10-11").child("Slot B2").child("SensorValue").setValue(fieldsinMeas5[3]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Wednesday").child("BookedTime 11-12").child("Slot B2").child("SensorValue").setValue(fieldsinMeas5[3]);//fieldinmeas5[0]= firld 1 in jason data
                                    //slot c1
                                    mRef.child("Wednesday").child("BookedTime 9-10").child("Slot C1").child("SensorValue").setValue(fieldsinMeas5[4]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Wednesday").child("BookedTime 10-11").child("Slot C1").child("SensorValue").setValue(fieldsinMeas5[4]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Wednesday").child("BookedTime 11-12").child("Slot C1").child("SensorValue").setValue(fieldsinMeas5[4]);//fieldinmeas5[0]= firld 1 in jason data
                                    //slot c2
                                    mRef.child("Wednesday").child("BookedTime 9-10").child("Slot C2").child("SensorValue").setValue(fieldsinMeas5[5]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Wednesday").child("BookedTime 10-11").child("Slot C2").child("SensorValue").setValue(fieldsinMeas5[5]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Wednesday").child("BookedTime 11-12").child("Slot C2").child("SensorValue").setValue(fieldsinMeas5[5]);//fieldinmeas5[0]= firld 1 in jason data

                                    break;}
                                case Calendar.THURSDAY:{
                                    mRef.child("Thursday").child("BookedTime 9-10").child("Slot A1").child("SensorValue").setValue(fieldsinMeas5[0]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Thursday").child("BookedTime 10-11").child("Slot A1").child("SensorValue").setValue(fieldsinMeas5[0]);
                                    mRef.child("Thursday").child("BookedTime 11-12").child("Slot A1").child("SensorValue").setValue(fieldsinMeas5[0]);
                                    // slot a2
                                    mRef.child("Thursday").child("BookedTime 9-10").child("Slot A2").child("SensorValue").setValue(fieldsinMeas5[1]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Thursday").child("BookedTime 10-11").child("Slot A2").child("SensorValue").setValue(fieldsinMeas5[1]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Thursday").child("BookedTime 11-12").child("Slot A2").child("SensorValue").setValue(fieldsinMeas5[1]);//fieldinmeas5[0]= firld 1 in jason data

                                    //slot b1
                                    mRef.child("Thursday").child("BookedTime 9-10").child("Slot B1").child("SensorValue").setValue(fieldsinMeas5[2]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Thursday").child("BookedTime 10-11").child("Slot B1").child("SensorValue").setValue(fieldsinMeas5[2]);
                                    mRef.child("Thursday").child("BookedTime 11-12").child("Slot B1").child("SensorValue").setValue(fieldsinMeas5[2]);
                                    // slot b2
                                    mRef.child("Thursday").child("BookedTime 9-10").child("Slot B2").child("SensorValue").setValue(fieldsinMeas5[3]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Thursday").child("BookedTime 10-11").child("Slot B2").child("SensorValue").setValue(fieldsinMeas5[3]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Thursday").child("BookedTime 11-12").child("Slot B2").child("SensorValue").setValue(fieldsinMeas5[3]);//fieldinmeas5[0]= firld 1 in jason data
                                    //slot c1
                                    mRef.child("Thursday").child("BookedTime 9-10").child("Slot C1").child("SensorValue").setValue(fieldsinMeas5[4]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Thursday").child("BookedTime 10-11").child("Slot C1").child("SensorValue").setValue(fieldsinMeas5[4]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Thursday").child("BookedTime 11-12").child("Slot C1").child("SensorValue").setValue(fieldsinMeas5[4]);//fieldinmeas5[0]= firld 1 in jason data
                                    //slot c2
                                    mRef.child("Thursday").child("BookedTime 9-10").child("Slot C2").child("SensorValue").setValue(fieldsinMeas5[5]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Thursday").child("BookedTime 10-11").child("Slot C2").child("SensorValue").setValue(fieldsinMeas5[5]);//fieldinmeas5[0]= firld 1 in jason data
                                    mRef.child("Thursday").child("BookedTime 11-12").child("Slot C2").child("SensorValue").setValue(fieldsinMeas5[5]);//fieldinmeas5[0]= firld 1 in jason data

                                    break;}
                                case Calendar.FRIDAY:{
                                    // etc.
                                    //do nothing its my WEEKEND :P
                                    break;}
                            }


                            ////////////////////////////



                        }
                        catch (JSONException e )
                        {
                            e.printStackTrace();
                            Toast.makeText(MainActivity.this,"error inside catch ",Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"error  ",Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        });
        // Toast.makeText(MainActivity.this,"response   "+response,Toast.LENGTH_SHORT).show();
        mQueue.add(request);
        Toast.makeText(MainActivity.this,"mQueue.add(request)   "+ mQueue.add(request),Toast.LENGTH_SHORT).show();
    }// void jsonParse


}
