import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class HW11 extends Application
{
	Pane root = new Pane();
	
	public void start(Stage primaryStage) throws Exception
	{
		Label label = new Label("Enter order: ");
		TextField tf = new TextField();
		
		HBox box = new HBox();
		box.getChildren().addAll(label, tf);
		box.setAlignment(Pos.CENTER);
		
		tf.setOnAction(e -> {
			String text = tf.getText();
			try 
			{
				int order = Integer.parseInt(text);
				root.getChildren().clear();
				horizontal(300, 300, 400, order);
			} 
			catch (NumberFormatException exp) 
			{
				exp.printStackTrace();
			}
		});
		
		primaryStage.setTitle("Fractal");
		VBox box2 = new VBox(root, box);
		root.setMinSize(600, 600);
		Scene scene = new Scene(box2, 600, 650);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	void horizontal(int x, int y, int size, int order)
	{
		if(order <= 0)
			return;
		
		Line l = new Line(x - size / 2, y, x + size / 2, y);
		root.getChildren().add(l);
		vertical(x - size / 2, y, size / 2, order - 1);
		vertical(x + size / 2, y, size / 2, order - 1);
	}
	
	void vertical(int x, int y, int size, int order)
	{
		if(order <= 0)
			return;
		
		Line l = new Line(x, y - size / 2, x, y + size / 2);
		root.getChildren().add(l);
		horizontal(x, y + size / 2, size / 2, order - 1);
		horizontal(x, y - size / 2, size / 2, order - 1);
	}
	
	public static void main(String args[])
	{
		launch(args);
	}
}
