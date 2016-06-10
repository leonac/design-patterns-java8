package st.pr.validator;

public class ValidationResult {
    /*public enum ErrorType {
        ERROR,
        WARNING
    }*/

    String message;
    int errorCode;

    public ValidationResult(final String message, final int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ValidationResult{");
        sb.append("message='").append(message).append('\'');
        sb.append(", errorCode=").append(errorCode);
        sb.append('}');
        return sb.toString();
    }
}
