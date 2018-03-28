package lab1;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Field 
{

	public static void main(String[] args) 
	{
		// stworzenie obiektow klasy Punkt
		Point point1 = new Point();
		Point point2 = new Point(51);
		
		int newPole = -4;  // nowy biegun, wzgledem ktorego zostanie oblczny nowy moment bezwladnosci
		
		// obliczenie i wyswietlenie informacji dotyczacych pierwszego punktu
		point1.showInfo();       
		point1.calcInertia();
		point1.calcStainer(newPole);
		
		System.out.println();
		
		// obliczenie i wyswietlenie informacji dotyczacych drugiego punktu
		point2.showInfo();
		point2.calcInertia();
		point2.calcStainer(newPole);
		
		System.out.println();

		point1.changeMass(312);  // zmiana masy pierwszego punktu z bazowej rownej 10 na nowa rowna 1015
		
		// ponowne obliczenie i wyswietlenie informacji dotyczacych pierwszego punktu po zmianie masy
		point1.showInfo();
		point1.calcInertia();
		point1.calcStainer(newPole);
		
		ArrayList<Point> pointList = new ArrayList<Point>();  // stworzenie tablicy przechowujacej obiekty klasy Punkt
		
		// petla tworzaca nowe punkty o "losowych" masach
		for(int x = 0; x<10; x++)
		{
			int randomMass = ThreadLocalRandom.current().nextInt(1, 100);
			
			pointList.add(new Point(randomMass));
		}
		
		System.out.println();
		
		// petla obliczajaca i wyswietlajaca informacje o punktach stworzonych we wczesniejszej peli
		for(int x = 0; x<10; x++)
		{
			Point tempPoint = pointList.get(x);
			
			tempPoint.quickInfo(newPole);
		}
		
		// tworzenie, obliczanie i wyswietlanie informacji o bryle sztywnej
		@SuppressWarnings("unused")
		Solid solid1 = new Solid(3, 1);
		
		
	}

}
