package lab5;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "alarm", schema = "main")
public class Translation {
    private int id;
    private int hours;
    private int minutes;
    private int seconds;

    public Translation() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "hours")
    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Basic
    @Column(name = "minutes")
    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @Basic
    @Column(name = "seconds")
    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public Translation(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Translation alarm = (Translation) o;
        return hours == alarm.hours && minutes == alarm.minutes && seconds == alarm.seconds && Objects.equals(id, alarm.id);
    }


}
