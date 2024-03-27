package com.example.latihan8pam121140197

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = <List(User(emptyList()))
        recyclerView.adapter = adapter

        // Mendapatkan data pengguna dari database Room
        Thread {
            val userDao = MyApp.database.userDao()
            val users = userDao.getAllUsers()
            runOnUiThread {
                adapter.setData(users)
            }
        }.start()
    }
}