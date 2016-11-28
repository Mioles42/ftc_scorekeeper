package info.theclockworks.ftcscorekeeper;

import java.io.Serializable;

/*
 * FTCScoreLog
 * Whenever a Match is scored, four different FTCScoreLogs are created, one for each
 * team in the match.
 * The set of recordedGoals is dependent on what goals (or goal sets) the
 *
 */
public class FTCScoreLog implements Serializable {

    // Information identifying the team that the log belongs to.
    private int teamNumber;
    private String teamName;
    private FTCGoal[] recordedGoals;
    private int[] timesAccomplished;



    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public FTCGoal[] getRecordedGoals() {
        return recordedGoals;
    }

    public void setRecordedGoals(FTCGoal[] recordedGoals) {
        this.recordedGoals = recordedGoals;
    }

    public int[] getTimesAccomplished() {
        return timesAccomplished;
    }

    public void setTimesAccomplished(int[] timesAccomplished) {
        this.timesAccomplished = timesAccomplished;
    }
}
