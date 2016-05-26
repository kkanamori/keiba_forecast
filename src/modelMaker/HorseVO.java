package modelMaker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HorseVO {

    String raceNo; // レースNo
    String today; // 日付
    String dirtOrGlass; // ダートor芝
    String distance; // 距離
    String horseLimit; // 出走馬制限
    String horseLevel; // 出走馬レベル
    String order; // 着順
    String horseNo; // 番号
    String horseName; // 馬名
    String overallIndex; // 総合指数
    String jockey; // 騎手
    String difference; // 着差
    String thistimeIndex; // 今回指数
    String pase; // ペース
    String agari; // 上がり
    String popularity; // 人気
    String win; // 単勝
    String place; // 位置取

    public String getRaceNo() {
        return raceNo;
    }

    public void setRaceNo(String raceNo) {
        this.raceNo = raceNo;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
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

    public String getHorseLevel() {
        return horseLevel;
    }

    public void setHorseLevel(String horseLevel) {
        this.horseLevel = horseLevel;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getHorseNo() {
        return horseNo;
    }

    public void setHorseNo(String horseNo) {
        this.horseNo = horseNo;
    }

    public String getHorseName() {
        return horseName;
    }

    public void setHorseName(String horseName) {

        Pattern p = Pattern.compile("^[A-Z]");
        Matcher m = p.matcher(BigSmallString.toSmall(horseName));

        if (m.find()) {
            this.horseName = horseName.substring(1, horseName.length());
        } else {
            this.horseName = horseName;
        }
    }

    public String getOverallIndex() {
        return overallIndex;
    }

    public void setOverallIndex(String overallIndex) {
        this.overallIndex = overallIndex;
    }

    public String getJockey() {
        return jockey;
    }

    public void setJockey(String jockey) {
        this.jockey = jockey;
    }

    public String getDifference() {
        return difference;
    }

    public void setDifference(String difference) {
        this.difference = difference;
    }

    public String getThistimeIndex() {
        return thistimeIndex;
    }

    public void setThistimeIndex(String thistimeIndex) {
        this.thistimeIndex = thistimeIndex;
    }

    public String getPase() {
        return pase;
    }

    public void setPase(String pase) {
        this.pase = pase;
    }

    public String getAgari() {
        return agari;
    }

    public void setAgari(String agari) {
        this.agari = agari;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
//        return BigSmallString.toSmall(today + "," + raceNo + "," + dirtOrGlass
//                + "," + distance + "," + horseLimit + "," + horseLevel + ","
//                + order + "," + horseNo + "," + horseName + "," + overallIndex
//                + "," + jockey + "," + difference + "," + thistimeIndex + ","
//                + pase + "," + agari + "," + popularity + "," + win + ","
//                + place);
        return BigSmallString.toSmall(today + "," + raceNo + "," + dirtOrGlass
            + "," + distance + "," + horseLimit + "," + horseLevel + ","
            + "1" + "," + horseNo + "," + horseName + "," + "0"
            + "," + jockey + "," + "0" + "," + "0" + ","
            + "0" + "," + "0" + "," + "0" + "," + "0" + ","
            + "0");


    }

}
