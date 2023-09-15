package com.model;

public class EmailSetup {
    private int language;
    private int pageSize;
    private boolean enableSpamsFilter;
    String signature;

    public EmailSetup(int language, int pageSize, boolean enableSpamsFilter, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.enableSpamsFilter = enableSpamsFilter;
        this.signature = signature;
    }
    public EmailSetup(){}

    public int getLanguage() {
      return this.language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isEnableSpamsFilter() {
        return enableSpamsFilter;
    }

    @Override
    public String toString() {
        return "EmailSetup{" +
                "language=" + language +
                ", pageSize=" + pageSize +
                ", enableSpamsFilter=" + enableSpamsFilter +
                ", signature='" + signature + '\'' +
                '}';
    }

    public void setEnableSpamsFilter(boolean enableSpamsFilter) {
        this.enableSpamsFilter = enableSpamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
