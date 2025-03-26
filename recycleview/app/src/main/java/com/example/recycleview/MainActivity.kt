package com.example.recycleview
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.recycleview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val lstName: ArrayList<String> = ArrayList<String>()
        lstName.add("Ty")
        lstName.add("Nam")
        lstName.add("Son")
        lstName.add("Hai")
        lstName.add("Thuy")
        binding.lstName.setBackgroundColor(Color.parseColor("#ffff00"))
        binding.lstName.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,
            lstName)
        binding.lstName.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, lstName[position].toString(),
                Toast.LENGTH_SHORT).show()
        }
        binding.btnAdd.setOnClickListener {
            lstName.add(binding.edtName.text.toString())
            binding.edtName.setText("")
            binding.edtName.requestFocus()
            binding.lstName.adapter = ArrayAdapter(this,
                android.R.layout.simple_list_item_1, lstName)
        }
    }
}
//Activity là màn hình mà người dùng tương tác trong một ứng dụng Android.
//
//Mỗi Activity đại diện cho một giao diện người dùng.
//Explicit Intent (Intent rõ ràng) dùng để chuyển từ Activity này sang Activity khác trong cùng một app.
//TextView	Hiển thị văn bản
//EditText	Ô nhập dữ liệu
//Button	Nút bấm
//ImageView	Hiển thị hình ảnh
//CheckBox, RadioButton, Switch, v.v	Tương tác lựa chọn
//LinearLayout	Xếp thẳng hàng (ngang hoặc dọc)
//RelativeLayout	Sắp xếp tương đối nhau
//ConstraintLayout	Sắp xếp theo ràng buộc (hiện đại, mạnh mẽ)
//FrameLayout	Chồng các View lên nhau
//ScrollView	Cho phép cuộn nội dung nếu quá dài
//android:id	Định danh duy nhất để truy cập từ code
//android:layout_width	Chiều rộng của View (match_parent, wrap_content, 100dp,...)
//android:layout_height	Chiều cao
//android:padding	Khoảng cách giữa nội dung và viền View
//android:margin	Khoảng cách giữa View với phần tử xung quanh
//android:text	Văn bản hiển thị (dành cho TextView, Button,...)
//android:textColor	Màu chữ
