package br.com.lulishouseprojetos;

import br.com.lulishouseprojetos.controller.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StageUtil {

    private StageUtil(){}

    public static void SetupPage(Stage st, String pageName, Controller ct) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(pageName + ".fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        Controller controller = fxmlLoader.getController();
        controller.setStage(st);

        if (ct != null){
            controller.setCurrentUser(ct.getCurrentUser());
            if (ct.getDatabase() != null)
                controller.setDatabase(ct.getDatabase());
        }

        controller.setupPage();
        st.setTitle("Lulis House Projetos");
        st.setScene(scene);
        st.show();
    }
}
