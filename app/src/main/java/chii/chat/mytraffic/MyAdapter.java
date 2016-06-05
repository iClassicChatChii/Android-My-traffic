package chii.chat.mytraffic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by cfour_000 on 05/06/2016.
 */
public class MyAdapter extends BaseAdapter{               //adapter คือเครื่องมือในการส่งค่า loop ให้ class อื่นๆ หรือ activity อื่นๆ

    //Explicit ประกาศตัวแปร
    private Context context;                                            //Context คำสั่งให้พ่นค่าให้หน้าจออื่นๆ หรือ ท่อลำเลียง
    private int[] ints;                                                 //Ctl + spac จะพ่น ตัวแปร ints ให้ เก็บแหล่งกำเนิดของค่า
    private String[] nameString, detailStrings;                         // array[]




    public MyAdapter(Context context,
                     int[] ints,
                     String[] nameString,
                     String[] detailStrings) {
        this.context = context;
        this.ints = ints;
        this.nameString = nameString;
        this.detailStrings = detailStrings;
    }


    @Override
    public int getCount() {     // นับ loop row กี่รอบ
        return ints.length;     // นับเองตาม length = ints.length
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {            //Ctl + spac จะ auto ตัวแปรให้ i view viewGroup
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);         //layout เสมือน    Atl + Enter เพื่อ cast to
        View view1 = layoutInflater.inflate(R.layout.my_listview,viewGroup, false);

        // for image
        ImageView imageView = (ImageView) view1.findViewById(R.id.imageView);                                               // Atl + Enter เพื่อ cast to => (R.id.imageView)
        imageView.setImageResource(ints[i]);

        // for Textview 2
        TextView nameTextView = (TextView) view1.findViewById(R.id.textView2);
        nameTextView.setText(nameString[i]);

        // for textview 3
        TextView detailTextView = (TextView) view1.findViewById(R.id.textView3);
        detailTextView.setText(detailStrings[i]);



        return view1;
    }




}//Main class
