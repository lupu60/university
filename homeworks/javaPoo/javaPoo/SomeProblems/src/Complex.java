
public class Complex {
	private double re;
	private double im;
	public Complex(double x, double y)
	{
	re=x;
	im=y;
	}
	public double getRe()
	{
	return re;
	}
	public double getIm()
	{
	return im;
	}
	public double modul()
	{
	return Math.sqrt(re*re+im*im);
	}
	public void suma(Complex c)
	{
	re=re+c.re;
	im=im+c.im;
	}
	public Complex suma2(Complex c)
	{
	re=re+c.re;
	im=im+c.im;
	return new Complex(re, im);
	}
	//inmultirea nr. complex curent, cu un alt nr. complex, cu depunerea
	//rezultatului in numarul complex curent:
	public void produs(Complex c)
	{
	re=re*c.re-im*c.im;
	im=re*c.im+im*c.re;
	}
	//redefinirea metodei equals() din clasa parinte Object:
	//(trebuie sa se pastreze aceeasi semnatura:)
	public boolean equals(Object obj)
	{
	Complex c=(Complex)obj;
	if(c!=null)
	if((re==c.re)&&(im==c.im))return true;
	return false;
	}
	//redefinirea metodei toString() din clasa parinte Object:
	public String toString()
	{
	String s="("+re+"+i"+im+")";
	return s;
	}
	}
	

