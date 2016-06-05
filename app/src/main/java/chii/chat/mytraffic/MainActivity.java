package chii.chat.mytraffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    //Explicit หรือ การประกาศตัวแปร studio จะ auto import android...ด้านบน ให้ไม่ต้องทำ
    private ListView trafficListView;
    private Button aboutMEButton;                                                // คีย์ลัด shift + Ctl + enter จะปิด statement ให้
    private String urlYoutubeString = "https://youtu.be/EPZfaGPP3cA";    //ประกาศค่าตัวแปร string และระบุค่าคงที่คือ link


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);                                 //statement หรือ คำสั่ง ในเมธอด จะตามหลักด้วย ";" คำสั่งลัด  reformat source code ใฃ้คำส่ง Ctl+Alt+L
        setContentView(R.layout.activity_main);

        // Bind widget คือ ผูก widget ให้กับตัวแปรเพื่อการทำงาน
        trafficListView = (ListView) findViewById(R.id.listView);           //R.id.listView  cast to data คำสั่ง Atl + Enter
        aboutMEButton = (Button) findViewById(R.id.button);

        // การเขียน controller ของปุ่ม button (method ที่ 1)
        controllerButton();                                                 //Alt ค้าง Enter เพื่อสร้าง method =>> private void controllerButton()
        // controller ของ ListView
        controllerListView();                                               //Alt ค้าง Enter เพื่อสร้าง method


    } // end main method หรือ เมธอดหลัก

    private void controllerListView() {

        // setup for name  แบบตัวแปร fix ใน source code
        final String[] nameStrings = new String[20];
        nameStrings[0] = "หัวข้อหลักที่ 1";
        nameStrings[1] = "หัวข้อหลักที่ 2";
        nameStrings[2] = "หัวข้อหลักที่ 3";
        nameStrings[3] = "หัวข้อหลักที่ 4";
        nameStrings[4] = "หัวข้อหลักที่ 5";
        nameStrings[5] = "หัวข้อหลักที่ 6";
        nameStrings[6] = "หัวข้อหลักที่ 7";
        nameStrings[7] = "หัวข้อหลักที่ 8";
        nameStrings[8] = "หัวข้อหลักที่ 9";
        nameStrings[9] = "หัวข้อหลักที่ 10";
        nameStrings[10] = "หัวข้อหลักที่ 11";
        nameStrings[11] = "หัวข้อหลักที่ 12";
        nameStrings[12] = "หัวข้อหลักที่ 13";
        nameStrings[13] = "หัวข้อหลักที่ 14";
        nameStrings[14] = "หัวข้อหลักที่ 15";
        nameStrings[15] = "หัวข้อหลักที่ 16";
        nameStrings[16] = "หัวข้อหลักที่ 17";
        nameStrings[17] = "หัวข้อหลักที่ 18";
        nameStrings[18] = "หัวข้อหลักที่ 19";
        nameStrings[19] = "หัวข้อหลักที่ 20";

    // setup for detail Short แบบ array ใน XML
        String[] detailStrings = getResources().getStringArray(R.array.detail_short);


        //setup for image  อีกแบบคือการสร้าง class เลย เพื่อเก็บ data ดูตาม class Mydata.Java
        MyData myData = new MyData();
        final int[] ints = myData.getInts();

        //create listview
        MyAdapter myAdapter = new MyAdapter(this,ints,nameStrings,detailStrings);   //set ค่าให้ adapter ใน myAdapter
        trafficListView.setAdapter(myAdapter);                                     // statement ทำงานแสดง ใน list view ที่ชื่อ trafficListview


        //มี action เมื่อคลิก ที่ row list view จะให้ไป หน้าจอต่อไป  (คือการ intent ไปหน้าจอถัดไป)
        trafficListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              Intent intent = new Intent(MainActivity.this,DetailActivity.class);   //การเคลื่อนย้าย ข้อมูลเมื่อคลิกจากหน้าจอ main ไปหน้า detailactivity
                    intent.putExtra("Name", nameStrings[position]);                //ส่งค่า
                    intent.putExtra("Image", ints[position]);                      //ส่งค่า
                    intent.putExtra("Index", position);                            //ส่งค่า
                startActivity(intent);                                             //statement เพื่อทำงาน ไปหน้าถัดไป คือหน้า detailActivity


            }
        });  //end การจับการกดจากหน้าจอ และส่งข้อมูลไปหน้าถัดไป





    } //end main method ของ controller list View

    private void controllerButton() {
        aboutMEButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Sound Effect
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.pig);      // getBaseContext การดึงเสียงจากใน folder raw App.เรา ไม่ ใช่จาก mem card
                mediaPlayer.start();                                                            // statement ทำงาน run sound

                //การทำ web view link ไป youtube  => Intent สามารถทำ share ได้
                Intent intent = new Intent(Intent.ACTION_VIEW);                                    //ประกาศตัวแปร intent ให้ทำงาน
                intent.setData(Uri.parse(urlYoutubeString));                                       //ใส่ค่าตัวแปรใน path
                startActivity(intent);                                                             //statement ทำงานของตัวแปร intent ที่ใส่ค่า link ในค่าตัวแปร
                //end การทำงาน web view

            } //end onClick ปุ่ม aboutMeButton
        });


    } //end controllerButton


} //End Main class หลัก
