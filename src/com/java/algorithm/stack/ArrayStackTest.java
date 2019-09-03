package com.java.algorithm.stack;

import com.java.algorithm.stack.ResizingArrayStack;

import java.util.Arrays;

/**
 * Created by mihir.desai on 1/25/2018.
 */
public class ArrayStackTest {

    public static void main(String[] args) {


        MaxStackWithCachedMax maxStackWithCachedMax = new MaxStackWithCachedMax();
        maxStackWithCachedMax.push(2);
        maxStackWithCachedMax.push(2);
        maxStackWithCachedMax.push(1);
        maxStackWithCachedMax.push(4);
        maxStackWithCachedMax.push(5);
        maxStackWithCachedMax.push(5);
        maxStackWithCachedMax.push(3);
        maxStackWithCachedMax.pop();
        System.out.println("max - "+maxStackWithCachedMax.max());
        maxStackWithCachedMax.pop();
        maxStackWithCachedMax.pop();
        System.out.println("max - "+maxStackWithCachedMax.max());
        maxStackWithCachedMax.pop();
        maxStackWithCachedMax.pop();
        System.out.println("max - "+maxStackWithCachedMax.max());


        Integer[] a = { 10, 9, 8 };
        System.out.println("Before reverse - "+ Arrays.toString(a));
        reverse(a);
        System.out.println("After reverse - "+ Arrays.toString(a));

        String valid = "{a}{b}({ab})";
        System.out.println("Expression is matched for " + valid + " - "+isMatched(valid));

        valid = "{a}{b}({ab}]";
        System.out.println("Expression is matched for " + valid + " - "+isMatched(valid));

      /*  String html = "<html><body><h1>This is a h1</h1><h2>This is h2</h2></body></html>";
        System.out.println("Valid HTML - "+isHTMLMatched(html));

        html = "<html><body><h1>This is a h1</h1><h2>This is h2</body></html>";
        System.out.println("Valid HTML - "+isHTMLMatched(html));*/

        MaxStack maxStack = new MaxStack();
        maxStack.push(2);
        maxStack.push(2);
        maxStack.push(1);
        maxStack.push(4);
        maxStack.push(5);
        maxStack.push(5);
        maxStack.push(3);
        maxStack.pop();
        System.out.println("max - "+maxStack.max());
        maxStack.pop();
        maxStack.pop();
        System.out.println("max - "+maxStack.max());
        maxStack.pop();
        maxStack.pop();
        System.out.println("max - "+maxStack.max());

    }

    public static <T> void reverse(T[] a) {
        ResizingArrayStack<T> stack = new ResizingArrayStack<>(a.length);
        for(int i = 0 ; i < a.length; i++) {
            stack.push(a[i]);
        }

        for(int i = 0; i < a.length; i++) {
            a[i] = stack.pop();
        }
    }

    public static boolean isMatched(String expression) {
        final String opening = "({[";
        final String closing = ")}]";
        ResizingArrayStack<Character> buffer = new ResizingArrayStack<>();

        for(char c : expression.toCharArray()) {
            if(opening.indexOf(c) != -1) {
                buffer.push(c);
            } else if(closing.indexOf(c) != -1) {
                if(buffer.isEmpty()) {
                    return false;
                }

                if(closing.indexOf(c) != opening.indexOf(buffer.pop())) {
                    return false;
                }
            }
        }

        return buffer.isEmpty();
    }

    public static boolean isHTMLMatched(String html) {
        ResizingArrayStack<String> buffer = new ResizingArrayStack<>();
        int j = html.indexOf('<');
        while(j != -1) {
            int k = html.indexOf('>',j + 1);

            if(k == -1) {
                return false;
            }

            String tag = html.substring(j+1,k);

            if(!tag.startsWith("/")) { // opening tag
                buffer.push(tag);
            } else { // closing tag
              if(buffer.isEmpty()) {
                  return false;
              }
               // first character is '/' so exclude for compare
              if( !tag.substring(1).equalsIgnoreCase(buffer.pop())) {
                  return false;
              }
            }

            j = html.indexOf("<",k + 1); // find next '<' in the html to proceed
        }

        return buffer.isEmpty();
    }
}
