package chii.chat.mytraffic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    //explicit ประกาศตัวแปร
    private TextView nameTextView, detailTextView;
    private ImageView imageView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

       //ผูก
        //setup หรือ ผูก ตัวแปร ให้กับ widget  ด้วย findviewbyid
        //Bind widget
        nameTextView = (TextView) findViewById(R.id.textView4);
        detailTextView = (TextView) findViewById(R.id.textView5);
        imageView = (ImageView) findViewById(R.id.imageView2);
        //end การผูก

        //การแสดงบนหน้าจอ
        //show view ให้กับ wibget
        String strName = getIntent().getStringExtra("Name");
        nameTextView.setText(strName);

        //show image
        int intImage = getIntent().getIntExtra("Image",R.drawable.backg);
        imageView.setImageResource(intImage);

        //show view detailTextView
        int intIndex = getIntent().getIntExtra("Index",0);      //ประกาศ
        String[] detailStrings = getResources().getStringArray(R.array.detail_long);  //get ค่าให้กับตัวแปรที่ผูก ใน widget
        detailTextView.setText(detailStrings[intIndex]);                    //set ค่าให้กับตัวแปร เพื่อ แสดงค่าบนหน้าจอ ที่ statement นี้
    //end การแสดงบนหน้าจอ


    } //end main method


public void clicBack(View view) {
    finish();
}


} //end main class
