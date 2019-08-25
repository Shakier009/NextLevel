package Domain.User;

import java.util.Objects;

public class Employee {

    private String employeeId;
    private String employeeFirstName;
    private String employeeLastName;

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    Employee(){

    }

    private Employee(Builder builder){
        this.employeeId = builder.employeeId;
        this.employeeFirstName = builder.employeeFirstName;
        this.employeeLastName = builder.employeeLastName;
    }

    public static class Builder {

        private String employeeId;
        private String employeeFirstName;
        private String employeeLastName;

        public Builder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder employeeFirstName(String employeeFirstName) {
            this.employeeFirstName = employeeFirstName;
            return this;
        }

        public Builder employeeLastName(String employeeLastName) {
            this.employeeLastName = employeeLastName;
            return this;
        }


        public Builder copy(Employee course) {
            this.employeeId = course.employeeId;
            this.employeeFirstName = course.employeeFirstName;
            this.employeeLastName = course.employeeLastName;

            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

    @Override
    public String toString() {
        return "Course{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeLastName='" + employeeLastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee course = (Employee) o;
        return employeeId.equals(course.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

}

