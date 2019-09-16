package de.stl.saar.internetentw1.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.*;

@ManagedBean
@SessionScoped
public class I18nBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private String localeCode;

    private Map<String,Object> languages;

    @PostConstruct
    public void initialize() {
        languages = new LinkedHashMap<>();
        languages.put("Deutsch", Locale.GERMAN);
        languages.put("English", Locale.ENGLISH);
        localeCode = Locale.GERMAN.getLanguage();
    }

    public void onLocaleCodeChange(ValueChangeEvent valueChangeEvent) {
        final String newLocale = valueChangeEvent.getNewValue().toString();

        for (Map.Entry<String, Object> entry : languages.entrySet()) {
            if (entry.getValue().toString().equals(newLocale)) {
                FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale)entry.getValue());
            }
        }
    }

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    public Map<String, Object> getLanguages() {
        return languages;
    }

}
