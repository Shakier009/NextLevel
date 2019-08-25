package Domain.User;

import java.util.Objects;

public class EmployeeGender {

    private String genderId;
    private String employeeId;

    public String getGenderId() {
        return genderId;
    }

    public String geteEmployeeId() {
        return employeeId;
    }

    EmployeeGender(){

    }

    private EmployeeGender(Builder builder){
        this.employeeId = builder.employeeId;
        this.genderId = builder.genderId;
    }

    public static class Builder {

        private String employeeId;
        private String genderId;

        public Builder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder genderId(String genderId) {
            this.genderId = genderId;
            return this;
        }

        public Builder copy(EmployeeGender course) {
            this.employeeId = course.employeeId;
            this.genderId = course.genderId;

            return this;
        }

        public EmployeeGender build() {
            return new EmployeeGender(this);
        }
    }

    @Override
    public String toString() {
        return "Course{" +
                "employeeId='" + employeeId + '\'' +
                ", genderId='" + genderId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeGender course = (EmployeeGender) o;
        return employeeId.equals(course.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

}


