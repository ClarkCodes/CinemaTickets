
package controlTesting;

import control.AdmPelicula;
import control.AdmPelicula.MovieGenres;
import control.AdmSettings;
import java.util.LinkedList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import control.Commons;
import model.Funcion;
import model.Pelicula;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import visual.FrmCinemaTicketsSystem;

/** Unit Testing Class for AdmPelicula
 * @author ClarkCodes */
public class AdmPeliculaTest
{
    private static AdmPelicula admPelicula;
    
    @BeforeAll
    public static void setUp()
    {
        FrmCinemaTicketsSystem mainWindow = new FrmCinemaTicketsSystem();
        admPelicula = AdmPelicula.getAdm();
    }
    
    @Test
    public void admPeliculaMustNotBeNull()
    {
        Assertions.assertNotNull( admPelicula );
        Assertions.assertInstanceOf( AdmPelicula.class, admPelicula );
    }
    
    @Test
    public void fillMoviesCombo_elementsInTheComboShouldBe()
    {
        JComboBox comboMovies = new JComboBox();
        admPelicula.llenarComboPeliculas( comboMovies, Commons.WindowMode.Creacion );

        Assertions.assertTrue( comboMovies.getItemCount() > 1 );
        
        switch ( AdmSettings.getAppLanguage() )
        {
            case Español -> Assertions.assertNotEquals( "Todas", comboMovies.getItemAt( 0 ).toString() );
            case English -> Assertions.assertNotEquals( "All", comboMovies.getItemAt( 0 ).toString() );
        }
        
        comboMovies = new JComboBox();
        admPelicula.llenarComboPeliculas( comboMovies, Commons.WindowMode.Busqueda );
        
        combosFirstElementShouldBe( comboMovies, "Todas" );
    }
    
    @Test
    public void fillGenresCombo_elementsInTheComboShouldBe()
    {
        JComboBox comboGenres = new JComboBox();
        admPelicula.llenarComboGenerosPeliculas( comboGenres );

        combosFirstElementShouldBe( comboGenres, "Todos" );
    }
    
    @Test
    public void fillMoviesLanguagesCombo_elementsInTheComboShouldBe()
    {
        JComboBox comboMovieLanguages = new JComboBox();
        admPelicula.llenarComboIdiomasPeliculas( comboMovieLanguages );

        combosFirstElementShouldBe( comboMovieLanguages, "Todos" );
    }
    
    @Test
    public void fillMoviesSubtitlesLanguagesCombo_elementsInTheComboShouldBe()
    {
        JComboBox comboMovieSubLanguages = new JComboBox();
        admPelicula.llenarComboSubtitulosPeliculas( comboMovieSubLanguages );

        combosFirstElementShouldBe( comboMovieSubLanguages, "Todos" );
    }

    private void combosFirstElementShouldBe ( JComboBox combo, String all_Sp )
    {
        Assertions.assertTrue( combo.getItemCount() > 1 );
        
        switch ( AdmSettings.getAppLanguage() )
        {
            case Español -> Assertions.assertEquals( all_Sp, combo.getItemAt( 0 ).toString() );
            case English -> Assertions.assertEquals( "All", combo.getItemAt( 0 ).toString() );
        }
    }
    
    @Test
    public void getMovie_MustNotBeNull_And_MustBeAPeliculaObject()
    {
        Pelicula movie = admPelicula.obtenerPelicula( "Free Guy" );
        Assertions.assertNotNull( movie );
        Assertions.assertInstanceOf( Pelicula.class, movie );
    }
    
    @Test
    public void fillSelectedMovieTable_TableDataMustBe()
    {
        LinkedList<String> horariosActuales = new LinkedList<>();
        LinkedList<String> horariosEsperados = new LinkedList<>();
        Pelicula movie = admPelicula.obtenerPelicula( "Free Guy" );
        JComboBox comboHorariosDisponibles = new JComboBox();
        JTable movieTable = new JTable();
        
        // Setting the necessary table model
        movieTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Codigo", "Genero", "Idioma", " Subtítulos", "Duracion"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });

        // Populating the table
        admPelicula.llenarTablaPeliculaElegida( movie.getId(), movieTable, comboHorariosDisponibles );
        
        // Making Expected Showtimes
        movie.getHorariosDisponibles().forEach( h -> horariosEsperados.add( h.format( Commons.getFormatoDateTime( Commons.TypeFormatoDateTime.HorasMinutos ) ) ) );
        
        // Getting showtimes that exist in the showtimes JComboBox
        for ( int itemIndex = 0; itemIndex < comboHorariosDisponibles.getItemCount(); itemIndex++ )
        {
            if ( comboHorariosDisponibles.getItemAt( itemIndex ) instanceof String criteria )
                horariosActuales.add( criteria );
        }

        // Asserting the table and the comboBox content
        Assertions.assertEquals( movie.getId(), movieTable.getValueAt( 0, 0 ) );
        Assertions.assertEquals( AdmSettings.getLanguageBundle().getString( movie.getGenero().getLangKey() ), movieTable.getValueAt( 0, 1 ) );
        Assertions.assertEquals( movie.getIdioma(), movieTable.getValueAt( 0, 2 ) );
        Assertions.assertEquals( movie.isTieneSubtitulos() ? movie.getIdiomaSubtitulos() : "N/A", movieTable.getValueAt( 0, 3 ) );
        Assertions.assertEquals( movie.obtenerDuracionFormateada(), movieTable.getValueAt( 0, 4 ) );
        
        // Asserting available showtimes
        Assertions.assertArrayEquals( horariosEsperados.toArray( String[]::new ) , horariosActuales.toArray( String[]::new ) );
    }
    
    @Test
    public void getShowtime_MustNotBeNull_And_MustBeAPeliculaObject()
    {
        Pelicula movie = admPelicula.obtenerPelicula( "Free Guy" );
        Funcion showtime = admPelicula.obtenerFuncion( movie.getHorariosDisponibles().get( 0 ).toString(), "Free Guy" );
        Assertions.assertNotNull( showtime );
        Assertions.assertInstanceOf( Funcion.class, showtime );
        Assertions.assertEquals( movie.getHorariosDisponibles().get( 0 ), showtime.getHorarioElegido() );
    }
    
    @Test
    public void movieGenres_MustBe() //Tests the enum MovieGenres, that its method getLangKey works right
    {
        Assertions.assertEquals( "Drama", AdmSettings.getLanguageBundle().getString( AdmPelicula.MovieGenres.Drama.getLangKey() ) );
        Assertions.assertEquals( "Horror-Terror", AdmSettings.getLanguageBundle().getString( AdmPelicula.MovieGenres.Horror_Terror.getLangKey() ) );
        Assertions.assertEquals( "Sci-Fi", AdmSettings.getLanguageBundle().getString( AdmPelicula.MovieGenres.Sci_Fi.getLangKey() ) );
        
        switch ( AdmSettings.getAppLanguage() )
        {
            case Español -> 
            {
                Assertions.assertEquals( "Acción", AdmSettings.getLanguageBundle().getString( AdmPelicula.MovieGenres.Action.getLangKey() ) );
                Assertions.assertEquals( "Comedia", AdmSettings.getLanguageBundle().getString( AdmPelicula.MovieGenres.Comedy.getLangKey() ) );
                Assertions.assertEquals( "Sci-Fi de videojuegos", AdmSettings.getLanguageBundle().getString( AdmPelicula.MovieGenres.Gaming_Sci_Fi.getLangKey() ) );
                Assertions.assertEquals( "Sci-Fi de Super héroes", AdmSettings.getLanguageBundle().getString( AdmPelicula.MovieGenres.Super_Hero_Sci_Fi.getLangKey() ) );
            }
            case English -> 
            {
                Assertions.assertEquals( "Action", AdmSettings.getLanguageBundle().getString( AdmPelicula.MovieGenres.Action.getLangKey() ) );
                Assertions.assertEquals( "Comedy", AdmSettings.getLanguageBundle().getString( AdmPelicula.MovieGenres.Comedy.getLangKey() ) );
                Assertions.assertEquals( "Gaming Sci-Fi", AdmSettings.getLanguageBundle().getString( AdmPelicula.MovieGenres.Gaming_Sci_Fi.getLangKey() ) );
                Assertions.assertEquals( "SuperHero Sci-Fi", AdmSettings.getLanguageBundle().getString( AdmPelicula.MovieGenres.Super_Hero_Sci_Fi.getLangKey() ) );
            }
        }
    }
    
    @Test
    public void valueOfLangKey_MustBe()
    {
        String[] movieGenresKeys = { "lk_movie_genre_comedy", "lk_movie_genre_scifi", "lk_movie_genre_action", "lk_movie_genre_gaming_scifi", "lk_movie_genre_superhero_scifi", "lk_movie_genre_horror_terror", "lk_movie_genre_drama" };
        int i = 0;
        
        for( MovieGenres genre : MovieGenres.values() )
        {
            Assertions.assertEquals( genre, AdmPelicula.MovieGenres.valueOfLangKey( movieGenresKeys[i] ) );
            i++;
        }        
    }
    
    @Test
    public void valueOfLocalizedString_MustBe()
    {
        Assertions.assertEquals( MovieGenres.Drama, MovieGenres.valueOfLocalizedString( "Drama" ) );
        Assertions.assertEquals( MovieGenres.Horror_Terror, MovieGenres.valueOfLocalizedString( "Horror-Terror" ) );
        Assertions.assertEquals( MovieGenres.Sci_Fi, MovieGenres.valueOfLocalizedString( "Sci-Fi" ) );
        
        switch ( AdmSettings.getAppLanguage() )
        {
            case Español -> 
            {
                Assertions.assertEquals( MovieGenres.Action, MovieGenres.valueOfLocalizedString( "Acción" ) );
                Assertions.assertEquals( MovieGenres.Comedy, MovieGenres.valueOfLocalizedString( "Comedia" ) );
                Assertions.assertEquals( MovieGenres.Gaming_Sci_Fi, MovieGenres.valueOfLocalizedString( "Sci-Fi de videojuegos" ) );
                Assertions.assertEquals( MovieGenres.Super_Hero_Sci_Fi, MovieGenres.valueOfLocalizedString( "Sci-Fi de Super héroes" ) );
            }
            case English -> 
            {
                Assertions.assertEquals( MovieGenres.Action, MovieGenres.valueOfLocalizedString( "Action" ) );
                Assertions.assertEquals( MovieGenres.Comedy, MovieGenres.valueOfLocalizedString( "Comedy" ) );
                Assertions.assertEquals( MovieGenres.Gaming_Sci_Fi, MovieGenres.valueOfLocalizedString( "Gaming Sci-Fi" ) );
                Assertions.assertEquals( MovieGenres.Super_Hero_Sci_Fi, MovieGenres.valueOfLocalizedString( "SuperHero Sci-Fi" ) );
            }
        }
    }
    
}
