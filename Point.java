package lab1;


public class Point 
{
	private double mass;   // masa punktu
	private double radius;   // odleglosc punktu od bieguna w zerze
	private static int baseID = 1;  // identyfikator pierwszego punktu
	private int id;   // identyfikator punktu wporwadzony dla lepszej czytelnosci wynikow
	
	Point()  // konstruktor domyslny
	{
		this.mass = 10;
		this.radius = 5;
		this.id = baseID;

		baseID++;
	}
	
	Point(int mass)  // konstruktor punktu pozwalajacy na stworzenie punkty o wybranej masie
	{
		this.mass = mass;
		this.radius = 5;
		this.id = baseID;

		baseID++;
	}
	
	
	Point(double mass, double radius)  // uproszczony konstruktor dla punktow nalezacych do bryly
	{
		this.mass = mass;
		this.radius = radius;
	}
	
	
	void changeMass(double newMass)  // metoda pozwalajaca zmienic mase punktu
	{
		this.mass = newMass;
	}
	
	
	void calcInertia()  // obicza moment wzgledem bieguna w zerze
	{
		double inertia = this.mass * Math.pow(radius, 2);
		
		System.out.println("Moment bezwladnosci wzgledem glownej osi wynosi: " + inertia);
	}
	
	
	void calcStainer(int newPole)  // oblicza moment wzgledem dowolnego bieguna
	{
		double newRadius = this.radius + Math.abs(newPole);
		
		double inertia = this.mass * Math.pow(newRadius, 2);
		
		System.out.println("Moment bezwladnosci punktu wzgledem nowej osi w: " + newPole + " , wynosi: " + inertia);
		
	}
	
	
	void showInfo()  // metoda wyswietlajaca podstawowe informacje o punkcie
	{
		System.out.println("Punkt materialny numer: " + id);
		System.out.println("Masa punktu: " + this.mass);
	}
	
	
	void quickInfo(int newPole)  // metoda wyswietlajaca wszystkie informacje o punkcie
	{
		showInfo();
		calcInertia();
		calcStainer(newPole);
		
		System.out.println();
	}
	
	
	double getMass()   // metoda zwracajaca wartosc masy punktu
	{
		return this.mass;
	}

	
	double getRadius()  // metoda zwracajaca wartosc odleglosci punktu od osi 0
	{
		return this.radius;
	}
	
	void showInfo2()  // metoda wyslwietlajaca skrocone informacje dla punktow nalezacych do bryly
	{
		System.out.println("masa:  " + this.mass + "  polozenie wzgledem osi 0:  " + this.radius);
	}
}
