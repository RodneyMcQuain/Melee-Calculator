
public class FormulaUtils {
    /**
	 This method calculates knockback after a crouch cancel by using damage, percent, weight, 
	 knockback scaling, and base knockback.
     */
    public static double cc(double damage, double percent, double weight, double knockbackScaling, double baseKnockback) {
		double knockback = (((((((percent + damage) / 10) + (((percent + damage) * damage)/20)) * (200/(weight + 100)) * 1.4) + 18) * (knockbackScaling / 100)) + baseKnockback) * (2 / 3); //how much a target would get knocked back from a move
		
		return knockback;
	}
    /**
     This method calculates knockback with automatic smash directional influence down by using 
     damage, percent, weight, knockback scaling, and base knockback.
     */
	public static double asdid(double damage, double percent, double weight, double knockbackScaling, double baseKnockback) {
		double knockback = (((((((percent + damage) / 10) + (((percent + damage) * damage)/20)) * (200/(weight + 100)) * 1.4) + 18) * (knockbackScaling / 100)) + baseKnockback); //how much a target would get knocked back from a move
		
		return knockback;
	}
	
	/**
	 This method calculates shieldstun by using move damage.
	 */
	public static int shieldstun(int damage) {
		int shieldstun = 0; //the amount of frames the target is stuck in shield and unactionable
		shieldstun = (int) Math.floor((damage + 4.45) / 2.235);
		
		return shieldstun;
	}
	
	/**
	 This method calculates hitstun by using knockback.
	 */
	public static int hitstun(double knockback) {
		int hitstun = (int) (knockback * .4); //the amount of frames that the target is unactionable while in knockback
		
		return hitstun;
	}
	
	/**
	 This method calculatues hitlag using move damage. 
	 */
	public static int hitlag(int damage) {
		int hitlag = 3 + (damage / 3); //the amount of frames characters are frozen after a move hits

		return hitlag;
	}
	
	/**
	 This method calculates frame advantage on block for move type aerial using shieldstun, 
	 landing lag, and fall frames.
	 */
	public static int frameAdvOnBlockForAerial(int shieldstunDone, int landingLag, int fallFrames) {
		int frameAdvOnBlock = shieldstunDone - landingLag + fallFrames; //frame advantage on block of move
		
		return frameAdvOnBlock;
	}
	/**
	 This method calculates frame advantage on block for move type ground using move shieldstun, 
	 first active frame of a move, and total move frames.
	 */
	public static int frameAdvOnBlockForGround(int shieldstunDone, int firstActive, int totalFrames) {
		int deadFrames = totalFrames - firstActive; //The amount of frames where there is not a relevant active hitbox
		int frameAdvOnBlock = shieldstunDone - deadFrames; //frame advantage on block of move
		
		return frameAdvOnBlock;
	}
	/**
	 This method calculates frame advantage on block for move type projectile using move shieldstun, 
	 move hitlag, and move landing lag.
	 */
	public static int frameAdvOnBlockForProjectile(int shieldstunDone, int hitlag, int landingLag) {
		int frameAdvOnBlock = shieldstunDone + hitlag - landingLag; //frame advantage on block of move
		 
		return frameAdvOnBlock;
	}
	
	/**
	 This method calculates frame advantage on hit for move type aerial using move hitstun, 
	 move landing lag, and move falling frames.
	 */
	public static int frameAdvOnHitForAerial(int hitstun, int landingLag, int fallFrames) {
		int frameAdvOnHit = hitstun - landingLag + fallFrames; //frame advantage on hit of move 
		
		return frameAdvOnHit;
	}
	/**
	 This method calculates frame advantage on hit for move type ground using move hitstun, 
	 first active frame of a move, and total move frames.
	 */
	public static int frameAdvOnHitForGround(int hitstun, int firstActive, int totalFrames) {
		int deadFrames = totalFrames - firstActive; //The amount of frames where there is not a relevant active hitbox
		int frameAdvOnHit = hitstun - deadFrames; //frame advantage on hit of move 
		
		return frameAdvOnHit;
	}
	/**
	 This method calculates frame advantage on hit for move type projectile using move hitstun, 
	 move hitlag, and move landing lag.
	 */
	public static int frameAdvOnHitForProjectile(int hitstun, int hitlag, int landingLag) {
		int frameAdvOnHit = hitstun + hitlag - landingLag; //frame advantage on hit of move 
		
		return frameAdvOnHit;
	}
  
	/*
	 This method calculates frame advantage on Amsah Tech for move type aerial using landing lag,
	 and move fall frames.
	 */
	public static int beforeTechForAerial(int landingLag, int fallFrames) {
		int beforeTech = landingLag + fallFrames;
		
		return beforeTech;
	}
	/*
	 This method calculates frame advantage on Amsah Tech for move type ground using 
	 first active frame of a move, and total move frames.
	 */
	public static int beforeTechForGround(int firstActive, int totalFrames) {
		int beforeTech = totalFrames - firstActive;
		
		return beforeTech;
	}
	/*
	 This method calculates frame advantage on Amsah Tech for move type projectile using move hitlag,
	 and move landing lag.
	 */
	public static int beforeTechForProjectile(int hitlag, int landingLag) {
		int beforeTech = hitlag - landingLag;
		
		return beforeTech;
	}
	
	/*
	 This method calculates frame advantage on Amsah Tech based on tech in place or tech roll and lag before the tech happens.
	 */
	public static int frameAdvOnAmsahTech(String techTypeSelection, int beforeTech) {
   	int frameAdvOnAmsahTech = 0; //frame advantage on at of move
		final int TECH_IN_PLACE = 26; //constant for the amount of frames the animation 'tech in place' takes
		final int TECH_ROLL = 40; //constant for the amount of frames the animation 'tech roll' takes

		if (techTypeSelection.equals("Tech in Place")) {
			frameAdvOnAmsahTech = TECH_IN_PLACE - beforeTech;
		} else if (techTypeSelection.equals("Tech Roll")) {
			frameAdvOnAmsahTech = TECH_ROLL - beforeTech;
		}
		
		return frameAdvOnAmsahTech;
	}
}
