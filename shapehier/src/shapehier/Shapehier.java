
package shapehier;

class Shape
{
    int x,y,z;
    public Shape(){
        System.out.println("NO PARAMETER");
    }
    public int getx(){
        return x;
    }
    public int gety(){
        return y;
    }
    public int getz(){
        return z;
    }
    public void setx(int a){
        x=a;
    }
    public void sety(int a){
        y=a;
    }
    public void setz(int a){
        z=a;
    }
}
abstract class twoDShape extends Shape{
    public twoDShape(){
        
    }
     public twoDShape(int a){
        setx(a);
    }
      public twoDShape(int a, int b){
        setx(a);
        sety(b);
    }
    abstract double area();
}
abstract class threeDShape extends Shape{
    public threeDShape(){
        
    }
     public threeDShape(int a){
        setx(a);
    }
      public threeDShape(int a, int b, int c){
        setx(a);
        sety(b);
        setz(c);
    }
      abstract double volume();
}
class circle extends twoDShape{
    circle(int a){
        super(a);
    }
    @Override
    double area(){
        return getx()*3.14;
    }
}
class rectangle extends twoDShape{
    rectangle(int a, int b){
        super(a,b);
    }
    double area(){
        return getx()*gety();
    }
}
class triangle extends twoDShape{
    triangle(int a, int b){
        super(a,b);
    }
    double area(){
        return getx()*gety()*0.5;
    }
}
class sphere extends threeDShape{
    sphere(int a){
        super(a);
    }
    double volume(){
        return getx()*(4/3)*3.14;
    }
}
class cube extends threeDShape{
    cube(int a,int b, int c){
        super(a,b,c);
    }
    double volume(){
        return getx()*gety()*getz();
    }
}
public class Shapehier {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        circle a=new circle(4);
        rectangle b=new rectangle(5,4);          
        triangle c=new triangle(10,4);
        sphere d=new sphere(2);
        cube e=new cube(4,6,5);
        System.out.println(a.area());
        System.out.println(b.area());
        System.out.println(c.area());
        System.out.println(d.volume());
        System.out.println(e.volume());

        
    }
    
}
