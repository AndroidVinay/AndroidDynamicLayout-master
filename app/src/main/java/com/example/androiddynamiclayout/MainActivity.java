package com.example.androiddynamiclayout;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {


    private String TAG = MainActivity.class.getSimpleName();
    // LinearLayout
    private LinearLayout llContentView;

    // List
    private LinkedList<ImageButton> listIBTNAdd;
    // ťID
    public static int btnIDIndex = 1000 * 1;
    // List
    private LinkedList<ImageButton> listIBTNDel;

    private int iETContentHeight = 0;    // EditText
    private float fDimRatio = 1.0f; // /xml

    Button btnSendToChemist;
    List<EditText> allEdt = new ArrayList<EditText>();
    List<Spinner> allSpnr = new ArrayList<Spinner>();
    List<CheckBox> allChckB = new ArrayList<CheckBox>();
    List<CheckBox> allChckL = new ArrayList<CheckBox>();
    List<CheckBox> allChckD = new ArrayList<CheckBox>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addContent();
        initCtrl();

    }


    private void initCtrl() {
        llContentView = (LinearLayout) this.findViewById(R.id.content_view);
//        etContent1 = (EditText) this.findViewById(R.id.et_content1);
        listIBTNAdd = new LinkedList<ImageButton>();
        listIBTNDel = new LinkedList<ImageButton>();

        ImageButton ibtnAdd1 = (ImageButton) this.findViewById(R.id.img_add_more);
        btnSendToChemist = (Button) this.findViewById(R.id.btn_send_to_chemist);
        ibtnAdd1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                iETContentHeight = etContent1.getHeight();
//                fDimRatio = iETContentHeight / 80;

//                addContent(v);
                addContent();
            }
        });

        btnSendToChemist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] editTextString = new String[allEdt.size()];
                String[] spinnerString = new String[allSpnr.size()];
                String[] checkboxBString = new String[allChckB.size()];
                String[] checkboxLString = new String[allChckL.size()];
                String[] checkboxDString = new String[allChckD.size()];
                for (int i = 0; i < allEdt.size(); i++) {
                    editTextString[i] = allEdt.get(i).getText().toString();
                    Log.d(TAG + " day" + i, editTextString[i]);

                    spinnerString[i] = allSpnr.get(i).getSelectedItem().toString();
                    Log.d(TAG + " medicine" + i, spinnerString[i]);

                    checkboxBString[i] = String.valueOf(allChckB.get(i).isChecked());
                    Log.d(TAG + " checkboxB" + i, checkboxBString[i]);
                    checkboxLString[i] = String.valueOf(allChckL.get(i).isChecked());
                    Log.d(TAG + " checkboxL" + i, checkboxLString[i]);

                    checkboxDString[i] = String.valueOf(allChckD.get(i).isChecked());
                    Log.d(TAG + " checkboxD" + i, checkboxDString[i]);

                }


            }
        });

        listIBTNAdd.add(ibtnAdd1);
        listIBTNDel.add(null);
    }

    private void addContent() {
//        if (v == null) {
//            return;
//        }


//        int iIndex = -1;
        int iIndex = 0;
//        for (int i = 0; i < listIBTNAdd.size(); i++) {
//            if (listIBTNAdd.get(i) == v) {
//                iIndex = i;
//                break;
//            }
//        }

        if (iIndex >= 0) {
            iIndex += 1;


            // LinearLayout
            LinearLayout layout = new LinearLayout(MainActivity.this);
            LinearLayout.LayoutParams lLayoutlayoutParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);

            lLayoutlayoutParams.setMargins(0, (int) (fDimRatio * 5), 0, 0);
            layout.setLayoutParams(lLayoutlayoutParams);

            layout.setBackgroundColor(Color.argb(255, 162, 205, 90));    // #FFA2CD5A
            layout.setPadding((int) (fDimRatio * 5), (int) (fDimRatio * 5),
                    (int) (fDimRatio * 5), (int) (fDimRatio * 5));
            layout.setOrientation(LinearLayout.VERTICAL);

            // 2.Textview (Prescription)
            TextView tvContent = new TextView(MainActivity.this);
            LinearLayout.LayoutParams tvParam = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            tvContent.setLayoutParams(tvParam);

            tvContent.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));    // #FFFFFFFF
            tvContent.setGravity(Gravity.LEFT);
            tvContent.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
            tvContent.setPadding((int) (fDimRatio * 5), 0, 0, 0);
            tvContent.setTextSize(16);
            tvContent.setText("Prescription");
            layout.addView(tvContent);


            // Prescription Spinner
            String[] strings = {"1", "2", "3"};
            Spinner spnr_presp = new Spinner(MainActivity.this);
            allSpnr.add(spnr_presp);
            LinearLayout.LayoutParams spnrParam = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            spnr_presp.setLayoutParams(spnrParam);
            spnr_presp.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, strings));
            spnr_presp.setBackgroundColor(Color.argb(255, 255, 255, 255));    // #FFFFFFFF
            spnr_presp.setPadding((int) (fDimRatio * 5), 0, 0, 0);
            layout.addView(spnr_presp);


            //prescription horizontal Linearlayout
            LinearLayout layout1 = new LinearLayout(MainActivity.this);
            LinearLayout.LayoutParams lLayoutlayoutParams1 = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            lLayoutlayoutParams1.setMargins(0, (int) (fDimRatio * 5), 0, 0);
            layout1.setLayoutParams(lLayoutlayoutParams1);
            layout1.setBackgroundColor(Color.argb(255, 162, 205, 90));    // #FFA2CD5A
            layout1.setPadding((int) (fDimRatio * 5), (int) (fDimRatio * 5),
                    (int) (fDimRatio * 5), (int) (fDimRatio * 5));
            layout1.setOrientation(LinearLayout.HORIZONTAL);
            layout.addView(layout1);

            LinearLayout layout2 = new LinearLayout(MainActivity.this);
            LinearLayout.LayoutParams lLayoutlayoutParams2 = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            lLayoutlayoutParams2.setMargins(0, (int) (fDimRatio * 5), 0, 0);
            layout2.setLayoutParams(lLayoutlayoutParams2);
            layout2.setBackgroundColor(Color.argb(255, 162, 205, 90));    // #FFA2CD5A
            layout2.setPadding((int) (fDimRatio * 5), (int) (fDimRatio * 5),
                    (int) (fDimRatio * 5), (int) (fDimRatio * 5));
            layout2.setOrientation(LinearLayout.VERTICAL);
            layout1.addView(layout2);

            // 2.Textview (Prescription)
            TextView tvDosage = new TextView(MainActivity.this);
            LinearLayout.LayoutParams tvDosageparam = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            tvDosage.setLayoutParams(tvDosageparam);

            tvDosage.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));    // #FFFFFFFF
            tvDosage.setGravity(Gravity.LEFT);
            tvDosage.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
            tvDosage.setPadding((int) (fDimRatio * 5), 0, 0, 0);
            tvDosage.setTextSize(16);
            tvDosage.setText("Dosage");
            layout2.addView(tvDosage);


            LinearLayout layout4 = new LinearLayout(MainActivity.this);
            LinearLayout.LayoutParams lLayoutlayoutParams4 = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            lLayoutlayoutParams4.setMargins(0, (int) (fDimRatio * 5), 0, 0);
            layout4.setLayoutParams(lLayoutlayoutParams4);
            layout4.setBackgroundColor(Color.argb(255, 162, 205, 90));    // #FFA2CD5A
            layout4.setPadding((int) (fDimRatio * 5), (int) (fDimRatio * 5),
                    (int) (fDimRatio * 5), (int) (fDimRatio * 5));
            layout4.setOrientation(LinearLayout.HORIZONTAL);
            layout2.addView(layout4);

            //checkbox B
            CheckBox checkBox = new CheckBox(MainActivity.this);
            allChckB.add(checkBox);
            LinearLayout.LayoutParams checkbxParam = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            checkBox.setLayoutParams(checkbxParam);
            checkBox.setText("B");
            layout4.addView(checkBox);

            //checkbox L
            CheckBox checkBox1 = new CheckBox(MainActivity.this);
            allChckL.add(checkBox1);
            LinearLayout.LayoutParams checkbxParam1 = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            checkBox1.setLayoutParams(checkbxParam1);
            checkBox1.setText("L");
            layout4.addView(checkBox1);

            //checkbox D
            CheckBox checkBox2 = new CheckBox(MainActivity.this);
            allChckD.add(checkBox2);
            LinearLayout.LayoutParams checkbxParam2 = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            checkBox2.setLayoutParams(checkbxParam2);
            checkBox2.setText("D");
            layout4.addView(checkBox2);


            LinearLayout layout3 = new LinearLayout(MainActivity.this);
            LinearLayout.LayoutParams lLayoutlayoutParams3 = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            lLayoutlayoutParams3.setMargins(0, (int) (fDimRatio * 5), 0, 0);
            layout3.setLayoutParams(lLayoutlayoutParams3);
            layout3.setBackgroundColor(Color.argb(255, 162, 205, 90));    // #FFA2CD5A
            layout3.setPadding((int) (fDimRatio * 5), (int) (fDimRatio * 5),
                    (int) (fDimRatio * 5), (int) (fDimRatio * 5));
            layout3.setOrientation(LinearLayout.VERTICAL);
            layout1.addView(layout3);

            TextView tvDays = new TextView(MainActivity.this);
            LinearLayout.LayoutParams tvDaysparam = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            tvDays.setLayoutParams(tvDaysparam);

            tvDays.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));    // #FFFFFFFF
            tvDays.setGravity(Gravity.LEFT);
            tvDays.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
            tvDays.setPadding((int) (fDimRatio * 5), 0, 0, 0);
            tvDays.setTextSize(16);
            tvDays.setText("Days");
            layout3.addView(tvDays);

            //Days editText box
            EditText etContent = new EditText(MainActivity.this);
            allEdt.add(etContent);
            LinearLayout.LayoutParams etParam = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            etContent.setLayoutParams(etParam);
            etContent.setBackgroundColor(Color.argb(255, 255, 255, 255));    // #FFFFFFFF
            etContent.setGravity(Gravity.LEFT);
            etContent.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
            etContent.setPadding((int) (fDimRatio * 5), 0, 0, 0);
            etContent.setTextSize(16);
            etContent.setHint("days");
            layout3.addView(etContent);


//            RelativeLayout
            RelativeLayout rlBtn = new RelativeLayout(MainActivity.this);
            RelativeLayout.LayoutParams rlParam = new RelativeLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
//			rlParam.setMargins(0, (int) (fDimRatio * 5), 0, 0);
            rlBtn.setPadding(0, (int) (fDimRatio * 5), 0, 0);
            rlBtn.setLayoutParams(rlParam);

            // 4.
            ImageButton btnAdd = new ImageButton(MainActivity.this);
            RelativeLayout.LayoutParams btnAddParam = new RelativeLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);

            btnAddParam.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            btnAdd.setLayoutParams(btnAddParam);

            btnAdd.setBackgroundResource(R.drawable.ic_add);
            btnAdd.setId(btnIDIndex);

            btnAdd.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
//                    addContent(v);
                    addContent();
                }
            });

            rlBtn.addView(btnAdd);
            listIBTNAdd.add(iIndex, btnAdd);

            // 5.
            ImageButton btnDelete = new ImageButton(MainActivity.this);
            btnDelete.setBackgroundResource(R.drawable.ic_delete);
            RelativeLayout.LayoutParams btnDeleteAddParam = new RelativeLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            btnDeleteAddParam.setMargins(0, 0, (int) (fDimRatio * 5), 0);
            //
            btnDeleteAddParam.addRule(RelativeLayout.LEFT_OF, btnIDIndex);
            btnDelete.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    deleteContent(v);
                }
            });
            // RelativeLayout
            rlBtn.addView(btnDelete, btnDeleteAddParam);
            listIBTNDel.add(iIndex, btnDelete);

            // 6.RelativeLayout to LinearLayout
            layout.addView(rlBtn);

            // 7.layout llContentView
            llContentView.addView(layout, iIndex);

            btnIDIndex++;
        }
    }

    private void deleteContent(View v) {
        if (v == null) {
            return;
        }


        int iIndex = -1;
        for (int i = 0; i < listIBTNDel.size(); i++) {
            if (listIBTNDel.get(i) == v) {
                iIndex = i;
                break;
            }
        }
        if (iIndex >= 0) {
            listIBTNAdd.remove(iIndex);
            listIBTNDel.remove(iIndex);

            llContentView.removeViewAt(iIndex);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}
