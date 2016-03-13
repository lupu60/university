import javax.swing.*;
class Ordonare3
{
public static void main(String args[])
{
int a=Integer.parseInt(JOptionPane.showInputDialog("a="));
int b=Integer.parseInt(JOptionPane.showInputDialog("b="));
int c=Integer.parseInt(JOptionPane.showInputDialog("c="));
if(a>b){
// le comutam:
int aux=a; a=b; b=aux;
}
if(b>c){
//le comutam:
int aux=b; b=c; c=aux;
}
if(a>c){
//le comutam:
int aux=a;a=c; c=aux;
}
System.out.println(a+" "+b+" "+c);
}
}