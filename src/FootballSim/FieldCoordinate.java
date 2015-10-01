package FootballSim;

/**
 * Class denoting a location on a FootballField
 * @author Rick
 *
 */
public class FieldCoordinate {
	int vert;
	int horz;
	
	public FieldCoordinate(int v, int h) {
		vert = v;
		horz = h;
	}
	
	public FieldCoordinate(FieldCoordinate aCoord) {
		vert = aCoord.getVert();
		horz = aCoord.getHorz();
	}
	
	/**
	 * constructs a new coordinate by combining two other coordinates
	 * forces new coordinate to remain within the bounds of the field. 
	 * @param coord1
	 * @param coord2 (usually a vector)
	 */
	public FieldCoordinate(FieldCoordinate coord1, FieldCoordinate coord2) {
		vert = coord1.getVert() + coord2.getVert();
		horz = coord1.getHorz() + coord2.getHorz();
		
		// constrain coordinates to within a range of 0-119 for vert and 0-52 for horz
		if (vert >= 120) {
			vert = 119;
		}
		else if (vert < 0) {
			vert = 0;
		}
		if (horz >= 53) {
			horz = 52;
		}
		else if (horz < 0) {
			horz = 0;
		}
	}
	
	public int getVert() {
		return vert;
	}
	
	public int getHorz() {
		return horz;
	}
	
	/**
	 * override of equals method, compares vert and horz values
	 */
	public boolean equals(Object o) {
		boolean isEqual = false;
		if (o instanceof FieldCoordinate) {
			FieldCoordinate otherCoord = ((FieldCoordinate)o);
			if (otherCoord.getVert() == getVert() &&
					otherCoord.getHorz() == getHorz()) {
				isEqual = true;
			}
		}
		
		return isEqual;
	}
	
	/**
	 * override of hashCode
	 */
	public int hashCode() {
		int hash = 13;
		hash = (hash + getVert()) * 17;
		hash = (hash + getHorz()) * 17;
		
		return hash;
	}
	
	/**
	 * override of toString, returns coordinate pair in standard (x, y) notation.
	 */
	public String toString() {
		return "(" + getVert() + ", " + getHorz() + ")";
	}
}
