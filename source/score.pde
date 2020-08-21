
void Score() {
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

void wonScore() {
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
