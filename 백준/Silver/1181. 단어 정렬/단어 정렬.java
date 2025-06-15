import java.util.*;

class Word implements Comparable<Word>{
    String word;
    int length;

    Word(String word){
        this.word = word;
        this.length = word.length();
    }

    @Override
    public int compareTo(Word other){
        int lenCompare = Integer.compare(this.length, other.length);
        if (lenCompare != 0) return lenCompare;
        return this.word.compareTo(other.word); // 길이 같을 때 사전순
    }
}

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt(); // 총 개수
        sc.nextLine();

        Set<String> words = new HashSet<>();
        Set<Word> wordSet = new TreeSet<>();

        for(int i = 0; i < total; i++){
            String w = sc.nextLine();
            words.add(w);
        }

        for(String w : words){
            Word word = new Word(w);
            wordSet.add(word);
        }

        for(Word word : wordSet){
            System.out.println(word.word);
        }
    }
}
