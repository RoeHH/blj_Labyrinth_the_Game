boolean istKreisInRechteck(int rK, int xK, int yK, int xR, int yR, int wR, int hR) {
  if (xK - rK  > xR
    && xK + rK < xR + wR
    && yK-rK > yR
    && yK + rK < yR + hR) {
    return true;
  } else {  
    return false;
  }
}
