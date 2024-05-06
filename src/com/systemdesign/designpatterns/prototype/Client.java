package com.systemdesign.designpatterns.prototype;

public class Client {

    private static void fillRegistry(StudentRegistry studentRegistry) {
        Student sept22StudentPrototype = new Student();
        sept22StudentPrototype.setBatchName("Sept22");
        sept22StudentPrototype.setAverageBatchPsp(95);
        studentRegistry.register("Sept22Student", sept22StudentPrototype);

        IntelligentStudent sept22IntelligentStudentPrototype = new IntelligentStudent();
        sept22IntelligentStudentPrototype.setBatchName("Sept22");
        sept22IntelligentStudentPrototype.setAverageBatchPsp(99);
        studentRegistry.register("Sept22IntelligentStudent", sept22IntelligentStudentPrototype);
    }

    public static void main(String[] args) {
        StudentRegistry registry = new StudentRegistry();
        fillRegistry(registry);

        Student venkat = registry.getPrototype("Sept22Student").copy();
        venkat.setName("venkat");
        venkat.setAge(27);
        venkat.setGraduationYear(2018);
        System.out.println(venkat);

        Student student = registry.getPrototype("Sept22Student").copy();
        student.setName("student");
        student.setAge(20);
        student.setGraduationYear(2019);
        System.out.println(student);

        IntelligentStudent intelligentStudent = (IntelligentStudent) registry.getPrototype("Sept22IntelligentStudent").copy();
        intelligentStudent.setName("Venkat");
        intelligentStudent.setAge(27);
        intelligentStudent.setGraduationYear(2018);
        intelligentStudent.setIq(100);
        System.out.println();
    }
}
