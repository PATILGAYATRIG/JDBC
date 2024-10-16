package com.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.myapp.bean.Student;
import com.myapp.service.ConnectionOBJ;

public class StudentDao implements StudentDaos {
    Connection con = ConnectionOBJ.getCon();

    @Override
    public int updateRecord(int roll, float per) {
        int n = 0;
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE Students SET percentage=? WHERE roll_no=?");
            ps.setFloat(1, per);
            ps.setInt(2, roll);
            n = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int deleteRecord(int roll) {
        int n = 0;
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM Students WHERE roll_no=?");
            ps.setInt(1, roll);  // Fix the index here
            n = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int saveDate(Student s) {  // Changed to saveData instead of saveDate
        int n = 0;
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Students VALUES(?,?,?)");
            ps.setInt(1, s.getRoll());
            ps.setString(2, s.getName());
            ps.setFloat(3, s.getPer());
            n = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public Student fetchReocordByRno(int roll) {
        Student s = new Student();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Students WHERE roll_no=?");  // Correct table name
            ps.setInt(1, roll);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s.setName(rs.getString("name"));        // Use getString for VARCHAR
                s.setRoll(rs.getInt("roll_no"));        // Use getInt for INT
                s.setPer(rs.getFloat("percentage"));    // Use getFloat for DECIMAL
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public List<Student> fechAllData() {
        List<Student> list = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Students");  // Correct table name
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setRoll(rs.getInt("roll_no"));        // Fetch roll number
                s.setName(rs.getString("name"));        // Fetch name
                s.setPer(rs.getFloat("percentage"));    // Fetch percentage
                list.add(s);                            // Correctly add student to the list
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
