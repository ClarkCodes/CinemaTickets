
package controlTesting;

import control.AdmSettings;
import control.AdmSettings.DataMode;
import control.AdmSettings.SupportedLanguagesAndLocales;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import visual.FrmCinemaTicketsSystem;

/** Unit Testing Class for AdmPelicula
 * @author ClarkCodes */
public class AdmSettingsTest
{
    private static AdmSettings admSettings;
    
    @BeforeAll
    public static void setUp()
    {
        FrmCinemaTicketsSystem mainWindow = new FrmCinemaTicketsSystem();
        admSettings = AdmSettings.getAdmSettings();
    }
    
    @Test
    public void admPeliculaMustNotBeNull()
    {
        Assertions.assertNotNull( admSettings );
        Assertions.assertInstanceOf( AdmSettings.class, admSettings );
    }
    
    @Test
    public void dataModeGetLangKey_MustBe()
    {
        Assertions.assertEquals( "lk_settings_stored_data", DataMode.Stored.getLangKey() );
        Assertions.assertEquals( "lk_settings_manual_input", DataMode.Manual.getLangKey() );
    }
    
    @Test
    public void dataModeValueOfLocalizedString_MustBe()
    {
        switch ( AdmSettings.getAppLanguage() )
        {
            case Español -> 
            {
                Assertions.assertEquals( DataMode.Stored, DataMode.valueOfLocalizedString( "Datos Almacenados" ) );
                Assertions.assertEquals( DataMode.Manual, DataMode.valueOfLocalizedString( "Ingreso Manual" ) );
            }
            case English -> 
            {
                Assertions.assertEquals( DataMode.Stored, DataMode.valueOfLocalizedString( "Stored Data" ) );
                Assertions.assertEquals( DataMode.Manual, DataMode.valueOfLocalizedString( "Manual Input" ) );
            }
        }
    }
    
    @Test
    public void supportedLanguagesAndLocales_GetLocale_GetLanguage_GetCountry_MustBe()
    {
        Assertions.assertEquals( "es_EC", SupportedLanguagesAndLocales.Español.getLocale() );
        Assertions.assertEquals( "en_US", SupportedLanguagesAndLocales.English.getLocale() );
        
        Assertions.assertEquals( "es", SupportedLanguagesAndLocales.Español.getLanguage() );
        Assertions.assertEquals( "en", SupportedLanguagesAndLocales.English.getLanguage() );
        
        Assertions.assertEquals( "EC", SupportedLanguagesAndLocales.Español.getCountry() );
        Assertions.assertEquals( "US", SupportedLanguagesAndLocales.English.getCountry() );
    }
    
    @Test
    public void fillLanguagesCombo_elementsInTheComboShouldBe()
    {
        JComboBox comboLanguages = new JComboBox();
        admSettings.fillLanguagesCombo( comboLanguages );
        
        Assertions.assertEquals( "Español", comboLanguages.getItemAt( 0 ).toString() );
        Assertions.assertEquals( "English", comboLanguages.getItemAt( 1 ).toString() );
    }
    
    @Test
    public void fillFlatLafCombo_elementsInTheComboShouldBe()
    {
        JComboBox comboFlatLaf = new JComboBox();
        admSettings.fillFlatLafCombo( comboFlatLaf );
        LinkedList<String> comboThemes = new LinkedList<>();
        String[] expectedArray = { "Flat Dark", "Flat Light" };
        
        for ( int itemIndex = 0; itemIndex < comboFlatLaf.getItemCount(); itemIndex++ )
        {
            if ( comboFlatLaf.getItemAt( itemIndex ) instanceof String criteria )
                comboThemes.add( criteria );
        }
        
        Assertions.assertArrayEquals( expectedArray, comboThemes.toArray( String[]::new ) );
    }
    
    @Test
    public void fillIntelliJCombo_elementsInTheComboShouldBe()
    {
        JComboBox comboIntelliJ = new JComboBox();
        admSettings.fillIntelliJCombo( comboIntelliJ );
        LinkedList<String> comboThemes = new LinkedList<>();
        LinkedList<String> expectedThemes = new LinkedList<>();
                
        expectedThemes.addAll( Arrays.asList( "Flat IntelliJ Light", 
                "Flat IntelliJ Dark",
                "Flat Darcula",
                "Dracula",
                "Arc Dark (Material)",
                "Arc Dark Orange",
                "Arc Orange",
                "One Dark",
                "Dark Purple",
                "Carbon",
                "Cobalt 2",
                "Gradianto Dark Fuchsia",
                "Gradianto Deep Ocean",
                "Gradianto Midnight Blue",
                "Gradianto Nature Green",
                "Gruvbox Dark Hard",
                "Gruvbox Dark Medium",
                "Hiberbee Dark",
                "Material Design Dark",
                "Monocai",
                "Solarized Dark",
                "Solarized Light",
                "Solarized Dark (Material)",
                "Solarized Light (Material)",
                "Atom One Dark (Material)",
                "Atom One Light (Material)",
                "GitHub (Material)",
                "GitHub Dark (Material)",
                "Material Darker (Material)",
                "Material Deep Ocean (Material)",
                "Material Oceanic (Material)",
                "Material Palenight (Material)",
                "Monokai Pro (Material)",
                "Moonlight (Material)",
                "Night Owl (Material)" ) );
        
        Collections.sort( expectedThemes );
        
        for ( int itemIndex = 0; itemIndex < comboIntelliJ.getItemCount(); itemIndex++ )
        {
            if ( comboIntelliJ.getItemAt( itemIndex ) instanceof String criteria )
                comboThemes.add( criteria );
        }
        
        Assertions.assertArrayEquals( expectedThemes.toArray( String[]::new ), comboThemes.toArray( String[]::new ) );
    }
    
    @Test
    public void applyThemeManager_And_themeSetter_ResultShouldBe()
    {
        String[] fewThemes = { "Arc Orange", "Arc Dark Orange", "Solarized Light", "Carbon", "Night Owl (Material)" };
        String[] expectedThemesClassNames = { "FlatArcOrangeIJTheme", "FlatArcDarkOrangeIJTheme", "FlatSolarizedLightIJTheme", "FlatCarbonIJTheme", "FlatNightOwlIJTheme" };
        
        for ( int i = 0; i < fewThemes.length; i++ )
        {
            admSettings.themeSetter( fewThemes[i] );
            Assertions.assertEquals( expectedThemesClassNames[i], UIManager.getLookAndFeel().getClass().getSimpleName() );
        }
        
        for ( int i = 0; i < fewThemes.length; i++ )
        {
            admSettings.applyThemeManager( fewThemes[i] );
            Assertions.assertEquals( expectedThemesClassNames[i], UIManager.getLookAndFeel().getClass().getSimpleName() );
        }
    }
    
    @Test
    public void gettingBackToSavedTheme_ResultShouldBe()
    {
        String savedThemeClassName = UIManager.getLookAndFeel().getClass().getSimpleName();
        String savedThemeName = UIManager.getLookAndFeel().getName();
        String[] fewThemes = { "Arc Orange", "Arc Dark Orange", "Solarized Light", "Carbon", "Night Owl (Material)" };
        String[] expectedThemesClassNames = { "FlatArcOrangeIJTheme", "FlatArcDarkOrangeIJTheme", "FlatSolarizedLightIJTheme", "FlatCarbonIJTheme", "FlatNightOwlIJTheme" };
        
        for ( int i = 0; i < fewThemes.length; i++ )
        {
            admSettings.themeSetter( fewThemes[i] );
            Assertions.assertEquals( expectedThemesClassNames[i], UIManager.getLookAndFeel().getClass().getSimpleName() );
            admSettings.gettingBackToSavedTheme( savedThemeName );
            Assertions.assertEquals( savedThemeClassName, UIManager.getLookAndFeel().getClass().getSimpleName() );
        }
    }
    
    @Test
    public void loadLanguageFromPreferences_ResultMustBe()
    {   
        admSettings.loadLanguageFromPreferences( "es_EC" );
        Assertions.assertEquals( AdmSettings.SupportedLanguagesAndLocales.Español, AdmSettings.getAppLanguage() );
        admSettings.loadLanguageFromPreferences( "en_US" );
        Assertions.assertEquals( AdmSettings.SupportedLanguagesAndLocales.English, AdmSettings.getAppLanguage() );
    }
    
    @Test
    public void applyLanguageInApp_ResultShouldBe()
    {   
        AdmSettings.setAppLanguage( "es" );
        admSettings.applyLanguageInApp();
        Assertions.assertEquals( AdmSettings.SupportedLanguagesAndLocales.Español, AdmSettings.getAppLanguage() );
        AdmSettings.setAppLanguage( "en" );
        admSettings.applyLanguageInApp();
        Assertions.assertEquals( AdmSettings.SupportedLanguagesAndLocales.English, AdmSettings.getAppLanguage() );
    }
    
}
