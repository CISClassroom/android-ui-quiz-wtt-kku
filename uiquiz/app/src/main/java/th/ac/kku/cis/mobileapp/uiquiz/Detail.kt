package th.ac.kku.cis.mobileapp.uiquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_detail.*

class Detail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var intent = intent

        val get_name = intent.getStringExtra("_name")
        val get_id = intent.getStringExtra("_id")

        val studentname = findViewById<TextView>(R.id.tx_name)
        val studentid = findViewById<TextView>(R.id.tx_id)

        studentname.text = get_name
        studentid.text = get_id

        btn_save.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
