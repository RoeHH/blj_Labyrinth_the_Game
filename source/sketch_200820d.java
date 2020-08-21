import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import controlP5.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class sketch_200820d extends PApplet {

public void setup() {
  
  noStroke();
  noLoop();
  Highscore();
  HighscoreNameInput();

}

public void mousePressed() {
    loop();
  if (highscoreListOpen == true){
  HighscoresList();
  highscoreListOpen = false;
  } 
  if (youWon == 0) {
    SubmitHighscore();
    youWon = youWon + 1;
  }
}

public void keyTyped(){
  HighscoresList();
}

public void setup1() {
  size (200, 200);
  x = width;
  y = height;
}

public void draw() {
  //Labyrint
  size(940, 820);
  fill(150, 150, 150);
  background(0, 0, 0);
  rect(0, 0, 420, 120);
  rect(300, 0, 120, 340);
  rect(0, 220, 420, 120);
  rect(0, 220, 120, 520);
  rect(0, 620, 840, 120);
  rect(720, 120, 120, 620);
  fill(150, 20, 50);
  rect(720, 0, 120, 120);
  Highscore();
  Score();
  //Timer
  seconds = (millis() - startingTime) / 1000;
  rKreseterseconds = (millis() - rKresetertime) / 1000;
  println(seconds);
  d = 2 * rK;

  boolean isMouseOverCircle = false;
  if (mouseX < x + d/2 && mouseX > x - d/2 && mouseY < y + d/2 && mouseY > y - d/2) {
    isMouseOverCircle = true;
  }
  if (isMouseOverCircle == false) {
    cursor();
  }
  if (mousePressed && isMouseOverCircle == true) {
    x = mouseX;
    y = mouseY;
    noCursor();
    if (gameGoing == false) {
      startingTime = millis();
      gameGoing = true;
      
    }
    // Kollision?
    if (istKreisInRechteck(rK, mouseX, mouseY, 0, 0, 420, 120) == true) {
      println("OK");
    } else if (istKreisInRechteck(rK, mouseX, mouseY, 300, 0, 120, 340) == true) {
      println("OK");
    } else if (istKreisInRechteck(rK, mouseX, mouseY, 0, 220, 420, 120) == true) {
      println("OK");
    } else if (istKreisInRechteck(rK, mouseX, mouseY, 0, 220, 120, 520) == true) {
      println("OK");
    } else if (istKreisInRechteck(rK, mouseX, mouseY, 0, 620, 840, 120) == true) {
      println("OK");
    } else if (istKreisInRechteck(rK, mouseX, mouseY, 720, 120, 120, 620) == true) {
      println("OK");
    } else if (istKreisInRechteck(rK, mouseX, mouseY, 720, 0, 120, 140) == true) {
      imZiel = true;
    } else if (rK > 10) {
      rK -= 0.5f;
      fill(0, 0, 255);
    }
  }

if ( imZiel == true) {
  d = 2 * rK;
  background(0, 0, 0, 0);
  textSize(100);
  textAlign (CENTER);
  text("You Won", 490, 285);
  textAlign(LEFT);
  x = 60;
  y = 60;
  noLoop();
  cursor();
  rK=50;
  imZiel = false;
  score = d*10-seconds*5;
  showScore = str(score);
  println(score);
  scoreScore = score;
  wonScore();
  youWon = youWon-1;
  gameGoing = false;
}


if (rK==10) {
  background(0, 0, 0, 0);
  textSize(100);
  textAlign (CENTER);
  text("Game over", 490, 385);
  textAlign(LEFT);
  cursor();
  x = 60;
  y = 60;
  noLoop();
  cursor();
  rK=50;
  gameGoing = false;
} 
circle(x, y, 2 * rK);
}


ControlP5 cp5;

public void Highscore() {
  textAlign(centercenterer);
  fill(0, 0, 0);
  rect(430, 620, 300, -900);
  fill(150, 20, 50);
  textSize(highScoreTextSize);
  text("Top 10:", textXAchse, textYAchse);
  text("1.  " + highscoreScore1 + " " + highscoreName1, textXAchse, textYAchse+50);
  text("2.  " + highscoreScore2 + " " + highscoreName2, textXAchse, textYAchse+100);
  text("3.  " + highscoreScore3 + " " + highscoreName3, textXAchse, textYAchse+150);
  text("4.  " + highscoreScore4 + " " + highscoreName4, textXAchse, textYAchse+200);
  text("5.  " + highscoreScore5 + " " + highscoreName5, textXAchse, textYAchse+250);
  text("6.  " + highscoreScore6 + " " + highscoreName6, textXAchse, textYAchse+300);
  text("7.  " + highscoreScore7 + " " + highscoreName7, textXAchse, textYAchse+350);
  text("8.  " + highscoreScore8 + " " + highscoreName8, textXAchse, textYAchse+400);
  text("9.  " + highscoreScore9 + " " + highscoreName9, textXAchse, textYAchse+450);
  text("10." + highscoreScore10 + " " + highscoreName10, textXAchse, textYAchse+500);
  textAlign(LEFT);
}

public void HighscoreNameInput() {
  cp5 = new ControlP5(this);
  cp5.addTextfield("textInputHighscore").setPosition(0, 740).setSize(450, 110).setAutoClear(false);
  cp5.addBang("SubmitHighscoreName").setPosition(450, 740).setSize(160, 110);
}

public void HighscoresList(){
  if(highscoreListOpen == true){
  loop();
  centercenterer = LEFT;
  textYAchse = 50;
  highScoreTextSize = 32;
  highscoreListOpen = true;
  }
  if(highscoreListOpen == false){
  noLoop();
  background(0,0,0);
  centercenterer = CENTER;
  textYAchse = 100;
  highScoreTextSize = 40;
  Highscore();
  highscoreListOpen = true;
  }
}

public void SubmitHighscoreName() {
  HighscoreNameCash = cp5.get(Textfield.class, "textInputHighscore").getText();
  println(HighscoreNameCash+" "+scoreScore);
}

public void SubmitHighscore() {
    if (highscoreScore1<scoreScore) {
    highscoreName1 = HighscoreNameCash;
    highscoreScore10 = 0+highscoreScore9;
    highscoreScore9 = 0+highscoreScore8;
    highscoreScore8 = 0+highscoreScore7;
    highscoreScore7 = 0+highscoreScore6;
    highscoreScore6 = 0+highscoreScore5;
    highscoreScore5 = 0+highscoreScore4;
    highscoreScore4 = 0+highscoreScore3;
    highscoreScore3 = 0+highscoreScore2;
    highscoreScore2 = 0+highscoreScore1;
    highscoreScore1 = 0+scoreScore;
    Highscore();
  } else if (highscoreScore2<scoreScore) {
    highscoreName2 = HighscoreNameCash; 
    highscoreScore10 = 0+highscoreScore9;
    highscoreScore9 = 0+highscoreScore8;
    highscoreScore8 = 0+highscoreScore7;
    highscoreScore7 = 0+highscoreScore6;
    highscoreScore6 = 0+highscoreScore5;
    highscoreScore5 = 0+highscoreScore4;
    highscoreScore4 = 0+highscoreScore3;
    highscoreScore3 = 0+highscoreScore2;
    highscoreScore2 = 0+scoreScore;
    Highscore();
  } else if (highscoreScore3<scoreScore) {
    highscoreName3 = HighscoreNameCash;
    highscoreScore10 = 0+highscoreScore9;
    highscoreScore9 = 0+highscoreScore8;
    highscoreScore8 = 0+highscoreScore7;
    highscoreScore7 = 0+highscoreScore6;
    highscoreScore6 = 0+highscoreScore5;
    highscoreScore5 = 0+highscoreScore4;
    highscoreScore4 = 0+highscoreScore3;
    highscoreScore3 = 0+scoreScore;
    Highscore();
  } else if (highscoreScore4<scoreScore) {
    highscoreName4 = HighscoreNameCash;
    highscoreScore10 = 0+highscoreScore9;
    highscoreScore9 = 0+highscoreScore8;
    highscoreScore8 = 0+highscoreScore7;
    highscoreScore7 = 0+highscoreScore6;
    highscoreScore6 = 0+highscoreScore5;
    highscoreScore5 = 0+highscoreScore4;
    highscoreScore4 = 0+scoreScore;
    Highscore();
  } else if (highscoreScore5<scoreScore) {
    highscoreName5 = HighscoreNameCash;
    highscoreScore10 = 0+highscoreScore9;
    highscoreScore9 = 0+highscoreScore8;
    highscoreScore8 = 0+highscoreScore7;
    highscoreScore7 = 0+highscoreScore6;
    highscoreScore6 = 0+highscoreScore5;
    highscoreScore5 = 0+scoreScore;
    Highscore();
  } else if (highscoreScore6<scoreScore) {
    highscoreName6 = HighscoreNameCash;
    highscoreScore10 = 0+highscoreScore9;
    highscoreScore9 = 0+highscoreScore8;
    highscoreScore8 = 0+highscoreScore7;
    highscoreScore7 = 0+highscoreScore6;
    highscoreScore6 = 0+scoreScore;
    Highscore();
  } else if (highscoreScore7<scoreScore) {
    highscoreName7 = HighscoreNameCash;
    highscoreScore10 = 0+highscoreScore9;
    highscoreScore9 = 0+highscoreScore8;
    highscoreScore8 = 0+highscoreScore7;
    highscoreScore7 = 0+scoreScore;
    Highscore();
  } else if (highscoreScore8<scoreScore) {
    highscoreName8 = HighscoreNameCash;
    highscoreScore10 = 0+highscoreScore9;
    highscoreScore9 = 0+highscoreScore8;
    highscoreScore8 = 0+scoreScore;
    Highscore();
  } else if (highscoreScore9<scoreScore) {
    highscoreName9 = HighscoreNameCash;
    highscoreScore10 = 0+highscoreScore9;
    highscoreScore9 =0+scoreScore;
    Highscore();
  } else if (highscoreScore10<scoreScore) {
    highscoreName10 = HighscoreNameCash;
    highscoreScore10 = 0+scoreScore;
    Highscore();
  }
}

public boolean istKreisInRechteck(int rK, int xK, int yK, int xR, int yR, int wR, int hR) {
  if (xK - rK  > xR
    && xK + rK < xR + wR
    && yK-rK > yR
    && yK + rK < yR + hR) {
    return true;
  } else {  
    return false;
  }
}

public void Score() {
  fill(0, 0, 0);
  rect(123, 350, 300, 250);
  fill(150, 20, 50);
  textSize(32);
  text("Score:", scoreTextXAchse, scoreTextYAchse);
  text(showScore, scoreTextXAchse, scoreTextYAchse+50);
  text("Time:", scoreTextXAchse, scoreTextYAchse+100);
  if (seconds<10) {
    text("00" + (seconds) + "s", scoreTextXAchse, scoreTextYAchse+150);
  } else if (seconds<100) {
    text("0" + (seconds)+ "s ", scoreTextXAchse, scoreTextYAchse+150);
  } else {
    text((seconds)+ "s", scoreTextXAchse, scoreTextYAchse+150);
  }
} 

public void wonScore() {
  fill(0, 0, 0);
  fill(150, 20, 50);
  textSize(32); 
  if (seconds<10) {
    text("Score:"+showScore+"  Time:"+"00" + (seconds) + "s ", wonScoreTextXAchse, wonScoreTextYAchse+150);
  } else if (seconds<100) {
    text("Score:"+showScore+"  Time:" + (seconds)+ "s ", wonScoreTextXAchse, wonScoreTextYAchse+150);
  } else {
    text("Score:"+showScore+"  Time:"+ "0" + (seconds)+ "s ", wonScoreTextXAchse, wonScoreTextYAchse+150);
  }
}
//Circle Desing
int circleColorR = 150;  
int circleColorG = 20;  
int circleColorB = 50;  
int circleColorR_hit = 500;  
int circleColorG_hit = 0;  
int circleColorB_hit = 0;  
int circleDiameter = 100;
//Highscore Text align
int textYAchse = 50;
int textXAchse = 470;
int highScoreTextSize = 32;
//HighscoreName
String HighscoreNameCash = " ";
String highscoreName1 = "  "; 
String highscoreName2 = "  "; 
String highscoreName3 = "  "; 
String highscoreName4 = "  "; 
String highscoreName5 = "  "; 
String highscoreName6 = "  "; 
String highscoreName7 = "  "; 
String highscoreName8 = "  ";
String highscoreName9 = "  "; 
String highscoreName10 = " "; 
//Stored Highscores
int highscoreScore1 = 0;
int highscoreScore2 = 0;
int highscoreScore3 = 0;
int highscoreScore4 = 0;
int highscoreScore5 = 0;
int highscoreScore6 = 0;
int highscoreScore7 = 0;
int highscoreScore8 = 0;
int highscoreScore9 = 0;
int highscoreScore10 =0;
int scoreScore;
//Scor+Time
int startingTime;
int score;
int seconds;
int scoreTextXAchse = 170;
int scoreTextYAchse = 400;
String showScore = "---";
int minutes;
int wonScoreTextXAchse = 320;
int wonScoreTextYAchse = 210;
//rk reseter
int rKresetertime;
int rKreseterseconds;
//Zusatz
int youWon;
boolean isMouseOverCircle = false;
boolean imZiel = false;
boolean gameGoing =false;
int rK = 50;
int x = 60;
int y = 60;
int d = 2 * rK;
//centercenterer
int centercenterer;
boolean highscoreListOpen = false;
  public void settings() {  size(940, 820); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "sketch_200820d" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
