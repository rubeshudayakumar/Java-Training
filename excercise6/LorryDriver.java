package excercise6;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class LorryDriver {

	public float speedKmperHr;
	public float distanceKm;
	public LocalDateTime dateTime;
	public float totalTimeTaken;
	
	static boolean isHoliday = false;

	public LorryDriver(float speedKmperHr, float distanceKm, LocalDateTime dateTime) {
		this.speedKmperHr = speedKmperHr;
		this.distanceKm = distanceKm;
		this.dateTime = dateTime;
	}

	public void calculateTotalTimeTaken() {
		totalTimeTaken = (this.distanceKm / this.speedKmperHr) * 60;
	}

	public void travelFirstDay() {

		skipLeaveAtEndAndStart();
		
		if(isHoliday) return;
		
		LocalDateTime takesNextDay = dateTime.plusMinutes(8*60);

		if (takesNextDay.getDayOfMonth() != dateTime.getDayOfMonth()) {

			LocalTime midnight = LocalTime.MIDNIGHT;
			LocalDate today = dateTime.toLocalDate().plusDays(1);
			LocalDateTime todayMidnight = LocalDateTime.of(today, midnight);
			long minutes = ChronoUnit.MINUTES.between(dateTime, todayMidnight);
			dateTime = dateTime.plusMinutes(minutes);
			totalTimeTaken -= minutes;
			dateTime = dateTime.withHour(9);

		} else {
			if (totalTimeTaken <= 8 * 60) {
				dateTime = dateTime.plusMinutes((long) totalTimeTaken);
				totalTimeTaken = 0;
			} else {
				totalTimeTaken -= (8 * 60);
				dateTime = dateTime.plusMinutes(8 * 60);
				dateTime = dateTime.plusDays(1).withHour(9);
			}

		}
	}

	public boolean isHoliday() {
		int currentDay = dateTime.getDayOfMonth();
		if ((currentDay >= 8 && currentDay <= 14 && dateTime.getDayOfWeek().getValue() == 6)
				|| (dateTime.getDayOfWeek().getValue() == 7)
				|| (dateTime.getMonth().getValue() == 1 && dateTime.getDayOfMonth() == 1)
				|| (dateTime.getMonth().getValue() == 1 && dateTime.getDayOfMonth() == 26)
				|| (dateTime.getMonth().getValue() == 8 && dateTime.getDayOfMonth() == 15)) {
			isHoliday = true;
			return true;
		} else {
			return false;
		}
	}

	public void travel() {
		skipLeaveAtEndAndStart();
		while (totalTimeTaken >= (8 * 60)) {
			if (isHoliday()) {
				dateTime = dateTime.plusDays(1);
				continue;
			}
			dateTime = dateTime.plusMinutes(8 * 60);
			totalTimeTaken -= (8 * 60);
			dateTime = dateTime.plusDays(1).withHour(9);

		}
		skipLeaveAtEndAndStart();
		dateTime = dateTime.plusMinutes((long) totalTimeTaken);

		totalTimeTaken = 0;
	}

	public void skipLeaveAtEndAndStart() {

		while (isHoliday()) {
			dateTime = dateTime.plusDays(1).withHour(9);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		float speed, distance;
		System.out.println("CURRENT TIME : " + date.format(dateTime));
		System.out.println("Enter the speed of the lorry : ");
		speed = scanner.nextFloat();
		System.out.println("Enter the distance to be travelled by the lorry : ");
		distance = scanner.nextFloat();

		LorryDriver lorryDriver = new LorryDriver(speed, distance, dateTime);

		lorryDriver.calculateTotalTimeTaken();
		lorryDriver.travelFirstDay();
		lorryDriver.travel();

		System.out.println("Lorry Arrived at : " + date.format(lorryDriver.dateTime));
		scanner.close();
	}
}
