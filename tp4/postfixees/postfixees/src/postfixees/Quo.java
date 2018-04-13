package postfixees;
public class Quo extends Operateur implements Yytoken{

  protected int calcul(int... values){
    return values[0]+values[1];
  }

  public Quo(String image){
    super(image,2);
  }
}
