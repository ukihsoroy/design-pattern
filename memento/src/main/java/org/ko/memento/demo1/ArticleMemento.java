package org.ko.memento.demo1;

public class ArticleMemento {

    private String title;

    private String content;

    private String images;

    public ArticleMemento(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
        this.images = article.getImages();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImages() {
        return images;
    }

    @Override
    public String toString() {
        return "ArticleMemento{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", images='" + images + '\'' +
                '}';
    }
}
