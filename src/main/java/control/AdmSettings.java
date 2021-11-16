package control;
// Imports
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import data.DatosTickets;
import com.formdev.flatlaf.intellijthemes.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/** Settings Mamagement Class, hosts tasks and important things related to it
 * @author Clark - ClarkCodes
 * @since 1.3
 */
public class AdmSettings 
{   
    private final static String APP_VERSION = "public-stable-1.5"; // Application Version Constant
    // Fields, Attributes - Properties    
    private final ArrayList<String> availableFlatLafThemes; // Main Lists of Themes - These lists will be useful to fulfill the combo boxes of Settings Window
    private final ArrayList<String> availableIntelliJThemes;
    
    // Icons
    private final int PX_X2; // Tamanio en pixeles que ocuparan los iconos con doble tamanio, los normales miden 16x16 pixeles ergo los x2 miden 32x32 pixeles.
    private FlatSVGIcon addIcon;
    private FlatSVGIcon addIconForGenerateForm;
    private FlatSVGIcon searchIcon;
    private FlatSVGIcon searchIconForSearchForm;
    private FlatSVGIcon editIcon;
    private FlatSVGIcon editIconForSearchForm;
    private FlatSVGIcon deleteIcon;
    private FlatSVGIcon deleteIconForSearchForm;
    private FlatSVGIcon sourceOpenIcon;
    private FlatSVGIcon sourceOpenIconForOpenDialog;
    private FlatSVGIcon saveIcon;
    private FlatSVGIcon saveIconForSaveDialog;
    private FlatSVGIcon settingsIcon;
    private FlatSVGIcon settingsIconForSettingsForm;
    private FlatSVGIcon powerExitIcon;
    private FlatSVGIcon groupsAttributionIcon;
    private FlatSVGIcon groupsAttributionIconForAttributionForm;
    private FlatSVGIcon infoIcon;
    private FlatSVGIcon infoIconForAboutDeveloperForm;
    
    //Enum Helper to Set the SVG Icon Color Filters
    public static enum ColorSetType
    {
        Startup,
        Runtime
    }
    // Singleton Pattern
    /** Sole Constructor which loads the {@code AdmSettings} unique instance following Singleton Design Pattern */
    private AdmSettings()
    {
        availableFlatLafThemes = new ArrayList<>();
        availableIntelliJThemes = new ArrayList<>();
        this.PX_X2 = 32; // Definiendo la constante de tamanio en pixeles de iconos x2.
        initSettings();
    }
    
    // Singleton Pattern
    private static AdmSettings admSettings = null;
    /** Gets the unique instance of this class, following Singleton Desing Pattern in Development
     * @return The Unique {@code AdmSettings} instance
     */
    public static AdmSettings getAdmSettings()
    {
        if(admSettings == null)
            admSettings = new AdmSettings();
        return admSettings;
    }
    
    /** Initializes and sorts predefined GUI Laf themes from FlatLaf */
    private void initSettings()
    {   // Adding items to the List
        availableFlatLafThemes.add("Flat Dark");
        availableFlatLafThemes.add("Flat Light");
        availableIntelliJThemes.add("Flat IntelliJ Light");
        availableIntelliJThemes.add("Flat IntelliJ Dark");
        availableIntelliJThemes.add("Flat Darcula");
        availableIntelliJThemes.add("Dracula");
        availableIntelliJThemes.add("Arc Dark (Material)");
        availableIntelliJThemes.add("Arc Dark Orange");
        availableIntelliJThemes.add("Arc Orange");
        availableIntelliJThemes.add("One Dark");
        availableIntelliJThemes.add("Dark Purple");
        availableIntelliJThemes.add("Carbon");
        availableIntelliJThemes.add("Cobalt 2");
        availableIntelliJThemes.add("Gradianto Dark Fuchsia");
        availableIntelliJThemes.add("Gradianto Deep Ocean");
        availableIntelliJThemes.add("Gradianto Midnight Blue");
        availableIntelliJThemes.add("Gradianto Nature Green");
        availableIntelliJThemes.add("Gruvbox Dark Hard");
        availableIntelliJThemes.add("Gruvbox Dark Medium");
        availableIntelliJThemes.add("Hiberbee Dark");
        availableIntelliJThemes.add("Material Design Dark");
        availableIntelliJThemes.add("Monocai");
        availableIntelliJThemes.add("Solarized Dark");
        availableIntelliJThemes.add("Solarized Light");
        availableIntelliJThemes.add("Solarized Dark (Material)");
        availableIntelliJThemes.add("Solarized Light (Material)");
        availableIntelliJThemes.add("Atom One Dark (Material)");
        availableIntelliJThemes.add("Atom One Light (Material)");
        availableIntelliJThemes.add("GitHub (Material)");
        availableIntelliJThemes.add("GitHub Dark (Material)");
        availableIntelliJThemes.add("Material Darker (Material)");
        availableIntelliJThemes.add("Material Deep Ocean (Material)");
        availableIntelliJThemes.add("Material Oceanic (Material)");
        availableIntelliJThemes.add("Material Palenight (Material)");
        availableIntelliJThemes.add("Monokai Pro (Material)");
        availableIntelliJThemes.add("Moonlight (Material)");
        availableIntelliJThemes.add("Night Owl (Material)");

        // Sorting
        Collections.sort(availableFlatLafThemes);
        Collections.sort(availableIntelliJThemes);
        
        // Icons
        addIcon = new FlatSVGIcon("add_white_18dp.svg");
        addIconForGenerateForm = new FlatSVGIcon("add_white_18dp.svg", PX_X2, PX_X2);
        searchIcon = new FlatSVGIcon("search_white_18dp.svg");
        searchIconForSearchForm = new FlatSVGIcon("search_white_18dp.svg", PX_X2, PX_X2);
        editIcon = new FlatSVGIcon("edit_white_18dp.svg");
        editIconForSearchForm = new FlatSVGIcon("edit_white_18dp.svg", PX_X2, PX_X2);
        deleteIcon = new FlatSVGIcon("delete_white_18dp.svg");
        deleteIconForSearchForm = new FlatSVGIcon("delete_white_18dp.svg", PX_X2, PX_X2);
        sourceOpenIcon = new FlatSVGIcon("source_white_18dp.svg");
        sourceOpenIconForOpenDialog = new FlatSVGIcon("source_white_18dp.svg", PX_X2, PX_X2);
        saveIcon = new FlatSVGIcon("save_white_18dp.svg");
        saveIconForSaveDialog = new FlatSVGIcon("save_white_18dp.svg", PX_X2, PX_X2);
        settingsIcon = new FlatSVGIcon("settings_white_18dp.svg");
        settingsIconForSettingsForm = new FlatSVGIcon("settings_white_18dp.svg", PX_X2, PX_X2);
        powerExitIcon = new FlatSVGIcon("settings_power_white_18dp.svg");
        groupsAttributionIcon = new FlatSVGIcon("groups_white_18dp.svg");
        groupsAttributionIconForAttributionForm = new FlatSVGIcon("groups_white_18dp.svg", PX_X2, PX_X2);
        infoIcon = new FlatSVGIcon("info_white_18dp.svg");
        infoIconForAboutDeveloperForm = new FlatSVGIcon("info_white_18dp.svg", PX_X2, PX_X2);
    }
    
    /** Sets the respective filtering color on svg icons to match properly with every theme set by user either 
     * in app startup matching with saved theme or in runtime when changing themes
     * @param colorSetType the type either startup or runtime from the respective ColorSetType Enum
     */
    public void colorOnIconsManager(ColorSetType colorSetType)
    {
        if(colorSetType.equals(ColorSetType.Runtime))
            FlatSVGIcon.ColorFilter.getInstance().removeAll();
        
        FlatSVGIcon.ColorFilter.getInstance().add(Color.WHITE, UIManager.getColor("MenuItem.foreground")); // Taking the Colors from UI MenuItem foreground for Icons and Setting the color for all FlatSVGIcons in use
    }
    
    /** Fills a given {@code JComboBox} with the available pre-set FlatLaf Themes list
     * @param flatLafCombo The {@code JComboBox} to be filled with FlatLaf Themes
     */
    public void fillFlatLafCombo(JComboBox flatLafCombo)
    {
        this.availableFlatLafThemes.forEach(theme -> { flatLafCombo.addItem(theme); });
    }
    
    /** Fills a given {@code JComboBox} with the available pre-set FlatLaf IntelliJ Themes list
     * @param intelliJCombo The {@code JComboBox} to be filled with IntelliJ Themes
     */
    public void fillIntelliJCombo(JComboBox intelliJCombo)
    {
        this.availableIntelliJThemes.forEach(theme -> { intelliJCombo.addItem(theme); });
    }
    
    /** Sets a Look and Feel Theme on the Application with a given {@code String} name
     * @param themeToSet The {@code String} Look and Feel name
     */
    public void themeSetter(String themeToSet)
    {
        var theme = switch(themeToSet) 
        {
            case "Flat Dark": yield new com.formdev.flatlaf.FlatDarkLaf();
            case "Flat Light": yield new com.formdev.flatlaf.FlatLightLaf();
            case "Flat Darcula": yield new com.formdev.flatlaf.FlatDarculaLaf();
            case "Dracula": yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatDraculaIJTheme();
            case "Flat IntelliJ Light": yield new FlatLightFlatIJTheme();
            case "Flat IntelliJ Dark": yield new FlatDarkFlatIJTheme();
            case "Arc Dark (Material)": yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkIJTheme();
            case "Arc Dark Orange": yield new FlatArcDarkOrangeIJTheme();
            case "Arc Orange": yield new FlatArcOrangeIJTheme();
            case "One Dark": yield new FlatOneDarkIJTheme();
            case "Dark Purple": yield new FlatDarkPurpleIJTheme();
            case "Monocai": yield new FlatMonocaiIJTheme();
            case "Solarized Dark": yield new FlatSolarizedDarkIJTheme();
            case "Solarized Light": yield new FlatSolarizedLightIJTheme();
            case "Solarized Dark (Material)": yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatSolarizedDarkIJTheme();
            case "Solarized Light (Material)": yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatSolarizedLightIJTheme();
            case "Carbon": yield new FlatCarbonIJTheme();
            case "Cobalt 2": yield new FlatCobalt2IJTheme();
            case "Gradianto Dark Fuchsia": yield new FlatGradiantoDarkFuchsiaIJTheme();
            case "Gradianto Deep Ocean": yield new FlatGradiantoDeepOceanIJTheme();
            case "Gradianto Midnight Blue": yield new FlatGradiantoMidnightBlueIJTheme();
            case "Gradianto Nature Green": yield new FlatGradiantoNatureGreenIJTheme();
            case "Gruvbox Dark Hard": yield new FlatGruvboxDarkHardIJTheme();
            case "Gruvbox Dark Medium": yield new FlatGruvboxDarkMediumIJTheme();
            case "Hiberbee Dark": yield new FlatHiberbeeDarkIJTheme();
            case "Atom One Dark (Material)": yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme();
            case "Atom One Light (Material)": yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightIJTheme();
            case "GitHub (Material)": yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubIJTheme();
            case "GitHub Dark (Material)": yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkIJTheme();
            case "Material Darker (Material)": yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDarkerIJTheme();
            case "Material Design Dark": yield new FlatMaterialDesignDarkIJTheme();
            case "Material Deep Ocean (Material)": yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDeepOceanIJTheme();
            case "Material Oceanic (Material)": yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialOceanicIJTheme();
            case "Material Palenight (Material)": yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialPalenightIJTheme();
            case "Monokai Pro (Material)": yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMonokaiProIJTheme();
            case "Moonlight (Material)": yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMoonlightIJTheme();
            case "Night Owl (Material)": yield new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlIJTheme();
            default: yield null;
        };
        
        try
        {
            UIManager.setLookAndFeel(theme); // Aplicamos el Tema tal cual
        }
        catch (UnsupportedLookAndFeelException ex)
        {
            Logger.getLogger(AdmSettings.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al establecer el Tema: \n" + ex.getMessage(), "Error de Laf UI", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /** Manages the set of Look and Feel Theme on the Application with a given Look and Feel {@code String} name,
     * following 3 needed steps.
     * <p>
     * The first step is to call the method {@code themeSetter}, which is the one in charge to apply the theme
     * sending the Laf name to it as parameter.
     * <p>
     * The second step is to call the FlatLaf method to update all the current Application UI.
     * <p>
     * And the third step is to update properly the {@code JFileChooser} used to open and save Cinema Tickets files,
     * calling the method in charge.
     * @param currentGuiLafTheme The {@code String} Look and Feel name
     */
    public void applyThemeManager(String currentGuiLafTheme)
    {
        themeSetter(currentGuiLafTheme); // Applying Theme
        FlatLaf.updateUI(); // Visual Components Update-Refreshing
        DatosTickets.updateSaveOpenDlg();
    }

    // Getters and Setters
    public FlatSVGIcon getSaveIcon()
    {
        return saveIcon;
    }

    public FlatSVGIcon getSearchIcon()
    {
        return searchIcon;
    }

    public FlatSVGIcon getSearchIconForSearchForm()
    {
        return searchIconForSearchForm;
    }

    public FlatSVGIcon getAddIcon()
    {
        return addIcon;
    }

    public FlatSVGIcon getDeleteIcon()
    {
        return deleteIcon;
    }

    public FlatSVGIcon getDeleteIconForSearchForm()
    {
        return deleteIconForSearchForm;
    }

    public FlatSVGIcon getEditIcon()
    {
        return editIcon;
    }

    public FlatSVGIcon getEditIconForSearchForm()
    {
        return editIconForSearchForm;
    }

    public FlatSVGIcon getGroupsAttributionIcon()
    {
        return groupsAttributionIcon;
    }

    public FlatSVGIcon getInfoIcon()
    {
        return infoIcon;
    }

    public FlatSVGIcon getPowerExitIcon()
    {
        return powerExitIcon;
    }

    public FlatSVGIcon getSettingsIcon()
    {
        return settingsIcon;
    }

    public FlatSVGIcon getSourceOpenIcon()
    {
        return sourceOpenIcon;
    }

    public static String getAPP_VERSION()
    {
        return APP_VERSION;
    }

    public FlatSVGIcon getAddIconForGenerateForm()
    {
        return addIconForGenerateForm;
    }

    public FlatSVGIcon getSourceOpenIconForOpenDialog()
    {
        return sourceOpenIconForOpenDialog;
    }

    public FlatSVGIcon getSaveIconForSaveDialog()
    {
        return saveIconForSaveDialog;
    }

    public FlatSVGIcon getSettingsIconForSettingsForm()
    {
        return settingsIconForSettingsForm;
    }

    public FlatSVGIcon getGroupsAttributionIconForAttributionForm()
    {
        return groupsAttributionIconForAttributionForm;
    }

    public FlatSVGIcon getInfoIconForAboutDeveloperForm()
    {
        return infoIconForAboutDeveloperForm;
    }
    
}
