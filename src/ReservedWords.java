import java.util.HashMap;

/**
 * Created by Jason on 2017-06-06.
 */
public class ReservedWords {

    private HashMap<String, Integer> n1;
    private HashMap<String, Integer> n2;

    public static String[] operators = {
            "abstract",
            "assert",
            "boolean",
            "break",
            "byte",
            "case",
            "catch",
            "char",
            "class",
            "continue",
            "default",
            "do",
            "double",
            "else",
            "enum",
            "extends",
            "final",
            "finally",
            "float",
            "for",
            "if",
            "implements",
            "import",
            "instanceof",
            "int",
            "interface",
            "long",
            "native",
            "new",
            "package",
            "private",
            "protected",
            "public",
            "return",
            "short",
            "static",
            "strictfp",
            "super",
            "switch",
            "synchronized",
            "this",
            "throw",
            "throws",
            "transient",
            "try",
            "void",
            "volatile",
            "while",
            // Arithmetic operators
            "+",
            "-",
            "*",
            "/",
            "%",
            "++",
            "--",
            // Relational operators
            "==",
            "!=",
            ">",
            "<",
            ">=",
            "<=",
            // Bitwise operators
            "&",
            "|",
            "^",
            "~",
            "<<",
            ">>",
            ">>>",
            // Logical operators
            "&&",
            "||",
            "!",
            // Assignment operators
            "=",
            "+=",
            "-=",
            "*=",
            "/=",
            "%=",
            "<<=",
            ">>=",
            "&=",
            "^=",
            "|=",
            "? :",
            "[",
            "]",
            "."
    };

    public ReservedWords() {
        this.n1 = new HashMap<>();
        this.n2 = new HashMap<>();
    }

    public void addOperator(String operator) {
        if (n1.get(operator) == null) {
            n1.put(operator, 1);
        }
        else {
            int count = n1.get(operator);
            n1.replace(operator, count+1);
        }
    }

    public void addOperand(String operand) {
        if (operand != null && operand != "") {
            if (n2.get(operand) == null) {
                n2.put(operand, 1);
            }
            else {
                int count = n2.get(operand);
                n2.replace(operand, count+1);
            }
        }
    }

    public String getN1() {
        int unique = 0;
        int total = 0;
        StringBuilder builder = new StringBuilder();
        builder.append("Operator\t\tNumber of Occurrences\n");
        for(String operator : n1.keySet()) {
            unique++;
            total += n1.get(operator);
            if (operator.length() < 4)
                builder.append(operator + "\t\t\t\t" + n1.get(operator) + "\n");
            else if (operator.length() > 8)
                builder.append(operator + "\t\t" + n1.get(operator) + "\n");
            else
                builder.append(operator + "\t\t\t" + n1.get(operator) + "\n");
        }

        builder.append("n1: " + unique + "\t\t\tN1: " + total + "\n");

        return builder.toString();
    }

    public String getN2() {
        int unique = 0;
        int total = 0;
        StringBuilder builder = new StringBuilder();
        builder.append("Operand\t\tNumber of Occurrences\n");
        for(String operand : n2.keySet()) {
            unique++;
            total += n2.get(operand);
            if(operand.length() < 12)
                builder.append(operand + "\t\t\t\t\t" + n2.get(operand) + "\n");
            else
                builder.append(operand + "\t\t" + n2.get(operand) + "\n");
        }

        builder.append("n2: " + unique + "\t\t\tN2: " + total + "\n");

        return builder.toString();
    }
}
