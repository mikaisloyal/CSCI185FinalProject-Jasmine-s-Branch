/*
ProjectName
CSCI 185
M03
Aron Lin, Rita Chen, Htoo Naing, Zhasmin Tuiachieva
Date of last contribution (Use the date on Github commit)
*/

package src;

public class University {
        //University instance variables
        private String uniName;
        private String uniCountry;

        //Constructors
        public University(String uniName, String uniCountry){
            this.uniName = uniName;
            this.uniCountry = uniCountry;
        }

        //Getters
        public String getUniName(){
            return uniName;
        }
        public String getUniCountry(){
            return uniCountry;
        }

        @Override
        //toString
        public String toString(){
            return this.uniName;
        }
    }


