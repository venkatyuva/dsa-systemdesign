package com.systemdesign.designpatterns.builder;

public class Client {

    public static void main(String[] args) {
        Student student = Student.getBuilder()
                .name("Venkatesh")
                .age(27)
                .graduationYear(2018)
                .psp(95)
                .batchName("September2022")
                .build();
        System.out.println(student);
    }
}
