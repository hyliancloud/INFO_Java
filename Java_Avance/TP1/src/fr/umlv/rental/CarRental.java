package fr.umlv.rental;

import fr.umlv.vehicle.IVehicle;

import java.util.*;
import java.util.stream.Collectors;

public class CarRental
{
	private final List<IVehicle> vehicles;
	
	public CarRental()
	{
		this.vehicles = new ArrayList<>();
	}
	
	public void add(IVehicle vehicle)
	{
		this.vehicles.add(Objects.requireNonNull(vehicle));
	}
	
	public void remove(IVehicle vehicle)
	{
		Objects.requireNonNull(vehicle);

		if(!vehicles.contains(vehicle))
		{
			throw new IllegalStateException("Cars does not contain this car : " + vehicle);
		}

		this.vehicles.remove(vehicle);
	}
	
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		
		Iterator<IVehicle> carsIterator = this.vehicles.iterator();
		
		while(carsIterator.hasNext())
		{
			str.append(carsIterator.next());
			if(carsIterator.hasNext())
			{
				str.append('\n');
			}
		}
		
		return str.toString();
	}

	public List<IVehicle> findAllByYear(int year)
	{
		return vehicles.stream()
				.filter( vehicle -> year == vehicle.getYear())
				.collect(Collectors.toList());
	}

	public int insuranceCostAt(int year)
	{
		int total = 0;

		for(IVehicle vehicle : vehicles)
		{
			total += vehicle.getInsuranceCost(year);
		}

		return total;
	}
/**
	public Optional<IVehicle> findACarByModel(String model)
	{

	}*/
}

/**
 * L'interface Stream
 */
