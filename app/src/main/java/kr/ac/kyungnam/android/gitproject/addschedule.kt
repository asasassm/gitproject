package kr.ac.kyungnam.android.gitproject

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class addschedule : AppCompatActivity() {

   lateinit var sptextday : TextView
    lateinit var sptexttime : TextView

    lateinit var edtName : EditText
    lateinit var edtRoom : EditText
    lateinit var edtDay : Spinner
    lateinit var edtTime : Spinner

   lateinit var myHelper: myDBHelper
 lateinit var btninsert : Button
 lateinit var sqlDB : SQLiteDatabase
lateinit var btnback : Button
lateinit var btnreset : Button
lateinit var btndelete : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addschedule)
        title = "시간표 추가"

        sptextday = findViewById(R.id.sptextday)
        sptexttime = findViewById(R.id.sptexttime)
        edtName = findViewById(R.id.edtName)
        edtRoom=findViewById(R.id.edtRoom)
        edtDay = findViewById(R.id.edtDay)
        edtTime = findViewById(R.id.edttime)
        btnback = findViewById(R.id.btnback)
        btnreset = findViewById(R.id.btnreset)
        btninsert = findViewById(R.id.btninsert)
        btndelete = findViewById(R.id.btndelete)



        var day = R.array.day
        var time = R.array.time

        edtDay.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                p0: AdapterView<*>?,
                p1: View?,
                p2: Int,
                p3: Long
            ) {
                sptextday.text ="" +edtDay.selectedItem
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
        edtTime.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                p0: AdapterView<*>?,
                p1: View?,
                p2: Int,
                p3: Long
            ) {
                sptexttime.text ="" +edtTime.selectedItem
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }


        myHelper = myDBHelper(this)

        btnback.setOnClickListener{
            val intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }


        btninsert.setOnClickListener{
            sqlDB = myHelper.writableDatabase
            sqlDB.execSQL("INSERT INTO scheduleDB VALUES('"+ edtName.text.toString()+"','"+edtRoom.text.toString()+"','"+sptextday.text.toString()+"','"+sptexttime.text.toString()+ "');")
            sqlDB.close()
            Toast.makeText(applicationContext,"저장완료",Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
        btnreset.setOnClickListener{
            sqlDB = myHelper.writableDatabase
            myHelper.onUpgrade(sqlDB,1,2)
            sqlDB.close()

        }
        btndelete.setOnClickListener{

        }






    }

  class myDBHelper(context: Context) : SQLiteOpenHelper(context, "scheduleDB", null, 1) {

        override fun onCreate(p0: SQLiteDatabase?) {

            p0!!.execSQL("CREATE TABLE scheduleDB(ClassName CHAR(20) PRIMARY KEY ,ClassRoom CHAR(20),ClassDay CHAR(1),ClassTime CHAR(1));")
        }

        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
            p0!!.execSQL("DROP TABLE IF EXISTS scheduleDB")
            onCreate(p0)
        }
    }
}


