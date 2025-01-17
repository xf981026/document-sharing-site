package com.jiaruiblog.enums;

import com.jiaruiblog.util.converter.BaseEnum;

/**
 * @author jiarui.luo
 */
public enum FileFormatEnum implements BaseEnum {

    /**
     * PDF document
     */
    PDF(1, "pdf"),

    /**
     * xls
     */
    XLS(2, "xls"),

    /**
     * xlsx
     */
    XLSX(3, "xlsx"),

    /**
     * doc
     */
    DOC(4, "doc"),

    /**
     * docx
     */
    DOCX(5, "docx"),

    /**
     * ppt
     */
    PPT(6, "ppt"),

    /**
     * pptx
     */
    PPTX(7, "pptx"),

    /**
     * markdown
     */
    MD(8, "markdown"),

    /**
     * png
     */
    PNG(9, "png"),

    /**
     * jpeg
     */
    JPEG(10, "JPEG");


    private Integer code;

    private String description;

    FileFormatEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }
}
