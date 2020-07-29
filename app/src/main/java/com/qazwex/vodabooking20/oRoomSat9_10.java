package com.qazwex.vodabooking20;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
public class oRoomSat9_10 extends AppCompatActivity {
    final private DatabaseReference mrefRoomSat9_10 = FirebaseDatabase.getInstance().getReferenceFromUrl("https://vodabooking20.firebaseio.com/");//global to handel it  in function and put

    @BindView(R.id.editphone)
    EditText editphone;
    @BindView(R.id.btnRoom1)
    Button btnRoom1;
    @BindView(R.id.btnRoom2)
    Button btnRoom2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_room_sat9_10);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.editphone, R.id.btnRoom1, R.id.btnRoom2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.editphone:
                break;
            case R.id.btnRoom1:
            {  AlertDialog.Builder buildervar=new AlertDialog.Builder(oRoomSat9_10.this);
                buildervar.setMessage("Are You Sure ?")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                int intphone=Integer.parseInt(editphone.getText().toString());
                                mrefRoomSat9_10.child("Saturday").child("BookedTime 9-10").child("Room 1").child("Booked").setValue(true);
                                mrefRoomSat9_10.child("Saturday").child("BookedTime 9-10").child("Room 1").child("phone no=").setValue(intphone);
                                btnRoom1.setEnabled(false);
                                btnRoom1.setText("Booked");
                                btnRoom1.setBackgroundColor(Color.GRAY);
                            }
                        }).setNegativeButton("No",null);
                AlertDialog alert=buildervar.create();
                alert.show();


                break;
            }
            case R.id.btnRoom2:
            {

                AlertDialog.Builder buildervar=new AlertDialog.Builder(oRoomSat9_10.this);
                buildervar.setMessage("Are You Sure ?")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int intphone=Integer.parseInt(editphone.getText().toString());
                                mrefRoomSat9_10.child("Saturday").child("BookedTime 9-10").child("Room 2").child("Booked").setValue(true);
                                mrefRoomSat9_10.child("Saturday").child("BookedTime 9-10").child("Room 2").child("phone no=").setValue(intphone);
                                btnRoom2.setEnabled(false);
                                btnRoom2.setText("Booked");
                                btnRoom2.setBackgroundColor(Color.GRAY);
                            }
                        }).setNegativeButton("No",null);
                AlertDialog alert=buildervar.create();
                alert.show();


                break;
            }
        }
    }




    //
}
