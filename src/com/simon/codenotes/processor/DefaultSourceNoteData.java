package com.simon.codenotes.processor;

import com.simon.codenotes.data.NoteData;

import java.util.List;

/**
 * @Author: Simon Lang
 * @Description: Think Twice, Code Once
 * @Date: 2021/10/30 17:28
 */
public class DefaultSourceNoteData implements SourceNoteData{

    private String filename;
    private String topic;
    private List<NoteData> noteList;

    public DefaultSourceNoteData(String filename, String topic, List<NoteData> noteList) {
        this.filename = filename;
        this.topic = topic;
        this.noteList = noteList;
    }

    @Override
    public String getFileName() {
        return filename;
    }

    @Override
    public String getTopic() {
        return topic;
    }

    @Override
    public List<NoteData> getNoteList() {
        return noteList;
    }
}
