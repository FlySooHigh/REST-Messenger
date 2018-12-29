package org.flysoohigh.rest.model;

/**
 * Created on 29.12.2018.
 */
class Link {
    private String url;
    private String rel;

    public String getUrl() {
        return url;
    }

    void setUrl(String url) {
        this.url = url;
    }

    public String getRel() {
        return rel;
    }

    void setRel(String rel) {
        this.rel = rel;
    }
}
