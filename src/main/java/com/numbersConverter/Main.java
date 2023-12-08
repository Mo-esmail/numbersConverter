package com.numbersConverter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    static Label Signlbl=new Label();
    static Label oneslbl=new Label();
    static Label twoslbl=new Label();

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        TextField input = new TextField();
        btn.setText("Calculate");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                int num = Integer.parseInt(input.getText());
                String binary=Integer.toString(num,2);
                Signlbl.setText("Sign magnitude: 1"+binary);
                getOneAndTwosComplement(binary);
            }
        });

        VBox root = new VBox();
        root.getChildren().addAll(new Label("Enter the number"),input,btn,Signlbl,oneslbl,twoslbl);

        Scene scene = new Scene(root, 300, 300);

        primaryStage.setTitle("Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    static void getOneAndTwosComplement(String bin)
    {
        int n = bin.length();
        int i;

        String ones = "", twos = "";
        ones = twos = "";

        for (i = 0; i < n; i++)
        {
            ones += flip(bin.charAt(i));
        }

        twos = ones;
        for (i = n - 1; i >= 0; i--)
        {
            if (ones.charAt(i) == '1')
            {
                twos = twos.substring(0, i) + '0' + twos.substring(i + 1);
            }
            else
            {
                twos = twos.substring(0, i) + '1' + twos.substring(i + 1);
                break;
            }
        }

        if (i == -1)
        {
            twos = '1' + twos;
        }

        oneslbl.setText("1's complement: " + ones);;
        twoslbl.setText("2's complement: " + twos);
    }
    static char flip(char c)
    {
        return (c == '0') ? '1' : '0';
    }
}