package com.grupo.xxiv.convenios.http.util;

public final class TokenHolder {

    private TokenHolder() {
        super();
    }

    private static final ThreadLocal<String> ACCESS_TOKEN_HOLDER = new ThreadLocal<String>();

    public static void setAccessToken(String accessToken) {
        ACCESS_TOKEN_HOLDER.set(accessToken);
    }

    public static String getAccessToken() {
        return ACCESS_TOKEN_HOLDER.get();
    }

    public static void clearAccessToken() {
        ACCESS_TOKEN_HOLDER.remove();
    }


}
