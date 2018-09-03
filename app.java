import java.io.File;
import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class app extends Application {
	private Scene mainMenuScene, knockbackCalcScene, frameAdvantageOnBlockScene, frameAdvantageOnHitScene, staleMoveNegationScene,
	hitlagCalcScene, frameAdvantageOnAmsahTechScene, errorScene;
	private Stage theStage;
	private static DecimalFormat f = new DecimalFormat("##.00000");
	private final Font HEADER_FONT = Font.font("Verdana", FontWeight.BOLD, 16);
	private final Font RESULT_FONT = Font.font("Verdana", FontWeight.BOLD, 13);
	
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
		GridPane mainMenuPane = new GridPane();
		mainMenuPane.setHgap(10);
		mainMenuPane.setVgap(10);
		mainMenuPane.setPadding(new Insets(10, 10, 10, 10));
		
    	Label lblMainMenuB = new Label("Melee Calculator - Select a Button");
    	File smashInsigniaF = new File("C:/Users/Rodney/Downloads/smashinsignia.png");
        Image smashInsigniaI = new Image(smashInsigniaF.toURI().toString());
        ImageView smashInsigniaIv = new ImageView(smashInsigniaI); 
    	Label lblProgramVersion = new Label("Version: 1.20a");
        smashInsigniaIv.setFitHeight(80);
        smashInsigniaIv.setFitWidth(80);
		
    	Button btKnockbackCalc = new Button("Knockback/Hitstun Calculator");
    	Button btFrameAdvantageOnBlock = new Button("Frame Advantage on Block");
    	Button btFrameAdvantageOnHit = new Button("Frame Advantage on Hit");
    	Button btFrameAdvOnAmsahTech = new Button("Frame Advantage on AT");
    	Button btStaleMoveNegation = new Button("Stale Move Negation");
    	Button btHitlagCalc = new Button("Hitlag Calculator");
        
		GridPane.setHalignment(btKnockbackCalc, HPos.CENTER);
		GridPane.setHalignment(btFrameAdvantageOnBlock, HPos.CENTER);
		GridPane.setHalignment(btFrameAdvantageOnHit, HPos.CENTER);
		GridPane.setHalignment(btFrameAdvOnAmsahTech, HPos.CENTER);
		GridPane.setHalignment(btStaleMoveNegation, HPos.CENTER);
		GridPane.setHalignment(btHitlagCalc, HPos.CENTER);
		GridPane.setHalignment(lblProgramVersion, HPos.RIGHT);
		GridPane.setHalignment(smashInsigniaIv, HPos.CENTER);
		GridPane.setHalignment(lblMainMenuB, HPos.CENTER);

		mainMenuPane.add(lblMainMenuB, 0, 0);
		lblMainMenuB.setFont(Font.font("Verdana", FontWeight.BOLD, 18));

		mainMenuPane.add(btKnockbackCalc, 0, 1);
		btKnockbackCalc.setOnAction(e -> theStage.setScene(knockbackCalcScene));
		
		mainMenuPane.add(btFrameAdvantageOnBlock, 0, 2);
		btFrameAdvantageOnBlock.setOnAction(e -> theStage.setScene(frameAdvantageOnBlockScene));

		mainMenuPane.add(btFrameAdvantageOnHit, 0, 3);
		btFrameAdvantageOnHit.setOnAction(e -> theStage.setScene(frameAdvantageOnHitScene));

		mainMenuPane.add(btFrameAdvOnAmsahTech, 0, 6);
		btFrameAdvOnAmsahTech.setOnAction(e -> theStage.setScene(frameAdvantageOnAmsahTechScene));
		
		mainMenuPane.add(btStaleMoveNegation, 0, 4);
		btStaleMoveNegation.setOnAction(e -> theStage.setScene(staleMoveNegationScene));

		mainMenuPane.add(btHitlagCalc, 0, 5);
		btHitlagCalc.setOnAction(e -> theStage.setScene(hitlagCalcScene));


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
		lblKnockbackCalcB1.setFont(HEADER_FONT);
		lblKnockbackCalcB2.setFont(HEADER_FONT);
		TextField tfDamage = new TextField();
		TextField tfPercent = new TextField();
		TextField tfWeight = new TextField();
		TextField tfKnockbackScaling = new TextField();
		TextField tfBaseKnockback = new TextField();
		Label lblKnockback = new Label("Knockback:");
		lblKnockback.setFont(RESULT_FONT);
		Label lblKnockbackResult = new Label();
		lblKnockbackResult.setFont(RESULT_FONT);
		Label lblHitstun = new Label("Hitstun:");
		lblHitstun.setFont(RESULT_FONT);
		Label lblHitstunResult = new Label();
		lblHitstunResult.setFont(RESULT_FONT);
		CheckBox chbDidTheyCc = new CheckBox("Crouch Cancelled?");
		Button btCalculate = new Button("Calculate Knockback & Hitstun");
		Button btMainMenu = new Button("Main Menu");
	
		knockbackCalcPane.add(lblKnockbackCalcB1, 0, 0);
		knockbackCalcPane.add(lblKnockbackCalcB2, 0, 1);
		knockbackCalcPane.add(new Label("How much damage does the move do? "), 0, 2);
		knockbackCalcPane.add(tfDamage, 1, 2);
		knockbackCalcPane.add(new Label("How much percent does the target have?"), 0, 3);
		knockbackCalcPane.add(tfPercent, 1, 3);
		knockbackCalcPane.add(new Label("How much does the target weigh?"), 0, 4);
		knockbackCalcPane.add(tfWeight, 1, 4);
		knockbackCalcPane.add(new Label("What is the knockback scaling?"), 0, 5);
		knockbackCalcPane.add(tfKnockbackScaling, 1, 5);
		knockbackCalcPane.add(new Label("What is the base knockback?"), 0, 6);
		knockbackCalcPane.add(tfBaseKnockback, 1, 6);
		knockbackCalcPane.add(chbDidTheyCc, 1, 7);
		knockbackCalcPane.add(btCalculate, 0, 8);
		btCalculate.setOnAction(e -> {
			double damage;
			double percent;
			double weight;
			double knockbackScaling;
			double baseKnockback;
			try {
				damage = Double.parseDouble(tfDamage.getText()); //damage of a move, how much percent a move does
				percent = Double.parseDouble(tfPercent.getText()); //how much total damage or percent has the target taken
				weight = Double.parseDouble(tfWeight.getText()); //how heavy a target is
				knockbackScaling = Double.parseDouble(tfKnockbackScaling.getText()); //how the knockback scales with percent for a move
				baseKnockback = Double.parseDouble(tfBaseKnockback.getText()); //where the knockback starts for a move
			} catch (NumberFormatException nfe) {
				UIUtils.numberFormatAlert();
		    	return;
			}
			double knockback = 0; //knockback of move
						
			if (chbDidTheyCc.isSelected()) {
				knockback = FormulaUtils.cc(damage, percent, weight, knockbackScaling, baseKnockback);
			} else {
				knockback = FormulaUtils.asdid(damage, percent, weight, knockbackScaling, baseKnockback);
			}	
			
			int hitstun = (int) FormulaUtils.hitstun(knockback);
			lblKnockbackResult.setText(String.valueOf(f.format(knockback)));
			lblHitstunResult.setText(String.valueOf(hitstun));
		});
		
		knockbackCalcPane.add(new Label("__________________________________________________________________________"), 0, 9, 2, 1);
		knockbackCalcPane.add(lblKnockback, 0, 10);
		knockbackCalcPane.add(lblKnockbackResult, 1, 10);
		knockbackCalcPane.add(lblHitstun, 0, 11);
		knockbackCalcPane.add(lblHitstunResult, 1, 11);
		knockbackCalcPane.add(new Label(""), 0, 12);
		knockbackCalcPane.add(btMainMenu, 0, 13);
		btMainMenu.setOnAction(e -> {
			theStage.setScene(mainMenuScene);
			tfDamage.setText("");
			tfPercent.setText("");
			tfWeight.setText("");
			tfKnockbackScaling.setText("");
			tfBaseKnockback.setText("");
			lblKnockbackResult.setText("");
			lblHitstunResult.setText("");
		});
		
		knockbackCalcScene = new Scene(knockbackCalcPane, 394, 385);
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
		
		Label lblFrameAdvOnBlockHeader = new Label("Frame Advantage on Block");
		lblFrameAdvOnBlockHeader.setFont(HEADER_FONT);
		ToggleGroup moveTypeGroup = new ToggleGroup();
		RadioButton rbAerial = new RadioButton("Aerial");
		RadioButton rbGround = new RadioButton("Ground ");
		RadioButton rbProjectile = new RadioButton("Projectile ");
		TextField tfDamage = new TextField();
		TextField tfLandingLagAerial = new TextField();
		TextField tfFallFramesAerial = new TextField();
		TextField tfLandingLagProjectile = new TextField();
		TextField tfFirstActive = new TextField();
		TextField tfTotalFrames = new TextField();
		Label lblLandingLagAerial = new Label("How much landing lag does the move have?");
		Label lblFallFrames1Aerial = new Label("How many frames is the character falling for");
		Label lblFallFrames2Aerial = new Label("after the move hits?");
		Label lblFirstActive = new Label("What is the 1st active frame?");
		Label lblTotalFrames1Ground = new Label("How many frames does the move have in");
		Label lblTotalFrames2Ground = new Label("total?");
		Label lblLandingLag1Projectile = new Label("How much landing lag/dead frames does");
		Label lblLandingLag2Projectile = new Label("the move have?");
		Button btCalculate = new Button("Calculate Frame Advantage on Block");
		Label lblFrameAdvOnBlock = new Label("Frame Advantage on Block:");
		lblFrameAdvOnBlock.setFont(RESULT_FONT);
		Label lblResult = new Label();
		lblResult.setFont(RESULT_FONT);
		Button btMainMenu = new Button("Main Menu");
		
		frameAdvOnBlockPane.add(lblFrameAdvOnBlockHeader, 0, 0);
		frameAdvOnBlockPane.add(new Label("What type of move was used? Aerial, Ground,"), 0, 1);
		frameAdvOnBlockPane.add(new Label("or Projectile?"), 0, 2);
		rbAerial.setToggleGroup(moveTypeGroup);
		rbGround.setToggleGroup(moveTypeGroup);
		rbProjectile.setToggleGroup(moveTypeGroup);
		frameAdvOnBlockPane.add(rbAerial, 1, 1);
		frameAdvOnBlockPane.add(rbGround, 1, 2);
		frameAdvOnBlockPane.add(rbProjectile, 1, 3);
		frameAdvOnBlockPane.add(new Label("How much damage does the move do?"), 0, 5);
		frameAdvOnBlockPane.add(tfDamage, 1, 5);

		moveTypeGroup.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
			//remove nodes
			frameAdvOnBlockPane.getChildren().remove(lblLandingLagAerial);
			frameAdvOnBlockPane.getChildren().remove(tfLandingLagAerial);
			frameAdvOnBlockPane.getChildren().remove(lblFallFrames1Aerial);
			frameAdvOnBlockPane.getChildren().remove(lblFallFrames2Aerial);
			frameAdvOnBlockPane.getChildren().remove(tfFallFramesAerial);
			frameAdvOnBlockPane.getChildren().remove(lblFirstActive);
			frameAdvOnBlockPane.getChildren().remove(tfFirstActive);
			frameAdvOnBlockPane.getChildren().remove(lblTotalFrames1Ground);
			frameAdvOnBlockPane.getChildren().remove(lblTotalFrames2Ground);
			frameAdvOnBlockPane.getChildren().remove(tfTotalFrames);
			frameAdvOnBlockPane.getChildren().remove(lblLandingLag1Projectile);
			frameAdvOnBlockPane.getChildren().remove(lblLandingLag2Projectile);
			frameAdvOnBlockPane.getChildren().remove(tfLandingLagProjectile);
			//remove nodes
			
			if(rbAerial.isSelected()){    
			   	frameAdvOnBlockPane.add(lblLandingLagAerial, 0, 6);       
			   	frameAdvOnBlockPane.add(tfLandingLagAerial, 1, 6);   
				frameAdvOnBlockPane.add(lblFallFrames1Aerial, 0, 7);       
				frameAdvOnBlockPane.add(lblFallFrames2Aerial, 0, 8);       
				frameAdvOnBlockPane.add(tfFallFramesAerial, 1, 8);
				tfFallFramesAerial.setText(String.valueOf(0));			
		   	} else if(rbGround.isSelected()) {
		   		frameAdvOnBlockPane.add(lblFirstActive, 0, 6);   
		   		frameAdvOnBlockPane.add(tfFirstActive, 1, 6);   
		   		frameAdvOnBlockPane.add(lblTotalFrames1Ground, 0, 7);   
		   		frameAdvOnBlockPane.add(lblTotalFrames2Ground, 0, 8);   
			   	frameAdvOnBlockPane.add(tfTotalFrames, 1, 8);   
		    } else if(rbProjectile.isSelected()) {
		   		frameAdvOnBlockPane.add(lblLandingLag1Projectile, 0, 6);       
	    		frameAdvOnBlockPane.add(lblLandingLag2Projectile, 0, 7);       
	    		frameAdvOnBlockPane.add(tfLandingLagProjectile, 1, 7);   
		   	} else {
		   		theStage.setScene(errorScene);
		   	}
			
			frameAdvOnBlockPane.add(btCalculate, 0, 9);
			btCalculate.setOnAction(e -> {
				int damage;
				int shieldstun;
				try {
					damage = Integer.parseInt(tfDamage.getText()); //damage of move, how much percent the move does
					shieldstun = FormulaUtils.shieldstun((int) damage); //the amount of frames the target is stuck in shield and unactionable					weight = Double.parseDouble(tfWeight.getText()); //how heavy a target is
				} catch (NumberFormatException nfe) {
					UIUtils.numberFormatAlert();
			    	return;
				}
		    	int frameAdvOnBlock = 0; //frame advantage on block of move

				if (rbAerial.isSelected()) {
					int landingLag;
					int fallFrames;
					try {
				    	landingLag = Integer.parseInt(tfLandingLagAerial.getText()); //amount of frames that the user of a move is unactionable when landing
						fallFrames = Integer.parseInt(tfFallFramesAerial.getText()); //the amount of falling frames after the move has hit	
					} catch (NumberFormatException nfe) {
							UIUtils.numberFormatAlert();
					    	return;
					}
					
					frameAdvOnBlock = FormulaUtils.frameAdvOnBlockForAerial(shieldstun, landingLag, fallFrames);
				} else if (rbGround.isSelected()) {
					int firstActive;
					int totalFrames;
					try {
						firstActive = Integer.parseInt(tfFirstActive.getText()); //first active frame of move
						totalFrames = Integer.parseInt(tfTotalFrames.getText()); //the total amount of frames the move has						
					} catch (NumberFormatException nfe) {
						UIUtils.numberFormatAlert();
				    	return;
					}

					frameAdvOnBlock = FormulaUtils.frameAdvOnBlockForGround(shieldstun, firstActive, totalFrames);
				} else if (rbProjectile.isSelected()) {
					int landingLag;
					int hitlag;
					
					try {
				    	landingLag = Integer.parseInt(tfLandingLagProjectile.getText()); //amount of frames that the user of a move is unactionable when landing
						hitlag = FormulaUtils.hitlag((int) damage); //the amount of frames characters are frozen after a move hits						
					} catch (NumberFormatException nfe) {
						UIUtils.numberFormatAlert();
				    	return;
					}

					frameAdvOnBlock = FormulaUtils.frameAdvOnBlockForProjectile(shieldstun, hitlag, landingLag);
				} else {
					System.out.println("Error");
				}
				
				if (frameAdvOnBlock > -1) {
					lblResult.setText(String.valueOf("+" + frameAdvOnBlock));
				} else {
					lblResult.setText(String.valueOf(frameAdvOnBlock));
				}
			});
			
			frameAdvOnBlockPane.add(new Label("_______________________________________________________________________________"), 0, 10, 2, 1);
			frameAdvOnBlockPane.add(lblFrameAdvOnBlock, 0, 11);
			frameAdvOnBlockPane.add(lblResult, 1, 11);
		});
		
		frameAdvOnBlockPane.add(new Label(""), 0, 12);
		frameAdvOnBlockPane.add(btMainMenu, 0, 13);
		btMainMenu.setOnAction(e -> theStage.setScene(mainMenuScene));
		
		frameAdvantageOnBlockScene = new Scene(frameAdvOnBlockPane, 415, 345);
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
		
		Label lblFrameAdvOnHitHeader = new Label("Frame Advantage on Hit");
		lblFrameAdvOnHitHeader.setFont(HEADER_FONT);
		ToggleGroup moveTypeGroup = new ToggleGroup();
		RadioButton rbAerial = new RadioButton("Aerial");
		RadioButton rbGround = new RadioButton("Ground");
		RadioButton rbProjectile = new RadioButton("Projectile");
		TextField tfHitstun = new TextField();
		TextField tfLandingLagAerial= new TextField();
		TextField tfFallFramesAerial = new TextField();
		TextField tfLandingLagProjectile = new TextField();
		TextField tfFirstActiveGround = new TextField();
		TextField tfTotalFramesGround = new TextField();
		TextField tfDamageProjectile = new TextField();
		Label lblLandingLagAerial = new Label("How much landing lag does the move have?");
		Label lblFallFrames1Aerial= new Label("How many frames is the character falling for");
		Label lblFallFrames2Aerial = new Label("after the move hits?");
		Label lblFirstActiveGround = new Label("What is the 1st active frame?");
		Label lblTotalFrames1Ground = new Label("How many frames does the move have in");
		Label lblTotalFrames2Ground = new Label("total?");
		Label lblDamageProjectile = new Label("How much damage does the move do?");
		Label lblLandingLag1Projectile = new Label("How much landing lag/dead frames does");
		Label lblLandingLag2Projectile = new Label("the move have?");
		Button btHitstunCalc = new Button("Hitstun Calculator");
		Button btCalculate = new Button("Calculate Frame Advantage on Hit");
		Label lblFrameAdvOnHit = new Label("Frame Advantage on Hit:");
		lblFrameAdvOnHit.setFont(RESULT_FONT);
		Label lblResult = new Label();
		lblResult.setFont(RESULT_FONT);
		Button btHitlagCalc = new Button("Hitlag Calc");
		Button btMainMenu = new Button("Main Menu");
		
		frameAdvOnHitPane.add(lblFrameAdvOnHitHeader, 0, 0);
		frameAdvOnHitPane.add(new Label("What type of move was used? Aerial, Ground,"), 0, 1);
		frameAdvOnHitPane.add(new Label("or Projectile?"), 0, 2);
		rbAerial.setToggleGroup(moveTypeGroup);
		rbGround.setToggleGroup(moveTypeGroup);
		rbProjectile.setToggleGroup(moveTypeGroup);
		frameAdvOnHitPane.add(rbAerial, 1, 1);
		frameAdvOnHitPane.add(rbGround, 1, 2);
		frameAdvOnHitPane.add(rbProjectile, 1, 3);
		frameAdvOnHitPane.add(new Label("How much hitstun does the move do?"), 0, 6);
		frameAdvOnHitPane.add(tfHitstun, 1, 6);
		frameAdvOnHitPane.add(new Label("If you don't know the hitstun,"), 0, 7);
		frameAdvOnHitPane.add(new Label("use the following button"), 0, 8);
		frameAdvOnHitPane.add(btHitstunCalc, 1, 8);
		btHitlagCalc.setOnAction(e -> theStage.setScene(hitlagCalcScene));

		moveTypeGroup.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
			//remove nodes
			frameAdvOnHitPane.getChildren().remove(lblLandingLagAerial);
			frameAdvOnHitPane.getChildren().remove(tfLandingLagAerial);
			frameAdvOnHitPane.getChildren().remove(lblFallFrames1Aerial);
			frameAdvOnHitPane.getChildren().remove(lblFallFrames2Aerial);
			frameAdvOnHitPane.getChildren().remove(tfFallFramesAerial);
			frameAdvOnHitPane.getChildren().remove(lblFirstActiveGround);
			frameAdvOnHitPane.getChildren().remove(tfFirstActiveGround);
			frameAdvOnHitPane.getChildren().remove(lblTotalFrames1Ground);
			frameAdvOnHitPane.getChildren().remove(lblTotalFrames2Ground);
			frameAdvOnHitPane.getChildren().remove(tfTotalFramesGround);
			frameAdvOnHitPane.getChildren().remove(lblDamageProjectile);
			frameAdvOnHitPane.getChildren().remove(tfDamageProjectile);
			frameAdvOnHitPane.getChildren().remove(lblLandingLag1Projectile);
			frameAdvOnHitPane.getChildren().remove(lblLandingLag2Projectile);
			frameAdvOnHitPane.getChildren().remove(tfLandingLagProjectile);
			//remove nodes
			
			if(rbAerial.isSelected()){    
				frameAdvOnHitPane.add(lblLandingLagAerial, 0, 9);   
				frameAdvOnHitPane.add(tfLandingLagAerial, 1, 9);
				frameAdvOnHitPane.add(lblFallFrames1Aerial, 0, 10);
				frameAdvOnHitPane.add(lblFallFrames2Aerial, 0, 11);       
				frameAdvOnHitPane.add(tfFallFramesAerial, 1, 11);     
				tfFallFramesAerial.setText(String.valueOf(0));			
			} else if(rbGround.isSelected()) {
	    		frameAdvOnHitPane.add(lblFirstActiveGround, 0, 9);   
	    		frameAdvOnHitPane.add(tfFirstActiveGround, 1, 9);   
	    		frameAdvOnHitPane.add(lblTotalFrames1Ground, 0, 10);   
	    		frameAdvOnHitPane.add(lblTotalFrames2Ground, 0, 11);   
	    		frameAdvOnHitPane.add(tfTotalFramesGround, 1, 11);   
	    	} else if(rbProjectile.isSelected()) {
	    		frameAdvOnHitPane.add(lblDamageProjectile, 0, 9);
	    		frameAdvOnHitPane.add(tfDamageProjectile, 1, 9);
	    		frameAdvOnHitPane.add(lblLandingLag1Projectile, 0, 10);  
	    		frameAdvOnHitPane.add(lblLandingLag2Projectile, 0, 11);       
	    		frameAdvOnHitPane.add(tfLandingLagProjectile, 1, 11);   
	    	} else {
	    		System.out.println("Error");
	    	}
			
	    	frameAdvOnHitPane.add(btCalculate, 0, 13);
			btCalculate.setOnAction(e -> {
				int hitstun;
				try {
			    	hitstun = Integer.parseInt(tfHitstun.getText()); //the amount of frames that the target is unactionable while in knockback					
				} catch (NumberFormatException nfe) {
					UIUtils.numberFormatAlert();
			    	return;
				}
				int frameAdvOnHit = 0; //frame advantage on hit of move 
				
				if (rbAerial.isSelected()) {
					int landingLag;
					int fallFrames;
					try {
						landingLag = Integer.parseInt(tfLandingLagAerial.getText()); //amount of frames that the user of a move is unactionable when landing
						fallFrames = Integer.parseInt(tfFallFramesAerial.getText()); //the amount of falling frames after the move has hit	
					} catch (NumberFormatException nfe) {
						UIUtils.numberFormatAlert();
						return;
					}
					
					frameAdvOnHit = FormulaUtils.frameAdvOnHitForAerial(hitstun, landingLag, fallFrames);
				} else if (rbGround.isSelected()) {
					int firstActive;
					int totalFrames;
					try {
						firstActive = Integer.parseInt(tfFirstActiveGround.getText()); //first active frame of move
						totalFrames = Integer.parseInt(tfTotalFramesGround.getText()); //the total amount of frames the move has						
					} catch (NumberFormatException nfe) {
						UIUtils.numberFormatAlert();
						return;
					}

					frameAdvOnHit = FormulaUtils.frameAdvOnHitForGround(hitstun, firstActive, totalFrames);
				} else if (rbProjectile.isSelected()) {
					double damage;
					int landingLag;
					try {
				    	damage = Double.parseDouble(tfDamageProjectile.getText()); //damage of move, how much percent the move does
						landingLag = Integer.parseInt(tfLandingLagProjectile.getText()); //amount of frames that the user of a move is unactionable when landing
					} catch (NumberFormatException nfe) {
						UIUtils.numberFormatAlert();
						return;
					}
					
					int hitlag = FormulaUtils.hitlag((int) damage); //the amount of frames characters are frozen after a move hits						
					frameAdvOnHit = FormulaUtils.frameAdvOnHitForProjectile(hitstun, hitlag, landingLag);
				} else {
					System.out.println("Error");
				}
					
				if (frameAdvOnHit > -1) {
					lblResult.setText(String.valueOf("+" + frameAdvOnHit));
				} else {
					lblResult.setText(String.valueOf(frameAdvOnHit));
				}
			});
	    	
			frameAdvOnHitPane.add(new Label("_______________________________________________________________________________"), 0, 14, 2, 1);
			frameAdvOnHitPane.add(lblFrameAdvOnHit, 0, 15);
			frameAdvOnHitPane.add(lblResult, 1, 15);
			frameAdvOnHitPane.add(new Label(""), 0, 16);
		});
		
		frameAdvOnHitPane.add(btMainMenu, 0, 17);
		btMainMenu.setOnAction(e -> theStage.setScene(mainMenuScene));
		
		frameAdvantageOnHitScene = new Scene(frameAdvOnHitPane, 415, 415);
		frameAdvantageOnHitScene.getStylesheets().add("stylesheet.css");
    }
    
    /**
    Setting up the Frame Advantage on Amsah Tech scene
    */
    public void frameAdvOnAtSetup() {
    	GridPane frameAdvOnAmsahTechPane = new GridPane();
    	frameAdvOnAmsahTechPane.setHgap(5);
    	frameAdvOnAmsahTechPane.setVgap(5);
    	frameAdvOnAmsahTechPane.setPadding(new Insets(10, 10, 10, 10));
		
		Label lblFrameAdvOnAmsahTechHeader = new Label("Frame Advantage on AT");
		lblFrameAdvOnAmsahTechHeader.setFont(HEADER_FONT);
    	ToggleGroup moveTypeGroup = new ToggleGroup();
		RadioButton rbAerial = new RadioButton("Aerial");
		RadioButton rbGround = new RadioButton("Ground ");
		RadioButton rbProjectile = new RadioButton("Projectile ");
		ComboBox<String> cbTechType = new ComboBox<String>();
		cbTechType.getItems().addAll("Tech in Place", "Tech Roll");
		cbTechType.setValue("Tech in Place");
		Label lblLandingLagAerial = new Label("How much landing lag does the move have?");
		TextField tfLandingLagAerial= new TextField();
		Label lblFallFrames1Aerial= new Label("How many frames is the character falling for");
		Label lblFallFrames2Aerial = new Label("after the move hits?");
		TextField tfFallFramesAerial = new TextField();
		Label lblFirstActiveGround = new Label("What is the 1st active frame?");
		TextField tfFirstActiveGround = new TextField();
		Label lblTotalFrames1Ground = new Label("How many frames does the move have in");
		Label lblTotalFrames2Ground = new Label("total?");
		TextField tfTotalFramesGround = new TextField();
		Label lblDamageProjectile = new Label("How much damage does the move do?");
		TextField tfDamageProjectile = new TextField();
		Label lblLandingLag1Projectile = new Label("How much landing lag/dead frames does");
		Label lblLandingLag2Projectile = new Label("the move have?");
		TextField tfLandingLagProjectile = new TextField();
		Button btCalculate = new Button("Calculate Frame Adv. on Amsah Tech");
		Label lblFrameAdvOnAmsahTech = new Label("Frame Adv. on Amsah Tech:");
		lblFrameAdvOnAmsahTech.setFont(RESULT_FONT);
		Label lblResult = new Label();
		lblResult.setFont(RESULT_FONT);
		Button btMainMenu = new Button("Main Menu");

		frameAdvOnAmsahTechPane.add(lblFrameAdvOnAmsahTechHeader, 0, 0);
		frameAdvOnAmsahTechPane.add(new Label("What type of move was used? Aerial, Ground,"), 0, 1);
		frameAdvOnAmsahTechPane.add(new Label("or Projectile?"), 0, 2);
		rbAerial.setToggleGroup(moveTypeGroup);
		rbGround.setToggleGroup(moveTypeGroup);
		rbProjectile.setToggleGroup(moveTypeGroup);
		frameAdvOnAmsahTechPane.add(rbAerial, 1, 1);
		frameAdvOnAmsahTechPane.add(rbGround, 1, 2);
		frameAdvOnAmsahTechPane.add(rbProjectile, 1, 3);
		frameAdvOnAmsahTechPane.add(new Label("What type of tech was used?"), 0, 5);
		frameAdvOnAmsahTechPane.add(cbTechType, 1, 5);

		moveTypeGroup.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
			//remove nodes
	    	frameAdvOnAmsahTechPane.getChildren().remove(lblLandingLagAerial);
	    	frameAdvOnAmsahTechPane.getChildren().remove(tfLandingLagAerial);
	    	frameAdvOnAmsahTechPane.getChildren().remove(lblFallFrames1Aerial);
	    	frameAdvOnAmsahTechPane.getChildren().remove(lblFallFrames2Aerial);
			frameAdvOnAmsahTechPane.getChildren().remove(tfFallFramesAerial);
			frameAdvOnAmsahTechPane.getChildren().remove(lblFirstActiveGround);
			frameAdvOnAmsahTechPane.getChildren().remove(tfFirstActiveGround);
			frameAdvOnAmsahTechPane.getChildren().remove(lblTotalFrames1Ground);
			frameAdvOnAmsahTechPane.getChildren().remove(lblTotalFrames2Ground);
			frameAdvOnAmsahTechPane.getChildren().remove(tfTotalFramesGround);
			frameAdvOnAmsahTechPane.getChildren().remove(lblDamageProjectile);
			frameAdvOnAmsahTechPane.getChildren().remove(tfDamageProjectile);
			frameAdvOnAmsahTechPane.getChildren().remove(lblLandingLag1Projectile);
			frameAdvOnAmsahTechPane.getChildren().remove(lblLandingLag2Projectile);
			frameAdvOnAmsahTechPane.getChildren().remove(tfLandingLagProjectile);
			//remove nodes

			if (rbAerial.isSelected()){
				frameAdvOnAmsahTechPane.add(lblLandingLagAerial, 0, 6);   
				frameAdvOnAmsahTechPane.add(tfLandingLagAerial, 1, 6);
				frameAdvOnAmsahTechPane.add(lblFallFrames1Aerial, 0, 7);
				frameAdvOnAmsahTechPane.add(lblFallFrames2Aerial, 0, 8);       
				frameAdvOnAmsahTechPane.add(tfFallFramesAerial, 1, 8);     
				tfFallFramesAerial.setText(String.valueOf(0));			
			} else if(rbGround.isSelected()) {
	    		frameAdvOnAmsahTechPane.add(lblFirstActiveGround, 0, 6);   
	    		frameAdvOnAmsahTechPane.add(tfFirstActiveGround, 1, 6);   
	    		frameAdvOnAmsahTechPane.add(lblTotalFrames1Ground, 0, 7);   
	    		frameAdvOnAmsahTechPane.add(lblTotalFrames2Ground, 0, 8);   
	    		frameAdvOnAmsahTechPane.add(tfTotalFramesGround, 1, 8);   
	    	} else if(rbProjectile.isSelected()) {
	    		frameAdvOnAmsahTechPane.add(lblLandingLag1Projectile, 0, 6);  
	    		frameAdvOnAmsahTechPane.add(lblLandingLag2Projectile, 0, 7);       
	    		frameAdvOnAmsahTechPane.add(tfLandingLagProjectile, 1, 7);   
	    		frameAdvOnAmsahTechPane.add(lblDamageProjectile, 0, 8);   
	    		frameAdvOnAmsahTechPane.add(tfDamageProjectile, 1, 8);   
	    	} else {
	    		theStage.setScene(errorScene);
	    	}
			
			frameAdvOnAmsahTechPane.add(btCalculate, 0, 10);
			btCalculate.setOnAction(e -> {
		    	int beforeTech = 0; //the amount of recovery a move has before the tech takes place
		    	int frameAdvOnAmsahTech = 0; //frame advantage on at of move
		    	String techTypeSelection = cbTechType.getValue();
		    		
				if (rbAerial.isSelected()) {
					int landingLag;
					int fallFrames;
					try {
						landingLag = Integer.parseInt(tfLandingLagAerial.getText()); //amount of frames that the user of a move is unactionable when landing
						fallFrames = Integer.parseInt(tfFallFramesAerial.getText()); //the amount of falling frames after the move has hit						
					} catch (NumberFormatException nfe) {
						UIUtils.numberFormatAlert();
						return;
					}

					beforeTech = FormulaUtils.beforeTechForAerial(landingLag, fallFrames);
					frameAdvOnAmsahTech = FormulaUtils.frameAdvOnAmsahTech(techTypeSelection, beforeTech);
				} else if (rbGround.isSelected()) {
					int firstActive;
					int totalFrames;
					try {
						firstActive = Integer.parseInt(tfFirstActiveGround.getText()); //first active frame of move
						totalFrames = Integer.parseInt(tfTotalFramesGround.getText()); //the total amount of frames the move has	
					} catch (NumberFormatException nfe) {
						UIUtils.numberFormatAlert();
						return;
					}
					
					beforeTech = FormulaUtils.beforeTechForGround(firstActive, totalFrames);
					frameAdvOnAmsahTech = FormulaUtils.frameAdvOnAmsahTech(techTypeSelection, beforeTech);
				} else if (rbProjectile.isSelected()) {
					int landingLag;
					double damage;
					try {
						landingLag = Integer.parseInt(tfLandingLagProjectile.getText()); //amount of frames that the user of a move is unactionable when landing
						damage = Integer.parseInt(tfDamageProjectile.getText()); //damage of move, how much percent the move does						
					} catch (NumberFormatException nfe) {
						UIUtils.numberFormatAlert();
						return;
					}
					
					int hitlag = FormulaUtils.hitlag((int) damage);
					beforeTech = FormulaUtils.beforeTechForProjectile(hitlag, landingLag);
					frameAdvOnAmsahTech = FormulaUtils.frameAdvOnAmsahTech(techTypeSelection, beforeTech);
				} else {
					System.out.println("Error");
				}
					
				if (frameAdvOnAmsahTech > -1) {
					lblResult.setText(String.valueOf("+" + frameAdvOnAmsahTech));
				} else {
					lblResult.setText(String.valueOf(frameAdvOnAmsahTech));
				}
			});
			
			frameAdvOnAmsahTechPane.add(new Label("_______________________________________________________________________________"), 0, 11, 2, 1);
			frameAdvOnAmsahTechPane.add(lblFrameAdvOnAmsahTech, 0, 12);
			frameAdvOnAmsahTechPane.add(lblResult, 1, 12);
		});
	
		frameAdvOnAmsahTechPane.add(new Label(""), 0, 13);
		frameAdvOnAmsahTechPane.add(btMainMenu, 0, 14);
		btMainMenu.setOnAction(e -> theStage.setScene(mainMenuScene));
		
		frameAdvantageOnAmsahTechScene = new Scene(frameAdvOnAmsahTechPane, 415, 355);
		frameAdvantageOnAmsahTechScene.getStylesheets().add("stylesheet.css");
    }
    
    /**
    Setting up the Stale Move Negation scene
    */
    public void staleMoveNegationSetup() {
    	GridPane staleMoveNegationPane = new GridPane();
		staleMoveNegationPane.setHgap(5);
		staleMoveNegationPane.setVgap(5);
		staleMoveNegationPane.setPadding(new Insets(10, 10, 10, 10));
		
		TextField tfDamageStaleMoveNegation = new TextField();
		RadioButton rbStale1 = new RadioButton("1");
		RadioButton rbStale2 = new RadioButton("2");
		RadioButton rbStale3 = new RadioButton("3");
		RadioButton rbStale4 = new RadioButton("4");
		RadioButton rbStale5 = new RadioButton("5");
		RadioButton rbStale6 = new RadioButton("6");
		RadioButton rbStale7 = new RadioButton("7");
		RadioButton rbStale8 = new RadioButton("8");
		RadioButton rbStale9 = new RadioButton("9");
		Label lblStaleMovePointsTotal = new Label("Stale Move Points Total:");
		lblStaleMovePointsTotal.setFont(RESULT_FONT);
		Label lblStaleMovePointsTotalResult = new Label();
		lblStaleMovePointsTotalResult.setFont(RESULT_FONT);
		Label lblStaleMovePercentEffected = new Label("Move's Decreased Damage:");
		lblStaleMovePercentEffected.setFont(RESULT_FONT);
		Label lblStaleMovePercentEffectedResult = new Label();
		lblStaleMovePercentEffectedResult.setFont(RESULT_FONT);
		Label lblStaleMove = new Label("The move will now do:");
		lblStaleMove.setFont(RESULT_FONT);
		Label lblStaleMoveResult = new Label();
		lblStaleMoveResult.setFont(RESULT_FONT);
		Button btCalcStaleMovePoints = new Button("Calculate Stale Move Points");
		Button btMainMenu = new Button("Main Menu");

		Label lblStaleMoveNegation = new Label("Stale Move Negation");
		lblStaleMoveNegation.setFont(HEADER_FONT);
		staleMoveNegationPane.add(lblStaleMoveNegation, 0, 0);

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
		btCalcStaleMovePoints.setOnAction(e -> {
			double damage;
			try {
		    	damage = Double.parseDouble(tfDamageStaleMoveNegation.getText()); //damage of move, how much percent the move does				
			} catch (NumberFormatException nfe) {
				UIUtils.numberFormatAlert();
				return;
			}
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
	    	lblStaleMovePointsTotalResult.setText(String.valueOf(staleMoveF.format(staleMovePoints)));
	    	percentEffected = Math.abs(staleMovePoints - 1); 
	    	lblStaleMovePercentEffectedResult.setText(String.valueOf(staleMoveF.format(staleMovePoints * 100)) + "%");
			staleDamage = percentEffected * damage;
			lblStaleMoveResult.setText(String.valueOf(staleMoveF.format(staleDamage)) + "%");
		});
		
		staleMoveNegationPane.add(new Label("__________________________________________________________________________"), 0, 14, 2, 1);
		staleMoveNegationPane.add(lblStaleMovePointsTotal, 0, 15);
		staleMoveNegationPane.add(lblStaleMovePointsTotalResult, 1, 15);
		staleMoveNegationPane.add(lblStaleMovePercentEffected, 0, 16);
		staleMoveNegationPane.add(lblStaleMovePercentEffectedResult, 1, 16);
		staleMoveNegationPane.add(lblStaleMove, 0, 17);
		staleMoveNegationPane.add(lblStaleMoveResult, 1, 17);
		staleMoveNegationPane.add(new Label(""), 0, 18);
		staleMoveNegationPane.add(btMainMenu, 0, 19);
		btMainMenu.setOnAction(e -> theStage.setScene(mainMenuScene));
		
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

		Label lblHitlagCalcHeader = new Label("Hitlag Calculator");
		lblHitlagCalcHeader.setFont(HEADER_FONT);
		TextField tfDamage = new TextField();
		CheckBox chbElectricMove = new CheckBox("Electric Move?");
		Button btCalculate = new Button("Calculate Hitlag");
		Label lblHitlag = new Label("Hitlag:");
		lblHitlag.setFont(RESULT_FONT);
		Label lblResult = new Label();
		lblResult.setFont(RESULT_FONT);
		Button btMainMenu = new Button("Main Menu");

		hitlagCalcPane.add(lblHitlagCalcHeader, 0, 0);
		hitlagCalcPane.add(new Label("How much damage does the move do?"), 0, 1);
		hitlagCalcPane.add(tfDamage, 1, 1);
		hitlagCalcPane.add(chbElectricMove, 1, 2);
		hitlagCalcPane.add(btCalculate, 0, 3);
		btCalculate.setOnAction(e -> {
			double damage;
			try {
		    	damage = Double.parseDouble(tfDamage.getText()); //damage of move, how much percent the move does
			} catch (NumberFormatException nfe) {
				UIUtils.numberFormatAlert();
				return;
			}
			final double ELECTRIC_HITLAG_MULTIPLIER = 1.5;
			int hitlag = FormulaUtils.hitlag((int) damage); //the amount of frames characters are frozen after a move hits

			if (chbElectricMove.isSelected()) {
				hitlag *= ELECTRIC_HITLAG_MULTIPLIER;
			}
			
			lblResult.setText(String.valueOf(hitlag));
		});
		
		hitlagCalcPane.add(new Label("________________________________________________________________________"), 0, 4, 2, 1);
		hitlagCalcPane.add(lblHitlag, 0, 5);
		hitlagCalcPane.add(lblResult, 1, 5);
		hitlagCalcPane.add(new Label(""), 0, 6);
		hitlagCalcPane.add(btMainMenu, 0, 7);
		btMainMenu.setOnAction(e -> theStage.setScene(mainMenuScene));
		
		hitlagCalcScene = new Scene(hitlagCalcPane, 383, 215);
		hitlagCalcScene.getStylesheets().add("stylesheet.css");
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
		lblError.setFont(HEADER_FONT);
		errorPane.add(lblError, 0, 0);
		
		errorScene = new Scene(errorPane, 1000, 500);
    }
	
	public static void main(String[] args) {
        Application.launch(args);
	}
}
