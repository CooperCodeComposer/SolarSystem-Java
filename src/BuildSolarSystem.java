
//*************************-=-=-=-=-=-=-=-=-=-=-=-=-**************************// 
//********************<         THE SOLAR SYSTEM          >*******************//
//*************************-=-=-=-=  V 1.1  -=-=-==-**************************//
//**************                     AUTHOR                     **************//
//---------------<_>------->>>   ALISTAIR COOPER   <<<-------<_>--------------//
//*****************<_>         CREATED: 06/29/2016          <_>***************//
//**************************-=-=-=-=-=-=-=-=-=-=-=-=-*************************//
// Model of solar system with orbits to relative scale + planets to relative  //
// scale (with the exception of the Sun). Orbital period also to relative     //
// scale                                                                      //


import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * BuildSolarSystem class builds the solar system
 * 
 * @author alistaircooper
 */
public class BuildSolarSystem extends Application {

	// class constants
	protected static final double orbitScaleFactor = 0.085;
	protected static final double planetScaleFactor = 0.0002;
	protected static final double timeScaleFactor = 27.38225629791895; // 1 Earth year = 10,000 ms

	@Override
	public void start(Stage primaryStage) {

		// Create root pane
		StackPane rootPane = new StackPane();

		// Create new scene and add root pane
		Scene scene = new Scene(rootPane, 800, 800);

		// Create a black background
		Pane backgroundPane = new Pane();
		backgroundPane.setStyle("-fx-background-color: black;");
		rootPane.getChildren().add(backgroundPane);

		// Add 100 random stars
		for (int i = 0; i < 100; i++) {

			Random rand = new Random();
			// randomly generate width
			int randX = rand.nextInt((int) scene.getWidth()) + 1; 
			// randomly generate height
			int randY = rand.nextInt((int) scene.getHeight()) + 1; 

			Circle star = new Circle();
			star.setCenterX(randX);
			star.setCenterY(randY);
			star.setRadius(1);
			star.setStroke(null);
			star.setFill(Color.WHITE);

			// add star to background pane
			backgroundPane.getChildren().add(star);
		}

		// Create the Sun
		Pane sunPane = createSun(rootPane);
		rootPane.getChildren().add(sunPane);

		// Create Mercury
		double mercuryOrbitRadius = 58.5963; // in km x 10^6
		double mercuryPlanetRadius = 2440; // in km
		Color mercuryColor = Color.rgb(206, 157, 91);
		int mercuryApproxLocDeg = 30; // approximate current position in orbit
		double mercuryOrbitPeriod = 88.0; // in days

		Planet mercury = new Planet(mercuryOrbitRadius, mercuryPlanetRadius, mercuryColor, mercuryApproxLocDeg,
				mercuryOrbitPeriod);
		Pane mercuryPane = mercury.makePlanetPane(rootPane);
		rootPane.getChildren().add(mercuryPane);

		// Create Venus
		double venusOrbitRadius = 108.8963; // in km x 10^6
		double venusPlanetRadius = 6052; // in km
		Color venusColor = Color.rgb(75, 178, 99);
		int venusApproxLocDeg = 330; // approximate current position in orbit
		double venusOrbitPeriod = 224.7; // in days

		Planet venus = new Planet(venusOrbitRadius, venusPlanetRadius, venusColor, venusApproxLocDeg, venusOrbitPeriod);
		Pane venusPane = venus.makePlanetPane(rootPane);
		rootPane.getChildren().add(venusPane);

		// Create Earth
		double earthOrbitRadius = 150.2963; // in km x 10^6
		double earthPlanetRadius = 6378; // in km
		Color earthColor = Color.rgb(165, 201, 233);
		int earthApproxLocDeg = 175; // approximate current position in orbit
		double earthOrbitPeriod = 365.2; // in days

		Planet earth = new Planet(earthOrbitRadius, earthPlanetRadius, earthColor, earthApproxLocDeg, earthOrbitPeriod);
		Pane earthPane = earth.makePlanetPane(rootPane);
		rootPane.getChildren().add(earthPane);

		// Create Mars
		double marsOrbitRadius = 228.5963; // in km x 10^6
		double marsPlanetRadius = 3397; // in km
		Color marsColor = Color.rgb(235, 35, 16);
		int marsApproxLocDeg = 187; // approximate current position in orbit
		double marsOrbitPeriod = 687.0; // in days

		Planet mars = new Planet(marsOrbitRadius, marsPlanetRadius, marsColor, marsApproxLocDeg, marsOrbitPeriod);
		Pane marsPane = mars.makePlanetPane(rootPane);
		rootPane.getChildren().add(marsPane);

		// Create Jupiter
		double jupiterOrbitRadius = 779.2963; // in km x 10^6
		double jupiterPlanetRadius = 71492; // in km
		Color jupiterColor = Color.rgb(224, 216, 210);
		int jupiterApproxLocDeg = 272; // approximate current position in orbit
		double jupiterOrbitPeriod = 4331; // in days

		Planet jupiter = new Planet(jupiterOrbitRadius, jupiterPlanetRadius, jupiterColor, jupiterApproxLocDeg,
				jupiterOrbitPeriod);
		Pane jupiterPane = jupiter.makePlanetPane(rootPane);
		rootPane.getChildren().add(jupiterPane);

		// Create Saturn
		double saturnOrbitRadius = 1434.1963; // in km x 10^6
		double saturnPlanetRadius = 60268; // in km
		Color saturnColor = Color.rgb(232, 176, 87);
		int saturnApproxLocDeg = 193; // approximate current position in orbit
		double saturnOrbitPeriod = 10747; // in days

		Planet saturn = new Planet(saturnOrbitRadius, saturnPlanetRadius, saturnColor, saturnApproxLocDeg,
				saturnOrbitPeriod);
		Pane saturnPane = saturn.makePlanetPane(rootPane);
		rootPane.getChildren().add(saturnPane);

		// Create Uranus
		double uranusOrbitRadius = 2873.1963; // in km x 10^6
		double uranusPlanetRadius = 25559; // in km
		Color uranusColor = Color.rgb(192, 229, 235);
		int uranusApproxLocDeg = 55; // approximate current position in orbit
		double uranusOrbitPeriod = 30589; // in days

		Planet uranus = new Planet(uranusOrbitRadius, uranusPlanetRadius, uranusColor, uranusApproxLocDeg,
				uranusOrbitPeriod);
		Pane uranusPane = uranus.makePlanetPane(rootPane);
		rootPane.getChildren().add(uranusPane);

		// Create Neptune
		double neptuneOrbitRadius = 4495.7963; // in km x 10^6
		double neptunePlanetRadius = 24766; // in km
		Color neptuneColor = Color.rgb(67, 107, 254);
		int neptuneApproxLocDeg = 112; // approximate current position in orbit
		double neptuneOrbitPeriod = 59800; // in days x 10^3

		Planet neptune = new Planet(neptuneOrbitRadius, neptunePlanetRadius, neptuneColor, neptuneApproxLocDeg,
				neptuneOrbitPeriod);
		Pane neptunePane = neptune.makePlanetPane(rootPane);
		rootPane.getChildren().add(neptunePane);

		// Setup primaryStage
		primaryStage.setTitle("Solar System"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	/**
	 * main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Application.launch(args);

	}

	/**
	 * createSun method to create circle for the Sun
	 *
	 * @param rootPane
	 * @return Pane pane containing sun node
	 */
	private static Pane createSun(Pane rootPane) {

		// sun not to scale
		final double sunRadius = 2;

		Pane sunPane = new Pane();

		Circle sun = new Circle();
		sun.centerXProperty().bind(rootPane.widthProperty().divide(2));
		sun.centerYProperty().bind(rootPane.widthProperty().divide(2));
		sun.setRadius(sunRadius);
		sun.setFill(Color.YELLOW);

		sunPane.getChildren().add(sun);

		return sunPane;
	}

}
