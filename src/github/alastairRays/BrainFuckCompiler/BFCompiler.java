package github.alastairRAyls.BrainFUckCompiler;

import java.util.Scanner;

public class BFInterpreter {

  //Default Memory amount for the program
  public static int programSize = 100;

  //The array that will hold all the pointers (Program Memory)
  //for the program.
  private int[] program;

  //The pointer variable will determine the value for each
  //element int the program array
  private int pointer = 0;

  //Constructors to set the size of the memory that will be
  //allocated for the program.
  public BFInterpreter() {

    program = new int[programSize];

  }
  public BFInterpreter(int size) {

    program = new int[size];

  }

  //The main Function
  public void interpret(String bfsource) {    

    //Scanner to get input from user when a comma char is found.
    Scanner input = new Scanner(System.in);

    //This loops though all the BrainF**ck source code.
    for (int i = 0; i < bfsource.length(); i++) {
      
      //If statements to determine what action should be taken for each char.

      /*
       * The chars are as follow:
       * > (Greater than char): Moves to the next pointer.
       * < (Less than char): Moves to the previous pointer.
       * + (Addition char): Adds one to the current pointer.
       * - (Subtraction char): Subtracts one from the current pointer.
       * [ (Left bracket char): Starts a loop.
       * ] (Right bracket char): Ends the loop.
       *
       *    //note that the loop will end only when the current pointer is not 0.  while (pointer != 0) {}
       *
       * . (Dot char): Prints value of pointer in ASCII character(s).
       * , (Comma char): Gets input from user and stores first character imputed as ASCII on the current pointer.
       *                 For instance if input was "Hello", the program will store the ASCII value of capital H on current pointer.
       */

        if (bfsource.charAt(i) == '>') {
                
          ++pointer;
                
        } else if (bfsource.charAt(i) == '<') {
                
          --pointer;
                
        } else if (bfsource.charAt(i) == '+') {
                
          program[pointer]++;
                
        } else if (bfsource.charAt(i) == '-') {
                
          program[pointer]--;
                
        } else if (bfsource.charAt(i) == ',') {
                
          program[pointer] = input.next().charAt(0);
                
        } else if (bfsource.charAt(i) == '.') {
                
          System.out.print((char)program[pointer]);
                
        } else if (bfsource.charAt(i) == '[') {

          //Variable to determine how many loops will happen.
          int loop = 1;

            //Running through the loop starter.
            if (program[pointer] == 0) {
                    
              while (loop != 0) {
                        
                i++;
                        
                if (bfsource.charAt(i) == '[') {
                            
                  loop++;
                            
                } else if (bfsource.charAt(i) == ']') {
                            
                  loop--;
                            
                }
                        
              }
                
            }
                
        } else if (bfsource.charAt(i) == ']') {

          //Running through the loop end.
          if (program[pointer] != 0) {
                    
            int loop = 1;
                    
            while (loop != 0) {
                        
              i--;
                        
              if (bfsource.charAt(i) == ']') {
                            
                loop++;
                            
              } else if (bfsource.charAt(i) == '[') {
                            
                loop--;
                            
              }
                        
            } 
                    
          }
                
        }
            
      }

    }

}
