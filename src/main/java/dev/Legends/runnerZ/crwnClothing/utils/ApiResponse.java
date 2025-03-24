package dev.Legends.runnerZ.crwnClothing.utils;

public class ApiResponse<T> {
    private int status;
    private T data;
    private String message;

    public ApiResponse(T data, int status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
    }

    public int getStatus() { return status; }
    public T getData() { return data; }
    public String getMessage() { return message; }

    @Override
    public String toString() {
        return "data:"+getData();
    }
}
