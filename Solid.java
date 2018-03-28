package lab1;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Solid extends Point // bryla dziedziczy po punkcie
{
	private ArrayList<Point> body = new ArrayList<Point>();  // tablica przehowujaca punkty, z ktorych sklada sie bryla
	
	Solid(int volume, double newCenter)  // konstruktor bryly, podajemy my ilosc punktow z ktorych ma skladac sie bryla oraz dowolna os wzgledem ktorej bedzie liczony moment bezwladnosci bryly
	{
		//petla tworzaca tyle punktow, ile podamy do konstruktora
		System.out.println("Punkty tworzace bryle: ");
		int cnt = 0;
		for(int x = volume; x>0; x--)
		{
			double randomMass = ThreadLocalRandom.current().nextInt(1, 10);
			double randomRadius = ThreadLocalRandom.current().nextInt(-5, 5);
			
			body.add(new Point(randomMass, randomRadius));
			
			Point tempPoint = body.get(cnt);
			
			tempPoint.showInfo2();
			cnt++;
		}
		
		calcInertia(volume, newCenter);
		
	}
	
	
	
	void calcInertia(int volume, double newCenter)  // metoda liczaca moment bezwladnosci bryly wzgledem srodka ciezkosci(oraz wywolujaca metode liczaca moment bezwladnosci bryly wzgledem dowolnej osi)
	{                                           
		double sumRadiusMass = 0;
		double sumMass = 0;
		
		// petla liczaca srodek ciezkosci
		int cnt = 0;
		for(int x = volume; x>0; x--)
		{
			Point tempPoint = body.get(cnt);
			
			sumRadiusMass = sumRadiusMass + ( tempPoint.getRadius() * tempPoint.getMass() );
			sumMass = sumMass + tempPoint.getMass();
			cnt++;
		}
		
		double center = sumRadiusMass / sumMass;
		
		double interia = 0;
		
		// petla liczaca moment bezwladnosci wzgledem srodka ciezkosci
		cnt = 0;
		for(int x = volume; x>0; x--)
		{
			Point tempPoint = body.get(cnt);
			double tempRadius = center - tempPoint.getRadius(); 
			double tempMass = tempPoint.getMass();
			
			interia = interia + ( tempMass * Math.pow(tempRadius, 2));
			cnt++;
		}
		
		System.out.println();
		System.out.println("Moment bezwladnosci bryly wzgldem srodeka ciezkosci bryly skladajacej sie z "
		+ volume + " punktow, o masie = " + sumMass +  "\n o srodku ciezkosci w " + center + " wynosi: " + interia);
		
		
		calcAnyInertia(newCenter, volume, sumMass);
	}
	
	
	void calcAnyInertia(double newCenter, int volume, double sumMass)  // metoda liczaca moment bezwladnosci bryly wzgledem dowolnej osi
	{
		double interia2 = 0;
		
		// petla liczaca moment bezwladnosci wzgledem dowolnej osi
		int cnt = 0;
		for(int x = volume; x>0; x--)
		{
			Point tempPoint = body.get(cnt);
			double tempRadius = newCenter - tempPoint.getRadius(); 
			double tempMass = tempPoint.getMass();
			
			interia2 = interia2 + ( tempMass * Math.pow(tempRadius, 2) );
			cnt++;
		}
		
		System.out.println();
		System.out.println("Moment bezwladnosci bryly wzgledem osi: " + newCenter + " wynosi: " + interia2);
	}

}
