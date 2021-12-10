package com.treech.custom.viewstudy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.treech.custom.viewstudy.view.NetView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val netView: NetView = findViewById(R.id.net_view);
        netView.addData("技能 A", 0.8f)
        netView.addData("技能 B", 0.6f)
        netView.addData("技能 C", 0.8f)
        netView.addData("技能 D", 0.6f)
        netView.addData("技能 E", 0.8f)
        netView.addData("技能 F", 0.2f)

        val map = HashMap<Int,Boolean?>()

        map[1].let {
            map[1] = true
        }
        map[2].let {
            map[2] = true
        }
        println(map)
    }
}