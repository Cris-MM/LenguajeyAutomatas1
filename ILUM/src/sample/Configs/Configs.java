package sample.Configs;

import java.util.regex.Pattern;

public class Configs {
    public static final String[] KEYWORDS = new String[] {
            "linea", "cuadro", "rectangulo", "triangulo", "trapecio", "rombo", "rojo",
            "verde", "azul", "blanco", "negro", "amarillo",
            "prendido", "destello", "iniciar", "tiempo", "escala",
            "apagar", "coordenada"
    };

    public static final String KEYWORD_PATTERN = "\\b(" + String.join("|", KEYWORDS) + ")\\b";
    public static final String PAREN_PATTERN = "\\(|\\)";
    public static final String BRACE_PATTERN = "\\{|\\}";
    public static final String BRACKET_PATTERN = "\\[|\\]";
    public static final String SEMICOLON_PATTERN = "\\;";
    public static final String STRING_PATTERN = "\"([^\"\\\\]|\\\\.)*\"";
    public static final String COMMENT_PATTERN = "//[^\n]*" + "|" + "/\\*(.|\\R)*?\\*/";

    public static final Pattern PATTERN = Pattern.compile(
            "(?<KEYWORD>" + KEYWORD_PATTERN + ")"
                    + "|(?<PAREN>" + PAREN_PATTERN + ")"
                    + "|(?<BRACE>" + BRACE_PATTERN + ")"
                    + "|(?<BRACKET>" + BRACKET_PATTERN + ")"
                    + "|(?<SEMICOLON>" + SEMICOLON_PATTERN + ")"
                    + "|(?<STRING>" + STRING_PATTERN + ")"
                    + "|(?<COMMENT>" + COMMENT_PATTERN + ")"
    );

    public static final String sampleCode = String.join("\n", new String[] {
            "iniciar linea (0,150)",
            "iniciar cuadro (100,-100)",
            "iniciar rectangulo (-100,100)",
            "iniciar triangulo (100,100)",
            "iniciar trapecio (-100,-100)",
            "iniciar rombo (0,0)",
            /*"iniciar linea (12,14) : rojo",
            "iniciar cuadro (3,2) : azul + destello",
            "triangulo (2,2)",
            "cuadro (7,13) = tiempo(1000)",
            "rectangulo (1,1) : amarillo + destello",
            "prendido + blanco : cuadro (76,34)",
            "destello : triangulo (10,8)",
            "2 escala {linea (8,8)}",
            "apagar coordenada (5,5)"*/
    });
    public static String[] expresiones={
            "(iniciar)\\s+([a-z]{5,10})\\s*[(]([-]?[0-9]{1,3})[,]([-]?[0-9]{1,3})[)]",
            "(iniciar)\\s+([a-z]{5,10})\\s*[(]([0-9]{1,2})[,]([0-9]{1,2})[)]\\s*[:]\\s*([a-z]{4,8})",
            "(iniciar)\\s+([a-z]{5,10})\\s*[(]([0-9]{1,2})[,]([0-9]{1,2})[)]\\s*[:]\\s*([a-z]{4,8})\\s*[+]\\s*(destello|prendido)",
            "([a-z]{5,10})\\s*[(]([0-9]{1,2})[,]([1-9]{1,2})[)]",
            "([a-z]{5,10})\\s*[(]([0-9]{1,2})[,]([1-9]{1,2})[)]\\s*[=]\\s*(tiempo)\\s*([(][0-9]+[)])",
            "([a-z]{5,10})\\s*[(]([0-9]{1,2})[,]([1-9]{1,2})[)]\\s*[:]\\s*([a-z]{4,8})\\s*[+]\\s*(destello|prendido)",
            "(destello|prendido)\\s*[+]\\s*([a-z]{4,8})\\s*[:]\\s*([a-z]{5,10})\\s*[(]([0-9]{1,2})[,]([1-9]{1,2})[)]",
            "(destello|prendido)\\s*[:]\\s*([a-z]{5,10})\\s*[(]([0-9]{1,2})[,]([1-9]{1,2})[)]",
            "([0-9]{1})\\s*(escala)\\s*[{]\\s*([a-z]{5,10})\\s*[(]([0-9]{1,2})[,]([0-9]{1,2})[)]\\s*[}]",
            "(apagar)\\s+(coordenada)\\s*[(]([0-9]{1,2})[,]([0-9]{1,2})[)]"

    };
}
