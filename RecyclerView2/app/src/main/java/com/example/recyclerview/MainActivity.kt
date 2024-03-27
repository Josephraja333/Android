package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieList: ArrayList<Movie>
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rv)
        recyclerView.setHasFixedSize(true)

        recyclerView.layoutManager = LinearLayoutManager(this)
        movieList = ArrayList()

        movieList.add(Movie(R.drawable.one,"ONE"))
        movieList.add(Movie(R.drawable.two,"TWO"))
        movieList.add(Movie(R.drawable.three,"THREE"))
        movieList.add(Movie(R.drawable.four,"FOUR"))
        movieList.add(Movie(R.drawable.one,"ONE"))
        movieList.add(Movie(R.drawable.two,"TWO"))
        movieList.add(Movie(R.drawable.three,"THREE"))
        movieList.add(Movie(R.drawable.four,"FOUR"))

        movieAdapter = MovieAdapter(movieList)
        recyclerView.adapter = movieAdapter

    }
}