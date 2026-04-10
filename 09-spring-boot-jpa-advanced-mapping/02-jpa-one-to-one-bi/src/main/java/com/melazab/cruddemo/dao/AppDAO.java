package com.melazab.cruddemo.dao;

import com.melazab.cruddemo.entity.Instructor;
import com.melazab.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById (int theId);
    void deleteInstructorById(int theId);
    InstructorDetail findInstructorDetailById(int theId);
}
