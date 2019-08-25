package Domain.Demography;

import java.util.Objects;

public class Gender {

    private String genderId;
    private String genderName;

    Gender(){

    }

    public String getGenderId(){
        return genderId;
    }

    public String getGenderName(){
        return genderName;
    }

    private Gender(Builder builder){
        this.genderName = builder.genderName;
        this.genderId = builder.genderId;
    }

    public static class Builder{

        private String genderName;
        private String genderId;

        public Builder genderName(String genderName) {
            this.genderName = genderName;
            return this;
        }

        public Builder genderId(String bayIdgenderId) {
            this.genderId = bayIdgenderId;
            return this;
        }

        public Builder copy(Gender course){
            this.genderId = course.genderId;
            this.genderName = course.genderName;

            return this;
        }

        public Gender build() {
            return new Gender(this);
        }

    }

    @Override
    public String toString() {
        return "Course{" +
                "genderId='" + genderId + '\'' +
                ", genderName='" + genderName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gender course = (Gender) o;
        return genderId.equals(course.genderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genderId);
    }
}