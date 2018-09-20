import java.io.*;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HW5 extends Application 
{
	public void start(Stage primaryStage) 
	{
		TextField tf = new TextField();
		TextArea ta = new TextArea();
		ta.setPrefHeight(400);
		ta.setEditable(false);
		ta.setFont(Font.font("Serif", 14));
		
		VBox vbox = new VBox(tf, ta);
		vbox.setPadding(new Insets(10, 10, 10, 10));
		vbox.setSpacing(10);
		
		Scene scene = new Scene(vbox, 800, 400);
		
		primaryStage.setTitle("Homework 5");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

		tf.setOnAction(e -> {
			String fileName = tf.getText();
			try 
			{
				RandomAccessFile raf = new RandomAccessFile(fileName, "r");
				String text = "";
				for (int i = 1; i <= raf.length(); i++) 
				{
					text += String.format("%08d", Integer.parseInt((Integer.toBinaryString(raf.readByte())))) + " ";
					if (i % 8 == 0) 
						text += "\n";
				}
				ta.setText(text);
				raf.close();
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			
		});
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}

}