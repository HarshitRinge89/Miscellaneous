import java.nio.file.*;

public class CSSformatter {
    public static void main(String[] args) throws Exception {
        String css = Files.readString(Path.of("formatted.css"));

        StringBuilder sb = new StringBuilder();
        int count = 0;

        css = css.replaceAll("\\s+", " ");
        css=css.replaceAll("\\s*([{};])\\s*", "$1");
        css=css.trim();

        for (int i = 0; i < css.length(); i++) {
            char ch = css.charAt(i);
            if (ch == '{') {
                sb.append(" {\n");
                count++;
                sb.append("\t".repeat(count));
            }
            else if (ch == '}') {
                count--;
                sb.append("\n");
                sb.append("\t".repeat(count));
                sb.append("}\n");
                if (count > 0) sb.append("\t".repeat(count));
            }
            else if (ch == ';') {
                sb.append(";\n");
                sb.append("\t".repeat(count));
            }
            else {
                sb.append(ch);
            }
        }
        Files.writeString(Path.of("formatted.css"), sb.toString());
        System.out.println("File formatted!");
    }
}