package modelMaker;

public class RaceVO {
    String raceNo;
    String dirtOrGlass;
    String horseLimit;
    String distance;
    String horseLevel;
    public String getHorseLevel() {
        return horseLevel;
    }
    public void setHorseLevel(String horseLevel) {

        this.horseLevel = horseLevel;
    }
    public String getRaceNo() {
        return raceNo;
    }
    public void setRaceNo(String raceNo) {
        this.raceNo = raceNo;
    }
    public String getDirtOrGlass() {
        return dirtOrGlass;
    }
    public void setDirtOrGlass(String dirtOrGlass) {
        this.dirtOrGlass = dirtOrGlass;
    }
    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
    public String getHorseLimit() {
        return horseLimit;
    }
    public void setHorseLimit(String horseLimit) {
        this.horseLimit = horseLimit;
    }
}
