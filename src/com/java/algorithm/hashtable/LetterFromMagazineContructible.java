package com.java.algorithm.hashtable;

import com.java.stdlib.StdOut;

import java.util.HashMap;
import java.util.Map;

public class LetterFromMagazineContructible {

    public static boolean canConstructLetterFromMagazine(String letter,String magazine) {

        Map<Character,Integer> charFrequenciesForLetter = new HashMap<>();

        for(int i = 0; i < letter.length(); i++) {
            char c = letter.charAt(i);
            /*if(!charFrequenciesForLetter.containsKey(c)) {
                charFrequenciesForLetter.put(c,1);
            } else {
                charFrequenciesForLetter.put(c, charFrequenciesForLetter.getOrDefault(c,0) + 1);
            }*/

            charFrequenciesForLetter.put(c, charFrequenciesForLetter.getOrDefault(c,0) + 1);
        }

        for(int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if(charFrequenciesForLetter.containsKey(c)) {
                charFrequenciesForLetter.put(c, charFrequenciesForLetter.getOrDefault(c,1) -1);
                if(charFrequenciesForLetter.get(c) == 0) {
                    charFrequenciesForLetter.remove(c);
                    // all characters for letters are matched
                    if(charFrequenciesForLetter.isEmpty()) {
                        break;
                    }
                }
            }
        }

        return charFrequenciesForLetter.isEmpty();

    }

    public static void main(String[] args) {
        String letter = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet.";
        String magazine = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc,";
        StdOut.println(canConstructLetterFromMagazine(letter,magazine));
    }
}
