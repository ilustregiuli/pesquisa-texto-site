import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String url = JOptionPane.showInputDialog(null,
                "Digite a URL do site:",
                "Entrada de URL",
                JOptionPane.QUESTION_MESSAGE);

        if (url == null || url.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Nenhuma URL foi fornecida. Encerrando o programa.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String wordSearch = JOptionPane.showInputDialog(null,
                "Digite a palavra a ser procurada em: " + url,
                "Busca palavra",
                JOptionPane.QUESTION_MESSAGE);

        if (wordSearch == null || wordSearch.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Nenhuma palavra foi fornecida. Encerrando o programa.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Document doc = Jsoup.connect(url).get();
            String textoPagina = doc.body().text();

            if(textoPagina.toLowerCase().contains(wordSearch.toLowerCase())) {
                JOptionPane.showMessageDialog(null,
                        "Palavra encontrada!",
                        "Resultado",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao acessar o site: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
