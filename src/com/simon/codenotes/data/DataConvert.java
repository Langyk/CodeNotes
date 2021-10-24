package com.simon.codenotes.data;

/**
 * @Author: Simon Lang
 * @Description: Think Twice, Code Once
 * @Date: 2021/10/24 21:27
 */
public class DataConvert {
    public static String[] convert(NoteData noteData){
        String[] raw = new String[4];
        raw[0] = noteData.getTitle();
        raw[1] = noteData.getMark();
        raw[2] = noteData.getFileName();
        raw[3] = noteData.getContent();
        return raw;
    }
}
