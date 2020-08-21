import controlP5.*;

ControlP5 cp5;

void Highscore() {
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

void HighscoreNameInput() {
  cp5 = new ControlP5(this);
  cp5.addTextfield("textInputHighscore").setPosition(0, 740).setSize(450, 110).setAutoClear(false);
  cp5.addBang("SubmitHighscoreName").setPosition(450, 740).setSize(160, 110);
}

void HighscoresList(){
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

void SubmitHighscoreName() {
  HighscoreNameCash = cp5.get(Textfield.class, "textInputHighscore").getText();
  println(HighscoreNameCash+" "+scoreScore);
}

void SubmitHighscore() {
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
