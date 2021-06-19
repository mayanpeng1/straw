package cn.tedu.straw.portal.ex;

public class ClassDisabledException extends ServiceException{
    public ClassDisabledException() {
        super();
    }

    public ClassDisabledException(String message) {
        super(message);
    }

    public ClassDisabledException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClassDisabledException(Throwable cause) {
        super(cause);
    }

    protected ClassDisabledException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
