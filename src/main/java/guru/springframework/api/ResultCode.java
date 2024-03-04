package guru.springframework.api;


/**
 * 枚举一些常用API操作码
 */
public enum ResultCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    CHECK_ERROR(401, "校验异常!"),
    CLIENT_AUTHENTICATION_FAILED(402, "客户端身份验证失败"),
    FORBIDDEN(403, "没有相关权限"),
    ILLEGAL_STATE(404, "非法的状态!"),
    SAVE_FAILED(405, "保存失败"),
    UPDATE_FAILED(406, "更新失败"),
    UNKNOWN_OPERATE_TYPE(407, "未知的操作类型"),
    DATA_ERROR(408, "数据异常"),
    JSON_PARSE_ERROR(409, "json解析异常"),
    OPERATE_TYPE_ERROR(410, "操作类型错误"),
    DELETE_FAILED(411, "删除失败"),
    PDF_UPLOAD_FASTDFS(412, "pdf上传到fastDFS出错"),
    CACHE_EXPIRED_RESAVE_EXCEL(413, "缓存已过期，请重新导入并保存Excel"),
    ROLE_ERROR(414, "工作台标识错误"),
    MASTER_ACCOUNT(415, "无法判断登录用户是否为主账号");


    private final long code;
    private final String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static void main(String[] args) {
        // 遍历枚举类型中的每个枚举项，并输出信息
        for (ResultCode errorCode : ResultCode.values()) {
            System.out.println(errorCode.getMessage());
        }
    }
    }

