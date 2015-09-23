package FootballSim;

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
}
