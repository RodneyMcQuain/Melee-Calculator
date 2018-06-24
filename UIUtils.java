import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class UIUtils {
	public static void numberFormatAlert() {
		Alert alNumberFormatException = new Alert(AlertType.ERROR);
		alNumberFormatException.setTitle("Number Format Exception");
		alNumberFormatException.setHeaderText(null);
		alNumberFormatException.setContentText("Please enter a number into all of the fields.");
		alNumberFormatException.showAndWait();
	}
}
