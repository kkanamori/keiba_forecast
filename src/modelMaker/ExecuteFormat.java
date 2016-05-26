package modelMaker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExecuteFormat {

	static final String INPUT_DIR = "dataSample/";

	static final String OUTPUT_DIR = "result/result.csv/";

    public static void main(String[] args) throws IOException {
        File dir = new File("INPUT_DIR");

        File resultFile = new File("OUTPUT_DIR");
        FileWriter fw = new FileWriter(resultFile, true);
        BufferedWriter bw = new BufferedWriter(fw);

        readFolder(dir, bw);

        bw.close();
        fw.close();

    }

    private static void execute(File file, BufferedWriter bw)
            throws IOException {
        FileInputStream in = null;
        Workbook wb = null;

        try {
            in = new FileInputStream(file);
            wb = WorkbookFactory.create(in);
        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (InvalidFormatException e) {
            System.out.println(e.toString());
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }

        // シートを取得
        Sheet sheet = wb.getSheetAt(0);
        String nowCell;
        String today = "";

        RaceVO[] race = new RaceVO[12];
        for (int i = 0; i < 12; i++) {
            race[i] = new RaceVO();
        }

        HorseVO[] horse = new HorseVO[18 * 12];
        for (int i = 0; i < 18 * 12; i++) {
            horse[i] = new HorseVO();
        }

        for (int i = 0; i < 76; i++) {
            Row row = sheet.getRow(i);

            for (int j = 0; j < 48; j++) {
                // セルの内容がnull以外の場合に出力
                if (row.getCell(j) != null) {
                    // 現在処理中のセル
                    nowCell = row.getCell(j).getStringCellValue();

                    if (nowCell != "") {
                        // 日付の取得
                        if (i == 0 && j == 0) {
                            today = "20" + nowCell.substring(0, 2) + "/"
                                    + nowCell.substring(3, 5) + "/"
                                    + nowCell.substring(6, 8);
                        }

                        // Round、ダート/芝、距離、出走馬制限、を取得（レース情報）
                        // R1
                        if (i == 1 && j == 0) {
                            getRaceInfo(nowCell, race[0]);
                        }
                        if (i == 1 && j == 7) {
                            getHorseLevel(nowCell, race[0]);
                        }

                        // R2
                        if (i == 26 && j == 0) {
                            getRaceInfo(nowCell, race[1]);
                        }
                        if (i == 26 && j == 7) {
                            getHorseLevel(nowCell, race[1]);
                        }

                        // R3
                        if (i == 51 && j == 0) {
                            getRaceInfo(nowCell, race[2]);
                        }
                        if (i == 51 && j == 7) {
                            getHorseLevel(nowCell, race[2]);
                        }

                        // R4
                        if (i == 1 && j == 12) {
                            getRaceInfo(nowCell, race[3]);
                        }
                        if (i == 1 && j == 19) {
                            getHorseLevel(nowCell, race[3]);
                        }

                        // R5
                        if (i == 26 && j == 12) {
                            getRaceInfo(nowCell, race[4]);
                        }
                        if (i == 26 && j == 19) {
                            getHorseLevel(nowCell, race[4]);
                        }

                        // R6
                        if (i == 51 && j == 12) {
                            getRaceInfo(nowCell, race[5]);
                        }
                        if (i == 51 && j == 19) {
                            getHorseLevel(nowCell, race[5]);
                        }

                        // R7
                        if (i == 1 && j == 24) {
                            getRaceInfo(nowCell, race[6]);
                        }
                        if (i == 1 && j == 31) {
                            getHorseLevel(nowCell, race[6]);
                        }

                        // R8
                        if (i == 26 && j == 24) {
                            getRaceInfo(nowCell, race[7]);
                        }
                        if (i == 26 && j == 31) {
                            getHorseLevel(nowCell, race[7]);
                        }

                        // R9
                        if (i == 51 && j == 24) {
                            getRaceInfo(nowCell, race[8]);
                        }
                        if (i == 51 && j == 31) {
                            getHorseLevel(nowCell, race[8]);
                        }

                        // R10
                        if (i == 1 && j == 36) {
                            getRaceInfo(nowCell, race[9]);
                        }
                        if (i == 1 && j == 43) {
                            getHorseLevel(nowCell, race[9]);
                        }

                        // R11
                        if (i == 26 && j == 36) {
                            getRaceInfo(nowCell, race[10]);
                        }
                        if (i == 26 && j == 43) {
                            getHorseLevel(nowCell, race[10]);
                        }

                        // R12
                        if (i == 51 && j == 36) {
                            getRaceInfo(nowCell, race[11]);
                        }
                        if (i == 51 && j == 43) {
                            getHorseLevel(nowCell, race[11]);
                        }

                        // 着順、番号、馬名、総合指数、騎手、着差、今回指数、ペース、上がり、人気、単勝、位置取りを取得
                        if (i >= 4 && i <= 21) {
                            // 1R
                            if (j == 0) {
                                horse[i - 4].setOrder(nowCell);
                            }
                            if (j == 1) {
                                horse[i - 4].setHorseNo(nowCell);
                            }
                            if (j == 2) {
                                horse[i - 4].setHorseName(nowCell);
                            }
                            if (j == 3) {
                                horse[i - 4].setOverallIndex(nowCell);
                            }
                            if (j == 4) {
                                horse[i - 4].setJockey(nowCell);
                            }
                            if (j == 5) {
                                horse[i - 4].setDifference(nowCell);
                            }
                            if (j == 6) {
                                horse[i - 4].setThistimeIndex(nowCell);
                            }
                            if (j == 7) {
                                horse[i - 4].setPase(nowCell);
                            }
                            if (j == 8) {
                                horse[i - 4].setAgari(nowCell);
                            }
                            if (j == 9) {
                                horse[i - 4].setPopularity(nowCell);
                            }
                            if (j == 10) {
                                horse[i - 4].setWin(nowCell);
                            }
                            if (j == 11) {
                                horse[i - 4].setPlace(nowCell);
                            }

                            // 4R
                            if (j == 12) {
                                horse[(j - 9) * 18 + i - 4].setOrder(nowCell);
                            }
                            if (j == 13) {
                                horse[(j - 10) * 18 + i - 4]
                                        .setHorseNo(nowCell);
                            }
                            if (j == 14) {
                                horse[(j - 11) * 18 + i - 4]
                                        .setHorseName(nowCell);
                            }
                            if (j == 15) {
                                horse[(j - 12) * 18 + i - 4]
                                        .setOverallIndex(nowCell);
                            }
                            if (j == 16) {
                                horse[(j - 13) * 18 + i - 4].setJockey(nowCell);
                            }
                            if (j == 17) {
                                horse[(j - 14) * 18 + i - 4]
                                        .setDifference(nowCell);
                            }
                            if (j == 18) {
                                horse[(j - 15) * 18 + i - 4]
                                        .setThistimeIndex(nowCell);
                            }
                            if (j == 19) {
                                horse[(j - 16) * 18 + i - 4].setPase(nowCell);
                            }
                            if (j == 20) {
                                horse[(j - 17) * 18 + i - 4].setAgari(nowCell);
                            }
                            if (j == 21) {
                                horse[(j - 18) * 18 + i - 4]
                                        .setPopularity(nowCell);
                            }
                            if (j == 22) {
                                horse[(j - 19) * 18 + i - 4].setWin(nowCell);
                            }
                            if (j == 23) {
                                horse[(j - 20) * 18 + i - 4].setPlace(nowCell);
                            }

                            // 7R
                            if (j == 24) {
                                horse[(j - 18) * 18 + i - 4].setOrder(nowCell);
                            }
                            if (j == 25) {
                                horse[(j - 19) * 18 + i - 4]
                                        .setHorseNo(nowCell);
                            }
                            if (j == 26) {
                                horse[(j - 20) * 18 + i - 4]
                                        .setHorseName(nowCell);
                            }
                            if (j == 27) {
                                horse[(j - 21) * 18 + i - 4]
                                        .setOverallIndex(nowCell);
                            }
                            if (j == 28) {
                                horse[(j - 22) * 18 + i - 4].setJockey(nowCell);
                            }
                            if (j == 29) {
                                horse[(j - 23) * 18 + i - 4]
                                        .setDifference(nowCell);
                            }
                            if (j == 30) {
                                horse[(j - 24) * 18 + i - 4]
                                        .setThistimeIndex(nowCell);
                            }
                            if (j == 31) {
                                horse[(j - 25) * 18 + i - 4].setPase(nowCell);
                            }
                            if (j == 32) {
                                horse[(j - 26) * 18 + i - 4].setAgari(nowCell);
                            }
                            if (j == 33) {
                                horse[(j - 27) * 18 + i - 4]
                                        .setPopularity(nowCell);
                            }
                            if (j == 34) {
                                horse[(j - 28) * 18 + i - 4].setWin(nowCell);
                            }
                            if (j == 35) {
                                horse[(j - 29) * 18 + i - 4].setPlace(nowCell);
                            }

                            // 10R
                            if (j == 36) {
                                horse[(j - 27) * 18 + i - 4].setOrder(nowCell);
                            }
                            if (j == 37) {
                                horse[(j - 28) * 18 + i - 4]
                                        .setHorseNo(nowCell);
                            }
                            if (j == 38) {
                                horse[(j - 29) * 18 + i - 4]
                                        .setHorseName(nowCell);
                            }
                            if (j == 39) {
                                horse[(j - 30) * 18 + i - 4]
                                        .setOverallIndex(nowCell);
                            }
                            if (j == 40) {
                                horse[(j - 31) * 18 + i - 4].setJockey(nowCell);
                            }
                            if (j == 41) {
                                horse[(j - 32) * 18 + i - 4]
                                        .setDifference(nowCell);
                            }
                            if (j == 42) {
                                horse[(j - 33) * 18 + i - 4]
                                        .setThistimeIndex(nowCell);
                            }
                            if (j == 43) {
                                horse[(j - 34) * 18 + i - 4].setPase(nowCell);
                            }
                            if (j == 44) {
                                horse[(j - 35) * 18 + i - 4].setAgari(nowCell);
                            }
                            if (j == 45) {
                                horse[(j - 36) * 18 + i - 4]
                                        .setPopularity(nowCell);
                            }
                            if (j == 46) {
                                horse[(j - 37) * 18 + i - 4].setWin(nowCell);
                            }
                            if (j == 47) {
                                horse[(j - 38) * 18 + i - 4].setPlace(nowCell);
                            }

                        }
                        if (i >= 29 && i <= 46) {
                            // 2R
                            if (j == 0) {
                                horse[i - 11].setOrder(nowCell);
                            }
                            if (j == 1) {
                                horse[i - 11].setHorseNo(nowCell);
                            }
                            if (j == 2) {
                                horse[i - 11].setHorseName(nowCell);
                            }
                            if (j == 3) {
                                horse[i - 11].setOverallIndex(nowCell);
                            }
                            if (j == 4) {
                                horse[i - 11].setJockey(nowCell);
                            }
                            if (j == 5) {
                                horse[i - 11].setDifference(nowCell);
                            }
                            if (j == 6) {
                                horse[i - 11].setThistimeIndex(nowCell);
                            }
                            if (j == 7) {
                                horse[i - 11].setPase(nowCell);
                            }
                            if (j == 8) {
                                horse[i - 11].setAgari(nowCell);
                            }
                            if (j == 9) {
                                horse[i - 11].setPopularity(nowCell);
                            }
                            if (j == 10) {
                                horse[i - 11].setWin(nowCell);
                            }
                            if (j == 11) {
                                horse[i - 11].setPlace(nowCell);
                            }

                            // 5R
                            if (j == 12) {
                                horse[(j - 9) * 18 + i - 11].setOrder(nowCell);
                            }
                            if (j == 13) {
                                horse[(j - 10) * 18 + i - 11]
                                        .setHorseNo(nowCell);
                            }
                            if (j == 14) {
                                horse[(j - 11) * 18 + i - 11]
                                        .setHorseName(nowCell);
                            }
                            if (j == 15) {
                                horse[(j - 12) * 18 + i - 11]
                                        .setOverallIndex(nowCell);
                            }
                            if (j == 16) {
                                horse[(j - 13) * 18 + i - 11]
                                        .setJockey(nowCell);
                            }
                            if (j == 17) {
                                horse[(j - 14) * 18 + i - 11]
                                        .setDifference(nowCell);
                            }
                            if (j == 18) {
                                horse[(j - 15) * 18 + i - 11]
                                        .setThistimeIndex(nowCell);
                            }
                            if (j == 19) {
                                horse[(j - 16) * 18 + i - 11].setPase(nowCell);
                            }
                            if (j == 20) {
                                horse[(j - 17) * 18 + i - 11].setAgari(nowCell);
                            }
                            if (j == 21) {
                                horse[(j - 18) * 18 + i - 11]
                                        .setPopularity(nowCell);
                            }
                            if (j == 22) {
                                horse[(j - 19) * 18 + i - 11].setWin(nowCell);
                            }
                            if (j == 23) {
                                horse[(j - 20) * 18 + i - 11].setPlace(nowCell);
                            }

                            // 8R
                            if (j == 24) {
                                horse[(j - 18) * 18 + i - 11].setOrder(nowCell);
                            }
                            if (j == 25) {
                                horse[(j - 19) * 18 + i - 11]
                                        .setHorseNo(nowCell);
                            }
                            if (j == 26) {
                                horse[(j - 20) * 18 + i - 11]
                                        .setHorseName(nowCell);
                            }
                            if (j == 27) {
                                horse[(j - 21) * 18 + i - 11]
                                        .setOverallIndex(nowCell);
                            }
                            if (j == 28) {
                                horse[(j - 22) * 18 + i - 11]
                                        .setJockey(nowCell);
                            }
                            if (j == 29) {
                                horse[(j - 23) * 18 + i - 11]
                                        .setDifference(nowCell);
                            }
                            if (j == 30) {
                                horse[(j - 24) * 18 + i - 11]
                                        .setThistimeIndex(nowCell);
                            }
                            if (j == 31) {
                                horse[(j - 25) * 18 + i - 11].setPase(nowCell);
                            }
                            if (j == 32) {
                                horse[(j - 26) * 18 + i - 11].setAgari(nowCell);
                            }
                            if (j == 33) {
                                horse[(j - 27) * 18 + i - 11]
                                        .setPopularity(nowCell);
                            }
                            if (j == 34) {
                                horse[(j - 28) * 18 + i - 11].setWin(nowCell);
                            }
                            if (j == 35) {
                                horse[(j - 29) * 18 + i - 11].setPlace(nowCell);
                            }

                            // 10R
                            if (j == 36) {
                                horse[(j - 27) * 18 + i - 11].setOrder(nowCell);
                            }
                            if (j == 37) {
                                horse[(j - 28) * 18 + i - 11]
                                        .setHorseNo(nowCell);
                            }
                            if (j == 38) {
                                horse[(j - 29) * 18 + i - 11]
                                        .setHorseName(nowCell);
                            }
                            if (j == 39) {
                                horse[(j - 30) * 18 + i - 11]
                                        .setOverallIndex(nowCell);
                            }
                            if (j == 40) {
                                horse[(j - 31) * 18 + i - 11]
                                        .setJockey(nowCell);
                            }
                            if (j == 41) {
                                horse[(j - 32) * 18 + i - 11]
                                        .setDifference(nowCell);
                            }
                            if (j == 42) {
                                horse[(j - 33) * 18 + i - 11]
                                        .setThistimeIndex(nowCell);
                            }
                            if (j == 43) {
                                horse[(j - 34) * 18 + i - 11].setPase(nowCell);
                            }
                            if (j == 44) {
                                horse[(j - 35) * 18 + i - 11].setAgari(nowCell);
                            }
                            if (j == 45) {
                                horse[(j - 36) * 18 + i - 11]
                                        .setPopularity(nowCell);
                            }
                            if (j == 46) {
                                horse[(j - 37) * 18 + i - 11].setWin(nowCell);
                            }
                            if (j == 47) {
                                horse[(j - 38) * 18 + i - 11].setPlace(nowCell);
                            }

                        }

                        if (i >= 54 && i <= 71) {
                            // 3R
                            if (j == 0) {
                                horse[i - 18].setOrder(nowCell);
                            }
                            if (j == 1) {
                                horse[i - 18].setHorseNo(nowCell);
                            }
                            if (j == 2) {
                                horse[i - 18].setHorseName(nowCell);
                            }
                            if (j == 3) {
                                horse[i - 18].setOverallIndex(nowCell);
                            }
                            if (j == 4) {
                                horse[i - 18].setJockey(nowCell);
                            }
                            if (j == 5) {
                                horse[i - 18].setDifference(nowCell);
                            }
                            if (j == 6) {
                                horse[i - 18].setThistimeIndex(nowCell);
                            }
                            if (j == 7) {
                                horse[i - 18].setPase(nowCell);
                            }
                            if (j == 8) {
                                horse[i - 18].setAgari(nowCell);
                            }
                            if (j == 9) {
                                horse[i - 18].setPopularity(nowCell);
                            }
                            if (j == 10) {
                                horse[i - 18].setWin(nowCell);
                            }
                            if (j == 11) {
                                horse[i - 18].setPlace(nowCell);
                            }

                            // 6R
                            if (j == 12) {
                                horse[(j - 9) * 18 + i - 18].setOrder(nowCell);
                            }
                            if (j == 13) {
                                horse[(j - 10) * 18 + i - 18]
                                        .setHorseNo(nowCell);
                            }
                            if (j == 14) {
                                horse[(j - 11) * 18 + i - 18]
                                        .setHorseName(nowCell);
                            }
                            if (j == 15) {
                                horse[(j - 12) * 18 + i - 18]
                                        .setOverallIndex(nowCell);
                            }
                            if (j == 16) {
                                horse[(j - 13) * 18 + i - 18]
                                        .setJockey(nowCell);
                            }
                            if (j == 17) {
                                horse[(j - 14) * 18 + i - 18]
                                        .setDifference(nowCell);
                            }
                            if (j == 18) {
                                horse[(j - 15) * 18 + i - 18]
                                        .setThistimeIndex(nowCell);
                            }
                            if (j == 19) {
                                horse[(j - 16) * 18 + i - 18].setPase(nowCell);
                            }
                            if (j == 20) {
                                horse[(j - 17) * 18 + i - 18].setAgari(nowCell);
                            }
                            if (j == 21) {
                                horse[(j - 18) * 18 + i - 18]
                                        .setPopularity(nowCell);
                            }
                            if (j == 22) {
                                horse[(j - 19) * 18 + i - 18].setWin(nowCell);
                            }
                            if (j == 23) {
                                horse[(j - 20) * 18 + i - 18].setPlace(nowCell);
                            }

                            // 9R
                            if (j == 24) {
                                horse[(j - 18) * 18 + i - 18].setOrder(nowCell);
                            }
                            if (j == 25) {
                                horse[(j - 19) * 18 + i - 18]
                                        .setHorseNo(nowCell);
                            }
                            if (j == 26) {
                                horse[(j - 20) * 18 + i - 18]
                                        .setHorseName(nowCell);
                            }
                            if (j == 27) {
                                horse[(j - 21) * 18 + i - 18]
                                        .setOverallIndex(nowCell);
                            }
                            if (j == 28) {
                                horse[(j - 22) * 18 + i - 18]
                                        .setJockey(nowCell);
                            }
                            if (j == 29) {
                                horse[(j - 23) * 18 + i - 18]
                                        .setDifference(nowCell);
                            }
                            if (j == 30) {
                                horse[(j - 24) * 18 + i - 18]
                                        .setThistimeIndex(nowCell);
                            }
                            if (j == 31) {
                                horse[(j - 25) * 18 + i - 18].setPase(nowCell);
                            }
                            if (j == 32) {
                                horse[(j - 26) * 18 + i - 18].setAgari(nowCell);
                            }
                            if (j == 33) {
                                horse[(j - 27) * 18 + i - 18]
                                        .setPopularity(nowCell);
                            }
                            if (j == 34) {
                                horse[(j - 28) * 18 + i - 18].setWin(nowCell);
                            }
                            if (j == 35) {
                                horse[(j - 29) * 18 + i - 18].setPlace(nowCell);
                            }

                            // 10R
                            if (j == 36) {
                                horse[(j - 27) * 18 + i - 18].setOrder(nowCell);
                            }
                            if (j == 37) {
                                horse[(j - 28) * 18 + i - 18]
                                        .setHorseNo(nowCell);
                            }
                            if (j == 38) {
                                horse[(j - 29) * 18 + i - 18]
                                        .setHorseName(nowCell);
                            }
                            if (j == 39) {
                                horse[(j - 30) * 18 + i - 18]
                                        .setOverallIndex(nowCell);
                            }
                            if (j == 40) {
                                horse[(j - 31) * 18 + i - 18]
                                        .setJockey(nowCell);
                            }
                            if (j == 41) {
                                horse[(j - 32) * 18 + i - 18]
                                        .setDifference(nowCell);
                            }
                            if (j == 42) {
                                horse[(j - 33) * 18 + i - 18]
                                        .setThistimeIndex(nowCell);
                            }
                            if (j == 43) {
                                horse[(j - 34) * 18 + i - 18].setPase(nowCell);
                            }
                            if (j == 44) {
                                horse[(j - 35) * 18 + i - 18].setAgari(nowCell);
                            }
                            if (j == 45) {
                                horse[(j - 36) * 18 + i - 18]
                                        .setPopularity(nowCell);
                            }
                            if (j == 46) {
                                horse[(j - 37) * 18 + i - 18].setWin(nowCell);
                            }
                            if (j == 47) {
                                horse[(j - 38) * 18 + i - 18].setPlace(nowCell);
                            }

                        }

                    }
                }
            }
        }

        int j = -1;
        // System.out.println("日付,レースNo,ダート/芝,距離,制限,出走レベル,着順,番号,馬名,総合指数,騎手,着差,今回指数,ペース,上がり,人気,単勝,位置取");
        for (int i = 0; i < 12 * 18; i++) {
            if (i % 18 == 0)
                j++;
            horse[i].setToday(today);
            horse[i].setRaceNo(race[j].getRaceNo());
            horse[i].setDirtOrGlass(race[j].getDirtOrGlass());
            horse[i].setDistance(race[j].getDistance());
            horse[i].setHorseLimit(race[j].getHorseLimit());
            horse[i].setHorseLevel(race[j].getHorseLevel());
            if (horse[i].horseName != null) {
                bw.write(trim(horse[i].toString()));
                bw.newLine();
                System.out.println(trim(horse[i].toString()));
            }
        }

    }

    static private void readFolder(File dir, BufferedWriter bw)
            throws IOException {

        File[] files = dir.listFiles();
        if (files == null)
            return;
        for (File file : files) {
            if (!file.exists())
                continue;
            else if (file.isDirectory())
                readFolder(file, bw);
            else if (file.isFile())
                execute(file, bw);
        }
    }

    static private void getRaceInfo(String nowCell, RaceVO race) {
        race.setRaceNo(nowCell.substring(1, 3));
        race.setDirtOrGlass(nowCell.substring(6, 7));
        race.setDistance(nowCell.substring(7,13));
        race.setHorseLimit(nowCell.substring(13, nowCell.length()));
//        race.setHorseLevel(nowCell.substring(8, nowCell.length()));
    }

    static private void getHorseLevel(String nowCell, RaceVO race) {
        race.setHorseLevel(nowCell.substring(8, nowCell.length()));
    }

    static private String trim(String str) {
        StringBuffer sb = new StringBuffer();
        char[] chr = str.toCharArray();
        for (int p = 0; p < chr.length; p++) {
            if (chr[p] == ' ' || chr[p] == '　')
                continue;
            sb.append(chr[p]);
        }
        return sb.toString();
    }

}