/**
 * 
 */
package com.microsoft.algorithm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * @author theagape
 *
 */
/*
Given a pair of English words determine whether there is a way to transform one word into the other
by changing one letter at a time and ensuring that all intermediate steps are valid English words.


word
wards

world
work
wors x
*/

public class WordTransform {
	
	static final int CHECK_FOUND_MATCH = -1;
	static final int CHECK_NOT_A_WORD = -2;
	static final int CHECK_ALREADY_IN_HASHTABLE = 0;
	static final int CHECK_NEW_WORD = 1;
	
	MyDictionary dictionary;
	String alphabet = "abcdefghijklmnopqrstuvwxyz";
	ArrayList<String> newWords = null;
	ArrayList<String> oldWords = null;
	
	public WordTransform() {
		this.dictionary = new MyDictionary();
		this.newWords = new ArrayList<String>();
		this.oldWords = new ArrayList<String>();
	}
	
	/**
	 * 
	 * @param word
	 * @return the number of words which are inserted into this.hashtable
	 */
	public int iterateInsert(String targetWord, String word) {		
		int numOfWords = 0;
		String tempWord = null;
		char ch = 0;
		int lenWord = word.length();
		int lenAlphabet = this.alphabet.length();
		int check = -1;
		
		for (int i = 0 ; i < lenWord + 1 ; i++) {
			
			for (int j = 0 ; j < lenAlphabet ; j++) {
				
				ch = this.alphabet.charAt(j);
				
				if (i < lenWord) {
					tempWord = word.substring(0, i) + ch + word.substring(i, lenWord);
				}
				else {
					tempWord = word + ch;
				}
				
				// for debugging!!
				// System.out.println(tempWord);
				
				// check & put into hashtableNewWords
				check = this.checkWord(targetWord, tempWord);
				
				switch(check) {
				case WordTransform.CHECK_FOUND_MATCH:
					this.oldWords.add(tempWord);
					return WordTransform.CHECK_FOUND_MATCH;
					// break;
				case WordTransform.CHECK_NOT_A_WORD:
					// discard tempWord
					break;
				case WordTransform.CHECK_ALREADY_IN_HASHTABLE:
					// discard tempWord
					break;
				case WordTransform.CHECK_NEW_WORD:
					this.newWords.add(tempWord);
					numOfWords++;
					break;
				}
				
			}
			
		}
		
		return numOfWords;
	}
	
	public int iterateDelete(String targetWord, String word) {
		int numOfWords = 0;
		String tempWord = null;
		int lenWord = word.length();
		int check = -1;
		
		for (int i = 0 ; i < lenWord ; i++) {
		
			tempWord = word.substring(0, i) + word.substring(i+1, lenWord);
			
			// for debugging!!
			// System.out.println(tempWord);
			
			// check & put into hashtableNewWords
			check = this.checkWord(targetWord, tempWord);
			
			switch(check) {
			case WordTransform.CHECK_FOUND_MATCH:
				this.oldWords.add(tempWord);
				return WordTransform.CHECK_FOUND_MATCH;
				// break;
			case WordTransform.CHECK_NOT_A_WORD:
				// discard tempWord
				break;
			case WordTransform.CHECK_ALREADY_IN_HASHTABLE:
				// discard tempWord
				break;
			case WordTransform.CHECK_NEW_WORD:
				this.newWords.add(tempWord);
				numOfWords++;
				break;
			}
			
		}
		
		return numOfWords;
	}
	
	public int iterateSwitch(String targetWord, String word) {
		int numOfWords = 0;
		String tempWord = null;
		char ch = 0;
		int lenWord = word.length();
		int lenAlphabet = this.alphabet.length();
		int check = -1;
		
		for (int i = 0 ; i < lenWord ; i++) {
			
			for (int j = 0 ; j < lenAlphabet ; j++) {
				
				ch = this.alphabet.charAt(j);
				
				tempWord = word.substring(0, i) + ch + word.substring(i+1, lenWord);
				
				// for debugging!!
				// System.out.println(tempWord);
				
				// check & put into hashtableNewWords
				check = this.checkWord(targetWord, tempWord);
				
				switch(check) {
				case WordTransform.CHECK_FOUND_MATCH:
					this.oldWords.add(tempWord);
					return WordTransform.CHECK_FOUND_MATCH;
					// break;
				case WordTransform.CHECK_NOT_A_WORD:
					// discard tempWord
					break;
				case WordTransform.CHECK_ALREADY_IN_HASHTABLE:
					// discard tempWord
					break;
				case WordTransform.CHECK_NEW_WORD:
					this.newWords.add(tempWord);
					numOfWords++;
					break;
				}
				
			}
			
		}
		
		return numOfWords;
	}
	
	private int checkWord(String targetWord, String word) {
		
		/*
		 * [1] match?
		 */
		if (targetWord.equalsIgnoreCase(word)) {
			return WordTransform.CHECK_FOUND_MATCH;
		}
		
		/*
		 * [2] already exists in hashtableNew/OldWords?
		 */
		if (this.newWords.contains(word.toLowerCase())
				|| this.oldWords.contains(word.toLowerCase())) {
			return WordTransform.CHECK_ALREADY_IN_HASHTABLE;
		}
		
		/*
		 * [3] is it a word?
		 */
		if (this.dictionary.lookup(word) == false) {
			return WordTransform.CHECK_NOT_A_WORD;
		}
		
		return WordTransform.CHECK_NEW_WORD;
	}
	
	/*
	private String insert(String word, char c, int index) {
	    // inserts... c in index
		String result = word;
		
	    return result;
	}
	*/
	
	public String update(String word, char c, int index) {
	    // update/switch word[index] with c
	    return word;
	}
	
	public String delete(String word, int index) {
	    // deletes a char from word at index
	    return word;
	}
	
	public boolean checkTransform(String targetWord, String inputWord) {
		// targetWord = "worlds"; // target word
		// inputWord = "worker"; // input word
		
		String word = null;
		int numOfNewInsertWords = 0;
		int numOfNewDeleteWords = 0;
		int numOfNewSwitchWords = 0;
		
		boolean result = false;
		
		this.newWords.add(inputWord);
		
		while(this.newWords.isEmpty() == false) {
			// word = this.newWords.remove(this.newWords.size()-1);
			word = this.newWords.remove(0);
			
			this.oldWords.add(word);
			
			// for debugging!!
			System.out.println("> Examine : " + targetWord + " vs. " + word);
			
			// for debugging!!
			System.out.println("\t--- ITR INSERT ---");
			numOfNewInsertWords = this.iterateInsert(targetWord, word);
			
			if (numOfNewInsertWords == WordTransform.CHECK_FOUND_MATCH) {
				return true;
			}
			
			// for debugging!!
			System.out.println("\t--- ITR DELETE ---");
			numOfNewDeleteWords = this.iterateDelete(targetWord, word);
			
			if (numOfNewDeleteWords == WordTransform.CHECK_FOUND_MATCH) {
				return true;
			}
			
			// for debugging!!
			System.out.println("\t--- ITR SWITCH ---");
			numOfNewSwitchWords = this.iterateSwitch(targetWord, word);
			
			if (numOfNewSwitchWords == WordTransform.CHECK_FOUND_MATCH) {
				return true;
			}
			
			// for debugging!!
			this.printOldWords();
		}
		
		/*
		int i = 0;
		int j = 0;
		while (i < word1.length() && j < word2.length()) {                
			    
			if (word1.charAt(i) == word2.charAt(j)) {
				i++;
				j++;
			    continue;
			}
		        
		    // change 1 char of word2
			// determine changed word2 in dictionary
			// if yes, move on --> compare to word1
			//                 --> match (return true) or not (loop)
			
			// otherwise
			// change 1 char of word1
			// determine changed word1 in dictionary
			// if yes, move on
			// otherwise return false
		}
		*/
		
		return result;
	}
	
	public void printOldWords() {
		
		Iterator<String> iterator = this.oldWords.iterator();
		
		System.out.println(">> Generated Words <<");
		
		for (int i = 1 ; iterator.hasNext() ; i++) {
			System.out.println("\t-> [" + i + "] : " + iterator.next());
		}
		
	}
	
	public static void main(String[] args) {
		String word1 =
				// "so";
				"sword";
		String word2 =
				// "too";
				"ward";
		
		WordTransform wt = new WordTransform();
		
		System.out.println("\n> Determined : [" + wt.checkTransform(word1, word2) + "]");
		
		System.out.println();
		
		System.out.println(">> === RESULT WORDS === <<");
		wt.printOldWords();
		
	}
	
	
	class MyDictionary {
		
		String[] words = {
			"so", "soak", "soar", "soap", "sol", "son", "soon", "soup", "sour",
			"sword", "swarm", "swan", "swiss", "swallow", "swing",
			"to", "token", "toll", "tom", "tomb", "ton", "too", "tool", "tour", "tow", "towel", "tower", "toy", "two",
			"war", "was", "wall", "wax","warp", "ward", "warrior", "wander",
			"west", "western", "well", "wear", "web", "went",
			"word", "world", "worn", "wolf", "work", "worry"
		};
		
		Hashtable<String, String> dict = new Hashtable<String, String>();
		
		public MyDictionary() {
			this.init();
		}
		
		private void init() {
			for (String word:this.words) {
				
				this.dict.put(word, word);
				
			}
		}
		
		boolean lookup(String word) {			
			return this.dict.containsKey(word.toLowerCase());
		}
		
	}

}
