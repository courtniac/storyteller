package com.example.storyteller;

public class BookCard implements Comparable {
    private String book_identifier;
    private String question;
    private String answer;
    private String category;

    public BookCard(String book_identifier, String question, String answer, String category) {
        this.book_identifier = book_identifier;
        this.question = question;
        this.answer = answer;
        this.category = category;
    }

    public boolean noQuestion() {return "".equals(question); }

    public String getBookIdentifier() { return book_identifier; }

    public String getQuestion() { return question; }

    public String getAnswer() { return answer; }

    public String getCategory() { return category; }


    @Override
    public int compareTo(Object cmp) {
        return this.category.compareTo(((BookCard) cmp).getCategory());
    }
}
