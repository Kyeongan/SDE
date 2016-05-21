
public class isSameOrder {

	public static void main(String[] args) {
		
		String a = "abcNjAhNgAhGjhfhAljhRkhgRbhjbevfhO";
		String b = "NAGARRO";
		
		System.out.println("Is this same order? " + checkOrder(a, b));
		

	}
	
	public static boolean checkOrder(String source, String sample) {
		int idxSource = 0;
		int idxSample = 0;
		for( idxSource=0 ; idxSource<source.length() ; idxSource++ ) {
			if( source.charAt(idxSource) == sample.charAt(idxSample) )
				idxSample ++ ;
		}
		if( idxSample == sample.length() )
			return true;
		else
			return false;
	}

}
