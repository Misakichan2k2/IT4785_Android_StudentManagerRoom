package com.example.studentmanagerfragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.studentmanagerfragment.models.StudentDatabase
import com.example.studentmanagerfragment.models.StudentEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentViewModel(application: Application) : AndroidViewModel(application) {
    private val studentDao = StudentDatabase.getDatabase(application).studentDao()
    val students: LiveData<List<StudentEntity>> = studentDao.getAllStudents()

    fun saveStudent(student: StudentEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            studentDao.insertStudent(student)
        }
    }

    fun deleteStudent(student: StudentEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            studentDao.deleteStudent(student)
        }
    }
}
