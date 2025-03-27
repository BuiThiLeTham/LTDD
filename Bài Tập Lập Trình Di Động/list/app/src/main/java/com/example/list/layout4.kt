package com.example.list

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast

import com.example.list.databinding.Layout4Binding

class layout4  : AppCompatActivity(){
    lateinit var binding: Layout4Binding
// chưa gán giá trị cho binding ngay lập tức, nhg sẽ gán nó trước khi dùng
// lateinit dùng để khai báo biến chưa khởi tạo ngay, nhưng sẽ được khởi tạo sau đó, trước khi sử dụng.
// lateinit Không dùng được với: val, Kiểu nguyên thủy (Int, Double, Boolean, ...)

    //Layout4Binding là lớp (class) tự động được tạo ra bởi Android Studio khi bạn dùng View Binding với file XML có tên là layout4.xml.

//    @Suppress("DEPRECATION")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = Layout4Binding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)
//        binding.btnLogin.setOnClickListener {
//            val myIntent = Intent(this,layout5::class.java)
//            val fullname = binding.edtFullName.text.toString()
//            myIntent.putExtra("fullname",fullname)
//            //startActivity(myIntent)
//            startActivityForResult(myIntent,200)
//        }
//        binding.btnVKU.setOnClickListener {
//            val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://vku.udn.vn/"))
//            startActivity(myIntent)
//        }
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Layout4Binding.inflate(layoutInflater)  //Đây là cách bạn kết nối file XML layout4.xml với Kotlin code bằng View Binding.
        val view = binding.root  //Lấy view gốc (root view) từ layout đã binding, để hiển thị nó lên màn hình.
        setContentView(view)

        binding.btnLogin.setOnClickListener {                               //	Khi người dùng bấm nút Login
            val myIntent = Intent(this, layout5::class.java) //Chuẩn bị chuyển sang màn hình đăng nhập
            val  fullname = binding.edtFullName.text.toString()
            myIntent.putExtra("fullname", fullname)                  //Gửi tên người dùng sang màn hình kia

        startActivityForResult(myIntent,200)                    //200 là mã yêu cầu (requestCode) — bạn gán số gì cũng được, miễn là bạn nhận đúng lại mã này ở hàm onActivityResult.
        }

        binding.btnVKU.setOnClickListener {
            val  myIntent = Intent(Intent.ACTION_VIEW,Uri.parse("https://vku.udn.vn/"))
            startActivity(myIntent)
            //Intent.ACTION_VIEW	Ý định mở 1 nội dung (ở đây là URL)
            //Uri.parse("https://vku.udn.vn/")	Chuyển chuỗi URL thành kiểu Uri
            //startActivity(myIntent)	Yêu cầu hệ thống mở trình duyệt web với trang VKU
        }


    }
    @Suppress("DEPRECATION")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Toast.makeText(this,"Ok",Toast.LENGTH_SHORT).show()             //Hiển thị thông báo nhỏ "Ok" để báo người dùng biết là đã nhận được kết quả trả về.
        if(requestCode == 200){
            if(resultCode == Activity.RESULT_OK){
                binding.btnLogin.visibility = View.INVISIBLE
                binding.btnVKU.visibility = View.INVISIBLE
                val msg = data!!.extras!!.getString("msgStatus")
                binding.tvLoginInfo.text = msg
            }else{
                binding.btnLogin.visibility = View.INVISIBLE
                binding.btnVKU.visibility = View.INVISIBLE
                val msg = data!!.extras!!.getString("msgStatus")
                binding.tvLoginInfo.text = msg
            }
        }
    }
}

