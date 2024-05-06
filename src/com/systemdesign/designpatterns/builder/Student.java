package com.systemdesign.designpatterns.builder;

public class Student {

    private String name;

    private int age;

    private double psp;

    private int graduationYear;

    private String batchName;

    private Student() {
    }

    private Student(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.batchName = builder.batchName;
        this.graduationYear = builder.graduationYear;
        this.psp = builder.psp;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    static class Builder {
        private String name;

        private int age;

        private double psp;

        private int graduationYear;

        private String batchName;

        private Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder psp(double psp) {
            this.psp = psp;
            return this;
        }

        public Builder graduationYear(int graduationYear) {
            this.graduationYear = graduationYear;
            return this;
        }

        public Builder batchName(String batchName) {
            this.batchName = batchName;
            return this;
        }

        public Student build() {
            if (this.graduationYear > 2022) {
                throw new IllegalArgumentException("Graduation year should not be greater than 2022");
            }
            return new Student(this);
        }
    }
}
