import javax.swing.*;
class VectorCuvinteDiferite
{
public static void main(String args[])
{
int N=Integer.parseInt(JOptionPane.showInputDialog("N = "));
String s[]=new String[N];
int i,j;
for(i=0;i<N;i++)
s[i]=JOptionPane.showInputDialog("cuvant = ");
//Sunt diferite?
for(i=0;i<N-1;i++)
for(j=i+1;j<N;j++)
if(s[i].compareTo(s[j])==0){
System.out.println("Nu sunt toate diferite . ");
return;
}
System.out.println("Sunt toate diferite ");
}
}