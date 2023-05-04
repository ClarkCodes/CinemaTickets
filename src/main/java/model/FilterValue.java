
package model;

import control.Commons;

/* LICENSE
 * Creative Commons Zero v1.0 Universal
 * CC0 1.0 Universal
 * Please check out the license file in this project's root folder.
 */
/** Helper Static Class for referencing values setting and getting them for
 * searchs filtering purposes
 *
 * @author Clark - ClarkCodes
 * @since 1.6
 */
public final class FilterValue
{
    private static Commons.ClientCriterias clientAgeCriteria;
    private static control.AdmPelicula.MovieGenres movieGenreSearching;
    private static String cedulaSearching = "", movieNameSearching = "", movieLanguageSearching = "", movieSubSearching = "";
    private static double ticketPriceSearching = 0.0;
    private static int clientAgeSearching = 0;
    private static char clientGenderSearching = 'M';

    // Getters and Setters
    /** Gets the specified client age criteria to perform searches
     * @return This Class temporary {@code Commons.ClientCriterias enum} 
     * criteria constant
     * @see control.AdmTicket
     */
    public static Commons.ClientCriterias getClientAgeCriteria ()
    {
        return clientAgeCriteria;
    }
    /** Sets the client age criteria to perform searches
     * @param clientAgeCriteria This Class temporary 
     *                          {@code Commons.ClientCriterias enum} criteria 
     *                          constant
     * @see control.AdmTicket
     */
    public static void setClientAgeCriteria ( Commons.ClientCriterias clientAgeCriteria )
    {
        FilterValue.clientAgeCriteria = clientAgeCriteria;
    }
    /** Gets the specified client age to perform searches
     * @return This Class temporary {@code int} client age
     * @see control.AdmTicket
     */
    public static int getClientAgeSearching ()
    {
        return clientAgeSearching;
    }
    /** Sets the client age to perform searches
     * @param clientAgeSearching This Class temporary {@code int} client age
     * @see control.AdmTicket
     */
    public static void setClientAgeSearching ( int clientAgeSearching )
    {
        FilterValue.clientAgeSearching = clientAgeSearching;
    }
    /** Gets the specified client cedula identification to perform searches
     * @return This Class temporary {@code String} representation that contains
     * a client cedula identification
     * @see control.AdmTicket
     */
    public static String getCedulaSearching ()
    {
        return cedulaSearching;
    }
    /** Sets the client cedula identification to perform searches
     * @param cedulaSearching This Class temporary {@code String} representation
     *                        that contains a client cedula identification
     * @see control.AdmTicket
     */
    public static void setCedulaSearching ( String cedulaSearching )
    {
        FilterValue.cedulaSearching = cedulaSearching;
    }
    /** Gets the specified client gender to perform searches
     * @return This Class temporary {@code char} that represents a client 
     * gender, M: Male, F: Female
     * @see control.AdmTicket
     */
    public static char getClientGenderSearching ()
    {
        return clientGenderSearching;
    }
    /** Sets the client gender to perform searches
     * @param clientGenderSearching This Class temporary {@code char} that 
     *                              represents a client gender, M: Male, 
     *                              F: Female
     * @see control.AdmTicket
     */
    public static void setClientGenderSearching ( String clientGenderSearching )
    {
        FilterValue.clientGenderSearching = clientGenderSearching.charAt( 0 );
    }
    /** Gets the specified Movie Genre criteria to perform searches
     * @return This Class temporary {@code MovieGenres enum} constant
     * @see control.AdmTicket
     */
    public static control.AdmPelicula.MovieGenres getMovieGenreSearching ()
    {
        return movieGenreSearching;
    }
    /** Sets the specified Movie Genre criteria to perform searches
     * @param movieGenreSearching This Class temporary {@code MovieGenres enum} 
     *                            constant
     * @see control.AdmTicket
     */
    public static void setMovieGenreSearching ( control.AdmPelicula.MovieGenres movieGenreSearching )
    {
        FilterValue.movieGenreSearching = movieGenreSearching;
    }
    /** Gets the specified Movie Language to perform searches
     * @return This Class temporary {@code String} representation that contains
     * a movie language
     * @see control.AdmTicket
     */
    public static String getMovieLanguageSearching ()
    {
        return movieLanguageSearching;
    }
    /** Sets the Movie Language to perform searches
     * @param movieLanguageSearching This Class temporary {@code String} 
     *                               representation that contains a movie 
     *                               language
     * @see control.AdmTicket
     */
    public static void setMovieLanguageSearching ( String movieLanguageSearching )
    {
        FilterValue.movieLanguageSearching = movieLanguageSearching;
    }
    /** Gets the specified Movie Name to perform searches
     * @return This Class temporary {@code String} representation that contains
     * a movie name
     * @see control.AdmTicket
     */
    public static String getMovieNameSearching ()
    {
        return movieNameSearching;
    }
    /** Sets the Movie Name to perform searches
     * @param movieNameSearching This Class temporary {@code String} 
     *                           representation that contains a movie name
     * @see control.AdmTicket
     */
    public static void setMovieNameSearching ( String movieNameSearching )
    {
        FilterValue.movieNameSearching = movieNameSearching;
    }
    /** Gets the specified Movie Subtitles language to perform searches
     * @return This Class temporary {@code String} representation that contains
     * a movie subtitles language
     * @see control.AdmTicket
     */
    public static String getMovieSubSearching ()
    {
        return movieSubSearching;
    }
    /** Sets the specified Movie Subtitles language to perform searches
     * @param movieSubSearching This Class temporary {@code String} 
     *                          representation that contains a movie Subtitles 
     *                          language
     * @see control.AdmTicket
     */
    public static void setMovieSubSearching ( String movieSubSearching )
    {
        FilterValue.movieSubSearching = movieSubSearching;
    }
    /** Gets the specified Ticket Price numeric value to perform searches
     * @return This Class temporary {@code double} ticket price number
     * @see control.AdmTicket
     */
    public static double getTicketPriceSearching ()
    {
        return ticketPriceSearching;
    }
    /** Sets the Ticket Price numeric value to perform searches
     * @param ticketPriceSearching This Class temporary {@code double} number 
     *                             that represents the ticket price
     * @see control.AdmTicket
     */
    public static void setTicketPriceSearching ( double ticketPriceSearching )
    {
        FilterValue.ticketPriceSearching = ticketPriceSearching;
    }

}
