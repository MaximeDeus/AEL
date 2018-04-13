package postfixees;
public class Opp extends Operateur implements Yytoken{

  protected int calcul(int... values){
    return -values[0];
  }

  public Opp(String image){
    super(image,1);
  }
}
