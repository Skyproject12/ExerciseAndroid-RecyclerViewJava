package com.example.lenovo.recyclerview;

import java.util.ArrayList;

public class PresidenData {
    public static String[][] data = new String[][]{
            {"Cristian Ronaldo", "Pemain Juventus", "https://upload.wikimedia.org/wikipedia/commons/a/a4/Cristiano_Ronaldo_in_Real_Madrid.jpg?1558792120554"},
            {"Cassilas", "Pemain Real Madrid", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/IkerCasillas.JPG/640px-IkerCasillas.JPG?1558792325870"},
            {"Luis Figo", "Pemain Real Madrid", "https://upload.wikimedia.org/wikipedia/commons/f/f0/Luis_Figo_flickr.jpg?1558792478796"},
            {"Patrick John Miguel van Aanholt", "Pemain Chelsea", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Van_Aanholt_in_2016_%28cropped%29.jpg/640px-Van_Aanholt_in_2016_%28cropped%29.jpg"},
            {"Tammy Abraham", "Pemain Chelsea", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/13/Tammy_Abraham_20160511.jpg/640px-Tammy_Abraham_20160511.jpg"},
            {"Ross Barkley", "Pemain Chelsea", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/de/Barkley_Ross.jpg/640px-Barkley_Ross.jpg"},
            {"Asmir Begović", "Pemain Chelsea", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a7/20150331_2026_AUT_BIH_2176.jpg/640px-20150331_2026_AUT_BIH_2176.jpg?1558792852130"}
    };
    public static ArrayList<President>getListData(){
        President president = null;
        ArrayList<President> list = new ArrayList<>();
        for (String[] aData : data) {
            president = new President();
            president.setNama(aData[0]);
            president.setRemaks(aData[1]);
            president.setPhoto(aData[2]);
            list.add(president);
        }
        return list;
    }
}
