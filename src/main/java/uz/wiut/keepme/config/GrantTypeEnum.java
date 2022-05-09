package uz.wiut.keepme.config;

public enum GrantTypeEnum {

    refresh_token("refresh_token"),
    password("password");

    private final String type;

    GrantTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static GrantTypeEnum fromString(String text) {
        for (GrantTypeEnum b : GrantTypeEnum.values()) {
            if (b.type.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

}
