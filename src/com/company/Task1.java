package com.company;


import java.util.HashMap;
import java.util.Map;

public class Task1 {

    static Map<Character, Integer> characters = new HashMap<>();

    public static void main(String[] args){
        System.out.println(solution("lemon","melon"));
    }

    public static int solution(String a, String b){
        if( a.length()>=b.length()){
            loopTallerString(a);
            loopShorterString(b);
        } else {
            loopTallerString(b);
            loopShorterString(a);
        }
        return collectMap(characters);
    }

    public static void loopTallerString(String s){
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            if(characters.containsKey(c)){
                characters.put(c, characters.get(c)+1);
            } else {
                characters.put(c, 1);
            }
        }
    }

    public static void loopShorterString(String s){
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            if(characters.containsKey(c)){
                int prevInt = characters.get(c);
                if(prevInt > 1) {
                    characters.put(c, characters.get(c) - 1);
                } else {
                    characters.remove(c);
                }
            } else {
                characters.put(c, 1);
            }
        }
    }

   public static int collectMap(Map<Character, Integer> map){
        int result=0;
        for( Integer i: map.values()){
            result+=i;
        }
        return result;
   }
}
