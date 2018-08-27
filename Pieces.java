public class Pieces {

	private String pieceName;
	private int xCoordinate;
	private int yCoordinate;
	
	//DEFAULT
	public Pieces () {
		pieceName = "[b]";
		xCoordinate = 0;
		yCoordinate = 0;
	}
	
	//CUSTOM
	public Pieces (String pieceName, int xCoordinate, int yCoordinate) { 
		this.pieceName = pieceName;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	
	
	//GETTER
	public String getPieceName() {
		return pieceName;
	}
	public int getXCoordinate () {
		return xCoordinate;
	}
	
	public int getYCoordinate () {
		return yCoordinate;
	}
	
	
	//SETTER
	public void setPieceName(String pieceName) {
		this.pieceName = pieceName;
	}
	public void setXCoordinate (int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	public void setYCoordinate (int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	
}
