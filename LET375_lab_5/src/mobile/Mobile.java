package mobile;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Mobile {
	private enum MobileType { SIMPLE, COMPOSITE }
	private MobileType type;
	private float weight;                   // Simple
	private float leftLength, rightLength;  // Composite
	private Mobile left, right;
	
	public Mobile( float weight ) {
		type = MobileType.SIMPLE;
		this.weight = weight;
		left = null;
		right = null;
		
	}
	
	public Mobile( Mobile left, float leftLength, Mobile right, float rightLength ) {
		type = MobileType.COMPOSITE;
		this.left = left;
		this.right = right;
	    this.leftLength = leftLength;
	    this.rightLength = rightLength;	
	}
	
	// Return the total mass of the mobile
	public float getWeight() {
		if ( isSimple() )
			return weight;
		else
			return left.getWeight() + right.getWeight();
	}  
	
	// Return the maximum height of the mobile
	public int getHeight() { 						// COMPLETE
		int depth = 0;
		
		if( this.type == MobileType.SIMPLE )		// Base case
			return 1;
		else {										// Recursive case
			int maxLeft = this.left.getHeight();
			int maxRight = this.right.getHeight();
			depth = 1 + Math.max(maxLeft, maxRight); // count current mobile and max depth of subtrees
		}
		return depth;
	}  
	
	// Print the leaves of the mobile
	public void flatten()  { // JOHAN'S TASK
	      // ...
	}  
	
//	Print a structured view of the mobile
	public void prettyPrint() { // JOHAN'S TASK
	      // ...
	}
	
// Determine if the mobile is balanced
	public boolean isBalanced() { 
		final double eps = 0.000001;
		return isSimple() ||
		    left.isBalanced() && right.isBalanced() &&
		        Math.abs( leftLength * left.getWeight() -
				rightLength * right.getWeight() ) < eps;
	}   
	
//	Return a clone of this mobile
	public Mobile clone() { // ANTON'S TASK
         // ...
         return null;
	}
	
// Change this mobile to its mirror image
	public void mirror() { // ANTON'S TASK		(may work, cannot test)
		
		if( this.type == MobileType.SIMPLE )		// Base case
			return;
		else {										// Recursive case
			this.left = this.right;
			this.right = this.left;
		}
	}
	
	private boolean isSimple() { 
		return type == MobileType.SIMPLE; 
	}
	
	public static void main(String[] args) {
		Mobile  m1 = new Mobile( 1 ),
		        m2 = new Mobile( new Mobile( 2 ), 6,  new Mobile( 3 ), 4 ),
		        m = new Mobile( m1, 10, m2, 2 );
	
		System.out.println("Total mass: " + m.getWeight() );
		System.out.println("Height:     " + m.getHeight() );
		
//		m.flatten(); System.out.println();
//		m.prettyPrint(); System.out.println();
//		if ( m.isBalanced() )
//			System.out.println("Balanced!");
//		else
//			System.out.println("Not balanced!");
/*		
		Mobile m22 = new Mobile( new Mobile( 2 ), 6,  new Mobile( 3 ), 4 ),
		       m3 = new Mobile( m1, 10, m22, 2 );
		if ( m.equals(m3) )
			System.out.println("Equal!");		// They should be!
		else
			System.out.println("Not equal!");
		
		Mobile c = m.clone();
		if ( c.equals(m) )
			System.out.println("Equal!");		// They should be!
		else
			System.out.println("Not equal!");

		if ( c == m )
			System.out.println("Identical!");	// They should definately not!
		else
			System.out.println("Not identical!");
		
		m.mirror();
		m.prettyPrint(); System.out.println();
		m.mirror();
		m.prettyPrint(); System.out.println();
*/
	}
}