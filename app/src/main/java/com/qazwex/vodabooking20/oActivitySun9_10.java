package com.qazwex.vodabooking20;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class oActivitySun9_10 extends AppCompatActivity {
    final private DatabaseReference mrefSun9_10 = FirebaseDatabase.getInstance().getReferenceFromUrl("https://vodabooking20.firebaseio.com/");//global to handel it  in function and put
    @BindView(R.id.btnidslotA1)
    Button btnidslotA1;
    @BindView(R.id.btnidslotA2)
    Button btnidslotA2;
    @BindView(R.id.btnidslotB1)
    Button btnidslotB1;
    @BindView(R.id.btnidslotB2)
    Button btnidslotB2;
    @BindView(R.id.btnidslotC1)
    Button btnidslotC1;
    @BindView(R.id.btnidslotC2)
    Button btnidslotC2;
    @BindView(R.id.editphone)
    EditText editphone;
    @BindView(R.id.clearallslots)
    Button clearallbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_sun9_10);
        ButterKnife.bind(this);
        getdata_fromFire_checkBooking_tf();

    }//oncreate
    @OnClick({R.id.btnidslotA1, R.id.btnidslotA2, R.id.btnidslotB1, R.id.btnidslotB2, R.id.btnidslotC1, R.id.btnidslotC2, R.id.clearallslots})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnidslotA1: {
                AlertDialog.Builder buildervar = new AlertDialog.Builder(oActivitySun9_10.this);
                buildervar.setMessage("Are You Sure ?")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Toast.makeText(oActivitySat10_11.this, "dataSnapshot= ", Toast.LENGTH_SHORT).show();

                                int intphone = Integer.parseInt(editphone.getText().toString());
                                mrefSun9_10.child("Sunday").child("BookedTime 9-10").child("Slot A1").child("Booked").setValue(true);
                                mrefSun9_10.child("Sunday").child("BookedTime 9-10").child("Slot A1").child("Car Number").setValue(intphone);
                                btnidslotA1.setEnabled(false);
                                btnidslotA1.setText("Booked");
                                btnidslotA1.setBackgroundColor(Color.GRAY);
                            }
                        }).setNegativeButton("No", null);
                AlertDialog alert = buildervar.create();
                alert.show();
                break;
            }//slotA1
            case R.id.btnidslotA2: {
                AlertDialog.Builder buildervar = new AlertDialog.Builder(oActivitySun9_10.this);
                buildervar.setMessage("Are You Sure ?")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Toast.makeText(oActivitySat10_11.this, "dataSnapshot= ", Toast.LENGTH_SHORT).show();

                                int intphone = Integer.parseInt(editphone.getText().toString());
                                mrefSun9_10.child("Sunday").child("BookedTime 9-10").child("Slot A2").child("Booked").setValue(true);
                                mrefSun9_10.child("Sunday").child("BookedTime 9-10").child("Slot A2").child("Car Number").setValue(intphone);
                                btnidslotA2.setEnabled(false);
                                btnidslotA2.setText("Booked");
                                btnidslotA2.setBackgroundColor(Color.GRAY);
                            }
                        }).setNegativeButton("No", null);
                AlertDialog alert = buildervar.create();
                alert.show();
                break;
            }//slotA2
            case R.id.btnidslotB1: {
                AlertDialog.Builder buildervar = new AlertDialog.Builder(oActivitySun9_10.this);
                buildervar.setMessage("Are You Sure ?")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Toast.makeText(oActivitySat10_11.this, "dataSnapshot= ", Toast.LENGTH_SHORT).show();

                                int intphone = Integer.parseInt(editphone.getText().toString());
                                mrefSun9_10.child("Sunday").child("BookedTime 9-10").child("Slot B1").child("Booked").setValue(true);
                                mrefSun9_10.child("Sunday").child("BookedTime 9-10").child("Slot B1").child("Car Number").setValue(intphone);
                                btnidslotB1.setEnabled(false);
                                btnidslotB1.setText("Booked");
                                btnidslotB1.setBackgroundColor(Color.GRAY);
                            }
                        }).setNegativeButton("No", null);
                AlertDialog alert = buildervar.create();
                alert.show();
                break;
            }//slotB1
            case R.id.btnidslotB2: {
                AlertDialog.Builder buildervar = new AlertDialog.Builder(oActivitySun9_10.this);
                buildervar.setMessage("Are You Sure ?")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Toast.makeText(oActivitySat10_11.this, "dataSnapshot= ", Toast.LENGTH_SHORT).show();

                                int intphone = Integer.parseInt(editphone.getText().toString());
                                mrefSun9_10.child("Sunday").child("BookedTime 9-10").child("Slot B2").child("Booked").setValue(true);
                                mrefSun9_10.child("Sunday").child("BookedTime 9-10").child("Slot B2").child("Car Number").setValue(intphone);
                                btnidslotB2.setEnabled(false);
                                btnidslotB2.setText("Booked");
                                btnidslotB2.setBackgroundColor(Color.GRAY);
                            }
                        }).setNegativeButton("No", null);
                AlertDialog alert = buildervar.create();
                alert.show();
                break;
            }//slotB2
            case R.id.btnidslotC1: {
                AlertDialog.Builder buildervar = new AlertDialog.Builder(oActivitySun9_10.this);
                buildervar.setMessage("Are You Sure ?")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Toast.makeText(oActivitySat10_11.this, "dataSnapshot= ", Toast.LENGTH_SHORT).show();

                                int intphone = Integer.parseInt(editphone.getText().toString());
                                mrefSun9_10.child("Sunday").child("BookedTime 9-10").child("Slot C1").child("Booked").setValue(true);
                                mrefSun9_10.child("Sunday").child("BookedTime 9-10").child("Slot C1").child("Car Number").setValue(intphone);
                                btnidslotC1.setEnabled(false);
                                btnidslotC1.setText("Booked");
                                btnidslotC1.setBackgroundColor(Color.GRAY);
                            }
                        }).setNegativeButton("No", null);
                AlertDialog alert = buildervar.create();
                alert.show();
                break;
            }//slotC1
            case R.id.btnidslotC2: {
                AlertDialog.Builder buildervar = new AlertDialog.Builder(oActivitySun9_10.this);
                buildervar.setMessage("Are You Sure ?")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Toast.makeText(oActivitySat10_11.this, "dataSnapshot= ", Toast.LENGTH_SHORT).show();

                                int intphone = Integer.parseInt(editphone.getText().toString());
                                mrefSun9_10.child("Sunday").child("BookedTime 9-10").child("Slot C2").child("Booked").setValue(true);
                                mrefSun9_10.child("Sunday").child("BookedTime 9-10").child("Slot C2").child("Car Number").setValue(intphone);
                                btnidslotC2.setEnabled(false);
                                btnidslotC2.setText("Booked");
                                btnidslotC2.setBackgroundColor(Color.GRAY);
                            }
                        }).setNegativeButton("No", null);
                AlertDialog alert = buildervar.create();
                alert.show();
                break;
            }//slotC2
            case R.id.clearallslots: {
                AlertDialog.Builder buildervar = new AlertDialog.Builder(oActivitySun9_10.this);
                buildervar.setMessage("Are You Sure ?")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int intphone = Integer.parseInt(editphone.getText().toString());
                                mrefSun9_10.child("Sunday").child("BookedTime 9-10").child("Slot A1").child("Booked").setValue(false);
                                mrefSun9_10.child("Sunday").child("BookedTime 9-10").child("Slot A2").child("Booked").setValue(false);
                                mrefSun9_10.child("Sunday").child("BookedTime 9-10").child("Slot B1").child("Booked").setValue(false);
                                mrefSun9_10.child("Sunday").child("BookedTime 9-10").child("Slot B2").child("Booked").setValue(false);
                                mrefSun9_10.child("Sunday").child("BookedTime 9-10").child("Slot C1").child("Booked").setValue(false);
                                mrefSun9_10.child("Sunday").child("BookedTime 9-10").child("Slot C2").child("Booked").setValue(false);
                                btnidslotA1.setEnabled(true);
                                btnidslotA2.setEnabled(true);
                                btnidslotB1.setEnabled(true);
                                btnidslotB2.setEnabled(true);
                                btnidslotC1.setEnabled(true);
                                btnidslotC2.setEnabled(true);
                                btnidslotA1.setText("Slot A1");
                                btnidslotA1.setBackgroundColor(Color.GREEN);
                                btnidslotA2.setText("Slot A2");
                                btnidslotA2.setBackgroundColor(Color.GREEN);
                                btnidslotB1.setText("Slot B1");
                                btnidslotB1.setBackgroundColor(Color.GREEN);
                                btnidslotB2.setText("Slot B2");
                                btnidslotB2.setBackgroundColor(Color.GREEN);
                                btnidslotC1.setText("Slot C1");
                                btnidslotC1.setBackgroundColor(Color.GREEN);
                                btnidslotC2.setText("Slot C2");
                                btnidslotC2.setBackgroundColor(Color.GREEN);
                            }
                        }).setNegativeButton("No", null);
                AlertDialog alert = buildervar.create();
                alert.show();
                break;
            }
            


        }//slotC2
    }//switch
    private void getdata_fromFire_checkBooking_tf() {
        mrefSun9_10.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (((boolean) dataSnapshot.child("Sunday").child("BookedTime 9-10").child("Slot A1").child("Booked").getValue()) == true) {
                    btnidslotA1.setEnabled(false);
                    btnidslotA1.setText("Booked");
                    btnidslotA1.setBackgroundColor(Color.GRAY);
                }
                if (((boolean) dataSnapshot.child("Sunday").child("BookedTime 9-10").child("Slot A2").child("Booked").getValue()) == true) {
                    btnidslotA2.setEnabled(false);
                    btnidslotA2.setText("Booked");
                    btnidslotA2.setBackgroundColor(Color.GRAY);
                }
                if (((boolean) dataSnapshot.child("Sunday").child("BookedTime 9-10").child("Slot B1").child("Booked").getValue()) == true) {
                    btnidslotB1.setEnabled(false);
                    btnidslotB1.setText("Booked");
                    btnidslotB1.setBackgroundColor(Color.GRAY);
                }
                if (((boolean) dataSnapshot.child("Sunday").child("BookedTime 9-10").child("Slot B2").child("Booked").getValue()) == true) {
                    btnidslotB2.setEnabled(false);
                    btnidslotB2.setText("Booked");
                    btnidslotB2.setBackgroundColor(Color.GRAY);
                }
                if (((boolean) dataSnapshot.child("Sunday").child("BookedTime 9-10").child("Slot C1").child("Booked").getValue()) == true) {
                    btnidslotC1.setEnabled(false);
                    btnidslotC1.setText("Booked");
                    btnidslotC1.setBackgroundColor(Color.GRAY);
                }
                if (((boolean) dataSnapshot.child("Sunday").child("BookedTime 9-10").child("Slot C2").child("Booked").getValue()) == true) {
                    btnidslotC2.setEnabled(false);
                    btnidslotC2.setText("Booked");
                    btnidslotC2.setBackgroundColor(Color.GRAY);
                }



            }//onDataChange

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }


}

