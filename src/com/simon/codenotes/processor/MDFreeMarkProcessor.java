package com.simon.codenotes.processor;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Simon Lang
 * @Description: Think Twice, Code Once
 * @Date: 2021/10/30 16:58
 */
public class MDFreeMarkProcessor extends AbstractFreeMarkProcessor{

    @Override
    protected Template getTemplate() {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_29);
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        configuration.setTemplateLoader(stringTemplateLoader);
        return null;
    }

    @Override
    protected Object getModel(SourceNoteData sourceNoteData) {
        Map model = new HashMap();
        model.put("topic",sourceNoteData);
        model.put("noteList",sourceNoteData);
        return model;
    }

    @Override
    protected Writer getWriter(SourceNoteData sourceNoteData) {
        return null;
    }
}
