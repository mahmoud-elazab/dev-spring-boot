package com.melazab.cruddemo.dao;

import com.melazab.cruddemo.entity.Instructor;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById (int theId);
}
