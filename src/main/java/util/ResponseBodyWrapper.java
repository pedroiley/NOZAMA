package util;

public class ResponseBodyWrapper {

    private String message;

    public ResponseBodyWrapper(String messageValue) {
        this.message = messageValue;
    }

    @Override
    public String toString() {
        return "{" + '\'' +
                "message='" + message + '\'' +
                '}';
    }
}
