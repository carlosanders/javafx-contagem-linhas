package mb.dabm.helper;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Helper
{

    public static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static boolean isAlphabeticAndLengh4(String str)
    {
        return str.matches("[A-Z]{4}");
    }

    /**
     * enviar alerta no sistema
     * 
     * @param type
     * @param titulo
     * @param cabecalho
     * @param conteudo
     */
    public static void enviarAlerta(AlertType type, String titulo, String cabecalho, String conteudo)
    {
        Alert dialog = new Alert(type);
        dialog.setTitle(titulo);
        dialog.setHeaderText(cabecalho);
        dialog.setContentText(conteudo);
        dialog.showAndWait();
    }

    /**
     * http://code.makery.ch/blog/javafx-dialogs-official/ enviar alerta no sistema
     * 
     * @param type
     * @param titulo
     * @param cabecalho
     * @param conteudo
     */
    public static Optional<ButtonType> enviarPergunta(AlertType type, String titulo, String cabecalho, String conteudo)
    {
        Alert dialog = new Alert(type);
        dialog.setTitle(titulo);
        dialog.setHeaderText(cabecalho);
        dialog.setContentText(conteudo);
        // dialog.showAndWait();

        return dialog.showAndWait();
    }

    /**
     * Right way to delete a non empty directory in Java
     * 
     */
    public static boolean deleteDirectory(File dir)
    {
        if (dir.isDirectory()) {
            File[] children = dir.listFiles();
            for (int i = 0; i < children.length; i++) {

                boolean success = deleteDirectory(children[i]);

                if (!success) {
                    return false;
                }
            }
        }
        // either file or an empty directory
        System.out.println("removing file or directory : " + dir.getName());
        return dir.delete();
    }

    /**
     * Responsavel por abrir o arquivo especificado
     * 
     * @param file
     */
    public static void openFile(File file)
    {
        Desktop desktop = Desktop.getDesktop();

        try {
            desktop.open(file);
        } catch (IOException ex) {
            // Logger.getLogger(SegmentVController.class.getName()).log(Level.SEVERE, null,
            // ex);
        }
    }
}
