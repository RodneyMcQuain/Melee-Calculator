import java.io.File;
import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;

public class meleeProgram extends Application {
	private Scene mainMenuScene, knockbackCalcScene, frameAdvantageOnBlockScene, frameAdvantageOnHitScene, staleMoveNegationScene,
	hitlagCalcScene, frameAdvantageOnAtScene, errorScene;
	private Stage theStage;
	private static DecimalFormat f = new DecimalFormat("##.00000");
    
	//Main Menu Scene needed global variables
	private Button btKnockbackCalc = new Button("Knockback/Hitstun Calculator");
	private Button btFrameAdvOnBlock = new Button("Frame Advantage on Block");
	private Button btFrameAdvOnHit = new Button("Frame Advantage on Hit");
	private Button btStaleMoveCalc = new Button("Stale Move Negation");
	private Button btHitlagCalc = new Button("Hitlag Calculator");
	private Button btFrameAdvOnAt = new Button("Frame Advantage on AT");
	
	//Knockback Calculator Scene needed global variables
	private Button btCalculateKnockbackCalc = new Button("Calculate Knockback & Hitstun");
	private TextField tfDamageKnockbackCalc = new TextField();
	private TextField tfPercent = new TextField();
	private TextField tfWeight = new TextField();
	private TextField tfKnockbackScaling = new TextField();
	private TextField tfBaseKnockback = new TextField();
	private TextField tfHitstunResult = new TextField();
	private TextField tfKnockbackResult = new TextField();
	private CheckBox chbDidTheyCc = new CheckBox("Crouch Cancelled?");
	private Button btMainMenuKnockbackCalc = new Button("Main Menu");

	//Frame Advantage on Block Scene needed global variables
	private ToggleGroup moveTypeGroupFrameAdvOnBlock = new ToggleGroup();
	private RadioButton rbAerialFrameAdvOnBlock = new RadioButton("Aerial");
	private RadioButton rbGroundFrameAdvOnBlock = new RadioButton("Ground ");
	private RadioButton rbProjectileFrameAdvOnBlock = new RadioButton("Projectile ");
	private TextField tfDamageFrameAdvOnBlock = new TextField();
	private TextField tfLandingLagAerialFrameAdvOnBlock = new TextField();
	private TextField tfFallFramesAerialFrameAdvOnBlock = new TextField();
	private TextField tfLandingLagProjectileFrameAdvOnBlock = new TextField();
	private TextField tfFirstActiveFrameAdvOnBlock = new TextField();
	private TextField tfTotalFramesFrameAdvOnBlock = new TextField();
	private TextField tfFrameAdvOnBlockResult = new TextField();
	private Label lblLandingLagAerialFrameAdvOnBlock = new Label("How much landing lag does the move have?");
	private Label lblFallFrames1AerialFrameAdvOnBlock = new Label("How many frames is the character falling for");
	private Label lblFallFrames2AerialFrameAdvOnBlock = new Label("after the move hits?");
	private Label lblFirstActiveFrameAdvOnBlock = new Label("What is the 1st active frame?");
	private Label lblTotalFrames1GroundFrameAdvOnBlock = new Label("How many frames does the move have in");
	private Label lblTotalFrames2GroundFrameAdvOnBlock = new Label("total?");
	private Label lblLandingLag1ProjectileFrameAdvOnBlock = new Label("How much landing lag/dead frames does");
	private Label lblLandingLag2ProjectileFrameAdvOnBlock = new Label("the move have?");
	private Button btCalculateFrameAdvOnBlock = new Button("Calculate Frame Advantage on Block");
	private Button btMainMenuFrameAdvOnBlock = new Button("Main Menu");

	//Frame Advantage on Hit Scene needed global variables
	private ToggleGroup moveTypeGroupFrameAdvOnHit = new ToggleGroup();
	private RadioButton rbAerialFrameAdvOnHit = new RadioButton("Aerial");
	private	RadioButton rbGroundFrameAdvOnHit = new RadioButton("Ground ");
	private RadioButton rbProjectileFrameAdvOnHit = new RadioButton("Projectile ");
	private TextField tfHitstunFrameAdvOnHit = new TextField();
	private TextField tfLandingLagAerialFrameAdvOnHit = new TextField();
	private TextField tfFallFramesAerialFrameAdvOnHit = new TextField();
	private TextField tfLandingLagProjectileFrameAdvOnHit = new TextField();
	private TextField tfFirstActiveFrameAdvOnHit = new TextField();
	private TextField tfTotalFramesFrameAdvOnHit = new TextField();
	private TextField tfDamageProjectileFrameAdvOnHit = new TextField();
	private TextField tfFrameAdvOnHitResult = new TextField();
	private Label lblLandingLagAerialFrameAdvOnHit = new Label("How much landing lag does the move have?");
	private Label lblFallFrames1AerialFrameAdvOnHit = new Label("How many frames is the character falling for");
	private Label lblFallFrames2AerialFrameAdvOnHit = new Label("after the move hits?");
	private Label lblFirstActiveFrameAdvOnHit = new Label("What is the 1st active frame?");
	private Label lblTotalFrames1GroundFrameAdvOnHit = new Label("How many frames does the move have in");
	private Label lblTotalFrames2GroundFrameAdvOnHit = new Label("total?");
	private Label lblDamageProjectileFrameAdvOnHit = new Label("How much damage does the move do?");
	private Label lblLandingLag1ProjectileFrameAdvOnHit = new Label("How much landing lag/dead frames does");
	private Label lblLandingLag2ProjectileFrameAdvOnHit = new Label("the move have?");
	private Button btHitstunCalcFrameAdvOnHit = new Button("Hitstun Calculator");
	private Button btCalculateFrameAdvOnHit = new Button("Calculate Frame Advantage on Hit");
	private Button btMainMenuFrameAdvOnHit = new Button("Main Menu");
	
	//Stale Move Negation Scene needed global variables
	private TextField tfDamageStaleMoveNegation = new TextField();
	private RadioButton rbStale1 = new RadioButton("1");
	private RadioButton rbStale2 = new RadioButton("2");
	private RadioButton rbStale3 = new RadioButton("3");
	private RadioButton rbStale4 = new RadioButton("4");
	private RadioButton rbStale5 = new RadioButton("5");
	private RadioButton rbStale6 = new RadioButton("6");
	private RadioButton rbStale7 = new RadioButton("7");
	private RadioButton rbStale8 = new RadioButton("8");
	private RadioButton rbStale9 = new RadioButton("9");
	private TextField tfStaleMovePointsTotal = new TextField();
	private TextField tfStaleMovePercentEffected = new TextField();
	private TextField tfStaleMoveResult = new TextField();
	private Button btCalcStaleMovePoints = new Button("Calculate Stale Move Points");
	private Button btMainMenuStaleMoveNegation = new Button("Main Menu");
	
	//Hitlag Calculator Scene needed global variables
	private TextField tfDamageHitlagCalc = new TextField();
	private TextField tfHitlagResultHitlagCalc = new TextField();
	private CheckBox chbElectricMove = new CheckBox("Electric Move?");
	private Button btCalculateHitlag = new Button("Calculate Hitlag");
	private Button btMainMenuHitlagCalc = new Button("Main Menu");
	
	//Frame Advantage on AT needed global variables
	private ToggleGroup moveTypeGroupFrameAdvOnAt = new ToggleGroup();
	private RadioButton rbAerialFrameAdvOnAt = new RadioButton("Aerial");
	private RadioButton rbGroundFrameAdvOnAt = new RadioButton("Ground ");
	private RadioButton rbProjectileFrameAdvOnAt = new RadioButton("Projectile ");
	private ToggleGroup techTypeGroupFrameAdvOnAt = new ToggleGroup();
	private RadioButton rbTechInPlaceFrameAdvOnAt = new RadioButton("Tech in Place");
	private RadioButton rbTechRollFrameAdvOnAt = new RadioButton("Tech Roll");
	private TextField tfLandingLagAerialFrameAdvOnAt = new TextField();
	private TextField tfFallFramesAerialFrameAdvOnAt = new TextField();
	private TextField tfLandingLagProjectileFrameAdvOnAt = new TextField();
	private TextField tfFirstActiveFrameAdvOnAt = new TextField();
	private TextField tfTotalFramesFrameAdvOnAt = new TextField();
	private TextField tfDamageProjectileFrameAdvOnAt = new TextField();
	private TextField tfFrameAdvOnAtResult = new TextField();
	private Label lblLandingLagAerialFrameAdvOnAt = new Label("How much landing lag does the move have?");
	private Label lblFallFrames1AerialFrameAdvOnAt = new Label("How many frames is the character falling for");
	private Label lblFallFrames2AerialFrameAdvOnAt = new Label("after the move hits?");
	private Label lblFirstActiveFrameAdvOnAt = new Label("What is the 1st active frame?");
	private Label lblTotalFrames1GroundFrameAdvOnAt = new Label("How many frames does the move have in");
	private Label lblTotalFrames2GroundFrameAdvOnAt = new Label("total?");
	private Label lblDamageProjectileFrameAdvOnAt = new Label("How much damage does the move do?");
	private Label lblLandingLag1ProjectileFrameAdvOnAt = new Label("How much landing lag/dead frames does");
	private Label lblLandingLag2ProjectileFrameAdvOnAt = new Label("the move have?");
	private Button btCalculateFrameAdvOnAt = new Button("Calculate Frame Advantage on AT");
	private Button btMainMenuFrameAdvOnAt = new Button("Main Menu");
    
    @Override
	public void start(Stage primaryStage) {
    	theStage = primaryStage;

		//Calling scene setups
		mainMenuSetup();
		knockbackCalcSetup();
		frameAdvOnBlockSetup();
		frameAdvOnHitSetup();
		staleMoveNegationSetup();
		hitlagCalcSetup();
		frameAdvOnAtSetup();
						
		//setting primaries
        primaryStage.setTitle("Melee Program");
	    primaryStage.setScene(mainMenuScene);
	    primaryStage.show();
	}

    //Setting up Scenes
    /**
     Setting up the Main Menu scene
    */
    public void mainMenuSetup() {
    	Label lblMainMenuB = new Label("Melee Calculator - Select a Button");
    	File smashInsigniaF = new File("C:/Users/Rodney/Downloads/smashinsignia.png");
        Image smashInsigniaI = new Image(smashInsigniaF.toURI().toString());
        ImageView smashInsigniaIv = new ImageView(smashInsigniaI); 
    	Label lblProgramVersion = new Label("Version: 1.04b");
        smashInsigniaIv.setFitHeight(80);
        smashInsigniaIv.setFitWidth(80);
		GridPane mainMenuPane = new GridPane();
		mainMenuPane.setHgap(10);
		mainMenuPane.setVgap(10);
		mainMenuPane.setPadding(new Insets(10, 10, 10, 10));
		GridPane.setHalignment(btKnockbackCalc, HPos.CENTER);
		GridPane.setHalignment(btFrameAdvOnBlock, HPos.CENTER);
		GridPane.setHalignment(btFrameAdvOnHit, HPos.CENTER);
		GridPane.setHalignment(btStaleMoveCalc, HPos.CENTER);
		GridPane.setHalignment(btHitlagCalc, HPos.CENTER);
		GridPane.setHalignment(btFrameAdvOnAt, HPos.CENTER);
		GridPane.setHalignment(lblProgramVersion, HPos.RIGHT);
		GridPane.setHalignment(smashInsigniaIv, HPos.CENTER);
		lblMainMenuB.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
		GridPane.setHalignment(lblMainMenuB, HPos.CENTER);

		mainMenuPane.add(lblMainMenuB, 0, 0);
		mainMenuPane.add(btKnockbackCalc, 0, 1);
		mainMenuPane.add(btFrameAdvOnBlock, 0, 2);
		mainMenuPane.add(btFrameAdvOnHit, 0, 3);
		mainMenuPane.add(btStaleMoveCalc, 0, 4);
		mainMenuPane.add(btHitlagCalc, 0, 5);
		mainMenuPane.add(btFrameAdvOnAt, 0, 6);
		mainMenuPane.add(smashInsigniaIv, 0, 9);
		mainMenuPane.add(lblProgramVersion, 0, 12);
		
		mainMenuScene = new Scene(mainMenuPane, 365, 400);
		mainMenuScene.getStylesheets().add("stylesheet.css");
    }
    /**
    Setting up the Knockback Calculator scene
    */
    public void knockbackCalcSetup() {
	    GridPane knockbackCalcPane = new GridPane();
		knockbackCalcPane.setHgap(5);
		knockbackCalcPane.setVgap(5);
		knockbackCalcPane.setPadding(new Insets(10, 10, 10, 10));
		
		Label lblKnockbackCalcB1 = new Label("Knockback/Hitstun");
		Label lblKnockbackCalcB2 = new Label("Calculator");
		lblKnockbackCalcB1.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
		lblKnockbackCalcB2.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
		knockbackCalcPane.add(lblKnockbackCalcB1, 0, 0);
		knockbackCalcPane.add(lblKnockbackCalcB2, 0, 1);
		knockbackCalcPane.add(new Label("How much damage does the move do? "), 0, 2);
		knockbackCalcPane.add(tfDamageKnockbackCalc, 1, 2);
		knockbackCalcPane.add(new Label("How much percent does the target have?"), 0, 3);
		knockbackCalcPane.add(tfPercent, 1, 3);
		knockbackCalcPane.add(new Label("How much does the target weigh?"), 0, 4);
		knockbackCalcPane.add(tfWeight, 1, 4);
		knockbackCalcPane.add(new Label("What is the knockback scaling?"), 0, 5);
		knockbackCalcPane.add(tfKnockbackScaling, 1, 5);
		knockbackCalcPane.add(new Label("What is the base knockback?"), 0, 6);
		knockbackCalcPane.add(tfBaseKnockback, 1, 6);
		knockbackCalcPane.add(chbDidTheyCc, 1, 7);
		knockbackCalcPane.add(btCalculateKnockbackCalc, 0, 8);
		knockbackCalcPane.add(new Label("Knockback:"), 0, 9);
		knockbackCalcPane.add(tfKnockbackResult, 1, 9);
		knockbackCalcPane.add(new Label("Hitstun:"), 0, 10);
		knockbackCalcPane.add(tfHitstunResult, 1, 10);
		knockbackCalcPane.add(new Label(""), 0, 11);
		knockbackCalcPane.add(btMainMenuKnockbackCalc, 0, 12);
		btKnockbackCalc.setOnAction(e -> knockbackCalcSceneM(e));
		btCalculateKnockbackCalc.setOnAction(e -> knockbackCalc());
		btMainMenuKnockbackCalc.setOnAction(e -> mainMenuKnockbackCalc(e));
		
		knockbackCalcScene = new Scene(knockbackCalcPane, 394, 377);
		knockbackCalcScene.getStylesheets().add("stylesheet.css");
    }
    /**
    Setting up the Frame Advantage on Block scene
    */
    public void frameAdvOnBlockSetup() {
		GridPane frameAdvOnBlockPane = new GridPane();
		frameAdvOnBlockPane.setHgap(5);
		frameAdvOnBlockPane.setVgap(5);
		frameAdvOnBlockPane.setPadding(new Insets(10, 10, 10, 10));
		
		Label lblFrameAdvOnBlock = new Label("Frame Advantage on Block");
		lblFrameAdvOnBlock.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
		frameAdvOnBlockPane.add(lblFrameAdvOnBlock, 0, 0);
		frameAdvOnBlockPane.add(new Label("What type of move was used? Aerial, Ground,"), 0, 1);
		frameAdvOnBlockPane.add(new Label("or Projectile?"), 0, 2);
		rbAerialFrameAdvOnBlock.setToggleGroup(moveTypeGroupFrameAdvOnBlock);
		rbGroundFrameAdvOnBlock.setToggleGroup(moveTypeGroupFrameAdvOnBlock);
		rbProjectileFrameAdvOnBlock.setToggleGroup(moveTypeGroupFrameAdvOnBlock);
		frameAdvOnBlockPane.add(rbAerialFrameAdvOnBlock, 1, 1);
		frameAdvOnBlockPane.add(rbGroundFrameAdvOnBlock, 1, 2);
		frameAdvOnBlockPane.add(rbProjectileFrameAdvOnBlock, 1, 3);
		frameAdvOnBlockPane.add(new Label("How much damage does the move do?"), 0, 5);
		frameAdvOnBlockPane.add(tfDamageFrameAdvOnBlock, 1, 5);
		btFrameAdvOnBlock.setOnAction(e -> frameAdvantageOnBlockSceneM(e));
		moveTypeGroupFrameAdvOnBlock.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
			removeFrameAdvOnBlock(frameAdvOnBlockPane);
			if(rbAerialFrameAdvOnBlock.isSelected()){    
			   	frameAdvOnBlockPane.add(lblLandingLagAerialFrameAdvOnBlock, 0, 6);       
			   	frameAdvOnBlockPane.add(tfLandingLagAerialFrameAdvOnBlock, 1, 6);   
				frameAdvOnBlockPane.add(lblFallFrames1AerialFrameAdvOnBlock, 0, 7);       
				frameAdvOnBlockPane.add(lblFallFrames2AerialFrameAdvOnBlock, 0, 8);       
				frameAdvOnBlockPane.add(tfFallFramesAerialFrameAdvOnBlock, 1, 8);
				tfFallFramesAerialFrameAdvOnBlock.setText(String.valueOf(0));			
		   	}
			else if(rbGroundFrameAdvOnBlock.isSelected()) {
		   		frameAdvOnBlockPane.add(lblFirstActiveFrameAdvOnBlock, 0, 6);   
		   		frameAdvOnBlockPane.add(tfFirstActiveFrameAdvOnBlock, 1, 6);   
		   		frameAdvOnBlockPane.add(lblTotalFrames1GroundFrameAdvOnBlock, 0, 7);   
		   		frameAdvOnBlockPane.add(lblTotalFrames2GroundFrameAdvOnBlock, 0, 8);   
			   	frameAdvOnBlockPane.add(tfTotalFramesFrameAdvOnBlock, 1, 8);   
		    }
		   	else if(rbProjectileFrameAdvOnBlock.isSelected()) {
		   		frameAdvOnBlockPane.add(lblLandingLag1ProjectileFrameAdvOnBlock, 0, 6);       
	    		frameAdvOnBlockPane.add(lblLandingLag2ProjectileFrameAdvOnBlock, 0, 7);       
	    		frameAdvOnBlockPane.add(tfLandingLagProjectileFrameAdvOnBlock, 1, 7);   
		   	}
		    else
		   		theStage.setScene(errorScene);
			frameAdvOnBlockPane.add(btCalculateFrameAdvOnBlock, 0, 9);
			frameAdvOnBlockPane.add(new Label("Frame Advantage on Block: "), 0, 10);
			frameAdvOnBlockPane.add(tfFrameAdvOnBlockResult, 1, 10);
		});
		frameAdvOnBlockPane.add(new Label(""), 0, 11);
		frameAdvOnBlockPane.add(btMainMenuFrameAdvOnBlock, 0, 12);
		btCalculateFrameAdvOnBlock.setOnAction(e -> frameAdvantageOnBlock());
		btMainMenuFrameAdvOnBlock.setOnAction(e -> mainMenuFrameAdvOnBlock(e));
		
		frameAdvantageOnBlockScene = new Scene(frameAdvOnBlockPane, 415, 333);
		frameAdvantageOnBlockScene.getStylesheets().add("stylesheet.css");
    }
    /**
    Setting up the Frame Advantage on Hit scene
    */
    public void frameAdvOnHitSetup() {
		GridPane frameAdvOnHitPane = new GridPane();
		frameAdvOnHitPane.setHgap(5);
		frameAdvOnHitPane.setVgap(5);
		frameAdvOnHitPane.setPadding(new Insets(10, 10, 10, 10));
		
		Label lblFrameAdvOnHit = new Label("Frame Advantage on Hit");
		lblFrameAdvOnHit.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
		frameAdvOnHitPane.add(lblFrameAdvOnHit, 0, 0);
		frameAdvOnHitPane.add(new Label("What type of move was used? Aerial, Ground,"), 0, 1);
		frameAdvOnHitPane.add(new Label("or Projectile?"), 0, 2);
		rbAerialFrameAdvOnHit.setToggleGroup(moveTypeGroupFrameAdvOnHit);
		rbGroundFrameAdvOnHit.setToggleGroup(moveTypeGroupFrameAdvOnHit);
		rbProjectileFrameAdvOnHit.setToggleGroup(moveTypeGroupFrameAdvOnHit);
		frameAdvOnHitPane.add(rbAerialFrameAdvOnHit, 1, 1);
		frameAdvOnHitPane.add(rbGroundFrameAdvOnHit, 1, 2);
		frameAdvOnHitPane.add(rbProjectileFrameAdvOnHit, 1, 3);
		frameAdvOnHitPane.add(new Label("How much hitstun does the move do?"), 0, 6);
		frameAdvOnHitPane.add(tfHitstunFrameAdvOnHit, 1, 6);
		frameAdvOnHitPane.add(new Label("If you don't know the hitstun,"), 0, 7);
		frameAdvOnHitPane.add(new Label("use the following button"), 0, 8);
		frameAdvOnHitPane.add(btHitstunCalcFrameAdvOnHit, 1, 8);
		btHitstunCalcFrameAdvOnHit.setOnAction(e -> frameAdvantageOnHitToHitstunCalc(e));
		btFrameAdvOnHit.setOnAction(e -> frameAdvantageOnHitSceneM(e));
		moveTypeGroupFrameAdvOnHit.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
			removeFrameAdvOnHit(frameAdvOnHitPane);
			if(rbAerialFrameAdvOnHit.isSelected()){    
				frameAdvOnHitPane.add(lblLandingLagAerialFrameAdvOnHit, 0, 9);   
				frameAdvOnHitPane.add(tfLandingLagAerialFrameAdvOnHit, 1, 9);
				frameAdvOnHitPane.add(lblFallFrames1AerialFrameAdvOnHit, 0, 10);
				frameAdvOnHitPane.add(lblFallFrames2AerialFrameAdvOnHit, 0, 11);       
				frameAdvOnHitPane.add(tfFallFramesAerialFrameAdvOnHit, 1, 11);     
				tfFallFramesAerialFrameAdvOnHit.setText(String.valueOf(0));			
			}
	    	else if(rbGroundFrameAdvOnHit.isSelected()) {
	    		frameAdvOnHitPane.add(lblFirstActiveFrameAdvOnHit, 0, 9);   
	    		frameAdvOnHitPane.add(tfFirstActiveFrameAdvOnHit, 1, 9);   
	    		frameAdvOnHitPane.add(lblTotalFrames1GroundFrameAdvOnHit, 0, 10);   
	    		frameAdvOnHitPane.add(lblTotalFrames2GroundFrameAdvOnHit, 0, 11);   
	    		frameAdvOnHitPane.add(tfTotalFramesFrameAdvOnHit, 1, 11);   
	    	}
	    	else if(rbProjectileFrameAdvOnHit.isSelected()) {
	    		frameAdvOnHitPane.add(lblDamageProjectileFrameAdvOnHit, 0, 9);
	    		frameAdvOnHitPane.add(tfDamageProjectileFrameAdvOnHit, 1, 9);
	    		frameAdvOnHitPane.add(lblLandingLag1ProjectileFrameAdvOnHit, 0, 10);  
	    		frameAdvOnHitPane.add(lblLandingLag2ProjectileFrameAdvOnHit, 0, 11);       
	    		frameAdvOnHitPane.add(tfLandingLagProjectileFrameAdvOnHit, 1, 11);   
	    	}
	    	else
	    		System.out.println("Error");
			frameAdvOnHitPane.add(btCalculateFrameAdvOnHit, 0, 13);
			frameAdvOnHitPane.add(new Label("Frame Advantage on Hit: "), 0, 14);
			frameAdvOnHitPane.add(tfFrameAdvOnHitResult, 1, 14);
			frameAdvOnHitPane.add(new Label(""), 0, 15);
		});
		frameAdvOnHitPane.add(btMainMenuFrameAdvOnHit, 0, 16);
		btCalculateFrameAdvOnHit.setOnAction(e -> frameAdvantageOnHit());
		btMainMenuFrameAdvOnHit.setOnAction(e -> mainMenuFrameAdvOnHit(e));
		
		frameAdvantageOnHitScene = new Scene(frameAdvOnHitPane, 415, 420);
		frameAdvantageOnHitScene.getStylesheets().add("stylesheet.css");
    }
    /**
    Setting up the Stale Move Negation scene
    */
    public void staleMoveNegationSetup() {
    	GridPane staleMoveNegationPane = new GridPane();
		staleMoveNegationPane.setHgap(5);
		staleMoveNegationPane.setVgap(5);
		staleMoveNegationPane.setPadding(new Insets(10, 10, 10, 10));
		
		Label lblStaleMoveNegation = new Label("Stale Move Negation");
		lblStaleMoveNegation.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
		staleMoveNegationPane.add(lblStaleMoveNegation, 0, 0);
		btStaleMoveCalc.setOnAction(e -> staleMoveNegationM(e));
		staleMoveNegationPane.add(new Label("How much damage does the move do?"), 0, 1);
		staleMoveNegationPane.add(tfDamageStaleMoveNegation, 1, 1);
		staleMoveNegationPane.add(new Label("Click on the spots where the move was used"), 0, 2);
		staleMoveNegationPane.add(new Label("With 1 being used most recently"), 0, 3);
		staleMoveNegationPane.add(rbStale1, 0, 4);
		staleMoveNegationPane.add(rbStale2, 0, 5);
		staleMoveNegationPane.add(rbStale3, 0, 6);
		staleMoveNegationPane.add(rbStale4, 0, 7);
		staleMoveNegationPane.add(rbStale5, 0, 8);
		staleMoveNegationPane.add(rbStale6, 0, 9);
		staleMoveNegationPane.add(rbStale7, 0, 10);
		staleMoveNegationPane.add(rbStale8, 0, 11);
		staleMoveNegationPane.add(rbStale9, 0, 12);
		staleMoveNegationPane.add(btCalcStaleMovePoints, 0, 13);
		btCalcStaleMovePoints.setOnAction(e -> staleMoveNegation());
		staleMoveNegationPane.add(new Label("Stale Move Points Total: "), 0, 14);
		staleMoveNegationPane.add(tfStaleMovePointsTotal, 1, 14);
		staleMoveNegationPane.add(new Label("The move's damage will be decreased by: "), 0, 15);
		staleMoveNegationPane.add(tfStaleMovePercentEffected, 1, 15);
		staleMoveNegationPane.add(new Label("The move will now do: "), 0, 16);
		staleMoveNegationPane.add(tfStaleMoveResult, 1, 16);
		staleMoveNegationPane.add(new Label(""), 0, 17);
		staleMoveNegationPane.add(btMainMenuStaleMoveNegation, 0, 18);
		btMainMenuStaleMoveNegation.setOnAction(e -> mainMenuStaleMoveNegation(e));
		
		staleMoveNegationScene = new Scene(staleMoveNegationPane, 415, 485);
		staleMoveNegationScene.getStylesheets().add("stylesheet.css");
    }
    /**
    Setting up the Hitlag Calculator scene
    */
    public void hitlagCalcSetup () {
		GridPane hitlagCalcPane = new GridPane();
		hitlagCalcPane.setHgap(5);
		hitlagCalcPane.setVgap(5);
		hitlagCalcPane.setPadding(new Insets(10, 10, 10, 10));
		
		Label lblHitlagCalc = new Label("Hitlag Calculator");
		lblHitlagCalc.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
		hitlagCalcPane.add(lblHitlagCalc, 0, 0);
		btHitlagCalc.setOnAction(e -> hitlagCalcM(e));
		hitlagCalcPane.add(new Label("How much damage does the move do?"), 0, 1);
		hitlagCalcPane.add(tfDamageHitlagCalc, 1, 1);
		hitlagCalcPane.add(chbElectricMove, 1, 2);
		hitlagCalcPane.add(btCalculateHitlag, 0, 3);
		btCalculateHitlag.setOnAction(e -> hitlagCalc());
		hitlagCalcPane.add(new Label("Hitlag: "), 0, 4);
		hitlagCalcPane.add(tfHitlagResultHitlagCalc, 1, 4);
		hitlagCalcPane.add(new Label(""), 0, 5);
		hitlagCalcPane.add(btMainMenuHitlagCalc, 0, 6);
		btMainMenuHitlagCalc.setOnAction(e -> mainMenuHitlagCalc(e));
		
		hitlagCalcScene = new Scene(hitlagCalcPane, 383, 203);
		hitlagCalcScene.getStylesheets().add("stylesheet.css");
    }
    /**
    Setting up the Frame Advantage on Amsah Tech scene
    */
    public void frameAdvOnAtSetup() {
    	GridPane frameAdvOnAtPane = new GridPane();
    	frameAdvOnAtPane.setHgap(5);
    	frameAdvOnAtPane.setVgap(5);
    	frameAdvOnAtPane.setPadding(new Insets(10, 10, 10, 10));
		
		Label lblFrameAdvOnAt = new Label("Frame Advantage on AT");
		lblFrameAdvOnAt.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
		frameAdvOnAtPane.add(lblFrameAdvOnAt, 0, 0);
		frameAdvOnAtPane.add(new Label("What type of move was used? Aerial, Ground,"), 0, 1);
		frameAdvOnAtPane.add(new Label("or Projectile?"), 0, 2);
		rbAerialFrameAdvOnAt.setToggleGroup(moveTypeGroupFrameAdvOnAt);
		rbGroundFrameAdvOnAt.setToggleGroup(moveTypeGroupFrameAdvOnAt);
		rbProjectileFrameAdvOnAt.setToggleGroup(moveTypeGroupFrameAdvOnAt);
		frameAdvOnAtPane.add(rbAerialFrameAdvOnAt, 1, 1);
		frameAdvOnAtPane.add(rbGroundFrameAdvOnAt, 1, 2);
		frameAdvOnAtPane.add(rbProjectileFrameAdvOnAt, 1, 3);
		
		frameAdvOnAtPane.add(new Label("What type of tech was used?"), 0, 5);
		rbTechInPlaceFrameAdvOnAt.setToggleGroup(techTypeGroupFrameAdvOnAt);
		rbTechRollFrameAdvOnAt.setToggleGroup(techTypeGroupFrameAdvOnAt);
		rbTechInPlaceFrameAdvOnAt.setSelected(true);
		frameAdvOnAtPane.add(rbTechInPlaceFrameAdvOnAt, 1, 5);
		frameAdvOnAtPane.add(rbTechRollFrameAdvOnAt, 1, 6);
		btFrameAdvOnAt.setOnAction(e -> frameAdvantageOnAtSceneM(e));

		moveTypeGroupFrameAdvOnAt.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
    		removeFrameAdvOnAt(frameAdvOnAtPane);
			if(rbAerialFrameAdvOnAt.isSelected()){    
				frameAdvOnAtPane.add(lblLandingLagAerialFrameAdvOnAt, 0, 9);   
				frameAdvOnAtPane.add(tfLandingLagAerialFrameAdvOnAt, 1, 9);
				frameAdvOnAtPane.add(lblFallFrames1AerialFrameAdvOnAt, 0, 10);
				frameAdvOnAtPane.add(lblFallFrames2AerialFrameAdvOnAt, 0, 11);       
				frameAdvOnAtPane.add(tfFallFramesAerialFrameAdvOnAt, 1, 11);     
				tfFallFramesAerialFrameAdvOnAt.setText(String.valueOf(0));			
			}
	    	else if(rbGroundFrameAdvOnAt.isSelected()) {
	    		frameAdvOnAtPane.add(lblFirstActiveFrameAdvOnAt, 0, 9);   
	    		frameAdvOnAtPane.add(tfFirstActiveFrameAdvOnAt, 1, 9);   
	    		frameAdvOnAtPane.add(lblTotalFrames1GroundFrameAdvOnAt, 0, 10);   
	    		frameAdvOnAtPane.add(lblTotalFrames2GroundFrameAdvOnAt, 0, 11);   
	    		frameAdvOnAtPane.add(tfTotalFramesFrameAdvOnAt, 1, 11);   
	    	}
	    	else if(rbProjectileFrameAdvOnAt.isSelected()) {
	    		frameAdvOnAtPane.add(lblLandingLag1ProjectileFrameAdvOnAt, 0, 9);  
	    		frameAdvOnAtPane.add(lblLandingLag2ProjectileFrameAdvOnAt, 0, 10);       
	    		frameAdvOnAtPane.add(tfLandingLagProjectileFrameAdvOnAt, 1, 10);   
	    		frameAdvOnAtPane.add(lblDamageProjectileFrameAdvOnAt, 0, 11);   
	    		frameAdvOnAtPane.add(tfDamageProjectileFrameAdvOnAt, 1, 11);   
	    	}
	    	else
	    		theStage.setScene(errorScene);
			frameAdvOnAtPane.add(btCalculateFrameAdvOnAt, 0, 13);
			frameAdvOnAtPane.add(new Label("Frame Advantage on At: "), 0, 14);
			frameAdvOnAtPane.add(tfFrameAdvOnAtResult, 1, 14);
			frameAdvOnAtPane.add(new Label(""), 0, 15);
		});
		frameAdvOnAtPane.add(btMainMenuFrameAdvOnAt, 0, 16);
		btCalculateFrameAdvOnAt.setOnAction(e -> frameAdvantageOnAt());
		btMainMenuFrameAdvOnAt.setOnAction(e -> mainMenuFrameAdvOnAt(e));
		
		frameAdvantageOnAtScene = new Scene(frameAdvOnAtPane, 415, 400);
		frameAdvantageOnAtScene.getStylesheets().add("stylesheet.css");
    }
    /**
    Setting up the Error scene
    */
    public void errorSetup() {
       	GridPane errorPane = new GridPane();
    	errorPane.setHgap(5);
    	errorPane.setVgap(5);
    	errorPane.setPadding(new Insets(10, 10, 10, 10));
    	
		Label lblError = new Label("Sorry, there was an error.  Please restart the program.");
		lblError.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		errorPane.add(lblError, 0, 0);
		
		errorScene = new Scene(errorPane, 1000, 500);
    }
    
    //Removing nodes to make room for different nodes
    /**
    Removes nodes (buttons, labels, etc.) in Frame Advantage on Block to make room for relevant nodes
    */
    public void removeFrameAdvOnBlock(GridPane frameAdvOnBlockPane) {
		frameAdvOnBlockPane.getChildren().remove(lblLandingLagAerialFrameAdvOnBlock);
		frameAdvOnBlockPane.getChildren().remove(tfLandingLagAerialFrameAdvOnBlock);
		frameAdvOnBlockPane.getChildren().remove(lblFallFrames1AerialFrameAdvOnBlock);
		frameAdvOnBlockPane.getChildren().remove(lblFallFrames2AerialFrameAdvOnBlock);
		frameAdvOnBlockPane.getChildren().remove(tfFallFramesAerialFrameAdvOnBlock);
		frameAdvOnBlockPane.getChildren().remove(lblFirstActiveFrameAdvOnBlock);
		frameAdvOnBlockPane.getChildren().remove(tfFirstActiveFrameAdvOnBlock);
		frameAdvOnBlockPane.getChildren().remove(lblTotalFrames1GroundFrameAdvOnBlock);
		frameAdvOnBlockPane.getChildren().remove(lblTotalFrames2GroundFrameAdvOnBlock);
		frameAdvOnBlockPane.getChildren().remove(tfTotalFramesFrameAdvOnBlock);
		frameAdvOnBlockPane.getChildren().remove(lblLandingLag1ProjectileFrameAdvOnBlock);
		frameAdvOnBlockPane.getChildren().remove(lblLandingLag2ProjectileFrameAdvOnBlock);
		frameAdvOnBlockPane.getChildren().remove(tfLandingLagProjectileFrameAdvOnBlock);
    }
    /**
    Removes nodes (buttons, labels, etc.) in Frame Advantage on Hit to make room for relevant nodes
    */
    public void removeFrameAdvOnHit(GridPane frameAdvOnHitPane) {
    	frameAdvOnHitPane.getChildren().remove(lblLandingLagAerialFrameAdvOnHit);
		frameAdvOnHitPane.getChildren().remove(tfLandingLagAerialFrameAdvOnHit);
		frameAdvOnHitPane.getChildren().remove(lblFallFrames1AerialFrameAdvOnHit);
		frameAdvOnHitPane.getChildren().remove(lblFallFrames2AerialFrameAdvOnHit);
		frameAdvOnHitPane.getChildren().remove(tfFallFramesAerialFrameAdvOnHit);
		frameAdvOnHitPane.getChildren().remove(lblFirstActiveFrameAdvOnHit);
		frameAdvOnHitPane.getChildren().remove(tfFirstActiveFrameAdvOnHit);
		frameAdvOnHitPane.getChildren().remove(lblTotalFrames1GroundFrameAdvOnHit);
		frameAdvOnHitPane.getChildren().remove(lblTotalFrames2GroundFrameAdvOnHit);
		frameAdvOnHitPane.getChildren().remove(tfTotalFramesFrameAdvOnHit);
		frameAdvOnHitPane.getChildren().remove(lblDamageProjectileFrameAdvOnHit);
		frameAdvOnHitPane.getChildren().remove(lblDamageProjectileFrameAdvOnHit);
		frameAdvOnHitPane.getChildren().remove(lblLandingLag1ProjectileFrameAdvOnHit);
		frameAdvOnHitPane.getChildren().remove(lblLandingLag2ProjectileFrameAdvOnHit);
		frameAdvOnHitPane.getChildren().remove(tfLandingLagProjectileFrameAdvOnHit);
    }
    /**
    Removes nodes (buttons, labels, etc.) in Frame Advantage on Amsah Tech to make room for relevant nodes
    */
    public void removeFrameAdvOnAt(GridPane frameAdvOnAtPane) {
    	frameAdvOnAtPane.getChildren().remove(lblLandingLagAerialFrameAdvOnAt);
    	frameAdvOnAtPane.getChildren().remove(tfLandingLagAerialFrameAdvOnAt);
    	frameAdvOnAtPane.getChildren().remove(lblFallFrames1AerialFrameAdvOnAt);
    	frameAdvOnAtPane.getChildren().remove(lblFallFrames2AerialFrameAdvOnAt);
		frameAdvOnAtPane.getChildren().remove(tfFallFramesAerialFrameAdvOnAt);
		frameAdvOnAtPane.getChildren().remove(lblFirstActiveFrameAdvOnAt);
		frameAdvOnAtPane.getChildren().remove(tfFirstActiveFrameAdvOnAt);
		frameAdvOnAtPane.getChildren().remove(lblTotalFrames1GroundFrameAdvOnAt);
		frameAdvOnAtPane.getChildren().remove(lblTotalFrames2GroundFrameAdvOnAt);
		frameAdvOnAtPane.getChildren().remove(tfTotalFramesFrameAdvOnAt);
		frameAdvOnAtPane.getChildren().remove(lblLandingLag1ProjectileFrameAdvOnAt);
		frameAdvOnAtPane.getChildren().remove(lblLandingLag2ProjectileFrameAdvOnAt);
		frameAdvOnAtPane.getChildren().remove(tfLandingLagProjectileFrameAdvOnAt);
    }
   
     //Methods to go from the main menu to other scenes by the click of a button
    /**
    This method takes the user from the main menu scene to the knockback calculator scene.
    */
    public void knockbackCalcSceneM(ActionEvent e)
    {
        if (e.getSource() == btKnockbackCalc)
            theStage.setScene(knockbackCalcScene);
        else
        	theStage.setScene(mainMenuScene);
    }
    /**
    This method takes the user from the main menu scene to the frame advantage on block scene.
    */
    public void frameAdvantageOnBlockSceneM(ActionEvent e)
    {
        if (e.getSource() == btFrameAdvOnBlock)
            theStage.setScene(frameAdvantageOnBlockScene);
        else
        	theStage.setScene(mainMenuScene);
    }
    /**
    This method takes the user from the main menu scene to the frame advantage on hit scene.
    */
    public void frameAdvantageOnHitSceneM(ActionEvent e)
    {
        if (e.getSource() == btFrameAdvOnHit)
            theStage.setScene(frameAdvantageOnHitScene);
        else
        	theStage.setScene(mainMenuScene);
    }
    /**
    This method takes the user from the frame advantage on hit scene to the knockback calculator scene.
    */
    public void frameAdvantageOnHitToHitstunCalc(ActionEvent e)
    {
        if (e.getSource() == btHitstunCalcFrameAdvOnHit)
            theStage.setScene(knockbackCalcScene);
        else
        	theStage.setScene(mainMenuScene);
    }
    /**
    This method takes the user from the main menu scene to the stale move negation scene.
    */
    public void staleMoveNegationM(ActionEvent e)
    {
        if (e.getSource() == btStaleMoveCalc)
            theStage.setScene(staleMoveNegationScene);
        else
        	theStage.setScene(mainMenuScene);
    }
    /**
    This method takes the user from the main menu scene to the hitlag calculator scene.
    */
    public void hitlagCalcM(ActionEvent e)
    {
        if (e.getSource() == btHitlagCalc)
            theStage.setScene(hitlagCalcScene);
        else
        	theStage.setScene(mainMenuScene);
    }
    /**
    This method takes the user from the main menu scene to the frame advantage on amsah tech scene.
    */
    public void frameAdvantageOnAtSceneM(ActionEvent e)
    {
        if (e.getSource() == btFrameAdvOnAt)
            theStage.setScene(frameAdvantageOnAtScene);
        else
        	theStage.setScene(mainMenuScene);
    }
    
     //Methods that take the user back to the main menu
    /**
     This method takes the user from the knockback calculator scene to the main menu scene.
     */
    public void mainMenuKnockbackCalc(ActionEvent e)
    {
        if (e.getSource() == btMainMenuKnockbackCalc)
            theStage.setScene(mainMenuScene);
        else
        	theStage.setScene(errorScene);
    }
    /**
    This method takes the user from the frame advantage on block scene to the main menu scene.
    */
    public void mainMenuFrameAdvOnBlock(ActionEvent e)
    {
        if (e.getSource() == btMainMenuFrameAdvOnBlock)
            theStage.setScene(mainMenuScene);
        else
        	theStage.setScene(errorScene);
    }
    /**
    This method takes the user from the frame advantage on hit scene to the main menu scene.
    */
    public void mainMenuFrameAdvOnHit(ActionEvent e)
    {
        if (e.getSource() == btMainMenuFrameAdvOnHit)
            theStage.setScene(mainMenuScene);
        else
        	theStage.setScene(errorScene);
    }
    /**
    This method takes the user from the stale move negation scene to the main menu scene.
    */
    public void mainMenuStaleMoveNegation(ActionEvent e)
    {
        if (e.getSource() == btMainMenuStaleMoveNegation)
            theStage.setScene(mainMenuScene);
        else
        	theStage.setScene(errorScene);
    }
    /**
    This method takes the user from the hitlag calculator scene to the main menu scene.
    */
    public void mainMenuHitlagCalc(ActionEvent e)
    {
        if (e.getSource() == btMainMenuHitlagCalc)
            theStage.setScene(mainMenuScene);
        else
        	theStage.setScene(errorScene);
    }
    /**
    This method takes the user from the frame advantage on amsah tech scene to the main menu scene.
    */
    public void mainMenuFrameAdvOnAt(ActionEvent e)
    {
        if (e.getSource() == btMainMenuFrameAdvOnAt)
            theStage.setScene(mainMenuScene);
        else
        	theStage.setScene(errorScene);
    }
    
    //Methods for the most important functions of the program
    /**
     This method calculates the knockback based on user input for move damage, target percent,
     target weight, move knockback scaling, and move base knockback. This also takes into account
     whether or not the target is crouch cancelling.
     */
    public void knockbackCalc() {
		double damage = Double.parseDouble(tfDamageKnockbackCalc.getText()); //damage of a move, how much percent a move does
		double percent = Double.parseDouble(tfPercent.getText()); //how much total damage or percent has the target taken
		double weight = Double.parseDouble(tfWeight.getText()); //how heavy a target is
		double knockbackScaling = Double.parseDouble(tfKnockbackScaling.getText()); //how the knockback scales with percent for a move
		double baseKnockback = Double.parseDouble(tfBaseKnockback.getText()); //where the knockback starts for a move
		double knockback = 0; //knockback of move]
		final int LANDING_LAG = 4; //normal landing lag frames
		int hitstun = 0;
		
		if (chbDidTheyCc.isSelected()) {
			knockback = cc(damage, percent, weight, knockbackScaling, baseKnockback);
			hitstun = (int) hitstunM(knockback);
		}
		else {
			knockback = asdid(damage, percent, weight, knockbackScaling, baseKnockback);
			hitstun = (int) hitstunM(knockback) + LANDING_LAG;
		}	
		tfHitstunResult.setText(String.valueOf(hitstun));
		tfKnockbackResult.setText(String.valueOf(f.format(knockback)));
    }
    /**
     This method calculates the frame advantage on block based on user input for move damage.
     The move damage is then converted into shieldstun and the user selects whether the move was 
     an aerial, ground, or projectile. After that the shieldstun and move type is used to calculate
     the final frame advantage on block. 
    */
    public void frameAdvantageOnBlock() {
    	double damage = Double.parseDouble(tfDamageFrameAdvOnBlock.getText()); //damage of move, how much percent the move does
    	int shieldstun = shieldstunM((int) damage); //the amount of frames the target is stuck in shield and unactionable
    	int frameAdvOnBlock = 0; //frame advantage on block of move

		if (rbAerialFrameAdvOnBlock.isSelected()) {
	    	int landingLag = Integer.parseInt(tfLandingLagAerialFrameAdvOnBlock.getText()); //amount of frames that the user of a move is unactionable when landing
			int fallFrames = Integer.parseInt(tfFallFramesAerialFrameAdvOnBlock.getText()); //the amount of falling frames after the move has hit
			frameAdvOnBlock = aerialBlock(shieldstun, landingLag, fallFrames);
		}
		else if (rbGroundFrameAdvOnBlock.isSelected()) {
			int firstActive = Integer.parseInt(tfFirstActiveFrameAdvOnBlock.getText()); //first active frame of move
			int totalFrames = Integer.parseInt(tfTotalFramesFrameAdvOnBlock.getText()); //the total amount of frames the move has
			frameAdvOnBlock = groundBlock(shieldstun, firstActive, totalFrames);
		}
		else if (rbProjectileFrameAdvOnBlock.isSelected()) {
	    	int landingLag = Integer.parseInt(tfLandingLagProjectileFrameAdvOnBlock.getText()); //amount of frames that the user of a move is unactionable when landing
			int hitlag = hitlagM((int) damage); //the amount of frames characters are frozen after a move hits
			frameAdvOnBlock = projectileBlock(shieldstun, hitlag, landingLag);
		}
		else
			System.out.println("Error");
		
		if (frameAdvOnBlock > -1)
			tfFrameAdvOnBlockResult.setText(String.valueOf("+" + frameAdvOnBlock));
		else
			tfFrameAdvOnBlockResult.setText(String.valueOf(frameAdvOnBlock));

    }
    /**
    This method calculates the frame advantage on hit based on user input for knockback.
    The knockback is then converted into hitstun and the user selects whether the move was
    aerial, ground, or projectile. After that the hitstun and move type is used to calculate
    the final frame advantage on hit. 
   */
    public void frameAdvantageOnHit() {
    	int hitstun = Integer.parseInt(tfHitstunFrameAdvOnHit.getText()); //the amount of frames that the target is unactionable while in knockback
		int frameAdvOnHit = 0; //frame advantage on hit of move 
		
		if (rbAerialFrameAdvOnHit.isSelected()) {
			int landingLag = Integer.parseInt(tfLandingLagAerialFrameAdvOnHit.getText()); //amount of frames that the user of a move is unactionable when landing
			int fallFrames = Integer.parseInt(tfFallFramesAerialFrameAdvOnHit.getText()); //the amount of falling frames after the move has hit
			frameAdvOnHit = aerialHit(hitstun, landingLag, fallFrames);
		}
		else if (rbGroundFrameAdvOnHit.isSelected()) {
			int firstActive = Integer.parseInt(tfFirstActiveFrameAdvOnHit.getText()); //first active frame of move
			int totalFrames = Integer.parseInt(tfTotalFramesFrameAdvOnHit.getText()); //the total amount of frames the move has
			frameAdvOnHit = groundHit(hitstun, firstActive, totalFrames);
		}
		else if (rbProjectileFrameAdvOnHit.isSelected()) {
	    	double damage = Double.parseDouble(tfDamageProjectileFrameAdvOnHit.getText()); //damage of move, how much percent the move does
			int landingLag = Integer.parseInt(tfLandingLagProjectileFrameAdvOnHit.getText()); //amount of frames that the user of a move is unactionable when landing
			int hitlag = hitlagM((int) damage); //the amount of frames characters are frozen after a move hits
			frameAdvOnHit = projectileHit(hitstun, hitlag, landingLag);
		}
		else
			System.out.println("Error");
		
		if (frameAdvOnHit > -1)
			tfFrameAdvOnHitResult.setText(String.valueOf("+" + frameAdvOnHit));
		else
			tfFrameAdvOnHitResult.setText(String.valueOf(frameAdvOnHit));
    }
    /**
     This method calculates how many stale points its accumulated, how much the percent is affected,
     and the final percent the move will do, based on user input about its position(s) in the stale 
     move queue and move damage. 
     */
    public void staleMoveNegation() {
    	double damage = Double.parseDouble(tfDamageStaleMoveNegation.getText()); //damage of move, how much percent the move does
    	double[] staleMoveQueue = {0,.09,.08,.07,.06,.05,.04,.03,.02,.01}; //the stale move queue has 9 slots (1-9), a move can be stored in multiple slots in the queue and is assigned its respective value
    	double staleMovePoints = 0; //keeps track of the total amount of stale points based on the stale move queue
    	double percentEffected; //how much percent the move will be effected
    	double staleDamage; //the final amount of damage the move will do
    	double stale1 = 0; //if radio button 1 is selected by the user stale1 will be assigned its respective value from the stale move queue array
    	double stale2 = 0; //if radio button 2 is selected by the user stale2 will be assigned its respective value from the stale move queue array
    	double stale3 = 0; //if radio button 3 is selected by the user stale3 will be assigned its respective value from the stale move queue array
    	double stale4 = 0; //if radio button 4 is selected by the user stale4 will be assigned its respective value from the stale move queue array
    	double stale5 = 0; //if radio button 5 is selected by the user stale5 will be assigned its respective value from the stale move queue array
    	double stale6 = 0; //if radio button 6 is selected by the user stale6 will be assigned its respective value from the stale move queue array
    	double stale7 = 0; //if radio button 7 is selected by the user stale7 will be assigned its respective value from the stale move queue array
    	double stale8 = 0; //if radio button 8 is selected by the user stale8 will be assigned its respective value from the stale move queue array
    	double stale9 = 0; //if radio button 9 is selected by the user stale9 will be assigned its respective value from the stale move queue array
        DecimalFormat staleMoveF = new DecimalFormat("##.00"); //goes to 2 decimal places because that's as far as stale move points go
    	
    	if (rbStale1.isSelected())
    		stale1 = staleMoveQueue[1];
    	if (rbStale2.isSelected())
    		stale2 = staleMoveQueue[2];
    	if (rbStale3.isSelected())
    		stale3 = staleMoveQueue[3];
    	if (rbStale4.isSelected()) 
    		stale4 = staleMoveQueue[4];
    	if (rbStale5.isSelected()) 
    		stale5 = staleMoveQueue[5];
    	if (rbStale6.isSelected())
    		stale6 = staleMoveQueue[6];
    	if (rbStale7.isSelected())
    		stale7 = staleMoveQueue[7];
    	if (rbStale8.isSelected()) 
    		stale8 = staleMoveQueue[8];
    	if (rbStale9.isSelected()) 
    		stale9 = staleMoveQueue[9];
    	
    	staleMovePoints = stale1 + stale2 + stale3 + stale4 + stale5 + stale6 + stale7 + stale8 + stale9;
		tfStaleMovePointsTotal.setText(String.valueOf(staleMoveF.format(staleMovePoints)));
    	percentEffected = Math.abs(staleMovePoints - 1); 
		tfStaleMovePercentEffected.setText(String.valueOf(staleMoveF.format(staleMovePoints * 100)) + "%");
		staleDamage = percentEffected * damage;
		tfStaleMoveResult.setText(String.valueOf(staleMoveF.format(staleDamage)) + "%");
    }
    /**
     This method calculates hitlag for a move based on user input for damage and whether or not 
     it's an electric move.
     */
    public void hitlagCalc() {
    	double damage = Double.parseDouble(tfDamageHitlagCalc.getText()); //damage of move, how much percent the move does
		int hitlag = hitlagM((int) damage); //the amount of frames characters are frozen after a move hits
		if (chbElectricMove.isSelected())
			hitlag *= 1.5;
		
		tfHitlagResultHitlagCalc.setText(String.valueOf(hitlag));
    }
    /**
     This method calculates frame advantage on amsah tech based on user input for move type and whether 
     the target tech rolled or teched in place.  
     */
    public void frameAdvantageOnAt() {
    	final int techInPlace = 26; //constant for the amount of frames the animation 'tech in place' takes
    	final int techRoll = 40; //constant for the amount of frames the animation 'tech roll' takes
    	int beforeTech = 0; //the amount of recovery a move has before the tech takes place
    	int frameAdvOnAt = 0; //frame advantage on at of move

		if (rbAerialFrameAdvOnAt.isSelected()) {
			int landingLag = Integer.parseInt(tfLandingLagAerialFrameAdvOnAt.getText()); //amount of frames that the user of a move is unactionable when landing
			int fallFrames = Integer.parseInt(tfFallFramesAerialFrameAdvOnAt.getText()); //the amount of falling frames after the move has hit
			beforeTech = aerialAt(landingLag, fallFrames);
			
			if (rbTechInPlaceFrameAdvOnAt.isSelected()) {
				frameAdvOnAt = techInPlace - beforeTech;
			}
			else if (rbTechRollFrameAdvOnAt.isSelected()) {
				frameAdvOnAt = techRoll - beforeTech;
			}
		}
		else if (rbGroundFrameAdvOnAt.isSelected()) {
			int firstActive = Integer.parseInt(tfFirstActiveFrameAdvOnAt.getText()); //first active frame of move
			int totalFrames = Integer.parseInt(tfTotalFramesFrameAdvOnAt.getText()); //the total amount of frames the move has
			beforeTech = groundAt(firstActive, totalFrames);

			if (rbTechInPlaceFrameAdvOnAt.isSelected()) {
				frameAdvOnAt = techInPlace - beforeTech;
				}
			else if (rbTechRollFrameAdvOnAt.isSelected()) {
				frameAdvOnAt = techRoll - beforeTech;
			}
		}
		else if (rbProjectileFrameAdvOnAt.isSelected()) {
			int landingLag = Integer.parseInt(tfLandingLagProjectileFrameAdvOnAt.getText()); //amount of frames that the user of a move is unactionable when landing
			double damage = Integer.parseInt(tfDamageProjectileFrameAdvOnAt.getText()); //damage of move, how much percent the move does
			int hitlag = hitlagM((int) damage);
			beforeTech = projectileAt(hitlag, landingLag);
			
			if (rbTechInPlaceFrameAdvOnAt.isSelected()) {
				frameAdvOnAt = techInPlace - beforeTech;
				}
			else if (rbTechRollFrameAdvOnAt.isSelected()) {
				frameAdvOnAt = techRoll - beforeTech;
			}
		}
		else
			System.out.println("Error");
		
		if (frameAdvOnAt > -1)
			tfFrameAdvOnAtResult.setText(String.valueOf("+" + frameAdvOnAt));
		else
			tfFrameAdvOnAtResult.setText(String.valueOf(frameAdvOnAt));
    }
    
	//extra methods for calculations
    /**
	 This method calculates knockback after a crouch cancel by using damage, percent, weight, 
	 knockback scaling, and base knockback.
     */
    public static double cc(double damage, double percent, double weight, double knockbackScaling, double baseKnockback) {
		double knockback = (((((((percent + damage) / 10) + (((percent + damage) * damage)/20)) * (200/(weight + 100)) * 1.4) + 18) * (knockbackScaling / 100)) + baseKnockback) * (2 / 3); //how much a target would get knocked back from a move
		
		return knockback;
	}
    /**
     This method calculates knockback with automatic smash directional influence down by using 
     damage, percent, weight, knockback scaling, and base knockback.
     */
	public static double asdid(double damage, double percent, double weight, double knockbackScaling, double baseKnockback) {
		double knockback = (((((((percent + damage) / 10) + (((percent + damage) * damage)/20)) * (200/(weight + 100)) * 1.4) + 18) * (knockbackScaling / 100)) + baseKnockback); //how much a target would get knocked back from a move
		
		return knockback;
	}
	
	/**
	 This method calculates shieldstun by using move damage.
	 */
	public static int shieldstunM(int damage) {
		int shieldstun = 0; //the amount of frames the target is stuck in shield and unactionable
		shieldstun = (int) Math.floor((damage + 4.45) / 2.235);
		
		return shieldstun;
	}
	/**
	 This method calculates frame advantage on block for move type aerial using shieldstun, 
	 landing lag, and fall frames.
	 */
	public static int aerialBlock(int shieldstunDone, int landingLag, int fallFrames) {
		int frameAdvOnBlock = shieldstunDone - landingLag + fallFrames; //frame advantage on block of move
		
		return frameAdvOnBlock;
	}
	/**
	 This method calculates frame advantage on block for move type ground using move shieldstun, 
	 first active frame of a move, and total move frames.
	 */
	public static int groundBlock(int shieldstunDone, int firstActive, int totalFrames) {
		int deadFrames = totalFrames - firstActive; //The amount of frames where there is not a relevant active hitbox
		int frameAdvOnBlock = shieldstunDone - deadFrames; //frame advantage on block of move
		
		return frameAdvOnBlock;
	}
	/**
	 This method calculates frame advantage on block for move type projectile using move shieldstun, 
	 move hitlag, and move landing lag.
	 */
	public static int projectileBlock(int shieldstunDone, int hitlag, int landingLag) {
		int frameAdvOnBlock = shieldstunDone + hitlag - landingLag; //frame advantage on block of move
		 
		return frameAdvOnBlock;
	}
	
	/**
	 This method calculates hitstun by using knockback.
	 */
	public static int hitstunM(double knockback) {
		int hitstun = (int) (knockback * .4); //the amount of frames that the target is unactionable while in knockback
		
		return hitstun;
	}
	/**
	 This method calculates frame advantage on hit for move type aerial using move hitstun, 
	 move landing lag, and move falling frames.
	 */
	public static int aerialHit(int hitstun, int landingLag, int fallFrames) {
		int frameAdvOnHit = hitstun - landingLag + fallFrames; //frame advantage on hit of move 
		
		return frameAdvOnHit;
	}
	/**
	 This method calculates frame advantage on hit for move type ground using move hitstun, 
	 first active frame of a move, and total move frames.
	 */
	public static int groundHit(int hitstun, int firstActive, int totalFrames) {
		int deadFrames = totalFrames - firstActive; //The amount of frames where there is not a relevant active hitbox
		int frameAdvOnHit = hitstun - deadFrames; //frame advantage on hit of move 
		
		return frameAdvOnHit;
	}
	/**
	 This method calculates frame advantage on hit for move type projectile using move hitstun, 
	 move hitlag, and move landing lag.
	 */
	public static int projectileHit(int hitstun, int hitlag, int landingLag) {
		int frameAdvOnHit = hitstun + hitlag - landingLag; //frame advantage on hit of move 
		
		return frameAdvOnHit;
	}
	
	/**
	 This method calculatues hitlag using move damage. 
	 */
	public static int hitlagM(int damage) {
		int hitlag = 3 + (damage / 3); //the amount of frames characters are frozen after a move hits

		return hitlag;
	}
    
	/*
	 This method calculates frame advantage on amsah tech for move type aerial using landing lag,
	 and move fall frames.
	 */
	public static int aerialAt(int landingLag, int fallFrames) {
		int beforeTech = landingLag + fallFrames;
		
		return beforeTech;
	}
	/*
	 This method calculates frame advantage on amsah tech for move type ground using 
	 first active frame of a move, and total move frames.
	 */
	public static int groundAt(int firstActive, int totalFrames) {
		int beforeTech = totalFrames - firstActive;
		
		return beforeTech;
	}
	/*
	 This method calculates frame advantage on amsah tech for move type projectile using move hitlag,
	 and move landing lag.
	 */
	public static int projectileAt(int hitlag, int landingLag) {
		int beforeTech = hitlag - landingLag;
		
		return beforeTech;
	}
	
	public static void main(String[] args) {
        Application.launch(args);
	}
}
