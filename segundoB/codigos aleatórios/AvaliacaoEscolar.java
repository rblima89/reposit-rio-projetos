
    import javax.swing.JOptionPane;

public class AvaliacaoEscolar {

    public static void main(String[] args) {
        int numNotas = 2;
        double somaNotas = 0.0;

        
        for (int i = 1; i <= numNotas; i++) {
            String input = JOptionPane.showInputDialog(null, 
                    "Digite a nota " + i + ":", 
                    "Entrada de Notas", 
                    JOptionPane.QUESTION_MESSAGE);
            
            if (input != null && !input.isEmpty()) {
                try {
                    double nota = Double.parseDouble(input);
                    somaNotas += nota;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, 
                            "Valor inválido! Insira um número válido.",
                            "Erro", 
                            JOptionPane.ERROR_MESSAGE);
                    i--;
                }
            } else {
                JOptionPane.showMessageDialog(null, 
                        "Nota não pode ser vazia. Por favor, insira uma nota.",
                        "Erro", 
                        JOptionPane.ERROR_MESSAGE);
                i--;
            }
        }
        double media = somaNotas / numNotas;        
        if (media >= 7.0) {
            JOptionPane.showMessageDialog(null, 
                    "Parabéns! Você foi Aprovado.\nMédia: " + media, 
                    "Resultado", 
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, 
                    "Agende sua prova de Avaliação.\nMédia: " + media, 
                    "Resultado", 
                    JOptionPane.WARNING_MESSAGE);
        }
    }
}


