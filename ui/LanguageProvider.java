package ui;

import java.util.HashMap;

interface LanguageProvider {
	public HashMap<String, String> getLanguage();

	public void setLanguage(HashMap<String, String> language);

	public void setLanguage(String language);
}
