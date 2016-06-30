import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 * Planet class builds a planet
 * 
 * @author alistaircooper
 */
public class Planet {

	// Variables
	private double orbitRadius;
	private double planetRadius;
	private Color planetColor;
	private int approxLocDeg;
	private double orbitPeriod;
	

	// Constructor

	public Planet(double orbitRadius, double planetRadius, Color planetColor, int approxLocDeg, double orbitPeriod) {
		this.orbitRadius = orbitRadius;
		this.planetRadius = planetRadius;
		this.planetColor = planetColor;
		this.approxLocDeg = approxLocDeg;
		this.orbitPeriod = orbitPeriod;
	}

	// Methods
	
	/**
     * createPlanet method to create circle for the planet and an orbit
     *
     * @param rootPane     root pane for solar system 
     * @param orbitRadius  the radius of the planet's orbit
     * @param planetRadius the radius of the planet
     * @param approxLocDeg the approximate start location of planet in Deg
     * @param planetColor  the color of the planet
     * @return Pane        pane containing sun node
     */
	public Pane makePlanetPane(Pane rootPane) {

		// scale the orbit radius
		orbitRadius = orbitRadius * BuildSolarSystem.orbitScaleFactor;
		// Scale the planet radius
		planetRadius = planetRadius * BuildSolarSystem.planetScaleFactor;
		// scale the orbital duration (ms)
		orbitPeriod = orbitPeriod * BuildSolarSystem.timeScaleFactor;

		// Create a pane to hold the orbit and planet
		Pane planetPane = new Pane();
		planetPane.setRotate(approxLocDeg);

		// Create a circle for the orbit and set its properties
		Circle orbit = new Circle();
		orbit.centerXProperty().bind(rootPane.widthProperty().divide(2));
		orbit.centerYProperty().bind(rootPane.widthProperty().divide(2));
		orbit.setRadius(orbitRadius);
		orbit.setStroke(Color.WHITE);
		orbit.setFill(null);

		// add orbit to pane
		planetPane.getChildren().add(orbit);

		// Create a circle for the orbit and set its properties
		Circle planet = new Circle();
		planet.centerXProperty().bind(rootPane.widthProperty().divide(2));
		planet.centerYProperty().bind(rootPane.widthProperty().divide(2).subtract(orbitRadius));
		planet.setRadius(planetRadius);
		planet.setStroke(null);
		planet.setFill(planetColor);

		// add orbit to pane
		planetPane.getChildren().add(planet);

		// Setup orbit rotation animation
		KeyValue startValue = new KeyValue(planetPane.rotateProperty(), approxLocDeg);
		KeyValue endValue = new KeyValue(planetPane.rotateProperty(), (approxLocDeg + 360));

		KeyFrame keyFrame = new KeyFrame(new Duration(orbitPeriod), startValue, endValue);

		Timeline timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.setAutoReverse(false); 
		timeline.getKeyFrames().addAll(keyFrame); 
		timeline.play();
		
		return planetPane;

	}

}
