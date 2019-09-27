package de.stl.saar.internetentw1.model;

/**
 * Eine Klasse zur Verwaltung von Räumen. Räume bestehen hierbei aus
 * einer Gebäudenummer, einer Etagennummer und einer Raumnummer.
 */
public class Room {
	private int building;
	private int floor;
	private int room;
	
	public Room(int building, int floor, int room) {
		super();
		this.building = building;
		this.floor = floor;
		this.room = room;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (this.room != other.room)
			return false;
		if (this.toString() == null) {
			if (other.toString() != null)
				return false;
		} else if (!toString().equals(other.toString()))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (building ^ (building >>> 32));
		result = prime * result + (int) (floor ^ (floor >>> 32));
		result = prime * result + (int) (room ^ (room >>> 32));
		return result;
	}

	public int getBuilding() {
		return building;
	}
	
	public void setBuilding(int building) {
		this.building = building;
	}
	
	public int getFloor() {
		return floor;
	}
	
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	public int getRoom() {
		return room;
	}
	
	public void setRoom(int room) {
		this.room = room;
	}
	
	@Override
	public String toString() {
		return String.valueOf(building) + String.valueOf(floor) + String.valueOf(room);
	}
}
