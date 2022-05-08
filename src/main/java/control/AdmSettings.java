
package control;

/* LICENSE
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */
// Imports
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.intellijthemes.*;
import data.DatosTickets;
import java.awt.Color;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.Commons;
import visual.FrmCinemaTicketsSystem;

/** Settings Management Class, hosts tasks and important things related to it
 *
 * @author Clark - ClarkCodes
 * @since 1.3
 */
public final class AdmSettings
{
    // Version fields - Application Version Constant v1.6-public-stable
    private final static int VERSION_MAJOR = 1;
    private final static int VERSION_MINOR = 6;
    private final static VersionAccess VERSION_ACCESS = VersionAccess.Public;
    private final static VersionState VERSION_STATE = VersionState.Stable;

    // Themes
    private final ArrayList<String> availableFlatLafThemes; // Main Lists of Themes - These lists will be useful to fulfill the combo boxes of Settings Window
    private final ArrayList<String> availableIntelliJThemes;

    // Properties
    private String currentSelectedGuiLafTheme, currentAppliedGuiLafTheme, startingFolder;
    private boolean applyingThemePending;
    private DataMode clientDataMode, appDataMode;
    private Commons.FileType fileTypeToSave = null;
    
    // Internationalization - App Locale
    private static SupportedLanguagesAndLocales appLanguage;
    private static ResourceBundle languageBundle;

    // Icons
    private final int PX_X2; // Tamanio en pixeles que ocuparan los iconos con doble tamanio, los normales miden 16x16 pixeles ergo los x2 miden 32x32 pixeles.
    private FlatSVGIcon addIcon;
    private FlatSVGIcon addIconForGenerateForm;
    private FlatSVGIcon addClientForClientManualInputDialog;
    private FlatSVGIcon searchIcon;
    private FlatSVGIcon searchIconForSearchForm;
    private FlatSVGIcon editIcon;
    private FlatSVGIcon editIconForSearchForm;
    private FlatSVGIcon deleteIcon;
    private FlatSVGIcon sourceOpenIcon;
    private FlatSVGIcon sourceOpenIconForOpenDialog;
    private FlatSVGIcon saveIcon;
    private FlatSVGIcon saveIconForSaveDialog;
    private FlatSVGIcon settingsIcon;
    private FlatSVGIcon settingsIconForSettingsForm;
    private FlatSVGIcon groupsAttributionIcon;
    private FlatSVGIcon groupsAttributionIconForAttributionForm;
    private FlatSVGIcon infoIcon;
    private FlatSVGIcon infoIconForAboutDeveloperForm;
    private FlatSVGIcon moviesIcon;
    private FlatSVGIcon moviesIconForMoviesForm;
    private FlatSVGIcon showsIcon;
    private FlatSVGIcon showsIconForShowsForm;
    private FlatSVGIcon theatersIcon;
    private FlatSVGIcon theatersIconForTheatersForm;
    private FlatSVGIcon copyIcon;
    private FlatSVGIcon powerExitIcon;

    
    // Versioning Enums
    private static enum VersionAccess
    {
        Public,
        Private
    }
    
    private static enum VersionState
    {
        Stable,
        onDev,
        Experimental
    }

    /** Enum Helper to Set the SVG Icon Color Filters */
    public static enum ColorSetType
    {   /** Color Set Type {@code enum} constant for Startup, used to colorize icons with a laf friendly color when the application stars */
        Startup, /** Color Set Type {@code enum} constant for Runtime, used to colorize icons with a laf friendly color when the application is already running */
        Runtime
    }

    /** Enum Helper to handle input or manual mode client and app data
     * @since 1.6
     */
    public enum DataMode
    {   /** Data Mode {@code enum} constant for Stored Mode */
        Stored ( "lk_settings_stored_data" ), /** Data Mode {@code enum} constant for Manual Mode */
        Manual ( "lk_settings_manual_input" );
        
        private final String lk_key;
        
        DataMode ( String lk_key )
        {
            this.lk_key = lk_key;
        }

        /** Gets the corresponding {@code String} language key asociated to its
         * corresponding {@code enum} constant
         * 
         * @return The asociated {@code String} language key
         * @since 1.6
         */
        public String getLangKey()
        {
            return lk_key;
        }

        /** Parses a {@code String} to its corresponding {@code DataMode enum} 
         * constant
         * @param str A specified {@code String} that contains a shown
         *            {@code DataMode} text in the current application 
         *            language
         * @return    The {@code DataMode enum} constant that matches with the
         *            given str
         * @since 1.6
         * @see control.AdmTicket
         */
        public static DataMode valueOfLocalizedString ( String str )
        {
            DataMode result = null;
            
            for ( DataMode c : values() )
            {
                if ( str.equalsIgnoreCase( AdmSettings.getLanguageBundle().getString( c.getLangKey() ) ) )
                {
                    result = c;
                    break;
                }
            }
            
            return result;
        }
    }

    /** Enum Helper to manage languages and locales for the application
     * 
     * @since 1.6
     * @see visual.FrmDialogPreferencias
     */
    public static enum SupportedLanguagesAndLocales
    {   /** Language {@code enum} constant for Spanish */
        Español ( "es_EC", "es", "EC" ), /** Language {@code enum} constant for English */
        English ( "en_US", "en", "US" );
        
        final String locale, language, country;
        
        SupportedLanguagesAndLocales ( String locale, String language, String country )
        {
            this.locale = locale;
            this.language = language;
            this.country = country;
        }
        
        /** Gets the locale that corresponds to this {@code enum} constant
         * @return The corresponding {@code String} that contains the respective
         * locale using a determined format composed by the 
         * ISO 639 alpha-2 language code and the ISO 3166 alpha-2 country code,
         * separated by an underline '_'. For example: "es_EC" or "en_US"
         * @since 1.6
         * @see Locale
         */
        public String getLocale()
        {
            return this.locale;
        }
        
        /** Gets the language code that corresponds to this {@code enum} 
         * constant
         * @return The corresponding {@code String} that contains the respective
         * ISO 639 alpha-2 language code
         * @since 1.6
         * @see Locale
         */
        public String getLanguage()
        {
            return this.language;
        }
        
        /** Gets the country code that corresponds to this {@code enum} 
         * constant
         * @return The corresponding {@code String} that contains the respective
         * ISO 3166 alpha-2 country code
         * @since 1.6
         * @see Locale
         */
        public String getCountry()
        {
            return this.country;
        }
    }

    // Singleton Pattern
    /** Sole Constructor which loads the {@code AdmSettings} unique instance
     * following Singleton Design Pattern */
    private AdmSettings ()
    {
        availableFlatLafThemes = new ArrayList<>();
        availableIntelliJThemes = new ArrayList<>();
        this.PX_X2 = 32; // Definiendo la constante de tamanio en pixeles de iconos x2.
        initSettings();
    }

    // Singleton Pattern
    private static AdmSettings admSettings = null;

    /** Gets the unique instance of this class, following Singleton Desing
     * Pattern in Development
     *
     * @return The Unique {@code AdmSettings} instance
     */
    public static AdmSettings getAdmSettings ()
    {
        if ( admSettings == null )
            admSettings = new AdmSettings();
        return admSettings;
    }

    /** Initializes important Settings like a list of predefined GUI Laf themes
     * from FlatLaf and FlatLaf-IntelliJ themes to use them after and also the
     * application icons
     * 
     * @since 1.4
     */
    private void initSettings ()
    {   // Adding items to the List
        availableFlatLafThemes.add( "Flat Dark" );
        availableFlatLafThemes.add( "Flat Light" );

        availableIntelliJThemes.addAll(
                Arrays.asList(
                        "Flat IntelliJ Light",
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
                        "Night Owl (Material)"
                ) );

        // Sorting themes
        Collections.sort( availableIntelliJThemes );

        // Icons
        addIcon = new FlatSVGIcon( "add_white_18dp.svg" );
        addIconForGenerateForm = new FlatSVGIcon( "add_white_18dp.svg", PX_X2, PX_X2 );
        addClientForClientManualInputDialog = new FlatSVGIcon( "person_add_white_18dp.svg", PX_X2, PX_X2 );
        searchIcon = new FlatSVGIcon( "search_white_18dp.svg" );
        searchIconForSearchForm = new FlatSVGIcon( "search_white_18dp.svg", PX_X2, PX_X2 );
        editIcon = new FlatSVGIcon( "edit_white_18dp.svg" );
        editIconForSearchForm = new FlatSVGIcon( "edit_white_18dp.svg", PX_X2, PX_X2 );
        deleteIcon = new FlatSVGIcon( "delete_white_18dp.svg" );
        sourceOpenIcon = new FlatSVGIcon( "source_white_18dp.svg" );
        sourceOpenIconForOpenDialog = new FlatSVGIcon( "source_white_18dp.svg", PX_X2, PX_X2 );
        saveIcon = new FlatSVGIcon( "save_white_18dp.svg" );
        saveIconForSaveDialog = new FlatSVGIcon( "save_white_18dp.svg", PX_X2, PX_X2 );
        settingsIcon = new FlatSVGIcon( "settings_white_18dp.svg" );
        settingsIconForSettingsForm = new FlatSVGIcon( "settings_white_18dp.svg", PX_X2, PX_X2 );
        groupsAttributionIcon = new FlatSVGIcon( "groups_white_18dp.svg" );
        groupsAttributionIconForAttributionForm = new FlatSVGIcon( "groups_white_18dp.svg", PX_X2, PX_X2 );
        infoIcon = new FlatSVGIcon( "info_white_18dp.svg" );
        infoIconForAboutDeveloperForm = new FlatSVGIcon( "info_white_18dp.svg", PX_X2, PX_X2 );
        moviesIcon = new FlatSVGIcon( "movie_white_18dp.svg" );
        moviesIconForMoviesForm = new FlatSVGIcon( "movie_white_18dp.svg" );
        showsIcon = new FlatSVGIcon( "slideshow_white_18dp.svg" );
        showsIconForShowsForm = new FlatSVGIcon( "slideshow_white_18dp.svg" );
        theatersIcon = new FlatSVGIcon( "theaters_white_18dp.svg" );
        theatersIconForTheatersForm = new FlatSVGIcon( "theaters_white_18dp.svg" );
        powerExitIcon = new FlatSVGIcon( "settings_power_white_18dp.svg" );
        copyIcon = new FlatSVGIcon( "content_copy_white_18dp.svg" );
    }

    /** Sets the respective filtering color on svg icons to match properly with
     * every theme set by user either
     * in app startup matching with saved theme or in runtime when changing
     * themes
     *
     * @param colorSetType the type either startup or runtime from the
     *                     respective ColorSetType Enum
     */
    public void colorOnIconsManager ( ColorSetType colorSetType )
    {
        if ( colorSetType.equals( ColorSetType.Runtime ) )
            FlatSVGIcon.ColorFilter.getInstance().removeAll();

        FlatSVGIcon.ColorFilter.getInstance().add( Color.WHITE, UIManager.getColor( "MenuItem.foreground" ) ); // Taking the Colors from UI MenuItem foreground for Icons and Setting the color for all FlatSVGIcons in use
    }

    /** Fills a {@code JComboBox} object with available languages
     * 
     * @param languagesCombo The {@code JComboBox} object to be populated
     * 
     * @since 1.6
     */
    public void fillLanguagesCombo ( JComboBox languagesCombo )
    {
        for ( SupportedLanguagesAndLocales l : SupportedLanguagesAndLocales.values() )
            languagesCombo.addItem( l.name() );
    }

    /** Fills a given {@code JComboBox} with the available pre-set FlatLaf
     * Themes list
     *
     * @param flatLafCombo The {@code JComboBox} to be filled with FlatLaf
     *                     Themes
     * @since 1.4
     */
    public void fillFlatLafCombo ( JComboBox flatLafCombo )
    {
        this.availableFlatLafThemes.forEach( theme -> flatLafCombo.addItem( theme ) );
    }

    /** Fills a given {@code JComboBox} with the available pre-set FlatLaf
     * IntelliJ Themes list
     *
     * @param intelliJCombo The {@code JComboBox} to be filled with IntelliJ
     *                      Themes
     * @since 1.4
     */
    public void fillIntelliJCombo ( JComboBox intelliJCombo )
    {
        this.availableIntelliJThemes.forEach( theme -> intelliJCombo.addItem( theme ) );
    }

    /** Sets a Look and Feel Theme on the Application
     * @param themeToSet A given {@code String} representation that contains the
     *                   theme name to set up the respective proper theme
     * @since 1.4
     */
    public void themeSetter ( String themeToSet )
    {
        var theme = switch ( themeToSet )
        {
            case "Flat Dark":
                yield new com.formdev.flatlaf.FlatDarkLaf();
            case "Flat Light":
                yield new com.formdev.flatlaf.FlatLightLaf();
            case "Flat Darcula":
                yield new com.formdev.flatlaf.FlatDarculaLaf();
            case "Dracula":
                yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatDraculaIJTheme();
            case "Flat IntelliJ Light":
                yield new FlatLightFlatIJTheme();
            case "Flat IntelliJ Dark":
                yield new FlatDarkFlatIJTheme();
            case "Arc Dark (Material)":
                yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkIJTheme();
            case "Arc Dark Orange":
                yield new FlatArcDarkOrangeIJTheme();
            case "Arc Orange":
                yield new FlatArcOrangeIJTheme();
            case "One Dark":
                yield new FlatOneDarkIJTheme();
            case "Dark Purple":
                yield new FlatDarkPurpleIJTheme();
            case "Monocai":
                yield new FlatMonocaiIJTheme();
            case "Solarized Dark":
                yield new FlatSolarizedDarkIJTheme();
            case "Solarized Light":
                yield new FlatSolarizedLightIJTheme();
            case "Solarized Dark (Material)":
                yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatSolarizedDarkIJTheme();
            case "Solarized Light (Material)":
                yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatSolarizedLightIJTheme();
            case "Carbon":
                yield new FlatCarbonIJTheme();
            case "Cobalt 2":
                yield new FlatCobalt2IJTheme();
            case "Gradianto Dark Fuchsia":
                yield new FlatGradiantoDarkFuchsiaIJTheme();
            case "Gradianto Deep Ocean":
                yield new FlatGradiantoDeepOceanIJTheme();
            case "Gradianto Midnight Blue":
                yield new FlatGradiantoMidnightBlueIJTheme();
            case "Gradianto Nature Green":
                yield new FlatGradiantoNatureGreenIJTheme();
            case "Gruvbox Dark Hard":
                yield new FlatGruvboxDarkHardIJTheme();
            case "Gruvbox Dark Medium":
                yield new FlatGruvboxDarkMediumIJTheme();
            case "Hiberbee Dark":
                yield new FlatHiberbeeDarkIJTheme();
            case "Atom One Dark (Material)":
                yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme();
            case "Atom One Light (Material)":
                yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightIJTheme();
            case "GitHub (Material)":
                yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubIJTheme();
            case "GitHub Dark (Material)":
                yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkIJTheme();
            case "Material Darker (Material)":
                yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDarkerIJTheme();
            case "Material Design Dark":
                yield new FlatMaterialDesignDarkIJTheme();
            case "Material Deep Ocean (Material)":
                yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDeepOceanIJTheme();
            case "Material Oceanic (Material)":
                yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialOceanicIJTheme();
            case "Material Palenight (Material)":
                yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialPalenightIJTheme();
            case "Monokai Pro (Material)":
                yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMonokaiProIJTheme();
            case "Moonlight (Material)":
                yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMoonlightIJTheme();
            case "Night Owl (Material)":
                yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlIJTheme();
            default:
                yield null;
        };

        try
        {
            UIManager.setLookAndFeel( theme ); // Aplicamos el Tema tal cual
        }
        catch ( UnsupportedLookAndFeelException ex )
        {
            Logger.getLogger( AdmSettings.class.getName() ).log( Level.SEVERE, null, ex );
            JOptionPane.showMessageDialog( null, "Error al establecer el Tema: \n" + ex.getMessage(), "Error de Laf UI", JOptionPane.ERROR_MESSAGE );
        }
    }

    /** Manages the set of a Look and Feel Theme on the Application with a given
     * Look and Feel {@code String} that contains its name, following 3 needed 
     * steps.
     * <p>
     * The first step is to call the method {@code themeSetter}, which is the
     * one in charge to apply the theme sending the Laf name to it as parameter.
     * <p>
     * The second step is to call the {@code FlatLaf.updateUI} method to update
     * all the current Application UI tree.
     * <p>
     * And the third step is to update properly the {@code JFileChooser} used to
     * open and save Cinema Tickets files by calling the method in charge, this
     * needs to be donde independently due to the {@code JFIleChooser} nature.
     * <p>
     * So once these 3 steps are done with no error, only then and not before, 
     * it is possible to conclude that the laf theme has been successfuly 
     * applied.
     *
     * @param currentGuiLafTheme The {@code String} representation that contains
     *                           a Look and Feel name
     * @since 1.4
     */
    public void applyThemeManager ( String currentGuiLafTheme )
    {
        themeSetter( currentGuiLafTheme ); // Applying Theme
        FlatLaf.updateUI(); // Visual Components Update-Refreshing
        DatosTickets.updateSaveOpenDlg();
    }
    
    /** Returns the application to the theme saved in user settings, this occurs
     * if user applies a certain laf theme different to the actual saved theme 
     * in user settings, but decides to click on cancel button instead ok 
     * button, so this method reverses that operation
     * 
     * @param themeInProperties The actual theme saved in user settings 
     *                          {@code Properties} object
     * 
     * @since 1.4
     */
    public void gettingBackToSavedTheme ( String themeInProperties ) // Method when the user cancel, so he doesn't actually to apply the theme, the operation is reverted and the saved theme in user properties y applied back.
    {
        applyThemeManager( themeInProperties ); // Making the Call to apply the theme
        colorOnIconsManager( ColorSetType.Runtime );
    }
    
    /** Loads the language saved in user settings properties file and sets it as
     * the current application language with that given specified saved locale, 
     * this method is mostly used when the application starts to automatically 
     * apply the right language, either the one by default or the one specified
     * by the user
     * 
     * @param strSavedLocale A locale saved in the properties file to set and 
     *                       apply the application language
     * 
     * @since 1.6
     */
    public void loadLanguageFromPreferences ( String strSavedLocale )
    {   
        setAppLanguage( strSavedLocale );
        applyLanguageInApp();
    }

    /** Applies and makes effective the already set language as the the 
     * application language to this current Java Virtual Machine as the default
     * locale making every window opens with the corresponding language, also 
     * set the corresponding proper {@code ResourceBundle} object to make all 
     * app windows texts and strings manually coded match with the new language 
     * and finally, it calls the proper method in the main window to update
     * its G.U.I. text components to the current language.
     * <p>
     * This is because when a language is set, it is set to the respective 
     * attribute, but it is not made effective, this means the application 
     * does not shows the new language yet, but this method makes the language 
     * effective and actually applies it to the application
     * 
     * @since 1.6
     */
    public void applyLanguageInApp ()
    {
        FrmCinemaTicketsSystem mainWindow = getCinemaTicketsMainFrame();        
        mainWindow.setLocaleInApp();

        languageBundle = switch ( appLanguage )
        {
            case Español -> ResourceBundle.getBundle( "internationalization/Internationalization_Bundle" );
            case English -> ResourceBundle.getBundle( "internationalization/Internationalization_Bundle_en_US" );
        };
        
        if( mainWindow.isVisible() )
            mainWindow.updateComponentsLanguage();
    }
    
    /** Gets the current CinemaTickets main window instance
     * 
     * @return The actual {@code FrmCinemaTicketsSystem} current window instance
     * @since 1.6
     * @see visual.FrmCinemaTicketsSystem
     */
    private FrmCinemaTicketsSystem getCinemaTicketsMainFrame()
    {
        FrmCinemaTicketsSystem mainWindow = null;
        
        for( Frame ctmf : FrmCinemaTicketsSystem.getFrames() )
        {
            if( ctmf != null && ctmf instanceof FrmCinemaTicketsSystem )
            {
                mainWindow = ( FrmCinemaTicketsSystem ) ctmf;
                break;
            }    
        }
        
        return mainWindow;
    }
    
    /** Converts a word to camel case, this is the first character in this 
     * String to upper case and the other characters if existing, to lower case,
     * using the rules of the default locale
     * @param word A {@code String} word to convert to camel case
     * @return The given word converted to camel case
     * @since 1.6
     */
    private String toCamelCase( String word )
    {
        if( word != null && !word.isBlank() )
        {
            if( word.length() > 1 )
            {
                word = Character.toUpperCase( word.charAt( 0 ) ) + word.substring( 1 ).toLowerCase();
            }
            else
            {
                word = word.toUpperCase();
            }
        }
        
        return word;
    }
    

    // Getters and Setters
    /** Gets a {@code String} with the application version using predefined
     * constants
     * @return This Application actual version
     * @since 1.6
     */
    public static String getAPP_VERSION ()
    {
        String APP_VERSION = "v" + VERSION_MAJOR + "." + VERSION_MINOR;

        if ( VERSION_ACCESS != null )
            APP_VERSION += "-" + VERSION_ACCESS.toString().toLowerCase();

        if ( VERSION_STATE != null )
            APP_VERSION += "-" + VERSION_STATE.toString().toLowerCase();

        return APP_VERSION;
    }

    /** Gets the Java platform version this application is currently working 
     * with
     * 
     * @return A {@code String} representation of the Java platform version this 
     *         application is currently working with
     */
    public static String getPlatform_VERSION ()
    {
        return "Java " + System.getProperty( "java.version" ) + "; OpenJDK 64-Bit Server VM 17.0.2+8-86";
    }
    /** Gets this application language
     * @return This application {@code SupportedLanguagesAndLocales enum} 
     * constant that represents the current language value applied in the application
     * @since 1.6
     */
    public static SupportedLanguagesAndLocales getAppLanguage ()
    {
        return appLanguage;
    }

    /** Sets the application language in a custom way made to accept a 
     * {@code String} parameter that caontains the language, it could be the 
     * whole word because it does a substring taking only the first 2 letters,
     * this is done this way because it works properly at least with english and
     * spanish that are the 2 unique languages available until this version at
     * least
     * 
     * @param language The {@code String} language representation to set the 
     *                 application language up
     * @since 1.6
     */
    public static void setAppLanguage ( String language )
    {
        language = language.substring( 0, 2 ).toLowerCase();
        
        for (SupportedLanguagesAndLocales ln : SupportedLanguagesAndLocales.values())
        {
            if( ln.getLanguage().equalsIgnoreCase( language ) )
            {
                AdmSettings.appLanguage = ln;
                break;
            }
        }
    }
    
    /** Gets the application language bundle
     * @return This Application proper Language {@code ResourceBundle} object
     * depending on the current locale and language set
     * @since 1.6
     */
    public static ResourceBundle getLanguageBundle ()
    {
        return languageBundle;
    }
    /** Gets the current applied graphical user interface look and feel theme
     * @return A {@code String} that contains the Current Applied Gui Laf Theme
     * representation
     * @since 1.4
     */
    public String getCurrentAppliedGuiLafTheme ()
    {
        return currentAppliedGuiLafTheme;
    }
    /** Sets the current applied graphical user interface look and feel theme
     * @param currentAppliedGuiLafTheme A {@code String} representation of the
     *                                  Current Applied Gui Laf Theme
     * @since 1.4
     */
    public void setCurrentAppliedGuiLafTheme ( String currentAppliedGuiLafTheme )
    {
        this.currentAppliedGuiLafTheme = currentAppliedGuiLafTheme;
    }
    /** Gets the current selected graphical user interface look and feel theme
     * @return A {@code String} that contains the current selected graphical 
     * user interface look and feel theme representation
     * @since 1.4
     */
    public String getCurrentSelectedGuiLafTheme ()
    {
        return currentSelectedGuiLafTheme;
    }
    /** Sets the current selected graphical user interface look and feel theme
     * @param currentSelectedGuiLafTheme A {@code String} representation of the
     *                                   Current Selected Gui Laf Theme
     * @since 1.4
     */
    public void setCurrentSelectedGuiLafTheme ( String currentSelectedGuiLafTheme )
    {
        this.currentSelectedGuiLafTheme = currentSelectedGuiLafTheme;
    }
    /** Gets the current App Data Mode Setting
     * @return A {@code DataMode enum} constant that represents the current App
     * Data Mode Setting
     * @since 1.6
     */
    public DataMode getAppDataMode ()
    {
        return appDataMode;
    }
    /** Sets the current App Data Mode Setting
     * @param appDataMode A {@code String} representation of the App Data Mode 
     *                    in the application
     * @since 1.6
     */
    public void setAppDataMode ( String appDataMode )
    {
        this.appDataMode = DataMode.valueOf( toCamelCase( appDataMode ) );
    }
    /** Gets the current Client Data Mode Setting
     * @return A {@code DataMode enum} constat that represents the current 
     * Client Data Mode Setting
     * @since 1.6
     */
    public DataMode getClientDataMode ()
    {
        return clientDataMode;
    }
    /** Sets the current Client Data Mode Setting
     * @param clientDataMode A {@code String} representation of the Client Data 
     *                       Mode in the application
     * @since 1.6
     */
    public void setClientDataMode ( String clientDataMode )
    {
        this.clientDataMode = DataMode.valueOf( toCamelCase( clientDataMode ) );
    }
    /** Gets the applying theme pending indicator
     * @return {@code true} if a theme is pending to apply, {@code false} 
     * otherwise
     * @since 1.4
     */
    public boolean isApplyingThemePending ()
    {
        return applyingThemePending;
    }
    /** Sets the applying theme pending indicator
     * @param applyingThemePending  A {@code boolean} representation that 
     *                              indicates that a themre is pending to apply
     * @since 1.4
     */
    public void setApplyingThemePending ( boolean applyingThemePending )
    {
        this.applyingThemePending = applyingThemePending;
    }
    /** Gets the type to save Cinema Tickets files
     * @return The {@code FileType} enum constant that indicates the file type 
     * format specified in settings that shall be used to save Cinema Tickets 
     * files
     * @since 1.6
     */
    public Commons.FileType getFileTypeToSave ()
    {
        return fileTypeToSave;
    }
    /** Sets the file type setting property the application has to use to save 
     * files, this is made in a custom way accepting a {@code String} as file 
     * type parameter and converting it to the respective enum constant that is
     * actually the one used as file type attribute in the application
     * 
     * @param fileType A {@code String} representation that contains the file 
     *                 type to set
     * 
     * @since 1.6
     * @see data.DatosTickets
     */
    public void setFileTypeToSave ( String fileType )
    {
        this.fileTypeToSave = Commons.FileType.valueOf( toCamelCase( fileType ) );
    }
    /** Gets the application starting folder value
     * @return A {@code String} representation that contains the application
     * starting folder set in settings or the value by default
     * @since 1.6
     */
    public String getStartingFolder ()
    {
        return startingFolder;
    }
    /** Sets the application starting folder value
     * @param startingFolder A {@code String} representation that contains the 
     *                       application starting folder value
     * @since 1.6
     */
    public void setStartingFolder ( String startingFolder )
    {
        this.startingFolder = startingFolder;
    }
    /** Gets the icon choosed to represent the action "add client" in double of 
     * normal size for use on windows title bars and buttons
     * @return A {@code FlatSVGIcon} icon object with the proper icon
     * @since 1.5
     */
    public FlatSVGIcon getAddClientForClientManualInputDialog ()
    {
        return addClientForClientManualInputDialog;
    }
    /** Gets the icon choosed to represent the action "save" in normal size used
     * commonly in menus
     * @return A {@code FlatSVGIcon} icon object with the proper icon
     * @since 1.5
     */
    public FlatSVGIcon getSaveIcon ()
    {
        return saveIcon;
    }
    /** Gets the icon choosed to represent the action "search" in normal size used
     * commonly in menus
     * @return A {@code FlatSVGIcon} icon object with the proper icon
     * @since 1.5
     */
    public FlatSVGIcon getSearchIcon ()
    {
        return searchIcon;
    }
    /** Gets the icon choosed to represent the action "search" in double of 
     * normal size for use on windows title bars and buttons
     * @return A {@code FlatSVGIcon} icon object with the proper icon
     * @since 1.5
     */
    public FlatSVGIcon getSearchIconForSearchForm ()
    {
        return searchIconForSearchForm;
    }
    /** Gets the icon choosed to represent the action "add" in normal size used
     * commonly in menus
     * @return A {@code FlatSVGIcon} icon object with the proper icon
     * @since 1.5
     */
    public FlatSVGIcon getAddIcon ()
    {
        return addIcon;
    }
    /** Gets the icon choosed to represent the action "delete" in normal size used
     * commonly in menus
     * @return A {@code FlatSVGIcon} icon object with the proper icon
     * @since 1.5
     */
    public FlatSVGIcon getDeleteIcon ()
    {
        return deleteIcon;
    }
    /** Gets the icon choosed to represent the action "edit" in normal size used
     * commonly in menus
     * @return A {@code FlatSVGIcon} icon object with the proper icon
     * @since 1.5
     */
    public FlatSVGIcon getEditIcon ()
    {
        return editIcon;
    }
    /** Gets the icon choosed to represent the action "edit" in double of 
     * normal size for use on windows title bars and buttons
     * @return A {@code FlatSVGIcon} icon object with the proper icon
     * @since 1.5
     */
    public FlatSVGIcon getEditIconForSearchForm ()
    {
        return editIconForSearchForm;
    }
    /** Gets the icon choosed to represent the action "attribution" in normal 
     * size used commonly in menus
     * @return A {@code FlatSVGIcon} icon object with the proper icon
     * @since 1.5
     */
    public FlatSVGIcon getGroupsAttributionIcon ()
    {
        return groupsAttributionIcon;
    }
    /** Gets the icon choosed to represent the action "about project" in normal
     * size used commonly in menus
     * @return A {@code FlatSVGIcon} icon object with the proper icon
     * @since 1.5
     */
    public FlatSVGIcon getInfoIcon ()
    {
        return infoIcon;
    }
    /** Gets the icon choosed to represent the action "settings" in normal
     * size used commonly in menus
     * @return A {@code FlatSVGIcon} icon object with the proper icon
     * @since 1.5
     */
    public FlatSVGIcon getSettingsIcon ()
    {
        return settingsIcon;
    }
    /** Gets the icon choosed to represent the action "open" in normal
     * size used commonly in menus
     * @return A {@code FlatSVGIcon} icon object with the proper icon
     * @since 1.5
     */
    public FlatSVGIcon getSourceOpenIcon ()
    {
        return sourceOpenIcon;
    }
    /** Gets the icon choosed to represent the action "add" in double of 
     * normal size for use on windows title bars and buttons
     * @return A {@code FlatSVGIcon} icon object with the proper icon
     * @since 1.5
     */
    public FlatSVGIcon getAddIconForGenerateForm ()
    {
        return addIconForGenerateForm;
    }
    /** Gets the icon choosed to represent the action "open" in double of 
     * normal size for use on windows title bars and buttons
     * @return A {@code FlatSVGIcon} icon object with the proper icon
     * @since 1.5
     */
    public FlatSVGIcon getSourceOpenIconForOpenDialog ()
    {
        return sourceOpenIconForOpenDialog;
    }
    /** Gets the icon choosed to represent the action "save" in double of 
     * normal size for use on windows title bars and buttons
     * @return A {@code FlatSVGIcon} icon object with the proper icon
     * @since 1.5
     */
    public FlatSVGIcon getSaveIconForSaveDialog ()
    {
        return saveIconForSaveDialog;
    }
    /** Gets the icon choosed to represent the action "settings" in double of 
     * normal size for use on windows title bars and buttons
     * @return A {@code FlatSVGIcon} icon object with the proper icon
     * @since 1.5
     */
    public FlatSVGIcon getSettingsIconForSettingsForm ()
    {
        return settingsIconForSettingsForm;
    }
    /** Gets the icon choosed to represent the action "attribution" in double of 
     * normal size for use on windows title bars and buttons
     * @return A {@code FlatSVGIcon} icon object with the proper icon
     * @since 1.5
     */
    public FlatSVGIcon getGroupsAttributionIconForAttributionForm ()
    {
        return groupsAttributionIconForAttributionForm;
    }
    /** Gets the icon choosed to represent the action "about project" in double
     * of normal size for use on windows title bars and buttons
     * @return A {@code FlatSVGIcon} icon object with the proper icon
     * @since 1.5
     */
    public FlatSVGIcon getInfoIconForAboutDeveloperForm ()
    {
        return infoIconForAboutDeveloperForm;
    }
    /** Gets the icon choosed to represent the action "movies" in normal
     * size used commonly in menus
     * @return A {@code FlatSVGIcon} icon object with the proper icon
     * @since 1.5
     */
    public FlatSVGIcon getMoviesIcon ()
    {
        return moviesIcon;
    }
    /** Gets the icon choosed to represent the action "movies" in double of 
     * normal size for use on windows title bars and buttons
     * @return A {@code FlatSVGIcon} icon object with the proper icon
     * @since 1.5
     */
    public FlatSVGIcon getMoviesIconForMoviesForm ()
    {
        return moviesIconForMoviesForm;
    }
    /** Gets the icon choosed to represent the action "shows" in normal
     * size used commonly in menus
     * @return A {@code FlatSVGIcon} icon object with the proper icon
     * @since 1.5
     */
    public FlatSVGIcon getShowsIcon ()
    {
        return showsIcon;
    }
    /** Gets the icon choosed to represent the action "shows" in double of 
     * normal size for use on windows title bars and buttons
     * @return A {@code FlatSVGIcon} icon object with the proper icon
     * @since 1.5
     */
    public FlatSVGIcon getShowsIconForShowsForm ()
    {
        return showsIconForShowsForm;
    }
    /** Gets the icon choosed to represent the action "theaters" in normal
     * size used commonly in menus
     * @return A {@code FlatSVGIcon} icon object with the proper icon
     * @since 1.5
     */
    public FlatSVGIcon getTheatersIcon ()
    {
        return theatersIcon;
    }
    /** Gets the icon choosed to represent the action "theaters" in double of 
     * normal size for use on windows title bars and buttons
     * @return A {@code FlatSVGIcon} icon object with the proper icon
     * @since 1.5
     */
    public FlatSVGIcon getTheatersIconForTheatersForm ()
    {
        return theatersIconForTheatersForm;
    }
    /** Gets the icon choosed to represent the action "exit" in normal
     * size used commonly in menus
     * @return A {@code FlatSVGIcon} icon object with the proper icon
     * @since 1.5
     */
    public FlatSVGIcon getPowerExitIcon ()
    {
        return powerExitIcon;
    }
    /** Gets the icon choosed to represent the action "copy" in normal
     * size used commonly in menus
     * @return A {@code FlatSVGIcon} icon object with the proper icon
     * @since 1.5
     */
    public FlatSVGIcon getCopyIcon ()
    {
        return copyIcon;
    }

}
