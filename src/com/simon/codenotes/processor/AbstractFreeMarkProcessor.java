package com.simon.codenotes.processor;


import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/**
 * @Author: Simon Lang
 * @Description: Think Twice, Code Once
 * @Date: 2021/10/30 15:21
 */
public abstract class AbstractFreeMarkProcessor implements Processor{

    protected abstract Template getTemplate() throws IOException;

    //文本实体模型
    protected abstract Object getModel(SourceNoteData sourceNoteData);

    //定义写入的文本
    protected abstract Writer getWriter(SourceNoteData sourceNoteData) throws Exception;

    @Override
    public final void process(SourceNoteData sourceNoteData) throws Exception {
        Template template = getTemplate();
        Object model = getModel(sourceNoteData);
        Writer writer = getWriter(sourceNoteData);
        template.process(model,writer);
    }
}
