package com.example.storyteller;

public class BookCard {
    private String question;
    private String answer;

    public BookCard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public boolean noQuestion() {return "".equals(question); }

    public String getQuestion() { return question; }

    public String getAnswer() { return answer; }
}
