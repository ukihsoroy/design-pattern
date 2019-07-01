package org.ko.memento.demo1;

public class Test {

    public static void main(String[] args) {
        ArticleMementoManager articleMementoManager = new ArticleMementoManager();

        Article article = new Article("如影随形的设计模式A", "内容A", "图片A");

        ArticleMemento articleMemento = article.saveToMemento();

        articleMementoManager.addMemento(articleMemento);

        System.out.println(article.toString());

        article.setTitle("修改手记start");
        article.setContent("手记内容B");
        article.setImages("手记图片B");

        System.out.println(article);

        articleMemento = article.saveToMemento();

        articleMementoManager.addMemento(articleMemento);

        article.setTitle("设计模式C");
        article.setContent("手记内容C");
        article.setImages("手记图片C");

        System.out.println(article.toString());

        System.out.println("回退出栈一次");
        articleMemento = articleMementoManager.getMemento();
        article.undoFromMemento(articleMemento);

        System.out.println(article.toString());

        System.out.println("回退出栈两次");
        articleMemento = articleMementoManager.getMemento();
        article.undoFromMemento(articleMemento);

        System.out.println(article.toString());


    }
}
