package Domain.Demography;

import java.util.Objects;

public class Race {

    private String raceId;
    private String raceName;

    Race(){

    }

    public String getRaceId(){
        return raceId;
    }

    public String getRaceName(){
        return raceName;
    }

    private Race(Builder builder){
        this.raceName = builder.raceName;
        this.raceId = builder.raceId;
    }

    public static class Builder{

        private String raceName;
        private String raceId;

        public Builder raceName(String raceName) {
            this.raceName = raceName;
            return this;
        }

        public Builder raceId(String raceId) {
            this.raceId = raceId;
            return this;
        }

        public Builder copy(Race course){
            this.raceId = course.raceId;
            this.raceName = course.raceName;

            return this;
        }

        public Race build() {
            return new Race(this);
        }

    }

    @Override
    public String toString() {
        return "Course{" +
                "raceId='" + raceId + '\'' +
                ", raceName='" + raceName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race course = (Race) o;
        return raceId.equals(course.raceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceId);
    }
}

