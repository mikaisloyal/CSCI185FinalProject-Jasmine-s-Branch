public class ConnectionEngine {
    // This is not supposed to work out of the box.
    // ConnectionEngine will REQUIRE Student.java and similar resources to initialize
    // its main function. Some variables may be misnamed.
    // The main reason everything has been provided before its established variables
    // is to save time for the project.

    /*
    Establishing some potential functions that may be reflected in the 'Student' class.
    These are hypothetical, and come from the Final Project Plan:
    getUniversity(), getMajor(), getInterests()
    getNationality() <- From 'Person' class
     */

    /*
    Integrating Jasmine's Connection Strength Table (and making some slight changes)
    Points are given if a similarity is found between them. Ranges from 0-100.
    First Name - 5
    Last Name - 10
    Age - 5
    Nationality - 15
    University Name - 20
    University Location - 10
    Major - 20
    Interests - 5 per (limited to 10 at a time)
    Classes - 5 per (limited to 5 at a time)
     */

    public static int ConnectionStrength(Student studentA, Student studentB){
        // INCOMPLETE ! ! !


        // initializes strength as an initial value of 0
        int strength = 0;

        if(studentA.getUniversity().equals(studentB.getUniversity())){
            strength += 50;
        }

        if(studentA.getMajor().equals(studentB.getMajor())){
            strength += 20;
        }

        if(personA.getNationality().equals(personB.getNationality())){
            strength += 20;
        }


        return

    }


}
