package jp.co.dms.infrastructure.security;

public class SecurityConstants {
    public static final String SECRET = "nyasbasamplesecret";
    public static final long EXPIRATION_TIME = 28_800_000; // 8hours
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String API_DOCS_URL = "/v2/api-docs";
    public static final String API_DOCS_LOCAL = "/**"; // TODO アクセス制御できていない
    public static final String SIGNUP_URL = "/api/v1/user/signup";
    public static final String LOGIN_URL = "/api/v1/user/login";
    public static final String LOGIN_ID = "email"; // defalut:username
    public static final String PASSWORD = "password"; // default:password
}