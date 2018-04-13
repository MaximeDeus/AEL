package postfixees;
public class Mult extends Operateur implements Yytoken{

  protected int calcul(int... values){
    return values[0]+values[1];
  }

  public Mult(String image){
    super(image,2);
  }
}
