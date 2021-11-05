package com.company.Test.test8;

public class Book {

    private int id;
    private int count;//借阅次数
    private int cardId;

    public Book(int id, int count, int cardId) {
        this.id = id;
        this.count = count;
        this.cardId = cardId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
}
