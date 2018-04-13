package postfixees;
public class Minus extends Operateur implements Yytoken{

  protected int calcul(int... values){
    return values[0]+values[1];
  }

  public Minus(String image){
    super(image,2);
  }
}
