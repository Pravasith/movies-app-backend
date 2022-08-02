package com.moviestore.cjv.utils;

public class CustomizedResponse<T>
{
    private String message;
    private T body;


    public CustomizedResponse()
    {
    }

    public CustomizedResponse(String message, T body)
    {
        this.message = message;
        this.body = body;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public T getBody()
    {
        return body;
    }

    public void setBody(T body)
    {
        this.body = body;
    }
}
