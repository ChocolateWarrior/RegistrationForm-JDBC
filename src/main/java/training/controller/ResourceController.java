package training.controller;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceController {
    USER_INTERFACE("property.msg");

    private ResourceBundle resourceBundle;
    private String resourceName;
    ResourceController(String resourceName) {
        this.resourceName = resourceName;
        this.resourceBundle = ResourceBundle.getBundle(resourceName, Locale.getDefault());
    }

    public void changeResource(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(
                resourceName, locale);

    }
    public String getString(String key) {
        return resourceBundle.getString(key);
    }

}
