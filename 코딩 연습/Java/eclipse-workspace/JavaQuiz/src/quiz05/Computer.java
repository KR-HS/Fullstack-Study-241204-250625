package quiz05;

public class Computer extends Calculator{
	double circle(){
		return Math.PI*result*result;
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
