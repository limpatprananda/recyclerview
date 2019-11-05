package com.limpatprananda.plugin.recyclerview

import androidx.lifecycle.*

class MovieViewModel() : ViewModel(){
    private val _listMovies = MutableLiveData<List<Movie>>()
    val listMovies: LiveData<List<Movie>>
        get() = _listMovies

    val className = "MovieViewModel"

    init {
        _listMovies.value = listOf(
            Movie("Raising Arizona", 1987),
            Movie("Vampire's Kiss", 1988),
            Movie("Con Air", 1997),
            Movie("Gone in 60 Seconds", 1997),
            Movie("National Treasure", 2004),
            Movie("The Wicker Man", 2006),
            Movie("Ghost Rider", 2007),
            Movie("Knowing", 2009),
            Movie("Vampire's Kiss", 1988),
            Movie("Con Air", 1997),
            Movie("Gone in 60 Seconds", 1997),
            Movie("National Treasure", 2004),
            Movie("The Wicker Man", 2006),
            Movie("Ghost Rider", 2007),
            Movie("Vampire's Kiss", 1988),
            Movie("Con Air", 1997),
            Movie("Gone in 60 Seconds", 1997),
            Movie("National Treasure", 2004),
            Movie("The Wicker Man", 2006),
            Movie("Ghost Rider", 2007),
            Movie("Vampire's Kiss", 1988),
            Movie("Con Air", 1997),
            Movie("Gone in 60 Seconds", 1997),
            Movie("National Treasure", 2004),
            Movie("The Wicker Man", 2006),
            Movie("Ghost Rider", 2007)
        )
    }


    class Factory() : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(MovieViewModel::class.java)){
                return MovieViewModel() as T
            }
            throw IllegalArgumentException("Unable to construct MovieViewModel")
        }
    }
}

data class Movie(
    val title: String,
    val year: Int
)