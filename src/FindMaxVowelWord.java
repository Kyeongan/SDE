
public class FindMaxVowelWord {

	@SuppressWarnings("null")
	public static void main(String[] args) {

		String sentence = "SP is a scale space framework, "
				+ "enabling the user to gain insight about individual academic entities and "
				+ "their relative contribution to aggregate academic entities. "
				+ "SP's base level covers academics, its second level departments, "
				+ "and its third level colleges. At each level, SP packs in a figure multi-faceted "
				+ "information about the entity's publication, citation, and funding profiles. "
				+ "SP draws data from open sources, including Google Scholar, "
				+ "the Journal Impact Factor List, and OpenGov. Initial feedback through a "
				+ "focus group and a survey study, show that SP is well received by the intended users, "
				+ "having high potential in serving as a complementary assessment tool in merit reviews "
				+ "and an insightful aid in search of an advisor or department. Next steps in this line "
				+ "of research include: a) SP's endowment with a wiki function for faster population "
				+ "of its department and college levels; and b) a longitudinal study to understand "
				+ "SP's usage patterns in practice, feeding back to the design cycle.";
		String[] wordsWithVowel = null;
		String[] words = sentence.split(" ");
		int maxVowelCount = 0;
		int idx = 0;

		for (String word : words) {
			int count = 0;
			word = word.toLowerCase();
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				if (ch == 'a' || ch == 'e' || ch == 'u' || ch == 'o' || ch == 'i') {
					count++;
				}

			}
			
			if (count > maxVowelCount) {
				maxVowelCount = count;
				wordsWithVowel[idx] = word;
			}
			idx++;

		}
		System.out.println(wordsWithVowel + " has (" + maxVowelCount + ") vowels.");
	}

}
