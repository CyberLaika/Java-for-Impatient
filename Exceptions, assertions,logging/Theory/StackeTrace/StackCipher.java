package Theory.StackeTrace;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class StackCipher {


        public static void main(String[] args) {
            stackFileRot13("theoryTest.txt","tt.txt");
            //stackFileRot13("theoryTest.txt","tt.txt");
        }

        public static void stackFileRot13(String filenameFrom, String filenameTo ){
            Scanner in = null;
            PrintWriter out = null;
            try {
                File fileFrom = new File(filenameFrom);
                File fileTO = new File(filenameTo);
                in = new Scanner(fileFrom);
                out = new PrintWriter(fileTO);
                while (in.hasNextLine()) {
                    out.println(stackStrRot13(in.nextLine()));
                }
            } catch (NullPointerException e) {
                System.err.println("null filename");
            } catch (FileNotFoundException e) {
                System.err.println("File wasn't found");
            } catch (SecurityException e) {
                System.err.println("Don't have access to file");
            } catch (IllegalStateException e) {
                System.err.println("Scanner is closed, data can't be written");
            }catch (IllegalArgumentException e){
                System.err.println("Please use english");
            }
            finally {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            }

        }

        public static String stackStrRot13(String str) throws IllegalArgumentException{
            StringBuilder result=new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                result.append(charRot13(str.charAt(i)));
            }
            return result.toString();
        }

        public static char charRot13( char ch){
            int abyte=ch;
            if(abyte>150) {
                IllegalArgumentException e = new IllegalArgumentException("Remember, no Russian");
                e.printStackTrace();
                throw e;
            }
            int cap = abyte & 32;
            abyte &= ~cap;
            abyte = ((abyte >= 'A') && (abyte <= 'Z') ? ((abyte - 'A' + 13) % 26 + 'A') : abyte) | cap;
            return (char) abyte;
        }

}
