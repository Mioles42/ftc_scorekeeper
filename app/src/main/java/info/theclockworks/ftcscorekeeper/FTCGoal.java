package info.theclockworks.ftcscorekeeper;

import java.io.Serializable;

public class FTCGoal implements Serializable {

    private String name;
    private String filename;
    private int value;
    private int timesCanBeAccomplished;

    public FTCGoal() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setTimesCanBeAccomplished(int timesCanBeAccomplished) {
        this.timesCanBeAccomplished = timesCanBeAccomplished;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getName() {
        return name;
    }

    public String getFilename() {
        return filename;
    }

    public int getValue() {
        return value;
    }

    public int getTimesCanBeAccomplished() {
        return timesCanBeAccomplished;
    }

    public String toString() {
        return name + "(" + value + "pts)";
    }
}
