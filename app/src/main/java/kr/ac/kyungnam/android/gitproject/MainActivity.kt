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




        btnadd = findViewById(R.id.btnadd)
        btnre = findViewById(R.id.btnre)

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
                setOf("???","A") -> {
                    mondayA.setText(cname.get(i))
                    mondayA.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","B") -> {
                    mondayB.setText(cname.get(i))
                    mondayB.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","C") -> {
                    mondayC.setText(cname.get(i))
                    mondayC.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","D") -> {
                    mondayD.setText(cname.get(i))
                    mondayD.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","E") -> {
                    mondayE.setText(cname.get(i))
                    mondayE.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","F") -> {
                    mondayF.setText(cname.get(i))
                    mondayF.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","G") -> {
                    mondayG.setText(cname.get(i))
                    mondayG.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","H") -> {
                    mondayH.setText(cname.get(i))
                    mondayH.setBackgroundResource(R.drawable.cell_shape_update)
                }

                setOf("???","A") -> {
                    tuesdayA.setText(cname.get(i))
                    tuesdayA.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","B") -> {
                    tuesdayB.setText(cname.get(i))
                    tuesdayB.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","C") -> {
                    tuesdayC.setText(cname.get(i))
                    tuesdayC.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","D") -> {
                    tuesdayD.setText(cname.get(i))
                    tuesdayD.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","E") -> {
                    tuesdayE.setText(cname.get(i))
                    tuesdayE.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","F") -> {
                    tuesdayF.setText(cname.get(i))
                    tuesdayF.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","G") -> {
                    tuesdayG.setText(cname.get(i))
                    tuesdayG.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","H") -> {
                    tuesdayH.setText(cname.get(i))
                    tuesdayH.setBackgroundResource(R.drawable.cell_shape_update)
                }

                setOf("???","A") -> {
                    wednesdayA.setText(cname.get(i))
                    wednesdayA.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","B") -> {
                    wednesdayB.setText(cname.get(i))
                    wednesdayB.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","C") -> {
                    wednesdayC.setText(cname.get(i))
                    wednesdayC.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","D") -> {
                    wednesdayD.setText(cname.get(i))
                    wednesdayD.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","E") -> {
                    wednesdayE.setText(cname.get(i))
                    wednesdayE.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","F") -> {
                    wednesdayF.setText(cname.get(i))
                    wednesdayF.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","G") -> {
                    wednesdayG.setText(cname.get(i))
                    wednesdayG.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","H") -> {
                    wednesdayH.setText(cname.get(i))
                    wednesdayH.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","A") -> {
                    thursdayA.setText(cname.get(i))
                    thursdayA.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","B") -> {
                    thursdayB.setText(cname.get(i))
                    thursdayB.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","C") -> {
                    thursdayC.setText(cname.get(i))
                    thursdayC.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","D") -> {
                    thursdayD.setText(cname.get(i))
                    thursdayD.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","E") -> {
                    thursdayE.setText(cname.get(i))
                    thursdayE.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","F") -> {
                    thursdayF.setText(cname.get(i))
                    thursdayF.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","G") -> {
                    thursdayG.setText(cname.get(i))
                    thursdayG.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","H") -> {
                    thursdayH.setText(cname.get(i))
                    thursdayH.setBackgroundResource(R.drawable.cell_shape_update)
                }

                setOf("???","A") -> {
                    fridayA.setText(cname.get(i))
                    fridayA.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","B") -> {
                    fridayB.setText(cname.get(i))
                    fridayB.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","C") -> {
                    fridayC.setText(cname.get(i))
                    fridayC.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","D") -> {
                    fridayD.setText(cname.get(i))
                    fridayD.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","E") -> {
                    fridayE.setText(cname.get(i))
                    fridayE.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","F") -> {
                    fridayF.setText(cname.get(i))
                    fridayF.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","G") -> {
                    fridayG.setText(cname.get(i))
                    fridayG.setBackgroundResource(R.drawable.cell_shape_update)
                }
                setOf("???","H") -> {
                    fridayH.setText(cname.get(i))
                    fridayH.setBackgroundResource(R.drawable.cell_shape_update)
                }
            }
            cnt = 0
        }





        btnadd.setOnClickListener {
            val intent = Intent(applicationContext, addschedule::class.java)
            startActivity(intent)
        }


        //????????? ??????
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
                    setOf("???","A") -> {
                        mondayA.setText(cname.get(i))
                        mondayA.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","B") -> {
                        mondayB.setText(cname.get(i))
                        mondayB.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","C") -> {
                        mondayC.setText(cname.get(i))
                        mondayC.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","D") -> {
                        mondayD.setText(cname.get(i))
                        mondayD.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","E") -> {
                        mondayE.setText(cname.get(i))
                        mondayE.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","F") -> {
                        mondayF.setText(cname.get(i))
                        mondayF.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","G") -> {
                        mondayG.setText(cname.get(i))
                        mondayG.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","H") -> {
                        mondayH.setText(cname.get(i))
                        mondayH.setBackgroundResource(R.drawable.cell_shape_update)
                    }

                    setOf("???","A") -> {
                        tuesdayA.setText(cname.get(i))
                        tuesdayA.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","B") -> {
                        tuesdayB.setText(cname.get(i))
                        tuesdayB.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","C") -> {
                        tuesdayC.setText(cname.get(i))
                        tuesdayC.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","D") -> {
                        tuesdayD.setText(cname.get(i))
                        tuesdayD.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","E") -> {
                        tuesdayE.setText(cname.get(i))
                        tuesdayE.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","F") -> {
                        tuesdayF.setText(cname.get(i))
                        tuesdayF.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","G") -> {
                        tuesdayG.setText(cname.get(i))
                        tuesdayG.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","H") -> {
                        tuesdayH.setText(cname.get(i))
                        tuesdayH.setBackgroundResource(R.drawable.cell_shape_update)
                    }

                    setOf("???","A") -> {
                        wednesdayA.setText(cname.get(i))
                        wednesdayA.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","B") -> {
                        wednesdayB.setText(cname.get(i))
                        wednesdayB.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","C") -> {
                        wednesdayC.setText(cname.get(i))
                        wednesdayC.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","D") -> {
                        wednesdayD.setText(cname.get(i))
                        wednesdayD.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","E") -> {
                        wednesdayE.setText(cname.get(i))
                        wednesdayE.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","F") -> {
                        wednesdayF.setText(cname.get(i))
                        wednesdayF.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","G") -> {
                        wednesdayG.setText(cname.get(i))
                        wednesdayG.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","H") -> {
                        wednesdayH.setText(cname.get(i))
                        wednesdayH.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","A") -> {
                        thursdayA.setText(cname.get(i))
                        thursdayA.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","B") -> {
                        thursdayB.setText(cname.get(i))
                        thursdayB.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","C") -> {
                        thursdayC.setText(cname.get(i))
                        thursdayC.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","D") -> {
                        thursdayD.setText(cname.get(i))
                        thursdayD.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","E") -> {
                        thursdayE.setText(cname.get(i))
                        thursdayE.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","F") -> {
                        thursdayF.setText(cname.get(i))
                        thursdayF.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","G") -> {
                        thursdayG.setText(cname.get(i))
                        thursdayG.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","H") -> {
                        thursdayH.setText(cname.get(i))
                        thursdayH.setBackgroundResource(R.drawable.cell_shape_update)
                    }

                    setOf("???","A") -> {
                        fridayA.setText(cname.get(i))
                        fridayA.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","B") -> {
                        fridayB.setText(cname.get(i))
                        fridayB.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","C") -> {
                        fridayC.setText(cname.get(i))
                        fridayC.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","D") -> {
                        fridayD.setText(cname.get(i))
                        fridayD.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","E") -> {
                        fridayE.setText(cname.get(i))
                        fridayE.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","F") -> {
                        fridayF.setText(cname.get(i))
                        fridayF.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","G") -> {
                        fridayG.setText(cname.get(i))
                        fridayG.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                    setOf("???","H") -> {
                        fridayH.setText(cname.get(i))
                        fridayH.setBackgroundResource(R.drawable.cell_shape_update)
                    }
                }
                cnt = 0
            }
            }


        }
    fun read(){

    }


    }










