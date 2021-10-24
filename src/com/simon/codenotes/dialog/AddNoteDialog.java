package com.simon.codenotes.dialog;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.EditorTextField;
import com.simon.codenotes.data.DataCenter;
import com.simon.codenotes.data.DataConvert;
import com.simon.codenotes.data.NoteData;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: Simon Lang
 * @Description: Think Twice, Code Once
 * @Date: 2021/10/20 21:22
 */
public class AddNoteDialog extends DialogWrapper {
    private EditorTextField tfTitle;
    private EditorTextField tfMark;

    public AddNoteDialog() {
        super(true);
        setTitle("添加笔记注释");
        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        //定义一个面板
        JPanel jPanel = new JPanel(new BorderLayout());
        //定义两个文本框
        tfTitle = new EditorTextField("笔记标题");
        tfMark = new EditorTextField("笔记内容");
        //设置内容框的大小
        tfMark.setPreferredSize(new Dimension(200,100));
        //根据BordLayout放置文本框的位置
        jPanel.add(tfTitle,BorderLayout.NORTH);
        jPanel.add(tfMark,BorderLayout.CENTER);
        return jPanel;
    }

    @Override
    protected JComponent createSouthPanel() {
        JPanel panel = new JPanel();
        JButton button = new JButton("添加笔记到列表");
        button.addActionListener(e -> {
            String title = tfTitle.getText();
            String mark = tfMark.getText();
            String fileType = DataCenter.FILE_NAME.substring(DataCenter.FILE_NAME.lastIndexOf(".")+1);//获取后缀名
            NoteData noteData = new NoteData(title,mark, DataCenter.FILE_NAME,DataCenter.SELECT_TEXT,fileType);
            DataCenter.NOTE_LIST.add(noteData);
            DataCenter.TABLE_MODEL.addRow(DataConvert.convert(noteData));
        });
        panel.add(button);
        return panel;

    }
}
