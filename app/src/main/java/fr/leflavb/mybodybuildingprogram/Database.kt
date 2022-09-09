package fr.leflavb.mybodybuildingprogram

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import fr.leflavb.mybodybuildingprogram.Database.Singleton.databaseRef
import fr.leflavb.mybodybuildingprogram.Database.Singleton.exercisesList

class Database {

    object Singleton {
        // connect to reference "exercises"
        val databaseRef = FirebaseDatabase.getInstance().getReference("exercises")

        // list of exercises
        val exercisesList = arrayListOf<ExerciseModel>()
    }

    fun updateData(callback: () -> Unit) {
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                exercisesList.clear()
                // collect the list
                for (ds in snapshot.children) {
                    //build a exercise object
                    val exercise = ds.getValue(ExerciseModel::class.java)

                    if (exercise != null) {
                        exercisesList.add(exercise)
                    }
                }
                callback()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    fun updateExercise(exercise: ExerciseModel) {

    }

}