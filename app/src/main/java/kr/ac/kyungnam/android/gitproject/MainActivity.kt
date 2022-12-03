package kr.ac.kyungnam.android.gitproject

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.room.Room
import kr.ac.kyungnam.android.gitproject.addschedule.myDBHelper
import java.time.DayOfWeek

class MainActivity : AppCompatActivity() {


    lateinit var myHelper: myDBHelper
    lateinit var sqlDB: SQLiteDatabase
    lateinit var btnadd: Button
    lateinit var btnre: Button


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
        btnadd.setOnClickListener {
            val intent = Intent(applicationContext, addschedule::class.java)
            startActivity(intent)
        }


        //여기서 문제
        btnre.setOnClickListener {
            sqlDB = myHelper.readableDatabase

            var cursor: Cursor
            var cname = mutableListOf<String>()
                  var croom = mutableListOf<String>()
                  var cweek = mutableListOf<String>()
                  var ctime =mutableListOf<String>()
                  var recnt =0
                  cursor = sqlDB.rawQuery("SELECT * FROM scheduleDB;", null)

                  var cnt =0
            while (cursor.moveToNext()) {
                cname += cursor.getString(0)
                croom += cursor.getString(1)
                cweek += cursor.getString(2)
                ctime += cursor.getString(3)
                recnt= cnt++
            }
                cursor.close()
                sqlDB.close()
                  for(i in 0..recnt){
                      when(setOf(cweek.get(i),ctime.get(i))){
                          setOf("월","A") -> {
                              mondayA.setText(cname.get(i)+"\n"+croom.get(i))
                              mondayA.setBackgroundResource(R.drawable.cell_shape_update)
                          }
                          setOf("월","B") -> {
                              mondayB.setText(cname.get(i)+"\n"+croom.get(i))
                              mondayB.setBackgroundResource(R.drawable.cell_shape_update)
                          }
                          setOf("월","C") -> {
                              mondayC.setText(cname.get(i)+"\n"+croom.get(i))
                              mondayC.setBackgroundResource(R.drawable.cell_shape_update)
                          }
                          setOf("월","D") -> {
                              mondayD.setText(cname.get(i)+"\n"+croom.get(i))
                              mondayD.setBackgroundResource(R.drawable.cell_shape_update)
                          }
                          setOf("월","E") -> {
                              mondayE.setText(cname.get(i)+"\n"+croom.get(i))
                              mondayE.setBackgroundResource(R.drawable.cell_shape_update)
                          }
                          setOf("월","F") -> {
                              mondayF.setText(cname.get(i)+"\n"+croom.get(i))
                              mondayF.setBackgroundResource(R.drawable.cell_shape_update)
                          }
                          setOf("월","G") -> {
                              mondayG.setText(cname.get(i)+"\n"+croom.get(i))
                              mondayG.setBackgroundResource(R.drawable.cell_shape_update)
                          }
                          setOf("월","H") -> {
                              mondayH.setText(cname.get(i)+"\n"+croom.get(i))
                              mondayH.setBackgroundResource(R.drawable.cell_shape_update)
                          }

                          setOf("화","A") -> {
                              tuesdayA.setText(cname.get(i)+"\n"+croom.get(i))
                              tuesdayA.setBackgroundResource(R.drawable.cell_shape_update)
                          }
                          setOf("화","B") -> {
                              tuesdayB.setText(cname.get(i)+"\n"+croom.get(i))
                              tuesdayB.setBackgroundResource(R.drawable.cell_shape_update)
                          }
                          setOf("화","C") -> {
                              tuesdayC.setText(cname.get(i)+"\n"+croom.get(i))
                              tuesdayC.setBackgroundResource(R.drawable.cell_shape_update)
                          }
                          setOf("화","D") -> {
                              tuesdayD.setText(cname.get(i)+"\n"+croom.get(i))
                              tuesdayD.setBackgroundResource(R.drawable.cell_shape_update)
                          }
                          setOf("화","E") -> {
                              tuesdayE.setText(cname.get(i)+"\n"+croom.get(i))
                              tuesdayE.setBackgroundResource(R.drawable.cell_shape_update)
                          }
                          setOf("화","F") -> {
                              tuesdayF.setText(cname.get(i)+"\n"+croom.get(i))
                              tuesdayF.setBackgroundResource(R.drawable.cell_shape_update)
                          }
                          setOf("화","G") -> {
                              tuesdayG.setText(cname.get(i)+"\n"+croom.get(i))
                              tuesdayG.setBackgroundResource(R.drawable.cell_shape_update)
                          }
                          setOf("화","H") -> {
                              tuesdayH.setText(cname.get(i)+"\n"+croom.get(i))
                              tuesdayH.setBackgroundResource(R.drawable.cell_shape_update)
                          }

                          setOf("수","A") -> {
                              wednesdayA.setText(cname.get(i)+"\n"+croom.get(i))
                              wednesdayA.setBackgroundResource(R.drawable.cell_shape_update)
                          }
                          setOf("수","B") -> {
                              wednesdayB.setText(cname.get(i)+"\n"+croom.get(i))
                              wednesdayB.setBackgroundResource(R.drawable.cell_shape_update)
                          }
                          setOf("수","C") -> {
                              wednesdayC.setText(cname.get(i)+"\n"+croom.get(i))
                              wednesdayC.setBackgroundResource(R.drawable.cell_shape_update)
                          }
                          setOf("수","D") -> {
                              wednesdayD.setText(cname.get(i)+"\n"+croom.get(i))
                              wednesdayD.setBackgroundResource(R.drawable.cell_shape_update)
                          }
                          setOf("수","E") -> {
                              wednesdayE.setText(cname.get(i)+"\n"+croom.get(i))
                              wednesdayE.setBackgroundResource(R.drawable.cell_shape_update)
                          }
                          setOf("수","F") -> {
                              wednesdayF.setText(cname.get(i)+"\n"+croom.get(i))
                              wednesdayF.setBackgroundResource(R.drawable.cell_shape_update)
                          }
                          setOf("수","G") -> {
                              wednesdayG.setText(cname.get(i)+"\n"+croom.get(i))
                              wednesdayG.setBackgroundResource(R.drawable.cell_shape_update)
                          }
                          setOf("수","H") -> {
                              wednesdayH.setText(cname.get(i)+"\n"+croom.get(i))
                              wednesdayH.setBackgroundResource(R.drawable.cell_shape_update)
                          }

                          setOf("목","A") -> {
                              thursdayA.setText(cname.get(i)+"\n"+croom.get(i))
                              thursdayA.setBackgroundResource(R.drawable.cell_shape_update)
                          }
                          setOf("목","B") -> {
                              thursdayB.setText(cname.get(i)+"\n"+croom.get(i))
                              thursdayB.setBackgroundResource(R.drawable.cell_shape_update)

                          }
                          setOf("목","C") -> {
                              thursdayC.setText(cname.get(i)+"\n"+croom.get(i))
                              thursdayC.setBackgroundResource(R.drawable.cell_shape_update)

                          }
                          setOf("목","D") -> {
                              thursdayD.setText(cname.get(i)+"\n"+croom.get(i))
                              thursdayD.setBackgroundResource(R.drawable.cell_shape_update)

                          }
                          setOf("목","E") -> {
                              thursdayE.setText(cname.get(i)+"\n"+croom.get(i))
                              thursdayE.setBackgroundResource(R.drawable.cell_shape_update)

                          }
                          setOf("목","F") -> {
                              thursdayF.setText(cname.get(i)+"\n"+croom.get(i))
                              thursdayF.setBackgroundResource(R.drawable.cell_shape_update)

                          }
                          setOf("목","G") -> {
                              thursdayG.setText(cname.get(i)+"\n"+croom.get(i))
                              thursdayG.setBackgroundResource(R.drawable.cell_shape_update)

                          }
                          setOf("목","H") -> {
                              thursdayH.setText(cname.get(i)+"\n"+croom.get(i))
                              thursdayH.setBackgroundResource(R.drawable.cell_shape_update)

                          }

                          setOf("금","A") -> {
                              fridayA.setText(cname.get(i)+"\n"+croom.get(i))
                              fridayA.setBackgroundResource(R.drawable.cell_shape_update)

                          }
                          setOf("금","B") -> {
                              fridayB.setText(cname.get(i)+"\n"+croom.get(i))
                              fridayB.setBackgroundResource(R.drawable.cell_shape_update)

                          }
                          setOf("금","C") -> {
                              fridayC.setText(cname.get(i)+"\n"+croom.get(i))
                              fridayC.setBackgroundResource(R.drawable.cell_shape_update)

                          }
                          setOf("금","D") -> {
                              fridayD.setText(cname.get(i)+"\n"+croom.get(i))
                              fridayD.setBackgroundResource(R.drawable.cell_shape_update)

                          }
                          setOf("금","E") -> {
                              fridayE.setText(cname.get(i)+"\n"+croom.get(i))
                              fridayE.setBackgroundResource(R.drawable.cell_shape_update)

                          }
                          setOf("금","F") -> {
                              fridayF.setText(cname.get(i)+"\n"+croom.get(i))
                              fridayF.setBackgroundResource(R.drawable.cell_shape_update)

                          }
                          setOf("금","G") -> {
                              fridayG.setText(cname.get(i)+"\n"+croom.get(i))
                              fridayG.setBackgroundResource(R.drawable.cell_shape_update)

                          }
                          setOf("금","H") -> {
                              fridayH.setText(cname.get(i)+"\n"+croom.get(i))
                              fridayH.setBackgroundResource(R.drawable.cell_shape_update)

                          }

                      }
                        cnt = 0
                  }

            }

        }


    }










