void setup() {
  size(940, 820);
  noStroke();
  noLoop();
  Highscore();
  HighscoreNameInput();

}

void mousePressed() {
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

void keyTyped(){
  HighscoresList();
}

void setup1() {
  size (200, 200);
  x = width;
  y = height;
}

void draw() {
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
      rK -= 0.5;
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
