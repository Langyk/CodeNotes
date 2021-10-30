package com.simon.codenotes.window;

import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import com.simon.codenotes.data.DataCenter;
import com.simon.codenotes.processor.DefaultSourceNoteData;
import com.simon.codenotes.processor.MDFreeMarkProcessor;
import com.simon.codenotes.processor.Processor;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: Simon Lang
 * @Description: Think Twice, Code Once
 * @Date: 2021/10/24 19:43
 */
public class NoteListWindow {
    private JTextField tfTopic;
    private JTable tbConent;
    private JButton btnCreate;
    private JButton btnClear;
    private JButton btnClose;
    private JPanel contentPanel;

    public void init(){
        tbConent.setModel(DataCenter.TABLE_MODEL);
        tbConent.setEnabled(true);
    }

    public NoteListWindow(Project project, ToolWindow toolWindow) {
        init();
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String topic = tfTopic.getText();
                String fileName = topic+".md";
                //判断是否输入标题
                if(topic == null || "".equals(topic)){
                    MessageDialogBuilder.yesNo("操作结果","文档标题没有输入");
                    return;
                }
                //获取存储文件的路径
                VirtualFile virtualFile = FileChooser.chooseFile(FileChooserDescriptorFactory.createSingleFolderDescriptor(), project, project.getBaseDir());
                if(virtualFile != null){
                    String path = virtualFile.getPath();
                    String fileFullPath = path + "/" + fileName;
                    Processor processor = new MDFreeMarkProcessor();
                    try {
                        processor.process(new DefaultSourceNoteData(fileFullPath,topic,DataCenter.NOTE_LIST));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataCenter.reset();
            }
        });
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolWindow.hide(null);
            }
        });
    }
    public JPanel getContentPanel() {
        return contentPanel;
    }
}
