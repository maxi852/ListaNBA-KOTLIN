package com.example.listanba

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recView: RecyclerView
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recView= findViewById(R.id.Rec_Nba)
        recView.layoutManager= LinearLayoutManager(this)
        val dataSet = getListadoNba()
        adapter=Adapter(applicationContext)
        recView.adapter=adapter
        adapter.submitList(dataSet)
        adapter.onItemClickListener = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name",it.name)
            intent.putExtra("logo",it.logo)
            startActivity(intent)
        }
    }

    private fun getListadoNba(): MutableList<Nba>? {
        return mutableListOf(
            Nba(1,"Celtics","Boston Garden",17,Conferencias.ESTE,"https://upload.wikimedia.org/wikipedia/en/thumb/8/8f/Boston_Celtics.svg/190px-Boston_Celtics.svg.png"),
            Nba(2,"Knicks","Madison Square Garden",4,Conferencias.ESTE,"https://upload.wikimedia.org/wikipedia/en/thumb/2/25/New_York_Knicks_logo.svg/240px-New_York_Knicks_logo.svg.png"),
            Nba(3,"Bucks","Fiserv Forum",23,Conferencias.ESTE,"https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Cleveland_Cavaliers_secondary_logo.svg/117px-Cleveland_Cavaliers_secondary_logo.svg.png"),
            Nba(4,"Cavaliers","Rocket Mortgage",1,Conferencias.ESTE,"https://upload.wikimedia.org/wikipedia/en/thumb/8/8f/Boston_Celtics.svg/190px-Boston_Celtics.svg.png"),
            Nba(5,"Pacers","Gainbridge Fieldhouse",17,Conferencias.ESTE,"https://upload.wikimedia.org/wikipedia/en/thumb/1/1b/Indiana_Pacers.svg/200px-Indiana_Pacers.svg.png"),
            Nba(6,"Thunder","Paycom Center",17,Conferencias.OESTE,"https://upload.wikimedia.org/wikipedia/en/thumb/5/5d/Oklahoma_City_Thunder.svg/200px-Oklahoma_City_Thunder.svg.png"),
            Nba(7,"Nuggets","Ball Arena",1,Conferencias.OESTE,"https://upload.wikimedia.org/wikipedia/en/thumb/7/76/Denver_Nuggets.svg/200px-Denver_Nuggets.svg.png"),
            Nba(8,"Timberwolves","Target Center",0,Conferencias.OESTE,"https://upload.wikimedia.org/wikipedia/en/thumb/c/c2/Minnesota_Timberwolves_logo.svg/200px-Minnesota_Timberwolves_logo.svg.png"),
            Nba(9,"Clippers","Crypto.com Arena",0,Conferencias.OESTE,"https://upload.wikimedia.org/wikipedia/en/thumb/b/bb/Los_Angeles_Clippers_%282015%29.svg/220px-Los_Angeles_Clippers_%282015%29.svg.png"),
            Nba(10,"Mavericks","American Airlines Center",1,Conferencias.OESTE,"https://upload.wikimedia.org/wikipedia/en/thumb/9/97/Dallas_Mavericks_logo.svg/210px-Dallas_Mavericks_logo.svg.png"),

        )
    }
}