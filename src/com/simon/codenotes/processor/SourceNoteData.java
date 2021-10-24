package com.simon.codenotes.processor;

import com.simon.codenotes.data.NoteData;

import java.util.List;

/**
 * @Author: Simon Lang
 * @Description: Think Twice, Code Once
 * @Date: 2021/10/24 22:16
 */
public interface SourceNoteData {
    public String getFileName();

    public String getTopic();

    public List<NoteData> getNoteList();

}
