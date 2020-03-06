package th.ac.kku.cis.mobileapp.uiquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import th.ac.kku.cis.mobileapp.uiquiz.Adapter.MyListAdapter
import th.ac.kku.cis.mobileapp.uiquiz.Model.Student

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView: ListView = findViewById(R.id.listView)

        var student_list = mutableListOf<Student>()
        val get_student_name = resources.getStringArray(R.array.students60)
        val get_student_id = resources.getStringArray(R.array.student60_id)
        val numStudent = get_student_name.size

        for (i in 0..numStudent-1)
        {
            when (get_student_id[i]) {
                "603410063-8" -> student_list.add(Student(get_student_name[i],   get_student_id[i],   R.drawable.w  ))
                "603410070-1" -> student_list.add(Student(get_student_name[i],   get_student_id[i],   R.drawable.w  ))
                "603410155-3" -> student_list.add(Student(get_student_name[i],   get_student_id[i],   R.drawable.w  ))
                "603410289-2" -> student_list.add(Student(get_student_name[i],   get_student_id[i],   R.drawable.w  ))
                "603410156-1" -> student_list.add(Student(get_student_name[i],   get_student_id[i],   R.drawable.w  ))
                "603410204-6" -> student_list.add(Student(get_student_name[i],   get_student_id[i],   R.drawable.w  ))
                "603410219-3" -> student_list.add(Student(get_student_name[i],   get_student_id[i],   R.drawable.w  ))
                "603410221-6" -> student_list.add(Student(get_student_name[i],   get_student_id[i],   R.drawable.w  ))
                "603410291-5" -> student_list.add(Student(get_student_name[i],   get_student_id[i],   R.drawable.w  ))
                "603410321-2" -> student_list.add(Student(get_student_name[i],   get_student_id[i],   R.drawable.w  ))
                else -> student_list.add(Student(get_student_name[i],   get_student_id[i],   R.drawable.m  ))
            }

        }

        listView.adapter = MyListAdapter(
            this,
            R.layout.student_list,
            student_list
        )

//        listView.setOnItemClickListener{parent, view, position, id ->
//            val selectedItem = parent.getItemAtPosition(position) as Student
//            Toast.makeText(this,selectedItem.name,Toast.LENGTH_SHORT).show()
//        }

        listView.setOnItemClickListener { parent: AdapterView<*>, view: View, position:Int, id:Long ->
            val selectedItem = parent.getItemAtPosition(position) as Student
            val intent = Intent(this@MainActivity, Detail::class.java)
            intent.putExtra("_name",selectedItem.name)
            intent.putExtra("_id",selectedItem.id)
            startActivity(intent)
        }
    }
}
