package com.simon.codenotes.processor;

import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * @Author: Simon Lang
 * @Description: Think Twice, Code Once
 * @Date: 2021/10/24 22:12
 */
public interface Processor {
    public void process(SourceNoteData sourceNoteData) throws Exception;
}
