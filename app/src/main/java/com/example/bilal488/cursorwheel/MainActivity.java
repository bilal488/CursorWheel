package com.example.bilal488.cursorwheel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bilal488.cursorwheel.Adapter.WheelItemAdapter;
import com.example.bilal488.cursorwheel.Adapter.WheelTextAdapter;
import com.example.bilal488.cursorwheel.Data.ImageData;
import com.example.bilal488.cursorwheel.Data.MenuItemData;

import java.util.ArrayList;
import java.util.List;

import github.hellocsl.cursorwheel.CursorWheelLayout;

public class MainActivity extends AppCompatActivity implements CursorWheelLayout.OnMenuSelectedListener {

    CursorWheelLayout wheel_text,wheel_image;
    List<MenuItemData> lstText;
    List<ImageData> lstImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        
        loadData();

        wheel_text.setOnMenuSelectedListener(this);
        wheel_image.setOnMenuSelectedListener(this);
    }

    private void loadData() {
        lstText = new ArrayList<>();
        for (int i=0;i<9;i++)
            lstText.add(new MenuItemData(""+i));
        lstText.add(new MenuItemData("OFF"));
        WheelTextAdapter adapter = new WheelTextAdapter(getBaseContext(),lstText);
        wheel_text.setAdapter(adapter);

        lstImage = new ArrayList<>();
        lstImage.add(new ImageData(R.drawable.drive,"Drive"));
        lstImage.add(new ImageData(R.drawable.facebook,"Facebook"));
        lstImage.add(new ImageData(R.drawable.twitter,"Twitter"));
        lstImage.add(new ImageData(R.drawable.windows,"Windows"));
        lstImage.add(new ImageData(R.drawable.youtube,"Youtube"));
        WheelItemAdapter imgadapter = new WheelItemAdapter(getBaseContext(),lstImage);
        wheel_image.setAdapter(imgadapter);
    }

    private void initViews() {
        wheel_image = (CursorWheelLayout)findViewById(R.id.wheel_image);
        wheel_text = (CursorWheelLayout)findViewById(R.id.wheel_text);
    }

    @Override
    public void onItemSelected(CursorWheelLayout parent, View view, int pos) {
        if (parent.getId() == R.id.wheel_text)
            Toast.makeText(getBaseContext(), "Selected:"+lstText.get(pos).mTitle, Toast.LENGTH_SHORT).show();
        else if (parent.getId() == R.id.wheel_image)
            Toast.makeText(getBaseContext(), "Selected:"+lstImage.get(pos).imageDiscription, Toast.LENGTH_SHORT).show();
    }
}
