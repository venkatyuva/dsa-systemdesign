package com.systemdesign.designpatterns.prototype;

public class Student implements Prototype<Student> {

    private String name;

    private int age;

    private int graduationYear;

    private String batchName;

    private double averageBatchPsp;

    public Student() {
    }

    public Student(Student student) {
        this.name = student.name;
        this.age = student.age;
        this.graduationYear = student.graduationYear;
        this.batchName = student.batchName;
        this.averageBatchPsp = student.averageBatchPsp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public void setAverageBatchPsp(double averageBatchPsp) {
        this.averageBatchPsp = averageBatchPsp;
    }

    @Override
    public Student copy() {
        return new Student(this);
    }
}
