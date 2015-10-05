package FootballSim;

/**
 * Enumerated value to store information about how a given FootballPlayer is moving, with a 
 * noticeable impact on their speed and agility. For example, sprinting would be faster than 
 *  backpedaling, but backpedaling has other advantages. The list of MoveTypes will be expanded 
 *  as I become aware of other distinct motions and how to refer to them. 
 * 
 * @author Rick
 */
public enum MoveType {
	SPRINT, BACKPEDAL;
}
