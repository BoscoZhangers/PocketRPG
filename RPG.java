import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.Random;

public class RPG{
	public static void main (String [] args){
		Console con = new Console();
		
		BufferedImage imgIntroGUI;
		imgIntroGUI = con.loadImage("Images_Pokemon_RPG/IntroGUI.png");
		con.drawImage(imgIntroGUI,0,0);
		con.repaint();
		con.setTextColor(Color.BLACK);
		con.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		con.print("                              ");
		
		// Declaring User Identification 
		
		BufferedImage imgIntro;
		String strUser=("");
		strUser=con.readLine();
		
		// Opening Current Data Files For Hardware Memory via TextFile IO
		TextInputFile txtDataIN = new TextInputFile("Data/Data.txt");
		String strUserRead=("");
		
		while (txtDataIN.eof()==false){
			strUserRead=txtDataIN.readLine();
			if (strUserRead.equalsIgnoreCase(strUser)){
				break;
			}
		}
			
		// Declaring User Info Based on Saved Data
		
		con.sleep(1500);
		con.clear();
		con.closeWindow();
	
		String strPokemon=("");
		double dblLevel = 0.0;
		int intHP = 0;
		int intHPMax = 0;
		int intAttackPower = 0;
		
		// User-Dictated Continuity Control: ensures that the program proceeds at user's discretion.
		// The program won't run until any new inputted value is assigned to chrContinue.
		// Note: This variable will be reused throughout the code for the same functionality.
		char chrContinue;
		

		if (strUser.equalsIgnoreCase(strUserRead)){
			strUser=strUserRead;
			strPokemon=txtDataIN.readLine();
			dblLevel=txtDataIN.readDouble();
			intHP=txtDataIN.readInt();
			intHPMax=txtDataIN.readInt();
			intAttackPower=txtDataIN.readInt();
			
			txtDataIN.close();
			
			
		} else {
			Console con2 = new Console();
			con2.setTextColor(Color.BLACK);
			BufferedImage imgGUI1;
			BufferedImage imgGUI2;
			BufferedImage imgGUI3;
			BufferedImage imgGUI4;
			
			imgGUI1 = con2.loadImage("Images_Pokemon_RPG/GUI1.png");
			con2.drawImage(imgGUI1, 0, 0);
			con2.repaint();
			
			chrContinue=con2.getChar();
			
			// Avoiding any duplicate accounts.
			boolean blnDuplicate=true;
			
			while (blnDuplicate==true){
				imgGUI2 = con2.loadImage("Images_Pokemon_RPG/GUI2.png");
				con2.drawImage(imgGUI2, 0, 0);
				con2.repaint();
			
				con2.println("");
				con2.println("");
				con2.println("");
				con2.println("");
				con2.println("");
				con2.println("");
				con2.println("");
				con2.println("");
				con2.println("");
				con2.print("                              ");
			
				strUser=con2.readLine();
				String strReadDuplicate=("");
			
				txtDataIN.close();
				
				TextInputFile txtDuplicates = new TextInputFile ("Data/Data.txt");
			
				while (txtDuplicates.eof()==false){
					strReadDuplicate=txtDuplicates.readLine();
					if (strReadDuplicate.equalsIgnoreCase(strUser)){
						break;
					}
				}
			
				if (!strReadDuplicate.equalsIgnoreCase(strUser)){
					break;
				}
				
				txtDuplicates.close();
			} 
			
			con2.sleep(1500);
			con2.clear();
			
			imgGUI3 = con2.loadImage("Images_Pokemon_RPG/GUI3.png");
			con2.drawImage(imgGUI3,0,0);
			con2.repaint();
			chrContinue=con2.getChar();
			// Gives user time to read the block of text in GUI3.
			
			
			// Pokemon Selection
			con2.closeWindow();
			
			Console con3 = new Console();
			con3.setTextColor(Color.BLACK);
			
			imgGUI4 = con3.loadImage("Images_Pokemon_RPG/GUI4.png");
			con3.drawImage(imgGUI4, 0, 0);
			con3.repaint();
			
			// Assigning Starter Stats for Beginners
			dblLevel = 1.0;
			intHP = 50;
			intHPMax = 50;
			intAttackPower = 10;
			
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			
			con3.println(" It's finally time to CHOOSE YOUR POKÉMON!");
			con.sleep(1000);
			con3.print(" 3, ");
			con.sleep(1000);
			con3.print("2, ");
			con.sleep(1000);
			con3.println("1");
			con.sleep(1500);
			con3.println(" Pikachu, Chansey, Eevee ... I CHOOSE YOU!");
			con3.sleep(1500);
			
			con3.clear();
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			con3.println("");
			
			BufferedImage imgPikachuSelect;
			BufferedImage imgChanseySelect;
			BufferedImage imgEeveeSelect;
			
			imgPikachuSelect=con3.loadImage("Images_Pokemon_RPG/PikachuSelect.png");
			imgChanseySelect=con3.loadImage("Images_Pokemon_RPG/ChanseySelect.png");
			imgEeveeSelect=con3.loadImage("Images_Pokemon_RPG/EeveeSelect.png");
			
			con3.drawImage(imgPikachuSelect,15,70);
			con3.repaint();
			con3.drawImage(imgChanseySelect,330,70);
			con3.repaint();
			con3.drawImage(imgEeveeSelect,645,70);
			con3.repaint();
			
			int intSelectX=0;
			int intSelectY=0;
			int intClick=0;
			con3.println("   "+strUser+", click to select your pokemon!");
			
			while (intSelectX != -10){
				intSelectX=con3.currentMouseX();
				intSelectY=con3.currentMouseY();
				intClick=con3.currentMouseButton();
				
				if ((intSelectX > 15 && intSelectX < 315) && (intSelectY > 70 && intSelectY < 420) && (intClick == 1)){
					strPokemon=("Pikachu");
					con3.println("   PIKA PIKA!");
					con3.sleep(1500);
					con3.println("   You picked Pikachu! You'll be taking down countless foes together!");
					con3.println("   Attack Power doubled from 10 to 20. Press any key to continue.");
					chrContinue=con3.getChar();
					intAttackPower=intAttackPower*2;
					break;
				} else if ((intSelectX > 330 && intSelectX < 630) && (intSelectY > 70 && intSelectY < 420) && (intClick == 1)){
					strPokemon=("Chansey");
					con3.println("   Chansey! Chansey! CHANSEY!!");
					con3.sleep(1500);
					con3.println("   You picked Chansey! Nobody will take you down that easily!");
					con3.println("   Health increased from 50 to 85. Press any key to continue.");
					chrContinue=con3.getChar();
					intHP=intHP+35;
					intHPMax=intHPMax+35;
					break;
				} else if ((intSelectX > 645 && intSelectX < 945) && (intSelectY > 70 && intSelectY < 420) && (intClick == 1)){
					strPokemon=("Eevee");
					con3.println("   Wee-Wee-EEVEE!!");
					con3.sleep(1500);
					con3.println("   You picked Eevee! No weapon formed against you shall prosper!");
					con3.println("   Defensive moves now reflect full damage. Press any key to continue.");
					chrContinue=con3.getChar();
					break;
				}
			}
			
			con3.println("**********");
			con3.closeWindow();
			
			// Generating New Maps for New Players...
			
			TextInputFile txtLevel1DEF = new TextInputFile("Data/Level1.csv");
			TextInputFile txtLevel2DEF = new TextInputFile("Data/Level2.csv");
			TextInputFile txtLevel3DEF = new TextInputFile("Data/Level3.csv");
			// Opening the "unedited" default templates...
			
			TextOutputFile txtLevel1USER = new TextOutputFile("Data/Level1"+strUser+".csv");
			TextOutputFile txtLevel2USER = new TextOutputFile("Data/Level2"+strUser+".csv");
			TextOutputFile txtLevel3USER = new TextOutputFile("Data/Level3"+strUser+".csv");
			// Creating new files for new players (personalized with strUser component in File Name). 
			
			String strReadLine;
			String strSplit[];
			int intLoopCounterRow=0;
			int intLoopCounterColumn=0;
			int intTransfer[][];
			intTransfer = new int [20][20];
			String strTransfer[][];
			strTransfer = new String [20][20];
			
			// Variable to transfer csv map values from Default to Personal template. 
			
			// Transferring Level 1 Map...
			for (intLoopCounterRow = 0; intLoopCounterRow <= 19; intLoopCounterRow++){
				
				strReadLine=txtLevel1DEF.readLine();
				strSplit=strReadLine.split(",");
				
				for (intLoopCounterColumn=0; intLoopCounterColumn <= 19; intLoopCounterColumn++){
					strTransfer[intLoopCounterRow][intLoopCounterColumn]=(strSplit[intLoopCounterColumn]);
					intTransfer[intLoopCounterRow][intLoopCounterColumn]=Integer.parseInt(strTransfer[intLoopCounterRow][intLoopCounterColumn]);
					txtLevel1USER.print((intTransfer[intLoopCounterRow][intLoopCounterColumn])+",");
				}
				txtLevel1USER.println("");
				
			}
			
			// Transferring Level 2 Map...
			for (intLoopCounterRow=0;intLoopCounterRow<=20-1;intLoopCounterRow++){
				
				strReadLine=txtLevel2DEF.readLine();
				strSplit=strReadLine.split(",");
				
				for (intLoopCounterColumn=0;intLoopCounterColumn<=20-1;intLoopCounterColumn++){
					strTransfer[intLoopCounterRow][intLoopCounterColumn]=(strSplit[intLoopCounterColumn]);
					intTransfer[intLoopCounterRow][intLoopCounterColumn]=Integer.parseInt(strTransfer[intLoopCounterRow][intLoopCounterColumn]);
					txtLevel2USER.print((intTransfer[intLoopCounterRow][intLoopCounterColumn])+",");
				}
				txtLevel2USER.println("");
				
			}
			
			//Transferring Level 3 Map...
			for (intLoopCounterRow=0;intLoopCounterRow<=20-1;intLoopCounterRow++){
				
				strReadLine=txtLevel3DEF.readLine();
				strSplit=strReadLine.split(",");
				
				for (intLoopCounterColumn=0;intLoopCounterColumn<=20-1;intLoopCounterColumn++){
					strTransfer[intLoopCounterRow][intLoopCounterColumn]=(strSplit[intLoopCounterColumn]);
					intTransfer[intLoopCounterRow][intLoopCounterColumn]=Integer.parseInt(strTransfer[intLoopCounterRow][intLoopCounterColumn]);
					txtLevel3USER.print((intTransfer[intLoopCounterRow][intLoopCounterColumn])+",");
				}
				
				txtLevel3USER.println("");
				
			}
			
			txtLevel1DEF.close();
			txtLevel2DEF.close();
			txtLevel3DEF.close();
			
			txtLevel1USER.close();
			txtLevel2USER.close();
			txtLevel3USER.close();
			
		}
			
		// Auto-Save for All Players
		TextInputFile txtSaveIN = new TextInputFile ("Data/Data.txt");
		TextOutputFile txtHold = new TextOutputFile ("Data/Hold.txt");
		String strSaveRead;
		// No true here; if the text file was previously created/previously existed, the data should be replaced. This is a temporary storage file to keep the data for ulterior users intact while the data is re-written.
			
			
		while (txtSaveIN.eof()==false){
			strSaveRead=txtSaveIN.readLine();
				
			// Since ulterior accounts' data has not changed, only the current user's data musn't be carried over since it is updated. 
			if (!strSaveRead.equalsIgnoreCase(strUser)){
				txtHold.println(strSaveRead);
				strSaveRead=txtSaveIN.readLine();
				txtHold.println(strSaveRead);
				strSaveRead=txtSaveIN.readLine();
				txtHold.println(strSaveRead);
				strSaveRead=txtSaveIN.readLine();
				txtHold.println(strSaveRead);
				strSaveRead=txtSaveIN.readLine();
				txtHold.println(strSaveRead);
				strSaveRead=txtSaveIN.readLine();
				txtHold.println(strSaveRead);
			} else if (strSaveRead.equalsIgnoreCase(strUser)){
				txtSaveIN.readLine();
				txtSaveIN.readLine();
				txtSaveIN.readLine();
				txtSaveIN.readLine();
				txtSaveIN.readLine();
			}
		}
			
		txtSaveIN.close();
		txtHold.close();
			
		TextInputFile txtHoldIN = new TextInputFile("Data/Hold.txt");
		TextOutputFile txtDataOUT = new TextOutputFile ("Data/Data.txt");
		String strSavePrint;
		// The data file is NOT appended to; it is entirely replaced (hence, no "true" in the parameters) as the old data contains some outdated information for the current user. We have already copied what is consistent via the Hold File which now serves as the input file. 
			
		txtDataOUT.println(strUser);
		txtDataOUT.println(strPokemon);
		txtDataOUT.println(dblLevel);
		txtDataOUT.println(intHP);
		txtDataOUT.println(intHPMax);
		txtDataOUT.println(intAttackPower);
			
		while (txtHoldIN.eof()==false){
			strSavePrint=txtHoldIN.readLine();
			txtDataOUT.println(strSavePrint);
				
			strSavePrint=txtHoldIN.readLine();
			txtDataOUT.println(strSavePrint);
				
			strSavePrint=txtHoldIN.readLine();
			txtDataOUT.println(strSavePrint);
				
			strSavePrint=txtHoldIN.readLine();
			txtDataOUT.println(strSavePrint);
				
			strSavePrint=txtHoldIN.readLine();
			txtDataOUT.println(strSavePrint);
				
			strSavePrint=txtHoldIN.readLine();
			txtDataOUT.println(strSavePrint);
		}
		
		txtDataOUT.close();
		txtHoldIN.close();
		
		Console con4 = new Console();
		con4.setTextColor(Color.BLACK);
		
		int intParentLoop=1;
		
		while (intParentLoop==1){
			
			con4.clear();
			BufferedImage imgHelpGUI;
			imgHelpGUI=con4.loadImage("Images_Pokemon_RPG/HelpGUI.png");
			BufferedImage imgMenuNav;
			imgMenuNav=con4.loadImage("Images_Pokemon_RPG/HomeNavGUI.png");
			con4.drawImage(imgMenuNav,0,0);
			con4.repaint();
		
			//Printing HUD (Heads-Up-Display) Stats
			con4.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			con4.println("                             Welcome back "+strUser+"!");
			con4.println("");
			con4.println("                  "+((strUser+"                          ").substring(0,19))+((int)(dblLevel))+"                         "+intHP);
			con4.println("                  "+((strPokemon+"                        ").substring(0,19))+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10"+"                      "+intAttackPower);
			
			int intMenu=con4.getKey();
		
			con4.sleep(500);
			
			//(Esc) Exit Program Menu Option
			if (intMenu==27){
					con4.closeConsole();
					System.exit(0);
			} 
			
			//(H) Help Program Menu Option
			else if (intMenu==72){
				con4.clear();
				con4.drawImage(imgHelpGUI,0,0);
				con4.repaint();
				chrContinue=con4.getChar();
			} 
			
			//(S) Save Program Menu Option
			else if (intMenu == 83){
				
				TextInputFile txtSaveINMenu = new TextInputFile ("Data/Data.txt");
				TextOutputFile txtHoldMenu = new TextOutputFile ("Data/Hold.txt");
				String strSaveReadMenu;
				// No true here; if the text file was previously created/previously existed, the data should be replaced. 
				// This is a temporary storage file to keep the data for ulterior users intact while the data is re-written.
			
			
				while (txtSaveINMenu.eof()==false) {
					strSaveReadMenu=txtSaveINMenu.readLine();
					
					if (txtSaveINMenu.eof() == false) {
						break;
					}
				
					// Since ulterior accounts' data has not changed, only the current user's 
					// data musn't be carried over since it is updated. 
					if (!strSaveReadMenu.equalsIgnoreCase(strUser)){
						txtHoldMenu.println(strSaveReadMenu);
						strSaveReadMenu=txtSaveINMenu.readLine();
						txtHoldMenu.println(strSaveReadMenu);
						strSaveReadMenu=txtSaveINMenu.readLine();
						txtHoldMenu.println(strSaveReadMenu);
						strSaveReadMenu=txtSaveINMenu.readLine();
						txtHoldMenu.println(strSaveReadMenu);
						strSaveReadMenu=txtSaveINMenu.readLine();
						txtHoldMenu.println(strSaveReadMenu);
						strSaveReadMenu=txtSaveINMenu.readLine();
						txtHoldMenu.println(strSaveReadMenu);
					} else if (strSaveReadMenu.equalsIgnoreCase(strUser)){
						txtSaveINMenu.readLine();
						txtSaveINMenu.readLine();
						txtSaveINMenu.readLine();
						txtSaveINMenu.readLine();
						txtSaveINMenu.readLine();
					}
				}
			
				txtSaveINMenu.close();
				txtHoldMenu.close();
			
				TextInputFile txtHoldINMenu = new TextInputFile("Data/Hold.txt");
				TextOutputFile txtDataOUTMenu = new TextOutputFile ("Data/Data.txt");
				String strSavePrintMenu;
				// The data file is NOT appended to; it is entirely replaced (hence, no "true" in the parameters) as the old data 
				// contains some outdated information for the current user. We have already copied what is consistent via the Hold 
				// File which now serves as the input file. 
			
				txtDataOUTMenu.println(strUser);
				txtDataOUTMenu.println(strPokemon);
				txtDataOUTMenu.println(dblLevel);
				txtDataOUTMenu.println(intHP);
				txtDataOUTMenu.println(intHPMax);
				txtDataOUTMenu.println(intAttackPower);
			
				while (txtHoldINMenu.eof()==false){
					strSavePrintMenu=txtHoldINMenu.readLine();
					txtDataOUTMenu.println(strSavePrintMenu);
					strSavePrintMenu=txtHoldINMenu.readLine();
					txtDataOUTMenu.println(strSavePrintMenu);
					strSavePrintMenu=txtHoldINMenu.readLine();
					txtDataOUTMenu.println(strSavePrintMenu);
					strSavePrintMenu=txtHoldINMenu.readLine();
					txtDataOUTMenu.println(strSavePrintMenu);
					strSavePrintMenu=txtHoldINMenu.readLine();
					txtDataOUTMenu.println(strSavePrintMenu);
					strSavePrintMenu=txtHoldINMenu.readLine();
					txtDataOUTMenu.println(strSavePrintMenu);
				}	
		
				txtDataOUTMenu.close();
				txtHoldINMenu.close();
				
				con4.println("   Your data has been successfully saved!");
				con4.sleep(1500);
		
			} 
			
			//(P) Play Game Loop
			else if (intMenu==80){
			
				con4.clear();
				con4.setTextColor(Color.BLACK);
				
				BufferedImage imgMap;
				imgMap = con4.loadImage("Images_Pokemon_RPG/PlayMapGUI.png");
				con4.drawImage(imgMap,0,0);
				con4.repaint();
				
				con4.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				con4.println("  Where would you like to travel, "+strUser+"?");
				con4.println("  Click on the route and you will be teleported to your destination.");

				int intMap=0;
				con4.sleep(500);
			
				int intMapX=0;
				int intMapY=0;
				int intMapClick=0;

				// Map Selection: infinite loop; only broken by "break" command when one of the below "if" statements is true (map is selected).
				while (true) {
					intMapX=con4.currentMouseX();
					intMapY=con4.currentMouseY();
					intMapClick=con4.currentMouseButton();

					if ((intMapX >= 0 && intMapX <= 470) && 
					    (intMapY >= 15 && intMapY <= 115) && 
						(intMapClick == 1)) {
						intMap = 1;
						break;
					}
				
					else if ((intMapX >= 0 && intMapX <= 470) && 
					        (intMapY >= 145 && intMapY <= 245) && 
							(intMapClick == 1)) {

						if (dblLevel < 2.0) {
							con4.clear();
							con4.drawImage(imgMap,0,0);
							con4.repaint();
							con4.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
							con4.println("  You must be level 2 or above to go here.");
							con4.sleep(3000);
							
							con4.clear();
							con4.setTextColor(Color.BLACK);
							
							con4.drawImage(imgMap, 0, 0);
							con4.repaint();
							
							con4.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
							con4.println("  Where would you like to travel, "+strUser+"?");
							con4.println("  Click on the route and you will be teleported to your destination.");
							intMapX=con4.currentMouseX();
							intMapY=con4.currentMouseY();
							intMapClick=con4.currentMouseButton();
							continue;
						}
						intMap=2;
						break;
					}
					
					// Will not work for players who are below level 2 (ex. dblLevel=1.9)
				
					else if ((intMapX>=0 && intMapX<=470) && 
							 (intMapY>=275 && intMapY<=375) &&
							 (intMapClick==1)) {
						
						if (dblLevel<3.0) {
							con4.clear();
							con4.setTextColor(Color.BLACK);
							
							con4.drawImage(imgMap,0,0);
							con4.repaint();

							con4.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
							con4.println("  You must be level 3 or above to go here.");
							con4.sleep(3000);
							con4.clear();
							con4.setTextColor(Color.BLACK);
							
							imgMap = con4.loadImage("Images_Pokemon_RPG/PlayMapGUI.png");
							con4.drawImage(imgMap,0,0);
							con4.repaint();
							
							con4.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
							con4.println("  Where would you like to travel, "+strUser+"?");
							con4.println("  Click on the route and you will be teleported to your destination.");
							intMapX=con4.currentMouseX();
							intMapY=con4.currentMouseY();
							intMapClick=con4.currentMouseButton();
							continue;
						}
						intMap=3;
						break;
					}
					// Will not work for players who are below level 3 (ex. dbllevel=2.9)
				}
				
				con4.clear();
				
				BufferedImage imgPlayGUI;
				imgPlayGUI=con4.loadImage("Images_Pokemon_RPG/PlayGUI.png");
				con4.drawImage(imgPlayGUI,0,0);
				con4.repaint();
				
				// Terrain Tile Index:
				// 0) Player Location
				// 1) Short Grass
				// 2) Tall Grass
				// 3) Tree
				// 4) Water
				// 5) Heal TL
				// 6) Heal TR
				// 7) Heal BL
				// 8) Heal BR
				// 9) Zubat
				// 10) Rocket Trainer
				// 11) Jessie
				// 12) James
				
				TextInputFile txtTerrain = new TextInputFile("Data/Level"+intMap+strUser+".csv");
				int intMove=0;
				int intLoopCounterRow;
				int intLoopCounterColumn;
				String strReadLine;
				String strSplit[];
				String strTransfer[][];
				
				strTransfer=new String[20][20];
				
				int intLocation[][];
				intLocation = new int [20][20];
				int intLocationX=0;
				int intLocationY=0;
				
				
				for (intLoopCounterRow=0;intLoopCounterRow<=20-1;intLoopCounterRow++){
				
				strReadLine=txtTerrain.readLine();
				strSplit=strReadLine.split(",");
				BufferedImage imgTile;
				
					for (intLoopCounterColumn = 0; intLoopCounterColumn < 20; intLoopCounterColumn++){
						strTransfer[intLoopCounterRow][intLoopCounterColumn]=(strSplit[intLoopCounterColumn]);
						intLocation[intLoopCounterRow][intLoopCounterColumn]=Integer.parseInt(strTransfer[intLoopCounterRow][intLoopCounterColumn]);
					
						if ((intLocation[intLoopCounterRow][intLoopCounterColumn])==0){
							imgTile=con4.loadImage("Images_Pokemon_RPG/" + (strPokemon)+".png");
							con4.drawImage(imgTile,(intLoopCounterColumn*20+150),(intLoopCounterRow*20)+100);
							con4.repaint();
							intLocationX=intLoopCounterColumn;
							intLocationY=intLoopCounterRow;
						} else if ((intLocation[intLoopCounterRow][intLoopCounterColumn])==1){
							imgTile=con4.loadImage("Images_Pokemon_RPG/Grass1.png");
							con4.drawImage(imgTile,(intLoopCounterColumn*20+150),(intLoopCounterRow*20)+100);
							con4.repaint();
						} else if ((intLocation[intLoopCounterRow][intLoopCounterColumn])==2){
							imgTile=con4.loadImage("Images_Pokemon_RPG/Grass2.png");
							con4.drawImage(imgTile,(intLoopCounterColumn*20+150),(intLoopCounterRow*20)+100);
							con4.repaint();
						} else if ((intLocation[intLoopCounterRow][intLoopCounterColumn])==3){
							imgTile=con4.loadImage("Images_Pokemon_RPG/Tree.png");
							con4.drawImage(imgTile,(intLoopCounterColumn*20+150),(intLoopCounterRow*20)+100);
							con4.repaint();
						} else if ((intLocation[intLoopCounterRow][intLoopCounterColumn])==4){
							imgTile=con4.loadImage("Images_Pokemon_RPG/Water.png");
							con4.drawImage(imgTile,(intLoopCounterColumn*20+150),(intLoopCounterRow*20)+100);
							con4.repaint();
						} else if ((intLocation[intLoopCounterRow][intLoopCounterColumn])==5){
							imgTile=con4.loadImage("Images_Pokemon_RPG/HealTL.png");
							con4.drawImage(imgTile,(intLoopCounterColumn*20+150),(intLoopCounterRow*20)+100);
							con4.repaint();
						} else if ((intLocation[intLoopCounterRow][intLoopCounterColumn])==6){
							imgTile=con4.loadImage("Images_Pokemon_RPG/HealTR.png");
							con4.drawImage(imgTile,(intLoopCounterColumn*20+150),(intLoopCounterRow*20)+100);
							con4.repaint();
						} else if ((intLocation[intLoopCounterRow][intLoopCounterColumn])==7){
							imgTile=con4.loadImage("Images_Pokemon_RPG/HealBL.png");
							con4.drawImage(imgTile,(intLoopCounterColumn*20+150),(intLoopCounterRow*20)+100);
							con4.repaint();
						} else if ((intLocation[intLoopCounterRow][intLoopCounterColumn])==8){
							imgTile=con4.loadImage("Images_Pokemon_RPG/HealBR.png");
							con4.drawImage(imgTile,(intLoopCounterColumn*20+150),(intLoopCounterRow*20)+100);
							con4.repaint();
						} else if ((intLocation[intLoopCounterRow][intLoopCounterColumn])==9){
							imgTile=con4.loadImage("Images_Pokemon_RPG/Zubat.png");
							con4.drawImage(imgTile,(intLoopCounterColumn*20+150),(intLoopCounterRow*20)+100);
							con4.repaint();
						} else if ((intLocation[intLoopCounterRow][intLoopCounterColumn])==10){
							imgTile=con4.loadImage("Images_Pokemon_RPG/RocketTrainer.png");
							con4.drawImage(imgTile,(intLoopCounterColumn*20+150),(intLoopCounterRow*20)+100);
							con4.repaint();
						} else if ((intLocation[intLoopCounterRow][intLoopCounterColumn])==11){
							imgTile=con4.loadImage("Images_Pokemon_RPG/Jessie.png");
							con4.drawImage(imgTile,(intLoopCounterColumn*20+150),(intLoopCounterRow*20)+100);
							con4.repaint();
						} else if ((intLocation[intLoopCounterRow][intLoopCounterColumn])==12){
							imgTile=con4.loadImage("Images_Pokemon_RPG/James.png");
							con4.drawImage(imgTile,(intLoopCounterColumn*20+150),(intLoopCounterRow*20)+100);
							con4.repaint();
						}
					}
				}
				
				txtTerrain.close();                                                                
			
				BufferedImage imgSwitchA;
				BufferedImage imgSwitchB;
			
				while (intMove!=27){
				
					if (intHP<=0){
					imgSwitchA=con.loadImage("Images_Pokemon_RPG/Grass1.png");
						imgSwitchB=con.loadImage("Images_Pokemon_RPG/" + strPokemon + ".png");
						con4.drawImage(imgSwitchA,intLocationX*20+150,intLocationY*20+100);
						con4.repaint();
						intLocation[intLocationY][intLocationX]=1;
						//Before resetting character's location; their last tile is switched back to grass since this is the only tile they can stand on.
						intLocationX=3;
						intLocationY=17;
						intLocation[intLocationY][intLocationX]=0;
						con4.drawImage(imgSwitchB,intLocationX*20+150,intLocationY*20+100);
						con4.repaint();
						intHP=intHPMax;
						con4.clear();
						con4.println("\n");
						con4.println("               Your pokémon are restored to full health.");    
						con4.sleep(1200);       
					}
				
					con4.clear();
					con4.println("\n");
					con4.println("                         Route "+intMap+"                                       "+intHP+"/"+intHPMax);
					con4.println("\n");
					con4.println("                                                                          "+intAttackPower); 
					con4.println("\n");
					con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
				
					intMove=con4.getKey();
				
					// (w or Up Arrow) Forwards
					if ((intMove==87 || intMove==38)&&((intLocationY-1)>=0)){
					
						if ((intLocation[intLocationY-1][intLocationX]==1)){
							intLocationY=intLocationY-1;
						
							intLocation[intLocationY][intLocationX]=0;
							intLocation[intLocationY+1][intLocationX]=1;
						
							imgSwitchA=con4.loadImage("Images_Pokemon_RPG/" + (strPokemon)+".png");
							con4.drawImage(imgSwitchA,intLocationX*20+150,(intLocationY)*20+100);
							con4.repaint();
							imgSwitchB=con4.loadImage("Images_Pokemon_RPG/Grass1.png");
							con4.drawImage(imgSwitchB,(intLocationX*20)+150,(intLocationY+1)*20+100);
							con4.repaint();
						
							// con4.println(intLocationX);
							// con4.println(intLocationY);
							con4.sleep(250);
						
						} 
						// User attempts to walk into Healing Centre
						else if (intLocation[intLocationY-1][intLocationX]==5 || intLocation[intLocationY-1][intLocationX]==6 || intLocation[intLocationY-1][intLocationX]==7 || intLocation[intLocationY-1][intLocationX]==8){
							intHP=intHPMax;
							con4.clear();
							con4.println("\n");
							con4.println("             "+strPokemon+"'s HP has been fully healed.");
							con4.sleep(1000);
							con4.clear();
							con4.println("\n");
							con4.println("             Thanks for visiting Poké Hospital!");
							con4.clear();
						
						} 
						// User walks into Water (Drowns)
						else if (intLocation[intLocationY-1][intLocationX]==4){
							con4.clear();
							intHP=0;

							con4.println("\n");
							con4.println("                 Oops! "+strPokemon+" drowned!                                "+intHP+"/"+intHPMax);
							con4.println("\n");
							con4.println("                                                                         "+intAttackPower); 
							con4.println("\n");
							con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10"); 
							con4.sleep(2000);
						
						}
					
						// User encounters a Wild Zubat
						else if (intLocation[intLocationY-1][intLocationX]==9){
							con4.clear();
							con4.println("\n");
							con4.print("             A wild Zubat appeared!");
							con4.println("                                   "+intHP+"/"+intHPMax);
							con4.println("\n");
							con4.println("                                                                         "+intAttackPower); 
							con4.println("\n");
							con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
						
							String strEnemy=("Zubat");
							int intZubatHP=25;
							int intOptionUSER;
							int intOptionZUBAT;
							int intAttackPowerZUBAT=5;
						
							con4.println("\n\n");
							con4.println("                                                                    "+strEnemy);
							con4.println("\n");
							con4.println("                                                                   "+intZubatHP+"/25");
							con4.println("\n");
							con4.println("                                                                        "+intAttackPowerZUBAT);
						
							con4.sleep(2000);
						
							while (intHP>0 && intZubatHP>0){
								intOptionUSER=0;
								intOptionZUBAT=0;
								int intRandom=9;
							
								// Keep asking user for input until a proper selection is chosen (1, 2, or 3). 
								while (intOptionUSER!=49 && intOptionUSER!=50 && intOptionUSER!=51){
									con4.clear();
									con4.println("\n");
									con4.print("      Press 1 to attack, 2 to heal 5HP, 3 to defend");
									con4.println("                    "+intHP+"/"+intHPMax);
									con4.println("\n");
									con4.println("                                                                         "+intAttackPower); 
									con4.println("\n");
									con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
									con4.println("\n\n");
									con4.println("                                                                    "+strEnemy);
									con4.println("\n");
									con4.println("                                                                   "+intZubatHP+"/25");
									con4.println("\n");
									con4.println("                                                                        "+intAttackPowerZUBAT);
								
									intOptionUSER=con4.getKey();
								}
							
								if (intOptionUSER==49){
									intOptionUSER=1;
								} else if (intOptionUSER==50){
									intOptionUSER=2;
								} else {
									intOptionUSER=3;
								}
							
								//Generate 3 random numbers with equal probability (uniform) distributions; since we should only have 9 since 9%3 = 0, 0 inclusive; 9 as a value will be rejected. 
								while (intRandom==9){
									intRandom=(int)((Math.random())*10);
								}
							
								if (intRandom>=0 && intRandom<=2){
									intOptionZUBAT=1;
								} else if (intRandom>=3 && intRandom<=5){
									intOptionZUBAT=2;
								} else if (intRandom>=6 && intRandom<=9){
									intOptionZUBAT=3;
								}
							
								con4.sleep(1500);
							
								// Same Move vs. Same Move (Nothing Happens)
								if (intOptionZUBAT==intOptionUSER){
									con4.clear();
									con4.println("\n");
									con4.println("      Your pokemon did the same move as ");
									con4.sleep(2000);
									con4.clear();
									con4.println("\n");
									con4.println("     "+strEnemy+" , nothing happened!");
									con4.sleep(2000);
								}
							
								// Attack vs. Heal (Attack Wins)
								else if (intOptionUSER==1 && intOptionZUBAT==2){
									intZubatHP=intZubatHP-intAttackPower;
									con4.clear();
									con4.println("\n");
									con4.println("   Your pokemon dealt "+intAttackPower+" DMG to "+strEnemy+"!");
									con4.sleep(2000);
								}
							
								else if (intOptionUSER==2 && intOptionZUBAT==1){
									intHP=intHP-intAttackPowerZUBAT;
									con4.clear();
									con4.println("\n");
									con4.println("    "+strEnemy+" dealt "+intAttackPowerZUBAT+" damage to your pokemon!");
									con4.sleep(2000);
								} 
							
								// Heal vs. Defend (Heal Wins ~ Defend is Useless / Does Nothing)
								else if (intOptionUSER==2 && intOptionZUBAT==3){
									intHP=intHP+5;
									con4.clear();
									con4.println("\n");
									con4.println("    You healed 5 HP!");
									con4.sleep(2000);
								}
								else if (intOptionUSER==3 && intOptionZUBAT==2){
									intZubatHP=intZubatHP+5;
									con4.clear();
									con4.println("\n");
									con4.println("   "+strEnemy+" healed 5 HP!");
									con4.sleep(2000);
								}
							
								// Attack vs. Defend (Defend Wins and Reflects Half or Full Damage)
								else if (intOptionUSER==3 && intOptionZUBAT==1){
									if (strPokemon.equalsIgnoreCase("eevee")){
										intZubatHP=intZubatHP-intAttackPowerZUBAT;
										con4.clear();
										con4.println("\n");
										con4.println("   You reflected "+intAttackPowerZUBAT+" back to "+strEnemy+"!");
										con4.sleep(2000);
									} else {
										intZubatHP=intZubatHP-(int)(0.5*intAttackPowerZUBAT);
										con4.clear();
										con4.println("\n");
										con4.println("   You reflected "+(int)(0.5*(intAttackPowerZUBAT))+" back to "+strEnemy+"!");
										con4.sleep(2000);
									}
								}
							
								else if (intOptionUSER==1 && intOptionZUBAT==3){
									intHP=(intHP)-(int)(0.5*intAttackPower);
									con4.clear();
									con4.println("\n");
									con4.println("   "+strEnemy+" reflected "+strPokemon+"'s hit for "+((int)(0.5*intAttackPower))+" damage!");
									con4.sleep(2000);
								}
						
								con4.sleep(2500);
							}
							
							// User Wins
						
							if (intHP>intZubatHP){
								dblLevel=dblLevel+0.1;
								con4.clear();
								con4.println("\n");
								con4.print("   The opposing "+strEnemy+" fainted!");
								con4.println("                            "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intZubatHP+"/25");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerZUBAT);
							
								con4.sleep(2500);
								intLocationY=intLocationY-1;
					
								intLocation[intLocationY][intLocationX]=0;
								intLocation[intLocationY+1][intLocationX]=1;
					
								imgSwitchA=con4.loadImage("Images_Pokemon_RPG/" + (strPokemon)+".png");
								con4.drawImage(imgSwitchA,intLocationX*20+150,(intLocationY)*20+100);
									con4.repaint();
								imgSwitchB=con4.loadImage("Images_Pokemon_RPG/Grass1.png");
								con4.drawImage(imgSwitchB,(intLocationX)*20+150,(intLocationY+1)*20+100);
								con4.repaint();
								con4.sleep(250);
							}
						
							//User Loses ~ Zubat Wins
							else {
								con4.clear();
								con4.println("\n");
								con4.print("     "+strPokemon+" fainted!");
								con4.println("                            "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intZubatHP+"/25");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerZUBAT);
							// Pass through the rest of the loop and re-enter ~ will be read by the "Check 0 HP "IF" Block" and will be sent to the Healing Centre.
							}
						}	
					
					
						// User encounters a Team Rocket Grunt
						else if (intLocation[intLocationY-1][intLocationX]==10){
							con4.clear();
							con4.println("\n");
							con4.print("  A Team Rocket Challenger Approaches You!");
							con4.sleep(1500);
							con4.clear();
							con4.println("\n");
							con4.println("   They send out a Ghastly!");
							con4.println("                                   "+intHP+"/"+intHPMax);
							con4.println("\n");
							con4.println("                                                                         "+intAttackPower); 
							con4.println("\n");
							con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
						
							String strEnemy=("Ghastly");
							int intGhastlyHP=40;
							int intOptionUSER;
							int intOptionGHASTLY;
							int intAttackPowerGHASTLY=10;
							
							con4.println("\n\n");
							con4.println("                                                                    "+strEnemy);
							con4.println("\n");
							con4.println("                                                                   "+intGhastlyHP+"/40");
							con4.println("\n");
							con4.println("                                                                        "+intAttackPowerGHASTLY);
							
							con4.sleep(2000);
							
							while (intHP>0 && intGhastlyHP>0){
								intOptionUSER=0;
								intOptionGHASTLY=0;
								int intRandom=9;
								
								// Keep asking user for input until a proper selection is chosen (1,2,or 3). 
								while (intOptionUSER!=49 && intOptionUSER!=50 && intOptionUSER!=51){
									con4.clear();
									con4.println("\n");
									con4.print("      Press 1 to attack, 2 to heal 5HP, 3 to defend");
									con4.println("                    "+intHP+"/"+intHPMax);
									con4.println("\n");
									con4.println("                                                                         "+intAttackPower); 
									con4.println("\n");
									con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
									con4.println("\n\n");
									con4.println("                                                                    "+strEnemy);
									con4.println("\n");
									con4.println("                                                                   "+intGhastlyHP+"/40");
									con4.println("\n");
									con4.println("                                                                        "+intAttackPowerGHASTLY);
									
									intOptionUSER=con4.getKey();
								}
								
								if (intOptionUSER==49){
									intOptionUSER=1;
								} else if (intOptionUSER==50){
									intOptionUSER=2;
								} else {
									intOptionUSER=3;
								}
								
								// Generate 3 random numbers with equal probability (uniform) distributions; since we should only have 9 since 9%3 = 0, 0 inclusive; 9 as a value will be rejected. 
								while (intRandom==9){
									intRandom=(int)((Math.random())*10);
								}
								
								if (intRandom>=0 && intRandom<=2){
									intOptionGHASTLY=1;
								} else if (intRandom>=3 && intRandom<=5){
									intOptionGHASTLY=2;
								} else if (intRandom>=6 && intRandom<=9){
									intOptionGHASTLY=3;
								}
								
								con4.sleep(1500);
								
								// Same Move vs. Same Move (Nothing Happens)
								if (intOptionGHASTLY==intOptionUSER){
									con4.clear();
									con4.println("\n");
									con4.println("      Your pokemon did the same move as ");
									con4.sleep(2000);
									con4.clear();
									con4.println("\n");
									con4.println("     "+strEnemy+" , nothing happened!");
									con4.sleep(2000);
								}
								
								// Attack vs. Heal (Attack Wins)
								else if (intOptionUSER==1 && intOptionGHASTLY==2){
									intGhastlyHP=intGhastlyHP-intAttackPower;
									con4.clear();
									con4.println("\n");
									con4.println("   Your pokemon dealt "+intAttackPower+" DMG to "+strEnemy+"!");
									con4.sleep(2000);
								}
								
								else if (intOptionUSER==2 && intOptionGHASTLY==1){
									intHP=intHP-intAttackPowerGHASTLY;
									con4.clear();
									con4.println("\n");
									con4.println("    "+strEnemy+" dealt "+intAttackPowerGHASTLY+" damage to your pokemon!");
									con4.sleep(2000);
								} 
								
								// Heal vs. Defend (Heal Wins ~ Defend is Useless / Does Nothing)
								else if (intOptionUSER==2 && intOptionGHASTLY==3){
									intHP=intHP+5;
									con4.clear();
									con4.println("\n");
									con4.println("    You healed 5 HP!");
									con4.sleep(2000);
								}
								else if (intOptionUSER==3 && intOptionGHASTLY==2){
									intGhastlyHP=intGhastlyHP+5;
									con4.clear();
									con4.println("\n");
									con4.println("   "+strEnemy+" healed 5 HP!");
									con4.sleep(2000);
								}
								
								// Attack vs. Defend (Defend Wins and Reflects Half or Full Damage)
								else if (intOptionUSER==3 && intOptionGHASTLY==1){
									if (strPokemon.equalsIgnoreCase("eevee")){
										intGhastlyHP=intGhastlyHP-intAttackPowerGHASTLY;
										con4.clear();
										con4.println("\n");
										con4.println("   You reflected "+intAttackPowerGHASTLY+" back to "+strEnemy+"!");
										con4.sleep(2000);
									} else {
										intGhastlyHP=intGhastlyHP-(int)(0.5*intAttackPowerGHASTLY);
										con4.clear();
										con4.println("\n");
										con4.println("   You reflected "+(int)(0.5*(intAttackPowerGHASTLY))+" back to "+strEnemy+"!");
										con4.sleep(2000);
									}
								}
								
								else if (intOptionUSER==1 && intOptionGHASTLY==3){
									intHP=(intHP)-(int)(0.5*intAttackPower);
									con4.clear();
									con4.println("\n");
									con4.println("   "+strEnemy+" reflected "+strPokemon+"'s hit for "+((int)(0.5*intAttackPower))+" damage!");
									con4.sleep(2000);
								}
							
								con4.sleep(2500);
							}
								
							// User Wins
							
							if (intHP>intGhastlyHP){
								dblLevel=dblLevel+0.1;
								con4.clear();
								con4.println("\n");
								con4.print("   The opposing "+strEnemy+" fainted!");
								con4.println("                                   "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intGhastlyHP+"/40");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerGHASTLY);
								
								con4.sleep(2500);
								intLocationY=intLocationY-1;
						
								intLocation[intLocationY][intLocationX]=0;
								intLocation[intLocationY+1][intLocationX]=1;
						
								imgSwitchA=con4.loadImage("Images_Pokemon_RPG/" + (strPokemon)+".png");
								con4.drawImage(imgSwitchA,intLocationX*20+150,(intLocationY)*20+100);
								con4.repaint();
								imgSwitchB=con4.loadImage("Images_Pokemon_RPG/Grass1.png");
								con4.drawImage(imgSwitchB,(intLocationX)*20+150,(intLocationY+1)*20+100);
								con4.repaint();
								con4.sleep(250);
							}
							
							// User Loses ~ Ghastly Wins
							else {
								con4.clear();
								con4.println("\n");
								con4.print("     "+strPokemon+" fainted!");
								con4.println("                                   "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intGhastlyHP+"/40");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerGHASTLY);
							// Pass through the rest of the loop and re-enter ~ will be read by the "Check 0 HP "IF" Block" and will be sent to the Healing Centre.
							}
						}
						
						
						// User encounters Jessie.
						else if (intLocation[intLocationY-1][intLocationX]==11){
							con4.clear();
							con4.println("\n");
							con4.print("  It's Team Rocket Jessie!");
							con4.sleep(1500);
							con4.clear();
							con4.println("\n");
							con4.println("   She sends out Ekans!");
							con4.println("                                   "+intHP+"/"+intHPMax);
							con4.println("\n");
							con4.println("                                                                         "+intAttackPower); 
							con4.println("\n");
							con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
							
							String strEnemy=("Ekans");
							int intEkansHP=50;
							int intOptionUSER;
							int intOptionEkans;
							int intAttackPowerEkans=15;
							
							con4.println("\n\n");
							con4.println("                                                                    "+strEnemy);
							con4.println("\n");
							con4.println("                                                                   "+intEkansHP+"/50");
							con4.println("\n");
							con4.println("                                                                        "+intAttackPowerEkans);
							
							con4.sleep(2000);
							
							while (intHP>0 && intEkansHP>0){
								intOptionUSER=0;
								intOptionEkans=0;
								int intRandom=9;
								
								// Keep asking user for input until a proper selection is chosen (1,2,or 3). 
								while (intOptionUSER!=49 && intOptionUSER!=50 && intOptionUSER!=51){
									con4.clear();
									con4.println("\n");
									con4.print("      Press 1 to attack, 2 to heal 5HP, 3 to defend");
									con4.println("                    "+intHP+"/"+intHPMax);
									con4.println("\n");
									con4.println("                                                                         "+intAttackPower); 
									con4.println("\n");
									con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
									con4.println("\n\n");
									con4.println("                                                                    "+strEnemy);
									con4.println("\n");
									con4.println("                                                                   "+intEkansHP+"/50");
									con4.println("\n");
									con4.println("                                                                        "+intAttackPowerEkans);
									
									intOptionUSER=con4.getKey();
								}
								
								if (intOptionUSER==49){
									intOptionUSER=1;
								} else if (intOptionUSER==50){
									intOptionUSER=2;
								} else {
									intOptionUSER=3;
								}
								
								// Generate 3 random numbers with equal probability (uniform) distributions; since we should only have 9 since 9%3 = 0, 0 inclusive; 9 as a value will be rejected. 
								while (intRandom==9){
									intRandom=(int)((Math.random())*10);
								}
								
								if (intRandom>=0 && intRandom<=2){
									intOptionEkans=1;
								} else if (intRandom>=3 && intRandom<=5){
									intOptionEkans=2;
								} else if (intRandom>=6 && intRandom<=9){
									intOptionEkans=3;
								}
								
								con4.sleep(1500);
								
								// Same Move vs. Same Move (Nothing Happens)
								if (intOptionEkans==intOptionUSER){
									con4.clear();
									con4.println("\n");
									con4.println("      Your pokemon did the same move as ");
									con.sleep(2000);
									con4.clear();
									con4.println("\n");
									con4.println("     "+strEnemy+" , nothing happened!");
									con4.sleep(2000);
								}
								
								// Attack vs. Heal (Attack Wins)
								else if (intOptionUSER==1 && intOptionEkans==2){
									intEkansHP=intEkansHP-intAttackPower;
									con4.clear();
									con4.println("\n");
									con4.println("   Your pokemon dealt "+intAttackPower+" DMG to "+strEnemy+"!");
									con4.sleep(2000);
								}
								
								else if (intOptionUSER==2 && intOptionEkans==1){
									intHP=intHP-intAttackPowerEkans;
									con4.clear();
									con4.println("\n");
									con4.println("    "+strEnemy+" dealt "+intAttackPowerEkans+" damage to your pokemon!");
									con4.sleep(2000);
								} 
								
								// Heal vs. Defend (Heal Wins ~ Defend is Useless / Does Nothing)
								else if (intOptionUSER==2 && intOptionEkans==3){
									intHP=intHP+5;
									con4.clear();
									con4.println("\n");
									con4.println("    You healed 5 HP!");
									con4.sleep(2000);
								}
								else if (intOptionUSER==3 && intOptionEkans==2){
									intEkansHP=intEkansHP+5;
									con4.clear();
									con4.println("\n");
									con4.println("   "+strEnemy+" healed 5 HP!");
									con4.sleep(2000);
								}
								
								// Attack vs. Defend (Defend Wins and Reflects Half or Full Damage)
								else if (intOptionUSER==3 && intOptionEkans==1){
									if (strPokemon.equalsIgnoreCase("eevee")){
										intEkansHP=intEkansHP-intAttackPowerEkans;
										con4.clear();
										con4.println("\n");
										con4.println("   You reflected "+intAttackPowerEkans+" back to "+strEnemy+"!");
										con4.sleep(2000);
									} else {
										intEkansHP=intEkansHP-(int)(0.5*intAttackPowerEkans);
										con4.clear();
										con4.println("\n");
										con4.println("   You reflected "+(int)(0.5*(intAttackPowerEkans))+" back to "+strEnemy+"!");
										con4.sleep(2000);
									}
								}
								
								else if (intOptionUSER==1 && intOptionEkans==3){
									intHP=(intHP)-(int)(0.5*intAttackPower);
									con4.clear();
									con4.println("\n");
									con4.println("   "+strEnemy+" reflected "+strPokemon+"'s hit for "+((int)(0.5*intAttackPower))+" damage!");
									con4.sleep(2000);
								}
							
								con4.sleep(2500);
							}
								
							// User Wins
							
							if (intHP>intEkansHP){
								dblLevel=dblLevel+0.1;
								con4.clear();
								con4.println("\n");
								con4.print("   The opposing "+strEnemy+" fainted!");
								con4.sleep(1500);
								
								intHPMax = intHPMax+10;
								intAttackPower = intAttackPower+10;
								
								con4.clear();
								con4.println("\n");
								con4.print("   Your HP Max increased by 10.");
								con4.sleep(2000);
								
								con4.clear();
								con4.println("\n");
								con4.print("   Your Attack Power increased by 10.");
								con4.sleep(2000);
								
								con4.println("                                   "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intEkansHP+"/50");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerEkans);
								
								con4.sleep(2500);
								intLocationY=intLocationY-1;
						
								intLocation[intLocationY][intLocationX]=0;
								intLocation[intLocationY+1][intLocationX]=1;
						
								imgSwitchA=con4.loadImage("Images_Pokemon_RPG/" + (strPokemon)+".png");
								con4.drawImage(imgSwitchA,intLocationX*20+150,(intLocationY)*20+100);
								con4.repaint();
								imgSwitchB=con4.loadImage("Images_Pokemon_RPG/Grass1.png");
								con4.drawImage(imgSwitchB,(intLocationX)*20+150,(intLocationY+1)*20+100);
								con4.repaint();
								con4.sleep(250);
							}
							
							// User Loses ~ Ekans Wins
							else {
								con4.clear();
								con4.println("\n");
								con4.print("     "+strPokemon+" fainted!");
								con4.println("                                  "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intEkansHP+"/50");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerEkans);
							// Pass through the rest of the loop and re-enter ~ will be read by the "Check 0 HP "IF" Block" and will be sent to the Healing Centre.
							}
						}
						
						// User encounters James.
						else if (intLocation[intLocationY-1][intLocationX]==12){
							con4.clear();
							con4.println("\n");
							con4.print("  It's Team Rocket James!");
							con4.sleep(1500);
							con4.clear();
							con4.println("\n");
							con4.println("   He sends out Meowth!");
							con4.println("                                   "+intHP+"/"+intHPMax);
							con4.println("\n");
							con4.println("                                                                         "+intAttackPower); 
							con4.println("\n");
							con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
							
							String strEnemy=("Meowth");
							int intMeowthHP=50;
							int intOptionUSER;
							int intOptionMeowth;
							int intAttackPowerMeowth=15;
							
							con4.println("\n\n");
							con4.println("                                                                    "+strEnemy);
							con4.println("\n");
							con4.println("                                                                   "+intMeowthHP+"/50");
							con4.println("\n");
							con4.println("                                                                        "+intAttackPowerMeowth);
							
							con4.sleep(2000);
							
							while (intHP>0 && intMeowthHP>0){
								intOptionUSER=0;
								intOptionMeowth=0;
								int intRandom=9;
								
								// Keep asking user for input until a proper selection is chosen (1,2,or 3). 
								while (intOptionUSER!=49 && intOptionUSER!=50 && intOptionUSER!=51){
									con4.clear();
									con4.println("\n");
									con4.print("      Press 1 to attack, 2 to heal 5HP, 3 to defend");
									con4.println("                    "+intHP+"/"+intHPMax);
									con4.println("\n");
									con4.println("                                                                         "+intAttackPower); 
									con4.println("\n");
									con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
									con4.println("\n\n");
									con4.println("                                                                    "+strEnemy);
									con4.println("\n");
									con4.println("                                                                   "+intMeowthHP+"/50");
									con4.println("\n");
									con4.println("                                                                        "+intAttackPowerMeowth);
									
									intOptionUSER=con4.getKey();
								}
								
								if (intOptionUSER==49){
									intOptionUSER=1;
								} else if (intOptionUSER==50){
									intOptionUSER=2;
								} else {
									intOptionUSER=3;
								}
								
								// Generate 3 random numbers with equal probability (uniform) distributions; since we should only have 9 since 9%3 = 0, 0 inclusive; 9 as a value will be rejected. 
								while (intRandom==9){
									intRandom=(int)((Math.random())*10);
								}
								
								if (intRandom>=0 && intRandom<=2){
									intOptionMeowth=1;
								} else if (intRandom>=3 && intRandom<=5){
									intOptionMeowth=2;
								} else if (intRandom>=6 && intRandom<=9){
									intOptionMeowth=3;
								}
								
								con4.sleep(1500);
								
								// Same Move vs. Same Move (Nothing Happens)
								if (intOptionMeowth==intOptionUSER){
									con4.clear();
									con4.println("\n");
									con4.println("      Your pokemon did the same move as ");
									con4.sleep(2000);
									con4.clear();
									con4.println("\n");
									con4.println("     "+strEnemy+" , nothing happened!");
									con4.sleep(2000);
								}
								
								// Attack vs. Heal (Attack Wins)
								else if (intOptionUSER==1 && intOptionMeowth==2){
									intMeowthHP=intMeowthHP-intAttackPower;
									con4.clear();
									con4.println("\n");
									con4.println("   Your pokemon dealt "+intAttackPower+" DMG to "+strEnemy+"!");
									con4.sleep(2000);
								}
								
								else if (intOptionUSER==2 && intOptionMeowth==1){
									intHP=intHP-intAttackPowerMeowth;
									con4.clear();
									con4.println("\n");
									con4.println("    "+strEnemy+" dealt "+intAttackPowerMeowth+" damage to your pokemon!");
									con4.sleep(2000);
								} 
								
								// Heal vs. Defend (Heal Wins ~ Defend is Useless / Does Nothing)
								else if (intOptionUSER==2 && intOptionMeowth==3){
									intHP=intHP+5;
									con4.clear();
									con4.println("\n");
									con4.println("    You healed 5 HP!");
									con4.sleep(2000);
								}
								else if (intOptionUSER==3 && intOptionMeowth==2){
									intMeowthHP=intMeowthHP+5;
									con4.clear();
									con4.println("\n");
									con4.println("   "+strEnemy+" healed 5 HP!");
									con4.sleep(2000);
								}
								
								// Attack vs. Defend (Defend Wins and Reflects Half or Full Damage)
								else if (intOptionUSER==3 && intOptionMeowth==1){
									if (strPokemon.equalsIgnoreCase("eevee")){
										intMeowthHP=intMeowthHP-intAttackPowerMeowth;
										con4.clear();
										con4.println("\n");
										con4.println("   You reflected "+intAttackPowerMeowth+" back to "+strEnemy+"!");
										con4.sleep(2000);
									} else {
										intMeowthHP=intMeowthHP-(int)(0.5*intAttackPowerMeowth);
										con4.clear();
										con4.println("\n");
										con4.println("   You reflected "+(int)(0.5*(intAttackPowerMeowth))+" back to "+strEnemy+"!");
										con4.sleep(2000);
									}
								}
								
								else if (intOptionUSER==1 && intOptionMeowth==3){
									intHP=(intHP)-(int)(0.5*intAttackPower);
									con4.clear();
									con4.println("\n");
									con4.println("   "+strEnemy+" reflected "+strPokemon+"'s hit for "+((int)(0.5*intAttackPower))+" damage!");
									con4.sleep(2000);
								}	
							
								con4.sleep(2500);
							}
								
							// User Wins
							
							if (intHP>intMeowthHP){
								dblLevel=dblLevel+0.1;
								con4.clear();
								con4.println("\n");
								con4.print("   The opposing "+strEnemy+" fainted!");
								con4.sleep(1500);
								
								intHPMax = intHPMax+10;
								intAttackPower = intAttackPower+10;
								
								con4.clear();
								con4.println("\n");
								con4.print("   Your HP Max increased by 10.");
								con4.sleep(2000);
								
								con4.clear();
								con4.println("\n");
								con4.print("   Your Attack Power increased by 10.");
								con4.sleep(2000);
								
								con4.println("                               "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intMeowthHP+"/50");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerMeowth);
								
								con4.sleep(2500);
								intLocationY=intLocationY-1;
						
								intLocation[intLocationY][intLocationX]=0;
								intLocation[intLocationY+1][intLocationX]=1;
						
								imgSwitchA=con4.loadImage("Images_Pokemon_RPG/" + (strPokemon)+".png");
								con4.drawImage(imgSwitchA,intLocationX*20+150,(intLocationY)*20+100);
								con4.repaint();
								imgSwitchB=con4.loadImage("Images_Pokemon_RPG/Grass1.png");
								con4.drawImage(imgSwitchB,(intLocationX)*20+150,(intLocationY+1)*20+100);
								con4.repaint();
								con4.sleep(250);
							}
							
							// User Loses ~ Meowth Wins
							else {
								con4.clear();
								con4.println("\n");
								con4.print("     "+strPokemon+" fainted!");
								con4.println("                               "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intMeowthHP+"/50");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerMeowth);
								// Pass through the rest of the loop and re-enter ~ will be read by the "Check 0 HP "IF" Block" and will be sent to the Healing Centre.
							}
						}
					}
				 
					
					// (a or left Arrow) Left
					else if (intMove==65 || intMove==37){
						
							if (((intLocationX-1)>=0) && (intLocation[intLocationY][intLocationX-1]==1)){
							
								intLocationX=intLocationX-1;
						
								intLocation[intLocationY][intLocationX]=0;
								intLocation[intLocationY][intLocationX+1]=1;
						
								imgSwitchA=con4.loadImage("Images_Pokemon_RPG/" + (strPokemon)+".png");
								con4.drawImage(imgSwitchA,intLocationX*20+150,(intLocationY)*20+100);
								con4.repaint();
								imgSwitchB=con4.loadImage("Images_Pokemon_RPG/Grass1.png");
								con4.drawImage(imgSwitchB,(intLocationX+1)*20+150,(intLocationY)*20+100);
								con4.repaint();
								con4.sleep(250);
							}
							// User attempts to walk into Healing Centre
							else if (intLocation[intLocationY][intLocationX-1]==5 || intLocation[intLocationY][intLocationX-1]==6 || intLocation[intLocationY][intLocationX-1]==7 || intLocation[intLocationY][intLocationX-1]==8){
								intHP=intHPMax;
								con4.clear();
								con4.println("\n");
								con4.println("             "+strPokemon+"'s HP has been fully healed.");
								con4.sleep(1000);
								con4.clear();
								con4.println("\n");
								con4.println("             Thanks for visiting Poké Hospital!");
								con4.clear();
							
							} 
							// User walks into Water (Drowns)
							else if (intLocation[intLocationY][intLocationX-1]==4){
								con4.clear();
								intHP=0;

								con4.println("\n");
								con4.println("                 Oops! "+strPokemon+" drowned!                                "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10"); 
								con4.sleep(2000);
							
							// User encounters a Wild Zubat
							} else if (intLocation[intLocationY][intLocationX-1]==9){
								con4.clear();
								con4.println("\n");
								con4.print("             A wild Zubat appeared!");
								con4.println("                                   "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
							
								String strEnemy=("Zubat");
								int intZubatHP=25;
								int intOptionUSER;
								int intOptionZUBAT;
								int intAttackPowerZUBAT=5;
							
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intZubatHP+"/25");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerZUBAT);
							
								con4.sleep(2000);
							
								while (intHP>0 && intZubatHP>0){
									intOptionUSER=0;
									intOptionZUBAT=0;
									int intRandom=9;
								
									// Keep asking user for input until a proper selection is chosen (1,2,or 3). 
									while (intOptionUSER!=49 && intOptionUSER!=50 && intOptionUSER!=51){
										con4.clear();
										con4.println("\n");
										con4.print("      Press 1 to attack, 2 to heal 5HP, 3 to defend");
										con4.println("                    "+intHP+"/"+intHPMax);
										con4.println("\n");
										con4.println("                                                                         "+intAttackPower); 
										con4.println("\n");
										con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
										con4.println("\n\n");
										con4.println("                                                                    "+strEnemy);
										con4.println("\n");
										con4.println("                                                                   "+intZubatHP+"/25");
										con4.println("\n");
										con4.println("                                                                        "+intAttackPowerZUBAT);
									
										intOptionUSER=con4.getKey();
									}
								
									if (intOptionUSER==49){
										intOptionUSER=1;
									} else if (intOptionUSER==50){
										intOptionUSER=2;
									} else {
										intOptionUSER=3;
									}
								
									// Generate 3 random numbers with equal probability (uniform) distributions; since we should only have 9 since 9%3 = 0, 0 inclusive; 9 as a value will be rejected. 
									while (intRandom==9){
										intRandom=(int)((Math.random())*10);
									}
								
									if (intRandom>=0 && intRandom<=2){
										intOptionZUBAT=1;
									} else if (intRandom>=3 && intRandom<=5){
										intOptionZUBAT=2;
									} else if (intRandom>=6 && intRandom<=9){
										intOptionZUBAT=3;
									}
								
									con4.sleep(1500);
								
									// Same Move vs. Same Move (Nothing Happens)
									if (intOptionZUBAT==intOptionUSER){
										con4.clear();
										con4.println("\n");
										con4.println("      Your pokemon did the same move as ");
										con4.sleep(2000);
										con4.clear();
										con4.println("\n");
										con4.println("     "+strEnemy+" , nothing happened!");
										con4.sleep(2000);
									}
								
									// Attack vs. Heal (Attack Wins)
									else if (intOptionUSER==1 && intOptionZUBAT==2){
										intZubatHP=intZubatHP-intAttackPower;
										con4.clear();
										con4.println("\n");
										con4.println("   Your pokemon dealt "+intAttackPower+" DMG to "+strEnemy+"!");
										con4.sleep(2000);
									}
								
									else if (intOptionUSER==2 && intOptionZUBAT==1){
										intHP=intHP-intAttackPowerZUBAT;
										con4.clear();
										con4.println("\n");
										con4.println("    "+strEnemy+" dealt "+intAttackPowerZUBAT+" damage to your pokemon!");
										con4.sleep(2000);
									} 
								
									// Heal vs. Defend (Heal Wins ~ Defend is Useless / Does Nothing)
									else if (intOptionUSER==2 && intOptionZUBAT==3){
										intHP=intHP+5;
										con4.clear();
										con4.println("\n");
										con4.println("    You healed 5 HP!");
										con4.sleep(2000);
									}
									else if (intOptionUSER==3 && intOptionZUBAT==2){
										intZubatHP=intZubatHP+5;
										con4.clear();
										con4.println("\n");
										con4.println("   "+strEnemy+" healed 5 HP!");
										con4.sleep(2000);
									}
								
									// Attack vs. Defend (Defend Wins and Reflects Half or Full Damage)
									else if (intOptionUSER==3 && intOptionZUBAT==1){
										if (strPokemon.equalsIgnoreCase("eevee")){
											intZubatHP=intZubatHP-intAttackPowerZUBAT;
											con4.clear();
											con4.println("\n");
											con4.println("   You reflected "+intAttackPowerZUBAT+" back to "+strEnemy+"!");
											con4.sleep(2000);
										} else {
											intZubatHP=intZubatHP-(int)(0.5*intAttackPowerZUBAT);
											con4.clear();
											con4.println("\n");
											con4.println("   You reflected "+(int)(0.5*(intAttackPowerZUBAT))+" back to "+strEnemy+"!");
											con4.sleep(2000);
										}
									}
								
									else if (intOptionUSER==1 && intOptionZUBAT==3){
										intHP=(intHP)-(int)(0.5*intAttackPower);
										con4.clear();
										con4.println("\n");
										con4.println("   "+strEnemy+" reflected "+strPokemon+"'s hit for "+((int)(0.5*intAttackPower))+" damage!");
										con4.sleep(2000);
									}
							
									con4.sleep(2500);
								}
								
								// User Wins
							
								if (intHP>intZubatHP){
									dblLevel=dblLevel+0.1;
									con4.clear();
									con4.println("\n");
									con4.print("   The opposing "+strEnemy+" fainted!");
									con4.println("                            "+intHP+"/"+intHPMax);
									con4.println("\n");
									con4.println("                                                                         "+intAttackPower); 
									con4.println("\n");
									con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
									con4.println("\n\n");
									con4.println("                                                                    "+strEnemy);
									con4.println("\n");
									con4.println("                                                                   "+intZubatHP+"/25");
									con4.println("\n");
									con4.println("                                                                        "+intAttackPowerZUBAT);
								
									con4.sleep(2500);
									intLocationX=intLocationX-1;
						
									intLocation[intLocationY][intLocationX]=0;
									intLocation[intLocationY][intLocationX+1]=1;
						
									imgSwitchA=con4.loadImage("Images_Pokemon_RPG/" + (strPokemon)+".png");
									con4.drawImage(imgSwitchA,intLocationX*20+150,(intLocationY)*20+100);
									con4.repaint();
									imgSwitchB=con4.loadImage("Images_Pokemon_RPG/Grass1.png");
									con4.drawImage(imgSwitchB,(intLocationX+1)*20+150,(intLocationY)*20+100);
									con4.repaint();
									con4.sleep(250);
								}
							
								// User Loses ~ Zubat Wins
								else {
									con4.clear();
									con4.println("\n");
									con4.print("     "+strPokemon+" fainted!");
									con4.println("                            "+intHP+"/"+intHPMax);
									con4.println("\n");
									con4.println("                                                                         "+intAttackPower); 
									con4.println("\n");
									con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
									con4.println("\n\n");
									con4.println("                                                                    "+strEnemy);
									con4.println("\n");
									con4.println("                                                                   "+intZubatHP+"/25");
									con4.println("\n");
									con4.println("                                                                        "+intAttackPowerZUBAT);
								//Pass through the rest of the loop and re-enter ~ will be read by the "Check 0 HP "IF" Block" and will be sent to the Healing Centre.
								}	
						
						
							//User encounters a Team Rocket Grunt
							} else if (intLocation[intLocationY][intLocationX-1]==10){
								con4.clear();
								con4.println("\n");
								con4.print("  A Team Rocket Challenger Approaches You!");
								con4.sleep(1500);
								con4.clear();
								con4.println("\n");
								con4.println("   They send out a Ghastly!");
								con4.println("                                   "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
							
								String strEnemy=("Ghastly");
								int intGhastlyHP=40;
								int intOptionUSER;
								int intOptionGHASTLY;
								int intAttackPowerGHASTLY=10;
							
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intGhastlyHP+"/40");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerGHASTLY);
							
								con4.sleep(2000);
							
								while (intHP>0 && intGhastlyHP>0){
									intOptionUSER=0;
									intOptionGHASTLY=0;
									int intRandom=9;
								
									// Keep asking user for input until a proper selection is chosen (1,2,or 3). 
									while (intOptionUSER!=49 && intOptionUSER!=50 && intOptionUSER!=51){
										con4.clear();
										con4.println("\n");
										con4.print("      Press 1 to attack, 2 to heal 5HP, 3 to defend");
										con4.println("                    "+intHP+"/"+intHPMax);
										con4.println("\n");
										con4.println("                                                                         "+intAttackPower); 
										con4.println("\n");
										con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
										con4.println("\n\n");
										con4.println("                                                                    "+strEnemy);
										con4.println("\n");
										con4.println("                                                                   "+intGhastlyHP+"/40");
										con4.println("\n");
										con4.println("                                                                        "+intAttackPowerGHASTLY);
									
										intOptionUSER=con4.getKey();
									}
								
									if (intOptionUSER==49){
										intOptionUSER=1;
									} else if (intOptionUSER==50){
										intOptionUSER=2;
									} else {
										intOptionUSER=3;
									}
								
									// Generate 3 random numbers with equal probability (uniform) distributions; since we should only have 9 since 9%3 = 0, 0 inclusive; 9 as a value will be rejected. 
									while (intRandom==9){
										intRandom=(int)((Math.random())*10);
									}
								
									if (intRandom>=0 && intRandom<=2){
										intOptionGHASTLY=1;
									} else if (intRandom>=3 && intRandom<=5){
										intOptionGHASTLY=2;
									} else if (intRandom>=6 && intRandom<=9){
										intOptionGHASTLY=3;
									}
								
									con4.sleep(1500);
								
									// Same Move vs. Same Move (Nothing Happens)
									if (intOptionGHASTLY==intOptionUSER){
										con4.clear();
										con4.println("\n");
										con4.println("      Your pokemon did the same move as ");
										con4.sleep(2000);
										con4.clear();
										con4.println("\n");
										con4.println("     "+strEnemy+" , nothing happened!");
										con4.sleep(2000);
									}
								
									// Attack vs. Heal (Attack Wins)
									else if (intOptionUSER==1 && intOptionGHASTLY==2){
										intGhastlyHP=intGhastlyHP-intAttackPower;
										con4.clear();
										con4.println("\n");
										con4.println("   Your pokemon dealt "+intAttackPower+" DMG to "+strEnemy+"!");
										con4.sleep(2000);
									}
								
									else if (intOptionUSER==2 && intOptionGHASTLY==1){
										intHP=intHP-intAttackPowerGHASTLY;
										con4.clear();
										con4.println("\n");
										con4.println("    "+strEnemy+" dealt "+intAttackPowerGHASTLY+" damage to your pokemon!");
										con4.sleep(2000);
									} 
								
									//Heal vs. Defend (Heal Wins ~ Defend is Useless / Does Nothing)
									else if (intOptionUSER==2 && intOptionGHASTLY==3){
										intHP=intHP+5;
										con4.clear();
										con4.println("\n");
										con4.println("    You healed 5 HP!");
										con4.sleep(2000);
									}
									else if (intOptionUSER==3 && intOptionGHASTLY==2){
										intGhastlyHP=intGhastlyHP+5;
										con4.clear();
										con4.println("\n");
										con4.println("   "+strEnemy+" healed 5 HP!");
										con4.sleep(2000);
									}
								
									//Attack vs. Defend (Defend Wins and Reflects Half or Full Damage)
									else if (intOptionUSER==3 && intOptionGHASTLY==1){
										if (strPokemon.equalsIgnoreCase("eevee")){
											intGhastlyHP=intGhastlyHP-intAttackPowerGHASTLY;
											con4.clear();
											con4.println("\n");
											con4.println("   You reflected "+intAttackPowerGHASTLY+" back to "+strEnemy+"!");
											con4.sleep(2000);
										} else {
											intGhastlyHP=intGhastlyHP-(int)(0.5*intAttackPowerGHASTLY);
											con4.clear();
											con4.println("\n");
											con4.println("   You reflected "+(int)(0.5*(intAttackPowerGHASTLY))+" back to "+strEnemy+"!");
											con4.sleep(2000);
										}
									}
								
									else if (intOptionUSER==1 && intOptionGHASTLY==3){
										intHP=(intHP)-(int)(0.5*intAttackPower);
										con4.clear();
										con4.println("\n");
										con4.println("   "+strEnemy+" reflected "+strPokemon+"'s hit for "+((int)(0.5*intAttackPower))+" damage!");
										con4.sleep(2000);
									}
							
									con4.sleep(2500);
								}
								
								//User Wins
							
								if (intHP>intGhastlyHP){
									dblLevel=dblLevel+0.1;
									con4.clear();
									con4.println("\n");
									con4.print("   The opposing "+strEnemy+" fainted!");
									con4.println("                                   "+intHP+"/"+intHPMax);
									con4.println("\n");
									con4.println("                                                                         "+intAttackPower); 
									con4.println("\n");
									con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
									con4.println("\n\n");
									con4.println("                                                                    "+strEnemy);
									con4.println("\n");
									con4.println("                                                                   "+intGhastlyHP+"/40");
									con4.println("\n");
									con4.println("                                                                        "+intAttackPowerGHASTLY);
									
									con4.sleep(2500);
									intLocationX=intLocationX-1;
						
									intLocation[intLocationY][intLocationX]=0;
									intLocation[intLocationY][intLocationX+1]=1;
						
									imgSwitchA=con4.loadImage("Images_Pokemon_RPG/" + (strPokemon)+".png");
									con4.drawImage(imgSwitchA,intLocationX*20+150,(intLocationY)*20+100);
									con4.repaint();
									imgSwitchB=con4.loadImage("Images_Pokemon_RPG/Grass1.png");
									con4.drawImage(imgSwitchB,(intLocationX+1)*20+150,(intLocationY)*20+100);
									con4.repaint();
									con4.sleep(250);
								}
							
								//User Loses ~ Ghastly Wins
								else {
									con4.clear();
									con4.println("\n");
									con4.print("     "+strPokemon+" fainted!");
									con4.println("                                   "+intHP+"/"+intHPMax);
									con4.println("\n");
									con4.println("                                                                         "+intAttackPower); 
									con4.println("\n");
									con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
									con4.println("\n\n");
									con4.println("                                                                    "+strEnemy);
									con4.println("\n");
									con4.println("                                                                   "+intGhastlyHP+"/40");
									con4.println("\n");
									con4.println("                                                                        "+intAttackPowerGHASTLY);
								//Pass through the rest of the loop and re-enter ~ will be read by the "Check 0 HP "IF" Block" and will be sent to the Healing Centre.
								}
							}
						
						
							//User encounters Jessie.
							else if (intLocation[intLocationY][intLocationX-1]==11){
								con4.clear();
								con4.println("\n");
								con4.print("  It's Team Rocket Jessie!");
								con4.sleep(1500);
								con4.clear();
								con4.println("\n");
								con4.println("   She sends out Ekans!");
								con4.println("                                   "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
							
								String strEnemy=("Ekans");
								int intEkansHP=50;
								int intOptionUSER;
								int intOptionEkans;
								int intAttackPowerEkans=15;
							
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intEkansHP+"/50");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerEkans);
							
								con4.sleep(2000);
							
								while (intHP>0 && intEkansHP>0){
									intOptionUSER=0;
									intOptionEkans=0;
									int intRandom=9;
								
									// Keep asking user for input until a proper selection is chosen (1,2,or 3). 
									while (intOptionUSER!=49 && intOptionUSER!=50 && intOptionUSER!=51){
										con4.clear();
										con4.println("\n");
										con4.print("      Press 1 to attack, 2 to heal 5HP, 3 to defend");
										con4.println("                    "+intHP+"/"+intHPMax);
										con4.println("\n");
										con4.println("                                                                         "+intAttackPower); 
										con4.println("\n");
										con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
										con4.println("\n\n");
										con4.println("                                                                    "+strEnemy);
										con4.println("\n");
										con4.println("                                                                   "+intEkansHP+"/50");
										con4.println("\n");
										con4.println("                                                                        "+intAttackPowerEkans);
									
										intOptionUSER=con4.getKey();
									}
									
									if (intOptionUSER==49){
										intOptionUSER=1;
									} else if (intOptionUSER==50){
										intOptionUSER=2;
									} else {
										intOptionUSER=3;
									}
								
									// Generate 3 random numbers with equal probability (uniform) distributions; since we should only have 9 since 9%3 = 0, 0 inclusive; 9 as a value will be rejected. 
									while (intRandom==9){
										intRandom=(int)((Math.random())*10);
									}
								
									if (intRandom>=0 && intRandom<=2){
										intOptionEkans=1;
									} else if (intRandom>=3 && intRandom<=5){
										intOptionEkans=2;
									} else if (intRandom>=6 && intRandom<=9){
										intOptionEkans=3;
									}
								
									con4.sleep(1500);
								
									// Same Move vs. Same Move (Nothing Happens)
									if (intOptionEkans==intOptionUSER){
										con4.clear();
										con4.println("\n");
										con4.println("      Your pokemon did the same move as ");
										con.sleep(2000);
										con4.clear();
										con4.println("\n");
										con4.println("     "+strEnemy+" , nothing happened!");
										con4.sleep(2000);
									}
								
									// Attack vs. Heal (Attack Wins)
									else if (intOptionUSER==1 && intOptionEkans==2){
										intEkansHP=intEkansHP-intAttackPower;
										con4.clear();
										con4.println("\n");
										con4.println("   Your pokemon dealt "+intAttackPower+" DMG to "+strEnemy+"!");
										con4.sleep(2000);
									}
								
									else if (intOptionUSER==2 && intOptionEkans==1){
										intHP=intHP-intAttackPowerEkans;
										con4.clear();
										con4.println("\n");
										con4.println("    "+strEnemy+" dealt "+intAttackPowerEkans+" damage to your pokemon!");
										con4.sleep(2000);
									} 
								
									//Heal vs. Defend (Heal Wins ~ Defend is Useless / Does Nothing)
									else if (intOptionUSER==2 && intOptionEkans==3){
										intHP=intHP+5;
										con4.clear();
										con4.println("\n");
										con4.println("    You healed 5 HP!");
										con4.sleep(2000);
									}
									else if (intOptionUSER==3 && intOptionEkans==2){
										intEkansHP=intEkansHP+5;
										con4.clear();
										con4.println("\n");
										con4.println("   "+strEnemy+" healed 5 HP!");
										con4.sleep(2000);
									}
								
									// Attack vs. Defend (Defend Wins and Reflects Half or Full Damage)
									else if (intOptionUSER==3 && intOptionEkans==1){
										if (strPokemon.equalsIgnoreCase("eevee")){
											intEkansHP=intEkansHP-intAttackPowerEkans;
											con4.clear();
											con4.println("\n");
											con4.println("   You reflected "+intAttackPowerEkans+" back to "+strEnemy+"!");
											con4.sleep(2000);
										} else {
											intEkansHP=intEkansHP-(int)(0.5*intAttackPowerEkans);
											con4.clear();
											con4.println("\n");
											con4.println("   You reflected "+(int)(0.5*(intAttackPowerEkans))+" back to "+strEnemy+"!");
											con4.sleep(2000);
										}
									}
								
									else if (intOptionUSER==1 && intOptionEkans==3){
										intHP=(intHP)-(int)(0.5*intAttackPower);
										con4.clear();
										con4.println("\n");
										con4.println("   "+strEnemy+" reflected "+strPokemon+"'s hit for "+((int)(0.5*intAttackPower))+" damage!");
										con4.sleep(2000);
									}
							
									con4.sleep(2500);
								}
								
								// User Wins
							
								if (intHP>intEkansHP){
									dblLevel=dblLevel+0.1;
									con4.clear();
									con4.println("\n");
									con4.print("   The opposing "+strEnemy+" fainted!");
									con4.sleep(1500);
								
									intHPMax = intHPMax+10;
									intAttackPower = intAttackPower+10;
								
									con4.clear();
									con4.println("\n");
									con4.print("   Your HP Max increased by 10.");
									con4.sleep(2000);
								
									con4.clear();
									con4.println("\n");
									con4.print("   Your Attack Power increased by 10.");
									con4.sleep(2000);
								
									con4.println("                                   "+intHP+"/"+intHPMax);
									con4.println("\n");
									con4.println("                                                                         "+intAttackPower); 
									con4.println("\n");
									con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
									con4.println("\n\n");
									con4.println("                                                                    "+strEnemy);
									con4.println("\n");
									con4.println("                                                                   "+intEkansHP+"/50");
									con4.println("\n");
									con4.println("                                                                        "+intAttackPowerEkans);
								
									con4.sleep(2500);
									intLocationX=intLocationX-1;
						
									intLocation[intLocationY][intLocationX]=0;
									intLocation[intLocationY][intLocationX+1]=1;
						
									imgSwitchA=con4.loadImage("Images_Pokemon_RPG/" + (strPokemon)+".png");
									con4.drawImage(imgSwitchA,intLocationX*20+150,(intLocationY)*20+100);
									con4.repaint();
									imgSwitchB=con4.loadImage("Images_Pokemon_RPG/Grass1.png");
									con4.drawImage(imgSwitchB,(intLocationX+1)*20+150,(intLocationY)*20+100);
									con4.repaint();
									con4.sleep(250);
								}
							
							//User Loses ~ Ekans Wins
							else {
								con4.clear();
								con4.println("\n");
								con4.print("     "+strPokemon+" fainted!");
								con4.println("                                  "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intEkansHP+"/50");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerEkans);
							//Pass through the rest of the loop and re-enter ~ will be read by the "Check 0 HP "IF" Block" and will be sent to the Healing Centre.
							}
						}
						
						//User encounters James.
						else if (intLocation[intLocationY][intLocationX-1]==12){
							con4.clear();
							con4.println("\n");
							con4.print("  It's Team Rocket James!");
							con4.sleep(1500);
							con4.clear();
							con4.println("\n");
							con4.println("   He sends out Meowth!");
							con4.println("                                   "+intHP+"/"+intHPMax);
							con4.println("\n");
							con4.println("                                                                         "+intAttackPower); 
							con4.println("\n");
							con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
							
							String strEnemy=("Meowth");
							int intMeowthHP=50;
							int intOptionUSER;
							int intOptionMeowth;
							int intAttackPowerMeowth=15;
							
							con4.println("\n\n");
							con4.println("                                                                    "+strEnemy);
							con4.println("\n");
							con4.println("                                                                   "+intMeowthHP+"/50");
							con4.println("\n");
							con4.println("                                                                        "+intAttackPowerMeowth);
							
							con4.sleep(2000);
							
							while (intHP>0 && intMeowthHP>0){
								intOptionUSER=0;
								intOptionMeowth=0;
								int intRandom=9;
								
								//Keep asking user for input until a proper selection is chosen (1,2,or 3). 
								while (intOptionUSER!=49 && intOptionUSER!=50 && intOptionUSER!=51){
									con4.clear();
									con4.println("\n");
									con4.print("      Press 1 to attack, 2 to heal 5HP, 3 to defend");
									con4.println("                    "+intHP+"/"+intHPMax);
									con4.println("\n");
									con4.println("                                                                         "+intAttackPower); 
									con4.println("\n");
									con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
									con4.println("\n\n");
									con4.println("                                                                    "+strEnemy);
									con4.println("\n");
									con4.println("                                                                   "+intMeowthHP+"/50");
									con4.println("\n");
									con4.println("                                                                        "+intAttackPowerMeowth);
									
									intOptionUSER=con4.getKey();
								}
								
								if (intOptionUSER==49){
									intOptionUSER=1;
								} else if (intOptionUSER==50){
									intOptionUSER=2;
								} else {
									intOptionUSER=3;
								}
								
								//Generate 3 random numbers with equal probability (uniform) distributions; since we should only have 9 since 9%3 = 0, 0 inclusive; 9 as a value will be rejected. 
								while (intRandom==9){
									intRandom=(int)((Math.random())*10);
								}
								
								if (intRandom>=0 && intRandom<=2){
									intOptionMeowth=1;
								} else if (intRandom>=3 && intRandom<=5){
									intOptionMeowth=2;
								} else if (intRandom>=6 && intRandom<=9){
									intOptionMeowth=3;
								}
								
								con4.sleep(1500);
								
								//Same Move vs. Same Move (Nothing Happens)
								if (intOptionMeowth==intOptionUSER){
									con4.clear();
									con4.println("\n");
									con4.println("      Your pokemon did the same move as ");
									con4.sleep(2000);
									con4.clear();
									con4.println("\n");
									con4.println("     "+strEnemy+" , nothing happened!");
									con4.sleep(2000);
								}
								
								//Attack vs. Heal (Attack Wins)
								else if (intOptionUSER==1 && intOptionMeowth==2){
									intMeowthHP=intMeowthHP-intAttackPower;
									con4.clear();
									con4.println("\n");
									con4.println("   Your pokemon dealt "+intAttackPower+" DMG to "+strEnemy+"!");
									con4.sleep(2000);
								}
								
								else if (intOptionUSER==2 && intOptionMeowth==1){
									intHP=intHP-intAttackPowerMeowth;
									con4.clear();
									con4.println("\n");
									con4.println("    "+strEnemy+" dealt "+intAttackPowerMeowth+" damage to your pokemon!");
									con4.sleep(2000);
								} 
								
								//Heal vs. Defend (Heal Wins ~ Defend is Useless / Does Nothing)
								else if (intOptionUSER==2 && intOptionMeowth==3){
									intHP=intHP+5;
									con4.clear();
									con4.println("\n");
									con4.println("    You healed 5 HP!");
									con4.sleep(2000);
								}
								else if (intOptionUSER==3 && intOptionMeowth==2){
									intMeowthHP=intMeowthHP+5;
									con4.clear();
									con4.println("\n");
									con4.println("   "+strEnemy+" healed 5 HP!");
									con4.sleep(2000);
								}
								
								//Attack vs. Defend (Defend Wins and Reflects Half or Full Damage)
								else if (intOptionUSER==3 && intOptionMeowth==1){
									if (strPokemon.equalsIgnoreCase("eevee")){
										intMeowthHP=intMeowthHP-intAttackPowerMeowth;
										con4.clear();
										con4.println("\n");
										con4.println("   You reflected "+intAttackPowerMeowth+" back to "+strEnemy+"!");
										con4.sleep(2000);
									} else {
										intMeowthHP=intMeowthHP-(int)(0.5*intAttackPowerMeowth);
										con4.clear();
										con4.println("\n");
										con4.println("   You reflected "+(int)(0.5*(intAttackPowerMeowth))+" back to "+strEnemy+"!");
										con4.sleep(2000);
									}
								}
								
								else if (intOptionUSER==1 && intOptionMeowth==3){
									intHP=(intHP)-(int)(0.5*intAttackPower);
									con4.clear();
									con4.println("\n");
									con4.println("   "+strEnemy+" reflected "+strPokemon+"'s hit for "+((int)(0.5*intAttackPower))+" damage!");
									con4.sleep(2000);
								}
							
								con4.sleep(2500);
							}
								
							//User Wins
							
							if (intHP>intMeowthHP){
								dblLevel=dblLevel+0.1;
								con4.clear();
								con4.println("\n");
								con4.print("   The opposing "+strEnemy+" fainted!");
								con4.sleep(1500);
								
								intHPMax = intHPMax+10;
								intAttackPower = intAttackPower+10;
								
								con4.clear();
								con4.println("\n");
								con4.print("   Your HP Max increased by 10.");
								con4.sleep(2000);
								
								con4.clear();
								con4.println("\n");
								con4.print("   Your Attack Power increased by 10.");
								con4.sleep(2000);
								
								con4.println("                               "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intMeowthHP+"/50");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerMeowth);
								
								con4.sleep(2500);
								intLocationX=intLocationX-1;
						
								intLocation[intLocationY][intLocationX]=0;
								intLocation[intLocationY][intLocationX+1]=1;
						
								imgSwitchA=con4.loadImage("Images_Pokemon_RPG/" + (strPokemon)+".png");
								con4.drawImage(imgSwitchA,intLocationX*20+150,(intLocationY)*20+100);
								con4.repaint();
								imgSwitchB=con4.loadImage("Images_Pokemon_RPG/Grass1.png");
								con4.drawImage(imgSwitchB,(intLocationX+1)*20+150,(intLocationY)*20+100);
								con4.repaint();
								con4.sleep(250);
							}
							
							//User Loses ~ Meowth Wins
							else {
								con4.clear();
								con4.println("\n");
								con4.print("     "+strPokemon+" fainted!");
								con4.println("                               "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intMeowthHP+"/50");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerMeowth);
							//Pass through the rest of the loop and re-enter ~ will be read by the "Check 0 HP "IF" Block" and will be sent to the Healing Centre.
							}
						}
					}
						
					
					
					//(s or down Arrow) Down
					else if (intMove==83 || intMove==40){
						if (((intLocationY+1)<=19) && (intLocation[intLocationY+1][intLocationX]==1)){
							
							intLocationY=intLocationY+1;
						
							intLocation[intLocationY][intLocationX]=0;
							intLocation[intLocationY-1][intLocationX]=1;
						
							imgSwitchA=con4.loadImage("Images_Pokemon_RPG/" + (strPokemon)+".png");
							con4.drawImage(imgSwitchA,(intLocationX)*20+150,(intLocationY)*20+100);
							con4.repaint();
							imgSwitchB=con4.loadImage("Images_Pokemon_RPG/Grass1.png");
							con4.drawImage(imgSwitchB,(intLocationX)*20+150,(intLocationY-1)*20+100);
							con4.repaint();
							con4.sleep(250);
						}
						//User attempts to walk into Healing Centre
						else if (intLocation[intLocationY+1][intLocationX]==5 || intLocation[intLocationY+1][intLocationX]==6 || intLocation[intLocationY+1][intLocationX]==7 || intLocation[intLocationY+1][intLocationX]==8){
							intHP=intHPMax;
							con4.clear();
							con4.println("\n");
							con4.println("             "+strPokemon+"'s HP has been fully healed.");
							con4.sleep(1000);
							con4.clear();
							con4.println("\n");
							con4.println("             Thanks for visiting Poké Hospital!");
							con4.clear();
							
						} 
						//User walks into Water (Drowns)
						else if (intLocation[intLocationY+1][intLocationX]==4){
							con4.clear();
							intHP=0;

							con4.println("\n");
							con4.println("                 Oops! "+strPokemon+" drowned!                                "+intHP+"/"+intHPMax);
							con4.println("\n");
							con4.println("                                                                         "+intAttackPower); 
							con4.println("\n");
							con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10"); 
							con4.sleep(2000);	
						}
						
						//User encounters a Wild Zubat
						else if (intLocation[intLocationY+1][intLocationX]==9){
							con4.clear();
							con4.println("\n");
							con4.print("             A wild Zubat appeared!");
							con4.println("                                   "+intHP+"/"+intHPMax);
							con4.println("\n");
							con4.println("                                                                         "+intAttackPower); 
							con4.println("\n");
							con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
							
							String strEnemy=("Zubat");
							int intZubatHP=25;
							int intOptionUSER;
							int intOptionZUBAT;
							int intAttackPowerZUBAT=5;
							
							con4.println("\n\n");
							con4.println("                                                                    "+strEnemy);
							con4.println("\n");
							con4.println("                                                                   "+intZubatHP+"/25");
							con4.println("\n");
							con4.println("                                                                        "+intAttackPowerZUBAT);
							
							con4.sleep(2000);
							
							while (intHP>0 && intZubatHP>0){
								intOptionUSER=0;
								intOptionZUBAT=0;
								int intRandom=9;
								
								//Keep asking user for input until a proper selection is chosen (1,2,or 3). 
								while (intOptionUSER!=49 && intOptionUSER!=50 && intOptionUSER!=51){
									con4.clear();
									con4.println("\n");
									con4.print("      Press 1 to attack, 2 to heal 5HP, 3 to defend");
									con4.println("                    "+intHP+"/"+intHPMax);
									con4.println("\n");
									con4.println("                                                                         "+intAttackPower); 
									con4.println("\n");
									con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
									con4.println("\n\n");
									con4.println("                                                                    "+strEnemy);
									con4.println("\n");
									con4.println("                                                                   "+intZubatHP+"/25");
									con4.println("\n");
									con4.println("                                                                        "+intAttackPowerZUBAT);
									
									intOptionUSER=con4.getKey();
								}
								
								if (intOptionUSER==49){
									intOptionUSER=1;
								} else if (intOptionUSER==50){
									intOptionUSER=2;
								} else {
									intOptionUSER=3;
								}
								
								//Generate 3 random numbers with equal probability (uniform) distributions; since we should only have 9 since 9%3 = 0, 0 inclusive; 9 as a value will be rejected. 
								while (intRandom==9){
									intRandom=(int)((Math.random())*10);
								}
								
								if (intRandom>=0 && intRandom<=2){
									intOptionZUBAT=1;
								} else if (intRandom>=3 && intRandom<=5){
									intOptionZUBAT=2;
								} else if (intRandom>=6 && intRandom<=9){
									intOptionZUBAT=3;
								}
								
								con4.sleep(1500);
								
								//Same Move vs. Same Move (Nothing Happens)
								if (intOptionZUBAT==intOptionUSER){
									con4.clear();
									con4.println("\n");
									con4.println("      Your pokemon did the same move as ");
									con4.sleep(2000);
									con4.clear();
									con4.println("\n");
									con4.println("     "+strEnemy+" , nothing happened!");
									con4.sleep(2000);
								}
								
								//Attack vs. Heal (Attack Wins)
								else if (intOptionUSER==1 && intOptionZUBAT==2){
									intZubatHP=intZubatHP-intAttackPower;
									con4.clear();
									con4.println("\n");
									con4.println("   Your pokemon dealt "+intAttackPower+" DMG to "+strEnemy+"!");
									con4.sleep(2000);
								}
								
								else if (intOptionUSER==2 && intOptionZUBAT==1){
									intHP=intHP-intAttackPowerZUBAT;
									con4.clear();
									con4.println("\n");
									con4.println("    "+strEnemy+" dealt "+intAttackPowerZUBAT+" damage to your pokemon!");
									con4.sleep(2000);
								} 
								
								//Heal vs. Defend (Heal Wins ~ Defend is Useless / Does Nothing)
								else if (intOptionUSER==2 && intOptionZUBAT==3){
									intHP=intHP+5;
									con4.clear();
									con4.println("\n");
									con4.println("    You healed 5 HP!");
									con4.sleep(2000);
								}
								else if (intOptionUSER==3 && intOptionZUBAT==2){
									intZubatHP=intZubatHP+5;
									con4.clear();
									con4.println("\n");
									con4.println("   "+strEnemy+" healed 5 HP!");
									con4.sleep(2000);
								}
								
								//Attack vs. Defend (Defend Wins and Reflects Half or Full Damage)
								else if (intOptionUSER==3 && intOptionZUBAT==1){
									if (strPokemon.equalsIgnoreCase("eevee")){
										intZubatHP=intZubatHP-intAttackPowerZUBAT;
										con4.clear();
										con4.println("\n");
										con4.println("   You reflected "+intAttackPowerZUBAT+" back to "+strEnemy+"!");
										con4.sleep(2000);
									} else {
										intZubatHP=intZubatHP-(int)(0.5*intAttackPowerZUBAT);
										con4.clear();
										con4.println("\n");
										con4.println("   You reflected "+(int)(0.5*(intAttackPowerZUBAT))+" back to "+strEnemy+"!");
										con4.sleep(2000);
									}
								}
								
								else if (intOptionUSER==1 && intOptionZUBAT==3){
									intHP=(intHP)-(int)(0.5*intAttackPower);
									con4.clear();
									con4.println("\n");
									con4.println("   "+strEnemy+" reflected "+strPokemon+"'s hit for "+((int)(0.5*intAttackPower))+" damage!");
									con4.sleep(2000);
								}
							
								con4.sleep(2500);
							}
								
							//User Wins
							
							if (intHP>intZubatHP){
								dblLevel=dblLevel+0.1;
								con4.clear();
								con4.println("\n");
								con4.print("   The opposing "+strEnemy+" fainted!");
								con4.println("                            "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intZubatHP+"/25");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerZUBAT);
								
								con4.sleep(2500);
								intLocationY=intLocationY+1;
						
								intLocation[intLocationY][intLocationX]=0;
								intLocation[intLocationY-1][intLocationX]=1;
						
								imgSwitchA=con4.loadImage("Images_Pokemon_RPG/" + (strPokemon)+".png");
								con4.drawImage(imgSwitchA, intLocationX * 20 + 150, (intLocationY) * 20 + 100);
								con4.repaint();
								imgSwitchB=con4.loadImage("Images_Pokemon_RPG/Grass1.png");
								con4.drawImage(imgSwitchB,(intLocationX)*20+150,(intLocationY-1)*20+100);
								con4.repaint();
								con4.sleep(250);
							}
							
							//User Loses ~ Zubat Wins
							else {
								con4.clear();
								con4.println("\n");
								con4.print("     "+strPokemon+" fainted!");
								con4.println("                            "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intZubatHP+"/25");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerZUBAT);
							//Pass through the rest of the loop and re-enter ~ will be read by the "Check 0 HP "IF" Block" and will be sent to the Healing Centre.
							}
						}	
						
						
						//User encounters a Team Rocket Grunt
						else if (intLocation[intLocationY+1][intLocationX] == 10){
							con4.clear();
							con4.println("\n");
							con4.print("  A Team Rocket Challenger Approaches You!");
							con4.sleep(1500);
							con4.clear();
							con4.println("\n");
							con4.println("   They send out a Ghastly!");
							con4.println("                                   "+intHP+"/"+intHPMax);
							con4.println("\n");
							con4.println("                                                                         "+intAttackPower); 
							con4.println("\n");
							con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
							
							String strEnemy=("Ghastly");
							int intGhastlyHP = 40;
							int intOptionUSER;
							int intOptionGHASTLY;
							int intAttackPowerGHASTLY = 10;
							
							con4.println("\n\n");
							con4.println("                                                                    "+strEnemy);
							con4.println("\n");
							con4.println("                                                                   "+intGhastlyHP+"/40");
							con4.println("\n");
							con4.println("                                                                        "+intAttackPowerGHASTLY);
							
							con4.sleep(2000);
							
							while (intHP>0 && intGhastlyHP>0){
								intOptionUSER=0;
								intOptionGHASTLY=0;
								int intRandom=9;
								
								// Keep asking user for input until a proper selection is chosen (1,2,or 3). 
								while (intOptionUSER!=49 && intOptionUSER!=50 && intOptionUSER!=51){
									con4.clear();
									con4.println("\n");
									con4.print("      Press 1 to attack, 2 to heal 5HP, 3 to defend");
									con4.println("                    "+intHP+"/"+intHPMax);
									con4.println("\n");
									con4.println("                                                                         "+intAttackPower); 
									con4.println("\n");
									con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
									con4.println("\n\n");
									con4.println("                                                                    "+strEnemy);
									con4.println("\n");
									con4.println("                                                                   "+intGhastlyHP+"/40");
									con4.println("\n");
									con4.println("                                                                        "+intAttackPowerGHASTLY);
									
									intOptionUSER=con4.getKey();
								}
								
								if (intOptionUSER == 49){
									intOptionUSER = 1;
								} else if (intOptionUSER == 50){
									intOptionUSER = 2;
								} else {
									intOptionUSER = 3;
								}
								
								// Generate 3 random numbers with equal probability (uniform) distributions; since we should only have 9 since 9%3 = 0, 0 inclusive; 9 as a value will be rejected. 
								while (intRandom==9){
									intRandom=(int)((Math.random())*10);
								}
								
								if (intRandom>=0 && intRandom<=2){
									intOptionGHASTLY=1;
								} else if (intRandom>=3 && intRandom<=5){
									intOptionGHASTLY=2;
								} else if (intRandom>=6 && intRandom<=9){
									intOptionGHASTLY=3;
								}
								
								con4.sleep(1500);
								
								// Same Move vs. Same Move (Nothing Happens)
								if (intOptionGHASTLY==intOptionUSER){
									con4.clear();
									con4.println("\n");
									con4.println("      Your pokemon did the same move as ");
									con4.sleep(2000);
									con4.clear();
									con4.println("\n");
									con4.println("     "+strEnemy+" , nothing happened!");
									con4.sleep(2000);
								}
								
								// Attack vs. Heal (Attack Wins)
								else if (intOptionUSER==1 && intOptionGHASTLY==2){
									intGhastlyHP=intGhastlyHP-intAttackPower;
									con4.clear();
									con4.println("\n");
									con4.println("   Your pokemon dealt "+intAttackPower+" DMG to "+strEnemy+"!");
									con4.sleep(2000);
								}
								
								else if (intOptionUSER==2 && intOptionGHASTLY==1){
									intHP=intHP-intAttackPowerGHASTLY;
									con4.clear();
									con4.println("\n");
									con4.println("    "+strEnemy+" dealt "+intAttackPowerGHASTLY+" damage to your pokemon!");
									con4.sleep(2000);
								} 
								
								// Heal vs. Defend (Heal Wins ~ Defend is Useless / Does Nothing)
								else if (intOptionUSER==2 && intOptionGHASTLY==3){
									intHP=intHP+5;
									con4.clear();
									con4.println("\n");
									con4.println("    You healed 5 HP!");
									con4.sleep(2000);
								}
								else if (intOptionUSER==3 && intOptionGHASTLY==2){
									intGhastlyHP=intGhastlyHP+5;
									con4.clear();
									con4.println("\n");
									con4.println("   "+strEnemy+" healed 5 HP!");
									con4.sleep(2000);
								}
								
								// Attack vs. Defend (Defend Wins and Reflects Half or Full Damage)
								else if (intOptionUSER==3 && intOptionGHASTLY==1){
									if (strPokemon.equalsIgnoreCase("eevee")){
										intGhastlyHP=intGhastlyHP-intAttackPowerGHASTLY;
										con4.clear();
										con4.println("\n");
										con4.println("   You reflected "+intAttackPowerGHASTLY+" back to "+strEnemy+"!");
										con4.sleep(2000);
									} else {
										intGhastlyHP=intGhastlyHP-(int)(0.5*intAttackPowerGHASTLY);
										con4.clear();
										con4.println("\n");
										con4.println("   You reflected "+(int)(0.5*(intAttackPowerGHASTLY))+" back to "+strEnemy+"!");
										con4.sleep(2000);
									}
								}
								
								else if (intOptionUSER==1 && intOptionGHASTLY==3){
									intHP=(intHP)-(int)(0.5*intAttackPower);
									con4.clear();
									con4.println("\n");
									con4.println("   "+strEnemy+" reflected "+strPokemon+"'s hit for "+((int)(0.5*intAttackPower))+" damage!");
									con4.sleep(2000);
								}
							
								con4.sleep(2500);
							}
								
							//User Wins
							
							if (intHP>intGhastlyHP){
								dblLevel=dblLevel+0.1;
								con4.clear();
								con4.println("\n");
								con4.print("   The opposing "+strEnemy+" fainted!");
								con4.println("                                   "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intGhastlyHP+"/40");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerGHASTLY);
								
								con4.sleep(2500);
								intLocationY=intLocationY+1;
						
								intLocation[intLocationY][intLocationX]=0;
								intLocation[intLocationY-1][intLocationX]=1;
						
								imgSwitchA=con4.loadImage("Images_Pokemon_RPG/" + (strPokemon)+".png");
								con4.drawImage(imgSwitchA,intLocationX*20+150,(intLocationY)*20+100);
								con4.repaint();
								imgSwitchB=con4.loadImage("Images_Pokemon_RPG/Grass1.png");
								con4.drawImage(imgSwitchB,(intLocationX)*20+150,(intLocationY-1)*20+100);
								con4.repaint();
								con4.sleep(250);
							}
							
							//User Loses ~ Ghastly Wins
							else {
								con4.clear();
								con4.println("\n");
								con4.print("     "+strPokemon+" fainted!");
								con4.println("                                   "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intGhastlyHP+"/40");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerGHASTLY);
							//Pass through the rest of the loop and re-enter ~ will be read by the "Check 0 HP "IF" Block" and will be sent to the Healing Centre.
							}
						}
						
						
						//User encounters Jessie.
						else if (intLocation[intLocationY+1][intLocationX]==11){
							con4.clear();
							con4.println("\n");
							con4.print("  It's Team Rocket Jessie!");
							con4.sleep(1500);
							con4.clear();
							con4.println("\n");
							con4.println("   She sends out Ekans!");
							con4.println("                                   "+intHP+"/"+intHPMax);
							con4.println("\n");
							con4.println("                                                                         "+intAttackPower); 
							con4.println("\n");
							con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
							
							String strEnemy=("Ekans");
							int intEkansHP=50;
							int intOptionUSER;
							int intOptionEkans;
							int intAttackPowerEkans=15;
							
							con4.println("\n\n");
							con4.println("                                                                    "+strEnemy);
							con4.println("\n");
							con4.println("                                                                   "+intEkansHP+"/50");
							con4.println("\n");
							con4.println("                                                                        "+intAttackPowerEkans);
							
							con4.sleep(2000);
							
							while (intHP>0 && intEkansHP>0){
								intOptionUSER=0;
								intOptionEkans=0;
								int intRandom=9;
								
								//Keep asking user for input until a proper selection is chosen (1,2,or 3). 
								while (intOptionUSER!=49 && intOptionUSER!=50 && intOptionUSER!=51){
									con4.clear();
									con4.println("\n");
									con4.print("      Press 1 to attack, 2 to heal 5HP, 3 to defend");
									con4.println("                    "+intHP+"/"+intHPMax);
									con4.println("\n");
									con4.println("                                                                         "+intAttackPower); 
									con4.println("\n");
									con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
									con4.println("\n\n");
									con4.println("                                                                    "+strEnemy);
									con4.println("\n");
									con4.println("                                                                   "+intEkansHP+"/50");
									con4.println("\n");
									con4.println("                                                                        "+intAttackPowerEkans);
									
									intOptionUSER=con4.getKey();
								}
								
								if (intOptionUSER==49){
									intOptionUSER=1;
								} else if (intOptionUSER==50){
									intOptionUSER=2;
								} else {
									intOptionUSER=3;
								}
								
								//Generate 3 random numbers with equal probability (uniform) distributions; since we should only have 9 since 9%3 = 0, 0 inclusive; 9 as a value will be rejected. 
								while (intRandom==9){
									intRandom=(int)((Math.random())*10);
								}
								
								if (intRandom>=0 && intRandom<=2){
									intOptionEkans=1;
								} else if (intRandom>=3 && intRandom<=5){
									intOptionEkans=2;
								} else if (intRandom>=6 && intRandom<=9){
									intOptionEkans=3;
								}
								
								con4.sleep(1500);
								
								//Same Move vs. Same Move (Nothing Happens)
								if (intOptionEkans==intOptionUSER){
									con4.clear();
									con4.println("\n");
									con4.println("      Your pokemon did the same move as ");
									con.sleep(2000);
									con4.clear();
									con4.println("\n");
									con4.println("     "+strEnemy+" , nothing happened!");
									con4.sleep(2000);
								}
								
								//Attack vs. Heal (Attack Wins)
								else if (intOptionUSER==1 && intOptionEkans==2){
									intEkansHP=intEkansHP-intAttackPower;
									con4.clear();
									con4.println("\n");
									con4.println("   Your pokemon dealt "+intAttackPower+" DMG to "+strEnemy+"!");
									con4.sleep(2000);
								}
								
								else if (intOptionUSER==2 && intOptionEkans==1){
									intHP=intHP-intAttackPowerEkans;
									con4.clear();
									con4.println("\n");
									con4.println("    "+strEnemy+" dealt "+intAttackPowerEkans+" damage to your pokemon!");
									con4.sleep(2000);
								} 
								
								//Heal vs. Defend (Heal Wins ~ Defend is Useless / Does Nothing)
								else if (intOptionUSER==2 && intOptionEkans==3){
									intHP=intHP+5;
									con4.clear();
									con4.println("\n");
									con4.println("    You healed 5 HP!");
									con4.sleep(2000);
								}
								else if (intOptionUSER==3 && intOptionEkans==2){
									intEkansHP=intEkansHP+5;
									con4.clear();
									con4.println("\n");
									con4.println("   "+strEnemy+" healed 5 HP!");
									con4.sleep(2000);
								}
								
								//Attack vs. Defend (Defend Wins and Reflects Half or Full Damage)
								else if (intOptionUSER==3 && intOptionEkans==1){
									if (strPokemon.equalsIgnoreCase("eevee")){
										intEkansHP=intEkansHP-intAttackPowerEkans;
										con4.clear();
										con4.println("\n");
										con4.println("   You reflected "+intAttackPowerEkans+" back to "+strEnemy+"!");
										con4.sleep(2000);
									} else {
										intEkansHP=intEkansHP-(int)(0.5*intAttackPowerEkans);
										con4.clear();
										con4.println("\n");
										con4.println("   You reflected "+(int)(0.5*(intAttackPowerEkans))+" back to "+strEnemy+"!");
										con4.sleep(2000);
									}
								}
								
								else if (intOptionUSER==1 && intOptionEkans==3){
									intHP=(intHP)-(int)(0.5*intAttackPower);
									con4.clear();
									con4.println("\n");
									con4.println("   "+strEnemy+" reflected "+strPokemon+"'s hit for "+((int)(0.5*intAttackPower))+" damage!");
									con4.sleep(2000);
								}
							
								con4.sleep(2500);
							}
								
							//User Wins
							
							if (intHP>intEkansHP){
								dblLevel=dblLevel+0.1;
								con4.clear();
								con4.println("\n");
								con4.print("   The opposing "+strEnemy+" fainted!");
								con4.sleep(1500);
								
								intHPMax = intHPMax+10;
								intAttackPower = intAttackPower+10;
								
								con4.clear();
								con4.println("\n");
								con4.print("   Your HP Max increased by 10.");
								con4.sleep(2000);
								
								con4.clear();
								con4.println("\n");
								con4.print("   Your Attack Power increased by 10.");
								con4.sleep(2000);
								
								con4.println("                                   "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intEkansHP+"/50");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerEkans);
								
								con4.sleep(2500);
								intLocationY=intLocationY-1;
						
								intLocation[intLocationY][intLocationX]=0;
								intLocation[intLocationY+1][intLocationX]=1;
						
								imgSwitchA=con4.loadImage("Images_Pokemon_RPG/"+(strPokemon)+".png");
								con4.drawImage(imgSwitchA,intLocationX*20+150,(intLocationY)*20+100);
								con4.repaint();
								imgSwitchB=con4.loadImage("Images_Pokemon_RPG/Grass1.png");
								con4.drawImage(imgSwitchB,(intLocationX)*20+150,(intLocationY+1)*20+100);
								con4.repaint();
								con4.sleep(250);
							}
							
							//User Loses ~ Ekans Wins
							else {
								con4.clear();
								con4.println("\n");
								con4.print("     "+strPokemon+" fainted!");
								con4.println("                                  "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intEkansHP+"/50");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerEkans);
							//Pass through the rest of the loop and re-enter ~ will be read by the "Check 0 HP "IF" Block" and will be sent to the Healing Centre.
							}
						}
						
						//User encounters James.
						else if (intLocation[intLocationY-1][intLocationX]==12){
							con4.clear();
							con4.println("\n");
							con4.print("  It's Team Rocket James!");
							con4.sleep(1500);
							con4.clear();
							con4.println("\n");
							con4.println("   He sends out Meowth!");
							con4.println("                                   "+intHP+"/"+intHPMax);
							con4.println("\n");
							con4.println("                                                                         "+intAttackPower); 
							con4.println("\n");
							con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
							
							String strEnemy=("Meowth");
							int intMeowthHP=50;
							int intOptionUSER;
							int intOptionMeowth;
							int intAttackPowerMeowth=15;
							
							con4.println("\n\n");
							con4.println("                                                                    "+strEnemy);
							con4.println("\n");
							con4.println("                                                                   "+intMeowthHP+"/50");
							con4.println("\n");
							con4.println("                                                                        "+intAttackPowerMeowth);
							
							con4.sleep(2000);
							
							while (intHP>0 && intMeowthHP>0){
								intOptionUSER=0;
								intOptionMeowth=0;
								int intRandom=9;
								
								//Keep asking user for input until a proper selection is chosen (1,2,or 3). 
								while (intOptionUSER!=49 && intOptionUSER!=50 && intOptionUSER!=51){
									con4.clear();
									con4.println("\n");
									con4.print("      Press 1 to attack, 2 to heal 5HP, 3 to defend");
									con4.println("                    "+intHP+"/"+intHPMax);
									con4.println("\n");
									con4.println("                                                                         "+intAttackPower); 
									con4.println("\n");
									con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
									con4.println("\n\n");
									con4.println("                                                                    "+strEnemy);
									con4.println("\n");
									con4.println("                                                                   "+intMeowthHP+"/50");
									con4.println("\n");
									con4.println("                                                                        "+intAttackPowerMeowth);
									
									intOptionUSER=con4.getKey();
								}
								
								if (intOptionUSER==49){
									intOptionUSER=1;
								} else if (intOptionUSER==50){
									intOptionUSER=2;
								} else {
									intOptionUSER=3;
								}
								
								//Generate 3 random numbers with equal probability (uniform) distributions; since we should only have 9 since 9%3 = 0, 0 inclusive; 9 as a value will be rejected. 
								while (intRandom==9){
									intRandom=(int)((Math.random())*10);
								}
								
								if (intRandom>=0 && intRandom<=2){
									intOptionMeowth=1;
								} else if (intRandom>=3 && intRandom<=5){
									intOptionMeowth=2;
								} else if (intRandom>=6 && intRandom<=9){
									intOptionMeowth=3;
								}
								
								con4.sleep(1500);
								
								//Same Move vs. Same Move (Nothing Happens)
								if (intOptionMeowth==intOptionUSER){
									con4.clear();
									con4.println("\n");
									con4.println("      Your pokemon did the same move as ");
									con4.sleep(2000);
									con4.clear();
									con4.println("\n");
									con4.println("     "+strEnemy+" , nothing happened!");
									con4.sleep(2000);
								}
								
								// Attack vs. Heal (Attack Wins)
								else if (intOptionUSER==1 && intOptionMeowth==2){
									intMeowthHP=intMeowthHP-intAttackPower;
									con4.clear();
									con4.println("\n");
									con4.println("   Your pokemon dealt "+intAttackPower+" DMG to "+strEnemy+"!");
									con4.sleep(2000);
								}
								
								else if (intOptionUSER==2 && intOptionMeowth==1){
									intHP=intHP-intAttackPowerMeowth;
									con4.clear();
									con4.println("\n");
									con4.println("    "+strEnemy+" dealt "+intAttackPowerMeowth+" damage to your pokemon!");
									con4.sleep(2000);
								} 
								
								// Heal vs. Defend (Heal Wins ~ Defend is Useless / Does Nothing)
								else if (intOptionUSER==2 && intOptionMeowth==3){
									intHP=intHP+5;
									con4.clear();
									con4.println("\n");
									con4.println("    You healed 5 HP!");
									con4.sleep(2000);
								}
								else if (intOptionUSER==3 && intOptionMeowth==2){
									intMeowthHP=intMeowthHP+5;
									con4.clear();
									con4.println("\n");
									con4.println("   "+strEnemy+" healed 5 HP!");
									con4.sleep(2000);
								}
								
								// Attack vs. Defend (Defend Wins and Reflects Half or Full Damage)
								else if (intOptionUSER==3 && intOptionMeowth==1){
									if (strPokemon.equalsIgnoreCase("eevee")){
										intMeowthHP=intMeowthHP-intAttackPowerMeowth;
										con4.clear();
										con4.println("\n");
										con4.println("   You reflected "+intAttackPowerMeowth+" back to "+strEnemy+"!");
										con4.sleep(2000);
									} else {
										intMeowthHP=intMeowthHP-(int)(0.5*intAttackPowerMeowth);
										con4.clear();
										con4.println("\n");
										con4.println("   You reflected "+(int)(0.5*(intAttackPowerMeowth))+" back to "+strEnemy+"!");
										con4.sleep(2000);
									}
								}
								
								else if (intOptionUSER==1 && intOptionMeowth==3){
									intHP=(intHP)-(int)(0.5*intAttackPower);
									con4.clear();
									con4.println("\n");
									con4.println("   "+strEnemy+" reflected "+strPokemon+"'s hit for "+((int)(0.5*intAttackPower))+" damage!");
									con4.sleep(2000);
								}	
							
								con4.sleep(2500);
							}
								
							// User Wins
							
							if (intHP>intMeowthHP){
								dblLevel=dblLevel+0.1;
								con4.clear();
								con4.println("\n");
								con4.print("   The opposing "+strEnemy+" fainted!");
								con4.sleep(1500);
								
								intHPMax = intHPMax+10;
								intAttackPower = intAttackPower+10;
								
								con4.clear();
								con4.println("\n");
								con4.print("   Your HP Max increased by 10.");
								con4.sleep(2000);
								
								con4.clear();
								con4.println("\n");
								con4.print("   Your Attack Power increased by 10.");
								con4.sleep(2000);
								
								con4.println("                               "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intMeowthHP+"/50");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerMeowth);
								
								con4.sleep(2500);
								intLocationY=intLocationY+1;
						
								intLocation[intLocationY][intLocationX]=0;
								intLocation[intLocationY-1][intLocationX]=1;
						
								imgSwitchA=con4.loadImage("Images_Pokemon_RPG/"+(strPokemon)+".png");
								con4.drawImage(imgSwitchA,intLocationX*20+150,(intLocationY)*20+100);
								con4.repaint();
								imgSwitchB=con4.loadImage("Images_Pokemon_RPG/Grass1.png");
								con4.drawImage(imgSwitchB,(intLocationX)*20+150,(intLocationY-1)*20+100);
								con4.repaint();
								con4.sleep(250);
							}
							
							// User Loses ~ Meowth Wins
							else {
								con4.clear();
								con4.println("\n");
								con4.print("     "+strPokemon+" fainted!");
								con4.println("                               "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intMeowthHP+"/50");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerMeowth);
								// Pass through the rest of the loop and re-enter ~ will be read by the "Check 0 HP "IF" Block" and will be sent to the Healing Centre.
							}
						}
					}
					
					
					
					// (d or right Arrow) Right
					
					else if (intMove==68 || intMove==39){
						if (((intLocationX+1)<=19) && (intLocation[intLocationY][intLocationX+1]==1)){
							
							intLocationX=intLocationX+1;
						
							intLocation[intLocationY][intLocationX]=0;
							intLocation[intLocationY][intLocationX-1]=1;
						
							imgSwitchA=con4.loadImage("Images_Pokemon_RPG/" + (strPokemon) + ".png");
							con4.drawImage(imgSwitchA,(intLocationX)*20+150,(intLocationY)*20+100);
							con4.repaint();
							imgSwitchB=con4.loadImage("Images_Pokemon_RPG/" + "Grass1.png");
							con4.drawImage(imgSwitchB,(intLocationX-1)*20+150,(intLocationY)*20+100);
							con4.repaint();
							con4.sleep(250);
						}
						// User attempts to walk into Healing Centre
						else if (intLocation[intLocationY][intLocationX+1]==5 || intLocation[intLocationY][intLocationX+1]==6 || intLocation[intLocationY][intLocationX+1]==7 || intLocation[intLocationY][intLocationX+1]==8){
							intHP=intHPMax;
							con4.clear();
							con4.println("\n");
							con4.println("             "+strPokemon+"'s HP has been fully healed.");
							con4.sleep(1000);
							con4.clear();
							con4.println("\n");
							con4.println("             Thanks for visiting Poké Hospital!");
							con4.clear();
							
						} 
						// User walks into Water (Drowns)
						else if (intLocation[intLocationY][intLocationX+1]==4){
							con4.clear();
							intHP=0;

							con4.println("\n");
							con4.println("                 Oops! "+strPokemon+" drowned!                                "+intHP+"/"+intHPMax);
							con4.println("\n");
							con4.println("                                                                         "+intAttackPower); 
							con4.println("\n");
							con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10"); 
							con4.sleep(2000);
							
						}
						//User encounters a Wild Zubat
						else if (intLocation[intLocationY][intLocationX+1]==9){
							con4.clear();
							con4.println("\n");
							con4.print("             A wild Zubat appeared!");
							con4.println("                                   "+intHP+"/"+intHPMax);
							con4.println("\n");
							con4.println("                                                                         "+intAttackPower); 
							con4.println("\n");
							con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
							
							String strEnemy=("Zubat");
							int intZubatHP=25;
							int intOptionUSER;
							int intOptionZUBAT;
							int intAttackPowerZUBAT=5;
							
							con4.println("\n\n");
							con4.println("                                                                    "+strEnemy);
							con4.println("\n");
							con4.println("                                                                   "+intZubatHP+"/25");
							con4.println("\n");
							con4.println("                                                                        "+intAttackPowerZUBAT);
							
							con4.sleep(2000);
							
							while (intHP>0 && intZubatHP>0){
								intOptionUSER=0;
								intOptionZUBAT=0;
								int intRandom=9;
								
								// Keep asking user for input until a proper selection is chosen (1,2,or 3). 
								while (intOptionUSER!=49 && intOptionUSER!=50 && intOptionUSER!=51){
									con4.clear();
									con4.println("\n");
									con4.print("      Press 1 to attack, 2 to heal 5HP, 3 to defend");
									con4.println("                    "+intHP+"/"+intHPMax);
									con4.println("\n");
									con4.println("                                                                         "+intAttackPower); 
									con4.println("\n");
									con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
									con4.println("\n\n");
									con4.println("                                                                    "+strEnemy);
									con4.println("\n");
									con4.println("                                                                   "+intZubatHP+"/25");
									con4.println("\n");
									con4.println("                                                                        "+intAttackPowerZUBAT);
									
									intOptionUSER=con4.getKey();
								}
								
								if (intOptionUSER==49){
									intOptionUSER=1;
								} else if (intOptionUSER==50){
									intOptionUSER=2;
								} else {
									intOptionUSER=3;
								}
								
								// Generate 3 random numbers with equal probability (uniform) distributions; since we should only have 9 since 9%3 = 0, 0 inclusive; 9 as a value will be rejected. 
								while (intRandom==9){
									intRandom=(int)((Math.random())*10);
								}
								
								if (intRandom>=0 && intRandom<=2){
									intOptionZUBAT=1;
								} else if (intRandom>=3 && intRandom<=5){
									intOptionZUBAT=2;
								} else if (intRandom>=6 && intRandom<=9){
									intOptionZUBAT=3;
								}
								
								con4.sleep(1500);
								
								// Same Move vs. Same Move (Nothing Happens)
								if (intOptionZUBAT==intOptionUSER){
									con4.clear();
									con4.println("\n");
									con4.println("      Your pokemon did the same move as ");
									con4.sleep(2000);
									con4.clear();
									con4.println("\n");
									con4.println("     "+strEnemy+" , nothing happened!");
									con4.sleep(2000);
								}
								
								// Attack vs. Heal (Attack Wins)
								else if (intOptionUSER==1 && intOptionZUBAT==2){
									intZubatHP=intZubatHP-intAttackPower;
									con4.clear();
									con4.println("\n");
									con4.println("   Your pokemon dealt "+intAttackPower+" DMG to "+strEnemy+"!");
									con4.sleep(2000);
								}
								
								else if (intOptionUSER==2 && intOptionZUBAT==1){
									intHP=intHP-intAttackPowerZUBAT;
									con4.clear();
									con4.println("\n");
									con4.println("    "+strEnemy+" dealt "+intAttackPowerZUBAT+" damage to your pokemon!");
									con4.sleep(2000);
								} 
								
								// Heal vs. Defend (Heal Wins ~ Defend is Useless / Does Nothing)
								else if (intOptionUSER==2 && intOptionZUBAT==3){
									intHP=intHP+5;
									con4.clear();
									con4.println("\n");
									con4.println("    You healed 5 HP!");
									con4.sleep(2000);
								}
								else if (intOptionUSER==3 && intOptionZUBAT==2){
									intZubatHP=intZubatHP+5;
									con4.clear();
									con4.println("\n");
									con4.println("   "+strEnemy+" healed 5 HP!");
									con4.sleep(2000);
								}
								
								// Attack vs. Defend (Defend Wins and Reflects Half or Full Damage)
								else if (intOptionUSER==3 && intOptionZUBAT==1){
									if (strPokemon.equalsIgnoreCase("eevee")){
										intZubatHP=intZubatHP-intAttackPowerZUBAT;
										con4.clear();
										con4.println("\n");
										con4.println("   You reflected "+intAttackPowerZUBAT+" back to "+strEnemy+"!");
										con4.sleep(2000);
									} else {
										intZubatHP=intZubatHP-(int)(0.5*intAttackPowerZUBAT);
										con4.clear();
										con4.println("\n");
										con4.println("   You reflected "+(int)(0.5*(intAttackPowerZUBAT))+" back to "+strEnemy+"!");
										con4.sleep(2000);
									}
								}
								
								else if (intOptionUSER==1 && intOptionZUBAT==3){
									intHP=(intHP)-(int)(0.5*intAttackPower);
									con4.clear();
									con4.println("\n");
									con4.println("   "+strEnemy+" reflected "+strPokemon+"'s hit for "+((int)(0.5*intAttackPower))+" damage!");
									con4.sleep(2000);
								}
							
								con4.sleep(2500);
							}
								
							// User Wins
							
							if (intHP>intZubatHP){
								dblLevel=dblLevel+0.1;
								con4.clear();
								con4.println("\n");
								con4.print("   The opposing "+strEnemy+" fainted!");
								con4.println("                            "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intZubatHP+"/25");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerZUBAT);
								
								con4.sleep(2500);
								intLocationX=intLocationX+1;
						
								intLocation[intLocationY][intLocationX]=0;
								intLocation[intLocationY][intLocationX-1]=1;
						
								imgSwitchA=con4.loadImage("Images_Pokemon_RPG/" + (strPokemon)+".png");
								con4.drawImage(imgSwitchA,intLocationX*20+150,(intLocationY)*20+100);
								con4.repaint();
								imgSwitchB=con4.loadImage("Images_Pokemon_RPG/Grass1.png");
								con4.drawImage(imgSwitchB,(intLocationX-1)*20+150,(intLocationY)*20+100);
								con4.repaint();
								con4.sleep(250);
							}
							
							// User Loses ~ Zubat Wins
							else {
								con4.clear();
								con4.println("\n");
								con4.print("     "+strPokemon+" fainted!");
								con4.println("                            "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intZubatHP+"/25");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerZUBAT);
							// Pass through the rest of the loop and re-enter ~ will be read by the "Check 0 HP "IF" Block" and will be sent to the Healing Centre.
							}
						}	
						
						
						// User encounters a Team Rocket Grunt
						else if (intLocation[intLocationY][intLocationX+1]==10){
							con4.clear();
							con4.println("\n");
							con4.print("  A Team Rocket Challenger Approaches You!");
							con4.sleep(1500);
							con4.clear();
							con4.println("\n");
							con4.println("   They send out a Ghastly!");
							con4.println("                                   "+intHP+"/"+intHPMax);
							con4.println("\n");
							con4.println("                                                                         "+intAttackPower); 
							con4.println("\n");
							con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
							
							String strEnemy=("Ghastly");
							int intGhastlyHP=40;
							int intOptionUSER;
							int intOptionGHASTLY;
							int intAttackPowerGHASTLY=10;
							
							con4.println("\n\n");
							con4.println("                                                                    "+strEnemy);
							con4.println("\n");
							con4.println("                                                                   "+intGhastlyHP+"/40");
							con4.println("\n");
							con4.println("                                                                        "+intAttackPowerGHASTLY);
							
							con4.sleep(2000);
							
							while (intHP>0 && intGhastlyHP>0){
								intOptionUSER=0;
								intOptionGHASTLY=0;
								int intRandom=9;
								
								//Keep asking user for input until a proper selection is chosen (1,2,or 3). 
								while (intOptionUSER!=49 && intOptionUSER!=50 && intOptionUSER!=51){
									con4.clear();
									con4.println("\n");
									con4.print("      Press 1 to attack, 2 to heal 5HP, 3 to defend");
									con4.println("                    "+intHP+"/"+intHPMax);
									con4.println("\n");
									con4.println("                                                                         "+intAttackPower); 
									con4.println("\n");
									con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
									con4.println("\n\n");
									con4.println("                                                                    "+strEnemy);
									con4.println("\n");
									con4.println("                                                                   "+intGhastlyHP+"/40");
									con4.println("\n");
									con4.println("                                                                        "+intAttackPowerGHASTLY);
									
									intOptionUSER=con4.getKey();
								}
								
								if (intOptionUSER==49){
									intOptionUSER=1;
								} else if (intOptionUSER==50){
									intOptionUSER=2;
								} else {
									intOptionUSER=3;
								}
								
								// Generate 3 random numbers with equal probability (uniform) distributions; since we should only have 9 since 9%3 = 0, 0 inclusive; 9 as a value will be rejected. 
								while (intRandom==9){
									intRandom=(int)((Math.random())*10);
								}
								
								if (intRandom>=0 && intRandom<=2){
									intOptionGHASTLY=1;
								} else if (intRandom>=3 && intRandom<=5){
									intOptionGHASTLY=2;
								} else if (intRandom>=6 && intRandom<=9){
									intOptionGHASTLY=3;
								}
								
								con4.sleep(1500);
								
								// Same Move vs. Same Move (Nothing Happens)
								if (intOptionGHASTLY==intOptionUSER){
									con4.clear();
									con4.println("\n");
									con4.println("      Your pokemon did the same move as ");
									con4.sleep(2000);
									con4.clear();
									con4.println("\n");
									con4.println("     "+strEnemy+" , nothing happened!");
									con4.sleep(2000);
								}
								
								// Attack vs. Heal (Attack Wins)
								else if (intOptionUSER==1 && intOptionGHASTLY==2){
									intGhastlyHP=intGhastlyHP-intAttackPower;
									con4.clear();
									con4.println("\n");
									con4.println("   Your pokemon dealt "+intAttackPower+" DMG to "+strEnemy+"!");
									con4.sleep(2000);
								}
								
								else if (intOptionUSER==2 && intOptionGHASTLY==1){
									intHP=intHP-intAttackPowerGHASTLY;
									con4.clear();
									con4.println("\n");
									con4.println("    "+strEnemy+" dealt "+intAttackPowerGHASTLY+" damage to your pokemon!");
									con4.sleep(2000);
								} 
								
								//Heal vs. Defend (Heal Wins ~ Defend is Useless / Does Nothing)
								else if (intOptionUSER==2 && intOptionGHASTLY==3){
									intHP=intHP+5;
									con4.clear();
									con4.println("\n");
									con4.println("    You healed 5 HP!");
									con4.sleep(2000);
								}
								else if (intOptionUSER==3 && intOptionGHASTLY==2){
									intGhastlyHP=intGhastlyHP+5;
									con4.clear();
									con4.println("\n");
									con4.println("   "+strEnemy+" healed 5 HP!");
									con4.sleep(2000);
								}
								
								//Attack vs. Defend (Defend Wins and Reflects Half or Full Damage)
								else if (intOptionUSER==3 && intOptionGHASTLY==1){
									if (strPokemon.equalsIgnoreCase("eevee")){
										intGhastlyHP=intGhastlyHP-intAttackPowerGHASTLY;
										con4.clear();
										con4.println("\n");
										con4.println("   You reflected "+intAttackPowerGHASTLY+" back to "+strEnemy+"!");
										con4.sleep(2000);
									} else {
										intGhastlyHP=intGhastlyHP-(int)(0.5*intAttackPowerGHASTLY);
										con4.clear();
										con4.println("\n");
										con4.println("   You reflected "+(int)(0.5*(intAttackPowerGHASTLY))+" back to "+strEnemy+"!");
										con4.sleep(2000);
									}
								}
								
								else if (intOptionUSER==1 && intOptionGHASTLY==3){
									intHP=(intHP)-(int)(0.5*intAttackPower);
									con4.clear();
									con4.println("\n");
									con4.println("   "+strEnemy+" reflected "+strPokemon+"'s hit for "+((int)(0.5*intAttackPower))+" damage!");
									con4.sleep(2000);
								}
							
								con4.sleep(2500);
							}
								
							// User Wins
							
							if (intHP>intGhastlyHP){
								dblLevel=dblLevel+0.1;
								con4.clear();
								con4.println("\n");
								con4.print("   The opposing "+strEnemy+" fainted!");
								con4.println("                                   "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intGhastlyHP+"/40");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerGHASTLY);
								
								con4.sleep(2500);
								intLocationX=intLocationX+1;
						
								intLocation[intLocationY][intLocationX]=0;
								intLocation[intLocationY][intLocationX-1]=1;
						
								imgSwitchA=con4.loadImage("Images_Pokemon_RPG/" + (strPokemon)+".png");
								con4.drawImage(imgSwitchA,intLocationX*20+150,(intLocationY)*20+100);
								con4.repaint();
								imgSwitchB=con4.loadImage("Images_Pokemon_RPG/Grass1.png");
								con4.drawImage(imgSwitchB,(intLocationX-1)*20+150,(intLocationY)*20+100);
								con4.repaint();
								con4.sleep(250);
							}
							
							// User Loses ~ Ghastly Wins
							else {
								con4.clear();
								con4.println("\n");
								con4.print("     "+strPokemon+" fainted!");
								con4.println("                                   "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intGhastlyHP+"/40");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerGHASTLY);
							//Pass through the rest of the loop and re-enter ~ will be read by the "Check 0 HP "IF" Block" and will be sent to the Healing Centre.
							}
						}
						
						
						//User encounters Jessie.
						else if (intLocation[intLocationY][intLocationX+1]==11){
							con4.clear();
							con4.println("\n");
							con4.print("  It's Team Rocket Jessie!");
							con4.sleep(1500);
							con4.clear();
							con4.println("\n");
							con4.println("   She sends out Ekans!");
							con4.println("                                   "+intHP+"/"+intHPMax);
							con4.println("\n");
							con4.println("                                                                         "+intAttackPower); 
							con4.println("\n");
							con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
							
							String strEnemy=("Ekans");
							int intEkansHP=50;
							int intOptionUSER;
							int intOptionEkans;
							int intAttackPowerEkans=15;
							
							con4.println("\n\n");
							con4.println("                                                                    "+strEnemy);
							con4.println("\n");
							con4.println("                                                                   "+intEkansHP+"/50");
							con4.println("\n");
							con4.println("                                                                        "+intAttackPowerEkans);
							
							con4.sleep(2000);
							
							while (intHP>0 && intEkansHP>0){
								intOptionUSER=0;
								intOptionEkans=0;
								int intRandom=9;
								
								// Keep asking user for input until a proper selection is chosen (1,2,or 3). 
								while (intOptionUSER!=49 && intOptionUSER!=50 && intOptionUSER!=51){
									con4.clear();
									con4.println("\n");
									con4.print("      Press 1 to attack, 2 to heal 5HP, 3 to defend");
									con4.println("                    "+intHP+"/"+intHPMax);
									con4.println("\n");
									con4.println("                                                                         "+intAttackPower); 
									con4.println("\n");
									con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
									con4.println("\n\n");
									con4.println("                                                                    "+strEnemy);
									con4.println("\n");
									con4.println("                                                                   "+intEkansHP+"/50");
									con4.println("\n");
									con4.println("                                                                        "+intAttackPowerEkans);
									
									intOptionUSER=con4.getKey();
								}
								
								if (intOptionUSER==49){
									intOptionUSER=1;
								} else if (intOptionUSER==50){
									intOptionUSER=2;
								} else {
									intOptionUSER=3;
								}
								
								// Generate 3 random numbers with equal probability (uniform) distributions; since we should only have 9 since 9%3 = 0, 0 inclusive; 9 as a value will be rejected. 
								while (intRandom==9){
									intRandom=(int)((Math.random())*10);
								}
								
								if (intRandom>=0 && intRandom<=2){
									intOptionEkans=1;
								} else if (intRandom>=3 && intRandom<=5){
									intOptionEkans=2;
								} else if (intRandom>=6 && intRandom<=9){
									intOptionEkans=3;
								}
								
								con4.sleep(1500);
								
								//Same Move vs. Same Move (Nothing Happens)
								if (intOptionEkans==intOptionUSER){
									con4.clear();
									con4.println("\n");
									con4.println("      Your pokemon did the same move as ");
									con.sleep(2000);
									con4.clear();
									con4.println("\n");
									con4.println("     "+strEnemy+" , nothing happened!");
									con4.sleep(2000);
								}
								
								//Attack vs. Heal (Attack Wins)
								else if (intOptionUSER==1 && intOptionEkans==2){
									intEkansHP=intEkansHP-intAttackPower;
									con4.clear();
									con4.println("\n");
									con4.println("   Your pokemon dealt "+intAttackPower+" DMG to "+strEnemy+"!");
									con4.sleep(2000);
								}
								
								else if (intOptionUSER==2 && intOptionEkans==1){
									intHP=intHP-intAttackPowerEkans;
									con4.clear();
									con4.println("\n");
									con4.println("    "+strEnemy+" dealt "+intAttackPowerEkans+" damage to your pokemon!");
									con4.sleep(2000);
								} 
								
								// Heal vs. Defend (Heal Wins ~ Defend is Useless / Does Nothing)
								else if (intOptionUSER==2 && intOptionEkans==3){
									intHP=intHP+5;
									con4.clear();
									con4.println("\n");
									con4.println("    You healed 5 HP!");
									con4.sleep(2000);
								}
								else if (intOptionUSER==3 && intOptionEkans==2){
									intEkansHP=intEkansHP+5;
									con4.clear();
									con4.println("\n");
									con4.println("   "+strEnemy+" healed 5 HP!");
									con4.sleep(2000);
								}
								
								//Attack vs. Defend (Defend Wins and Reflects Half or Full Damage)
								else if (intOptionUSER==3 && intOptionEkans==1){
									if (strPokemon.equalsIgnoreCase("eevee")){
										intEkansHP=intEkansHP-intAttackPowerEkans;
										con4.clear();
										con4.println("\n");
										con4.println("   You reflected "+intAttackPowerEkans+" back to "+strEnemy+"!");
										con4.sleep(2000);
									} else {
										intEkansHP=intEkansHP-(int)(0.5*intAttackPowerEkans);
										con4.clear();
										con4.println("\n");
										con4.println("   You reflected "+(int)(0.5*(intAttackPowerEkans))+" back to "+strEnemy+"!");
										con4.sleep(2000);
									}
								}
								
								else if (intOptionUSER==1 && intOptionEkans==3){
									intHP=(intHP)-(int)(0.5*intAttackPower);
									con4.clear();
									con4.println("\n");
									con4.println("   "+strEnemy+" reflected "+strPokemon+"'s hit for "+((int)(0.5*intAttackPower))+" damage!");
									con4.sleep(2000);
								}
							
								con4.sleep(2500);
							}
								
							//User Wins
							
							if (intHP>intEkansHP){
								dblLevel=dblLevel+0.1;
								con4.clear();
								con4.println("\n");
								con4.print("   The opposing "+strEnemy+" fainted!");
								con4.sleep(1500);
								
								intHPMax = intHPMax+10;
								intAttackPower = intAttackPower+10;
								
								con4.clear();
								con4.println("\n");
								con4.print("   Your HP Max increased by 10.");
								con4.sleep(2000);
								
								con4.clear();
								con4.println("\n");
								con4.print("   Your Attack Power increased by 10.");
								con4.sleep(2000);
								
								con4.println("                                   "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intEkansHP+"/50");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerEkans);
								
								con4.sleep(2500);
								intLocationX=intLocationX+1;
						
								intLocation[intLocationY][intLocationX]=0;
								intLocation[intLocationY][intLocationX-1]=1;
						
								imgSwitchA=con4.loadImage("Images_Pokemon_RPG/" + (strPokemon)+".png");
								con4.drawImage(imgSwitchA,intLocationX*20+150,(intLocationY)*20+100);
								con4.repaint();
								imgSwitchB=con4.loadImage("Images_Pokemon_RPG/Grass1.png");
								con4.drawImage(imgSwitchB,(intLocationX-1)*20+150,(intLocationY)*20+100);
								con4.repaint();
								con4.sleep(250);
							}
							
							//User Loses ~ Ekans Wins
							else {
								con4.clear();
								con4.println("\n");
								con4.print("     "+strPokemon+" fainted!");
								con4.println("                                  "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intEkansHP+"/50");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerEkans);
							//Pass through the rest of the loop and re-enter ~ will be read by the "Check 0 HP "IF" Block" and will be sent to the Healing Centre.
							}
						}
						
						//User encounters James.
						else if (intLocation[intLocationY][intLocationX+1]==12){
							con4.clear();
							con4.println("\n");
							con4.print("  It's Team Rocket James!");
							con4.sleep(1500);
							con4.clear();
							con4.println("\n");
							con4.println("   He sends out Meowth!");
							con4.println("                                   "+intHP+"/"+intHPMax);
							con4.println("\n");
							con4.println("                                                                         "+intAttackPower); 
							con4.println("\n");
							con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
							
							String strEnemy=("Meowth");
							int intMeowthHP=50;
							int intOptionUSER;
							int intOptionMeowth;
							int intAttackPowerMeowth=15;
							
							con4.println("\n\n");
							con4.println("                                                                    "+strEnemy);
							con4.println("\n");
							con4.println("                                                                   "+intMeowthHP+"/50");
							con4.println("\n");
							con4.println("                                                                        "+intAttackPowerMeowth);
							
							con4.sleep(2000);
							
							while (intHP>0 && intMeowthHP>0){
								intOptionUSER=0;
								intOptionMeowth=0;
								int intRandom=9;
								
								//Keep asking user for input until a proper selection is chosen (1,2,or 3). 
								while (intOptionUSER!=49 && intOptionUSER!=50 && intOptionUSER!=51){
									con4.clear();
									con4.println("\n");
									con4.print("      Press 1 to attack, 2 to heal 5HP, 3 to defend");
									con4.println("                    "+intHP+"/"+intHPMax);
									con4.println("\n");
									con4.println("                                                                         "+intAttackPower); 
									con4.println("\n");
									con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
									con4.println("\n\n");
									con4.println("                                                                    "+strEnemy);
									con4.println("\n");
									con4.println("                                                                   "+intMeowthHP+"/50");
									con4.println("\n");
									con4.println("                                                                        "+intAttackPowerMeowth);
									
									intOptionUSER=con4.getKey();
								}
								
								if (intOptionUSER==49){
									intOptionUSER=1;
								} else if (intOptionUSER==50){
									intOptionUSER=2;
								} else {
									intOptionUSER=3;
								}
								
								//Generate 3 random numbers with equal probability (uniform) distributions; since we should only have 9 since 9%3 = 0, 0 inclusive; 9 as a value will be rejected. 
								while (intRandom==9){
									intRandom=(int)((Math.random())*10);
								}
								
								if (intRandom>=0 && intRandom<=2){
									intOptionMeowth=1;
								} else if (intRandom>=3 && intRandom<=5){
									intOptionMeowth=2;
								} else if (intRandom>=6 && intRandom<=9){
									intOptionMeowth=3;
								}
								
								con4.sleep(1500);
								
								//Same Move vs. Same Move (Nothing Happens)
								if (intOptionMeowth==intOptionUSER){
									con4.clear();
									con4.println("\n");
									con4.println("      Your pokemon did the same move as ");
									con4.sleep(2000);
									con4.clear();
									con4.println("\n");
									con4.println("     "+strEnemy+" , nothing happened!");
									con4.sleep(2000);
								}
								
								//Attack vs. Heal (Attack Wins)
								else if (intOptionUSER==1 && intOptionMeowth==2){
									intMeowthHP=intMeowthHP-intAttackPower;
									con4.clear();
									con4.println("\n");
									con4.println("   Your pokemon dealt "+intAttackPower+" DMG to "+strEnemy+"!");
									con4.sleep(2000);
								}
								
								else if (intOptionUSER==2 && intOptionMeowth==1){
									intHP=intHP-intAttackPowerMeowth;
									con4.clear();
									con4.println("\n");
									con4.println("    "+strEnemy+" dealt "+intAttackPowerMeowth+" damage to your pokemon!");
									con4.sleep(2000);
								} 
								
								//Heal vs. Defend (Heal Wins ~ Defend is Useless / Does Nothing)
								else if (intOptionUSER==2 && intOptionMeowth==3){
									intHP=intHP+5;
									con4.clear();
									con4.println("\n");
									con4.println("    You healed 5 HP!");
									con4.sleep(2000);
								}
								else if (intOptionUSER==3 && intOptionMeowth==2){
									intMeowthHP=intMeowthHP+5;
									con4.clear();
									con4.println("\n");
									con4.println("   "+strEnemy+" healed 5 HP!");
									con4.sleep(2000);
								}
								
								//Attack vs. Defend (Defend Wins and Reflects Half or Full Damage)
								else if (intOptionUSER==3 && intOptionMeowth==1){
									if (strPokemon.equalsIgnoreCase("eevee")){
										intMeowthHP=intMeowthHP-intAttackPowerMeowth;
										con4.clear();
										con4.println("\n");
										con4.println("   You reflected "+intAttackPowerMeowth+" back to "+strEnemy+"!");
										con4.sleep(2000);
									} else {
										intMeowthHP=intMeowthHP-(int)(0.5*intAttackPowerMeowth);
										con4.clear();
										con4.println("\n");
										con4.println("   You reflected "+(int)(0.5*(intAttackPowerMeowth))+" back to "+strEnemy+"!");
										con4.sleep(2000);
									}
								}
								
								else if (intOptionUSER==1 && intOptionMeowth==3){
									intHP=(intHP)-(int)(0.5*intAttackPower);
									con4.clear();
									con4.println("\n");
									con4.println("   "+strEnemy+" reflected "+strPokemon+"'s hit for "+((int)(0.5*intAttackPower))+" damage!");
									con4.sleep(2000);
								}	
							
								con4.sleep(2500);
							}
								
							//User Wins
							
							if (intHP>intMeowthHP){
								dblLevel=dblLevel+0.1;
								con4.clear();
								con4.println("\n");
								con4.print("   The opposing "+strEnemy+" fainted!");
								con4.sleep(1500);
								
								intHPMax = intHPMax+10;
								intAttackPower = intAttackPower+10;
								
								con4.clear();
								con4.println("\n");
								con4.print("   Your HP Max increased by 10.");
								con4.sleep(2000);
								
								con4.clear();
								con4.println("\n");
								con4.print("   Your Attack Power increased by 10.");
								con4.sleep(2000);
								
								con4.println("                               "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intMeowthHP+"/50");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerMeowth);
								
								con4.sleep(2500);
								intLocationX=intLocationX+1;
						
								intLocation[intLocationY][intLocationX]=0;
								intLocation[intLocationY][intLocationX-1]=1;
						
								imgSwitchA=con4.loadImage("Images_Pokemon_RPG/" + (strPokemon)+".png");
								con4.drawImage(imgSwitchA,intLocationX*20+150,(intLocationY)*20+100);
								con4.repaint();
								imgSwitchB=con4.loadImage("Images_Pokemon_RPG/Grass1.png");
								con4.drawImage(imgSwitchB,(intLocationX-1)*20+150,(intLocationY)*20+100);
								con4.repaint();
								con4.sleep(250);
							}
							
							//User Loses ~ Meowth Wins
							else {
								con4.clear();
								con4.println("\n");
								con4.print("     "+strPokemon+" fainted!");
								con4.println("                               "+intHP+"/"+intHPMax);
								con4.println("\n");
								con4.println("                                                                         "+intAttackPower); 
								con4.println("\n");
								con4.println("                                                                      "+((int)(dblLevel))+": "+((int)(((dblLevel)-((int)(dblLevel)))*10.0))+"/10");  
								con4.println("\n\n");
								con4.println("                                                                    "+strEnemy);
								con4.println("\n");
								con4.println("                                                                   "+intMeowthHP+"/50");
								con4.println("\n");
								con4.println("                                                                        "+intAttackPowerMeowth);
								//Pass through the rest of the loop and re-enter ~ will be read by the "Check 0 HP "IF" Block" and will be sent to the Healing Centre.
							}
						}
					}
					
					else if (intMove==27){
						break;
					}
				}
				
				con4.sleep(500);
					
			}
		}

	}
	
}
