package quiz05;

public class Computer extends Calculator{
	@Override
	double circle(int r){
		return Math.PI*r*r;
	}
	
	double rect(double a) {
		return a*a;
	}
	
	double rect(double a,double b) {
		return a*b;
	}
	
	double rect(double a, double b,double c) {
		return a*b*c;
	}
	
	
}
