package co.uk.rileythefox.speedrun;

public enum Setting {

    //GENERATE_WORLD_ON_START("generate_world_on_start", true);
    DAMAGE_ON_NO_MOVEMENT("damage_on_no_movement", true);

    private final String path;
    private final Object defaultValue;

    Setting(String path, Object defaultValue) {
        this.path = path;
        this.defaultValue = defaultValue;
    }

    public String getPath() {
        return path;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }
}
