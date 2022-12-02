package kr.ac.kyungnam.android.gitproject

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TableLayout
import android.widget.TextView
import androidx.room.Room
import kr.ac.kyungnam.android.gitproject.addschedule.myDBHelper
import java.time.DayOfWeek

class MainActivity : AppCompatActivity() {


    lateinit var myHelper: myDBHelper
    lateinit var sqlDB : SQLiteDatabase
lateinit var btnadd : Button
lateinit var btnre :Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myHelper = myDBHelper(this)
        sqlDB = myHelper.writableDatabase

        var text1 = findViewById<TextView>(R.id.wednesdayA)

        var mondayA = findViewById<TextView>(R.id.mondayA)
        var tuesdayA = findViewById<TextView>(R.id.tuesdayA)
        var wednesdayA = findViewById<TextView>(R.id.wednesdayA)
        var thursdayA = findViewById<TextView>(R.id.thursdayA)
        var fridayA = findViewById<TextView>(R.id.fridayA)

        var mondayB = findViewById<TextView>(R.id.mondayB)
        var tuesdayB = findViewById<TextView>(R.id.tuesdayB)
        var wednesdayB = findViewById<TextView>(R.id.wednesdayB)
        var thursdayB = findViewById<TextView>(R.id.thursdayB)
        var fridayB = findViewById<TextView>(R.id.fridayB)

        var mondayC = findViewById<TextView>(R.id.mondayC)
        var tuesdayC = findViewById<TextView>(R.id.tuesdayC)
        var wednesdayC = findViewById<TextView>(R.id.wednesdayC)
        var thursdayC = findViewById<TextView>(R.id.thursdayC)
        var fridayC = findViewById<TextView>(R.id.fridayC)

        var mondayD = findViewById<TextView>(R.id.mondayD)
        var tuesdayD = findViewById<TextView>(R.id.tuesdayD)
        var wednesdayD = findViewById<TextView>(R.id.wednesdayD)
        var thursdayD = findViewById<TextView>(R.id.thursdayD)
        var fridayD = findViewById<TextView>(R.id.fridayD)

        var mondayE = findViewById<TextView>(R.id.mondayE)
        var tuesdayE = findViewById<TextView>(R.id.tuesdayE)
        var wednesdayE = findViewById<TextView>(R.id.wednesdayE)
        var thursdayE = findViewById<TextView>(R.id.thursdayE)
        var fridayE = findViewById<TextView>(R.id.fridayE)

        var mondayF = findViewById<TextView>(R.id.mondayF)
        var tuesdayF = findViewById<TextView>(R.id.tuesdayF)
        var wednesdayF = findViewById<TextView>(R.id.wednesdayF)
        var thursdayF = findViewById<TextView>(R.id.thursdayF)
        var fridayF = findViewById<TextView>(R.id.fridayF)

        var mondayG = findViewById<TextView>(R.id.mondayG)
        var tuesdayG = findViewById<TextView>(R.id.tuesdayG)
        var wednesdayG = findViewById<TextView>(R.id.wednesdayG)
        var thursdayG = findViewById<TextView>(R.id.thursdayG)
        var fridayG = findViewById<TextView>(R.id.fridayG)

        var mondayH = findViewById<TextView>(R.id.mondayH)
        var tuesdayH = findViewById<TextView>(R.id.tuesdayH)
        var wednesdayH = findViewById<TextView>(R.id.wednesdayH)
        var thursdayH = findViewById<TextView>(R.id.thursdayH)
        var fridayH = findViewById<TextView>(R.id.fridayH)



        //var monday = arrayOf(R.id.mondayA,R.id.mondayB,R.id.mondayC,R.id.mondayD,R.id.mondayE,R.id.mondayF,R.id.mondayG,R.id.mondayH)
      //  var tuesday = arrayOf(R.id.tuesdayA,R.id.tuesdayB,R.id.tuesdayC,R.id.tuesdayD,R.id.tuesdayE,R.id.tuesdayF,R.id.tuesdayG,R.id.tuesdayH)
       // var wednesday = arrayOf(R.id.wednesdayA,R.id.wednesdayB,R.id.wednesdayC,R.id.wednesdayD,R.id.wednesdayE,R.id.wednesdayF,R.id.wednesdayG,R.id.wednesdayH)
       // var thursday = arrayOf(R.id.thursdayA,R.id.thursdayB,R.id.thursdayC,R.id.thursdayD,R.id.thursdayE,R.id.thursdayF,R.id.thursdayG,R.id.thursdayH)
      //  var friday = arrayOf(R.id.fridayA,R.id.fridayB,R.id.fridayC,R.id.fridayD,R.id.fridayE,R.id.fridayF,R.id.fridayG,R.id.fridayH)

        btnadd = findViewById(R.id.btnadd)
        btnre = findViewById(R.id.btnre)
        btnadd.setOnClickListener{
            val intent = Intent(applicationContext,addschedule::class.java)
            startActivity(intent)
        }
        btnre.setOnClickListener{
            sqlDB = myHelper.readableDatabase
           // var list = mutableListOf<schedullist>()
            var a = "A"
            var cursor: Cursor
            var name ="\r\n"
            var room1 ="\r\n"
            var weeks ="\r\n"
            var time1 ="\r\n"
            cursor = sqlDB.rawQuery("SELECT * FROM scheduleDB;",null)
            while(cursor.moveToNext()){
                name +=cursor.getString(0)+"\r\n"
                room1 +=cursor.getString(1)+"\r\n"
                weeks +=cursor.getString(2)+"\r\n"
                time1 +=cursor.getString(3)+"\r\n"


            }
            if(name == "aaa"){
                mondayA.setText(name)
            }
          //  list.add(schedullist(name,room1,weeks,time1))


            cursor.close()
            sqlDB.close()
        }

    }
}

//class schedullist(var ClassName:String?,var ClassRoom:String,var ClassDay:String,var ClassTime:String)





