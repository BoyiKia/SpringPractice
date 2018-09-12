package com.example.demo.Utils;




public class Response{
    private String status;
    private Object content;

    public Response(String status, Object content) {
        this.status = status;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status:" + status + '\'' +
                ", conten:" + content +
                '}';
    }
}
