package chii.chat.mytraffic;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Explicit หรือ การประกาศตัวแปร
    private ListView trafficListView;
    private Button aboutMEButton;                                            // คีย์ลัด shift + Ctl + enter จะปิด statement ให้


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);                                 //statement หรือ คำสั่ง ในเมธอด จะตามหลักด้วย ";" คำสั่งลัด  reformat source code ใฃ้คำส่ง Ctl+Alt+L
        setContentView(R.layout.activity_main);

        // Bind widget คือ ผูก widget ให้กับตัวแปรเพื่อการทำงาน
        trafficListView = (ListView) findViewById(R.id.listView);           //R.id.listView  cast to data คำสั่ง Atl + Enter
        aboutMEButton = (Button) findViewById(R.id.button);

        // การเขียน controller ของปุ่ม button
        controllerButton();                                                 //Alt ค้าง Enter เพื่อสร้าง method =>> private void controllerButton()




    } // end main method หรือ เมธอดหลัก

    private void controllerButton() {
        aboutMEButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //Sound Effect
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.pig);      // getBaseContext การดึงเสียงจากใน folder raw App.เรา ไม่ ใช่จาก mem card
                mediaPlayer.start();

            } //end onClick ปุ่ม aboutMeButton
        });


    } //end controllerButton


} //End Main class หลัก
