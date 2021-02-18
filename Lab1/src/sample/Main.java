package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        Group root = new Group();
        Scene sc=new Scene(root, 500, 475);

        Line l1=new Line(386,60,346,100);

        Line l2=new Line(150,115,325,230);
        Line l3=new Line(350,115,175,230);
        Circle c1=new Circle(310,220,30);
        Circle c2=new Circle(185,220,30);
        Polygon polygon = new Polygon(150, 50, 150, 100,200,100);
        Rectangle rectangle=new Rectangle(150,95,200,50);
        root.getChildren().add(l1);
        root.getChildren().add(l2);
        root.getChildren().add(l3);
        root.getChildren().add(c1);
        root.getChildren().add(c2);
        root.getChildren().add(polygon);
        root.getChildren().add(rectangle);
        polygon.setFill(Color.CYAN);
        rectangle.setFill(Color.CYAN);
        c1.setFill(Color.BLUEVIOLET);
        c2.setFill(Color.BLUEVIOLET);
        sc.setFill(Color.ORANGE);





        primaryStage.setScene(sc);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
