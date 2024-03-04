package guru.springframework.api;

/**
 * 错误码枚举类接口
 */
public interface ErrorCode{

    /**
     *错误码
     */
    long getCode();

    /**
     *提示信息
     */
    String getMessage();

    /**
     * 业务范围
     */
    String getBizScope();

    /**
     * 错误级别
     */
    int getBizLevel();

    /**
     * 业务详情情描述
     */
    String getBizDetails();
}
