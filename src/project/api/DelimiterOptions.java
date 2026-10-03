package project.api;
//Custom delimiter config type
public interface DelimiterOptions {
    //returns the delimiter character
    char getDelimiter();
    // checks if the the default shold be used instead of custom
    boolean isDefault();
}
